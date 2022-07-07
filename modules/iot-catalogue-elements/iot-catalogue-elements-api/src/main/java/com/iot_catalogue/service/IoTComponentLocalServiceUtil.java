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

import com.iot_catalogue.model.IoTComponent;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for IoTComponent. This utility wraps
 * <code>com.iot_catalogue.service.impl.IoTComponentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IoTComponentLocalService
 * @generated
 */
public class IoTComponentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.iot_catalogue.service.impl.IoTComponentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the io t component to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTComponent the io t component
	 * @return the io t component that was added
	 */
	public static IoTComponent addIoTComponent(IoTComponent ioTComponent) {
		return getService().addIoTComponent(ioTComponent);
	}

	public static IoTComponent addIoTComponent(
			long userId, String name, String description, String website,
			String embeddedUrl, String imageUrl, String elementStatus,
			List<java.util.HashMap<String, Object>> categoriesPath,
			String originalId, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addIoTComponent(
			userId, name, description, website, embeddedUrl, imageUrl,
			elementStatus, categoriesPath, originalId, subscriptionId,
			serviceContext);
	}

	/**
	 * Creates a new io t component with the primary key. Does not add the io t component to the database.
	 *
	 * @param iotComponentId the primary key for the new io t component
	 * @return the new io t component
	 */
	public static IoTComponent createIoTComponent(long iotComponentId) {
		return getService().createIoTComponent(iotComponentId);
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
	 * Deletes the io t component from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTComponent the io t component
	 * @return the io t component that was removed
	 */
	public static IoTComponent deleteIoTComponent(IoTComponent ioTComponent) {
		return getService().deleteIoTComponent(ioTComponent);
	}

	public static IoTComponent deleteIoTComponent(
			IoTComponent iotComponent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().deleteIoTComponent(iotComponent, serviceContext);
	}

	/**
	 * Deletes the io t component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component that was removed
	 * @throws PortalException if a io t component with the primary key could not be found
	 */
	public static IoTComponent deleteIoTComponent(long iotComponentId)
		throws PortalException {

		return getService().deleteIoTComponent(iotComponentId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTComponentModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTComponentModelImpl</code>.
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

	public static IoTComponent fetchIoTComponent(long iotComponentId) {
		return getService().fetchIoTComponent(iotComponentId);
	}

	/**
	 * Returns the io t component matching the UUID and group.
	 *
	 * @param uuid the io t component's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	public static IoTComponent fetchIoTComponentByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchIoTComponentByUuidAndGroupId(uuid, groupId);
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
	 * Returns the io t component with the primary key.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component
	 * @throws PortalException if a io t component with the primary key could not be found
	 */
	public static IoTComponent getIoTComponent(long iotComponentId)
		throws PortalException {

		return getService().getIoTComponent(iotComponentId);
	}

	public static IoTComponent getIoTComponentByOriginalId(String originalId)
		throws com.iot_catalogue.exception.NoSuchIoTComponentException {

		return getService().getIoTComponentByOriginalId(originalId);
	}

	public static IoTComponent getIoTComponentByOriginalId(
			String originalId, long subscriptionId)
		throws com.iot_catalogue.exception.NoSuchIoTComponentException {

		return getService().getIoTComponentByOriginalId(
			originalId, subscriptionId);
	}

	/**
	 * Returns the io t component matching the UUID and group.
	 *
	 * @param uuid the io t component's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t component
	 * @throws PortalException if a matching io t component could not be found
	 */
	public static IoTComponent getIoTComponentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getIoTComponentByUuidAndGroupId(uuid, groupId);
	}

	public static List<IoTComponent> getIoTComponents() {
		return getService().getIoTComponents();
	}

	/**
	 * Returns a range of all the io t components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of io t components
	 */
	public static List<IoTComponent> getIoTComponents(int start, int end) {
		return getService().getIoTComponents(start, end);
	}

	public static List<IoTComponent> getIoTComponents(long groupId) {
		return getService().getIoTComponents(groupId);
	}

	public static List<IoTComponent> getIoTComponents(
		long groupId, int start, int end) {

		return getService().getIoTComponents(groupId, start, end);
	}

	public static List<IoTComponent> getIoTComponents(
		long groupId, int start, int end, OrderByComparator<IoTComponent> obc) {

		return getService().getIoTComponents(groupId, start, end, obc);
	}

	public static List<IoTComponent> getIoTComponentsBySubscriptionId(
		long subscriptionId) {

		return getService().getIoTComponentsBySubscriptionId(subscriptionId);
	}

	public static List<IoTComponent> getIoTComponentsBySubscriptionId(
		long subscriptionId, int start, int end) {

		return getService().getIoTComponentsBySubscriptionId(
			subscriptionId, start, end);
	}

	/**
	 * Returns all the io t components matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t components
	 * @param companyId the primary key of the company
	 * @return the matching io t components, or an empty list if no matches were found
	 */
	public static List<IoTComponent> getIoTComponentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getIoTComponentsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of io t components matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t components
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching io t components, or an empty list if no matches were found
	 */
	public static List<IoTComponent> getIoTComponentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		return getService().getIoTComponentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of io t components.
	 *
	 * @return the number of io t components
	 */
	public static int getIoTComponentsCount() {
		return getService().getIoTComponentsCount();
	}

	public static int getIoTComponentsCount(long groupId) {
		return getService().getIoTComponentsCount(groupId);
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

	public static void test() {
		getService().test();
	}

	/**
	 * Updates the io t component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTComponent the io t component
	 * @return the io t component that was updated
	 */
	public static IoTComponent updateIoTComponent(IoTComponent ioTComponent) {
		return getService().updateIoTComponent(ioTComponent);
	}

	public static IoTComponent updateIoTComponent(
			long userId, long iotComponentId, String name, String description,
			String website, String embeddedUrl, String imageUrl,
			String elementStatus,
			List<java.util.HashMap<String, Object>> categoriesPath,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateIoTComponent(
			userId, iotComponentId, name, description, website, embeddedUrl,
			imageUrl, elementStatus, categoriesPath, serviceContext);
	}

	public static IoTComponentLocalService getService() {
		return _service;
	}

	private static volatile IoTComponentLocalService _service;

}