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

import com.iot_catalogue.model.Subscription;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Subscription in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SubscriptionCacheModel
	implements CacheModel<Subscription>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof SubscriptionCacheModel)) {
			return false;
		}

		SubscriptionCacheModel subscriptionCacheModel =
			(SubscriptionCacheModel)object;

		if (subscriptionId == subscriptionCacheModel.subscriptionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, subscriptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", subscriptionId=");
		sb.append(subscriptionId);
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
		sb.append(", connectionId=");
		sb.append(connectionId);
		sb.append(", connectionState=");
		sb.append(connectionState);
		sb.append(", token=");
		sb.append(token);
		sb.append(", socketAddress=");
		sb.append(socketAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Subscription toEntityModel() {
		SubscriptionImpl subscriptionImpl = new SubscriptionImpl();

		if (uuid == null) {
			subscriptionImpl.setUuid("");
		}
		else {
			subscriptionImpl.setUuid(uuid);
		}

		subscriptionImpl.setSubscriptionId(subscriptionId);
		subscriptionImpl.setGroupId(groupId);
		subscriptionImpl.setCompanyId(companyId);
		subscriptionImpl.setUserId(userId);

		if (userName == null) {
			subscriptionImpl.setUserName("");
		}
		else {
			subscriptionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			subscriptionImpl.setCreateDate(null);
		}
		else {
			subscriptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			subscriptionImpl.setModifiedDate(null);
		}
		else {
			subscriptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		subscriptionImpl.setStatus(status);
		subscriptionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			subscriptionImpl.setStatusByUserName("");
		}
		else {
			subscriptionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			subscriptionImpl.setStatusDate(null);
		}
		else {
			subscriptionImpl.setStatusDate(new Date(statusDate));
		}

		if (connectionId == null) {
			subscriptionImpl.setConnectionId("");
		}
		else {
			subscriptionImpl.setConnectionId(connectionId);
		}

		if (connectionState == null) {
			subscriptionImpl.setConnectionState("");
		}
		else {
			subscriptionImpl.setConnectionState(connectionState);
		}

		if (token == null) {
			subscriptionImpl.setToken("");
		}
		else {
			subscriptionImpl.setToken(token);
		}

		if (socketAddress == null) {
			subscriptionImpl.setSocketAddress("");
		}
		else {
			subscriptionImpl.setSocketAddress(socketAddress);
		}

		subscriptionImpl.resetOriginalValues();

		return subscriptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		subscriptionId = objectInput.readLong();

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
		connectionId = objectInput.readUTF();
		connectionState = objectInput.readUTF();
		token = objectInput.readUTF();
		socketAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(subscriptionId);

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

		if (connectionId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(connectionId);
		}

		if (connectionState == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(connectionState);
		}

		if (token == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(token);
		}

		if (socketAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(socketAddress);
		}
	}

	public String uuid;
	public long subscriptionId;
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
	public String connectionId;
	public String connectionState;
	public String token;
	public String socketAddress;

}