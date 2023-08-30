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
 * Provides a wrapper for {@link ElementStandardLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElementStandardLocalService
 * @generated
 */
public class ElementStandardLocalServiceWrapper
	implements ElementStandardLocalService,
			   ServiceWrapper<ElementStandardLocalService> {

	public ElementStandardLocalServiceWrapper(
		ElementStandardLocalService elementStandardLocalService) {

		_elementStandardLocalService = elementStandardLocalService;
	}

	/**
	 * Adds the element standard to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementStandardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementStandard the element standard
	 * @return the element standard that was added
	 */
	@Override
	public com.iot_catalogue.model.ElementStandard addElementStandard(
		com.iot_catalogue.model.ElementStandard elementStandard) {

		return _elementStandardLocalService.addElementStandard(elementStandard);
	}

	/**
	 * Creates a new element standard with the primary key. Does not add the element standard to the database.
	 *
	 * @param elementStandardId the primary key for the new element standard
	 * @return the new element standard
	 */
	@Override
	public com.iot_catalogue.model.ElementStandard createElementStandard(
		long elementStandardId) {

		return _elementStandardLocalService.createElementStandard(
			elementStandardId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementStandardLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the element standard from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementStandardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementStandard the element standard
	 * @return the element standard that was removed
	 */
	@Override
	public com.iot_catalogue.model.ElementStandard deleteElementStandard(
		com.iot_catalogue.model.ElementStandard elementStandard) {

		return _elementStandardLocalService.deleteElementStandard(
			elementStandard);
	}

	/**
	 * Deletes the element standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementStandardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard that was removed
	 * @throws PortalException if a element standard with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementStandard deleteElementStandard(
			long elementStandardId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementStandardLocalService.deleteElementStandard(
			elementStandardId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementStandardLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _elementStandardLocalService.dynamicQuery();
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

		return _elementStandardLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementStandardModelImpl</code>.
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

		return _elementStandardLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementStandardModelImpl</code>.
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

		return _elementStandardLocalService.dynamicQuery(
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

		return _elementStandardLocalService.dynamicQueryCount(dynamicQuery);
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

		return _elementStandardLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.iot_catalogue.model.ElementStandard fetchElementStandard(
		long elementStandardId) {

		return _elementStandardLocalService.fetchElementStandard(
			elementStandardId);
	}

	/**
	 * Returns the element standard matching the UUID and group.
	 *
	 * @param uuid the element standard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementStandard
		fetchElementStandardByUuidAndGroupId(String uuid, long groupId) {

		return _elementStandardLocalService.
			fetchElementStandardByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _elementStandardLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the element standard with the primary key.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard
	 * @throws PortalException if a element standard with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementStandard getElementStandard(
			long elementStandardId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementStandardLocalService.getElementStandard(
			elementStandardId);
	}

	/**
	 * Returns the element standard matching the UUID and group.
	 *
	 * @param uuid the element standard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element standard
	 * @throws PortalException if a matching element standard could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementStandard
			getElementStandardByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementStandardLocalService.getElementStandardByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the element standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of element standards
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ElementStandard>
		getElementStandards(int start, int end) {

		return _elementStandardLocalService.getElementStandards(start, end);
	}

	/**
	 * Returns all the element standards matching the UUID and company.
	 *
	 * @param uuid the UUID of the element standards
	 * @param companyId the primary key of the company
	 * @return the matching element standards, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ElementStandard>
		getElementStandardsByUuidAndCompanyId(String uuid, long companyId) {

		return _elementStandardLocalService.
			getElementStandardsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of element standards matching the UUID and company.
	 *
	 * @param uuid the UUID of the element standards
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching element standards, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ElementStandard>
		getElementStandardsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.ElementStandard> orderByComparator) {

		return _elementStandardLocalService.
			getElementStandardsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of element standards.
	 *
	 * @return the number of element standards
	 */
	@Override
	public int getElementStandardsCount() {
		return _elementStandardLocalService.getElementStandardsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _elementStandardLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _elementStandardLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _elementStandardLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementStandardLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the element standard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementStandardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementStandard the element standard
	 * @return the element standard that was updated
	 */
	@Override
	public com.iot_catalogue.model.ElementStandard updateElementStandard(
		com.iot_catalogue.model.ElementStandard elementStandard) {

		return _elementStandardLocalService.updateElementStandard(
			elementStandard);
	}

	@Override
	public ElementStandardLocalService getWrappedService() {
		return _elementStandardLocalService;
	}

	@Override
	public void setWrappedService(
		ElementStandardLocalService elementStandardLocalService) {

		_elementStandardLocalService = elementStandardLocalService;
	}

	private ElementStandardLocalService _elementStandardLocalService;

}