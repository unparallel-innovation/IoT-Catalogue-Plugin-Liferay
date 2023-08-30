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

import com.iot_catalogue.model.ElementEntity;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ElementEntity. This utility wraps
 * <code>com.iot_catalogue.service.impl.ElementEntityLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntityLocalService
 * @generated
 */
public class ElementEntityLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.iot_catalogue.service.impl.ElementEntityLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ElementEntity addElementEntity(ElementEntity elementEntity) {
		return getService().addElementEntity(elementEntity);
	}

	public static ElementEntity addElementEntity(
			long userId, String originalId, String elementClassName,
			String name, String website, String label, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addElementEntity(
			userId, originalId, elementClassName, name, website, label,
			subscriptionId, serviceContext);
	}

	/**
	 * Creates a new element entity with the primary key. Does not add the element entity to the database.
	 *
	 * @param elementEntityId the primary key for the new element entity
	 * @return the new element entity
	 */
	public static ElementEntity createElementEntity(long elementEntityId) {
		return getService().createElementEntity(elementEntityId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	public static List<ElementEntity> deleteElementEntities(
		long subscriptionId, String originalId, String elementClassName) {

		return getService().deleteElementEntities(
			subscriptionId, originalId, elementClassName);
	}

	public static List<ElementEntity> deleteElementEntities(
		long subscriptionId, String originalId, String elementClassName,
		String label) {

		return getService().deleteElementEntities(
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
	public static ElementEntity deleteElementEntity(
		ElementEntity elementEntity) {

		return getService().deleteElementEntity(elementEntity);
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
	public static ElementEntity deleteElementEntity(long elementEntityId)
		throws PortalException {

		return getService().deleteElementEntity(elementEntityId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementEntityModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementEntityModelImpl</code>.
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

	public static ElementEntity fetchElementEntity(long elementEntityId) {
		return getService().fetchElementEntity(elementEntityId);
	}

	/**
	 * Returns the element entity matching the UUID and group.
	 *
	 * @param uuid the element entity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	public static ElementEntity fetchElementEntityByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchElementEntityByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static List<ElementEntity> getElementCoordinatesByGroupId(
		long groupId) {

		return getService().getElementCoordinatesByGroupId(groupId);
	}

	public static List<ElementEntity> getElementEntities() {
		return getService().getElementEntities();
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
	public static List<ElementEntity> getElementEntities(int start, int end) {
		return getService().getElementEntities(start, end);
	}

	public static List<ElementEntity> getElementEntities(
		long subscriptionId, String originalId, String elementClassName) {

		return getService().getElementEntities(
			subscriptionId, originalId, elementClassName);
	}

	public static List<ElementEntity> getElementEntities(
		long subscriptionId, String originalId, String elementClassName,
		String label) {

		return getService().getElementEntities(
			subscriptionId, originalId, elementClassName, label);
	}

	public static List<ElementEntity> getElementEntities(
		String originalId, String elementClassName, String label) {

		return getService().getElementEntities(
			originalId, elementClassName, label);
	}

	public static List<ElementEntity> getElementEntitiesBySubscriptionId(
		long subscriptionId) {

		return getService().getElementEntitiesBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns all the element entities matching the UUID and company.
	 *
	 * @param uuid the UUID of the element entities
	 * @param companyId the primary key of the company
	 * @return the matching element entities, or an empty list if no matches were found
	 */
	public static List<ElementEntity> getElementEntitiesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getElementEntitiesByUuidAndCompanyId(
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
	public static List<ElementEntity> getElementEntitiesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return getService().getElementEntitiesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of element entities.
	 *
	 * @return the number of element entities
	 */
	public static int getElementEntitiesCount() {
		return getService().getElementEntitiesCount();
	}

	/**
	 * Returns the element entity with the primary key.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity
	 * @throws PortalException if a element entity with the primary key could not be found
	 */
	public static ElementEntity getElementEntity(long elementEntityId)
		throws PortalException {

		return getService().getElementEntity(elementEntityId);
	}

	/**
	 * Returns the element entity matching the UUID and group.
	 *
	 * @param uuid the element entity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element entity
	 * @throws PortalException if a matching element entity could not be found
	 */
	public static ElementEntity getElementEntityByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getElementEntityByUuidAndGroupId(uuid, groupId);
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
	 * Updates the element entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementEntity the element entity
	 * @return the element entity that was updated
	 */
	public static ElementEntity updateElementEntity(
		ElementEntity elementEntity) {

		return getService().updateElementEntity(elementEntity);
	}

	public static ElementEntityLocalService getService() {
		return _service;
	}

	private static volatile ElementEntityLocalService _service;

}