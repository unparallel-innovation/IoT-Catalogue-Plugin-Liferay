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
 * This class is a wrapper for {@link ValidationChild}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ValidationChild
 * @generated
 */
public class ValidationChildWrapper
	extends BaseModelWrapper<ValidationChild>
	implements ModelWrapper<ValidationChild>, ValidationChild {

	public ValidationChildWrapper(ValidationChild validationChild) {
		super(validationChild);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
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
		attributes.put("validationOrignalId", getValidationOrignalId());
		attributes.put(
			"childValidationOriginalId", getChildValidationOriginalId());
		attributes.put("subscriptionId", getSubscriptionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
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

		String validationOrignalId = (String)attributes.get(
			"validationOrignalId");

		if (validationOrignalId != null) {
			setValidationOrignalId(validationOrignalId);
		}

		String childValidationOriginalId = (String)attributes.get(
			"childValidationOriginalId");

		if (childValidationOriginalId != null) {
			setChildValidationOriginalId(childValidationOriginalId);
		}

		Long subscriptionId = (Long)attributes.get("subscriptionId");

		if (subscriptionId != null) {
			setSubscriptionId(subscriptionId);
		}
	}

	/**
	 * Returns the child validation original ID of this validation child.
	 *
	 * @return the child validation original ID of this validation child
	 */
	@Override
	public String getChildValidationOriginalId() {
		return model.getChildValidationOriginalId();
	}

	/**
	 * Returns the company ID of this validation child.
	 *
	 * @return the company ID of this validation child
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this validation child.
	 *
	 * @return the create date of this validation child
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this validation child.
	 *
	 * @return the group ID of this validation child
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ID of this validation child.
	 *
	 * @return the ID of this validation child
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the modified date of this validation child.
	 *
	 * @return the modified date of this validation child
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this validation child.
	 *
	 * @return the primary key of this validation child
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this validation child.
	 *
	 * @return the status of this validation child
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this validation child.
	 *
	 * @return the status by user ID of this validation child
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this validation child.
	 *
	 * @return the status by user name of this validation child
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this validation child.
	 *
	 * @return the status by user uuid of this validation child
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this validation child.
	 *
	 * @return the status date of this validation child
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subscription ID of this validation child.
	 *
	 * @return the subscription ID of this validation child
	 */
	@Override
	public long getSubscriptionId() {
		return model.getSubscriptionId();
	}

	/**
	 * Returns the user ID of this validation child.
	 *
	 * @return the user ID of this validation child
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this validation child.
	 *
	 * @return the user name of this validation child
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this validation child.
	 *
	 * @return the user uuid of this validation child
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this validation child.
	 *
	 * @return the uuid of this validation child
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the validation orignal ID of this validation child.
	 *
	 * @return the validation orignal ID of this validation child
	 */
	@Override
	public String getValidationOrignalId() {
		return model.getValidationOrignalId();
	}

	/**
	 * Returns <code>true</code> if this validation child is approved.
	 *
	 * @return <code>true</code> if this validation child is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this validation child is denied.
	 *
	 * @return <code>true</code> if this validation child is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this validation child is a draft.
	 *
	 * @return <code>true</code> if this validation child is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this validation child is expired.
	 *
	 * @return <code>true</code> if this validation child is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this validation child is inactive.
	 *
	 * @return <code>true</code> if this validation child is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this validation child is incomplete.
	 *
	 * @return <code>true</code> if this validation child is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this validation child is pending.
	 *
	 * @return <code>true</code> if this validation child is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this validation child is scheduled.
	 *
	 * @return <code>true</code> if this validation child is scheduled; <code>false</code> otherwise
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
	 * Sets the child validation original ID of this validation child.
	 *
	 * @param childValidationOriginalId the child validation original ID of this validation child
	 */
	@Override
	public void setChildValidationOriginalId(String childValidationOriginalId) {
		model.setChildValidationOriginalId(childValidationOriginalId);
	}

	/**
	 * Sets the company ID of this validation child.
	 *
	 * @param companyId the company ID of this validation child
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this validation child.
	 *
	 * @param createDate the create date of this validation child
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this validation child.
	 *
	 * @param groupId the group ID of this validation child
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ID of this validation child.
	 *
	 * @param id the ID of this validation child
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the modified date of this validation child.
	 *
	 * @param modifiedDate the modified date of this validation child
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this validation child.
	 *
	 * @param primaryKey the primary key of this validation child
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this validation child.
	 *
	 * @param status the status of this validation child
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this validation child.
	 *
	 * @param statusByUserId the status by user ID of this validation child
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this validation child.
	 *
	 * @param statusByUserName the status by user name of this validation child
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this validation child.
	 *
	 * @param statusByUserUuid the status by user uuid of this validation child
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this validation child.
	 *
	 * @param statusDate the status date of this validation child
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subscription ID of this validation child.
	 *
	 * @param subscriptionId the subscription ID of this validation child
	 */
	@Override
	public void setSubscriptionId(long subscriptionId) {
		model.setSubscriptionId(subscriptionId);
	}

	/**
	 * Sets the user ID of this validation child.
	 *
	 * @param userId the user ID of this validation child
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this validation child.
	 *
	 * @param userName the user name of this validation child
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this validation child.
	 *
	 * @param userUuid the user uuid of this validation child
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this validation child.
	 *
	 * @param uuid the uuid of this validation child
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the validation orignal ID of this validation child.
	 *
	 * @param validationOrignalId the validation orignal ID of this validation child
	 */
	@Override
	public void setValidationOrignalId(String validationOrignalId) {
		model.setValidationOrignalId(validationOrignalId);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ValidationChildWrapper wrap(ValidationChild validationChild) {
		return new ValidationChildWrapper(validationChild);
	}

}