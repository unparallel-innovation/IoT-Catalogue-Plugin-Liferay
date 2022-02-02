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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ComponentChild service. Represents a row in the &quot;IoTCatalogue_ComponentChild&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.iot_catalogue.model.impl.ComponentChildModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.iot_catalogue.model.impl.ComponentChildImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComponentChild
 * @generated
 */
@ProviderType
public interface ComponentChildModel
	extends BaseModel<ComponentChild>, GroupedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a component child model instance should use the {@link ComponentChild} interface instead.
	 */

	/**
	 * Returns the primary key of this component child.
	 *
	 * @return the primary key of this component child
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this component child.
	 *
	 * @param primaryKey the primary key of this component child
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this component child.
	 *
	 * @return the uuid of this component child
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this component child.
	 *
	 * @param uuid the uuid of this component child
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the ID of this component child.
	 *
	 * @return the ID of this component child
	 */
	public long getId();

	/**
	 * Sets the ID of this component child.
	 *
	 * @param id the ID of this component child
	 */
	public void setId(long id);

	/**
	 * Returns the group ID of this component child.
	 *
	 * @return the group ID of this component child
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this component child.
	 *
	 * @param groupId the group ID of this component child
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this component child.
	 *
	 * @return the company ID of this component child
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this component child.
	 *
	 * @param companyId the company ID of this component child
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this component child.
	 *
	 * @return the user ID of this component child
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this component child.
	 *
	 * @param userId the user ID of this component child
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this component child.
	 *
	 * @return the user uuid of this component child
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this component child.
	 *
	 * @param userUuid the user uuid of this component child
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this component child.
	 *
	 * @return the user name of this component child
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this component child.
	 *
	 * @param userName the user name of this component child
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this component child.
	 *
	 * @return the create date of this component child
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this component child.
	 *
	 * @param createDate the create date of this component child
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this component child.
	 *
	 * @return the modified date of this component child
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this component child.
	 *
	 * @param modifiedDate the modified date of this component child
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this component child.
	 *
	 * @return the status of this component child
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this component child.
	 *
	 * @param status the status of this component child
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this component child.
	 *
	 * @return the status by user ID of this component child
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this component child.
	 *
	 * @param statusByUserId the status by user ID of this component child
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this component child.
	 *
	 * @return the status by user uuid of this component child
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this component child.
	 *
	 * @param statusByUserUuid the status by user uuid of this component child
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this component child.
	 *
	 * @return the status by user name of this component child
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this component child.
	 *
	 * @param statusByUserName the status by user name of this component child
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this component child.
	 *
	 * @return the status date of this component child
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this component child.
	 *
	 * @param statusDate the status date of this component child
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the component orignal ID of this component child.
	 *
	 * @return the component orignal ID of this component child
	 */
	@AutoEscape
	public String getComponentOrignalId();

	/**
	 * Sets the component orignal ID of this component child.
	 *
	 * @param componentOrignalId the component orignal ID of this component child
	 */
	public void setComponentOrignalId(String componentOrignalId);

	/**
	 * Returns the child component original ID of this component child.
	 *
	 * @return the child component original ID of this component child
	 */
	@AutoEscape
	public String getChildComponentOriginalId();

	/**
	 * Sets the child component original ID of this component child.
	 *
	 * @param childComponentOriginalId the child component original ID of this component child
	 */
	public void setChildComponentOriginalId(String childComponentOriginalId);

	/**
	 * Returns the subscription ID of this component child.
	 *
	 * @return the subscription ID of this component child
	 */
	public long getSubscriptionId();

	/**
	 * Sets the subscription ID of this component child.
	 *
	 * @param subscriptionId the subscription ID of this component child
	 */
	public void setSubscriptionId(long subscriptionId);

	/**
	 * Returns <code>true</code> if this component child is approved.
	 *
	 * @return <code>true</code> if this component child is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this component child is denied.
	 *
	 * @return <code>true</code> if this component child is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this component child is a draft.
	 *
	 * @return <code>true</code> if this component child is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this component child is expired.
	 *
	 * @return <code>true</code> if this component child is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this component child is inactive.
	 *
	 * @return <code>true</code> if this component child is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this component child is incomplete.
	 *
	 * @return <code>true</code> if this component child is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this component child is pending.
	 *
	 * @return <code>true</code> if this component child is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this component child is scheduled.
	 *
	 * @return <code>true</code> if this component child is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}