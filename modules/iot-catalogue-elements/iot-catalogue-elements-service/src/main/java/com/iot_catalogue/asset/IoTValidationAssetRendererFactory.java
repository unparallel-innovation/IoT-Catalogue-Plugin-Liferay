package com.iot_catalogue.asset;




import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.service.IoTValidationLocalService;
import com.iot_catalogue.service.permission.IoTValidationPermission;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true, property = {"javax.portlet.name=" +ElementListPortletKeys.ELEMENT_LIST}, service = AssetRendererFactory.class)
public class IoTValidationAssetRendererFactory extends BaseAssetRendererFactory<IoTValidation> {
	  public IoTValidationAssetRendererFactory() {
		  
		    setClassName(CLASS_NAME);
		    setLinkable(_LINKABLE);
		    setPortletId(ElementListPortletKeys.ELEMENT_LIST);
		    setSearchable(true);
		    setSelectable(true);
		  }
	  @Override
	  public AssetRenderer<IoTValidation> getAssetRenderer(long classPK, int type) 
	  throws PortalException {
		  IoTValidation iotValidation = _iotValidationLocalService.getIoTValidation(classPK);

	    IoTValidationAssetRenderer iotValidationAssetRenderer = 
	    new IoTValidationAssetRenderer(iotValidation);

	    iotValidationAssetRenderer.setAssetRendererType(type);
	    iotValidationAssetRenderer.setServletContext(_servletContext);

	    return iotValidationAssetRenderer;
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
      @Override
      public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest,
          LiferayPortletResponse liferayPortletResponse, long classTypeId) {

        PortletURL portletURL = null;

        try {
          ThemeDisplay themeDisplay = (ThemeDisplay) 
          liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

          portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay),
        		  ElementListPortletKeys.ELEMENT_LIST, PortletRequest.RENDER_PHASE);
          portletURL.setParameter("mvcRenderCommandName", "/guestbookwebportlet/edit_guestbook");
          portletURL.setParameter("showback", Boolean.FALSE.toString());
        } catch (PortalException e) {
        }

        return portletURL;
      }
	  */
	  @Override
	  public boolean hasPermission(PermissionChecker permissionChecker, 
	  long classPK, String actionId) throws Exception {
		    IoTValidation iotValidation = _iotValidationLocalService.getIoTValidation(classPK);
		    return IoTValidationPermission.contains(permissionChecker, iotValidation, 
		    actionId);
		  
	  }
	  
      @Override
      public boolean isLinkable() {
        return _LINKABLE;
      }

      @Override
      public String getIconCssClass() {
          return "bookmarks";
      }

	  
      @Reference(target = "(osgi.web.symbolicname=com.iot_catalogue.portlet)",
              unbind = "-")
      public void setServletContext(ServletContext servletContext) {
              _servletContext = servletContext;
          }
          private ServletContext _servletContext;

      @Reference(unbind = "-")
          protected void setIoTValidationLocalService(IoTValidationLocalService iotValidationLocalService) {
    	  _iotValidationLocalService = iotValidationLocalService; 
      }

      
    private IoTValidationLocalService _iotValidationLocalService;
    private static final boolean _LINKABLE = true;
    public static final String CLASS_NAME = IoTValidation.class.getName();
    public static final String TYPE = "iot_validation";
}
