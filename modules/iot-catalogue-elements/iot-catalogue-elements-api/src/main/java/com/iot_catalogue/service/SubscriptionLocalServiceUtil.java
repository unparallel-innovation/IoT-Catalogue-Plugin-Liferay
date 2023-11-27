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

package com.iot_catalogue.service;

import com.iot_catalogue.model.Subscription;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Subscription. This utility wraps
 * <code>com.iot_catalogue.service.impl.SubscriptionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionLocalService
 * @generated
 */
public class SubscriptionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.iot_catalogue.service.impl.SubscriptionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Subscription addSubscription(
			long userId, long groupId, String token, String host,
			String componentPagePath, String validationPagePath,
			String manufacturerLabel, String developerLabel, Integer port,
			boolean useSSL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addSubscription(
			userId, groupId, token, host, componentPagePath, validationPagePath,
			manufacturerLabel, developerLabel, port, useSSL, serviceContext);
	}

	/**
	 * Adds the subscription to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubscriptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subscription the subscription
	 * @return the subscription that was added
	 */
	public static Subscription addSubscription(Subscription subscription) {
		return getService().addSubscription(subscription);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new subscription with the primary key. Does not add the subscription to the database.
	 *
	 * @param subscriptionId the primary key for the new subscription
	 * @return the new subscription
	 */
	public static Subscription createSubscription(long subscriptionId) {
		return getService().createSubscription(subscriptionId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubscriptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription that was removed
	 * @throws PortalException if a subscription with the primary key could not be found
	 */
	public static Subscription deleteSubscription(long subscriptionId)
		throws PortalException {

		return getService().deleteSubscription(subscriptionId);
	}

	/**
	 * Deletes the subscription from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubscriptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subscription the subscription
	 * @return the subscription that was removed
	 */
	public static Subscription deleteSubscription(Subscription subscription) {
		return getService().deleteSubscription(subscription);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Subscription fetchSubscription(long subscriptionId) {
		return getService().fetchSubscription(subscriptionId);
	}

	/**
	 * Returns the subscription matching the UUID and group.
	 *
	 * @param uuid the subscription's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	public static Subscription fetchSubscriptionByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchSubscriptionByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subscription with the primary key.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription
	 * @throws PortalException if a subscription with the primary key could not be found
	 */
	public static Subscription getSubscription(long subscriptionId)
		throws PortalException {

		return getService().getSubscription(subscriptionId);
	}

	public static Subscription getSubscriptionByGroupId(long groupId)
		throws com.iot_catalogue.exception.NoSuchSubscriptionException {

		return getService().getSubscriptionByGroupId(groupId);
	}

	public static Subscription getSubscriptionById(long subscriptionId)
		throws com.iot_catalogue.exception.NoSuchSubscriptionException {

		return getService().getSubscriptionById(subscriptionId);
	}

	/**
	 * Returns the subscription matching the UUID and group.
	 *
	 * @param uuid the subscription's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subscription
	 * @throws PortalException if a matching subscription could not be found
	 */
	public static Subscription getSubscriptionByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getSubscriptionByUuidAndGroupId(uuid, groupId);
	}

	public static int getSubscriptionCount() {
		return getService().getSubscriptionCount();
	}

	public static int getSubscriptionCount(long groupId) {
		return getService().getSubscriptionCount(groupId);
	}

	public static List<Subscription> getSubscriptions() {
		return getService().getSubscriptions();
	}

	/**
	 * Returns a range of all the subscriptions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.SubscriptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @return the range of subscriptions
	 */
	public static List<Subscription> getSubscriptions(int start, int end) {
		return getService().getSubscriptions(start, end);
	}

	public static List<Subscription> getSubscriptions(
		long groupId, int start, int end) {

		return getService().getSubscriptions(groupId, start, end);
	}

	/**
	 * Returns all the subscriptions matching the UUID and company.
	 *
	 * @param uuid the UUID of the subscriptions
	 * @param companyId the primary key of the company
	 * @return the matching subscriptions, or an empty list if no matches were found
	 */
	public static List<Subscription> getSubscriptionsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getSubscriptionsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of subscriptions matching the UUID and company.
	 *
	 * @param uuid the UUID of the subscriptions
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of subscriptions
	 * @param end the upper bound of the range of subscriptions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching subscriptions, or an empty list if no matches were found
	 */
	public static List<Subscription> getSubscriptionsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Subscription> orderByComparator) {

		return getService().getSubscriptionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of subscriptions.
	 *
	 * @return the number of subscriptions
	 */
	public static int getSubscriptionsCount() {
		return getService().getSubscriptionsCount();
	}

	public static Subscription setSubscriptionConnectionId(
			long subscriptionId, String connectionId)
		throws PortalException {

		return getService().setSubscriptionConnectionId(
			subscriptionId, connectionId);
	}

	public static Subscription setSubscriptionConnectionInfo(
			long subscriptionId, String connectionId, String connectionState)
		throws PortalException {

		return getService().setSubscriptionConnectionInfo(
			subscriptionId, connectionId, connectionState);
	}

	public static Subscription setSubscriptionConnectionState(
			long subscriptionId, String connectionState)
		throws PortalException {

		return getService().setSubscriptionConnectionState(
			subscriptionId, connectionState);
	}

	/**
	 * Updates the subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SubscriptionLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param subscription the subscription
	 * @return the subscription that was updated
	 */
	public static Subscription updateSubscription(Subscription subscription) {
		return getService().updateSubscription(subscription);
	}

	public static SubscriptionLocalService getService() {
		return _service;
	}

	private static volatile SubscriptionLocalService _service;

}