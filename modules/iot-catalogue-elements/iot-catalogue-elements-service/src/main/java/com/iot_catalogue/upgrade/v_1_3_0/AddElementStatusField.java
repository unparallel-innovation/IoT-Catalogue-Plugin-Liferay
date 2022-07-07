package com.iot_catalogue.upgrade.v_1_3_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class AddElementStatusField extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		// TODO Auto-generated method stub
		runSQL("ALTER TABLE IoTCatalogue_IoTValidation ADD elementStatus varchar(255);\n"
				+ "ALTER TABLE IoTCatalogue_IoTComponent ADD elementStatus varchar(255);");
	}

}
