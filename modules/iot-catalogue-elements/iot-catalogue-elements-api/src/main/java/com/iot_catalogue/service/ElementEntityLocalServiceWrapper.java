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
 * Provides a wrapper for {@link ElementEntityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntityLocalService
 * @generated
 */
public class ElementEntityLocalServiceWrapper
	implements ElementEntityLocalService,
			   ServiceWrapper<ElementEntityLocalService> {

	public ElementEntityLocalServiceWrapper(
		ElementEntityLocalService elementEntityLocalService) {

		_elementEntityLocalService = elementEntityLocalService;
	}

	/**
	 * Adds the element entity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementEntity the element entity
	 * @return the element entity that was added
	 */
	@Override
	public com.iot_catalogue.model.ElementEntity addElementEntity(
		com.iot_catalogue.model.ElementEntity elementEntity) {

		return _elementEntityLocalService.addElementEntity(elementEntity);
	}

	@Override
	public com.iot_catalogue.model.ElementEntity addElementEntity(
			long userId, String originalId, String elementClassName,
			String name, String website, String label, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementEntityLocalService.addElementEntity(
			userId, originalId, elementClassName, name, website, label,
			subscriptionId, serviceContext);
	}

	/**
	 * Creates a new element entity with the primary key. Does not add the element entity to the database.
	 *
	 * @param elementEntityId the primary key for the new element entity
	 * @return the new element entity
	 */
	@Override
	public com.iot_catalogue.model.ElementEntity createElementEntity(
		long elementEntityId) {

		return _elementEntityLocalService.createElementEntity(elementEntityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementEntityLocalService.createPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		deleteElementEntities(
			long subscriptionId, String originalId, String elementClassName) {

		return _elementEntityLocalService.deleteElementEntities(
			subscriptionId, originalId, elementClassName);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		deleteElementEntities(
			long subscriptionId, String originalId, String elementClassName,
			String label) {

		return _elementEntityLocalService.deleteElementEntities(
			subscriptionId, originalId, elementClassName, label);
	}

	/**
	 * Deletes the element entity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementEntity the element entity
	 * @return the element entity that was removed
	 */
	@Override
	public com.iot_catalogue.model.ElementEntity deleteElementEntity(
		com.iot_catalogue.model.ElementEntity elementEntity) {

		return _elementEntityLocalService.deleteElementEntity(elementEntity);
	}

	/**
	 * Deletes the element entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity that was removed
	 * @throws PortalException if a element entity with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementEntity deleteElementEntity(
			long elementEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementEntityLocalService.deleteElementEntity(elementEntityId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementEntityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _elementEntityLocalService.dynamicQuery();
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

		return _elementEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementEntityModelImpl</code>.
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

		return _elementEntityLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementEntityModelImpl</code>.
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

		return _elementEntityLocalService.dynamicQuery(
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

		return _elementEntityLocalService.dynamicQueryCount(dynamicQuery);
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

		return _elementEntityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.iot_catalogue.model.ElementEntity fetchElementEntity(
		long elementEntityId) {

		return _elementEntityLocalService.fetchElementEntity(elementEntityId);
	}

	/**
	 * Returns the element entity matching the UUID and group.
	 *
	 * @param uuid the element entity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementEntity
		fetchElementEntityByUuidAndGroupId(String uuid, long groupId) {

		return _elementEntityLocalService.fetchElementEntityByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _elementEntityLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementCoordinatesByGroupId(long groupId) {

		return _elementEntityLocalService.getElementCoordinatesByGroupId(
			groupId);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementEntities() {

		return _elementEntityLocalService.getElementEntities();
	}

	/**
	 * Returns a range of all the element entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of element entities
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementEntities(int start, int end) {

		return _elementEntityLocalService.getElementEntities(start, end);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementEntities(
			long subscriptionId, String originalId, String elementClassName) {

		return _elementEntityLocalService.getElementEntities(
			subscriptionId, originalId, elementClassName);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementEntities(
			long subscriptionId, String originalId, String elementClassName,
			String label) {

		return _elementEntityLocalService.getElementEntities(
			subscriptionId, originalId, elementClassName, label);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementEntities(
			String originalId, String elementClassName, String label) {

		return _elementEntityLocalService.getElementEntities(
			originalId, elementClassName, label);
	}

	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementEntitiesBySubscriptionId(long subscriptionId) {

		return _elementEntityLocalService.getElementEntitiesBySubscriptionId(
			subscriptionId);
	}

	/**
	 * Returns all the element entities matching the UUID and company.
	 *
	 * @param uuid the UUID of the element entities
	 * @param companyId the primary key of the company
	 * @return the matching element entities, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementEntitiesByUuidAndCompanyId(String uuid, long companyId) {

		return _elementEntityLocalService.getElementEntitiesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of element entities matching the UUID and company.
	 *
	 * @param uuid the UUID of the element entities
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching element entities, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ElementEntity>
		getElementEntitiesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.ElementEntity> orderByComparator) {

		return _elementEntityLocalService.getElementEntitiesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of element entities.
	 *
	 * @return the number of element entities
	 */
	@Override
	public int getElementEntitiesCount() {
		return _elementEntityLocalService.getElementEntitiesCount();
	}

	/**
	 * Returns the element entity with the primary key.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity
	 * @throws PortalException if a element entity with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementEntity getElementEntity(
			long elementEntityId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementEntityLocalService.getElementEntity(elementEntityId);
	}

	/**
	 * Returns the element entity matching the UUID and group.
	 *
	 * @param uuid the element entity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element entity
	 * @throws PortalException if a matching element entity could not be found
	 */
	@Override
	public com.iot_catalogue.model.ElementEntity
			getElementEntityByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementEntityLocalService.getElementEntityByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _elementEntityLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _elementEntityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _elementEntityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _elementEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the element entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementEntity the element entity
	 * @return the element entity that was updated
	 */
	@Override
	public com.iot_catalogue.model.ElementEntity updateElementEntity(
		com.iot_catalogue.model.ElementEntity elementEntity) {

		return _elementEntityLocalService.updateElementEntity(elementEntity);
	}

	@Override
	public ElementEntityLocalService getWrappedService() {
		return _elementEntityLocalService;
	}

	@Override
	public void setWrappedService(
		ElementEntityLocalService elementEntityLocalService) {

		_elementEntityLocalService = elementEntityLocalService;
	}

	private ElementEntityLocalService _elementEntityLocalService;

}