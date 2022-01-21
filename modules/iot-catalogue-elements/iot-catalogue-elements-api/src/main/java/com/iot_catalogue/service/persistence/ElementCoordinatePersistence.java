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

import com.iot_catalogue.exception.NoSuchElementCoordinateException;
import com.iot_catalogue.model.ElementCoordinate;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the element coordinate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementCoordinateUtil
 * @generated
 */
@ProviderType
public interface ElementCoordinatePersistence
	extends BasePersistence<ElementCoordinate> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElementCoordinateUtil} to access the element coordinate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the element coordinates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByUuid(String uuid);

	/**
	 * Returns a range of all the element coordinates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the element coordinates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element coordinates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate[] findByUuid_PrevAndNext(
			long elementCoordinateId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Removes all the element coordinates where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of element coordinates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element coordinates
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementCoordinateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByUUID_G(String uuid, long groupId)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the element coordinate where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element coordinate that was removed
	 */
	public ElementCoordinate removeByUUID_G(String uuid, long groupId)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the number of element coordinates where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element coordinates
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate[] findByUuid_C_PrevAndNext(
			long elementCoordinateId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Removes all the element coordinates where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element coordinates
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the element coordinates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByGroupId(long groupId);

	/**
	 * Returns a range of all the element coordinates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the element coordinates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element coordinates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the first element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the last element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the last element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate[] findByGroupId_PrevAndNext(
			long elementCoordinateId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Removes all the element coordinates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of element coordinates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element coordinates
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the element coordinates where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByStatus(int status);

	/**
	 * Returns a range of all the element coordinates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the element coordinates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element coordinates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the first element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the last element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the last element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where status = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate[] findByStatus_PrevAndNext(
			long elementCoordinateId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Removes all the element coordinates where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of element coordinates where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element coordinates
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns a range of all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end);

	/**
	 * Returns an ordered range of all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate[] findByS_E_PrevAndNext(
			long elementCoordinateId, long subscriptionId,
			String elementOriginalId, String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Removes all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public void removeByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns the number of element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element coordinates
	 */
	public int countByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns a range of all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end);

	/**
	 * Returns an ordered range of all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByElement_First(
			String elementOriginalId, String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the first element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByElement_First(
		String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the last element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findByElement_Last(
			String elementOriginalId, String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the last element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate[] findByElement_PrevAndNext(
			long elementCoordinateId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Removes all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public void removeByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns the number of element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element coordinates
	 */
	public int countByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns all the element coordinates where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId);

	/**
	 * Returns a range of all the element coordinates where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end);

	/**
	 * Returns an ordered range of all the element coordinates where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element coordinates where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	public java.util.List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findBySubscriptionId_First(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchBySubscriptionId_First(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public ElementCoordinate findBySubscriptionId_Last(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public ElementCoordinate fetchBySubscriptionId_Last(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate[] findBySubscriptionId_PrevAndNext(
			long elementCoordinateId, long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
				orderByComparator)
		throws NoSuchElementCoordinateException;

	/**
	 * Removes all the element coordinates where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public void removeBySubscriptionId(long subscriptionId);

	/**
	 * Returns the number of element coordinates where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element coordinates
	 */
	public int countBySubscriptionId(long subscriptionId);

	/**
	 * Caches the element coordinate in the entity cache if it is enabled.
	 *
	 * @param elementCoordinate the element coordinate
	 */
	public void cacheResult(ElementCoordinate elementCoordinate);

	/**
	 * Caches the element coordinates in the entity cache if it is enabled.
	 *
	 * @param elementCoordinates the element coordinates
	 */
	public void cacheResult(
		java.util.List<ElementCoordinate> elementCoordinates);

	/**
	 * Creates a new element coordinate with the primary key. Does not add the element coordinate to the database.
	 *
	 * @param elementCoordinateId the primary key for the new element coordinate
	 * @return the new element coordinate
	 */
	public ElementCoordinate create(long elementCoordinateId);

	/**
	 * Removes the element coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate that was removed
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate remove(long elementCoordinateId)
		throws NoSuchElementCoordinateException;

	public ElementCoordinate updateImpl(ElementCoordinate elementCoordinate);

	/**
	 * Returns the element coordinate with the primary key or throws a <code>NoSuchElementCoordinateException</code> if it could not be found.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate findByPrimaryKey(long elementCoordinateId)
		throws NoSuchElementCoordinateException;

	/**
	 * Returns the element coordinate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate, or <code>null</code> if a element coordinate with the primary key could not be found
	 */
	public ElementCoordinate fetchByPrimaryKey(long elementCoordinateId);

	/**
	 * Returns all the element coordinates.
	 *
	 * @return the element coordinates
	 */
	public java.util.List<ElementCoordinate> findAll();

	/**
	 * Returns a range of all the element coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of element coordinates
	 */
	public java.util.List<ElementCoordinate> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the element coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of element coordinates
	 */
	public java.util.List<ElementCoordinate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of element coordinates
	 */
	public java.util.List<ElementCoordinate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementCoordinate>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the element coordinates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of element coordinates.
	 *
	 * @return the number of element coordinates
	 */
	public int countAll();

}