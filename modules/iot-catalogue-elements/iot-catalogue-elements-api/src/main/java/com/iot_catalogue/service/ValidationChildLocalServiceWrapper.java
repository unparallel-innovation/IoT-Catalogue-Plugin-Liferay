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
 * Provides a wrapper for {@link ValidationChildLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ValidationChildLocalService
 * @generated
 */
public class ValidationChildLocalServiceWrapper
	implements ServiceWrapper<ValidationChildLocalService>,
			   ValidationChildLocalService {

	public ValidationChildLocalServiceWrapper(
		ValidationChildLocalService validationChildLocalService) {

		_validationChildLocalService = validationChildLocalService;
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
	@Override
	public com.iot_catalogue.model.ValidationChild addValidationChild(
		com.iot_catalogue.model.ValidationChild validationChild) {

		return _validationChildLocalService.addValidationChild(validationChild);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _validationChildLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new validation child with the primary key. Does not add the validation child to the database.
	 *
	 * @param id the primary key for the new validation child
	 * @return the new validation child
	 */
	@Override
	public com.iot_catalogue.model.ValidationChild createValidationChild(
		long id) {

		return _validationChildLocalService.createValidationChild(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _validationChildLocalService.deletePersistedModel(
			persistedModel);
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
	@Override
	public com.iot_catalogue.model.ValidationChild deleteValidationChild(
			long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _validationChildLocalService.deleteValidationChild(id);
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
	@Override
	public com.iot_catalogue.model.ValidationChild deleteValidationChild(
		com.iot_catalogue.model.ValidationChild validationChild) {

		return _validationChildLocalService.deleteValidationChild(
			validationChild);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _validationChildLocalService.dynamicQuery();
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

		return _validationChildLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _validationChildLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _validationChildLocalService.dynamicQuery(
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

		return _validationChildLocalService.dynamicQueryCount(dynamicQuery);
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

		return _validationChildLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.iot_catalogue.model.ValidationChild fetchValidationChild(
		long id) {

		return _validationChildLocalService.fetchValidationChild(id);
	}

	/**
	 * Returns the validation child matching the UUID and group.
	 *
	 * @param uuid the validation child's UUID
	 * @param groupId the primary key of the group
	 * @return the matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public com.iot_catalogue.model.ValidationChild
		fetchValidationChildByUuidAndGroupId(String uuid, long groupId) {

		return _validationChildLocalService.
			fetchValidationChildByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _validationChildLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _validationChildLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _validationChildLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _validationChildLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _validationChildLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the validation child with the primary key.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child
	 * @throws PortalException if a validation child with the primary key could not be found
	 */
	@Override
	public com.iot_catalogue.model.ValidationChild getValidationChild(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _validationChildLocalService.getValidationChild(id);
	}

	/**
	 * Returns the validation child matching the UUID and group.
	 *
	 * @param uuid the validation child's UUID
	 * @param groupId the primary key of the group
	 * @return the matching validation child
	 * @throws PortalException if a matching validation child could not be found
	 */
	@Override
	public com.iot_catalogue.model.ValidationChild
			getValidationChildByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _validationChildLocalService.getValidationChildByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.iot_catalogue.model.ValidationChild>
		getValidationChilds(int start, int end) {

		return _validationChildLocalService.getValidationChilds(start, end);
	}

	/**
	 * Returns all the validation childs matching the UUID and company.
	 *
	 * @param uuid the UUID of the validation childs
	 * @param companyId the primary key of the company
	 * @return the matching validation childs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.iot_catalogue.model.ValidationChild>
		getValidationChildsByUuidAndCompanyId(String uuid, long companyId) {

		return _validationChildLocalService.
			getValidationChildsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.iot_catalogue.model.ValidationChild>
		getValidationChildsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.iot_catalogue.model.ValidationChild> orderByComparator) {

		return _validationChildLocalService.
			getValidationChildsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of validation childs.
	 *
	 * @return the number of validation childs
	 */
	@Override
	public int getValidationChildsCount() {
		return _validationChildLocalService.getValidationChildsCount();
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
	@Override
	public com.iot_catalogue.model.ValidationChild updateValidationChild(
		com.iot_catalogue.model.ValidationChild validationChild) {

		return _validationChildLocalService.updateValidationChild(
			validationChild);
	}

	@Override
	public ValidationChildLocalService getWrappedService() {
		return _validationChildLocalService;
	}

	@Override
	public void setWrappedService(
		ValidationChildLocalService validationChildLocalService) {

		_validationChildLocalService = validationChildLocalService;
	}

	private ValidationChildLocalService _validationChildLocalService;

}