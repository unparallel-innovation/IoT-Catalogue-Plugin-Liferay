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

package com.iot_catalogue.service.persistence;

import com.iot_catalogue.exception.NoSuchIoTComponentException;
import com.iot_catalogue.model.IoTComponent;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the io t component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IoTComponentUtil
 * @generated
 */
@ProviderType
public interface IoTComponentPersistence extends BasePersistence<IoTComponent> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IoTComponentUtil} to access the io t component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the io t components where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching io t components
	 */
	public java.util.List<IoTComponent> findByUuid(String uuid);

	/**
	 * Returns a range of all the io t components where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	public java.util.List<IoTComponent> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the io t components where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the io t components where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the first io t component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the last io t component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the last io t component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where uuid = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent[] findByUuid_PrevAndNext(
			long iotComponentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Removes all the io t components where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of io t components where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching io t components
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the io t component where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIoTComponentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByUUID_G(String uuid, long groupId)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the io t component where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the io t component where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the io t component where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the io t component that was removed
	 */
	public IoTComponent removeByUUID_G(String uuid, long groupId)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the number of io t components where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching io t components
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching io t components
	 */
	public java.util.List<IoTComponent> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	public java.util.List<IoTComponent> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the first io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the last io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the last io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent[] findByUuid_C_PrevAndNext(
			long iotComponentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Removes all the io t components where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching io t components
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the io t components where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t components
	 */
	public java.util.List<IoTComponent> findByGroupId(long groupId);

	/**
	 * Returns a range of all the io t components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	public java.util.List<IoTComponent> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the io t components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the io t components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the first io t component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the last io t component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the last io t component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where groupId = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent[] findByGroupId_PrevAndNext(
			long iotComponentId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns all the io t components that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t components that the user has permission to view
	 */
	public java.util.List<IoTComponent> filterFindByGroupId(long groupId);

	/**
	 * Returns a range of all the io t components that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components that the user has permission to view
	 */
	public java.util.List<IoTComponent> filterFindByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the io t components that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components that the user has permission to view
	 */
	public java.util.List<IoTComponent> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the io t components before and after the current io t component in the ordered set of io t components that the user has permission to view where groupId = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent[] filterFindByGroupId_PrevAndNext(
			long iotComponentId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Removes all the io t components where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of io t components where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t components
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of io t components that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t components that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns the io t component where originalId = &#63; or throws a <code>NoSuchIoTComponentException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @return the matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByOriginalId(String originalId)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the io t component where originalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByOriginalId(String originalId);

	/**
	 * Returns the io t component where originalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByOriginalId(
		String originalId, boolean useFinderCache);

	/**
	 * Removes the io t component where originalId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @return the io t component that was removed
	 */
	public IoTComponent removeByOriginalId(String originalId)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the number of io t components where originalId = &#63;.
	 *
	 * @param originalId the original ID
	 * @return the number of matching io t components
	 */
	public int countByOriginalId(String originalId);

	/**
	 * Returns the io t component where originalId = &#63; and subscriptionId = &#63; or throws a <code>NoSuchIoTComponentException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByOID_S(String originalId, long subscriptionId)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the io t component where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByOID_S(String originalId, long subscriptionId);

	/**
	 * Returns the io t component where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByOID_S(
		String originalId, long subscriptionId, boolean useFinderCache);

	/**
	 * Removes the io t component where originalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the io t component that was removed
	 */
	public IoTComponent removeByOID_S(String originalId, long subscriptionId)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the number of io t components where originalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t components
	 */
	public int countByOID_S(String originalId, long subscriptionId);

	/**
	 * Returns all the io t components where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching io t components
	 */
	public java.util.List<IoTComponent> findByStatus(int status);

	/**
	 * Returns a range of all the io t components where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	public java.util.List<IoTComponent> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the io t components where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the io t components where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t component in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the first io t component in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the last io t component in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the last io t component in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where status = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent[] findByStatus_PrevAndNext(
			long iotComponentId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Removes all the io t components where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of io t components where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching io t components
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the io t components where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t components
	 */
	public java.util.List<IoTComponent> findByG_S(long groupId, int status);

	/**
	 * Returns a range of all the io t components where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	public java.util.List<IoTComponent> findByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the io t components where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the io t components where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the first io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the last io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the last io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent[] findByG_S_PrevAndNext(
			long iotComponentId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns all the io t components that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t components that the user has permission to view
	 */
	public java.util.List<IoTComponent> filterFindByG_S(
		long groupId, int status);

	/**
	 * Returns a range of all the io t components that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components that the user has permission to view
	 */
	public java.util.List<IoTComponent> filterFindByG_S(
		long groupId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the io t components that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components that the user has permission to view
	 */
	public java.util.List<IoTComponent> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the io t components before and after the current io t component in the ordered set of io t components that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent[] filterFindByG_S_PrevAndNext(
			long iotComponentId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Removes all the io t components where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of io t components where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t components
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of io t components that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t components that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the io t components where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching io t components
	 */
	public java.util.List<IoTComponent> findBySubscriptionId(
		long subscriptionId);

	/**
	 * Returns a range of all the io t components where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	public java.util.List<IoTComponent> findBySubscriptionId(
		long subscriptionId, int start, int end);

	/**
	 * Returns an ordered range of all the io t components where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the io t components where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	public java.util.List<IoTComponent> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findBySubscriptionId_First(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the first io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchBySubscriptionId_First(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the last io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	public IoTComponent findBySubscriptionId_Last(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the last io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public IoTComponent fetchBySubscriptionId_Last(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent[] findBySubscriptionId_PrevAndNext(
			long iotComponentId, long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
				orderByComparator)
		throws NoSuchIoTComponentException;

	/**
	 * Removes all the io t components where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public void removeBySubscriptionId(long subscriptionId);

	/**
	 * Returns the number of io t components where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t components
	 */
	public int countBySubscriptionId(long subscriptionId);

	/**
	 * Caches the io t component in the entity cache if it is enabled.
	 *
	 * @param ioTComponent the io t component
	 */
	public void cacheResult(IoTComponent ioTComponent);

	/**
	 * Caches the io t components in the entity cache if it is enabled.
	 *
	 * @param ioTComponents the io t components
	 */
	public void cacheResult(java.util.List<IoTComponent> ioTComponents);

	/**
	 * Creates a new io t component with the primary key. Does not add the io t component to the database.
	 *
	 * @param iotComponentId the primary key for the new io t component
	 * @return the new io t component
	 */
	public IoTComponent create(long iotComponentId);

	/**
	 * Removes the io t component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component that was removed
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent remove(long iotComponentId)
		throws NoSuchIoTComponentException;

	public IoTComponent updateImpl(IoTComponent ioTComponent);

	/**
	 * Returns the io t component with the primary key or throws a <code>NoSuchIoTComponentException</code> if it could not be found.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	public IoTComponent findByPrimaryKey(long iotComponentId)
		throws NoSuchIoTComponentException;

	/**
	 * Returns the io t component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component, or <code>null</code> if a io t component with the primary key could not be found
	 */
	public IoTComponent fetchByPrimaryKey(long iotComponentId);

	/**
	 * Returns all the io t components.
	 *
	 * @return the io t components
	 */
	public java.util.List<IoTComponent> findAll();

	/**
	 * Returns a range of all the io t components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of io t components
	 */
	public java.util.List<IoTComponent> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the io t components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of io t components
	 */
	public java.util.List<IoTComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator);

	/**
	 * Returns an ordered range of all the io t components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of io t components
	 */
	public java.util.List<IoTComponent> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTComponent>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the io t components from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of io t components.
	 *
	 * @return the number of io t components
	 */
	public int countAll();

}