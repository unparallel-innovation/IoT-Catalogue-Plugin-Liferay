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

package com.iot_catalogue.service.base;

import com.iot_catalogue.model.ElementCoordinate;
import com.iot_catalogue.service.ElementCoordinateLocalService;
import com.iot_catalogue.service.ElementCoordinateLocalServiceUtil;
import com.iot_catalogue.service.persistence.ElementCoordinatePersistence;
import com.iot_catalogue.service.persistence.IoTComponentPersistence;
import com.iot_catalogue.service.persistence.IoTValidationPersistence;
import com.iot_catalogue.service.persistence.SubscriptionPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandler;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerRegistryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Disjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Property;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the element coordinate local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.iot_catalogue.service.impl.ElementCoordinateLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.iot_catalogue.service.impl.ElementCoordinateLocalServiceImpl
 * @generated
 */
public abstract class ElementCoordinateLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, ElementCoordinateLocalService,
			   IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ElementCoordinateLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ElementCoordinateLocalServiceUtil</code>.
	 */

	/**
	 * Adds the element coordinate to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementCoordinateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementCoordinate the element coordinate
	 * @return the element coordinate that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ElementCoordinate addElementCoordinate(
		ElementCoordinate elementCoordinate) {

		elementCoordinate.setNew(true);

		return elementCoordinatePersistence.update(elementCoordinate);
	}

	/**
	 * Creates a new element coordinate with the primary key. Does not add the element coordinate to the database.
	 *
	 * @param elementCoordinateId the primary key for the new element coordinate
	 * @return the new element coordinate
	 */
	@Override
	@Transactional(enabled = false)
	public ElementCoordinate createElementCoordinate(long elementCoordinateId) {
		return elementCoordinatePersistence.create(elementCoordinateId);
	}

	/**
	 * Deletes the element coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementCoordinateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate that was removed
	 * @throws PortalException if a element coordinate with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ElementCoordinate deleteElementCoordinate(long elementCoordinateId)
		throws PortalException {

		return elementCoordinatePersistence.remove(elementCoordinateId);
	}

	/**
	 * Deletes the element coordinate from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementCoordinateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementCoordinate the element coordinate
	 * @return the element coordinate that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ElementCoordinate deleteElementCoordinate(
		ElementCoordinate elementCoordinate) {

		return elementCoordinatePersistence.remove(elementCoordinate);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ElementCoordinate.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return elementCoordinatePersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return elementCoordinatePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return elementCoordinatePersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return elementCoordinatePersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return elementCoordinatePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ElementCoordinate fetchElementCoordinate(long elementCoordinateId) {
		return elementCoordinatePersistence.fetchByPrimaryKey(
			elementCoordinateId);
	}

	/**
	 * Returns the element coordinate matching the UUID and group.
	 *
	 * @param uuid the element coordinate's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchElementCoordinateByUuidAndGroupId(
		String uuid, long groupId) {

		return elementCoordinatePersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the element coordinate with the primary key.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate
	 * @throws PortalException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate getElementCoordinate(long elementCoordinateId)
		throws PortalException {

		return elementCoordinatePersistence.findByPrimaryKey(
			elementCoordinateId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			elementCoordinateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ElementCoordinate.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("elementCoordinateId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			elementCoordinateLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ElementCoordinate.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"elementCoordinateId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			elementCoordinateLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ElementCoordinate.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("elementCoordinateId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					Criterion modifiedDateCriterion =
						portletDataContext.getDateRangeCriteria("modifiedDate");

					Criterion statusDateCriterion =
						portletDataContext.getDateRangeCriteria("statusDate");

					if ((modifiedDateCriterion != null) &&
						(statusDateCriterion != null)) {

						Disjunction disjunction =
							RestrictionsFactoryUtil.disjunction();

						disjunction.add(modifiedDateCriterion);
						disjunction.add(statusDateCriterion);

						dynamicQuery.add(disjunction);
					}

					Property workflowStatusProperty =
						PropertyFactoryUtil.forName("status");

					if (portletDataContext.isInitialPublication()) {
						dynamicQuery.add(
							workflowStatusProperty.ne(
								WorkflowConstants.STATUS_IN_TRASH));
					}
					else {
						StagedModelDataHandler<?> stagedModelDataHandler =
							StagedModelDataHandlerRegistryUtil.
								getStagedModelDataHandler(
									ElementCoordinate.class.getName());

						dynamicQuery.add(
							workflowStatusProperty.in(
								stagedModelDataHandler.
									getExportableStatuses()));
					}
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<ElementCoordinate>() {

				@Override
				public void performAction(ElementCoordinate elementCoordinate)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, elementCoordinate);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ElementCoordinate.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return elementCoordinatePersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return elementCoordinateLocalService.deleteElementCoordinate(
			(ElementCoordinate)persistedModel);
	}

	public BasePersistence<ElementCoordinate> getBasePersistence() {
		return elementCoordinatePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return elementCoordinatePersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the element coordinates matching the UUID and company.
	 *
	 * @param uuid the UUID of the element coordinates
	 * @param companyId the primary key of the company
	 * @return the matching element coordinates, or an empty list if no matches were found
	 */
	@Override
	public List<ElementCoordinate> getElementCoordinatesByUuidAndCompanyId(
		String uuid, long companyId) {

		return elementCoordinatePersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of element coordinates matching the UUID and company.
	 *
	 * @param uuid the UUID of the element coordinates
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching element coordinates, or an empty list if no matches were found
	 */
	@Override
	public List<ElementCoordinate> getElementCoordinatesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return elementCoordinatePersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the element coordinate matching the UUID and group.
	 *
	 * @param uuid the element coordinate's UUID
	 * @param groupId the primary key of the group
	 * @return the matching element coordinate
	 * @throws PortalException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate getElementCoordinateByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return elementCoordinatePersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the element coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of element coordinates
	 */
	@Override
	public List<ElementCoordinate> getElementCoordinates(int start, int end) {
		return elementCoordinatePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of element coordinates.
	 *
	 * @return the number of element coordinates
	 */
	@Override
	public int getElementCoordinatesCount() {
		return elementCoordinatePersistence.countAll();
	}

	/**
	 * Updates the element coordinate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElementCoordinateLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param elementCoordinate the element coordinate
	 * @return the element coordinate that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ElementCoordinate updateElementCoordinate(
		ElementCoordinate elementCoordinate) {

		return elementCoordinatePersistence.update(elementCoordinate);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ElementCoordinateLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		elementCoordinateLocalService = (ElementCoordinateLocalService)aopProxy;

		_setLocalServiceUtilService(elementCoordinateLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ElementCoordinateLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ElementCoordinate.class;
	}

	protected String getModelClassName() {
		return ElementCoordinate.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				elementCoordinatePersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	private void _setLocalServiceUtilService(
		ElementCoordinateLocalService elementCoordinateLocalService) {

		try {
			Field field =
				ElementCoordinateLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, elementCoordinateLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected ElementCoordinateLocalService elementCoordinateLocalService;

	@Reference
	protected ElementCoordinatePersistence elementCoordinatePersistence;

	@Reference
	protected IoTComponentPersistence ioTComponentPersistence;

	@Reference
	protected IoTValidationPersistence ioTValidationPersistence;

	@Reference
	protected SubscriptionPersistence subscriptionPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}