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

import com.iot_catalogue.model.ComponentChild;

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
 * The persistence utility for the component child service. This utility wraps <code>com.iot_catalogue.service.persistence.impl.ComponentChildPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComponentChildPersistence
 * @generated
 */
public class ComponentChildUtil {

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
	public static void clearCache(ComponentChild componentChild) {
		getPersistence().clearCache(componentChild);
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
	public static Map<Serializable, ComponentChild> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ComponentChild> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ComponentChild> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ComponentChild> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ComponentChild update(ComponentChild componentChild) {
		return getPersistence().update(componentChild);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ComponentChild update(
		ComponentChild componentChild, ServiceContext serviceContext) {

		return getPersistence().update(componentChild, serviceContext);
	}

	/**
	 * Returns all the component childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching component childs
	 */
	public static List<ComponentChild> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the component childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	public static List<ComponentChild> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the component childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByUuid_First(
			String uuid, OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByUuid_First(
		String uuid, OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByUuid_Last(
			String uuid, OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByUuid_Last(
		String uuid, OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the component childs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of component childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching component childs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchComponentChildException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the component child where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the component child that was removed
	 */
	public static ComponentChild removeByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of component childs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching component childs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching component childs
	 */
	public static List<ComponentChild> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	public static List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the component childs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching component childs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the component childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching component childs
	 */
	public static List<ComponentChild> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the component childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	public static List<ComponentChild> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the component childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByGroupId_First(
			long groupId, OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByGroupId_First(
		long groupId, OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByGroupId_Last(
			long groupId, OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByGroupId_Last(
		long groupId, OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild[] findByGroupId_PrevAndNext(
			long id, long groupId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByGroupId_PrevAndNext(
			id, groupId, orderByComparator);
	}

	/**
	 * Removes all the component childs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of component childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching component childs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the component childs where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @return the matching component childs
	 */
	public static List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId) {

		return getPersistence().findByComponentOrignalId(componentOrignalId);
	}

	/**
	 * Returns a range of all the component childs where componentOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	public static List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end) {

		return getPersistence().findByComponentOrignalId(
			componentOrignalId, start, end);
	}

	/**
	 * Returns an ordered range of all the component childs where componentOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findByComponentOrignalId(
			componentOrignalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs where componentOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByComponentOrignalId(
			componentOrignalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByComponentOrignalId_First(
			String componentOrignalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByComponentOrignalId_First(
			componentOrignalId, orderByComparator);
	}

	/**
	 * Returns the first component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByComponentOrignalId_First(
		String componentOrignalId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByComponentOrignalId_First(
			componentOrignalId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByComponentOrignalId_Last(
			String componentOrignalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByComponentOrignalId_Last(
			componentOrignalId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByComponentOrignalId_Last(
		String componentOrignalId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByComponentOrignalId_Last(
			componentOrignalId, orderByComparator);
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild[] findByComponentOrignalId_PrevAndNext(
			long id, String componentOrignalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByComponentOrignalId_PrevAndNext(
			id, componentOrignalId, orderByComparator);
	}

	/**
	 * Removes all the component childs where componentOrignalId = &#63; from the database.
	 *
	 * @param componentOrignalId the component orignal ID
	 */
	public static void removeByComponentOrignalId(String componentOrignalId) {
		getPersistence().removeByComponentOrignalId(componentOrignalId);
	}

	/**
	 * Returns the number of component childs where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @return the number of matching component childs
	 */
	public static int countByComponentOrignalId(String componentOrignalId) {
		return getPersistence().countByComponentOrignalId(componentOrignalId);
	}

	/**
	 * Returns all the component childs where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @return the matching component childs
	 */
	public static List<ComponentChild> findByCOID_S(
		String componentOrignalId, long subscriptionId) {

		return getPersistence().findByCOID_S(
			componentOrignalId, subscriptionId);
	}

	/**
	 * Returns a range of all the component childs where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	public static List<ComponentChild> findByCOID_S(
		String componentOrignalId, long subscriptionId, int start, int end) {

		return getPersistence().findByCOID_S(
			componentOrignalId, subscriptionId, start, end);
	}

	/**
	 * Returns an ordered range of all the component childs where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByCOID_S(
		String componentOrignalId, long subscriptionId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findByCOID_S(
			componentOrignalId, subscriptionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByCOID_S(
		String componentOrignalId, long subscriptionId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCOID_S(
			componentOrignalId, subscriptionId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first component child in the ordered set where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByCOID_S_First(
			String componentOrignalId, long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByCOID_S_First(
			componentOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first component child in the ordered set where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByCOID_S_First(
		String componentOrignalId, long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByCOID_S_First(
			componentOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByCOID_S_Last(
			String componentOrignalId, long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByCOID_S_Last(
			componentOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByCOID_S_Last(
		String componentOrignalId, long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByCOID_S_Last(
			componentOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild[] findByCOID_S_PrevAndNext(
			long id, String componentOrignalId, long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByCOID_S_PrevAndNext(
			id, componentOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the component childs where componentOrignalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 */
	public static void removeByCOID_S(
		String componentOrignalId, long subscriptionId) {

		getPersistence().removeByCOID_S(componentOrignalId, subscriptionId);
	}

	/**
	 * Returns the number of component childs where componentOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching component childs
	 */
	public static int countByCOID_S(
		String componentOrignalId, long subscriptionId) {

		return getPersistence().countByCOID_S(
			componentOrignalId, subscriptionId);
	}

	/**
	 * Returns all the component childs where childComponentOriginalId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @return the matching component childs
	 */
	public static List<ComponentChild> findByChildComponentOrignalId(
		String childComponentOriginalId) {

		return getPersistence().findByChildComponentOrignalId(
			childComponentOriginalId);
	}

	/**
	 * Returns a range of all the component childs where childComponentOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	public static List<ComponentChild> findByChildComponentOrignalId(
		String childComponentOriginalId, int start, int end) {

		return getPersistence().findByChildComponentOrignalId(
			childComponentOriginalId, start, end);
	}

	/**
	 * Returns an ordered range of all the component childs where childComponentOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByChildComponentOrignalId(
		String childComponentOriginalId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findByChildComponentOrignalId(
			childComponentOriginalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs where childComponentOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByChildComponentOrignalId(
		String childComponentOriginalId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChildComponentOrignalId(
			childComponentOriginalId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first component child in the ordered set where childComponentOriginalId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByChildComponentOrignalId_First(
			String childComponentOriginalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByChildComponentOrignalId_First(
			childComponentOriginalId, orderByComparator);
	}

	/**
	 * Returns the first component child in the ordered set where childComponentOriginalId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByChildComponentOrignalId_First(
		String childComponentOriginalId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByChildComponentOrignalId_First(
			childComponentOriginalId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where childComponentOriginalId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByChildComponentOrignalId_Last(
			String childComponentOriginalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByChildComponentOrignalId_Last(
			childComponentOriginalId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where childComponentOriginalId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByChildComponentOrignalId_Last(
		String childComponentOriginalId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByChildComponentOrignalId_Last(
			childComponentOriginalId, orderByComparator);
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where childComponentOriginalId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param childComponentOriginalId the child component original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild[] findByChildComponentOrignalId_PrevAndNext(
			long id, String childComponentOriginalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByChildComponentOrignalId_PrevAndNext(
			id, childComponentOriginalId, orderByComparator);
	}

	/**
	 * Removes all the component childs where childComponentOriginalId = &#63; from the database.
	 *
	 * @param childComponentOriginalId the child component original ID
	 */
	public static void removeByChildComponentOrignalId(
		String childComponentOriginalId) {

		getPersistence().removeByChildComponentOrignalId(
			childComponentOriginalId);
	}

	/**
	 * Returns the number of component childs where childComponentOriginalId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @return the number of matching component childs
	 */
	public static int countByChildComponentOrignalId(
		String childComponentOriginalId) {

		return getPersistence().countByChildComponentOrignalId(
			childComponentOriginalId);
	}

	/**
	 * Returns all the component childs where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching component childs
	 */
	public static List<ComponentChild> findByCCOID_S(
		String childComponentOriginalId, long subscriptionId) {

		return getPersistence().findByCCOID_S(
			childComponentOriginalId, subscriptionId);
	}

	/**
	 * Returns a range of all the component childs where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	public static List<ComponentChild> findByCCOID_S(
		String childComponentOriginalId, long subscriptionId, int start,
		int end) {

		return getPersistence().findByCCOID_S(
			childComponentOriginalId, subscriptionId, start, end);
	}

	/**
	 * Returns an ordered range of all the component childs where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByCCOID_S(
		String childComponentOriginalId, long subscriptionId, int start,
		int end, OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findByCCOID_S(
			childComponentOriginalId, subscriptionId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findByCCOID_S(
		String childComponentOriginalId, long subscriptionId, int start,
		int end, OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCCOID_S(
			childComponentOriginalId, subscriptionId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first component child in the ordered set where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByCCOID_S_First(
			String childComponentOriginalId, long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByCCOID_S_First(
			childComponentOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first component child in the ordered set where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByCCOID_S_First(
		String childComponentOriginalId, long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByCCOID_S_First(
			childComponentOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findByCCOID_S_Last(
			String childComponentOriginalId, long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByCCOID_S_Last(
			childComponentOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchByCCOID_S_Last(
		String childComponentOriginalId, long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchByCCOID_S_Last(
			childComponentOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild[] findByCCOID_S_PrevAndNext(
			long id, String childComponentOriginalId, long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByCCOID_S_PrevAndNext(
			id, childComponentOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the component childs where childComponentOriginalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 */
	public static void removeByCCOID_S(
		String childComponentOriginalId, long subscriptionId) {

		getPersistence().removeByCCOID_S(
			childComponentOriginalId, subscriptionId);
	}

	/**
	 * Returns the number of component childs where childComponentOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childComponentOriginalId the child component original ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching component childs
	 */
	public static int countByCCOID_S(
		String childComponentOriginalId, long subscriptionId) {

		return getPersistence().countByCCOID_S(
			childComponentOriginalId, subscriptionId);
	}

	/**
	 * Returns all the component childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching component childs
	 */
	public static List<ComponentChild> findBySubscriptionId(
		long subscriptionId) {

		return getPersistence().findBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns a range of all the component childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	public static List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end);
	}

	/**
	 * Returns an ordered range of all the component childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	public static List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public static ComponentChild findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild[] findBySubscriptionId_PrevAndNext(
			long id, long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findBySubscriptionId_PrevAndNext(
			id, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the component childs where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public static void removeBySubscriptionId(long subscriptionId) {
		getPersistence().removeBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns the number of component childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching component childs
	 */
	public static int countBySubscriptionId(long subscriptionId) {
		return getPersistence().countBySubscriptionId(subscriptionId);
	}

	/**
	 * Caches the component child in the entity cache if it is enabled.
	 *
	 * @param componentChild the component child
	 */
	public static void cacheResult(ComponentChild componentChild) {
		getPersistence().cacheResult(componentChild);
	}

	/**
	 * Caches the component childs in the entity cache if it is enabled.
	 *
	 * @param componentChilds the component childs
	 */
	public static void cacheResult(List<ComponentChild> componentChilds) {
		getPersistence().cacheResult(componentChilds);
	}

	/**
	 * Creates a new component child with the primary key. Does not add the component child to the database.
	 *
	 * @param id the primary key for the new component child
	 * @return the new component child
	 */
	public static ComponentChild create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the component child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the component child
	 * @return the component child that was removed
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild remove(long id)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().remove(id);
	}

	public static ComponentChild updateImpl(ComponentChild componentChild) {
		return getPersistence().updateImpl(componentChild);
	}

	/**
	 * Returns the component child with the primary key or throws a <code>NoSuchComponentChildException</code> if it could not be found.
	 *
	 * @param id the primary key of the component child
	 * @return the component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public static ComponentChild findByPrimaryKey(long id)
		throws com.iot_catalogue.exception.NoSuchComponentChildException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the component child with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the component child
	 * @return the component child, or <code>null</code> if a component child with the primary key could not be found
	 */
	public static ComponentChild fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the component childs.
	 *
	 * @return the component childs
	 */
	public static List<ComponentChild> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the component childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of component childs
	 */
	public static List<ComponentChild> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the component childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of component childs
	 */
	public static List<ComponentChild> findAll(
		int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the component childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of component childs
	 */
	public static List<ComponentChild> findAll(
		int start, int end, OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the component childs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of component childs.
	 *
	 * @return the number of component childs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ComponentChildPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ComponentChildPersistence, ComponentChildPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ComponentChildPersistence.class);

		ServiceTracker<ComponentChildPersistence, ComponentChildPersistence>
			serviceTracker =
				new ServiceTracker
					<ComponentChildPersistence, ComponentChildPersistence>(
						bundle.getBundleContext(),
						ComponentChildPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}