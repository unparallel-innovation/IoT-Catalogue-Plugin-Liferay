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

import com.iot_catalogue.exception.NoSuchElementEntityException;
import com.iot_catalogue.model.ElementEntity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the element entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntityUtil
 * @generated
 */
@ProviderType
public interface ElementEntityPersistence
	extends BasePersistence<ElementEntity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElementEntityUtil} to access the element entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the element entities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findByUuid(String uuid);

	/**
	 * Returns a range of all the element entities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the element entities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where uuid = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findByUuid_PrevAndNext(
			long elementEntityId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of element entities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element entities
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementEntityException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByUUID_G(String uuid, long groupId)
		throws NoSuchElementEntityException;

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the element entity where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element entity that was removed
	 */
	public ElementEntity removeByUUID_G(String uuid, long groupId)
		throws NoSuchElementEntityException;

	/**
	 * Returns the number of element entities where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element entities
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findByUuid_C_PrevAndNext(
			long elementEntityId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element entities
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the element entities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findByGroupId(long groupId);

	/**
	 * Returns a range of all the element entities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the element entities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where groupId = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findByGroupId_PrevAndNext(
			long elementEntityId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of element entities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element entities
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the element entities where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findByStatus(int status);

	/**
	 * Returns a range of all the element entities where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the element entities where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where status = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findByStatus_PrevAndNext(
			long elementEntityId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of element entities where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element entities
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns a range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end);

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findByS_E_PrevAndNext(
			long elementEntityId, long subscriptionId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public void removeByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns the number of element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element entities
	 */
	public int countByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName);

	/**
	 * Returns all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label);

	/**
	 * Returns a range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end);

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByS_E_L_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByS_E_L_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByS_E_L_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByS_E_L_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findByS_E_L_PrevAndNext(
			long elementEntityId, long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 */
	public void removeByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label);

	/**
	 * Returns the number of element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the number of matching element entities
	 */
	public int countByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label);

	/**
	 * Returns all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label);

	/**
	 * Returns a range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end);

	/**
	 * Returns an ordered range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByE_L_First(
			String elementOriginalId, String elementClassName, String label,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByE_L_First(
		String elementOriginalId, String elementClassName, String label,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByE_L_Last(
			String elementOriginalId, String elementClassName, String label,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByE_L_Last(
		String elementOriginalId, String elementClassName, String label,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findByE_L_PrevAndNext(
			long elementEntityId, String elementOriginalId,
			String elementClassName, String label,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 */
	public void removeByE_L(
		String elementOriginalId, String elementClassName, String label);

	/**
	 * Returns the number of element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the number of matching element entities
	 */
	public int countByE_L(
		String elementOriginalId, String elementClassName, String label);

	/**
	 * Returns all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns a range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end);

	/**
	 * Returns an ordered range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByElement_First(
			String elementOriginalId, String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByElement_First(
		String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findByElement_Last(
			String elementOriginalId, String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findByElement_PrevAndNext(
			long elementEntityId, String elementOriginalId,
			String elementClassName,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public void removeByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns the number of element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element entities
	 */
	public int countByElement(
		String elementOriginalId, String elementClassName);

	/**
	 * Returns all the element entities where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element entities
	 */
	public java.util.List<ElementEntity> findBySubscriptionId(
		long subscriptionId);

	/**
	 * Returns a range of all the element entities where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	public java.util.List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end);

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	public java.util.List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findBySubscriptionId_First(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchBySubscriptionId_First(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public ElementEntity findBySubscriptionId_Last(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public ElementEntity fetchBySubscriptionId_Last(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity[] findBySubscriptionId_PrevAndNext(
			long elementEntityId, long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
				orderByComparator)
		throws NoSuchElementEntityException;

	/**
	 * Removes all the element entities where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public void removeBySubscriptionId(long subscriptionId);

	/**
	 * Returns the number of element entities where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element entities
	 */
	public int countBySubscriptionId(long subscriptionId);

	/**
	 * Caches the element entity in the entity cache if it is enabled.
	 *
	 * @param elementEntity the element entity
	 */
	public void cacheResult(ElementEntity elementEntity);

	/**
	 * Caches the element entities in the entity cache if it is enabled.
	 *
	 * @param elementEntities the element entities
	 */
	public void cacheResult(java.util.List<ElementEntity> elementEntities);

	/**
	 * Creates a new element entity with the primary key. Does not add the element entity to the database.
	 *
	 * @param elementEntityId the primary key for the new element entity
	 * @return the new element entity
	 */
	public ElementEntity create(long elementEntityId);

	/**
	 * Removes the element entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity that was removed
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity remove(long elementEntityId)
		throws NoSuchElementEntityException;

	public ElementEntity updateImpl(ElementEntity elementEntity);

	/**
	 * Returns the element entity with the primary key or throws a <code>NoSuchElementEntityException</code> if it could not be found.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public ElementEntity findByPrimaryKey(long elementEntityId)
		throws NoSuchElementEntityException;

	/**
	 * Returns the element entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity, or <code>null</code> if a element entity with the primary key could not be found
	 */
	public ElementEntity fetchByPrimaryKey(long elementEntityId);

	/**
	 * Returns all the element entities.
	 *
	 * @return the element entities
	 */
	public java.util.List<ElementEntity> findAll();

	/**
	 * Returns a range of all the element entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of element entities
	 */
	public java.util.List<ElementEntity> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the element entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of element entities
	 */
	public java.util.List<ElementEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator);

	/**
	 * Returns an ordered range of all the element entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of element entities
	 */
	public java.util.List<ElementEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElementEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the element entities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of element entities.
	 *
	 * @return the number of element entities
	 */
	public int countAll();

}