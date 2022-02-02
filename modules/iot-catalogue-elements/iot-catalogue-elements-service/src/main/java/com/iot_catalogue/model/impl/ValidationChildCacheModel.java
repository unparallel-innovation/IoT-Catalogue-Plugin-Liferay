/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.iot_catalogue.model.impl;

import com.iot_catalogue.model.ValidationChild;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ValidationChild in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ValidationChildCacheModel
	implements CacheModel<ValidationChild>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ValidationChildCacheModel)) {
			return false;
		}

		ValidationChildCacheModel validationChildCacheModel =
			(ValidationChildCacheModel)object;

		if (id == validationChildCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", validationOrignalId=");
		sb.append(validationOrignalId);
		sb.append(", childValidationOriginalId=");
		sb.append(childValidationOriginalId);
		sb.append(", subscriptionId=");
		sb.append(subscriptionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ValidationChild toEntityModel() {
		ValidationChildImpl validationChildImpl = new ValidationChildImpl();

		if (uuid == null) {
			validationChildImpl.setUuid("");
		}
		else {
			validationChildImpl.setUuid(uuid);
		}

		validationChildImpl.setId(id);
		validationChildImpl.setGroupId(groupId);
		validationChildImpl.setCompanyId(companyId);
		validationChildImpl.setUserId(userId);

		if (userName == null) {
			validationChildImpl.setUserName("");
		}
		else {
			validationChildImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			validationChildImpl.setCreateDate(null);
		}
		else {
			validationChildImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			validationChildImpl.setModifiedDate(null);
		}
		else {
			validationChildImpl.setModifiedDate(new Date(modifiedDate));
		}

		validationChildImpl.setStatus(status);
		validationChildImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			validationChildImpl.setStatusByUserName("");
		}
		else {
			validationChildImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			validationChildImpl.setStatusDate(null);
		}
		else {
			validationChildImpl.setStatusDate(new Date(statusDate));
		}

		if (validationOrignalId == null) {
			validationChildImpl.setValidationOrignalId("");
		}
		else {
			validationChildImpl.setValidationOrignalId(validationOrignalId);
		}

		if (childValidationOriginalId == null) {
			validationChildImpl.setChildValidationOriginalId("");
		}
		else {
			validationChildImpl.setChildValidationOriginalId(
				childValidationOriginalId);
		}

		validationChildImpl.setSubscriptionId(subscriptionId);

		validationChildImpl.resetOriginalValues();

		return validationChildImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		validationOrignalId = objectInput.readUTF();
		childValidationOriginalId = objectInput.readUTF();

		subscriptionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (validationOrignalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(validationOrignalId);
		}

		if (childValidationOriginalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(childValidationOriginalId);
		}

		objectOutput.writeLong(subscriptionId);
	}

	public String uuid;
	public long id;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String validationOrignalId;
	public String childValidationOriginalId;
	public long subscriptionId;

}