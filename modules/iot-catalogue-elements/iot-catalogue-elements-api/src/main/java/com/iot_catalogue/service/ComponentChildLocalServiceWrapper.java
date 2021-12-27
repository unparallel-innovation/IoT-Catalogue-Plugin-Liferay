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
 * Provides a wrapper for {@link ComponentChildLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ComponentChildLocalService
 * @generated
 */
public class ComponentChildLocalServiceWrapper
	implements ComponentChildLocalService,
			   ServiceWrapper<ComponentChildLocalService> {

	public ComponentChildLocalServiceWrapper(
		ComponentChildLocalService componentChildLocalService) {

		_componentChildLocalService = componentChildLocalService;
	}

	/**
	 * Adds the component child to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentChild the component child
	 * @return the component child that was added
	 */
	@Override
	public com.iot_catalogue.model.ComponentChild addComponentChild(
		com.iot_catalogue.model.ComponentChild componentChild) {

		return _componentChildLocalService.addComponentChild(componentChild);
	}

	@Override
	public com.iot_catalogue.model.ComponentChild addComponentChild(
			long userId, String componentOriginalId,
			String childComponentOriginalId, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentChildLocalService.addComponentChild(
			userId, componentOriginalId, childComponentOriginalId,
			subscriptionId, serviceContext);
	}

	/**
	 * Creates a new component child with the primary key. Does not add the component child to the database.
	 *
	 * @param id the primary key for the new component child
	 * @return the new component child
	 */
	@Override
	public com.iot_catalogue.model.ComponentChild createComponentChild(
		long id) {

		return _componentChildLocalService.createComponentChild(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentChildLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the component child from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentChild the component child
	 * @return the component child that was removed
	 */
	@Override
	public com.iot_catalogue.model.ComponentChild deleteComponentChild(
		com.iot_catalogue.model.ComponentChild componentChild) {

		return _componentChildLocalService.deleteComponentChild(componentChild);
	}

	/**
	 * Deletes the component child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the component child
	 * @return the component child that was removed
	 * @throws PortalException if a component child with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.ComponentChild deleteComponentChild(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentChildLocalService.deleteComponentChild(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentChildLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _componentChildLocalService.dynamicQuery();
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

		return _componentChildLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ComponentChildModelImpl</code>.
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

		return _componentChildLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ComponentChildModelImpl</code>.
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

		return _componentChildLocalService.dynamicQuery(
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

		return _componentChildLocalService.dynamicQueryCount(dynamicQuery);
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

		return _componentChildLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.iot_catalogue.model.ComponentChild fetchComponentChild(long id) {
		return _componentChildLocalService.fetchComponentChild(id);
	}

	/**
	 * Returns the component child matching the UUID and group.
	 *
	 * @param uuid the component child's UUID
	 * @param groupId the primary key of the group
	 * @return the matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public com.iot_catalogue.model.ComponentChild
		fetchComponentChildByUuidAndGroupId(String uuid, long groupId) {

		return _componentChildLocalService.fetchComponentChildByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _componentChildLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the component child with the primary key.
	 *
	 * @param id the primary key of the component child
	 * @return the component child
	 * @throws PortalException if a component child with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.ComponentChild getComponentChild(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentChildLocalService.getComponentChild(id);
	}

	/**
	 * Returns the component child matching the UUID and group.
	 *
	 * @param uuid the component child's UUID
	 * @param groupId the primary key of the group
	 * @return the matching component child
	 * @throws PortalException if a matching component child could not be found
	 */
	@Override
	public com.iot_catalogue.model.ComponentChild
			getComponentChildByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentChildLocalService.getComponentChildByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ComponentChild>
		getComponentChilds() {

		return _componentChildLocalService.getComponentChilds();
	}

	/**
	 * Returns a range of all the component childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of component childs
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ComponentChild>
		getComponentChilds(int start, int end) {

		return _componentChildLocalService.getComponentChilds(start, end);
	}

	/**
	 * Returns all the component childs matching the UUID and company.
	 *
	 * @param uuid the UUID of the component childs
	 * @param companyId the primary key of the company
	 * @return the matching component childs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ComponentChild>
		getComponentChildsByUuidAndCompanyId(String uuid, long companyId) {

		return _componentChildLocalService.getComponentChildsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of component childs matching the UUID and company.
	 *
	 * @param uuid the UUID of the component childs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching component childs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ComponentChild>
		getComponentChildsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.ComponentChild> orderByComparator) {

		return _componentChildLocalService.getComponentChildsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of component childs.
	 *
	 * @return the number of component childs
	 */
	@Override
	public int getComponentChildsCount() {
		return _componentChildLocalService.getComponentChildsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _componentChildLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _componentChildLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _componentChildLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _componentChildLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the component child in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentChild the component child
	 * @return the component child that was updated
	 */
	@Override
	public com.iot_catalogue.model.ComponentChild updateComponentChild(
		com.iot_catalogue.model.ComponentChild componentChild) {

		return _componentChildLocalService.updateComponentChild(componentChild);
	}

	@Override
	public ComponentChildLocalService getWrappedService() {
		return _componentChildLocalService;
	}

	@Override
	public void setWrappedService(
		ComponentChildLocalService componentChildLocalService) {

		_componentChildLocalService = componentChildLocalService;
	}

	private ComponentChildLocalService _componentChildLocalService;

}