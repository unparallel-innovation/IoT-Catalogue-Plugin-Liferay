package com.iot_catalogue.asset;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot_catalogue.model.ElementCoordinate;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.model.Subscription;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.service.ElementCoordinateLocalServiceUtil;
import com.iot_catalogue.service.SubscriptionLocalServiceUtil;
import com.iot_catalogue.service.permission.IoTValidationPermission;
import com.iot_catalogue.utils.CategoryUtil;
import com.iot_catalogue.utils.StringUtils;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.asset.kernel.model.DDMFormValuesReader;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;

public class IoTValidationAssetRenderer extends BaseJSPAssetRenderer<IoTValidation> {

	public IoTValidationAssetRenderer(IoTValidation iotValidation) {
		_iotValidation = iotValidation;
	}

	private IoTValidation _iotValidation;

	@Override
	public int getStatus() {

		return super.getStatus();
	}
	
	
	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) throws PortalException {

		return false;
	}

	@Override
	public DDMFormValuesReader getDDMFormValuesReader() {
		List<ElementCoordinate> elementCoordinates = 
			ElementCoordinateLocalServiceUtil.getElementCoordinates(
					_iotValidation.getSubscriptionId(),
					_iotValidation.getOriginalId(),
					IoTValidation.class.getName()
					);
		return new GeoLocationDDMFormValueReader(elementCoordinates);
	}
	
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) throws PortalException {

		long iotValidationId = _iotValidation.getIotValidationId();
		return IoTValidationPermission.contains(permissionChecker, iotValidationId, ActionKeys.VIEW);
	}

	
	@Override
	public String getURLImagePreview(PortletRequest portletRequest) throws Exception {
		// TODO Auto-generated method stub
		return _iotValidation.getImageUrl();
	}
	
	
	@Override
	public IoTValidation getAssetObject() {
		return _iotValidation;
	}
	
	

	@Override
	public long getGroupId() {
		
		long groupId = _iotValidation.getGroupId();
		return groupId;
	}

	@Override
	public long getUserId() {

		return _iotValidation.getUserId();
	}

	@Override
	public String getUserName() {
		return _iotValidation.getUserName();
	}

	@Override
	public String getUuid() {
		return _iotValidation.getUuid();
	}

	@Override
	public String getClassName() {
		return IoTValidation.class.getName();
	}

	@Override
	public long getClassPK() {
		return _iotValidation.getIotValidationId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return  StringUtils.StripHTML(_iotValidation.getDescription());
	}
	
	@Override
	public String getSearchSummary(Locale locale) {
		return  StringUtils.StripHTML(_iotValidation.getDescription());
	}
	
	@Override
	public String getTitle(Locale locale) {
		return _iotValidation.getName();
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		request.setAttribute("IOTVALIDATION", _iotValidation);
		request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
		request.setAttribute("StringUtil", new StringUtil());
		return super.include(request, response, template);
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {

		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			try {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(IoTValidation.class.getName(),_iotValidation.getPrimaryKey());
				HashMap<String, List<HashMap<String,String>>> vocabulariesCategories = CategoryUtil.getVocabulariesCategories(assetEntry);
				request.setAttribute("vocabularies_categories", vocabulariesCategories);
				request.setAttribute("asset_entry", assetEntry);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("iot_validation", _iotValidation);

			return "/asset/iotvalidation/" + template + ".jsp";
		} else {
			return null;
		}

	}

	/*
	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
		try {
			long plid = PortalUtil.getPlidFromPortletId(_iotValidation.getGroupId(),
					ElementListPortletKeys.ELEMENT_LIST);

			PortletURL portletURL;
			if (plid == LayoutConstants.DEFAULT_PLID) {
				portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
						ElementListPortletKeys.ELEMENT_LIST, PortletRequest.RENDER_PHASE);
			} else {
				portletURL = PortletURLFactoryUtil.create(liferayPortletRequest, ElementListPortletKeys.ELEMENT_LIST,
						plid, PortletRequest.RENDER_PHASE);
			}

			portletURL.setParameter("mvcRenderCommandName", "/elementswebportlet/view.jsp");
			portletURL.setParameter("iotValidationId", String.valueOf(_iotValidation.getIotValidationId()));

			String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);

			portletURL.setParameter("redirect", currentUrl);

			return portletURL.toString();

		} catch (PortalException e) {

		} catch (SystemException e) {
		}

		return noSuchEntryRedirect;
	}
*/
	
	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) { // IOT_COMPONENT_FULL_CONTENT
																							// try {
		
		try {
			String originalId = _iotValidation.getOriginalId();
			Subscription subscription = SubscriptionLocalServiceUtil.getSubscriptionById(_iotValidation.getSubscriptionId());
			if(subscription!=null) {
				return subscription.getValidationPagePath() + "?pageId=" + originalId;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return null;



	}
	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) throws Exception {
		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(
				getControlPanelPlid(liferayPortletRequest), ElementListPortletKeys.ELEMENT_LIST,
				PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcRenderCommandName", "/guestbookwebportlet/edit_entry");
		portletURL.setParameter("entryId", String.valueOf(_iotValidation.getIotValidationId()));
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}

	@Override
	public boolean isPrintable() {
		return true;
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {

		return super.getURLView(liferayPortletResponse, windowState);
	}
}
