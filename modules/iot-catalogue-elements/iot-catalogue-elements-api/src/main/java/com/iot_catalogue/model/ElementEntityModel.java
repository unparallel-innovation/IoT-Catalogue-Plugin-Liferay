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
 * The base model interface for the ElementEntity service. Represents a row in the &quot;IoTCatalogue_ElementEntity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.iot_catalogue.model.impl.ElementEntityModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.iot_catalogue.model.impl.ElementEntityImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntity
 * @generated
 */
@ProviderType
public interface ElementEntityModel
	extends BaseModel<ElementEntity>, GroupedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a element entity model instance should use the {@link ElementEntity} interface instead.
	 */

	/**
	 * Returns the primary key of this element entity.
	 *
	 * @return the primary key of this element entity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this element entity.
	 *
	 * @param primaryKey the primary key of this element entity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this element entity.
	 *
	 * @return the uuid of this element entity
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this element entity.
	 *
	 * @param uuid the uuid of this element entity
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the element entity ID of this element entity.
	 *
	 * @return the element entity ID of this element entity
	 */
	public long getElementEntityId();

	/**
	 * Sets the element entity ID of this element entity.
	 *
	 * @param elementEntityId the element entity ID of this element entity
	 */
	public void setElementEntityId(long elementEntityId);

	/**
	 * Returns the group ID of this element entity.
	 *
	 * @return the group ID of this element entity
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this element entity.
	 *
	 * @param groupId the group ID of this element entity
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this element entity.
	 *
	 * @return the company ID of this element entity
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this element entity.
	 *
	 * @param companyId the company ID of this element entity
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this element entity.
	 *
	 * @return the user ID of this element entity
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this element entity.
	 *
	 * @param userId the user ID of this element entity
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this element entity.
	 *
	 * @return the user uuid of this element entity
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this element entity.
	 *
	 * @param userUuid the user uuid of this element entity
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this element entity.
	 *
	 * @return the user name of this element entity
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this element entity.
	 *
	 * @param userName the user name of this element entity
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this element entity.
	 *
	 * @return the create date of this element entity
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this element entity.
	 *
	 * @param createDate the create date of this element entity
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this element entity.
	 *
	 * @return the modified date of this element entity
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this element entity.
	 *
	 * @param modifiedDate the modified date of this element entity
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this element entity.
	 *
	 * @return the status of this element entity
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this element entity.
	 *
	 * @param status the status of this element entity
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this element entity.
	 *
	 * @return the status by user ID of this element entity
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this element entity.
	 *
	 * @param statusByUserId the status by user ID of this element entity
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this element entity.
	 *
	 * @return the status by user uuid of this element entity
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this element entity.
	 *
	 * @param statusByUserUuid the status by user uuid of this element entity
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this element entity.
	 *
	 * @return the status by user name of this element entity
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this element entity.
	 *
	 * @param statusByUserName the status by user name of this element entity
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this element entity.
	 *
	 * @return the status date of this element entity
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this element entity.
	 *
	 * @param statusDate the status date of this element entity
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the element original ID of this element entity.
	 *
	 * @return the element original ID of this element entity
	 */
	@AutoEscape
	public String getElementOriginalId();

	/**
	 * Sets the element original ID of this element entity.
	 *
	 * @param elementOriginalId the element original ID of this element entity
	 */
	public void setElementOriginalId(String elementOriginalId);

	/**
	 * Returns the element class name of this element entity.
	 *
	 * @return the element class name of this element entity
	 */
	@AutoEscape
	public String getElementClassName();

	/**
	 * Sets the element class name of this element entity.
	 *
	 * @param elementClassName the element class name of this element entity
	 */
	public void setElementClassName(String elementClassName);

	/**
	 * Returns the name of this element entity.
	 *
	 * @return the name of this element entity
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this element entity.
	 *
	 * @param name the name of this element entity
	 */
	public void setName(String name);

	/**
	 * Returns the website of this element entity.
	 *
	 * @return the website of this element entity
	 */
	@AutoEscape
	public String getWebsite();

	/**
	 * Sets the website of this element entity.
	 *
	 * @param website the website of this element entity
	 */
	public void setWebsite(String website);

	/**
	 * Returns the label of this element entity.
	 *
	 * @return the label of this element entity
	 */
	@AutoEscape
	public String getLabel();

	/**
	 * Sets the label of this element entity.
	 *
	 * @param label the label of this element entity
	 */
	public void setLabel(String label);

	/**
	 * Returns the subscription ID of this element entity.
	 *
	 * @return the subscription ID of this element entity
	 */
	public long getSubscriptionId();

	/**
	 * Sets the subscription ID of this element entity.
	 *
	 * @param subscriptionId the subscription ID of this element entity
	 */
	public void setSubscriptionId(long subscriptionId);

	/**
	 * Returns <code>true</code> if this element entity is approved.
	 *
	 * @return <code>true</code> if this element entity is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this element entity is denied.
	 *
	 * @return <code>true</code> if this element entity is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this element entity is a draft.
	 *
	 * @return <code>true</code> if this element entity is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this element entity is expired.
	 *
	 * @return <code>true</code> if this element entity is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this element entity is inactive.
	 *
	 * @return <code>true</code> if this element entity is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this element entity is incomplete.
	 *
	 * @return <code>true</code> if this element entity is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this element entity is pending.
	 *
	 * @return <code>true</code> if this element entity is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this element entity is scheduled.
	 *
	 * @return <code>true</code> if this element entity is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}