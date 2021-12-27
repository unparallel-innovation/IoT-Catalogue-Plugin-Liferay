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

import com.iot_catalogue.model.ComponentChild;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ComponentChild. This utility wraps
 * <code>com.iot_catalogue.service.impl.ComponentChildLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ComponentChildLocalService
 * @generated
 */
public class ComponentChildLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.iot_catalogue.service.impl.ComponentChildLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static ComponentChild addComponentChild(
		ComponentChild componentChild) {

		return getService().addComponentChild(componentChild);
	}

	public static ComponentChild addComponentChild(
			long userId, String componentOriginalId,
			String childComponentOriginalId, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addComponentChild(
			userId, componentOriginalId, childComponentOriginalId,
			subscriptionId, serviceContext);
	}

	/**
	 * Creates a new component child with the primary key. Does not add the component child to the database.
	 *
	 * @param id the primary key for the new component child
	 * @return the new component child
	 */
	public static ComponentChild createComponentChild(long id) {
		return getService().createComponentChild(id);
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
	 * Deletes the component child from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentChild the component child
	 * @return the component child that was removed
	 */
	public static ComponentChild deleteComponentChild(
		ComponentChild componentChild) {

		return getService().deleteComponentChild(componentChild);
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
	public static ComponentChild deleteComponentChild(long id)
		throws PortalException {

		return getService().deleteComponentChild(id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ComponentChildModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ComponentChildModelImpl</code>.
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

	public static ComponentChild fetchComponentChild(long id) {
		return getService().fetchComponentChild(id);
	}

	/**
	 * Returns the component child matching the UUID and group.
	 *
	 * @param uuid the component child's UUID
	 * @param groupId the primary key of the group
	 * @return the matching component child, or <code>null</code> if a matching component child could not be found
	 */
	public static ComponentChild fetchComponentChildByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchComponentChildByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the component child with the primary key.
	 *
	 * @param id the primary key of the component child
	 * @return the component child
	 * @throws PortalException if a component child with the primary key could not be found
	 */
	public static ComponentChild getComponentChild(long id)
		throws PortalException {

		return getService().getComponentChild(id);
	}

	/**
	 * Returns the component child matching the UUID and group.
	 *
	 * @param uuid the component child's UUID
	 * @param groupId the primary key of the group
	 * @return the matching component child
	 * @throws PortalException if a matching component child could not be found
	 */
	public static ComponentChild getComponentChildByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getComponentChildByUuidAndGroupId(uuid, groupId);
	}

	public static List<ComponentChild> getComponentChilds() {
		return getService().getComponentChilds();
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
	public static List<ComponentChild> getComponentChilds(int start, int end) {
		return getService().getComponentChilds(start, end);
	}

	/**
	 * Returns all the component childs matching the UUID and company.
	 *
	 * @param uuid the UUID of the component childs
	 * @param companyId the primary key of the company
	 * @return the matching component childs, or an empty list if no matches were found
	 */
	public static List<ComponentChild> getComponentChildsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getComponentChildsByUuidAndCompanyId(
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
	public static List<ComponentChild> getComponentChildsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return getService().getComponentChildsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of component childs.
	 *
	 * @return the number of component childs
	 */
	public static int getComponentChildsCount() {
		return getService().getComponentChildsCount();
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
	 * Updates the component child in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ComponentChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param componentChild the component child
	 * @return the component child that was updated
	 */
	public static ComponentChild updateComponentChild(
		ComponentChild componentChild) {

		return getService().updateComponentChild(componentChild);
	}

	public static ComponentChildLocalService getService() {
		return _service;
	}

	private static volatile ComponentChildLocalService _service;

}