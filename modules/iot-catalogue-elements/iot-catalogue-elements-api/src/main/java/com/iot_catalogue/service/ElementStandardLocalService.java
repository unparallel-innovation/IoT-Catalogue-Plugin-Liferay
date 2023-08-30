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

import com.iot_catalogue.model.ElementStandard;

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
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ElementStandard. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ElementStandardLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ElementStandardLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.iot_catalogue.service.impl.ElementStandardLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the element standard local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ElementStandardLocalServiceUtil} if injection and service tracking are not available.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	public ElementStandard addElementStandard(ElementStandard elementStandard);

	/**
	 * Creates a new element standard with the primary key. Does not add the element standard to the database.
	 *
	 * @param elementStandardId the primary key for the new element standard
	 * @return the new element standard
	 */
	@Transactional(enabled = false)
	public ElementStandard createElementStandard(long elementStandardId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

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
	@Indexable(type = IndexableType.DELETE)
	public ElementStandard deleteElementStandard(
		ElementStandard elementStandard);

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
	@Indexable(type = IndexableType.DELETE)
	public ElementStandard deleteElementStandard(long elementStandardId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementStandardModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementStandardModelImpl</code>.
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
	public ElementStandard fetchElementStandard(long elementStandardId);

	/**
	 * Returns the element standard matching the UUID and group.
	 *
	 * @param uuid the element standard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElementStandard fetchElementStandardByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the element standard with the primary key.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard
	 * @throws PortalException if a element standard with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElementStandard getElementStandard(long elementStandardId)
		throws PortalException;

	/**
	 * Returns the element standard matching the UUID and group.
	 *
	 * @param uuid the element standard's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element standard
	 * @throws PortalException if a matching element standard could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElementStandard getElementStandardByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementStandard> getElementStandards(int start, int end);

	/**
	 * Returns all the element standards matching the UUID and company.
	 *
	 * @param uuid the UUID of the element standards
	 * @param companyId the primary key of the company
	 * @return the matching element standards, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementStandard> getElementStandardsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementStandard> getElementStandardsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator);

	/**
	 * Returns the number of element standards.
	 *
	 * @return the number of element standards
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getElementStandardsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	 * Updates the element standard in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementStandardLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementStandard the element standard
	 * @return the element standard that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ElementStandard updateElementStandard(
		ElementStandard elementStandard);

}