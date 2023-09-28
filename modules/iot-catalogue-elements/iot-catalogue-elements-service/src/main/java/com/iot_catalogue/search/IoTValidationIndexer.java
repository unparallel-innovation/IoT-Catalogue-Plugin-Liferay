package com.iot_catalogue.search;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.search.Field;
import com.iot_catalogue.exception.NoSuchIoTComponentException;
import com.iot_catalogue.exception.NoSuchIoTValidationException;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.service.IoTValidationLocalService;
import com.iot_catalogue.service.permission.IoTValidationPermission;
import com.iot_catalogue.utils.StringUtils;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(
	    immediate = true,
	    service = Indexer.class
	)
	public class IoTValidationIndexer extends BaseIndexer<IoTValidation> {

	    public static final String CLASS_NAME = IoTValidation.class.getName();
	    public IoTValidationIndexer() {
	        setDefaultSelectedFieldNames(
	            Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT,
	            Field.ENTRY_CLASS_NAME, Field.ENTRY_CLASS_PK, Field.GROUP_ID,
	            Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE, Field.UID);
	        setPermissionAware(true);
	        setFilterSearch(true);
	    }
	    
	    @Override
	    public String getClassName() {
	        return CLASS_NAME;
	    }
	    
	    @Override
	    public boolean hasPermission(
	            PermissionChecker permissionChecker, String entryClassName, 
	            long entryClassPK, String actionId) 
	        throws Exception {
	        return IoTValidationPermission.contains(
	            permissionChecker, entryClassPK, ActionKeys.VIEW);
	    }
	    
	    @Override
	    public void postProcessContextBooleanFilter(
	            BooleanFilter contextBooleanFilter, SearchContext searchContext)
	    throws Exception {
	        addStatus(contextBooleanFilter, searchContext);
	    }
	    
	    @Override
	    public void postProcessSearchQuery(
	        BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
	        SearchContext searchContext)
	        throws Exception {
	    
	        addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);
	    }
	    
	    @Override
	    protected void doDelete(IoTValidation iotValidation) throws Exception {
	        deleteDocument(iotValidation.getCompanyId(), iotValidation.getIotValidationId());
	    }
	    
	    @Override
	    protected Document doGetDocument(IoTValidation iotValidation)
	        throws Exception {

	        Document document = getBaseModelDocument(CLASS_NAME, iotValidation);

	        document.addDate(Field.MODIFIED_DATE, iotValidation.getModifiedDate());

	        Locale defaultLocale =
	            PortalUtil.getSiteDefaultLocale(iotValidation.getGroupId());

	        document.addText(Field.TITLE, iotValidation.getName());
	        document.addText(Field.CONTENT, StringUtils.StripHTML( iotValidation.getDescription()));
	        return document;
	    }
	    
	    
	    @Override
	    protected Summary doGetSummary(
	        Document document, Locale locale, String snippet,
	        PortletRequest portletRequest, PortletResponse portletResponse) {

	        Summary summary = createSummary(document);
	        summary.setMaxContentLength(1000);
	        return summary;
	    }
	    
	    @Override
	    protected void doReindex(IoTValidation iotValidation)
	        throws Exception {

	        Document document = getDocument(iotValidation);
	        indexWriterHelper.updateDocument(
	            getSearchEngineId(), iotValidation.getCompanyId(), document,
	            isCommitImmediately());
	    }
	    
	    @Override
	    protected void doReindex(String className, long classPK)
	        {

	        IoTValidation iotValidation;
			try {
				iotValidation = _iotValidationLocalService.getIoTValidation(classPK);
				doReindex(iotValidation);
				
			}catch(NoSuchIoTValidationException ex) {
				_log.warn("IoT Validation with id:" + classPK + " does not exists" );
			}
			catch (Exception e) {
				e.printStackTrace();
				// TODO Auto-generated catch block
				
					
			}
	        
	    }
	    
	    @Override
	    protected void doReindex(String[] ids)
	        throws Exception {

	        long companyId = GetterUtil.getLong(ids[0]);
	        reindexIoTValidations(companyId);
	    }
	    
	    protected void reindexIoTValidations(long companyId)
	    		  throws PortalException {

	    		  final IndexableActionableDynamicQuery indexableActionableDynamicQuery =
	    				  _iotValidationLocalService.getIndexableActionableDynamicQuery();

	    		  indexableActionableDynamicQuery.setCompanyId(companyId);

	    		  indexableActionableDynamicQuery.setPerformActionMethod(

	    		    new ActionableDynamicQuery.PerformActionMethod<IoTValidation>() {
	    		      @Override
	    		      public void performAction(IoTValidation iotValidation) {
	    		        try {
	    		          Document document = getDocument(iotValidation);
	    		          indexableActionableDynamicQuery.addDocuments(document);
	    		        }
	    		        catch (PortalException pe) {
	    		          if (_log.isWarnEnabled()) {
	    		            _log.warn(
	    		              "Unable to index iot validation " +
	    		            		  iotValidation.getIotValidationId(),
	    		              pe);
	    		          }
	    		        }
	    		      }
	    		    });
	    		  indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
	    		  indexableActionableDynamicQuery.performActions();
	    		}
	    
	    private static final Log _log =
		  LogFactoryUtil.getLog(IoTValidationIndexer.class);

		@Reference
		protected IndexWriterHelper indexWriterHelper;

		@Reference
		private IoTValidationLocalService _iotValidationLocalService;
	}