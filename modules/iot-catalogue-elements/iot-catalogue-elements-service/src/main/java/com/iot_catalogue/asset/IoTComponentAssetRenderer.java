package com.iot_catalogue.asset;

import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iot_catalogue.model.ElementCoordinate;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.model.Subscription;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.service.ElementCoordinateLocalServiceUtil;
import com.iot_catalogue.service.SubscriptionLocalServiceUtil;
import com.iot_catalogue.service.permission.IoTComponentPermission;
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

public class IoTComponentAssetRenderer extends BaseJSPAssetRenderer<IoTComponent> {

	public IoTComponentAssetRenderer(IoTComponent iotComponent) {
		_iotComponent = iotComponent;
	}


	
	private IoTComponent _iotComponent;

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {

		return false;
	}

	@Override
	public DDMFormValuesReader getDDMFormValuesReader() {

		List<ElementCoordinate> elementCoordinates =
				ElementCoordinateLocalServiceUtil.getElementCoordinates(
						_iotComponent.getSubscriptionId(),
						_iotComponent.getOriginalId(),
						IoTComponent.class.getName()
						);
		return new GeoLocationDDMFormValueReader(elementCoordinates);

	}
	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {

		long iotComponentId = _iotComponent.getIotComponentId();
		return IoTComponentPermission.contains(permissionChecker, iotComponentId, ActionKeys.VIEW);

	}

	@Override
	public IoTComponent getAssetObject() {
		return _iotComponent;
	}

	@Override
	public long getGroupId() {
		long groupId = _iotComponent.getGroupId();
		return groupId;
	}

	@Override
	public long getUserId() {
		return _iotComponent.getUserId();
	}

	@Override
	public String getUserName() {
		return _iotComponent.getUserName();
	}

	@Override
	public String getUuid() {
		return _iotComponent.getUuid();
	}

	@Override
	public String getClassName() {
		return IoTComponent.class.getName();
	}

	@Override
	public long getClassPK() {
		return _iotComponent.getIotComponentId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return _iotComponent.getDescription();
	}

	@Override
	public String getSearchSummary(Locale locale) {
		return _iotComponent.getDescription();
	}

	@Override
	public String getTitle(Locale locale) {

		return _iotComponent.getName();
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		request.setAttribute("IOTCATALOGUE", _iotComponent);
		request.setAttribute("HtmlUtil", HtmlUtil.getHtml());
		request.setAttribute("StringUtil", new StringUtil());
		return super.include(request, response, template);

	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {
		if (template.equals(TEMPLATE_FULL_CONTENT)) {


			try {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(IoTComponent.class.getName(),_iotComponent.getPrimaryKey());
				request.setAttribute("asset_entry", assetEntry);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			request.setAttribute("iot_component", _iotComponent);
			return "/asset/iotcomponent/" + template + ".jsp";
			
		} else {
			return null;
		}

	}
	/*
	 * @Override public String getURLViewInContext(LiferayPortletRequest
	 * liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, String
	 * noSuchEntryRedirect) throws Exception { try {
	 *
	 * long plid = PortalUtil.getPlidFromPortletId(_iotComponent.getGroupId(),
	 * ElementListPortletKeys.ELEMENT_LIST);
	 *
	 * PortletURL portletURL; if (plid == LayoutConstants.DEFAULT_PLID) { portletURL
	 * = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(
	 * liferayPortletRequest), ElementListPortletKeys.ELEMENT_LIST,
	 * PortletRequest.RENDER_PHASE); } else { portletURL =
	 * PortletURLFactoryUtil.create(liferayPortletRequest,
	 * ElementListPortletKeys.ELEMENT_LIST, plid, PortletRequest.RENDER_PHASE); }
	 *
	 * portletURL.setParameter("mvcRenderCommandName",
	 * "/elementswebportlet/view.jsp"); portletURL.setParameter("iotComponentId",
	 * String.valueOf(_iotComponent.getIotComponentId()));
	 * portletURL.setParameter("test", "test-str");
	 *
	 * String currentUrl = PortalUtil.getCurrentURL(liferayPortletRequest);
	 *
	 * portletURL.setParameter("redirect", currentUrl); String url =
	 * portletURL.toString(); return url;
	 *
	 * } catch (PortalException e) {
	 *
	 * } catch (SystemException e) { }
	 *
	 * return noSuchEntryRedirect; }
	 */

	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) { // IOT_COMPONENT_FULL_CONTENT
																							// try {

		try {
			String originalId = _iotComponent.getOriginalId();
			Subscription subscription = SubscriptionLocalServiceUtil.getSubscriptionById(_iotComponent.getSubscriptionId());
			if(subscription!=null) {
				return subscription.getComponentPagePath() + "?pageId=" + originalId;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;



	}

	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest,
			LiferayPortletResponse liferayPortletResponse) {
		PortletURL portletURL = null;
		try {
			portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest),
					ElementListPortletKeys.ELEMENT_LIST, PortletRequest.RENDER_PHASE);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		portletURL.setParameter("mvcRenderCommandName", "/guestbookwebportlet/edit_entry");
		portletURL.setParameter("entryId", String.valueOf(_iotComponent.getIotComponentId()));
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
