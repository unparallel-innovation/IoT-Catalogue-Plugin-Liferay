package com.iot_catalogue.portlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot_catalogue.exception.NoSuchIoTComponentException;
import com.iot_catalogue.model.ElementEntity;
import com.iot_catalogue.model.ElementStandard;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.service.ElementEntityLocalService;
import com.iot_catalogue.service.ElementStandardLocalService;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.iot_catalogue.service.permission.IoTComponentPermission;
import com.iot_catalogue.utils.CategoryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;


@Component(
		immediate = true,
		property = {
			"com.liferay.portlet.display-category=category.cms",
			"com.liferay.portlet.header-portlet-css=/css/main.css",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=IoT Catalogue Component",
			"javax.portlet.init-param.template-path=/",
			"javax.portlet.init-param.view-template=/asset/iotcomponent/full_content.jsp",
			"javax.portlet.name=" + ElementListPortletKeys.IOT_COMPONENT_FULL_CONTENT,

			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
	)





public class IoTComponentFullContentPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {

			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			String originalComponentId = httpReq.getParameter("pageId");
			if(originalComponentId != null) {
				try {
					IoTComponent iotComponent = _ioTComponentLocalService.getIoTComponentByOriginalId(originalComponentId);
					ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
					PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
					long iotComponentId = iotComponent.getIotComponentId();
					if(IoTComponentPermission.contains(permissionChecker, iotComponentId, ActionKeys.VIEW)) {
						renderRequest.setAttribute("iot_component", iotComponent);
						try {
							AssetEntry assetEntry = _assetEntryLocalService.getEntry(IoTComponent.class.getName(),iotComponent.getPrimaryKey());
							HashMap<String, List<HashMap<String,String>>> vocabulariesCategories = CategoryUtil.getVocabulariesCategories(assetEntry);
						
							
							List<ElementEntity> developers = _elementEntityLocalService.getElementEntities(iotComponent.getOriginalId(), IoTComponent.class.getName(), "Developer");
							List<ElementEntity> manufacturers = _elementEntityLocalService.getElementEntities(iotComponent.getOriginalId(), IoTComponent.class.getName(), "Manufacturer");
							List<ElementStandard> standards = _elementStandardLocalService.getElementStandards(iotComponent.getOriginalId(), IoTComponent.class.getName());
							renderRequest.setAttribute("vocabularies_categories", vocabulariesCategories);
							renderRequest.setAttribute("asset_entry", assetEntry);
							renderRequest.setAttribute("developers", developers);
							renderRequest.setAttribute("manufacturers", manufacturers);
							renderRequest.setAttribute("standards", standards);
							var mapper = new ObjectMapper();
							try {
								String vocabulariesCategoriesJSON = mapper.writeValueAsString(vocabulariesCategories);
								renderRequest.setAttribute("vocabulariesCategoriesJSON", vocabulariesCategoriesJSON);
					
								
							}catch(Exception e) {
								
							}
							
							
						}catch(Exception e) {
							e.printStackTrace();
						}

					}else {
						renderRequest.setAttribute("not_authorized", true);
					}

				} catch (NoSuchIoTComponentException e) {
					renderRequest.setAttribute("not_found", true);
					// TODO Auto-generated catch block

				}
			}


	        super.render(renderRequest, renderResponse);
	}
	private static final Log _log = LogFactoryUtil.getLog(IoTComponentFullContentPortlet.class);
	
	@Reference(unbind = "-")
	private void setElementEntityLocalService(ElementEntityLocalService elementEntityLocalService) {
		_elementEntityLocalService = elementEntityLocalService;
	}
	
	private ElementEntityLocalService _elementEntityLocalService;
	
	
	@Reference(unbind = "-")
	private void setElementStandardLocalService(ElementStandardLocalService elementStandardLocalService) {
		_elementStandardLocalService = elementStandardLocalService;
	}
	
	private ElementStandardLocalService _elementStandardLocalService;
	
	@Reference(unbind = "-")
	protected void setIoTComponentLocalService(IoTComponentLocalService ioTComponentLocalService) {
		_ioTComponentLocalService = ioTComponentLocalService;
	}

	private IoTComponentLocalService _ioTComponentLocalService;

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}


	private AssetEntryLocalService _assetEntryLocalService = null;


}
