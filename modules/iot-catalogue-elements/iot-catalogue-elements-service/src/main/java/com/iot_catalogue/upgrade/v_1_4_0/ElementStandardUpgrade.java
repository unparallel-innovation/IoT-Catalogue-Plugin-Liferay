package com.iot_catalogue.upgrade.v_1_4_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class ElementStandardUpgrade extends UpgradeProcess {
	protected void doUpgrade() throws Exception {
		runSQL("create table IoTCatalogue_ElementStandard (\n"
				+ "	uuid_ VARCHAR(75) null,\n"
				+ "	elementStandardId LONG not null primary key,\n"
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
				+ "	name VARCHAR(75) null,\n"
				+ "	subscriptionId LONG\n"
				+ ");");
		
	}
}