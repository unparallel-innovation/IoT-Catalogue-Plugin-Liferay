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

import com.iot_catalogue.exception.NoSuchComponentChildException;
import com.iot_catalogue.model.ComponentChild;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the component child service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComponentChildUtil
 * @generated
 */
@ProviderType
public interface ComponentChildPersistence
	extends BasePersistence<ComponentChild> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ComponentChildUtil} to access the component child persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the component childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching component childs
	 */
	public java.util.List<ComponentChild> findByUuid(String uuid);

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
	public java.util.List<ComponentChild> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ComponentChild> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

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
	public java.util.List<ComponentChild> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the first component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the last component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the last component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the component childs before and after the current component child in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public ComponentChild[] findByUuid_PrevAndNext(
			long id, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Removes all the component childs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of component childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching component childs
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchComponentChildException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByUUID_G(String uuid, long groupId)
		throws NoSuchComponentChildException;

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the component child where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the component child that was removed
	 */
	public ComponentChild removeByUUID_G(String uuid, long groupId)
		throws NoSuchComponentChildException;

	/**
	 * Returns the number of component childs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching component childs
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching component childs
	 */
	public java.util.List<ComponentChild> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

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
	public java.util.List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the first component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the last component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the last component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

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
	public ComponentChild[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Removes all the component childs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching component childs
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the component childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching component childs
	 */
	public java.util.List<ComponentChild> findByGroupId(long groupId);

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
	public java.util.List<ComponentChild> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<ComponentChild> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

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
	public java.util.List<ComponentChild> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the first component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the last component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the last component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the component childs before and after the current component child in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public ComponentChild[] findByGroupId_PrevAndNext(
			long id, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Removes all the component childs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of component childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching component childs
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the component childs where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @return the matching component childs
	 */
	public java.util.List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId);

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
	public java.util.List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end);

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
	public java.util.List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

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
	public java.util.List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByComponentOrignalId_First(
			String componentOrignalId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the first component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByComponentOrignalId_First(
		String componentOrignalId,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the last component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findByComponentOrignalId_Last(
			String componentOrignalId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the last component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchByComponentOrignalId_Last(
		String componentOrignalId,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the component childs before and after the current component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public ComponentChild[] findByComponentOrignalId_PrevAndNext(
			long id, String componentOrignalId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Removes all the component childs where componentOrignalId = &#63; from the database.
	 *
	 * @param componentOrignalId the component orignal ID
	 */
	public void removeByComponentOrignalId(String componentOrignalId);

	/**
	 * Returns the number of component childs where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @return the number of matching component childs
	 */
	public int countByComponentOrignalId(String componentOrignalId);

	/**
	 * Returns all the component childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching component childs
	 */
	public java.util.List<ComponentChild> findBySubscriptionId(
		long subscriptionId);

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
	public java.util.List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end);

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
	public java.util.List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

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
	public java.util.List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findBySubscriptionId_First(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the first component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchBySubscriptionId_First(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the last component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	public ComponentChild findBySubscriptionId_Last(
			long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Returns the last component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public ComponentChild fetchBySubscriptionId_Last(
		long subscriptionId,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

	/**
	 * Returns the component childs before and after the current component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public ComponentChild[] findBySubscriptionId_PrevAndNext(
			long id, long subscriptionId,
			com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
				orderByComparator)
		throws NoSuchComponentChildException;

	/**
	 * Removes all the component childs where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	public void removeBySubscriptionId(long subscriptionId);

	/**
	 * Returns the number of component childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching component childs
	 */
	public int countBySubscriptionId(long subscriptionId);

	/**
	 * Caches the component child in the entity cache if it is enabled.
	 *
	 * @param componentChild the component child
	 */
	public void cacheResult(ComponentChild componentChild);

	/**
	 * Caches the component childs in the entity cache if it is enabled.
	 *
	 * @param componentChilds the component childs
	 */
	public void cacheResult(java.util.List<ComponentChild> componentChilds);

	/**
	 * Creates a new component child with the primary key. Does not add the component child to the database.
	 *
	 * @param id the primary key for the new component child
	 * @return the new component child
	 */
	public ComponentChild create(long id);

	/**
	 * Removes the component child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the component child
	 * @return the component child that was removed
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public ComponentChild remove(long id) throws NoSuchComponentChildException;

	public ComponentChild updateImpl(ComponentChild componentChild);

	/**
	 * Returns the component child with the primary key or throws a <code>NoSuchComponentChildException</code> if it could not be found.
	 *
	 * @param id the primary key of the component child
	 * @return the component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	public ComponentChild findByPrimaryKey(long id)
		throws NoSuchComponentChildException;

	/**
	 * Returns the component child with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the component child
	 * @return the component child, or <code>null</code> if a component child with the primary key could not be found
	 */
	public ComponentChild fetchByPrimaryKey(long id);

	/**
	 * Returns all the component childs.
	 *
	 * @return the component childs
	 */
	public java.util.List<ComponentChild> findAll();

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
	public java.util.List<ComponentChild> findAll(int start, int end);

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
	public java.util.List<ComponentChild> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator);

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
	public java.util.List<ComponentChild> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ComponentChild>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the component childs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of component childs.
	 *
	 * @return the number of component childs
	 */
	public int countAll();

}