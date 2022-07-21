package com.iot_catalogue.upgrade.v_1_3_0;

import com.iot_catalogue.upgrade.v_1_3_0.tables.ComponentTable;
import com.iot_catalogue.upgrade.v_1_3_0.tables.ValidationTable;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class AddElementStatusField extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		// TODO Auto-generated method stub

		
		alter(
				ComponentTable.class,
				new AlterTableAddColumn("elementStatus", "varchar(255)")
				
				);
		alter(
				ValidationTable.class,
				new AlterTableAddColumn("elementStatus", "varchar(255)")
				
				);
	}

}
