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
 * This class is a wrapper for {@link Subscription}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Subscription
 * @generated
 */
public class SubscriptionWrapper
	extends BaseModelWrapper<Subscription>
	implements ModelWrapper<Subscription>, Subscription {

	public SubscriptionWrapper(Subscription subscription) {
		super(subscription);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("subscriptionId", getSubscriptionId());
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
		attributes.put("connectionId", getConnectionId());
		attributes.put("connectionState", getConnectionState());
		attributes.put("token", getToken());
		attributes.put("socketAddress", getSocketAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long subscriptionId = (Long)attributes.get("subscriptionId");

		if (subscriptionId != null) {
			setSubscriptionId(subscriptionId);
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

		String connectionId = (String)attributes.get("connectionId");

		if (connectionId != null) {
			setConnectionId(connectionId);
		}

		String connectionState = (String)attributes.get("connectionState");

		if (connectionState != null) {
			setConnectionState(connectionState);
		}

		String token = (String)attributes.get("token");

		if (token != null) {
			setToken(token);
		}

		String socketAddress = (String)attributes.get("socketAddress");

		if (socketAddress != null) {
			setSocketAddress(socketAddress);
		}
	}

	/**
	 * Returns the company ID of this subscription.
	 *
	 * @return the company ID of this subscription
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the connection ID of this subscription.
	 *
	 * @return the connection ID of this subscription
	 */
	@Override
	public String getConnectionId() {
		return model.getConnectionId();
	}

	/**
	 * Returns the connection state of this subscription.
	 *
	 * @return the connection state of this subscription
	 */
	@Override
	public String getConnectionState() {
		return model.getConnectionState();
	}

	/**
	 * Returns the create date of this subscription.
	 *
	 * @return the create date of this subscription
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this subscription.
	 *
	 * @return the group ID of this subscription
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this subscription.
	 *
	 * @return the modified date of this subscription
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this subscription.
	 *
	 * @return the primary key of this subscription
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the socket address of this subscription.
	 *
	 * @return the socket address of this subscription
	 */
	@Override
	public String getSocketAddress() {
		return model.getSocketAddress();
	}

	/**
	 * Returns the status of this subscription.
	 *
	 * @return the status of this subscription
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this subscription.
	 *
	 * @return the status by user ID of this subscription
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this subscription.
	 *
	 * @return the status by user name of this subscription
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this subscription.
	 *
	 * @return the status by user uuid of this subscription
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this subscription.
	 *
	 * @return the status date of this subscription
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subscription ID of this subscription.
	 *
	 * @return the subscription ID of this subscription
	 */
	@Override
	public long getSubscriptionId() {
		return model.getSubscriptionId();
	}

	/**
	 * Returns the token of this subscription.
	 *
	 * @return the token of this subscription
	 */
	@Override
	public String getToken() {
		return model.getToken();
	}

	/**
	 * Returns the user ID of this subscription.
	 *
	 * @return the user ID of this subscription
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this subscription.
	 *
	 * @return the user name of this subscription
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this subscription.
	 *
	 * @return the user uuid of this subscription
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this subscription.
	 *
	 * @return the uuid of this subscription
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this subscription is approved.
	 *
	 * @return <code>true</code> if this subscription is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this subscription is denied.
	 *
	 * @return <code>true</code> if this subscription is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this subscription is a draft.
	 *
	 * @return <code>true</code> if this subscription is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this subscription is expired.
	 *
	 * @return <code>true</code> if this subscription is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this subscription is inactive.
	 *
	 * @return <code>true</code> if this subscription is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this subscription is incomplete.
	 *
	 * @return <code>true</code> if this subscription is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this subscription is pending.
	 *
	 * @return <code>true</code> if this subscription is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this subscription is scheduled.
	 *
	 * @return <code>true</code> if this subscription is scheduled; <code>false</code> otherwise
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
	 * Sets the company ID of this subscription.
	 *
	 * @param companyId the company ID of this subscription
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the connection ID of this subscription.
	 *
	 * @param connectionId the connection ID of this subscription
	 */
	@Override
	public void setConnectionId(String connectionId) {
		model.setConnectionId(connectionId);
	}

	/**
	 * Sets the connection state of this subscription.
	 *
	 * @param connectionState the connection state of this subscription
	 */
	@Override
	public void setConnectionState(String connectionState) {
		model.setConnectionState(connectionState);
	}

	/**
	 * Sets the create date of this subscription.
	 *
	 * @param createDate the create date of this subscription
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this subscription.
	 *
	 * @param groupId the group ID of this subscription
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this subscription.
	 *
	 * @param modifiedDate the modified date of this subscription
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this subscription.
	 *
	 * @param primaryKey the primary key of this subscription
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the socket address of this subscription.
	 *
	 * @param socketAddress the socket address of this subscription
	 */
	@Override
	public void setSocketAddress(String socketAddress) {
		model.setSocketAddress(socketAddress);
	}

	/**
	 * Sets the status of this subscription.
	 *
	 * @param status the status of this subscription
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this subscription.
	 *
	 * @param statusByUserId the status by user ID of this subscription
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this subscription.
	 *
	 * @param statusByUserName the status by user name of this subscription
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this subscription.
	 *
	 * @param statusByUserUuid the status by user uuid of this subscription
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this subscription.
	 *
	 * @param statusDate the status date of this subscription
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subscription ID of this subscription.
	 *
	 * @param subscriptionId the subscription ID of this subscription
	 */
	@Override
	public void setSubscriptionId(long subscriptionId) {
		model.setSubscriptionId(subscriptionId);
	}

	/**
	 * Sets the token of this subscription.
	 *
	 * @param token the token of this subscription
	 */
	@Override
	public void setToken(String token) {
		model.setToken(token);
	}

	/**
	 * Sets the user ID of this subscription.
	 *
	 * @param userId the user ID of this subscription
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this subscription.
	 *
	 * @param userName the user name of this subscription
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this subscription.
	 *
	 * @param userUuid the user uuid of this subscription
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this subscription.
	 *
	 * @param uuid the uuid of this subscription
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
	protected SubscriptionWrapper wrap(Subscription subscription) {
		return new SubscriptionWrapper(subscription);
	}

}