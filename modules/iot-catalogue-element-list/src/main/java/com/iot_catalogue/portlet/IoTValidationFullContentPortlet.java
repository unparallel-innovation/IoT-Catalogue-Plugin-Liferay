package com.iot_catalogue.portlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot_catalogue.exception.NoSuchIoTValidationException;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.service.IoTValidationLocalService;
import com.iot_catalogue.service.permission.IoTValidationPermission;
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

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.cms",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=IoT Catalogue Validation", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/asset/iotvalidation/full_content.jsp",
		"javax.portlet.name=" + ElementListPortletKeys.IOT_VALIDATION_FULL_CONTENT,

		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class IoTValidationFullContentPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		String originalIoTValidationId = httpReq.getParameter("pageId");

		if(originalIoTValidationId!=null) {
			try {
				IoTValidation iotValidation;
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
				iotValidation = _iotValidationLocalService.getIoTValidationByOriginalId(originalIoTValidationId);

				long iotValidationId = iotValidation.getIotValidationId();
				try {
					if(IoTValidationPermission.contains(permissionChecker, iotValidationId, ActionKeys.VIEW)) {
						renderRequest.setAttribute("iot_validation", iotValidation);
						try {
							AssetEntry assetEntry = _assetEntryLocalService.getEntry(IoTValidation.class.getName(),iotValidation.getPrimaryKey());
							HashMap<String, List<HashMap<String,String>>> vocabulariesCategories = CategoryUtil.getVocabulariesCategories(assetEntry);
							renderRequest.setAttribute("vocabularies_categories", vocabulariesCategories);
							renderRequest.setAttribute("asset_entry", assetEntry);
							ObjectMapper mapper = new ObjectMapper();
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
				} catch (Exception e) {
					// TODO Auto-generated catch block
					renderRequest.setAttribute("not_authorized", true);
					e.printStackTrace();
				}

			} catch (NoSuchIoTValidationException e) {
				// TODO Auto-generated catch block
				renderRequest.setAttribute("not_found", true);

			}
		}


		super.render(renderRequest, renderResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(IoTComponentFullContentPortlet.class);

	@Reference(unbind = "-")
	protected void setIoTValidationLocalService(IoTValidationLocalService iotValidationLocalService) {
		_iotValidationLocalService = iotValidationLocalService;
	}

	private IoTValidationLocalService _iotValidationLocalService;

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}


	private AssetEntryLocalService _assetEntryLocalService = null;
}
