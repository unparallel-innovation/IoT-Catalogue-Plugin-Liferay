package com.iot_catalogue.upgrade.v_1_2_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

public class ValidationChildUpgrade extends UpgradeProcess{

	@Override
	protected void doUpgrade() throws Exception {
		// TODO Auto-generated method stub
		runSQL("create table IoTCatalogue_ValidationChild (\n"
				+ "	uuid_ VARCHAR(75) null,\n"
				+ "	id_ LONG not null primary key,\n"
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
				+ "	validationOrignalId VARCHAR(75) null,\n"
				+ "	childValidationOriginalId VARCHAR(75) null,\n"
				+ "	subscriptionId LONG\n"
				+ ");");
	}

}
