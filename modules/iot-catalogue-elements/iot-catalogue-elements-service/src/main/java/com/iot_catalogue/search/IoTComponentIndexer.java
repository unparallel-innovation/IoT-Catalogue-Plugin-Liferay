package com.iot_catalogue.search;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.search.Field;
import com.iot_catalogue.exception.NoSuchIoTComponentException;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.iot_catalogue.service.permission.IoTComponentPermission;
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
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(immediate = true, service = Indexer.class)
public class IoTComponentIndexer extends BaseIndexer<IoTComponent> {

	public static final String CLASS_NAME = IoTComponent.class.getName();

	public IoTComponentIndexer() {
		setDefaultSelectedFieldNames(Field.ASSET_TAG_NAMES, Field.COMPANY_ID, Field.CONTENT, Field.ENTRY_CLASS_NAME,
				Field.ENTRY_CLASS_PK, Field.GROUP_ID, Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID, Field.TITLE,
				Field.UID);
		setPermissionAware(true);
		setFilterSearch(true);
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, String entryClassName, long entryClassPK,
			String actionId) {
		boolean permission = IoTComponentPermission.contains(permissionChecker, entryClassPK, ActionKeys.VIEW);
		return permission;
	}

	@Override
	public void postProcessContextBooleanFilter(BooleanFilter contextBooleanFilter, SearchContext searchContext)
			throws Exception {

		addStatus(contextBooleanFilter, searchContext);

	}

	@Override
	public void postProcessSearchQuery(BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter,
			SearchContext searchContext) throws Exception {

		addSearchLocalizedTerm(searchQuery, searchContext, Field.TITLE, false);

	}

	@Override
	protected void doDelete(IoTComponent iotComponent) throws Exception {

		deleteDocument(iotComponent.getCompanyId(), iotComponent.getIotComponentId());

	}

	@Override
	protected Document doGetDocument(IoTComponent iotComponent) {
		Document document = getBaseModelDocument(CLASS_NAME, iotComponent);
	
		document.addDate(Field.MODIFIED_DATE, iotComponent.getModifiedDate());

		document.addText(Field.TITLE, iotComponent.getName());
		document.addText(Field.CONTENT, StringUtils.StripHTML( iotComponent.getDescription()));
	
		return document;
	}

	@Override
	protected Summary doGetSummary(Document document, Locale locale, String snippet, PortletRequest portletRequest,
			PortletResponse portletResponse) {

		Summary summary = createSummary(document);
		summary.setMaxContentLength(1000);

		return summary;
	}

	@Override
	protected void doReindex(IoTComponent iotComponent) throws SearchException {

	
		Document document = getDocument(iotComponent);
			indexWriterHelper.updateDocument(getSearchEngineId(), iotComponent.getCompanyId(), document,
					isCommitImmediately());
	

	}

	@Override
	protected void doReindex(String className, long classPK) {

		IoTComponent iotComponent;
		try {
			iotComponent = _iotComponentLocalService.getIoTComponent(classPK);
			doReindex(iotComponent);
		} catch (NoSuchIoTComponentException ex) {
			_log.warn("IoT Component with id:" + classPK + " does not exists");
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doReindex(String[] ids) {

		long companyId = GetterUtil.getLong(ids[0]);
		try {
			reindexIoTComponents(companyId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void reindexIoTComponents(long companyId) {

		final IndexableActionableDynamicQuery indexableActionableDynamicQuery = _iotComponentLocalService
				.getIndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setCompanyId(companyId);

		indexableActionableDynamicQuery.setPerformActionMethod(

				new ActionableDynamicQuery.PerformActionMethod<IoTComponent>() {
					@Override
					public void performAction(IoTComponent iotComponent) {
						try {
							Document document = getDocument(iotComponent);
							indexableActionableDynamicQuery.addDocuments(document);
						} catch (PortalException pe) {
							if (_log.isWarnEnabled()) {
								_log.warn("Unable to index iot component " + iotComponent.getIotComponentId(), pe);
							}
						}
					}
				});
		indexableActionableDynamicQuery.setSearchEngineId(getSearchEngineId());
		try {
			indexableActionableDynamicQuery.performActions();
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(IoTComponentIndexer.class);

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	@Reference
	private IoTComponentLocalService _iotComponentLocalService;

}