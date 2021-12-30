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

import com.iot_catalogue.model.ValidationChild;

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
 * The persistence utility for the validation child service. This utility wraps <code>com.iot_catalogue.service.persistence.impl.ValidationChildPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ValidationChildPersistence
 * @generated
 */
public class ValidationChildUtil {

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
	public static void clearCache(ValidationChild validationChild) {
		getPersistence().clearCache(validationChild);
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
	public static Map<Serializable, ValidationChild> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ValidationChild> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ValidationChild> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ValidationChild> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ValidationChild update(ValidationChild validationChild) {
		return getPersistence().update(validationChild);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ValidationChild update(
		ValidationChild validationChild, ServiceContext serviceContext) {

		return getPersistence().update(validationChild, serviceContext);
	}

	/**
	 * Returns all the validation childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching validation childs
	 */
	public static List<ValidationChild> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the validation childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	public static List<ValidationChild> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByUuid_First(
			String uuid, OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByUuid_First(
		String uuid, OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByUuid_Last(
			String uuid, OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByUuid_Last(
		String uuid, OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByUuid_PrevAndNext(
			id, uuid, orderByComparator);
	}

	/**
	 * Removes all the validation childs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of validation childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching validation childs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchValidationChildException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the validation child where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the validation child that was removed
	 */
	public static ValidationChild removeByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of validation childs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching validation childs
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching validation childs
	 */
	public static List<ValidationChild> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	public static List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByUuid_C_PrevAndNext(
			id, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the validation childs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching validation childs
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the validation childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching validation childs
	 */
	public static List<ValidationChild> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the validation childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	public static List<ValidationChild> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByGroupId_First(
			long groupId, OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByGroupId_First(
		long groupId, OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByGroupId_Last(
			long groupId, OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByGroupId_Last(
		long groupId, OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild[] findByGroupId_PrevAndNext(
			long id, long groupId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByGroupId_PrevAndNext(
			id, groupId, orderByComparator);
	}

	/**
	 * Removes all the validation childs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of validation childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching validation childs
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the validation childs where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @return the matching validation childs
	 */
	public static List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId) {

		return getPersistence().findByValidationOrignalId(validationOrignalId);
	}

	/**
	 * Returns a range of all the validation childs where validationOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	public static List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end) {

		return getPersistence().findByValidationOrignalId(
			validationOrignalId, start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs where validationOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findByValidationOrignalId(
			validationOrignalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs where validationOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByValidationOrignalId(
			validationOrignalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByValidationOrignalId_First(
			String validationOrignalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByValidationOrignalId_First(
			validationOrignalId, orderByComparator);
	}

	/**
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByValidationOrignalId_First(
		String validationOrignalId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByValidationOrignalId_First(
			validationOrignalId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByValidationOrignalId_Last(
			String validationOrignalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByValidationOrignalId_Last(
			validationOrignalId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByValidationOrignalId_Last(
		String validationOrignalId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByValidationOrignalId_Last(
			validationOrignalId, orderByComparator);
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild[] findByValidationOrignalId_PrevAndNext(
			long id, String validationOrignalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByValidationOrignalId_PrevAndNext(
			id, validationOrignalId, orderByComparator);
	}

	/**
	 * Removes all the validation childs where validationOrignalId = &#63; from the database.
	 *
	 * @param validationOrignalId the validation orignal ID
	 */
	public static void removeByValidationOrignalId(String validationOrignalId) {
		getPersistence().removeByValidationOrignalId(validationOrignalId);
	}

	/**
	 * Returns the number of validation childs where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @return the number of matching validation childs
	 */
	public static int countByValidationOrignalId(String validationOrignalId) {
		return getPersistence().countByValidationOrignalId(validationOrignalId);
	}

	/**
	 * Returns all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @return the matching validation childs
	 */
	public static List<ValidationChild> findByVOID_S(
		String validationOrignalId, long subscriptionId) {

		return getPersistence().findByVOID_S(
			validationOrignalId, subscriptionId);
	}

	/**
	 * Returns a range of all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	public static List<ValidationChild> findByVOID_S(
		String validationOrignalId, long subscriptionId, int start, int end) {

		return getPersistence().findByVOID_S(
			validationOrignalId, subscriptionId, start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByVOID_S(
		String validationOrignalId, long subscriptionId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findByVOID_S(
			validationOrignalId, subscriptionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByVOID_S(
		String validationOrignalId, long subscriptionId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByVOID_S(
			validationOrignalId, subscriptionId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByVOID_S_First(
			String validationOrignalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByVOID_S_First(
			validationOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByVOID_S_First(
		String validationOrignalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByVOID_S_First(
			validationOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByVOID_S_Last(
			String validationOrignalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByVOID_S_Last(
			validationOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByVOID_S_Last(
		String validationOrignalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByVOID_S_Last(
			validationOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild[] findByVOID_S_PrevAndNext(
			long id, String validationOrignalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByVOID_S_PrevAndNext(
			id, validationOrignalId, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 */
	public static void removeByVOID_S(
		String validationOrignalId, long subscriptionId) {

		getPersistence().removeByVOID_S(validationOrignalId, subscriptionId);
	}

	/**
	 * Returns the number of validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching validation childs
	 */
	public static int countByVOID_S(
		String validationOrignalId, long subscriptionId) {

		return getPersistence().countByVOID_S(
			validationOrignalId, subscriptionId);
	}

	/**
	 * Returns all the validation childs where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @return the matching validation childs
	 */
	public static List<ValidationChild> findByChildValidationOrignalId(
		String childValidationOriginalId) {

		return getPersistence().findByChildValidationOrignalId(
			childValidationOriginalId);
	}

	/**
	 * Returns a range of all the validation childs where childValidationOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	public static List<ValidationChild> findByChildValidationOrignalId(
		String childValidationOriginalId, int start, int end) {

		return getPersistence().findByChildValidationOrignalId(
			childValidationOriginalId, start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs where childValidationOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByChildValidationOrignalId(
		String childValidationOriginalId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findByChildValidationOrignalId(
			childValidationOriginalId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs where childValidationOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByChildValidationOrignalId(
		String childValidationOriginalId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByChildValidationOrignalId(
			childValidationOriginalId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByChildValidationOrignalId_First(
			String childValidationOriginalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByChildValidationOrignalId_First(
			childValidationOriginalId, orderByComparator);
	}

	/**
	 * Returns the first validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByChildValidationOrignalId_First(
		String childValidationOriginalId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByChildValidationOrignalId_First(
			childValidationOriginalId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByChildValidationOrignalId_Last(
			String childValidationOriginalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByChildValidationOrignalId_Last(
			childValidationOriginalId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByChildValidationOrignalId_Last(
		String childValidationOriginalId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByChildValidationOrignalId_Last(
			childValidationOriginalId, orderByComparator);
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild[] findByChildValidationOrignalId_PrevAndNext(
			long id, String childValidationOriginalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByChildValidationOrignalId_PrevAndNext(
			id, childValidationOriginalId, orderByComparator);
	}

	/**
	 * Removes all the validation childs where childValidationOriginalId = &#63; from the database.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 */
	public static void removeByChildValidationOrignalId(
		String childValidationOriginalId) {

		getPersistence().removeByChildValidationOrignalId(
			childValidationOriginalId);
	}

	/**
	 * Returns the number of validation childs where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @return the number of matching validation childs
	 */
	public static int countByChildValidationOrignalId(
		String childValidationOriginalId) {

		return getPersistence().countByChildValidationOrignalId(
			childValidationOriginalId);
	}

	/**
	 * Returns all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching validation childs
	 */
	public static List<ValidationChild> findByCVOID_S(
		String childValidationOriginalId, long subscriptionId) {

		return getPersistence().findByCVOID_S(
			childValidationOriginalId, subscriptionId);
	}

	/**
	 * Returns a range of all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	public static List<ValidationChild> findByCVOID_S(
		String childValidationOriginalId, long subscriptionId, int start,
		int end) {

		return getPersistence().findByCVOID_S(
			childValidationOriginalId, subscriptionId, start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByCVOID_S(
		String childValidationOriginalId, long subscriptionId, int start,
		int end, OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findByCVOID_S(
			childValidationOriginalId, subscriptionId, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findByCVOID_S(
		String childValidationOriginalId, long subscriptionId, int start,
		int end, OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCVOID_S(
			childValidationOriginalId, subscriptionId, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByCVOID_S_First(
			String childValidationOriginalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByCVOID_S_First(
			childValidationOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByCVOID_S_First(
		String childValidationOriginalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByCVOID_S_First(
			childValidationOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findByCVOID_S_Last(
			String childValidationOriginalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByCVOID_S_Last(
			childValidationOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchByCVOID_S_Last(
		String childValidationOriginalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchByCVOID_S_Last(
			childValidationOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild[] findByCVOID_S_PrevAndNext(
			long id, String childValidationOriginalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByCVOID_S_PrevAndNext(
			id, childValidationOriginalId, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 */
	public static void removeByCVOID_S(
		String childValidationOriginalId, long subscriptionId) {

		getPersistence().removeByCVOID_S(
			childValidationOriginalId, subscriptionId);
	}

	/**
	 * Returns the number of validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching validation childs
	 */
	public static int countByCVOID_S(
		String childValidationOriginalId, long subscriptionId) {

		return getPersistence().countByCVOID_S(
			childValidationOriginalId, subscriptionId);
	}

	/**
	 * Returns all the validation childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching validation childs
	 */
	public static List<ValidationChild> findBySubscriptionId(
		long subscriptionId) {

		return getPersistence().findBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns a range of all the validation childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	public static List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	public static List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public static ValidationChild findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild[] findBySubscriptionId_PrevAndNext(
			long id, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findBySubscriptionId_PrevAndNext(
			id, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the validation childs where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public static void removeBySubscriptionId(long subscriptionId) {
		getPersistence().removeBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns the number of validation childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching validation childs
	 */
	public static int countBySubscriptionId(long subscriptionId) {
		return getPersistence().countBySubscriptionId(subscriptionId);
	}

	/**
	 * Caches the validation child in the entity cache if it is enabled.
	 *
	 * @param validationChild the validation child
	 */
	public static void cacheResult(ValidationChild validationChild) {
		getPersistence().cacheResult(validationChild);
	}

	/**
	 * Caches the validation childs in the entity cache if it is enabled.
	 *
	 * @param validationChilds the validation childs
	 */
	public static void cacheResult(List<ValidationChild> validationChilds) {
		getPersistence().cacheResult(validationChilds);
	}

	/**
	 * Creates a new validation child with the primary key. Does not add the validation child to the database.
	 *
	 * @param id the primary key for the new validation child
	 * @return the new validation child
	 */
	public static ValidationChild create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the validation child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child that was removed
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild remove(long id)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().remove(id);
	}

	public static ValidationChild updateImpl(ValidationChild validationChild) {
		return getPersistence().updateImpl(validationChild);
	}

	/**
	 * Returns the validation child with the primary key or throws a <code>NoSuchValidationChildException</code> if it could not be found.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public static ValidationChild findByPrimaryKey(long id)
		throws com.iot_catalogue.exception.NoSuchValidationChildException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the validation child with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child, or <code>null</code> if a validation child with the primary key could not be found
	 */
	public static ValidationChild fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the validation childs.
	 *
	 * @return the validation childs
	 */
	public static List<ValidationChild> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the validation childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of validation childs
	 */
	public static List<ValidationChild> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the validation childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of validation childs
	 */
	public static List<ValidationChild> findAll(
		int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the validation childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of validation childs
	 */
	public static List<ValidationChild> findAll(
		int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the validation childs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of validation childs.
	 *
	 * @return the number of validation childs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ValidationChildPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ValidationChildPersistence, ValidationChildPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ValidationChildPersistence.class);

		ServiceTracker<ValidationChildPersistence, ValidationChildPersistence>
			serviceTracker =
				new ServiceTracker
					<ValidationChildPersistence, ValidationChildPersistence>(
						bundle.getBundleContext(),
						ValidationChildPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}