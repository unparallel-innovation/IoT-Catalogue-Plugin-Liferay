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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.iot_catalogue.service.http.SubscriptionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SubscriptionSoap implements Serializable {

	public static SubscriptionSoap toSoapModel(Subscription model) {
		SubscriptionSoap soapModel = new SubscriptionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSubscriptionId(model.getSubscriptionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setConnectionId(model.getConnectionId());
		soapModel.setConnectionState(model.getConnectionState());
		soapModel.setToken(model.getToken());
		soapModel.setSocketAddress(model.getSocketAddress());

		return soapModel;
	}

	public static SubscriptionSoap[] toSoapModels(Subscription[] models) {
		SubscriptionSoap[] soapModels = new SubscriptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubscriptionSoap[][] toSoapModels(Subscription[][] models) {
		SubscriptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubscriptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubscriptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubscriptionSoap[] toSoapModels(List<Subscription> models) {
		List<SubscriptionSoap> soapModels = new ArrayList<SubscriptionSoap>(
			models.size());

		for (Subscription model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubscriptionSoap[soapModels.size()]);
	}

	public SubscriptionSoap() {
	}

	public long getPrimaryKey() {
		return _subscriptionId;
	}

	public void setPrimaryKey(long pk) {
		setSubscriptionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSubscriptionId() {
		return _subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		_subscriptionId = subscriptionId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getConnectionId() {
		return _connectionId;
	}

	public void setConnectionId(String connectionId) {
		_connectionId = connectionId;
	}

	public String getConnectionState() {
		return _connectionState;
	}

	public void setConnectionState(String connectionState) {
		_connectionState = connectionState;
	}

	public String getToken() {
		return _token;
	}

	public void setToken(String token) {
		_token = token;
	}

	public String getSocketAddress() {
		return _socketAddress;
	}

	public void setSocketAddress(String socketAddress) {
		_socketAddress = socketAddress;
	}

	private String _uuid;
	private long _subscriptionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _connectionId;
	private String _connectionState;
	private String _token;
	private String _socketAddress;

}