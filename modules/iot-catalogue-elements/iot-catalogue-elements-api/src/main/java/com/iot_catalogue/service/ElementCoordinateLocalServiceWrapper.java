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
 * Provides a wrapper for {@link ElementCoordinateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElementCoordinateLocalService
 * @generated
 */
public class ElementCoordinateLocalServiceWrapper
	implements ElementCoordinateLocalService,
			   ServiceWrapper<ElementCoordinateLocalService> {

	public ElementCoordinateLocalServiceWrapper(
		ElementCoordinateLocalService elementCoordinateLocalService) {

		_elementCoordinateLocalService = elementCoordinateLocalService;
	}

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
	@Override
	public com.iot_catalogue.model.ElementCoordinate addElementCoordinate(
		com.iot_catalogue.model.ElementCoordinate elementCoordinate) {

		return _elementCoordinateLocalService.addElementCoordinate(
			elementCoordinate);
	}

	@Override
	public com.iot_catalogue.model.ElementCoordinate addElementCoordinate(
			long userId, String originalId, String elementClassName,
			double latitude, double longitude, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementCoordinateLocalService.addElementCoordinate(
			userId, originalId, elementClassName, latitude, longitude,
			subscriptionId, serviceContext);
	}

	/**
	 * Creates a new element coordinate with the primary key. Does not add the element coordinate to the database.
	 *
	 * @param elementCoordinateId the primary key for the new element coordinate
	 * @return the new element coordinate
	 */
	@Override
	public com.iot_catalogue.model.ElementCoordinate createElementCoordinate(
		long elementCoordinateId) {

		return _elementCoordinateLocalService.createElementCoordinate(
			elementCoordinateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementCoordinateLocalService.createPersistedModel(
			primaryKeyObj);
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
	@Override
	public com.iot_catalogue.model.ElementCoordinate deleteElementCoordinate(
		com.iot_catalogue.model.ElementCoordinate elementCoordinate) {

		return _elementCoordinateLocalService.deleteElementCoordinate(
			elementCoordinate);
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
	@Override
	public com.iot_catalogue.model.ElementCoordinate deleteElementCoordinate(
			long elementCoordinateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementCoordinateLocalService.deleteElementCoordinate(
			elementCoordinateId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementCoordinate>
		deleteElementCoordinates(
			long subscriptionId, String originalId, String elementClassName) {

		return _elementCoordinateLocalService.deleteElementCoordinates(
			subscriptionId, originalId, elementClassName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementCoordinateLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _elementCoordinateLocalService.dynamicQuery();
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

		return _elementCoordinateLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _elementCoordinateLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _elementCoordinateLocalService.dynamicQuery(
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

		return _elementCoordinateLocalService.dynamicQueryCount(dynamicQuery);
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

		return _elementCoordinateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.iot_catalogue.model.ElementCoordinate fetchElementCoordinate(
		long elementCoordinateId) {

		return _elementCoordinateLocalService.fetchElementCoordinate(
			elementCoordinateId);
	}

	/**
	 * Returns the element coordinate matching the UUID and group.
	 *
	 * @param uuid the element coordinate's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementCoordinate
		fetchElementCoordinateByUuidAndGroupId(String uuid, long groupId) {

		return _elementCoordinateLocalService.
			fetchElementCoordinateByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _elementCoordinateLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the element coordinate with the primary key.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate
	 * @throws PortalException if a element coordinate with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementCoordinate getElementCoordinate(
			long elementCoordinateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementCoordinateLocalService.getElementCoordinate(
			elementCoordinateId);
	}

	/**
	 * Returns the element coordinate matching the UUID and group.
	 *
	 * @param uuid the element coordinate's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element coordinate
	 * @throws PortalException if a matching element coordinate could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementCoordinate
			getElementCoordinateByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementCoordinateLocalService.
			getElementCoordinateByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementCoordinate>
		getElementCoordinates() {

		return _elementCoordinateLocalService.getElementCoordinates();
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
	@Override
	public java.util.List<com.iot_catalogue.model.ElementCoordinate>
		getElementCoordinates(int start, int end) {

		return _elementCoordinateLocalService.getElementCoordinates(start, end);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementCoordinate>
		getElementCoordinates(
			long subscriptionId, String originalId, String elementClassName) {

		return _elementCoordinateLocalService.getElementCoordinates(
			subscriptionId, originalId, elementClassName);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementCoordinate>
		getElementCoordinatesByGroupId(long groupId) {

		return _elementCoordinateLocalService.getElementCoordinatesByGroupId(
			groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementCoordinate>
		getElementCoordinatesBySubscriptionId(long subscriptionId) {

		return _elementCoordinateLocalService.
			getElementCoordinatesBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns all the element coordinates matching the UUID and company.
	 *
	 * @param uuid the UUID of the element coordinates
	 * @param companyId the primary key of the company
	 * @return the matching element coordinates, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ElementCoordinate>
		getElementCoordinatesByUuidAndCompanyId(String uuid, long companyId) {

		return _elementCoordinateLocalService.
			getElementCoordinatesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.iot_catalogue.model.ElementCoordinate>
		getElementCoordinatesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.ElementCoordinate> orderByComparator) {

		return _elementCoordinateLocalService.
			getElementCoordinatesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of element coordinates.
	 *
	 * @return the number of element coordinates
	 */
	@Override
	public int getElementCoordinatesCount() {
		return _elementCoordinateLocalService.getElementCoordinatesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _elementCoordinateLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _elementCoordinateLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _elementCoordinateLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementCoordinateLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.iot_catalogue.model.ElementCoordinate updateElementCoordinate(
		com.iot_catalogue.model.ElementCoordinate elementCoordinate) {

		return _elementCoordinateLocalService.updateElementCoordinate(
			elementCoordinate);
	}

	@Override
	public ElementCoordinateLocalService getWrappedService() {
		return _elementCoordinateLocalService;
	}

	@Override
	public void setWrappedService(
		ElementCoordinateLocalService elementCoordinateLocalService) {

		_elementCoordinateLocalService = elementCoordinateLocalService;
	}

	private ElementCoordinateLocalService _elementCoordinateLocalService;

}