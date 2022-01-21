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

package com.iot_catalogue.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ElementCoordinate}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementCoordinate
 * @generated
 */
public class ElementCoordinateWrapper
	extends BaseModelWrapper<ElementCoordinate>
	implements ElementCoordinate, ModelWrapper<ElementCoordinate> {

	public ElementCoordinateWrapper(ElementCoordinate elementCoordinate) {
		super(elementCoordinate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("elementCoordinateId", getElementCoordinateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("elementOriginalId", getElementOriginalId());
		attributes.put("elementClassName", getElementClassName());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("subscriptionId", getSubscriptionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long elementCoordinateId = (Long)attributes.get("elementCoordinateId");

		if (elementCoordinateId != null) {
			setElementCoordinateId(elementCoordinateId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String elementOriginalId = (String)attributes.get("elementOriginalId");

		if (elementOriginalId != null) {
			setElementOriginalId(elementOriginalId);
		}

		String elementClassName = (String)attributes.get("elementClassName");

		if (elementClassName != null) {
			setElementClassName(elementClassName);
		}

		Double latitude = (Double)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		Double longitude = (Double)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		Long subscriptionId = (Long)attributes.get("subscriptionId");

		if (subscriptionId != null) {
			setSubscriptionId(subscriptionId);
		}
	}

	/**
	 * Returns the company ID of this element coordinate.
	 *
	 * @return the company ID of this element coordinate
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this element coordinate.
	 *
	 * @return the create date of this element coordinate
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the element class name of this element coordinate.
	 *
	 * @return the element class name of this element coordinate
	 */
	@Override
	public String getElementClassName() {
		return model.getElementClassName();
	}

	/**
	 * Returns the element coordinate ID of this element coordinate.
	 *
	 * @return the element coordinate ID of this element coordinate
	 */
	@Override
	public long getElementCoordinateId() {
		return model.getElementCoordinateId();
	}

	/**
	 * Returns the element original ID of this element coordinate.
	 *
	 * @return the element original ID of this element coordinate
	 */
	@Override
	public String getElementOriginalId() {
		return model.getElementOriginalId();
	}

	/**
	 * Returns the group ID of this element coordinate.
	 *
	 * @return the group ID of this element coordinate
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the latitude of this element coordinate.
	 *
	 * @return the latitude of this element coordinate
	 */
	@Override
	public double getLatitude() {
		return model.getLatitude();
	}

	/**
	 * Returns the longitude of this element coordinate.
	 *
	 * @return the longitude of this element coordinate
	 */
	@Override
	public double getLongitude() {
		return model.getLongitude();
	}

	/**
	 * Returns the modified date of this element coordinate.
	 *
	 * @return the modified date of this element coordinate
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this element coordinate.
	 *
	 * @return the primary key of this element coordinate
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this element coordinate.
	 *
	 * @return the status of this element coordinate
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this element coordinate.
	 *
	 * @return the status by user ID of this element coordinate
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this element coordinate.
	 *
	 * @return the status by user name of this element coordinate
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this element coordinate.
	 *
	 * @return the status by user uuid of this element coordinate
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this element coordinate.
	 *
	 * @return the status date of this element coordinate
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subscription ID of this element coordinate.
	 *
	 * @return the subscription ID of this element coordinate
	 */
	@Override
	public long getSubscriptionId() {
		return model.getSubscriptionId();
	}

	/**
	 * Returns the user ID of this element coordinate.
	 *
	 * @return the user ID of this element coordinate
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this element coordinate.
	 *
	 * @return the user name of this element coordinate
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this element coordinate.
	 *
	 * @return the user uuid of this element coordinate
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this element coordinate.
	 *
	 * @return the uuid of this element coordinate
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this element coordinate is approved.
	 *
	 * @return <code>true</code> if this element coordinate is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this element coordinate is denied.
	 *
	 * @return <code>true</code> if this element coordinate is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this element coordinate is a draft.
	 *
	 * @return <code>true</code> if this element coordinate is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this element coordinate is expired.
	 *
	 * @return <code>true</code> if this element coordinate is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this element coordinate is inactive.
	 *
	 * @return <code>true</code> if this element coordinate is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this element coordinate is incomplete.
	 *
	 * @return <code>true</code> if this element coordinate is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this element coordinate is pending.
	 *
	 * @return <code>true</code> if this element coordinate is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this element coordinate is scheduled.
	 *
	 * @return <code>true</code> if this element coordinate is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this element coordinate.
	 *
	 * @param companyId the company ID of this element coordinate
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this element coordinate.
	 *
	 * @param createDate the create date of this element coordinate
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the element class name of this element coordinate.
	 *
	 * @param elementClassName the element class name of this element coordinate
	 */
	@Override
	public void setElementClassName(String elementClassName) {
		model.setElementClassName(elementClassName);
	}

	/**
	 * Sets the element coordinate ID of this element coordinate.
	 *
	 * @param elementCoordinateId the element coordinate ID of this element coordinate
	 */
	@Override
	public void setElementCoordinateId(long elementCoordinateId) {
		model.setElementCoordinateId(elementCoordinateId);
	}

	/**
	 * Sets the element original ID of this element coordinate.
	 *
	 * @param elementOriginalId the element original ID of this element coordinate
	 */
	@Override
	public void setElementOriginalId(String elementOriginalId) {
		model.setElementOriginalId(elementOriginalId);
	}

	/**
	 * Sets the group ID of this element coordinate.
	 *
	 * @param groupId the group ID of this element coordinate
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the latitude of this element coordinate.
	 *
	 * @param latitude the latitude of this element coordinate
	 */
	@Override
	public void setLatitude(double latitude) {
		model.setLatitude(latitude);
	}

	/**
	 * Sets the longitude of this element coordinate.
	 *
	 * @param longitude the longitude of this element coordinate
	 */
	@Override
	public void setLongitude(double longitude) {
		model.setLongitude(longitude);
	}

	/**
	 * Sets the modified date of this element coordinate.
	 *
	 * @param modifiedDate the modified date of this element coordinate
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this element coordinate.
	 *
	 * @param primaryKey the primary key of this element coordinate
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this element coordinate.
	 *
	 * @param status the status of this element coordinate
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this element coordinate.
	 *
	 * @param statusByUserId the status by user ID of this element coordinate
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this element coordinate.
	 *
	 * @param statusByUserName the status by user name of this element coordinate
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this element coordinate.
	 *
	 * @param statusByUserUuid the status by user uuid of this element coordinate
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this element coordinate.
	 *
	 * @param statusDate the status date of this element coordinate
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subscription ID of this element coordinate.
	 *
	 * @param subscriptionId the subscription ID of this element coordinate
	 */
	@Override
	public void setSubscriptionId(long subscriptionId) {
		model.setSubscriptionId(subscriptionId);
	}

	/**
	 * Sets the user ID of this element coordinate.
	 *
	 * @param userId the user ID of this element coordinate
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this element coordinate.
	 *
	 * @param userName the user name of this element coordinate
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this element coordinate.
	 *
	 * @param userUuid the user uuid of this element coordinate
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this element coordinate.
	 *
	 * @param uuid the uuid of this element coordinate
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ElementCoordinateWrapper wrap(
		ElementCoordinate elementCoordinate) {

		return new ElementCoordinateWrapper(elementCoordinate);
	}

}