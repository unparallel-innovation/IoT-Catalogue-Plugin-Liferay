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

import com.iot_catalogue.model.IoTComponent;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing IoTComponent in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class IoTComponentCacheModel
	implements CacheModel<IoTComponent>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof IoTComponentCacheModel)) {
			return false;
		}

		IoTComponentCacheModel ioTComponentCacheModel =
			(IoTComponentCacheModel)object;

		if (iotComponentId == ioTComponentCacheModel.iotComponentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, iotComponentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", iotComponentId=");
		sb.append(iotComponentId);
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
	public IoTComponent toEntityModel() {
		IoTComponentImpl ioTComponentImpl = new IoTComponentImpl();

		if (uuid == null) {
			ioTComponentImpl.setUuid("");
		}
		else {
			ioTComponentImpl.setUuid(uuid);
		}

		ioTComponentImpl.setIotComponentId(iotComponentId);
		ioTComponentImpl.setGroupId(groupId);
		ioTComponentImpl.setCompanyId(companyId);
		ioTComponentImpl.setUserId(userId);

		if (userName == null) {
			ioTComponentImpl.setUserName("");
		}
		else {
			ioTComponentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ioTComponentImpl.setCreateDate(null);
		}
		else {
			ioTComponentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ioTComponentImpl.setModifiedDate(null);
		}
		else {
			ioTComponentImpl.setModifiedDate(new Date(modifiedDate));
		}

		ioTComponentImpl.setStatus(status);
		ioTComponentImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			ioTComponentImpl.setStatusByUserName("");
		}
		else {
			ioTComponentImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			ioTComponentImpl.setStatusDate(null);
		}
		else {
			ioTComponentImpl.setStatusDate(new Date(statusDate));
		}

		if (originalId == null) {
			ioTComponentImpl.setOriginalId("");
		}
		else {
			ioTComponentImpl.setOriginalId(originalId);
		}

		if (name == null) {
			ioTComponentImpl.setName("");
		}
		else {
			ioTComponentImpl.setName(name);
		}

		if (description == null) {
			ioTComponentImpl.setDescription("");
		}
		else {
			ioTComponentImpl.setDescription(description);
		}

		if (embeddedUrl == null) {
			ioTComponentImpl.setEmbeddedUrl("");
		}
		else {
			ioTComponentImpl.setEmbeddedUrl(embeddedUrl);
		}

		if (imageUrl == null) {
			ioTComponentImpl.setImageUrl("");
		}
		else {
			ioTComponentImpl.setImageUrl(imageUrl);
		}

		ioTComponentImpl.setSubscriptionId(subscriptionId);

		ioTComponentImpl.resetOriginalValues();

		return ioTComponentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		iotComponentId = objectInput.readLong();

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

		objectOutput.writeLong(iotComponentId);

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
	public long iotComponentId;
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