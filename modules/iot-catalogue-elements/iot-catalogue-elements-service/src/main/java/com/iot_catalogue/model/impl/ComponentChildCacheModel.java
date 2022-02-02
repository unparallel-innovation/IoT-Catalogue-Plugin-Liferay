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

import com.iot_catalogue.model.ComponentChild;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ComponentChild in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ComponentChildCacheModel
	implements CacheModel<ComponentChild>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ComponentChildCacheModel)) {
			return false;
		}

		ComponentChildCacheModel componentChildCacheModel =
			(ComponentChildCacheModel)object;

		if (id == componentChildCacheModel.id) {
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
		sb.append(", componentOrignalId=");
		sb.append(componentOrignalId);
		sb.append(", childComponentOriginalId=");
		sb.append(childComponentOriginalId);
		sb.append(", subscriptionId=");
		sb.append(subscriptionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ComponentChild toEntityModel() {
		ComponentChildImpl componentChildImpl = new ComponentChildImpl();

		if (uuid == null) {
			componentChildImpl.setUuid("");
		}
		else {
			componentChildImpl.setUuid(uuid);
		}

		componentChildImpl.setId(id);
		componentChildImpl.setGroupId(groupId);
		componentChildImpl.setCompanyId(companyId);
		componentChildImpl.setUserId(userId);

		if (userName == null) {
			componentChildImpl.setUserName("");
		}
		else {
			componentChildImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			componentChildImpl.setCreateDate(null);
		}
		else {
			componentChildImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			componentChildImpl.setModifiedDate(null);
		}
		else {
			componentChildImpl.setModifiedDate(new Date(modifiedDate));
		}

		componentChildImpl.setStatus(status);
		componentChildImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			componentChildImpl.setStatusByUserName("");
		}
		else {
			componentChildImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			componentChildImpl.setStatusDate(null);
		}
		else {
			componentChildImpl.setStatusDate(new Date(statusDate));
		}

		if (componentOrignalId == null) {
			componentChildImpl.setComponentOrignalId("");
		}
		else {
			componentChildImpl.setComponentOrignalId(componentOrignalId);
		}

		if (childComponentOriginalId == null) {
			componentChildImpl.setChildComponentOriginalId("");
		}
		else {
			componentChildImpl.setChildComponentOriginalId(
				childComponentOriginalId);
		}

		componentChildImpl.setSubscriptionId(subscriptionId);

		componentChildImpl.resetOriginalValues();

		return componentChildImpl;
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
		componentOrignalId = objectInput.readUTF();
		childComponentOriginalId = objectInput.readUTF();

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

		if (componentOrignalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(componentOrignalId);
		}

		if (childComponentOriginalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(childComponentOriginalId);
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
	public String componentOrignalId;
	public String childComponentOriginalId;
	public long subscriptionId;

}