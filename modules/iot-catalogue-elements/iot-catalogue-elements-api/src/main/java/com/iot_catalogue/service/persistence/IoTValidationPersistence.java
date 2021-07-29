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

import com.iot_catalogue.exception.NoSuchIoTValidationException;
import com.iot_catalogue.model.IoTValidation;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the io t validation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IoTValidationUtil
 * @generated
 */
@ProviderType
public interface IoTValidationPersistence
	extends BasePersistence<IoTValidation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IoTValidationUtil} to access the io t validation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the io t validations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching io t validations
	 */
	public java.util.List<IoTValidation> findByUuid(String uuid);

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
	public java.util.List<IoTValidation> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<IoTValidation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public java.util.List<IoTValidation> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public IoTValidation[] findByUuid_PrevAndNext(
			long iotValidationId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Removes all the io t validations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of io t validations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching io t validations
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByUUID_G(String uuid, long groupId)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the io t validation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the io t validation that was removed
	 */
	public IoTValidation removeByUUID_G(String uuid, long groupId)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the number of io t validations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching io t validations
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching io t validations
	 */
	public java.util.List<IoTValidation> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public java.util.List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public IoTValidation[] findByUuid_C_PrevAndNext(
			long iotValidationId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Removes all the io t validations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching io t validations
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the io t validations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t validations
	 */
	public java.util.List<IoTValidation> findByGroupId(long groupId);

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
	public java.util.List<IoTValidation> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<IoTValidation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public java.util.List<IoTValidation> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public IoTValidation[] findByGroupId_PrevAndNext(
			long iotValidationId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns all the io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t validations that the user has permission to view
	 */
	public java.util.List<IoTValidation> filterFindByGroupId(long groupId);

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
	public java.util.List<IoTValidation> filterFindByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<IoTValidation> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set of io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public IoTValidation[] filterFindByGroupId_PrevAndNext(
			long iotValidationId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Removes all the io t validations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of io t validations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t validations
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the number of io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t validations that the user has permission to view
	 */
	public int filterCountByGroupId(long groupId);

	/**
	 * Returns the io t validation where originalId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByOriginalId(String originalId)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the io t validation where originalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByOriginalId(String originalId);

	/**
	 * Returns the io t validation where originalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByOriginalId(
		String originalId, boolean useFinderCache);

	/**
	 * Removes the io t validation where originalId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @return the io t validation that was removed
	 */
	public IoTValidation removeByOriginalId(String originalId)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the number of io t validations where originalId = &#63;.
	 *
	 * @param originalId the original ID
	 * @return the number of matching io t validations
	 */
	public int countByOriginalId(String originalId);

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByOID_S(String originalId, long subscriptionId)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByOID_S(String originalId, long subscriptionId);

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByOID_S(
		String originalId, long subscriptionId, boolean useFinderCache);

	/**
	 * Removes the io t validation where originalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the io t validation that was removed
	 */
	public IoTValidation removeByOID_S(String originalId, long subscriptionId)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the number of io t validations where originalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t validations
	 */
	public int countByOID_S(String originalId, long subscriptionId);

	/**
	 * Returns all the io t validations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching io t validations
	 */
	public java.util.List<IoTValidation> findByStatus(int status);

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
	public java.util.List<IoTValidation> findByStatus(
		int status, int start, int end);

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
	public java.util.List<IoTValidation> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public java.util.List<IoTValidation> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the first io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the last io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the last io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where status = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public IoTValidation[] findByStatus_PrevAndNext(
			long iotValidationId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Removes all the io t validations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of io t validations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching io t validations
	 */
	public int countByStatus(int status);

	/**
	 * Returns all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t validations
	 */
	public java.util.List<IoTValidation> findByG_S(long groupId, int status);

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
	public java.util.List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public java.util.List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByG_S_First(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findByG_S_Last(
			long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public IoTValidation[] findByG_S_PrevAndNext(
			long iotValidationId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns all the io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t validations that the user has permission to view
	 */
	public java.util.List<IoTValidation> filterFindByG_S(
		long groupId, int status);

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
	public java.util.List<IoTValidation> filterFindByG_S(
		long groupId, int status, int start, int end);

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
	public java.util.List<IoTValidation> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public IoTValidation[] filterFindByG_S_PrevAndNext(
			long iotValidationId, long groupId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Removes all the io t validations where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	public void removeByG_S(long groupId, int status);

	/**
	 * Returns the number of io t validations where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t validations
	 */
	public int countByG_S(long groupId, int status);

	/**
	 * Returns the number of io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t validations that the user has permission to view
	 */
	public int filterCountByG_S(long groupId, int status);

	/**
	 * Returns all the io t validations where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validations
	 */
	public java.util.List<IoTValidation> findBySubscriptionId(
		long subscriptionId);

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
	public java.util.List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end);

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
	public java.util.List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public java.util.List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findBySubscriptionId_First(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the first io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchBySubscriptionId_First(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the last io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	public IoTValidation findBySubscriptionId_Last(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the last io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public IoTValidation fetchBySubscriptionId_Last(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public IoTValidation[] findBySubscriptionId_PrevAndNext(
			long iotValidationId, long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
				orderByComparator)
		throws NoSuchIoTValidationException;

	/**
	 * Removes all the io t validations where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public void removeBySubscriptionId(long subscriptionId);

	/**
	 * Returns the number of io t validations where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t validations
	 */
	public int countBySubscriptionId(long subscriptionId);

	/**
	 * Caches the io t validation in the entity cache if it is enabled.
	 *
	 * @param ioTValidation the io t validation
	 */
	public void cacheResult(IoTValidation ioTValidation);

	/**
	 * Caches the io t validations in the entity cache if it is enabled.
	 *
	 * @param ioTValidations the io t validations
	 */
	public void cacheResult(java.util.List<IoTValidation> ioTValidations);

	/**
	 * Creates a new io t validation with the primary key. Does not add the io t validation to the database.
	 *
	 * @param iotValidationId the primary key for the new io t validation
	 * @return the new io t validation
	 */
	public IoTValidation create(long iotValidationId);

	/**
	 * Removes the io t validation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation that was removed
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public IoTValidation remove(long iotValidationId)
		throws NoSuchIoTValidationException;

	public IoTValidation updateImpl(IoTValidation ioTValidation);

	/**
	 * Returns the io t validation with the primary key or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	public IoTValidation findByPrimaryKey(long iotValidationId)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the io t validation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation, or <code>null</code> if a io t validation with the primary key could not be found
	 */
	public IoTValidation fetchByPrimaryKey(long iotValidationId);

	/**
	 * Returns all the io t validations.
	 *
	 * @return the io t validations
	 */
	public java.util.List<IoTValidation> findAll();

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
	public java.util.List<IoTValidation> findAll(int start, int end);

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
	public java.util.List<IoTValidation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator);

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
	public java.util.List<IoTValidation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<IoTValidation>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the io t validations from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of io t validations.
	 *
	 * @return the number of io t validations
	 */
	public int countAll();

}