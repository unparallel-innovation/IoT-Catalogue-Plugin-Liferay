package com.iot_catalogue.upgrade.v_1_4_0;

import com.iot_catalogue.upgrade.v_1_4_0.tables.ComponentTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class AddIoTComponentFields extends UpgradeProcess{
	@Override
	protected void doUpgrade() throws Exception {
		alter(
				ComponentTable.class,
				new AlterTableAddColumn("license", "varchar(75)")
				
				);
		alter(
				ComponentTable.class,
				new AlterTableAddColumn("trl", "varchar(75)")
				
				);	
	}
}
