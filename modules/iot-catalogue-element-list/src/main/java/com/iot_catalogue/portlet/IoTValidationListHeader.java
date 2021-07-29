package com.iot_catalogue.portlet;



import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.cms",
		"com.liferay.portlet.header-portlet-css=/asset/iotvalidation/list_header.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=IoT Validation List Header", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/asset/iotvalidation/list_header.jsp",
		"javax.portlet.name=" + ElementListPortletKeys.IOT_VALIDATION_LIST_HEADER,

		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class IoTValidationListHeader extends MVCPortlet {

	private final static String title = "Validations";
	private final static String description = "List of all validations available for your user, selecting one will allow you to see more information including, the places, solutions, problems and components related with this validation.";

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		if (httpReq.getPathInfo().contains("-/asset_publisher/")) {
			renderRequest.setAttribute("showing_asset", true);

		} else {
			renderRequest.setAttribute("showing_asset", false);
			renderRequest.setAttribute("title", title);
			renderRequest.setAttribute("description", description);
		}

		super.render(renderRequest, renderResponse);
	}

	private static final Log _log = LogFactoryUtil.getLog(IoTValidationListHeader.class);

}
