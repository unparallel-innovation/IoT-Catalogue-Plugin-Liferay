package com.iot_catalogue.portlet;
import java.io.IOException;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.permission.ModelPermissions;
import com.liferay.portal.kernel.language.LanguageUtil;
/**
 * @author antoniogoncalves
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.cms",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=IoT Catalogue Elements",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/elementswebportlet/view.jsp",
		"javax.portlet.name=" + ElementListPortletKeys.ELEMENT_LIST,
		"mvc.command.name=/",
		"mvc.command.name=/components/view",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user,guest"
	},
	service = Portlet.class
)
public class ElementListPortlet extends MVCPortlet {
	
	
	@Override
	public void init() throws PortletException {
		super.init();
	}





	

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {

	        try {
	        
	
	        }
	        catch (Exception e) {
	            throw new PortletException(e);
	        }

	        super.render(renderRequest, renderResponse);
	}
	
	@Reference(unbind = "-")
	protected void setIoTComponentLocalService(IoTComponentLocalService ioTComponentLocalService) {
		_ioTComponentLocalService = ioTComponentLocalService;
	}

	private IoTComponentLocalService _ioTComponentLocalService;
	private static final Log _log = LogFactoryUtil.getLog(ElementListAdminPortlet.class);

}








