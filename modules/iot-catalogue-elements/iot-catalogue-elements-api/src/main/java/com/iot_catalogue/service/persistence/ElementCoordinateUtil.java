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

import com.iot_catalogue.model.ElementCoordinate;

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
 * The persistence utility for the element coordinate service. This utility wraps <code>com.iot_catalogue.service.persistence.impl.ElementCoordinatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementCoordinatePersistence
 * @generated
 */
public class ElementCoordinateUtil {

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
	public static void clearCache(ElementCoordinate elementCoordinate) {
		getPersistence().clearCache(elementCoordinate);
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
	public static Map<Serializable, ElementCoordinate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ElementCoordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ElementCoordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ElementCoordinate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ElementCoordinate update(
		ElementCoordinate elementCoordinate) {

		return getPersistence().update(elementCoordinate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ElementCoordinate update(
		ElementCoordinate elementCoordinate, ServiceContext serviceContext) {

		return getPersistence().update(elementCoordinate, serviceContext);
	}

	/**
	 * Returns all the element coordinates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element coordinates
	 */
	public static List<ElementCoordinate> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<ElementCoordinate> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<ElementCoordinate> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<ElementCoordinate> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByUuid_First(
			String uuid, OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByUuid_First(
		String uuid, OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByUuid_Last(
			String uuid, OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByUuid_Last(
		String uuid, OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate[] findByUuid_PrevAndNext(
			long elementCoordinateId, String uuid,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByUuid_PrevAndNext(
			elementCoordinateId, uuid, orderByComparator);
	}

	/**
	 * Removes all the element coordinates where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of element coordinates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element coordinates
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementCoordinateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the element coordinate where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element coordinate that was removed
	 */
	public static ElementCoordinate removeByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of element coordinates where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element coordinates
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element coordinates
	 */
	public static List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static ElementCoordinate[] findByUuid_C_PrevAndNext(
			long elementCoordinateId, String uuid, long companyId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByUuid_C_PrevAndNext(
			elementCoordinateId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the element coordinates where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element coordinates
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the element coordinates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element coordinates
	 */
	public static List<ElementCoordinate> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByGroupId_First(
			long groupId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByGroupId_First(
		long groupId, OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByGroupId_Last(
			long groupId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByGroupId_Last(
		long groupId, OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate[] findByGroupId_PrevAndNext(
			long elementCoordinateId, long groupId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByGroupId_PrevAndNext(
			elementCoordinateId, groupId, orderByComparator);
	}

	/**
	 * Removes all the element coordinates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of element coordinates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element coordinates
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the element coordinates where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element coordinates
	 */
	public static List<ElementCoordinate> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

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
	public static List<ElementCoordinate> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

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
	public static List<ElementCoordinate> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

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
	public static List<ElementCoordinate> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByStatus_First(
			int status, OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByStatus_First(
		int status, OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByStatus_Last(
			int status, OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByStatus_Last(
		int status, OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where status = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate[] findByStatus_PrevAndNext(
			long elementCoordinateId, int status,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByStatus_PrevAndNext(
			elementCoordinateId, status, orderByComparator);
	}

	/**
	 * Removes all the element coordinates where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of element coordinates where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element coordinates
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element coordinates
	 */
	public static List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName);
	}

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
	public static List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end);
	}

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
	public static List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator);
	}

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
	public static List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator, useFinderCache);
	}

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
	public static ElementCoordinate findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

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
	public static ElementCoordinate findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);
	}

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
	public static ElementCoordinate[] findByS_E_PrevAndNext(
			long elementCoordinateId, long subscriptionId,
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByS_E_PrevAndNext(
			elementCoordinateId, subscriptionId, elementOriginalId,
			elementClassName, orderByComparator);
	}

	/**
	 * Removes all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
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
	 * Returns the number of element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element coordinates
	 */
	public static int countByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return getPersistence().countByS_E(
			subscriptionId, elementOriginalId, elementClassName);
	}

	/**
	 * Returns all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element coordinates
	 */
	public static List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName);
	}

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
	public static List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end);
	}

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
	public static List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator);
	}

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
	public static List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByElement_First(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByElement_First(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the first element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByElement_First(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByElement_First(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findByElement_Last(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);
	}

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
	public static ElementCoordinate[] findByElement_PrevAndNext(
			long elementCoordinateId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByElement_PrevAndNext(
			elementCoordinateId, elementOriginalId, elementClassName,
			orderByComparator);
	}

	/**
	 * Removes all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	public static void removeByElement(
		String elementOriginalId, String elementClassName) {

		getPersistence().removeByElement(elementOriginalId, elementClassName);
	}

	/**
	 * Returns the number of element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element coordinates
	 */
	public static int countByElement(
		String elementOriginalId, String elementClassName) {

		return getPersistence().countByElement(
			elementOriginalId, elementClassName);
	}

	/**
	 * Returns all the element coordinates where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element coordinates
	 */
	public static List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId) {

		return getPersistence().findBySubscriptionId(subscriptionId);
	}

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
	public static List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end);
	}

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
	public static List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator);
	}

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
	public static List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate[] findBySubscriptionId_PrevAndNext(
			long elementCoordinateId, long subscriptionId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findBySubscriptionId_PrevAndNext(
			elementCoordinateId, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the element coordinates where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public static void removeBySubscriptionId(long subscriptionId) {
		getPersistence().removeBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns the number of element coordinates where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element coordinates
	 */
	public static int countBySubscriptionId(long subscriptionId) {
		return getPersistence().countBySubscriptionId(subscriptionId);
	}

	/**
	 * Caches the element coordinate in the entity cache if it is enabled.
	 *
	 * @param elementCoordinate the element coordinate
	 */
	public static void cacheResult(ElementCoordinate elementCoordinate) {
		getPersistence().cacheResult(elementCoordinate);
	}

	/**
	 * Caches the element coordinates in the entity cache if it is enabled.
	 *
	 * @param elementCoordinates the element coordinates
	 */
	public static void cacheResult(List<ElementCoordinate> elementCoordinates) {
		getPersistence().cacheResult(elementCoordinates);
	}

	/**
	 * Creates a new element coordinate with the primary key. Does not add the element coordinate to the database.
	 *
	 * @param elementCoordinateId the primary key for the new element coordinate
	 * @return the new element coordinate
	 */
	public static ElementCoordinate create(long elementCoordinateId) {
		return getPersistence().create(elementCoordinateId);
	}

	/**
	 * Removes the element coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate that was removed
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate remove(long elementCoordinateId)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().remove(elementCoordinateId);
	}

	public static ElementCoordinate updateImpl(
		ElementCoordinate elementCoordinate) {

		return getPersistence().updateImpl(elementCoordinate);
	}

	/**
	 * Returns the element coordinate with the primary key or throws a <code>NoSuchElementCoordinateException</code> if it could not be found.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate findByPrimaryKey(long elementCoordinateId)
		throws com.iot_catalogue.exception.NoSuchElementCoordinateException {

		return getPersistence().findByPrimaryKey(elementCoordinateId);
	}

	/**
	 * Returns the element coordinate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate, or <code>null</code> if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate fetchByPrimaryKey(
		long elementCoordinateId) {

		return getPersistence().fetchByPrimaryKey(elementCoordinateId);
	}

	/**
	 * Returns all the element coordinates.
	 *
	 * @return the element coordinates
	 */
	public static List<ElementCoordinate> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ElementCoordinate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ElementCoordinate> findAll(
		int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ElementCoordinate> findAll(
		int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the element coordinates from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of element coordinates.
	 *
	 * @return the number of element coordinates
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ElementCoordinatePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ElementCoordinatePersistence, ElementCoordinatePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ElementCoordinatePersistence.class);

		ServiceTracker
			<ElementCoordinatePersistence, ElementCoordinatePersistence>
				serviceTracker =
					new ServiceTracker
						<ElementCoordinatePersistence,
						 ElementCoordinatePersistence>(
							 bundle.getBundleContext(),
							 ElementCoordinatePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}