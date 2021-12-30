package com.iot_catalogue.portlet.upgrade;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;


@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class PortletModuleUpgrade implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		System.out.println("Registering");
		registry.register("1.0.0", "1.1.0", new DummyUpgradeStep());
	}

}
