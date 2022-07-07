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

import com.iot_catalogue.model.IoTValidation;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for IoTValidation. This utility wraps
 * <code>com.iot_catalogue.service.impl.IoTValidationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see IoTValidationLocalService
 * @generated
 */
public class IoTValidationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.iot_catalogue.service.impl.IoTValidationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static IoTValidation addIoTValidation(IoTValidation ioTValidation) {
		return getService().addIoTValidation(ioTValidation);
	}

	public static IoTValidation addIoTValidation(
			long userId, String name, String description, String website,
			String embeddedUrl, String imageUrl, String elementStatus,
			List<java.util.HashMap<String, Object>> categoriesPath,
			String originalId, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addIoTValidation(
			userId, name, description, website, embeddedUrl, imageUrl,
			elementStatus, categoriesPath, originalId, subscriptionId,
			serviceContext);
	}

	/**
	 * Creates a new io t validation with the primary key. Does not add the io t validation to the database.
	 *
	 * @param iotValidationId the primary key for the new io t validation
	 * @return the new io t validation
	 */
	public static IoTValidation createIoTValidation(long iotValidationId) {
		return getService().createIoTValidation(iotValidationId);
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
	 * Deletes the io t validation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTValidationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTValidation the io t validation
	 * @return the io t validation that was removed
	 */
	public static IoTValidation deleteIoTValidation(
		IoTValidation ioTValidation) {

		return getService().deleteIoTValidation(ioTValidation);
	}

	public static IoTValidation deleteIoTValidation(
			IoTValidation iotValidation,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().deleteIoTValidation(iotValidation, serviceContext);
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
	public static IoTValidation deleteIoTValidation(long iotValidationId)
		throws PortalException {

		return getService().deleteIoTValidation(iotValidationId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTValidationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTValidationModelImpl</code>.
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

	public static IoTValidation fetchIoTValidation(long iotValidationId) {
		return getService().fetchIoTValidation(iotValidationId);
	}

	/**
	 * Returns the io t validation matching the UUID and group.
	 *
	 * @param uuid the io t validation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	public static IoTValidation fetchIoTValidationByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchIoTValidationByUuidAndGroupId(uuid, groupId);
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
	 * Returns the io t validation with the primary key.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation
	 * @throws PortalException if a io t validation with the primary key could not be found
	 */
	public static IoTValidation getIoTValidation(long iotValidationId)
		throws PortalException {

		return getService().getIoTValidation(iotValidationId);
	}

	public static IoTValidation getIoTValidationByOriginalId(String originalId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getService().getIoTValidationByOriginalId(originalId);
	}

	public static IoTValidation getIoTValidationByOriginalId(
			String originalId, long subscriptionId)
		throws com.iot_catalogue.exception.NoSuchIoTValidationException {

		return getService().getIoTValidationByOriginalId(
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
	public static IoTValidation getIoTValidationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getIoTValidationByUuidAndGroupId(uuid, groupId);
	}

	public static List<IoTValidation> getIoTValidations() {
		return getService().getIoTValidations();
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
	public static List<IoTValidation> getIoTValidations(int start, int end) {
		return getService().getIoTValidations(start, end);
	}

	public static List<IoTValidation> getIoTValidations(long groupId) {
		return getService().getIoTValidations(groupId);
	}

	public static List<IoTValidation> getIoTValidations(
		long groupId, int start, int end) {

		return getService().getIoTValidations(groupId, start, end);
	}

	public static List<IoTValidation> getIoTValidations(
		long groupId, int start, int end,
		OrderByComparator<IoTValidation> obc) {

		return getService().getIoTValidations(groupId, start, end, obc);
	}

	public static List<IoTValidation> getIoTValidationsBySubscriptionId(
		long subscriptionId) {

		return getService().getIoTValidationsBySubscriptionId(subscriptionId);
	}

	public static List<IoTValidation> getIoTValidationsBySubscriptionId(
		long subscriptionId, int start, int end) {

		return getService().getIoTValidationsBySubscriptionId(
			subscriptionId, start, end);
	}

	/**
	 * Returns all the io t validations matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t validations
	 * @param companyId the primary key of the company
	 * @return the matching io t validations, or an empty list if no matches were found
	 */
	public static List<IoTValidation> getIoTValidationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getIoTValidationsByUuidAndCompanyId(
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
	public static List<IoTValidation> getIoTValidationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return getService().getIoTValidationsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of io t validations.
	 *
	 * @return the number of io t validations
	 */
	public static int getIoTValidationsCount() {
		return getService().getIoTValidationsCount();
	}

	public static int getIoTValidationsCount(long groupId) {
		return getService().getIoTValidationsCount(groupId);
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
	 * Updates the io t validation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTValidationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTValidation the io t validation
	 * @return the io t validation that was updated
	 */
	public static IoTValidation updateIoTValidation(
		IoTValidation ioTValidation) {

		return getService().updateIoTValidation(ioTValidation);
	}

	public static IoTValidation updateIoTValidation(
			long userId, long iotValidationId, String name, String description,
			String website, String embeddedUrl, String imageUrl,
			String elementStatus,
			List<java.util.HashMap<String, Object>> categoriesPath,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().updateIoTValidation(
			userId, iotValidationId, name, description, website, embeddedUrl,
			imageUrl, elementStatus, categoriesPath, serviceContext);
	}

	public static IoTValidationLocalService getService() {
		return _service;
	}

	private static volatile IoTValidationLocalService _service;

}