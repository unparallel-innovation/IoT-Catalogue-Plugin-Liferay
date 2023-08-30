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

import com.iot_catalogue.exception.NoSuchElementStandardException;
import com.iot_catalogue.model.ElementStandard;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the element standard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementStandardUtil
 * @generated
 */
@ProviderType
public interface ElementStandardPersistence
	extends BasePersistence<ElementStandard> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElementStandardUtil} to access the element standard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the element standards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element standards
	 */
	public java.util.List<ElementStandard> findByUuid(String uuid);

	/**
	 * Returns a range of all the element standards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	public java.util.List<ElementStandard> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the element standards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element standards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where uuid = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard[] findByUuid_PrevAndNext(
			long elementStandardId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Removes all the element standards where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of element standards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element standards
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementStandardException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByUUID_G(String uuid, long groupId)
		throws NoSuchElementStandardException;

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the element standard where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element standard that was removed
	 */
	public ElementStandard removeByUUID_G(String uuid, long groupId)
		throws NoSuchElementStandardException;

	/**
	 * Returns the number of element standards where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element standards
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element standards
	 */
	public java.util.List<ElementStandard> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	public java.util.List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard[] findByUuid_C_PrevAndNext(
			long elementStandardId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Removes all the element standards where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element standards
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the element standards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element standards
	 */
	public java.util.List<ElementStandard> findByGroupId(long groupId);

	/**
	 * Returns a range of all the element standards where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	public java.util.List<ElementStandard> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the element standards where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element standards where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the first element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the last element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the last element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where groupId = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard[] findByGroupId_PrevAndNext(
			long elementStandardId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Removes all the element standards where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of element standards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element standards
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the element standards where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element standards
	 */
	public java.util.List<ElementStandard> findByStatus(int status);

	/**
	 * Returns a range of all the element standards where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	public java.util.List<ElementStandard> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the element standards where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element standards where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the first element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the last element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the last element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where status = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard[] findByStatus_PrevAndNext(
			long elementStandardId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Removes all the element standards where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of element standards where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element standards
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element standards
	 */
	public java.util.List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns a range of all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	public java.util.List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end);

	/**
	 * Returns an ordered range of all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard[] findByS_E_PrevAndNext(
			long elementStandardId, long subscriptionId,
			String elementOriginalId, String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Removes all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public void removeByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns the number of element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element standards
	 */
	public int countByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element standards
	 */
	public java.util.List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns a range of all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	public java.util.List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end);

	/**
	 * Returns an ordered range of all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByElement_First(
			String elementOriginalId, String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the first element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByElement_First(
		String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the last element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findByElement_Last(
			String elementOriginalId, String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the last element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard[] findByElement_PrevAndNext(
			long elementStandardId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Removes all the element standards where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public void removeByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns the number of element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element standards
	 */
	public int countByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns all the element standards where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element standards
	 */
	public java.util.List<ElementStandard> findBySubscriptionId(
		long subscriptionId);

	/**
	 * Returns a range of all the element standards where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	public java.util.List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end);

	/**
	 * Returns an ordered range of all the element standards where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element standards where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	public java.util.List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findBySubscriptionId_First(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchBySubscriptionId_First(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public ElementStandard findBySubscriptionId_Last(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public ElementStandard fetchBySubscriptionId_Last(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard[] findBySubscriptionId_PrevAndNext(
			long elementStandardId, long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
				orderByComparator)
		throws NoSuchElementStandardException;

	/**
	 * Removes all the element standards where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public void removeBySubscriptionId(long subscriptionId);

	/**
	 * Returns the number of element standards where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element standards
	 */
	public int countBySubscriptionId(long subscriptionId);

	/**
	 * Caches the element standard in the entity cache if it is enabled.
	 *
	 * @param elementStandard the element standard
	 */
	public void cacheResult(ElementStandard elementStandard);

	/**
	 * Caches the element standards in the entity cache if it is enabled.
	 *
	 * @param elementStandards the element standards
	 */
	public void cacheResult(java.util.List<ElementStandard> elementStandards);

	/**
	 * Creates a new element standard with the primary key. Does not add the element standard to the database.
	 *
	 * @param elementStandardId the primary key for the new element standard
	 * @return the new element standard
	 */
	public ElementStandard create(long elementStandardId);

	/**
	 * Removes the element standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard that was removed
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard remove(long elementStandardId)
		throws NoSuchElementStandardException;

	public ElementStandard updateImpl(ElementStandard elementStandard);

	/**
	 * Returns the element standard with the primary key or throws a <code>NoSuchElementStandardException</code> if it could not be found.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public ElementStandard findByPrimaryKey(long elementStandardId)
		throws NoSuchElementStandardException;

	/**
	 * Returns the element standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard, or <code>null</code> if a element standard with the primary key could not be found
	 */
	public ElementStandard fetchByPrimaryKey(long elementStandardId);

	/**
	 * Returns all the element standards.
	 *
	 * @return the element standards
	 */
	public java.util.List<ElementStandard> findAll();

	/**
	 * Returns a range of all the element standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of element standards
	 */
	public java.util.List<ElementStandard> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the element standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of element standards
	 */
	public java.util.List<ElementStandard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of element standards
	 */
	public java.util.List<ElementStandard> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementStandard>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the element standards from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of element standards.
	 *
	 * @return the number of element standards
	 */
	public int countAll();

}