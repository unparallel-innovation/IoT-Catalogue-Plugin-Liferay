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

import com.iot_catalogue.exception.NoSuchSubscriptionException;
import com.iot_catalogue.model.Subscription;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionUtil
 * @generated
 */
@ProviderType
public interface SubscriptionPersistence extends BasePersistence<Subscription> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SubscriptionUtil} to access the subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the subscriptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching subscriptions
	 */
	public java.util.List<Subscription> findByUuid(String uuid);

	/**
	 * Returns a range of all the subscriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of matching subscriptions
	 */
	public java.util.List<Subscription> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the subscriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscriptions
	 */
	public java.util.List<Subscription> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subscriptions where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subscriptions
	 */
	public java.util.List<Subscription> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subscription in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public Subscription findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the first subscription in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns the last subscription in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public Subscription findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the last subscription in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns the subscriptions before and after the current subscription in the ordered set where uuid = &#63;.
	 *
	 * @param subscriptionId the primary key of the current subscription
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	public Subscription[] findByUuid_PrevAndNext(
			long subscriptionId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Removes all the subscriptions where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of subscriptions where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching subscriptions
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the subscription where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSubscriptionException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public Subscription findByUUID_G(String uuid, long groupId)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the subscription where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the subscription where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the subscription where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the subscription that was removed
	 */
	public Subscription removeByUUID_G(String uuid, long groupId)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the number of subscriptions where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching subscriptions
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the subscriptions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching subscriptions
	 */
	public java.util.List<Subscription> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the subscriptions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of matching subscriptions
	 */
	public java.util.List<Subscription> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the subscriptions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscriptions
	 */
	public java.util.List<Subscription> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subscriptions where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subscriptions
	 */
	public java.util.List<Subscription> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subscription in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public Subscription findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the first subscription in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns the last subscription in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public Subscription findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the last subscription in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns the subscriptions before and after the current subscription in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param subscriptionId the primary key of the current subscription
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	public Subscription[] findByUuid_C_PrevAndNext(
			long subscriptionId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Removes all the subscriptions where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of subscriptions where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching subscriptions
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching subscriptions
	 */
	public java.util.List<Subscription> findByGroupId(long groupId);

	/**
	 * Returns a range of all the subscriptions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of matching subscriptions
	 */
	public java.util.List<Subscription> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the subscriptions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching subscriptions
	 */
	public java.util.List<Subscription> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subscriptions where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching subscriptions
	 */
	public java.util.List<Subscription> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public Subscription findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the first subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns the last subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public Subscription findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the last subscription in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns the subscriptions before and after the current subscription in the ordered set where groupId = &#63;.
	 *
	 * @param subscriptionId the primary key of the current subscription
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	public Subscription[] findByGroupId_PrevAndNext(
			long subscriptionId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Subscription>
				orderByComparator)
		throws NoSuchSubscriptionException;

	/**
	 * Removes all the subscriptions where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of subscriptions where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching subscriptions
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns the subscription where subscriptionId = &#63; or throws a <code>NoSuchSubscriptionException</code> if it could not be found.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching subscription
	 * @throws NoSuchSubscriptionException if a matching subscription could not be found
	 */
	public Subscription findBySubscriptionId(long subscriptionId)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the subscription where subscriptionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchBySubscriptionId(long subscriptionId);

	/**
	 * Returns the subscription where subscriptionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param subscriptionId the subscription ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public Subscription fetchBySubscriptionId(
		long subscriptionId, boolean useFinderCache);

	/**
	 * Removes the subscription where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the subscription that was removed
	 */
	public Subscription removeBySubscriptionId(long subscriptionId)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the number of subscriptions where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching subscriptions
	 */
	public int countBySubscriptionId(long subscriptionId);

	/**
	 * Caches the subscription in the entity cache if it is enabled.
	 *
	 * @param subscription the subscription
	 */
	public void cacheResult(Subscription subscription);

	/**
	 * Caches the subscriptions in the entity cache if it is enabled.
	 *
	 * @param subscriptions the subscriptions
	 */
	public void cacheResult(java.util.List<Subscription> subscriptions);

	/**
	 * Creates a new subscription with the primary key. Does not add the subscription to the database.
	 *
	 * @param subscriptionId the primary key for the new subscription
	 * @return the new subscription
	 */
	public Subscription create(long subscriptionId);

	/**
	 * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription that was removed
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	public Subscription remove(long subscriptionId)
		throws NoSuchSubscriptionException;

	public Subscription updateImpl(Subscription subscription);

	/**
	 * Returns the subscription with the primary key or throws a <code>NoSuchSubscriptionException</code> if it could not be found.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription
	 * @throws NoSuchSubscriptionException if a subscription with the primary key could not be found
	 */
	public Subscription findByPrimaryKey(long subscriptionId)
		throws NoSuchSubscriptionException;

	/**
	 * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
	 */
	public Subscription fetchByPrimaryKey(long subscriptionId);

	/**
	 * Returns all the subscriptions.
	 *
	 * @return the subscriptions
	 */
	public java.util.List<Subscription> findAll();

	/**
	 * Returns a range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of subscriptions
	 */
	public java.util.List<Subscription> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of subscriptions
	 */
	public java.util.List<Subscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator);

	/**
	 * Returns an ordered range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of subscriptions
	 */
	public java.util.List<Subscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Subscription>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the subscriptions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of subscriptions.
	 *
	 * @return the number of subscriptions
	 */
	public int countAll();

}