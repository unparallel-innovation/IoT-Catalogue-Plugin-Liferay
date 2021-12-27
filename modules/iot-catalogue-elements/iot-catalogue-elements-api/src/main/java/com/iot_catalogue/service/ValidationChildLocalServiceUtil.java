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

import com.iot_catalogue.model.ValidationChild;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ValidationChild. This utility wraps
 * <code>com.iot_catalogue.service.impl.ValidationChildLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ValidationChildLocalService
 * @generated
 */
public class ValidationChildLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.iot_catalogue.service.impl.ValidationChildLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ValidationChild addValidationChild(
			long userId, String validationOriginalId,
			String childValidationOriginalId, long subscriptionId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addValidationChild(
			userId, validationOriginalId, childValidationOriginalId,
			subscriptionId, serviceContext);
	}

	/**
	 * Adds the validation child to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ValidationChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param validationChild the validation child
	 * @return the validation child that was added
	 */
	public static ValidationChild addValidationChild(
		ValidationChild validationChild) {

		return getService().addValidationChild(validationChild);
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
	 * Creates a new validation child with the primary key. Does not add the validation child to the database.
	 *
	 * @param id the primary key for the new validation child
	 * @return the new validation child
	 */
	public static ValidationChild createValidationChild(long id) {
		return getService().createValidationChild(id);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the validation child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ValidationChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child that was removed
	 * @throws PortalException if a validation child with the primary key could not be found
	 */
	public static ValidationChild deleteValidationChild(long id)
		throws PortalException {

		return getService().deleteValidationChild(id);
	}

	/**
	 * Deletes the validation child from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ValidationChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param validationChild the validation child
	 * @return the validation child that was removed
	 */
	public static ValidationChild deleteValidationChild(
		ValidationChild validationChild) {

		return getService().deleteValidationChild(validationChild);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ValidationChildModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ValidationChildModelImpl</code>.
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

	public static ValidationChild fetchValidationChild(long id) {
		return getService().fetchValidationChild(id);
	}

	/**
	 * Returns the validation child matching the UUID and group.
	 *
	 * @param uuid the validation child's UUID
	 * @param groupId the primary key of the group
	 * @return the matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	public static ValidationChild fetchValidationChildByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchValidationChildByUuidAndGroupId(uuid, groupId);
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
	 * Returns the validation child with the primary key.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child
	 * @throws PortalException if a validation child with the primary key could not be found
	 */
	public static ValidationChild getValidationChild(long id)
		throws PortalException {

		return getService().getValidationChild(id);
	}

	/**
	 * Returns the validation child matching the UUID and group.
	 *
	 * @param uuid the validation child's UUID
	 * @param groupId the primary key of the group
	 * @return the matching validation child
	 * @throws PortalException if a matching validation child could not be found
	 */
	public static ValidationChild getValidationChildByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getValidationChildByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the validation childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of validation childs
	 */
	public static List<ValidationChild> getValidationChilds(
		int start, int end) {

		return getService().getValidationChilds(start, end);
	}

	public static List<ValidationChild> getValidationChilds(
		String validationOriginalId) {

		return getService().getValidationChilds(validationOriginalId);
	}

	public static List<ValidationChild> getValidationChildsBySubscriptionId(
		long subscriptionId) {

		return getService().getValidationChildsBySubscriptionId(subscriptionId);
	}

	/**
	 * Returns all the validation childs matching the UUID and company.
	 *
	 * @param uuid the UUID of the validation childs
	 * @param companyId the primary key of the company
	 * @return the matching validation childs, or an empty list if no matches were found
	 */
	public static List<ValidationChild> getValidationChildsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getValidationChildsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of validation childs matching the UUID and company.
	 *
	 * @param uuid the UUID of the validation childs
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching validation childs, or an empty list if no matches were found
	 */
	public static List<ValidationChild> getValidationChildsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return getService().getValidationChildsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of validation childs.
	 *
	 * @return the number of validation childs
	 */
	public static int getValidationChildsCount() {
		return getService().getValidationChildsCount();
	}

	/**
	 * Updates the validation child in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ValidationChildLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param validationChild the validation child
	 * @return the validation child that was updated
	 */
	public static ValidationChild updateValidationChild(
		ValidationChild validationChild) {

		return getService().updateValidationChild(validationChild);
	}

	public static ValidationChildLocalService getService() {
		return _service;
	}

	private static volatile ValidationChildLocalService _service;

}