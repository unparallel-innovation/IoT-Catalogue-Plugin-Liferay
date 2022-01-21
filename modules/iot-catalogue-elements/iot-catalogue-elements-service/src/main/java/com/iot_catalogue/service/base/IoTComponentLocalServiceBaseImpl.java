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

import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.iot_catalogue.service.IoTComponentLocalServiceUtil;
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
 * Provides the base implementation for the io t component local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.iot_catalogue.service.impl.IoTComponentLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.iot_catalogue.service.impl.IoTComponentLocalServiceImpl
 * @generated
 */
public abstract class IoTComponentLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService, IoTComponentLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>IoTComponentLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>IoTComponentLocalServiceUtil</code>.
	 */

	/**
	 * Adds the io t component to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTComponent the io t component
	 * @return the io t component that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public IoTComponent addIoTComponent(IoTComponent ioTComponent) {
		ioTComponent.setNew(true);

		return ioTComponentPersistence.update(ioTComponent);
	}

	/**
	 * Creates a new io t component with the primary key. Does not add the io t component to the database.
	 *
	 * @param iotComponentId the primary key for the new io t component
	 * @return the new io t component
	 */
	@Override
	@Transactional(enabled = false)
	public IoTComponent createIoTComponent(long iotComponentId) {
		return ioTComponentPersistence.create(iotComponentId);
	}

	/**
	 * Deletes the io t component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component that was removed
	 * @throws PortalException if a io t component with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public IoTComponent deleteIoTComponent(long iotComponentId)
		throws PortalException {

		return ioTComponentPersistence.remove(iotComponentId);
	}

	/**
	 * Deletes the io t component from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTComponent the io t component
	 * @return the io t component that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public IoTComponent deleteIoTComponent(IoTComponent ioTComponent) {
		return ioTComponentPersistence.remove(ioTComponent);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			IoTComponent.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return ioTComponentPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTComponentModelImpl</code>.
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

		return ioTComponentPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTComponentModelImpl</code>.
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

		return ioTComponentPersistence.findWithDynamicQuery(
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
		return ioTComponentPersistence.countWithDynamicQuery(dynamicQuery);
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

		return ioTComponentPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public IoTComponent fetchIoTComponent(long iotComponentId) {
		return ioTComponentPersistence.fetchByPrimaryKey(iotComponentId);
	}

	/**
	 * Returns the io t component matching the UUID and group.
	 *
	 * @param uuid the io t component's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchIoTComponentByUuidAndGroupId(
		String uuid, long groupId) {

		return ioTComponentPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the io t component with the primary key.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component
	 * @throws PortalException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent getIoTComponent(long iotComponentId)
		throws PortalException {

		return ioTComponentPersistence.findByPrimaryKey(iotComponentId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(ioTComponentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(IoTComponent.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("iotComponentId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			ioTComponentLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(IoTComponent.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"iotComponentId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(ioTComponentLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(IoTComponent.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("iotComponentId");
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
									IoTComponent.class.getName());

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
			new ActionableDynamicQuery.PerformActionMethod<IoTComponent>() {

				@Override
				public void performAction(IoTComponent ioTComponent)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, ioTComponent);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(IoTComponent.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ioTComponentPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return ioTComponentLocalService.deleteIoTComponent(
			(IoTComponent)persistedModel);
	}

	public BasePersistence<IoTComponent> getBasePersistence() {
		return ioTComponentPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return ioTComponentPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the io t components matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t components
	 * @param companyId the primary key of the company
	 * @return the matching io t components, or an empty list if no matches were found
	 */
	@Override
	public List<IoTComponent> getIoTComponentsByUuidAndCompanyId(
		String uuid, long companyId) {

		return ioTComponentPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of io t components matching the UUID and company.
	 *
	 * @param uuid the UUID of the io t components
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching io t components, or an empty list if no matches were found
	 */
	@Override
	public List<IoTComponent> getIoTComponentsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		return ioTComponentPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the io t component matching the UUID and group.
	 *
	 * @param uuid the io t component's UUID
	 * @param groupId the primary key of the group
	 * @return the matching io t component
	 * @throws PortalException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent getIoTComponentByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return ioTComponentPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the io t components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.iot_catalogue.model.impl.IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of io t components
	 */
	@Override
	public List<IoTComponent> getIoTComponents(int start, int end) {
		return ioTComponentPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of io t components.
	 *
	 * @return the number of io t components
	 */
	@Override
	public int getIoTComponentsCount() {
		return ioTComponentPersistence.countAll();
	}

	/**
	 * Updates the io t component in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect IoTComponentLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ioTComponent the io t component
	 * @return the io t component that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public IoTComponent updateIoTComponent(IoTComponent ioTComponent) {
		return ioTComponentPersistence.update(ioTComponent);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			IoTComponentLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		ioTComponentLocalService = (IoTComponentLocalService)aopProxy;

		_setLocalServiceUtilService(ioTComponentLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return IoTComponentLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return IoTComponent.class;
	}

	protected String getModelClassName() {
		return IoTComponent.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = ioTComponentPersistence.getDataSource();

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
		IoTComponentLocalService ioTComponentLocalService) {

		try {
			Field field = IoTComponentLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, ioTComponentLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected ElementCoordinatePersistence elementCoordinatePersistence;

	protected IoTComponentLocalService ioTComponentLocalService;

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

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

}