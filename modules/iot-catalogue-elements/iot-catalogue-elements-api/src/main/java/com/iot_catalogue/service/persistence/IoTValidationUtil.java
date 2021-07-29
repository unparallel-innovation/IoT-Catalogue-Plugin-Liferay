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

import com.iot_catalogue.model.IoTValidation;

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
 * The persistence utility for the io t validation service. This utility wraps <code>com.iot_catalogue.service.persistence.impl.IoTValidationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IoTValidationPersistence
 * @generated
 */
public class IoTValidationUtil {

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
	public static void clearCache(IoTValidation ioTValidation) {
		getPersistence().clearCache(ioTValidation);
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
	public static Map<Serializable, IoTValidation> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<IoTValidation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<IoTValidation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<IoTValidation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static IoTValidation update(IoTValidation ioTValidation) {
		return getPersistence().update(ioTValidation);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static IoTValidation update(
		IoTValidation ioTValidation, ServiceContext serviceContext) {

		return getPersistence().update(ioTValidation, serviceContext);
	}

	/**
	 * Returns all the io t validations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching io t validations
	 */
	public static List<IoTValidation> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the io t validations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	public static List<IoTValidation> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the io t validations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByUuid_First(
			String uuid, OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByUuid_First(
		String uuid, OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByUuid_Last(
			String uuid, OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByUuid_Last(
		String uuid, OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation[] findByUuid_PrevAndNext(
			long iotValidationId, String uuid,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByUuid_PrevAndNext(
			iotValidationId, uuid, orderByComparator);
	}

	/**
	 * Removes all the io t validations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of io t validations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching io t validations
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the io t validation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the io t validation that was removed
	 */
	public static IoTValidation removeByUUID_G(String uuid, long groupId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of io t validations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching io t validations
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching io t validations
	 */
	public static List<IoTValidation> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	public static List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation[] findByUuid_C_PrevAndNext(
			long iotValidationId, String uuid, long companyId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByUuid_C_PrevAndNext(
			iotValidationId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the io t validations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching io t validations
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the io t validations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t validations
	 */
	public static List<IoTValidation> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the io t validations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	public static List<IoTValidation> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the io t validations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByGroupId_First(
			long groupId, OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByGroupId_First(
		long groupId, OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByGroupId_Last(
			long groupId, OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByGroupId_Last(
		long groupId, OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation[] findByGroupId_PrevAndNext(
			long iotValidationId, long groupId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByGroupId_PrevAndNext(
			iotValidationId, groupId, orderByComparator);
	}

	/**
	 * Returns all the io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t validations that the user has permission to view
	 */
	public static List<IoTValidation> filterFindByGroupId(long groupId) {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	 * Returns a range of all the io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations that the user has permission to view
	 */
	public static List<IoTValidation> filterFindByGroupId(
		long groupId, int start, int end) {

		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations that the user has permission to view
	 */
	public static List<IoTValidation> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().filterFindByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set of io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation[] filterFindByGroupId_PrevAndNext(
			long iotValidationId, long groupId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().filterFindByGroupId_PrevAndNext(
			iotValidationId, groupId, orderByComparator);
	}

	/**
	 * Removes all the io t validations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of io t validations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t validations
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns the number of io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t validations that the user has permission to view
	 */
	public static int filterCountByGroupId(long groupId) {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	 * Returns the io t validation where originalId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByOriginalId(String originalId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByOriginalId(originalId);
	}

	/**
	 * Returns the io t validation where originalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByOriginalId(String originalId) {
		return getPersistence().fetchByOriginalId(originalId);
	}

	/**
	 * Returns the io t validation where originalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByOriginalId(
		String originalId, boolean useFinderCache) {

		return getPersistence().fetchByOriginalId(originalId, useFinderCache);
	}

	/**
	 * Removes the io t validation where originalId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @return the io t validation that was removed
	 */
	public static IoTValidation removeByOriginalId(String originalId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().removeByOriginalId(originalId);
	}

	/**
	 * Returns the number of io t validations where originalId = &#63;.
	 *
	 * @param originalId the original ID
	 * @return the number of matching io t validations
	 */
	public static int countByOriginalId(String originalId) {
		return getPersistence().countByOriginalId(originalId);
	}

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByOID_S(
			String originalId, long subscriptionId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByOID_S(originalId, subscriptionId);
	}

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByOID_S(
		String originalId, long subscriptionId) {

		return getPersistence().fetchByOID_S(originalId, subscriptionId);
	}

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByOID_S(
		String originalId, long subscriptionId, boolean useFinderCache) {

		return getPersistence().fetchByOID_S(
			originalId, subscriptionId, useFinderCache);
	}

	/**
	 * Removes the io t validation where originalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the io t validation that was removed
	 */
	public static IoTValidation removeByOID_S(
			String originalId, long subscriptionId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().removeByOID_S(originalId, subscriptionId);
	}

	/**
	 * Returns the number of io t validations where originalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t validations
	 */
	public static int countByOID_S(String originalId, long subscriptionId) {
		return getPersistence().countByOID_S(originalId, subscriptionId);
	}

	/**
	 * Returns all the io t validations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching io t validations
	 */
	public static List<IoTValidation> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the io t validations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	public static List<IoTValidation> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByStatus(
		int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the io t validations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByStatus(
		int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByStatus_First(
			int status, OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByStatus_First(
		int status, OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByStatus_Last(
			int status, OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByStatus_Last(
		int status, OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where status = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation[] findByStatus_PrevAndNext(
			long iotValidationId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByStatus_PrevAndNext(
			iotValidationId, status, orderByComparator);
	}

	/**
	 * Removes all the io t validations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of io t validations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching io t validations
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Returns all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t validations
	 */
	public static List<IoTValidation> findByG_S(long groupId, int status) {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	public static List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByG_S(
			groupId, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByG_S_First(
			long groupId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByG_S_First(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findByG_S_Last(
			long groupId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchByG_S_Last(
			groupId, status, orderByComparator);
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation[] findByG_S_PrevAndNext(
			long iotValidationId, long groupId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByG_S_PrevAndNext(
			iotValidationId, groupId, status, orderByComparator);
	}

	/**
	 * Returns all the io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t validations that the user has permission to view
	 */
	public static List<IoTValidation> filterFindByG_S(
		long groupId, int status) {

		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	 * Returns a range of all the io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations that the user has permission to view
	 */
	public static List<IoTValidation> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations that the user has permission to view
	 */
	public static List<IoTValidation> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().filterFindByG_S(
			groupId, status, start, end, orderByComparator);
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set of io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation[] filterFindByG_S_PrevAndNext(
			long iotValidationId, long groupId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().filterFindByG_S_PrevAndNext(
			iotValidationId, groupId, status, orderByComparator);
	}

	/**
	 * Removes all the io t validations where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public static void removeByG_S(long groupId, int status) {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	 * Returns the number of io t validations where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t validations
	 */
	public static int countByG_S(long groupId, int status) {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	 * Returns the number of io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t validations that the user has permission to view
	 */
	public static int filterCountByG_S(long groupId, int status) {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	 * Returns all the io t validations where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validations
	 */
	public static List<IoTValidation> findBySubscriptionId(
		long subscriptionId) {

		return getPersistence().findBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns a range of all the io t validations where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	public static List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the io t validations where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	public static List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the first io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public static IoTValidation findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the last io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation[] findBySubscriptionId_PrevAndNext(
			long iotValidationId, long subscriptionId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findBySubscriptionId_PrevAndNext(
			iotValidationId, subscriptionId, orderByComparator);
	}

	/**
	 * Removes all the io t validations where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public static void removeBySubscriptionId(long subscriptionId) {
		getPersistence().removeBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns the number of io t validations where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t validations
	 */
	public static int countBySubscriptionId(long subscriptionId) {
		return getPersistence().countBySubscriptionId(subscriptionId);
	}

	/**
	 * Caches the io t validation in the entity cache if it is enabled.
	 *
	 * @param ioTValidation the io t validation
	 */
	public static void cacheResult(IoTValidation ioTValidation) {
		getPersistence().cacheResult(ioTValidation);
	}

	/**
	 * Caches the io t validations in the entity cache if it is enabled.
	 *
	 * @param ioTValidations the io t validations
	 */
	public static void cacheResult(List<IoTValidation> ioTValidations) {
		getPersistence().cacheResult(ioTValidations);
	}

	/**
	 * Creates a new io t validation with the primary key. Does not add the io t validation to the database.
	 *
	 * @param iotValidationId the primary key for the new io t validation
	 * @return the new io t validation
	 */
	public static IoTValidation create(long iotValidationId) {
		return getPersistence().create(iotValidationId);
	}

	/**
	 * Removes the io t validation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation that was removed
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation remove(long iotValidationId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().remove(iotValidationId);
	}

	public static IoTValidation updateImpl(IoTValidation ioTValidation) {
		return getPersistence().updateImpl(ioTValidation);
	}

	/**
	 * Returns the io t validation with the primary key or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation findByPrimaryKey(long iotValidationId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getPersistence().findByPrimaryKey(iotValidationId);
	}

	/**
	 * Returns the io t validation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation, or <code>null</code> if a io t validation with the primary key could not be found
	 */
	public static IoTValidation fetchByPrimaryKey(long iotValidationId) {
		return getPersistence().fetchByPrimaryKey(iotValidationId);
	}

	/**
	 * Returns all the io t validations.
	 *
	 * @return the io t validations
	 */
	public static List<IoTValidation> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the io t validations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of io t validations
	 */
	public static List<IoTValidation> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the io t validations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of io t validations
	 */
	public static List<IoTValidation> findAll(
		int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the io t validations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of io t validations
	 */
	public static List<IoTValidation> findAll(
		int start, int end, OrderByComparator<IoTValidation> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the io t validations from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of io t validations.
	 *
	 * @return the number of io t validations
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IoTValidationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<IoTValidationPersistence, IoTValidationPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IoTValidationPersistence.class);

		ServiceTracker<IoTValidationPersistence, IoTValidationPersistence>
			serviceTracker =
				new ServiceTracker
					<IoTValidationPersistence, IoTValidationPersistence>(
						bundle.getBundleContext(),
						IoTValidationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}