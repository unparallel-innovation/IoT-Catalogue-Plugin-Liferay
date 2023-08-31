package com.iot_catalogue.upgrade.v_1_4_0;

import com.iot_catalogue.model.impl.ElementStandardModelImpl;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class ElementStandardUpgrade extends UpgradeProcess {
	protected void doUpgrade() throws Exception {
		runSQL(ElementStandardModelImpl.TABLE_SQL_CREATE);
		
	}
}
