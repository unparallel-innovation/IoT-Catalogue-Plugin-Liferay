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
 * The base model interface for the ElementCoordinate service. Represents a row in the &quot;IoTCatalogue_ElementCoordinate&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.iot_catalogue.model.impl.ElementCoordinateModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.iot_catalogue.model.impl.ElementCoordinateImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementCoordinate
 * @generated
 */
@ProviderType
public interface ElementCoordinateModel
	extends BaseModel<ElementCoordinate>, GroupedModel, ShardedModel,
			StagedAuditedModel, WorkflowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a element coordinate model instance should use the {@link ElementCoordinate} interface instead.
	 */

	/**
	 * Returns the primary key of this element coordinate.
	 *
	 * @return the primary key of this element coordinate
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this element coordinate.
	 *
	 * @param primaryKey the primary key of this element coordinate
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this element coordinate.
	 *
	 * @return the uuid of this element coordinate
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this element coordinate.
	 *
	 * @param uuid the uuid of this element coordinate
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the element coordinate ID of this element coordinate.
	 *
	 * @return the element coordinate ID of this element coordinate
	 */
	public long getElementCoordinateId();

	/**
	 * Sets the element coordinate ID of this element coordinate.
	 *
	 * @param elementCoordinateId the element coordinate ID of this element coordinate
	 */
	public void setElementCoordinateId(long elementCoordinateId);

	/**
	 * Returns the group ID of this element coordinate.
	 *
	 * @return the group ID of this element coordinate
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this element coordinate.
	 *
	 * @param groupId the group ID of this element coordinate
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this element coordinate.
	 *
	 * @return the company ID of this element coordinate
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this element coordinate.
	 *
	 * @param companyId the company ID of this element coordinate
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this element coordinate.
	 *
	 * @return the user ID of this element coordinate
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this element coordinate.
	 *
	 * @param userId the user ID of this element coordinate
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this element coordinate.
	 *
	 * @return the user uuid of this element coordinate
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this element coordinate.
	 *
	 * @param userUuid the user uuid of this element coordinate
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this element coordinate.
	 *
	 * @return the user name of this element coordinate
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this element coordinate.
	 *
	 * @param userName the user name of this element coordinate
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this element coordinate.
	 *
	 * @return the create date of this element coordinate
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this element coordinate.
	 *
	 * @param createDate the create date of this element coordinate
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this element coordinate.
	 *
	 * @return the modified date of this element coordinate
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this element coordinate.
	 *
	 * @param modifiedDate the modified date of this element coordinate
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this element coordinate.
	 *
	 * @return the status of this element coordinate
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this element coordinate.
	 *
	 * @param status the status of this element coordinate
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this element coordinate.
	 *
	 * @return the status by user ID of this element coordinate
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this element coordinate.
	 *
	 * @param statusByUserId the status by user ID of this element coordinate
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this element coordinate.
	 *
	 * @return the status by user uuid of this element coordinate
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this element coordinate.
	 *
	 * @param statusByUserUuid the status by user uuid of this element coordinate
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this element coordinate.
	 *
	 * @return the status by user name of this element coordinate
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this element coordinate.
	 *
	 * @param statusByUserName the status by user name of this element coordinate
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this element coordinate.
	 *
	 * @return the status date of this element coordinate
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this element coordinate.
	 *
	 * @param statusDate the status date of this element coordinate
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the element original ID of this element coordinate.
	 *
	 * @return the element original ID of this element coordinate
	 */
	@AutoEscape
	public String getElementOriginalId();

	/**
	 * Sets the element original ID of this element coordinate.
	 *
	 * @param elementOriginalId the element original ID of this element coordinate
	 */
	public void setElementOriginalId(String elementOriginalId);

	/**
	 * Returns the element class name of this element coordinate.
	 *
	 * @return the element class name of this element coordinate
	 */
	@AutoEscape
	public String getElementClassName();

	/**
	 * Sets the element class name of this element coordinate.
	 *
	 * @param elementClassName the element class name of this element coordinate
	 */
	public void setElementClassName(String elementClassName);

	/**
	 * Returns the latitude of this element coordinate.
	 *
	 * @return the latitude of this element coordinate
	 */
	public double getLatitude();

	/**
	 * Sets the latitude of this element coordinate.
	 *
	 * @param latitude the latitude of this element coordinate
	 */
	public void setLatitude(double latitude);

	/**
	 * Returns the longitude of this element coordinate.
	 *
	 * @return the longitude of this element coordinate
	 */
	public double getLongitude();

	/**
	 * Sets the longitude of this element coordinate.
	 *
	 * @param longitude the longitude of this element coordinate
	 */
	public void setLongitude(double longitude);

	/**
	 * Returns the subscription ID of this element coordinate.
	 *
	 * @return the subscription ID of this element coordinate
	 */
	public long getSubscriptionId();

	/**
	 * Sets the subscription ID of this element coordinate.
	 *
	 * @param subscriptionId the subscription ID of this element coordinate
	 */
	public void setSubscriptionId(long subscriptionId);

	/**
	 * Returns <code>true</code> if this element coordinate is approved.
	 *
	 * @return <code>true</code> if this element coordinate is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this element coordinate is denied.
	 *
	 * @return <code>true</code> if this element coordinate is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this element coordinate is a draft.
	 *
	 * @return <code>true</code> if this element coordinate is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this element coordinate is expired.
	 *
	 * @return <code>true</code> if this element coordinate is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this element coordinate is inactive.
	 *
	 * @return <code>true</code> if this element coordinate is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this element coordinate is incomplete.
	 *
	 * @return <code>true</code> if this element coordinate is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this element coordinate is pending.
	 *
	 * @return <code>true</code> if this element coordinate is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this element coordinate is scheduled.
	 *
	 * @return <code>true</code> if this element coordinate is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

}