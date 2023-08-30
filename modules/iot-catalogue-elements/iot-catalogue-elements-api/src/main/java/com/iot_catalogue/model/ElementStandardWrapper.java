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
 * This class is a wrapper for {@link ElementStandard}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementStandard
 * @generated
 */
public class ElementStandardWrapper
	extends BaseModelWrapper<ElementStandard>
	implements ElementStandard, ModelWrapper<ElementStandard> {

	public ElementStandardWrapper(ElementStandard elementStandard) {
		super(elementStandard);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("elementStandardId", getElementStandardId());
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
		attributes.put("name", getName());
		attributes.put("subscriptionId", getSubscriptionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long elementStandardId = (Long)attributes.get("elementStandardId");

		if (elementStandardId != null) {
			setElementStandardId(elementStandardId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long subscriptionId = (Long)attributes.get("subscriptionId");

		if (subscriptionId != null) {
			setSubscriptionId(subscriptionId);
		}
	}

	/**
	 * Returns the company ID of this element standard.
	 *
	 * @return the company ID of this element standard
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this element standard.
	 *
	 * @return the create date of this element standard
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the element class name of this element standard.
	 *
	 * @return the element class name of this element standard
	 */
	@Override
	public String getElementClassName() {
		return model.getElementClassName();
	}

	/**
	 * Returns the element original ID of this element standard.
	 *
	 * @return the element original ID of this element standard
	 */
	@Override
	public String getElementOriginalId() {
		return model.getElementOriginalId();
	}

	/**
	 * Returns the element standard ID of this element standard.
	 *
	 * @return the element standard ID of this element standard
	 */
	@Override
	public long getElementStandardId() {
		return model.getElementStandardId();
	}

	/**
	 * Returns the group ID of this element standard.
	 *
	 * @return the group ID of this element standard
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this element standard.
	 *
	 * @return the modified date of this element standard
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this element standard.
	 *
	 * @return the name of this element standard
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this element standard.
	 *
	 * @return the primary key of this element standard
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this element standard.
	 *
	 * @return the status of this element standard
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this element standard.
	 *
	 * @return the status by user ID of this element standard
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this element standard.
	 *
	 * @return the status by user name of this element standard
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this element standard.
	 *
	 * @return the status by user uuid of this element standard
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this element standard.
	 *
	 * @return the status date of this element standard
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subscription ID of this element standard.
	 *
	 * @return the subscription ID of this element standard
	 */
	@Override
	public long getSubscriptionId() {
		return model.getSubscriptionId();
	}

	/**
	 * Returns the user ID of this element standard.
	 *
	 * @return the user ID of this element standard
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this element standard.
	 *
	 * @return the user name of this element standard
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this element standard.
	 *
	 * @return the user uuid of this element standard
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this element standard.
	 *
	 * @return the uuid of this element standard
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this element standard is approved.
	 *
	 * @return <code>true</code> if this element standard is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this element standard is denied.
	 *
	 * @return <code>true</code> if this element standard is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this element standard is a draft.
	 *
	 * @return <code>true</code> if this element standard is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this element standard is expired.
	 *
	 * @return <code>true</code> if this element standard is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this element standard is inactive.
	 *
	 * @return <code>true</code> if this element standard is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this element standard is incomplete.
	 *
	 * @return <code>true</code> if this element standard is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this element standard is pending.
	 *
	 * @return <code>true</code> if this element standard is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this element standard is scheduled.
	 *
	 * @return <code>true</code> if this element standard is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this element standard.
	 *
	 * @param companyId the company ID of this element standard
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this element standard.
	 *
	 * @param createDate the create date of this element standard
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the element class name of this element standard.
	 *
	 * @param elementClassName the element class name of this element standard
	 */
	@Override
	public void setElementClassName(String elementClassName) {
		model.setElementClassName(elementClassName);
	}

	/**
	 * Sets the element original ID of this element standard.
	 *
	 * @param elementOriginalId the element original ID of this element standard
	 */
	@Override
	public void setElementOriginalId(String elementOriginalId) {
		model.setElementOriginalId(elementOriginalId);
	}

	/**
	 * Sets the element standard ID of this element standard.
	 *
	 * @param elementStandardId the element standard ID of this element standard
	 */
	@Override
	public void setElementStandardId(long elementStandardId) {
		model.setElementStandardId(elementStandardId);
	}

	/**
	 * Sets the group ID of this element standard.
	 *
	 * @param groupId the group ID of this element standard
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this element standard.
	 *
	 * @param modifiedDate the modified date of this element standard
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this element standard.
	 *
	 * @param name the name of this element standard
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this element standard.
	 *
	 * @param primaryKey the primary key of this element standard
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this element standard.
	 *
	 * @param status the status of this element standard
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this element standard.
	 *
	 * @param statusByUserId the status by user ID of this element standard
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this element standard.
	 *
	 * @param statusByUserName the status by user name of this element standard
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this element standard.
	 *
	 * @param statusByUserUuid the status by user uuid of this element standard
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this element standard.
	 *
	 * @param statusDate the status date of this element standard
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subscription ID of this element standard.
	 *
	 * @param subscriptionId the subscription ID of this element standard
	 */
	@Override
	public void setSubscriptionId(long subscriptionId) {
		model.setSubscriptionId(subscriptionId);
	}

	/**
	 * Sets the user ID of this element standard.
	 *
	 * @param userId the user ID of this element standard
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this element standard.
	 *
	 * @param userName the user name of this element standard
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this element standard.
	 *
	 * @param userUuid the user uuid of this element standard
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this element standard.
	 *
	 * @param uuid the uuid of this element standard
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
	protected ElementStandardWrapper wrap(ElementStandard elementStandard) {
		return new ElementStandardWrapper(elementStandard);
	}

}