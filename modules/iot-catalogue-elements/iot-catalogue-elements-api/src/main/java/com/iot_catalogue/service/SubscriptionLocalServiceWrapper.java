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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SubscriptionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionLocalService
 * @generated
 */
public class SubscriptionLocalServiceWrapper
	implements ServiceWrapper<SubscriptionLocalService>,
			   SubscriptionLocalService {

	public SubscriptionLocalServiceWrapper(
		SubscriptionLocalService subscriptionLocalService) {

		_subscriptionLocalService = subscriptionLocalService;
	}

	@Override
	public com.iot_catalogue.model.Subscription addSubscription(
			long userId, long groupId, String token, String host,
			String componentPagePath, String validationPagePath, Integer port,
			boolean useSSL,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.addSubscription(
			userId, groupId, token, host, componentPagePath, validationPagePath,
			port, useSSL, serviceContext);
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
	@Override
	public com.iot_catalogue.model.Subscription addSubscription(
		com.iot_catalogue.model.Subscription subscription) {

		return _subscriptionLocalService.addSubscription(subscription);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new subscription with the primary key. Does not add the subscription to the database.
	 *
	 * @param subscriptionId the primary key for the new subscription
	 * @return the new subscription
	 */
	@Override
	public com.iot_catalogue.model.Subscription createSubscription(
		long subscriptionId) {

		return _subscriptionLocalService.createSubscription(subscriptionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.iot_catalogue.model.Subscription deleteSubscription(
			long subscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.deleteSubscription(subscriptionId);
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
	@Override
	public com.iot_catalogue.model.Subscription deleteSubscription(
		com.iot_catalogue.model.Subscription subscription) {

		return _subscriptionLocalService.deleteSubscription(subscription);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _subscriptionLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _subscriptionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _subscriptionLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _subscriptionLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _subscriptionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _subscriptionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.iot_catalogue.model.Subscription fetchSubscription(
		long subscriptionId) {

		return _subscriptionLocalService.fetchSubscription(subscriptionId);
	}

	/**
	 * Returns the subscription matching the UUID and group.
	 *
	 * @param uuid the subscription's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subscription, or <code>null</code> if a matching subscription could not be found
	 */
	@Override
	public com.iot_catalogue.model.Subscription
		fetchSubscriptionByUuidAndGroupId(String uuid, long groupId) {

		return _subscriptionLocalService.fetchSubscriptionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _subscriptionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _subscriptionLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _subscriptionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _subscriptionLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the subscription with the primary key.
	 *
	 * @param subscriptionId the primary key of the subscription
	 * @return the subscription
	 * @throws PortalException if a subscription with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.Subscription getSubscription(
			long subscriptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.getSubscription(subscriptionId);
	}

	@Override
	public com.iot_catalogue.model.Subscription getSubscriptionByGroupId(
			long groupId)
		throws com.iot_catalogue.exception.NoSuchSubscriptionException {

		return _subscriptionLocalService.getSubscriptionByGroupId(groupId);
	}

	@Override
	public com.iot_catalogue.model.Subscription getSubscriptionById(
			long subscriptionId)
		throws com.iot_catalogue.exception.NoSuchSubscriptionException {

		return _subscriptionLocalService.getSubscriptionById(subscriptionId);
	}

	/**
	 * Returns the subscription matching the UUID and group.
	 *
	 * @param uuid the subscription's UUID
	 * @param groupId the primary key of the group
	 * @return the matching subscription
	 * @throws PortalException if a matching subscription could not be found
	 */
	@Override
	public com.iot_catalogue.model.Subscription getSubscriptionByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.getSubscriptionByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public int getSubscriptionCount() {
		return _subscriptionLocalService.getSubscriptionCount();
	}

	@Override
	public int getSubscriptionCount(long groupId) {
		return _subscriptionLocalService.getSubscriptionCount(groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.Subscription>
		getSubscriptions() {

		return _subscriptionLocalService.getSubscriptions();
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
	@Override
	public java.util.List<com.iot_catalogue.model.Subscription>
		getSubscriptions(int start, int end) {

		return _subscriptionLocalService.getSubscriptions(start, end);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.Subscription>
		getSubscriptions(long groupId, int start, int end) {

		return _subscriptionLocalService.getSubscriptions(groupId, start, end);
	}

	/**
	 * Returns all the subscriptions matching the UUID and company.
	 *
	 * @param uuid the UUID of the subscriptions
	 * @param companyId the primary key of the company
	 * @return the matching subscriptions, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.Subscription>
		getSubscriptionsByUuidAndCompanyId(String uuid, long companyId) {

		return _subscriptionLocalService.getSubscriptionsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.iot_catalogue.model.Subscription>
		getSubscriptionsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.Subscription> orderByComparator) {

		return _subscriptionLocalService.getSubscriptionsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of subscriptions.
	 *
	 * @return the number of subscriptions
	 */
	@Override
	public int getSubscriptionsCount() {
		return _subscriptionLocalService.getSubscriptionsCount();
	}

	@Override
	public com.iot_catalogue.model.Subscription setSubscriptionConnectionId(
			long subscriptionId, String connectionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.setSubscriptionConnectionId(
			subscriptionId, connectionId);
	}

	@Override
	public com.iot_catalogue.model.Subscription setSubscriptionConnectionInfo(
			long subscriptionId, String connectionId, String connectionState)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.setSubscriptionConnectionInfo(
			subscriptionId, connectionId, connectionState);
	}

	@Override
	public com.iot_catalogue.model.Subscription setSubscriptionConnectionState(
			long subscriptionId, String connectionState)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _subscriptionLocalService.setSubscriptionConnectionState(
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
	@Override
	public com.iot_catalogue.model.Subscription updateSubscription(
		com.iot_catalogue.model.Subscription subscription) {

		return _subscriptionLocalService.updateSubscription(subscription);
	}

	@Override
	public SubscriptionLocalService getWrappedService() {
		return _subscriptionLocalService;
	}

	@Override
	public void setWrappedService(
		SubscriptionLocalService subscriptionLocalService) {

		_subscriptionLocalService = subscriptionLocalService;
	}

	private SubscriptionLocalService _subscriptionLocalService;

}