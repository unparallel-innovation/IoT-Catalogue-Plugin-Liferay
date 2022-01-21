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

import com.iot_catalogue.model.ElementCoordinate;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ElementCoordinate in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElementCoordinateCacheModel
	implements CacheModel<ElementCoordinate>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElementCoordinateCacheModel)) {
			return false;
		}

		ElementCoordinateCacheModel elementCoordinateCacheModel =
			(ElementCoordinateCacheModel)object;

		if (elementCoordinateId ==
				elementCoordinateCacheModel.elementCoordinateId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, elementCoordinateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", elementCoordinateId=");
		sb.append(elementCoordinateId);
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
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", subscriptionId=");
		sb.append(subscriptionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ElementCoordinate toEntityModel() {
		ElementCoordinateImpl elementCoordinateImpl =
			new ElementCoordinateImpl();

		if (uuid == null) {
			elementCoordinateImpl.setUuid("");
		}
		else {
			elementCoordinateImpl.setUuid(uuid);
		}

		elementCoordinateImpl.setElementCoordinateId(elementCoordinateId);
		elementCoordinateImpl.setGroupId(groupId);
		elementCoordinateImpl.setCompanyId(companyId);
		elementCoordinateImpl.setUserId(userId);

		if (userName == null) {
			elementCoordinateImpl.setUserName("");
		}
		else {
			elementCoordinateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			elementCoordinateImpl.setCreateDate(null);
		}
		else {
			elementCoordinateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			elementCoordinateImpl.setModifiedDate(null);
		}
		else {
			elementCoordinateImpl.setModifiedDate(new Date(modifiedDate));
		}

		elementCoordinateImpl.setStatus(status);
		elementCoordinateImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			elementCoordinateImpl.setStatusByUserName("");
		}
		else {
			elementCoordinateImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			elementCoordinateImpl.setStatusDate(null);
		}
		else {
			elementCoordinateImpl.setStatusDate(new Date(statusDate));
		}

		if (elementOriginalId == null) {
			elementCoordinateImpl.setElementOriginalId("");
		}
		else {
			elementCoordinateImpl.setElementOriginalId(elementOriginalId);
		}

		if (elementClassName == null) {
			elementCoordinateImpl.setElementClassName("");
		}
		else {
			elementCoordinateImpl.setElementClassName(elementClassName);
		}

		elementCoordinateImpl.setLatitude(latitude);
		elementCoordinateImpl.setLongitude(longitude);
		elementCoordinateImpl.setSubscriptionId(subscriptionId);

		elementCoordinateImpl.resetOriginalValues();

		return elementCoordinateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		elementCoordinateId = objectInput.readLong();

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

		latitude = objectInput.readDouble();

		longitude = objectInput.readDouble();

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

		objectOutput.writeLong(elementCoordinateId);

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

		objectOutput.writeDouble(latitude);

		objectOutput.writeDouble(longitude);

		objectOutput.writeLong(subscriptionId);
	}

	public String uuid;
	public long elementCoordinateId;
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
	public double latitude;
	public double longitude;
	public long subscriptionId;

}