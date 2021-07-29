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

import com.iot_catalogue.model.IoTValidation;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing IoTValidation in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class IoTValidationCacheModel
	implements CacheModel<IoTValidation>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IoTValidationCacheModel)) {
			return false;
		}

		IoTValidationCacheModel ioTValidationCacheModel =
			(IoTValidationCacheModel)object;

		if (iotValidationId == ioTValidationCacheModel.iotValidationId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, iotValidationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", iotValidationId=");
		sb.append(iotValidationId);
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
		sb.append(", originalId=");
		sb.append(originalId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", embeddedUrl=");
		sb.append(embeddedUrl);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", subscriptionId=");
		sb.append(subscriptionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IoTValidation toEntityModel() {
		IoTValidationImpl ioTValidationImpl = new IoTValidationImpl();

		if (uuid == null) {
			ioTValidationImpl.setUuid("");
		}
		else {
			ioTValidationImpl.setUuid(uuid);
		}

		ioTValidationImpl.setIotValidationId(iotValidationId);
		ioTValidationImpl.setGroupId(groupId);
		ioTValidationImpl.setCompanyId(companyId);
		ioTValidationImpl.setUserId(userId);

		if (userName == null) {
			ioTValidationImpl.setUserName("");
		}
		else {
			ioTValidationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ioTValidationImpl.setCreateDate(null);
		}
		else {
			ioTValidationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ioTValidationImpl.setModifiedDate(null);
		}
		else {
			ioTValidationImpl.setModifiedDate(new Date(modifiedDate));
		}

		ioTValidationImpl.setStatus(status);
		ioTValidationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			ioTValidationImpl.setStatusByUserName("");
		}
		else {
			ioTValidationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			ioTValidationImpl.setStatusDate(null);
		}
		else {
			ioTValidationImpl.setStatusDate(new Date(statusDate));
		}

		if (originalId == null) {
			ioTValidationImpl.setOriginalId("");
		}
		else {
			ioTValidationImpl.setOriginalId(originalId);
		}

		if (name == null) {
			ioTValidationImpl.setName("");
		}
		else {
			ioTValidationImpl.setName(name);
		}

		if (description == null) {
			ioTValidationImpl.setDescription("");
		}
		else {
			ioTValidationImpl.setDescription(description);
		}

		if (embeddedUrl == null) {
			ioTValidationImpl.setEmbeddedUrl("");
		}
		else {
			ioTValidationImpl.setEmbeddedUrl(embeddedUrl);
		}

		if (imageUrl == null) {
			ioTValidationImpl.setImageUrl("");
		}
		else {
			ioTValidationImpl.setImageUrl(imageUrl);
		}

		ioTValidationImpl.setSubscriptionId(subscriptionId);

		ioTValidationImpl.resetOriginalValues();

		return ioTValidationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		iotValidationId = objectInput.readLong();

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
		originalId = objectInput.readUTF();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		embeddedUrl = objectInput.readUTF();
		imageUrl = objectInput.readUTF();

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

		objectOutput.writeLong(iotValidationId);

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

		if (originalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(originalId);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (embeddedUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(embeddedUrl);
		}

		if (imageUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		objectOutput.writeLong(subscriptionId);
	}

	public String uuid;
	public long iotValidationId;
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
	public String originalId;
	public String name;
	public String description;
	public String embeddedUrl;
	public String imageUrl;
	public long subscriptionId;

}