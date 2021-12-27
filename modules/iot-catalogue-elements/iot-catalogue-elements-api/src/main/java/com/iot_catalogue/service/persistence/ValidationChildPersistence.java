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

import com.iot_catalogue.exception.NoSuchValidationChildException;
import com.iot_catalogue.model.ValidationChild;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the validation child service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ValidationChildUtil
 * @generated
 */
@ProviderType
public interface ValidationChildPersistence
	extends BasePersistence<ValidationChild> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ValidationChildUtil} to access the validation child persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the validation childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching validation childs
	 */
	public java.util.List<ValidationChild> findByUuid(String uuid);

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
	public java.util.List<ValidationChild> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ValidationChild> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

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
	public java.util.List<ValidationChild> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public ValidationChild[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Removes all the validation childs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of validation childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching validation childs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchValidationChildException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByUUID_G(String uuid, long groupId)
		throws NoSuchValidationChildException;

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the validation child where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the validation child that was removed
	 */
	public ValidationChild removeByUUID_G(String uuid, long groupId)
		throws NoSuchValidationChildException;

	/**
	 * Returns the number of validation childs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching validation childs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching validation childs
	 */
	public java.util.List<ValidationChild> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

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
	public java.util.List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

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
	public ValidationChild[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Removes all the validation childs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching validation childs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the validation childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching validation childs
	 */
	public java.util.List<ValidationChild> findByGroupId(long groupId);

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
	public java.util.List<ValidationChild> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ValidationChild> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

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
	public java.util.List<ValidationChild> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the first validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the last validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the last validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public ValidationChild[] findByGroupId_PrevAndNext(
			long id, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Removes all the validation childs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of validation childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching validation childs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the validation childs where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @return the matching validation childs
	 */
	public java.util.List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId);

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
	public java.util.List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end);

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
	public java.util.List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

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
	public java.util.List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByValidationOrignalId_First(
			String validationOrignalId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByValidationOrignalId_First(
		String validationOrignalId,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findByValidationOrignalId_Last(
			String validationOrignalId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchByValidationOrignalId_Last(
		String validationOrignalId,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public ValidationChild[] findByValidationOrignalId_PrevAndNext(
			long id, String validationOrignalId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Removes all the validation childs where validationOrignalId = &#63; from the database.
	 *
	 * @param validationOrignalId the validation orignal ID
	 */
	public void removeByValidationOrignalId(String validationOrignalId);

	/**
	 * Returns the number of validation childs where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @return the number of matching validation childs
	 */
	public int countByValidationOrignalId(String validationOrignalId);

	/**
	 * Returns all the validation childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching validation childs
	 */
	public java.util.List<ValidationChild> findBySubscriptionId(
		long subscriptionId);

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
	public java.util.List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end);

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
	public java.util.List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

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
	public java.util.List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findBySubscriptionId_First(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the first validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchBySubscriptionId_First(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the last validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	public ValidationChild findBySubscriptionId_Last(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Returns the last validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public ValidationChild fetchBySubscriptionId_Last(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public ValidationChild[] findBySubscriptionId_PrevAndNext(
			long id, long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
				orderByComparator)
		throws NoSuchValidationChildException;

	/**
	 * Removes all the validation childs where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public void removeBySubscriptionId(long subscriptionId);

	/**
	 * Returns the number of validation childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching validation childs
	 */
	public int countBySubscriptionId(long subscriptionId);

	/**
	 * Caches the validation child in the entity cache if it is enabled.
	 *
	 * @param validationChild the validation child
	 */
	public void cacheResult(ValidationChild validationChild);

	/**
	 * Caches the validation childs in the entity cache if it is enabled.
	 *
	 * @param validationChilds the validation childs
	 */
	public void cacheResult(java.util.List<ValidationChild> validationChilds);

	/**
	 * Creates a new validation child with the primary key. Does not add the validation child to the database.
	 *
	 * @param id the primary key for the new validation child
	 * @return the new validation child
	 */
	public ValidationChild create(long id);

	/**
	 * Removes the validation child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child that was removed
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public ValidationChild remove(long id)
		throws NoSuchValidationChildException;

	public ValidationChild updateImpl(ValidationChild validationChild);

	/**
	 * Returns the validation child with the primary key or throws a <code>NoSuchValidationChildException</code> if it could not be found.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	public ValidationChild findByPrimaryKey(long id)
		throws NoSuchValidationChildException;

	/**
	 * Returns the validation child with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child, or <code>null</code> if a validation child with the primary key could not be found
	 */
	public ValidationChild fetchByPrimaryKey(long id);

	/**
	 * Returns all the validation childs.
	 *
	 * @return the validation childs
	 */
	public java.util.List<ValidationChild> findAll();

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
	public java.util.List<ValidationChild> findAll(int start, int end);

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
	public java.util.List<ValidationChild> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator);

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
	public java.util.List<ValidationChild> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ValidationChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the validation childs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of validation childs.
	 *
	 * @return the number of validation childs
	 */
	public int countAll();

}