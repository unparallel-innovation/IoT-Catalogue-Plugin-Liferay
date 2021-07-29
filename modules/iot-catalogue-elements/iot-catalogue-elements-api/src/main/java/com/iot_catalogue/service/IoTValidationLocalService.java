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

import com.iot_catalogue.exception.NoSuchIoTValidationException;
import com.iot_catalogue.model.IoTValidation;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for IoTValidation. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see IoTValidationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface IoTValidationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.iot_catalogue.service.impl.IoTValidationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the io t validation local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link IoTValidationLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public IoTValidation addIoTValidation(IoTValidation ioTValidation);

	@Indexable(type = IndexableType.REINDEX)
	public IoTValidation addIoTValidation(
			long userId, String name, String description, String embeddedUrl,
			String imageUrl, String originalId, long subscriptionId,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new io t validation with the primary key. Does not add the io t validation to the database.
	 *
	 * @param iotValidationId the primary key for the new io t validation
	 * @return the new io t validation
	 */
	@Transactional(enabled = false)
	public IoTValidation createIoTValidation(long iotValidationId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public IoTValidation deleteIoTValidation(IoTValidation ioTValidation);

	@Indexable(type = IndexableType.DELETE)
	public IoTValidation deleteIoTValidation(
			IoTValidation iotValidation, ServiceContext serviceContext)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public IoTValidation deleteIoTValidation(long iotValidationId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IoTValidation fetchIoTValidation(long iotValidationId);

	/**
	 * Returns the io t validation matching the UUID and group.
	 *
	 * @param uuid the io t validation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IoTValidation fetchIoTValidationByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the io t validation with the primary key.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation
	 * @throws PortalException if a io t validation with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IoTValidation getIoTValidation(long iotValidationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IoTValidation getIoTValidationByOriginalId(String originalId)
		throws NoSuchIoTValidationException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IoTValidation getIoTValidationByOriginalId(
			String originalId, long subscriptionId)
		throws NoSuchIoTValidationException;

	/**
	 * Returns the io t validation matching the UUID and group.
	 *
	 * @param uuid the io t validation's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t validation
	 * @throws PortalException if a matching io t validation could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IoTValidation getIoTValidationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidations();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidations(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidations(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidations(
		long groupId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidations(
		long groupId, int start, int end, OrderByComparator<IoTValidation> obc);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidationsBySubscriptionId(
		long subscriptionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidationsBySubscriptionId(
		long subscriptionId, int start, int end);

	/**
	 * Returns all the io t validations matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t validations
	 * @param companyId the primary key of the company
	 * @return the matching io t validations, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidationsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<IoTValidation> getIoTValidationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator);

	/**
	 * Returns the number of io t validations.
	 *
	 * @return the number of io t validations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getIoTValidationsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getIoTValidationsCount(long groupId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.REINDEX)
	public IoTValidation updateIoTValidation(IoTValidation ioTValidation);

	@Indexable(type = IndexableType.REINDEX)
	public IoTValidation updateIoTValidation(
			long userId, long iotValidationId, String name, String description,
			String embeddedUrl, String imageUrl, ServiceContext serviceContext)
		throws PortalException;

}