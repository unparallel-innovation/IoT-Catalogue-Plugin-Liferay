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

import com.iot_catalogue.model.ElementCoordinate;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ElementCoordinate. This utility wraps
 * <code>com.iot_catalogue.service.impl.ElementCoordinateLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ElementCoordinateLocalService
 * @generated
 */
public class ElementCoordinateLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.iot_catalogue.service.impl.ElementCoordinateLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the element coordinate to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementCoordinateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementCoordinate the element coordinate
	 * @return the element coordinate that was added
	 */
	public static ElementCoordinate addElementCoordinate(
		ElementCoordinate elementCoordinate) {

		return getService().addElementCoordinate(elementCoordinate);
	}

	public static ElementCoordinate addElementCoordinate(
			long userId, String originalId, String elementClassName,
			double latitude, double longitude, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addElementCoordinate(
			userId, originalId, elementClassName, latitude, longitude,
			subscriptionId, serviceContext);
	}

	/**
	 * Creates a new element coordinate with the primary key. Does not add the element coordinate to the database.
	 *
	 * @param elementCoordinateId the primary key for the new element coordinate
	 * @return the new element coordinate
	 */
	public static ElementCoordinate createElementCoordinate(
		long elementCoordinateId) {

		return getService().createElementCoordinate(elementCoordinateId);
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
	 * Deletes the element coordinate from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementCoordinateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementCoordinate the element coordinate
	 * @return the element coordinate that was removed
	 */
	public static ElementCoordinate deleteElementCoordinate(
		ElementCoordinate elementCoordinate) {

		return getService().deleteElementCoordinate(elementCoordinate);
	}

	/**
	 * Deletes the element coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementCoordinateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate that was removed
	 * @throws PortalException if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate deleteElementCoordinate(
			long elementCoordinateId)
		throws PortalException {

		return getService().deleteElementCoordinate(elementCoordinateId);
	}

	public static List<ElementCoordinate> deleteElementCoordinates(
		long subscriptionId, String originalId, String elementClassName) {

		return getService().deleteElementCoordinates(
			subscriptionId, originalId, elementClassName);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementCoordinateModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementCoordinateModelImpl</code>.
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

	public static ElementCoordinate fetchElementCoordinate(
		long elementCoordinateId) {

		return getService().fetchElementCoordinate(elementCoordinateId);
	}

	/**
	 * Returns the element coordinate matching the UUID and group.
	 *
	 * @param uuid the element coordinate's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	public static ElementCoordinate fetchElementCoordinateByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchElementCoordinateByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the element coordinate with the primary key.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate
	 * @throws PortalException if a element coordinate with the primary key could not be found
	 */
	public static ElementCoordinate getElementCoordinate(
			long elementCoordinateId)
		throws PortalException {

		return getService().getElementCoordinate(elementCoordinateId);
	}

	/**
	 * Returns the element coordinate matching the UUID and group.
	 *
	 * @param uuid the element coordinate's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element coordinate
	 * @throws PortalException if a matching element coordinate could not be found
	 */
	public static ElementCoordinate getElementCoordinateByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getElementCoordinateByUuidAndGroupId(uuid, groupId);
	}

	public static List<ElementCoordinate> getElementCoordinates() {
		return getService().getElementCoordinates();
	}

	/**
	 * Returns a range of all the element coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of element coordinates
	 */
	public static List<ElementCoordinate> getElementCoordinates(
		int start, int end) {

		return getService().getElementCoordinates(start, end);
	}

	public static List<ElementCoordinate> getElementCoordinates(
		long subscriptionId, String originalId, String elementClassName) {

		return getService().getElementCoordinates(
			subscriptionId, originalId, elementClassName);
	}

	public static List<ElementCoordinate> getElementCoordinatesByGroupId(
		long groupId) {

		return getService().getElementCoordinatesByGroupId(groupId);
	}

	public static List<ElementCoordinate> getElementCoordinatesBySubscriptionId(
		long subscriptionId) {

		return getService().getElementCoordinatesBySubscriptionId(
			subscriptionId);
	}

	/**
	 * Returns all the element coordinates matching the UUID and company.
	 *
	 * @param uuid the UUID of the element coordinates
	 * @param companyId the primary key of the company
	 * @return the matching element coordinates, or an empty list if no matches were found
	 */
	public static List<ElementCoordinate>
		getElementCoordinatesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getElementCoordinatesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of element coordinates matching the UUID and company.
	 *
	 * @param uuid the UUID of the element coordinates
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching element coordinates, or an empty list if no matches were found
	 */
	public static List<ElementCoordinate>
		getElementCoordinatesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<ElementCoordinate> orderByComparator) {

		return getService().getElementCoordinatesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of element coordinates.
	 *
	 * @return the number of element coordinates
	 */
	public static int getElementCoordinatesCount() {
		return getService().getElementCoordinatesCount();
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
	 * Updates the element coordinate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementCoordinateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementCoordinate the element coordinate
	 * @return the element coordinate that was updated
	 */
	public static ElementCoordinate updateElementCoordinate(
		ElementCoordinate elementCoordinate) {

		return getService().updateElementCoordinate(elementCoordinate);
	}

	public static ElementCoordinateLocalService getService() {
		return _service;
	}

	private static volatile ElementCoordinateLocalService _service;

}