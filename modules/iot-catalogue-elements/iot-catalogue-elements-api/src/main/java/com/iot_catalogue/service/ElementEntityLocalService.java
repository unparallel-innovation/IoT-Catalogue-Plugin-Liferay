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
 * Provides the local service interface for ElementEntity. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntityLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ElementEntityLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.iot_catalogue.service.impl.ElementEntityLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the element entity local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ElementEntityLocalServiceUtil} if injection and service tracking are not available.
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
	@Indexable(type = IndexableType.REINDEX)
	public ElementEntity addElementEntity(ElementEntity elementEntity);

	public ElementEntity addElementEntity(
			long userId, String originalId, String elementClassName,
			String name, String website, String label, long subscriptionId,
			ServiceContext serviceContext)
		throws PortalException;

	/**
	 * Creates a new element entity with the primary key. Does not add the element entity to the database.
	 *
	 * @param elementEntityId the primary key for the new element entity
	 * @return the new element entity
	 */
	@Transactional(enabled = false)
	public ElementEntity createElementEntity(long elementEntityId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public List<ElementEntity> deleteElementEntities(
		long subscriptionId, String originalId, String elementClassName);

	public List<ElementEntity> deleteElementEntities(
		long subscriptionId, String originalId, String elementClassName,
		String label);

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
	@Indexable(type = IndexableType.DELETE)
	public ElementEntity deleteElementEntity(ElementEntity elementEntity);

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
	@Indexable(type = IndexableType.DELETE)
	public ElementEntity deleteElementEntity(long elementEntityId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementEntityModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementEntityModelImpl</code>.
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
	public ElementEntity fetchElementEntity(long elementEntityId);

	/**
	 * Returns the element entity matching the UUID and group.
	 *
	 * @param uuid the element entity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElementEntity fetchElementEntityByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementCoordinatesByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementEntities();

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementEntities(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementEntities(
		long subscriptionId, String originalId, String elementClassName);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementEntities(
		long subscriptionId, String originalId, String elementClassName,
		String label);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementEntities(
		String originalId, String elementClassName, String label);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementEntitiesBySubscriptionId(
		long subscriptionId);

	/**
	 * Returns all the element entities matching the UUID and company.
	 *
	 * @param uuid the UUID of the element entities
	 * @param companyId the primary key of the company
	 * @return the matching element entities, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementEntitiesByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ElementEntity> getElementEntitiesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator);

	/**
	 * Returns the number of element entities.
	 *
	 * @return the number of element entities
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getElementEntitiesCount();

	/**
	 * Returns the element entity with the primary key.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity
	 * @throws PortalException if a element entity with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElementEntity getElementEntity(long elementEntityId)
		throws PortalException;

	/**
	 * Returns the element entity matching the UUID and group.
	 *
	 * @param uuid the element entity's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element entity
	 * @throws PortalException if a matching element entity could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ElementEntity getElementEntityByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	 * Updates the element entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementEntity the element entity
	 * @return the element entity that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ElementEntity updateElementEntity(ElementEntity elementEntity);

}