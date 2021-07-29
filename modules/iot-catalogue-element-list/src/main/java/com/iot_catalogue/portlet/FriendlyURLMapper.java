package com.iot_catalogue.portlet;

import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import org.osgi.service.component.annotations.Component;

@Component(
	    property = {
	        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	        "javax.portlet.name=" + ElementListPortletKeys.ELEMENT_LIST
	    },
	    service = FriendlyURLMapper.class
	)
public class FriendlyURLMapper extends DefaultFriendlyURLMapper {
	@Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "components";
}
