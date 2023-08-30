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

import com.iot_catalogue.model.ElementEntity;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the element entity service. This utility wraps <code>com.iot_catalogue.service.persistence.impl.ElementEntityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntityPersistence
 * @generated
 */
public class ElementEntityUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ElementEntity elementEntity) {
		getPersistence().clearCache(elementEntity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ElementEntity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ElementEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ElementEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ElementEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ElementEntity update(ElementEntity elementEntity) {
		return getPersistence().update(elementEntity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ElementEntity update(
		ElementEntity elementEntity, ServiceContext serviceContext) {

		return getPersistence().update(elementEntity, serviceContext);
	}

	/**
	 * Returns all the element entities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ElementEntity> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ElementEntity> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ElementEntity> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByUuid_First(
			String uuid, OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByUuid_First(
		String uuid, OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByUuid_Last(
			String uuid, OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByUuid_Last(
		String uuid, OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where uuid = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public static ElementEntity[] findByUuid_PrevAndNext(
			long elementEntityId, String uuid,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByUuid_PrevAndNext(
			elementEntityId, uuid, orderByComparator);
	}

	/**
	 * Removes all the element entities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of element entities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element entities
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementEntityException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the element entity where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element entity that was removed
	 */
	public static ElementEntity removeByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of element entities where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element entities
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ElementEntity[] findByUuid_C_PrevAndNext(
			long elementEntityId, String uuid, long companyId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByUuid_C_PrevAndNext(
			elementEntityId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the element entities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element entities
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the element entities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<ElementEntity> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<ElementEntity> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<ElementEntity> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByGroupId_First(
			long groupId, OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByGroupId_First(
		long groupId, OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByGroupId_Last(
			long groupId, OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByGroupId_Last(
		long groupId, OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where groupId = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public static ElementEntity[] findByGroupId_PrevAndNext(
			long elementEntityId, long groupId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByGroupId_PrevAndNext(
			elementEntityId, groupId, orderByComparator);
	}

	/**
	 * Removes all the element entities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of element entities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element entities
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the element entities where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

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
	public static List<ElementEntity> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

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
	public static List<ElementEntity> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

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
	public static List<ElementEntity> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByStatus_First(
			int status, OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByStatus_First(
		int status, OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByStatus_Last(
			int status, OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByStatus_Last(
		int status, OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where status = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public static ElementEntity[] findByStatus_PrevAndNext(
			long elementEntityId, int status,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByStatus_PrevAndNext(
			elementEntityId, status, orderByComparator);
	}

	/**
	 * Removes all the element entities where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of element entities where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element entities
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName);
	}

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
	public static List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end);
	}

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
	public static List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator);
	}

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
	public static List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end, OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static ElementEntity findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

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
	public static ElementEntity findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

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
	public static ElementEntity[] findByS_E_PrevAndNext(
			long elementEntityId, long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByS_E_PrevAndNext(
			elementEntityId, subscriptionId, elementOriginalId,
			elementClassName, orderByComparator);
	}

	/**
	 * Removes all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public static void removeByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		getPersistence().removeByS_E(
			subscriptionId, elementOriginalId, elementClassName);
	}

	/**
	 * Returns the number of element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element entities
	 */
	public static int countByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return getPersistence().countByS_E(
			subscriptionId, elementOriginalId, elementClassName);
	}

	/**
	 * Returns all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label) {

		return getPersistence().findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label);
	}

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
	public static List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end) {

		return getPersistence().findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label, start,
			end);
	}

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
	public static List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label, start,
			end, orderByComparator);
	}

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
	public static List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label, start,
			end, orderByComparator, useFinderCache);
	}

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
	public static ElementEntity findByS_E_L_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByS_E_L_First(
			subscriptionId, elementOriginalId, elementClassName, label,
			orderByComparator);
	}

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
	public static ElementEntity fetchByS_E_L_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByS_E_L_First(
			subscriptionId, elementOriginalId, elementClassName, label,
			orderByComparator);
	}

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
	public static ElementEntity findByS_E_L_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByS_E_L_Last(
			subscriptionId, elementOriginalId, elementClassName, label,
			orderByComparator);
	}

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
	public static ElementEntity fetchByS_E_L_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByS_E_L_Last(
			subscriptionId, elementOriginalId, elementClassName, label,
			orderByComparator);
	}

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
	public static ElementEntity[] findByS_E_L_PrevAndNext(
			long elementEntityId, long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByS_E_L_PrevAndNext(
			elementEntityId, subscriptionId, elementOriginalId,
			elementClassName, label, orderByComparator);
	}

	/**
	 * Removes all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 */
	public static void removeByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label) {

		getPersistence().removeByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label);
	}

	/**
	 * Returns the number of element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the number of matching element entities
	 */
	public static int countByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label) {

		return getPersistence().countByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label);
	}

	/**
	 * Returns all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label) {

		return getPersistence().findByE_L(
			elementOriginalId, elementClassName, label);
	}

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
	public static List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end) {

		return getPersistence().findByE_L(
			elementOriginalId, elementClassName, label, start, end);
	}

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
	public static List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findByE_L(
			elementOriginalId, elementClassName, label, start, end,
			orderByComparator);
	}

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
	public static List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end, OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByE_L(
			elementOriginalId, elementClassName, label, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static ElementEntity findByE_L_First(
			String elementOriginalId, String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByE_L_First(
			elementOriginalId, elementClassName, label, orderByComparator);
	}

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByE_L_First(
		String elementOriginalId, String elementClassName, String label,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByE_L_First(
			elementOriginalId, elementClassName, label, orderByComparator);
	}

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
	public static ElementEntity findByE_L_Last(
			String elementOriginalId, String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByE_L_Last(
			elementOriginalId, elementClassName, label, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByE_L_Last(
		String elementOriginalId, String elementClassName, String label,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByE_L_Last(
			elementOriginalId, elementClassName, label, orderByComparator);
	}

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
	public static ElementEntity[] findByE_L_PrevAndNext(
			long elementEntityId, String elementOriginalId,
			String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByE_L_PrevAndNext(
			elementEntityId, elementOriginalId, elementClassName, label,
			orderByComparator);
	}

	/**
	 * Removes all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 */
	public static void removeByE_L(
		String elementOriginalId, String elementClassName, String label) {

		getPersistence().removeByE_L(
			elementOriginalId, elementClassName, label);
	}

	/**
	 * Returns the number of element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the number of matching element entities
	 */
	public static int countByE_L(
		String elementOriginalId, String elementClassName, String label) {

		return getPersistence().countByE_L(
			elementOriginalId, elementClassName, label);
	}

	/**
	 * Returns all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName);
	}

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
	public static List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end);
	}

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
	public static List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator);
	}

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
	public static List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByElement_First(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByElement_First(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByElement_First(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByElement_First(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findByElement_Last(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);
	}

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
	public static ElementEntity[] findByElement_PrevAndNext(
			long elementEntityId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByElement_PrevAndNext(
			elementEntityId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Removes all the element entities where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public static void removeByElement(
		String elementOriginalId, String elementClassName) {

		getPersistence().removeByElement(elementOriginalId, elementClassName);
	}

	/**
	 * Returns the number of element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element entities
	 */
	public static int countByElement(
		String elementOriginalId, String elementClassName) {

		return getPersistence().countByElement(
			elementOriginalId, elementClassName);
	}

	/**
	 * Returns all the element entities where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element entities
	 */
	public static List<ElementEntity> findBySubscriptionId(
		long subscriptionId) {

		return getPersistence().findBySubscriptionId(subscriptionId);
	}

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
	public static List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end);
	}

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
	public static List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator);
	}

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
	public static List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	public static ElementEntity findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public static ElementEntity[] findBySubscriptionId_PrevAndNext(
			long elementEntityId, long subscriptionId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findBySubscriptionId_PrevAndNext(
			elementEntityId, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the element entities where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public static void removeBySubscriptionId(long subscriptionId) {
		getPersistence().removeBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns the number of element entities where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element entities
	 */
	public static int countBySubscriptionId(long subscriptionId) {
		return getPersistence().countBySubscriptionId(subscriptionId);
	}

	/**
	 * Caches the element entity in the entity cache if it is enabled.
	 *
	 * @param elementEntity the element entity
	 */
	public static void cacheResult(ElementEntity elementEntity) {
		getPersistence().cacheResult(elementEntity);
	}

	/**
	 * Caches the element entities in the entity cache if it is enabled.
	 *
	 * @param elementEntities the element entities
	 */
	public static void cacheResult(List<ElementEntity> elementEntities) {
		getPersistence().cacheResult(elementEntities);
	}

	/**
	 * Creates a new element entity with the primary key. Does not add the element entity to the database.
	 *
	 * @param elementEntityId the primary key for the new element entity
	 * @return the new element entity
	 */
	public static ElementEntity create(long elementEntityId) {
		return getPersistence().create(elementEntityId);
	}

	/**
	 * Removes the element entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity that was removed
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public static ElementEntity remove(long elementEntityId)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().remove(elementEntityId);
	}

	public static ElementEntity updateImpl(ElementEntity elementEntity) {
		return getPersistence().updateImpl(elementEntity);
	}

	/**
	 * Returns the element entity with the primary key or throws a <code>NoSuchElementEntityException</code> if it could not be found.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	public static ElementEntity findByPrimaryKey(long elementEntityId)
		throws com.iot_catalogue.exception.NoSuchElementEntityException {

		return getPersistence().findByPrimaryKey(elementEntityId);
	}

	/**
	 * Returns the element entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity, or <code>null</code> if a element entity with the primary key could not be found
	 */
	public static ElementEntity fetchByPrimaryKey(long elementEntityId) {
		return getPersistence().fetchByPrimaryKey(elementEntityId);
	}

	/**
	 * Returns all the element entities.
	 *
	 * @return the element entities
	 */
	public static List<ElementEntity> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ElementEntity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ElementEntity> findAll(
		int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ElementEntity> findAll(
		int start, int end, OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the element entities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of element entities.
	 *
	 * @return the number of element entities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ElementEntityPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ElementEntityPersistence, ElementEntityPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ElementEntityPersistence.class);

		ServiceTracker<ElementEntityPersistence, ElementEntityPersistence>
			serviceTracker =
				new ServiceTracker
					<ElementEntityPersistence, ElementEntityPersistence>(
						bundle.getBundleContext(),
						ElementEntityPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}