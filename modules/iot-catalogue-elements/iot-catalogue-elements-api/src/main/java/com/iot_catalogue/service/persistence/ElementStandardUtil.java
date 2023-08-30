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

import com.iot_catalogue.model.ElementStandard;

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
 * The persistence utility for the element standard service. This utility wraps <code>com.iot_catalogue.service.persistence.impl.ElementStandardPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementStandardPersistence
 * @generated
 */
public class ElementStandardUtil {

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
	public static void clearCache(ElementStandard elementStandard) {
		getPersistence().clearCache(elementStandard);
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
	public static Map<Serializable, ElementStandard> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ElementStandard> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ElementStandard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ElementStandard> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ElementStandard update(ElementStandard elementStandard) {
		return getPersistence().update(elementStandard);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ElementStandard update(
		ElementStandard elementStandard, ServiceContext serviceContext) {

		return getPersistence().update(elementStandard, serviceContext);
	}

	/**
	 * Returns all the element standards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element standards
	 */
	public static List<ElementStandard> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ElementStandard> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ElementStandard> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ElementStandard> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByUuid_First(
			String uuid, OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByUuid_First(
		String uuid, OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByUuid_Last(
			String uuid, OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByUuid_Last(
		String uuid, OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where uuid = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public static ElementStandard[] findByUuid_PrevAndNext(
			long elementStandardId, String uuid,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByUuid_PrevAndNext(
			elementStandardId, uuid, orderByComparator);
	}

	/**
	 * Removes all the element standards where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of element standards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element standards
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementStandardException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the element standard where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element standard that was removed
	 */
	public static ElementStandard removeByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of element standards where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element standards
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element standards
	 */
	public static List<ElementStandard> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ElementStandard[] findByUuid_C_PrevAndNext(
			long elementStandardId, String uuid, long companyId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByUuid_C_PrevAndNext(
			elementStandardId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the element standards where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element standards
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the element standards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element standards
	 */
	public static List<ElementStandard> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<ElementStandard> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<ElementStandard> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<ElementStandard> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByGroupId_First(
			long groupId, OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByGroupId_First(
		long groupId, OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByGroupId_Last(
			long groupId, OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByGroupId_Last(
		long groupId, OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where groupId = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public static ElementStandard[] findByGroupId_PrevAndNext(
			long elementStandardId, long groupId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByGroupId_PrevAndNext(
			elementStandardId, groupId, orderByComparator);
	}

	/**
	 * Removes all the element standards where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of element standards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element standards
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the element standards where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element standards
	 */
	public static List<ElementStandard> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

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
	public static List<ElementStandard> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

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
	public static List<ElementStandard> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

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
	public static List<ElementStandard> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByStatus_First(
			int status, OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByStatus_First(
		int status, OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByStatus_Last(
			int status, OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByStatus_Last(
		int status, OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where status = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public static ElementStandard[] findByStatus_PrevAndNext(
			long elementStandardId, int status,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByStatus_PrevAndNext(
			elementStandardId, status, orderByComparator);
	}

	/**
	 * Removes all the element standards where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of element standards where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element standards
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element standards
	 */
	public static List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName);
	}

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
	public static List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end);
	}

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
	public static List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator);
	}

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
	public static List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static ElementStandard findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

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
	public static ElementStandard findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

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
	public static ElementStandard[] findByS_E_PrevAndNext(
			long elementStandardId, long subscriptionId,
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByS_E_PrevAndNext(
			elementStandardId, subscriptionId, elementOriginalId,
			elementClassName, orderByComparator);
	}

	/**
	 * Removes all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
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
	 * Returns the number of element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element standards
	 */
	public static int countByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return getPersistence().countByS_E(
			subscriptionId, elementOriginalId, elementClassName);
	}

	/**
	 * Returns all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element standards
	 */
	public static List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName);
	}

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
	public static List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end);
	}

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
	public static List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator);
	}

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
	public static List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByElement_First(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByElement_First(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the first element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByElement_First(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByElement_First(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findByElement_Last(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);
	}

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
	public static ElementStandard[] findByElement_PrevAndNext(
			long elementStandardId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByElement_PrevAndNext(
			elementStandardId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Removes all the element standards where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public static void removeByElement(
		String elementOriginalId, String elementClassName) {

		getPersistence().removeByElement(elementOriginalId, elementClassName);
	}

	/**
	 * Returns the number of element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element standards
	 */
	public static int countByElement(
		String elementOriginalId, String elementClassName) {

		return getPersistence().countByElement(
			elementOriginalId, elementClassName);
	}

	/**
	 * Returns all the element standards where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element standards
	 */
	public static List<ElementStandard> findBySubscriptionId(
		long subscriptionId) {

		return getPersistence().findBySubscriptionId(subscriptionId);
	}

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
	public static List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end);
	}

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
	public static List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator);
	}

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
	public static List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	public static ElementStandard findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	public static ElementStandard fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public static ElementStandard[] findBySubscriptionId_PrevAndNext(
			long elementStandardId, long subscriptionId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findBySubscriptionId_PrevAndNext(
			elementStandardId, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the element standards where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public static void removeBySubscriptionId(long subscriptionId) {
		getPersistence().removeBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns the number of element standards where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element standards
	 */
	public static int countBySubscriptionId(long subscriptionId) {
		return getPersistence().countBySubscriptionId(subscriptionId);
	}

	/**
	 * Caches the element standard in the entity cache if it is enabled.
	 *
	 * @param elementStandard the element standard
	 */
	public static void cacheResult(ElementStandard elementStandard) {
		getPersistence().cacheResult(elementStandard);
	}

	/**
	 * Caches the element standards in the entity cache if it is enabled.
	 *
	 * @param elementStandards the element standards
	 */
	public static void cacheResult(List<ElementStandard> elementStandards) {
		getPersistence().cacheResult(elementStandards);
	}

	/**
	 * Creates a new element standard with the primary key. Does not add the element standard to the database.
	 *
	 * @param elementStandardId the primary key for the new element standard
	 * @return the new element standard
	 */
	public static ElementStandard create(long elementStandardId) {
		return getPersistence().create(elementStandardId);
	}

	/**
	 * Removes the element standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard that was removed
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public static ElementStandard remove(long elementStandardId)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().remove(elementStandardId);
	}

	public static ElementStandard updateImpl(ElementStandard elementStandard) {
		return getPersistence().updateImpl(elementStandard);
	}

	/**
	 * Returns the element standard with the primary key or throws a <code>NoSuchElementStandardException</code> if it could not be found.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	public static ElementStandard findByPrimaryKey(long elementStandardId)
		throws com.iot_catalogue.exception.NoSuchElementStandardException {

		return getPersistence().findByPrimaryKey(elementStandardId);
	}

	/**
	 * Returns the element standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard, or <code>null</code> if a element standard with the primary key could not be found
	 */
	public static ElementStandard fetchByPrimaryKey(long elementStandardId) {
		return getPersistence().fetchByPrimaryKey(elementStandardId);
	}

	/**
	 * Returns all the element standards.
	 *
	 * @return the element standards
	 */
	public static List<ElementStandard> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ElementStandard> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ElementStandard> findAll(
		int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ElementStandard> findAll(
		int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the element standards from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of element standards.
	 *
	 * @return the number of element standards
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ElementStandardPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ElementStandardPersistence, ElementStandardPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ElementStandardPersistence.class);

		ServiceTracker<ElementStandardPersistence, ElementStandardPersistence>
			serviceTracker =
				new ServiceTracker
					<ElementStandardPersistence, ElementStandardPersistence>(
						bundle.getBundleContext(),
						ElementStandardPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}