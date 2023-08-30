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
 * Provides a wrapper for {@link IoTComponentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IoTComponentLocalService
 * @generated
 */
public class IoTComponentLocalServiceWrapper
	implements IoTComponentLocalService,
			   ServiceWrapper<IoTComponentLocalService> {

	public IoTComponentLocalServiceWrapper(
		IoTComponentLocalService ioTComponentLocalService) {

		_ioTComponentLocalService = ioTComponentLocalService;
	}

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
	@Override
	public com.iot_catalogue.model.IoTComponent addIoTComponent(
		com.iot_catalogue.model.IoTComponent ioTComponent) {

		return _ioTComponentLocalService.addIoTComponent(ioTComponent);
	}

	@Override
	public com.iot_catalogue.model.IoTComponent addIoTComponent(
			long userId, String name, String description, String website,
			String embeddedUrl, String imageUrl, String elementStatus,
			String license, String trl,
			java.util.List<java.util.HashMap<String, Object>> categoriesPath,
			String originalId, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.addIoTComponent(
			userId, name, description, website, embeddedUrl, imageUrl,
			elementStatus, license, trl, categoriesPath, originalId,
			subscriptionId, serviceContext);
	}

	/**
	 * Creates a new io t component with the primary key. Does not add the io t component to the database.
	 *
	 * @param iotComponentId the primary key for the new io t component
	 * @return the new io t component
	 */
	@Override
	public com.iot_catalogue.model.IoTComponent createIoTComponent(
		long iotComponentId) {

		return _ioTComponentLocalService.createIoTComponent(iotComponentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.iot_catalogue.model.IoTComponent deleteIoTComponent(
		com.iot_catalogue.model.IoTComponent ioTComponent) {

		return _ioTComponentLocalService.deleteIoTComponent(ioTComponent);
	}

	@Override
	public com.iot_catalogue.model.IoTComponent deleteIoTComponent(
			com.iot_catalogue.model.IoTComponent iotComponent,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.deleteIoTComponent(
			iotComponent, serviceContext);
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
	@Override
	public com.iot_catalogue.model.IoTComponent deleteIoTComponent(
			long iotComponentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.deleteIoTComponent(iotComponentId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ioTComponentLocalService.dynamicQuery();
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

		return _ioTComponentLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ioTComponentLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ioTComponentLocalService.dynamicQuery(
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

		return _ioTComponentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ioTComponentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.iot_catalogue.model.IoTComponent fetchIoTComponent(
		long iotComponentId) {

		return _ioTComponentLocalService.fetchIoTComponent(iotComponentId);
	}

	/**
	 * Returns the io t component matching the UUID and group.
	 *
	 * @param uuid the io t component's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public com.iot_catalogue.model.IoTComponent
		fetchIoTComponentByUuidAndGroupId(String uuid, long groupId) {

		return _ioTComponentLocalService.fetchIoTComponentByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ioTComponentLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ioTComponentLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ioTComponentLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the io t component with the primary key.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component
	 * @throws PortalException if a io t component with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.IoTComponent getIoTComponent(
			long iotComponentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.getIoTComponent(iotComponentId);
	}

	@Override
	public com.iot_catalogue.model.IoTComponent getIoTComponentByOriginalId(
			String originalId)
		throws com.iot_catalogue.exception.NoSuchIoTComponentException {

		return _ioTComponentLocalService.getIoTComponentByOriginalId(
			originalId);
	}

	@Override
	public com.iot_catalogue.model.IoTComponent getIoTComponentByOriginalId(
			String originalId, long subscriptionId)
		throws com.iot_catalogue.exception.NoSuchIoTComponentException {

		return _ioTComponentLocalService.getIoTComponentByOriginalId(
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
	@Override
	public com.iot_catalogue.model.IoTComponent getIoTComponentByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.getIoTComponentByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponents() {

		return _ioTComponentLocalService.getIoTComponents();
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
	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponents(int start, int end) {

		return _ioTComponentLocalService.getIoTComponents(start, end);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponents(long groupId) {

		return _ioTComponentLocalService.getIoTComponents(groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponents(long groupId, int start, int end) {

		return _ioTComponentLocalService.getIoTComponents(groupId, start, end);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponents(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.IoTComponent> obc) {

		return _ioTComponentLocalService.getIoTComponents(
			groupId, start, end, obc);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponentsBySubscriptionId(long subscriptionId) {

		return _ioTComponentLocalService.getIoTComponentsBySubscriptionId(
			subscriptionId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponentsBySubscriptionId(
			long subscriptionId, int start, int end) {

		return _ioTComponentLocalService.getIoTComponentsBySubscriptionId(
			subscriptionId, start, end);
	}

	/**
	 * Returns all the io t components matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t components
	 * @param companyId the primary key of the company
	 * @return the matching io t components, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponentsByUuidAndCompanyId(String uuid, long companyId) {

		return _ioTComponentLocalService.getIoTComponentsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<com.iot_catalogue.model.IoTComponent>
		getIoTComponentsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.IoTComponent> orderByComparator) {

		return _ioTComponentLocalService.getIoTComponentsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of io t components.
	 *
	 * @return the number of io t components
	 */
	@Override
	public int getIoTComponentsCount() {
		return _ioTComponentLocalService.getIoTComponentsCount();
	}

	@Override
	public int getIoTComponentsCount(long groupId) {
		return _ioTComponentLocalService.getIoTComponentsCount(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ioTComponentLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public void test() {
		_ioTComponentLocalService.test();
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
	@Override
	public com.iot_catalogue.model.IoTComponent updateIoTComponent(
		com.iot_catalogue.model.IoTComponent ioTComponent) {

		return _ioTComponentLocalService.updateIoTComponent(ioTComponent);
	}

	@Override
	public com.iot_catalogue.model.IoTComponent updateIoTComponent(
			long userId, long iotComponentId, String name, String description,
			String website, String embeddedUrl, String imageUrl,
			String elementStatus, String license, String trl,
			java.util.List<java.util.HashMap<String, Object>> categoriesPath,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTComponentLocalService.updateIoTComponent(
			userId, iotComponentId, name, description, website, embeddedUrl,
			imageUrl, elementStatus, license, trl, categoriesPath,
			serviceContext);
	}

	@Override
	public IoTComponentLocalService getWrappedService() {
		return _ioTComponentLocalService;
	}

	@Override
	public void setWrappedService(
		IoTComponentLocalService ioTComponentLocalService) {

		_ioTComponentLocalService = ioTComponentLocalService;
	}

	private IoTComponentLocalService _ioTComponentLocalService;

}