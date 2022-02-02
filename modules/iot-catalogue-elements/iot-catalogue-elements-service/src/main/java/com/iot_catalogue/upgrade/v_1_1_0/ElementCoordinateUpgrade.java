package com.iot_catalogue.upgrade.v_1_1_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class ElementCoordinateUpgrade extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		// TODO Auto-generated method stub

		runSQL("create table IoTCatalogue_ElementCoordinate (\n"
				+ "	uuid_ VARCHAR(75) null,\n"
				+ "	elementCoordinateId LONG not null primary key,\n"
				+ "	groupId LONG,\n"
				+ "	companyId LONG,\n"
				+ "	userId LONG,\n"
				+ "	userName VARCHAR(75) null,\n"
				+ "	createDate DATE null,\n"
				+ "	modifiedDate DATE null,\n"
				+ "	status INTEGER,\n"
				+ "	statusByUserId LONG,\n"
				+ "	statusByUserName VARCHAR(75) null,\n"
				+ "	statusDate DATE null,\n"
				+ "	elementOriginalId VARCHAR(75) null,\n"
				+ "	elementClassName VARCHAR(75) null,\n"
				+ "	latitude DOUBLE,\n"
				+ "	longitude DOUBLE,\n"
				+ "	subscriptionId LONG\n"
				+ ");\n"
				+ "");
	}

}
