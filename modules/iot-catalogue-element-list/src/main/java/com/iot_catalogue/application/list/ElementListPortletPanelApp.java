package com.iot_catalogue.application.list;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;

@Component(
	    immediate = true,
	    property = {
	        "panel.app.order:Integer=300",
	        "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
	    },
	    service = PanelApp.class
	)
public class ElementListPortletPanelApp extends BasePanelApp {

    @Override
    public String getPortletId() {
        return ElementListPortletKeys.ELEMENT_LIST_ADMIN;
    }
    
    @Override
    @Reference(
        target = "(javax.portlet.name=" + ElementListPortletKeys.ELEMENT_LIST_ADMIN + ")",
        unbind = "-"
    )
    public void setPortlet(Portlet portlet) {
        super.setPortlet(portlet);
    }
}
