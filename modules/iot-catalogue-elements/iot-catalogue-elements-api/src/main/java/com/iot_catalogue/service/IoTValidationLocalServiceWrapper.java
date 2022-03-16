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
 * Provides a wrapper for {@link IoTValidationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see IoTValidationLocalService
 * @generated
 */
public class IoTValidationLocalServiceWrapper
	implements IoTValidationLocalService,
			   ServiceWrapper<IoTValidationLocalService> {

	public IoTValidationLocalServiceWrapper(
		IoTValidationLocalService ioTValidationLocalService) {

		_ioTValidationLocalService = ioTValidationLocalService;
	}

	/**
	 * Adds the io t validation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTValidationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTValidation the io t validation
	 * @return the io t validation that was added
	 */
	@Override
	public com.iot_catalogue.model.IoTValidation addIoTValidation(
		com.iot_catalogue.model.IoTValidation ioTValidation) {

		return _ioTValidationLocalService.addIoTValidation(ioTValidation);
	}

	@Override
	public com.iot_catalogue.model.IoTValidation addIoTValidation(
			long userId, String name, String description, String embeddedUrl,
			String imageUrl, java.util.List<java.util.List<String>> tagsPaths,
			String originalId, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.addIoTValidation(
			userId, name, description, embeddedUrl, imageUrl, tagsPaths,
			originalId, subscriptionId, serviceContext);
	}

	/**
	 * Creates a new io t validation with the primary key. Does not add the io t validation to the database.
	 *
	 * @param iotValidationId the primary key for the new io t validation
	 * @return the new io t validation
	 */
	@Override
	public com.iot_catalogue.model.IoTValidation createIoTValidation(
		long iotValidationId) {

		return _ioTValidationLocalService.createIoTValidation(iotValidationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the io t validation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTValidationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTValidation the io t validation
	 * @return the io t validation that was removed
	 */
	@Override
	public com.iot_catalogue.model.IoTValidation deleteIoTValidation(
		com.iot_catalogue.model.IoTValidation ioTValidation) {

		return _ioTValidationLocalService.deleteIoTValidation(ioTValidation);
	}

	@Override
	public com.iot_catalogue.model.IoTValidation deleteIoTValidation(
			com.iot_catalogue.model.IoTValidation iotValidation,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.deleteIoTValidation(
			iotValidation, serviceContext);
	}

	/**
	 * Deletes the io t validation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTValidationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation that was removed
	 * @throws PortalException if a io t validation with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.IoTValidation deleteIoTValidation(
			long iotValidationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.deleteIoTValidation(iotValidationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ioTValidationLocalService.dynamicQuery();
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

		return _ioTValidationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTValidationModelImpl</code>.
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

		return _ioTValidationLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTValidationModelImpl</code>.
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

		return _ioTValidationLocalService.dynamicQuery(
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

		return _ioTValidationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ioTValidationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.iot_catalogue.model.IoTValidation fetchIoTValidation(
		long iotValidationId) {

		return _ioTValidationLocalService.fetchIoTValidation(iotValidationId);
	}

	/**
	 * Returns the io t validation matching the UUID and group.
	 *
	 * @param uuid the io t validation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public com.iot_catalogue.model.IoTValidation
		fetchIoTValidationByUuidAndGroupId(String uuid, long groupId) {

		return _ioTValidationLocalService.fetchIoTValidationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ioTValidationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ioTValidationLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ioTValidationLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the io t validation with the primary key.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation
	 * @throws PortalException if a io t validation with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.IoTValidation getIoTValidation(
			long iotValidationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.getIoTValidation(iotValidationId);
	}

	@Override
	public com.iot_catalogue.model.IoTValidation getIoTValidationByOriginalId(
			String originalId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return _ioTValidationLocalService.getIoTValidationByOriginalId(
			originalId);
	}

	@Override
	public com.iot_catalogue.model.IoTValidation getIoTValidationByOriginalId(
			String originalId, long subscriptionId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return _ioTValidationLocalService.getIoTValidationByOriginalId(
			originalId, subscriptionId);
	}

	/**
	 * Returns the io t validation matching the UUID and group.
	 *
	 * @param uuid the io t validation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t validation
	 * @throws PortalException if a matching io t validation could not be found
	 */
	@Override
	public com.iot_catalogue.model.IoTValidation
			getIoTValidationByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.getIoTValidationByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidations() {

		return _ioTValidationLocalService.getIoTValidations();
	}

	/**
	 * Returns a range of all the io t validations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of io t validations
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidations(int start, int end) {

		return _ioTValidationLocalService.getIoTValidations(start, end);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidations(long groupId) {

		return _ioTValidationLocalService.getIoTValidations(groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidations(long groupId, int start, int end) {

		return _ioTValidationLocalService.getIoTValidations(
			groupId, start, end);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidations(
			long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.IoTValidation> obc) {

		return _ioTValidationLocalService.getIoTValidations(
			groupId, start, end, obc);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidationsBySubscriptionId(long subscriptionId) {

		return _ioTValidationLocalService.getIoTValidationsBySubscriptionId(
			subscriptionId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidationsBySubscriptionId(
			long subscriptionId, int start, int end) {

		return _ioTValidationLocalService.getIoTValidationsBySubscriptionId(
			subscriptionId, start, end);
	}

	/**
	 * Returns all the io t validations matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t validations
	 * @param companyId the primary key of the company
	 * @return the matching io t validations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidationsByUuidAndCompanyId(String uuid, long companyId) {

		return _ioTValidationLocalService.getIoTValidationsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of io t validations matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t validations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching io t validations, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.IoTValidation>
		getIoTValidationsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.IoTValidation> orderByComparator) {

		return _ioTValidationLocalService.getIoTValidationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of io t validations.
	 *
	 * @return the number of io t validations
	 */
	@Override
	public int getIoTValidationsCount() {
		return _ioTValidationLocalService.getIoTValidationsCount();
	}

	@Override
	public int getIoTValidationsCount(long groupId) {
		return _ioTValidationLocalService.getIoTValidationsCount(groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ioTValidationLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the io t validation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTValidationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTValidation the io t validation
	 * @return the io t validation that was updated
	 */
	@Override
	public com.iot_catalogue.model.IoTValidation updateIoTValidation(
		com.iot_catalogue.model.IoTValidation ioTValidation) {

		return _ioTValidationLocalService.updateIoTValidation(ioTValidation);
	}

	@Override
	public com.iot_catalogue.model.IoTValidation updateIoTValidation(
			long userId, long iotValidationId, String name, String description,
			String embeddedUrl, String imageUrl,
			java.util.List<java.util.List<String>> tagsPaths,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ioTValidationLocalService.updateIoTValidation(
			userId, iotValidationId, name, description, embeddedUrl, imageUrl,
			tagsPaths, serviceContext);
	}

	@Override
	public IoTValidationLocalService getWrappedService() {
		return _ioTValidationLocalService;
	}

	@Override
	public void setWrappedService(
		IoTValidationLocalService ioTValidationLocalService) {

		_ioTValidationLocalService = ioTValidationLocalService;
	}

	private IoTValidationLocalService _ioTValidationLocalService;

}