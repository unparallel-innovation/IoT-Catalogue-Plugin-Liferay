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
import com.iot_catalogue.model.ElementEntityModel;
import com.iot_catalogue.model.ElementEntitySoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ElementEntity service. Represents a row in the &quot;IoTCatalogue_ElementEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ElementEntityModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ElementEntityImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntityImpl
 * @generated
 */
@JSON(strict = true)
public class ElementEntityModelImpl
	extends BaseModelImpl<ElementEntity> implements ElementEntityModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a element entity model instance should use the <code>ElementEntity</code> interface instead.
	 */
	public static final String TABLE_NAME = "IoTCatalogue_ElementEntity";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"elementEntityId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"status", Types.INTEGER}, {"statusByUserId", Types.BIGINT},
		{"statusByUserName", Types.VARCHAR}, {"statusDate", Types.TIMESTAMP},
		{"elementOriginalId", Types.VARCHAR},
		{"elementClassName", Types.VARCHAR}, {"name", Types.VARCHAR},
		{"website", Types.VARCHAR}, {"label", Types.VARCHAR},
		{"subscriptionId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("elementEntityId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("statusByUserId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("statusByUserName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("statusDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("elementOriginalId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("elementClassName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("website", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("label", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("subscriptionId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table IoTCatalogue_ElementEntity (uuid_ VARCHAR(75) null,elementEntityId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,elementOriginalId VARCHAR(75) null,elementClassName VARCHAR(75) null,name VARCHAR(1000) null,website VARCHAR(75) null,label VARCHAR(75) null,subscriptionId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table IoTCatalogue_ElementEntity";

	public static final String ORDER_BY_JPQL =
		" ORDER BY elementEntity.elementEntityId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY IoTCatalogue_ElementEntity.elementEntityId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ELEMENTCLASSNAME_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ELEMENTORIGINALID_COLUMN_BITMASK = 4L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long GROUPID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long LABEL_COLUMN_BITMASK = 16L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STATUS_COLUMN_BITMASK = 32L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long SUBSCRIPTIONID_COLUMN_BITMASK = 64L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 128L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long ELEMENTENTITYID_COLUMN_BITMASK = 256L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static ElementEntity toModel(ElementEntitySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ElementEntity model = new ElementEntityImpl();

		model.setUuid(soapModel.getUuid());
		model.setElementEntityId(soapModel.getElementEntityId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setElementOriginalId(soapModel.getElementOriginalId());
		model.setElementClassName(soapModel.getElementClassName());
		model.setName(soapModel.getName());
		model.setWebsite(soapModel.getWebsite());
		model.setLabel(soapModel.getLabel());
		model.setSubscriptionId(soapModel.getSubscriptionId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<ElementEntity> toModels(ElementEntitySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<ElementEntity> models = new ArrayList<ElementEntity>(
			soapModels.length);

		for (ElementEntitySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ElementEntityModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _elementEntityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setElementEntityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _elementEntityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ElementEntity.class;
	}

	@Override
	public String getModelClassName() {
		return ElementEntity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ElementEntity, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ElementEntity, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ElementEntity, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ElementEntity)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ElementEntity, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ElementEntity, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ElementEntity)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ElementEntity, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ElementEntity, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ElementEntity>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ElementEntity.class.getClassLoader(), ElementEntity.class,
			ModelWrapper.class);

		try {
			Constructor<ElementEntity> constructor =
				(Constructor<ElementEntity>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<ElementEntity, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ElementEntity, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ElementEntity, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<ElementEntity, Object>>();
		Map<String, BiConsumer<ElementEntity, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ElementEntity, ?>>();

		attributeGetterFunctions.put("uuid", ElementEntity::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<ElementEntity, String>)ElementEntity::setUuid);
		attributeGetterFunctions.put(
			"elementEntityId", ElementEntity::getElementEntityId);
		attributeSetterBiConsumers.put(
			"elementEntityId",
			(BiConsumer<ElementEntity, Long>)ElementEntity::setElementEntityId);
		attributeGetterFunctions.put("groupId", ElementEntity::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ElementEntity, Long>)ElementEntity::setGroupId);
		attributeGetterFunctions.put("companyId", ElementEntity::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ElementEntity, Long>)ElementEntity::setCompanyId);
		attributeGetterFunctions.put("userId", ElementEntity::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ElementEntity, Long>)ElementEntity::setUserId);
		attributeGetterFunctions.put("userName", ElementEntity::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ElementEntity, String>)ElementEntity::setUserName);
		attributeGetterFunctions.put(
			"createDate", ElementEntity::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ElementEntity, Date>)ElementEntity::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ElementEntity::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ElementEntity, Date>)ElementEntity::setModifiedDate);
		attributeGetterFunctions.put("status", ElementEntity::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<ElementEntity, Integer>)ElementEntity::setStatus);
		attributeGetterFunctions.put(
			"statusByUserId", ElementEntity::getStatusByUserId);
		attributeSetterBiConsumers.put(
			"statusByUserId",
			(BiConsumer<ElementEntity, Long>)ElementEntity::setStatusByUserId);
		attributeGetterFunctions.put(
			"statusByUserName", ElementEntity::getStatusByUserName);
		attributeSetterBiConsumers.put(
			"statusByUserName",
			(BiConsumer<ElementEntity, String>)
				ElementEntity::setStatusByUserName);
		attributeGetterFunctions.put(
			"statusDate", ElementEntity::getStatusDate);
		attributeSetterBiConsumers.put(
			"statusDate",
			(BiConsumer<ElementEntity, Date>)ElementEntity::setStatusDate);
		attributeGetterFunctions.put(
			"elementOriginalId", ElementEntity::getElementOriginalId);
		attributeSetterBiConsumers.put(
			"elementOriginalId",
			(BiConsumer<ElementEntity, String>)
				ElementEntity::setElementOriginalId);
		attributeGetterFunctions.put(
			"elementClassName", ElementEntity::getElementClassName);
		attributeSetterBiConsumers.put(
			"elementClassName",
			(BiConsumer<ElementEntity, String>)
				ElementEntity::setElementClassName);
		attributeGetterFunctions.put("name", ElementEntity::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<ElementEntity, String>)ElementEntity::setName);
		attributeGetterFunctions.put("website", ElementEntity::getWebsite);
		attributeSetterBiConsumers.put(
			"website",
			(BiConsumer<ElementEntity, String>)ElementEntity::setWebsite);
		attributeGetterFunctions.put("label", ElementEntity::getLabel);
		attributeSetterBiConsumers.put(
			"label",
			(BiConsumer<ElementEntity, String>)ElementEntity::setLabel);
		attributeGetterFunctions.put(
			"subscriptionId", ElementEntity::getSubscriptionId);
		attributeSetterBiConsumers.put(
			"subscriptionId",
			(BiConsumer<ElementEntity, Long>)ElementEntity::setSubscriptionId);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getElementEntityId() {
		return _elementEntityId;
	}

	@Override
	public void setElementEntityId(long elementEntityId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_elementEntityId = elementEntityId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_groupId = groupId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalGroupId() {
		return GetterUtil.getLong(this.<Long>getColumnOriginalValue("groupId"));
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_companyId = companyId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalCompanyId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("companyId"));
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_status = status;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public int getOriginalStatus() {
		return GetterUtil.getInteger(
			this.<Integer>getColumnOriginalValue("status"));
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getStatusByUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return "";
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_statusDate = statusDate;
	}

	@JSON
	@Override
	public String getElementOriginalId() {
		if (_elementOriginalId == null) {
			return "";
		}
		else {
			return _elementOriginalId;
		}
	}

	@Override
	public void setElementOriginalId(String elementOriginalId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_elementOriginalId = elementOriginalId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalElementOriginalId() {
		return getColumnOriginalValue("elementOriginalId");
	}

	@JSON
	@Override
	public String getElementClassName() {
		if (_elementClassName == null) {
			return "";
		}
		else {
			return _elementClassName;
		}
	}

	@Override
	public void setElementClassName(String elementClassName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_elementClassName = elementClassName;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalElementClassName() {
		return getColumnOriginalValue("elementClassName");
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_name = name;
	}

	@JSON
	@Override
	public String getWebsite() {
		if (_website == null) {
			return "";
		}
		else {
			return _website;
		}
	}

	@Override
	public void setWebsite(String website) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_website = website;
	}

	@JSON
	@Override
	public String getLabel() {
		if (_label == null) {
			return "";
		}
		else {
			return _label;
		}
	}

	@Override
	public void setLabel(String label) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_label = label;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalLabel() {
		return getColumnOriginalValue("label");
	}

	@JSON
	@Override
	public long getSubscriptionId() {
		return _subscriptionId;
	}

	@Override
	public void setSubscriptionId(long subscriptionId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_subscriptionId = subscriptionId;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public long getOriginalSubscriptionId() {
		return GetterUtil.getLong(
			this.<Long>getColumnOriginalValue("subscriptionId"));
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ElementEntity.class.getName()));
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (entry.getValue() != getColumnValue(entry.getKey())) {
				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ElementEntity.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ElementEntity toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ElementEntity>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ElementEntityImpl elementEntityImpl = new ElementEntityImpl();

		elementEntityImpl.setUuid(getUuid());
		elementEntityImpl.setElementEntityId(getElementEntityId());
		elementEntityImpl.setGroupId(getGroupId());
		elementEntityImpl.setCompanyId(getCompanyId());
		elementEntityImpl.setUserId(getUserId());
		elementEntityImpl.setUserName(getUserName());
		elementEntityImpl.setCreateDate(getCreateDate());
		elementEntityImpl.setModifiedDate(getModifiedDate());
		elementEntityImpl.setStatus(getStatus());
		elementEntityImpl.setStatusByUserId(getStatusByUserId());
		elementEntityImpl.setStatusByUserName(getStatusByUserName());
		elementEntityImpl.setStatusDate(getStatusDate());
		elementEntityImpl.setElementOriginalId(getElementOriginalId());
		elementEntityImpl.setElementClassName(getElementClassName());
		elementEntityImpl.setName(getName());
		elementEntityImpl.setWebsite(getWebsite());
		elementEntityImpl.setLabel(getLabel());
		elementEntityImpl.setSubscriptionId(getSubscriptionId());

		elementEntityImpl.resetOriginalValues();

		return elementEntityImpl;
	}

	@Override
	public int compareTo(ElementEntity elementEntity) {
		long primaryKey = elementEntity.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElementEntity)) {
			return false;
		}

		ElementEntity elementEntity = (ElementEntity)object;

		long primaryKey = elementEntity.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_setModifiedDate = false;

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<ElementEntity> toCacheModel() {
		ElementEntityCacheModel elementEntityCacheModel =
			new ElementEntityCacheModel();

		elementEntityCacheModel.uuid = getUuid();

		String uuid = elementEntityCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			elementEntityCacheModel.uuid = null;
		}

		elementEntityCacheModel.elementEntityId = getElementEntityId();

		elementEntityCacheModel.groupId = getGroupId();

		elementEntityCacheModel.companyId = getCompanyId();

		elementEntityCacheModel.userId = getUserId();

		elementEntityCacheModel.userName = getUserName();

		String userName = elementEntityCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			elementEntityCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			elementEntityCacheModel.createDate = createDate.getTime();
		}
		else {
			elementEntityCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			elementEntityCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			elementEntityCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		elementEntityCacheModel.status = getStatus();

		elementEntityCacheModel.statusByUserId = getStatusByUserId();

		elementEntityCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = elementEntityCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			elementEntityCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			elementEntityCacheModel.statusDate = statusDate.getTime();
		}
		else {
			elementEntityCacheModel.statusDate = Long.MIN_VALUE;
		}

		elementEntityCacheModel.elementOriginalId = getElementOriginalId();

		String elementOriginalId = elementEntityCacheModel.elementOriginalId;

		if ((elementOriginalId != null) && (elementOriginalId.length() == 0)) {
			elementEntityCacheModel.elementOriginalId = null;
		}

		elementEntityCacheModel.elementClassName = getElementClassName();

		String elementClassName = elementEntityCacheModel.elementClassName;

		if ((elementClassName != null) && (elementClassName.length() == 0)) {
			elementEntityCacheModel.elementClassName = null;
		}

		elementEntityCacheModel.name = getName();

		String name = elementEntityCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			elementEntityCacheModel.name = null;
		}

		elementEntityCacheModel.website = getWebsite();

		String website = elementEntityCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			elementEntityCacheModel.website = null;
		}

		elementEntityCacheModel.label = getLabel();

		String label = elementEntityCacheModel.label;

		if ((label != null) && (label.length() == 0)) {
			elementEntityCacheModel.label = null;
		}

		elementEntityCacheModel.subscriptionId = getSubscriptionId();

		return elementEntityCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ElementEntity, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ElementEntity, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ElementEntity, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ElementEntity)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<ElementEntity, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ElementEntity, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ElementEntity, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ElementEntity)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ElementEntity>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private long _elementEntityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _elementOriginalId;
	private String _elementClassName;
	private String _name;
	private String _website;
	private String _label;
	private long _subscriptionId;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<ElementEntity, Object> function =
			_attributeGetterFunctions.get(columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((ElementEntity)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("elementEntityId", _elementEntityId);
		_columnOriginalValues.put("groupId", _groupId);
		_columnOriginalValues.put("companyId", _companyId);
		_columnOriginalValues.put("userId", _userId);
		_columnOriginalValues.put("userName", _userName);
		_columnOriginalValues.put("createDate", _createDate);
		_columnOriginalValues.put("modifiedDate", _modifiedDate);
		_columnOriginalValues.put("status", _status);
		_columnOriginalValues.put("statusByUserId", _statusByUserId);
		_columnOriginalValues.put("statusByUserName", _statusByUserName);
		_columnOriginalValues.put("statusDate", _statusDate);
		_columnOriginalValues.put("elementOriginalId", _elementOriginalId);
		_columnOriginalValues.put("elementClassName", _elementClassName);
		_columnOriginalValues.put("name", _name);
		_columnOriginalValues.put("website", _website);
		_columnOriginalValues.put("label", _label);
		_columnOriginalValues.put("subscriptionId", _subscriptionId);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("elementEntityId", 2L);

		columnBitmasks.put("groupId", 4L);

		columnBitmasks.put("companyId", 8L);

		columnBitmasks.put("userId", 16L);

		columnBitmasks.put("userName", 32L);

		columnBitmasks.put("createDate", 64L);

		columnBitmasks.put("modifiedDate", 128L);

		columnBitmasks.put("status", 256L);

		columnBitmasks.put("statusByUserId", 512L);

		columnBitmasks.put("statusByUserName", 1024L);

		columnBitmasks.put("statusDate", 2048L);

		columnBitmasks.put("elementOriginalId", 4096L);

		columnBitmasks.put("elementClassName", 8192L);

		columnBitmasks.put("name", 16384L);

		columnBitmasks.put("website", 32768L);

		columnBitmasks.put("label", 65536L);

		columnBitmasks.put("subscriptionId", 131072L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private ElementEntity _escapedModel;

}