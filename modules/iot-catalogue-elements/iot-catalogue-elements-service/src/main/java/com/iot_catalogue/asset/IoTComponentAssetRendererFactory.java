package com.iot_catalogue.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;

import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.iot_catalogue.service.permission.IoTComponentPermission;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = {
		"javax.portlet.name=" + ElementListPortletKeys.ELEMENT_LIST }, service = AssetRendererFactory.class)
public class IoTComponentAssetRendererFactory extends BaseAssetRendererFactory<IoTComponent> {
	public IoTComponentAssetRendererFactory() {

		setClassName(CLASS_NAME);
		setLinkable(_LINKABLE);
		setPortletId(ElementListPortletKeys.ELEMENT_LIST);
		setSearchable(true);
		setSelectable(true);
	}

	@Override
	public AssetRenderer<IoTComponent> getAssetRenderer(long classPK, int type) {
		IoTComponent iotComponent = null;
		try {
			iotComponent = _iotComponentLocalService.getIoTComponent(classPK);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IoTComponentAssetRenderer iotComponentAssetRenderer = new IoTComponentAssetRenderer(iotComponent);

		iotComponentAssetRenderer.setAssetRendererType(type);
		iotComponentAssetRenderer.setServletContext(_servletContext);

		return iotComponentAssetRenderer;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	/*
	 * @Override public PortletURL getURLAdd(LiferayPortletRequest
	 * liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, long
	 * classTypeId) {
	 * 
	 * PortletURL portletURL = null;
	 * 
	 * try { ThemeDisplay themeDisplay = (ThemeDisplay)
	 * liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
	 * 
	 * portletURL =
	 * liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(
	 * themeDisplay), ElementListPortletKeys.ELEMENT_LIST,
	 * PortletRequest.RENDER_PHASE); portletURL.setParameter("mvcRenderCommandName",
	 * "/guestbookwebportlet/edit_guestbook"); portletURL.setParameter("showback",
	 * Boolean.FALSE.toString()); } catch (PortalException e) { }
	 * 
	 * return portletURL; }
	 */
	@Override
	public boolean hasPermission(PermissionChecker permissionChecker, long classPK, String actionId)
			throws PortalException {

		IoTComponent iotComponent = _iotComponentLocalService.getIoTComponent(classPK);
		return IoTComponentPermission.contains(permissionChecker, iotComponent, actionId);

	}

	@Override
	public boolean isLinkable() {

		return _LINKABLE;
	}

	@Override
	public String getIconCssClass() {
		return "bookmarks";
	}

	@Reference(target = "(osgi.web.symbolicname=com.iot_catalogue.portlet)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private ServletContext _servletContext;

	@Reference(unbind = "-")
	protected void setIoTComponentLocalService(IoTComponentLocalService iotComponentLocalService) {
		_iotComponentLocalService = iotComponentLocalService;
	}

	private IoTComponentLocalService _iotComponentLocalService;
	private static final boolean _LINKABLE = true;
	public static final String CLASS_NAME = IoTComponent.class.getName();
	public static final String TYPE = "iot_component";
}
