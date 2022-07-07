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
 * This class is used by SOAP remote services, specifically {@link com.iot_catalogue.service.http.IoTComponentServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class IoTComponentSoap implements Serializable {

	public static IoTComponentSoap toSoapModel(IoTComponent model) {
		IoTComponentSoap soapModel = new IoTComponentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIotComponentId(model.getIotComponentId());
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
		soapModel.setOriginalId(model.getOriginalId());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setEmbeddedUrl(model.getEmbeddedUrl());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setElementStatus(model.getElementStatus());
		soapModel.setSubscriptionId(model.getSubscriptionId());

		return soapModel;
	}

	public static IoTComponentSoap[] toSoapModels(IoTComponent[] models) {
		IoTComponentSoap[] soapModels = new IoTComponentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static IoTComponentSoap[][] toSoapModels(IoTComponent[][] models) {
		IoTComponentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new IoTComponentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new IoTComponentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static IoTComponentSoap[] toSoapModels(List<IoTComponent> models) {
		List<IoTComponentSoap> soapModels = new ArrayList<IoTComponentSoap>(
			models.size());

		for (IoTComponent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new IoTComponentSoap[soapModels.size()]);
	}

	public IoTComponentSoap() {
	}

	public long getPrimaryKey() {
		return _iotComponentId;
	}

	public void setPrimaryKey(long pk) {
		setIotComponentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIotComponentId() {
		return _iotComponentId;
	}

	public void setIotComponentId(long iotComponentId) {
		_iotComponentId = iotComponentId;
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

	public String getOriginalId() {
		return _originalId;
	}

	public void setOriginalId(String originalId) {
		_originalId = originalId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getEmbeddedUrl() {
		return _embeddedUrl;
	}

	public void setEmbeddedUrl(String embeddedUrl) {
		_embeddedUrl = embeddedUrl;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getElementStatus() {
		return _elementStatus;
	}

	public void setElementStatus(String elementStatus) {
		_elementStatus = elementStatus;
	}

	public long getSubscriptionId() {
		return _subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		_subscriptionId = subscriptionId;
	}

	private String _uuid;
	private long _iotComponentId;
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
	private String _originalId;
	private String _name;
	private String _description;
	private String _embeddedUrl;
	private String _imageUrl;
	private String _elementStatus;
	private long _subscriptionId;

}