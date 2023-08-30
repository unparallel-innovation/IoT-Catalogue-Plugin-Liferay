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

import com.iot_catalogue.model.ElementEntity;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ElementEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElementEntityCacheModel
	implements CacheModel<ElementEntity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElementEntityCacheModel)) {
			return false;
		}

		ElementEntityCacheModel elementEntityCacheModel =
			(ElementEntityCacheModel)object;

		if (elementEntityId == elementEntityCacheModel.elementEntityId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, elementEntityId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", elementEntityId=");
		sb.append(elementEntityId);
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
		sb.append(", website=");
		sb.append(website);
		sb.append(", label=");
		sb.append(label);
		sb.append(", subscriptionId=");
		sb.append(subscriptionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ElementEntity toEntityModel() {
		ElementEntityImpl elementEntityImpl = new ElementEntityImpl();

		if (uuid == null) {
			elementEntityImpl.setUuid("");
		}
		else {
			elementEntityImpl.setUuid(uuid);
		}

		elementEntityImpl.setElementEntityId(elementEntityId);
		elementEntityImpl.setGroupId(groupId);
		elementEntityImpl.setCompanyId(companyId);
		elementEntityImpl.setUserId(userId);

		if (userName == null) {
			elementEntityImpl.setUserName("");
		}
		else {
			elementEntityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			elementEntityImpl.setCreateDate(null);
		}
		else {
			elementEntityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			elementEntityImpl.setModifiedDate(null);
		}
		else {
			elementEntityImpl.setModifiedDate(new Date(modifiedDate));
		}

		elementEntityImpl.setStatus(status);
		elementEntityImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			elementEntityImpl.setStatusByUserName("");
		}
		else {
			elementEntityImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			elementEntityImpl.setStatusDate(null);
		}
		else {
			elementEntityImpl.setStatusDate(new Date(statusDate));
		}

		if (elementOriginalId == null) {
			elementEntityImpl.setElementOriginalId("");
		}
		else {
			elementEntityImpl.setElementOriginalId(elementOriginalId);
		}

		if (elementClassName == null) {
			elementEntityImpl.setElementClassName("");
		}
		else {
			elementEntityImpl.setElementClassName(elementClassName);
		}

		if (name == null) {
			elementEntityImpl.setName("");
		}
		else {
			elementEntityImpl.setName(name);
		}

		if (website == null) {
			elementEntityImpl.setWebsite("");
		}
		else {
			elementEntityImpl.setWebsite(website);
		}

		if (label == null) {
			elementEntityImpl.setLabel("");
		}
		else {
			elementEntityImpl.setLabel(label);
		}

		elementEntityImpl.setSubscriptionId(subscriptionId);

		elementEntityImpl.resetOriginalValues();

		return elementEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		elementEntityId = objectInput.readLong();

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
		website = objectInput.readUTF();
		label = objectInput.readUTF();

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

		objectOutput.writeLong(elementEntityId);

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

		if (website == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(website);
		}

		if (label == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(label);
		}

		objectOutput.writeLong(subscriptionId);
	}

	public String uuid;
	public long elementEntityId;
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
	public String website;
	public String label;
	public long subscriptionId;

}