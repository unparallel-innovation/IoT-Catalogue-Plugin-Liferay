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

import com.iot_catalogue.model.ElementStandard;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ElementStandard in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElementStandardCacheModel
	implements CacheModel<ElementStandard>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElementStandardCacheModel)) {
			return false;
		}

		ElementStandardCacheModel elementStandardCacheModel =
			(ElementStandardCacheModel)object;

		if (elementStandardId == elementStandardCacheModel.elementStandardId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, elementStandardId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", elementStandardId=");
		sb.append(elementStandardId);
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
		sb.append(", elementOriginalId=");
		sb.append(elementOriginalId);
		sb.append(", elementClassName=");
		sb.append(elementClassName);
		sb.append(", name=");
		sb.append(name);
		sb.append(", subscriptionId=");
		sb.append(subscriptionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ElementStandard toEntityModel() {
		ElementStandardImpl elementStandardImpl = new ElementStandardImpl();

		if (uuid == null) {
			elementStandardImpl.setUuid("");
		}
		else {
			elementStandardImpl.setUuid(uuid);
		}

		elementStandardImpl.setElementStandardId(elementStandardId);
		elementStandardImpl.setGroupId(groupId);
		elementStandardImpl.setCompanyId(companyId);
		elementStandardImpl.setUserId(userId);

		if (userName == null) {
			elementStandardImpl.setUserName("");
		}
		else {
			elementStandardImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			elementStandardImpl.setCreateDate(null);
		}
		else {
			elementStandardImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			elementStandardImpl.setModifiedDate(null);
		}
		else {
			elementStandardImpl.setModifiedDate(new Date(modifiedDate));
		}

		elementStandardImpl.setStatus(status);
		elementStandardImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			elementStandardImpl.setStatusByUserName("");
		}
		else {
			elementStandardImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			elementStandardImpl.setStatusDate(null);
		}
		else {
			elementStandardImpl.setStatusDate(new Date(statusDate));
		}

		if (elementOriginalId == null) {
			elementStandardImpl.setElementOriginalId("");
		}
		else {
			elementStandardImpl.setElementOriginalId(elementOriginalId);
		}

		if (elementClassName == null) {
			elementStandardImpl.setElementClassName("");
		}
		else {
			elementStandardImpl.setElementClassName(elementClassName);
		}

		if (name == null) {
			elementStandardImpl.setName("");
		}
		else {
			elementStandardImpl.setName(name);
		}

		elementStandardImpl.setSubscriptionId(subscriptionId);

		elementStandardImpl.resetOriginalValues();

		return elementStandardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		elementStandardId = objectInput.readLong();

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
		elementOriginalId = objectInput.readUTF();
		elementClassName = objectInput.readUTF();
		name = objectInput.readUTF();

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

		objectOutput.writeLong(elementStandardId);

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

		if (elementOriginalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(elementOriginalId);
		}

		if (elementClassName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(elementClassName);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(subscriptionId);
	}

	public String uuid;
	public long elementStandardId;
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
	public String elementOriginalId;
	public String elementClassName;
	public String name;
	public long subscriptionId;

}