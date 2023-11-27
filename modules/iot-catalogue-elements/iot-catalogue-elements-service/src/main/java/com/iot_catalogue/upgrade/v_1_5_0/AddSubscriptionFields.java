package com.iot_catalogue.upgrade.v_1_5_0;

import com.iot_catalogue.upgrade.v_1_5_0.tables.SubscriptionTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.upgrade.UpgradeProcess.AlterTableAddColumn;


public class AddSubscriptionFields extends UpgradeProcess{
	@Override
	protected void doUpgrade() throws Exception {
		alter(
				SubscriptionTable.class,
				new AlterTableAddColumn("manufacturerLabel", "varchar(75)")
				
				);
		alter(
				SubscriptionTable.class,
				new AlterTableAddColumn("developerLabel", "varchar(75)")
				
				);	
	}
}
