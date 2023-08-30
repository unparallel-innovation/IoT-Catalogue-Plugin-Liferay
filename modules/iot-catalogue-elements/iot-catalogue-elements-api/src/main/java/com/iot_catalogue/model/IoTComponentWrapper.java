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
 * This class is a wrapper for {@link IoTComponent}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IoTComponent
 * @generated
 */
public class IoTComponentWrapper
	extends BaseModelWrapper<IoTComponent>
	implements IoTComponent, ModelWrapper<IoTComponent> {

	public IoTComponentWrapper(IoTComponent ioTComponent) {
		super(ioTComponent);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("iotComponentId", getIotComponentId());
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
		attributes.put("originalId", getOriginalId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("embeddedUrl", getEmbeddedUrl());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("license", getLicense());
		attributes.put("trl", getTrl());
		attributes.put("elementStatus", getElementStatus());
		attributes.put("subscriptionId", getSubscriptionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long iotComponentId = (Long)attributes.get("iotComponentId");

		if (iotComponentId != null) {
			setIotComponentId(iotComponentId);
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

		String originalId = (String)attributes.get("originalId");

		if (originalId != null) {
			setOriginalId(originalId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String embeddedUrl = (String)attributes.get("embeddedUrl");

		if (embeddedUrl != null) {
			setEmbeddedUrl(embeddedUrl);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String license = (String)attributes.get("license");

		if (license != null) {
			setLicense(license);
		}

		String trl = (String)attributes.get("trl");

		if (trl != null) {
			setTrl(trl);
		}

		String elementStatus = (String)attributes.get("elementStatus");

		if (elementStatus != null) {
			setElementStatus(elementStatus);
		}

		Long subscriptionId = (Long)attributes.get("subscriptionId");

		if (subscriptionId != null) {
			setSubscriptionId(subscriptionId);
		}
	}

	/**
	 * Returns the company ID of this io t component.
	 *
	 * @return the company ID of this io t component
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this io t component.
	 *
	 * @return the create date of this io t component
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this io t component.
	 *
	 * @return the description of this io t component
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the element status of this io t component.
	 *
	 * @return the element status of this io t component
	 */
	@Override
	public String getElementStatus() {
		return model.getElementStatus();
	}

	/**
	 * Returns the embedded url of this io t component.
	 *
	 * @return the embedded url of this io t component
	 */
	@Override
	public String getEmbeddedUrl() {
		return model.getEmbeddedUrl();
	}

	/**
	 * Returns the group ID of this io t component.
	 *
	 * @return the group ID of this io t component
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the image url of this io t component.
	 *
	 * @return the image url of this io t component
	 */
	@Override
	public String getImageUrl() {
		return model.getImageUrl();
	}

	/**
	 * Returns the iot component ID of this io t component.
	 *
	 * @return the iot component ID of this io t component
	 */
	@Override
	public long getIotComponentId() {
		return model.getIotComponentId();
	}

	/**
	 * Returns the license of this io t component.
	 *
	 * @return the license of this io t component
	 */
	@Override
	public String getLicense() {
		return model.getLicense();
	}

	/**
	 * Returns the modified date of this io t component.
	 *
	 * @return the modified date of this io t component
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this io t component.
	 *
	 * @return the name of this io t component
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the original ID of this io t component.
	 *
	 * @return the original ID of this io t component
	 */
	@Override
	public String getOriginalId() {
		return model.getOriginalId();
	}

	/**
	 * Returns the primary key of this io t component.
	 *
	 * @return the primary key of this io t component
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this io t component.
	 *
	 * @return the status of this io t component
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this io t component.
	 *
	 * @return the status by user ID of this io t component
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this io t component.
	 *
	 * @return the status by user name of this io t component
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this io t component.
	 *
	 * @return the status by user uuid of this io t component
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this io t component.
	 *
	 * @return the status date of this io t component
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subscription ID of this io t component.
	 *
	 * @return the subscription ID of this io t component
	 */
	@Override
	public long getSubscriptionId() {
		return model.getSubscriptionId();
	}

	/**
	 * Returns the trl of this io t component.
	 *
	 * @return the trl of this io t component
	 */
	@Override
	public String getTrl() {
		return model.getTrl();
	}

	/**
	 * Returns the user ID of this io t component.
	 *
	 * @return the user ID of this io t component
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this io t component.
	 *
	 * @return the user name of this io t component
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this io t component.
	 *
	 * @return the user uuid of this io t component
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this io t component.
	 *
	 * @return the uuid of this io t component
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this io t component is approved.
	 *
	 * @return <code>true</code> if this io t component is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this io t component is denied.
	 *
	 * @return <code>true</code> if this io t component is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this io t component is a draft.
	 *
	 * @return <code>true</code> if this io t component is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this io t component is expired.
	 *
	 * @return <code>true</code> if this io t component is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this io t component is inactive.
	 *
	 * @return <code>true</code> if this io t component is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this io t component is incomplete.
	 *
	 * @return <code>true</code> if this io t component is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this io t component is pending.
	 *
	 * @return <code>true</code> if this io t component is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this io t component is scheduled.
	 *
	 * @return <code>true</code> if this io t component is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this io t component.
	 *
	 * @param companyId the company ID of this io t component
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this io t component.
	 *
	 * @param createDate the create date of this io t component
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this io t component.
	 *
	 * @param description the description of this io t component
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the element status of this io t component.
	 *
	 * @param elementStatus the element status of this io t component
	 */
	@Override
	public void setElementStatus(String elementStatus) {
		model.setElementStatus(elementStatus);
	}

	/**
	 * Sets the embedded url of this io t component.
	 *
	 * @param embeddedUrl the embedded url of this io t component
	 */
	@Override
	public void setEmbeddedUrl(String embeddedUrl) {
		model.setEmbeddedUrl(embeddedUrl);
	}

	/**
	 * Sets the group ID of this io t component.
	 *
	 * @param groupId the group ID of this io t component
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the image url of this io t component.
	 *
	 * @param imageUrl the image url of this io t component
	 */
	@Override
	public void setImageUrl(String imageUrl) {
		model.setImageUrl(imageUrl);
	}

	/**
	 * Sets the iot component ID of this io t component.
	 *
	 * @param iotComponentId the iot component ID of this io t component
	 */
	@Override
	public void setIotComponentId(long iotComponentId) {
		model.setIotComponentId(iotComponentId);
	}

	/**
	 * Sets the license of this io t component.
	 *
	 * @param license the license of this io t component
	 */
	@Override
	public void setLicense(String license) {
		model.setLicense(license);
	}

	/**
	 * Sets the modified date of this io t component.
	 *
	 * @param modifiedDate the modified date of this io t component
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this io t component.
	 *
	 * @param name the name of this io t component
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the original ID of this io t component.
	 *
	 * @param originalId the original ID of this io t component
	 */
	@Override
	public void setOriginalId(String originalId) {
		model.setOriginalId(originalId);
	}

	/**
	 * Sets the primary key of this io t component.
	 *
	 * @param primaryKey the primary key of this io t component
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this io t component.
	 *
	 * @param status the status of this io t component
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this io t component.
	 *
	 * @param statusByUserId the status by user ID of this io t component
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this io t component.
	 *
	 * @param statusByUserName the status by user name of this io t component
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this io t component.
	 *
	 * @param statusByUserUuid the status by user uuid of this io t component
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this io t component.
	 *
	 * @param statusDate the status date of this io t component
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subscription ID of this io t component.
	 *
	 * @param subscriptionId the subscription ID of this io t component
	 */
	@Override
	public void setSubscriptionId(long subscriptionId) {
		model.setSubscriptionId(subscriptionId);
	}

	/**
	 * Sets the trl of this io t component.
	 *
	 * @param trl the trl of this io t component
	 */
	@Override
	public void setTrl(String trl) {
		model.setTrl(trl);
	}

	/**
	 * Sets the user ID of this io t component.
	 *
	 * @param userId the user ID of this io t component
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this io t component.
	 *
	 * @param userName the user name of this io t component
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this io t component.
	 *
	 * @param userUuid the user uuid of this io t component
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this io t component.
	 *
	 * @param uuid the uuid of this io t component
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
	protected IoTComponentWrapper wrap(IoTComponent ioTComponent) {
		return new IoTComponentWrapper(ioTComponent);
	}

}