package com.iot_catalogue.upgrade;

import org.osgi.service.component.annotations.Component;

import com.iot_catalogue.upgrade.v_1_1_0.ElementCoordinateUpgrade;
import com.iot_catalogue.upgrade.v_1_2_0.ComponentChildUpgrade;
import com.iot_catalogue.upgrade.v_1_2_0.ValidationChildUpgrade;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

@Component(
		enabled = true, immediate = true, service = UpgradeStepRegistrator.class
	)
public class Upgrade implements UpgradeStepRegistrator{

	@Override
	public void register(Registry registry) {
		// TODO Auto-generated method stub

		_log.info("Service upgrade step registrator started");
		registry.register("1.0.0", "1.1.0", new ElementCoordinateUpgrade());
		registry.register("1.1.0", "1.2.0", new ComponentChildUpgrade(), new ValidationChildUpgrade());

	}
	private static final Log _log = LogFactoryUtil.getLog(
			Upgrade.class);
}
