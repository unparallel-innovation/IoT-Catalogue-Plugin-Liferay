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
import com.iot_catalogue.service.ElementCoordinateService;
import com.iot_catalogue.service.ElementCoordinateServiceUtil;
import com.iot_catalogue.service.persistence.ElementCoordinatePersistence;
import com.iot_catalogue.service.persistence.IoTComponentPersistence;
import com.iot_catalogue.service.persistence.IoTValidationPersistence;
import com.iot_catalogue.service.persistence.SubscriptionPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.util.PortalUtil;

import java.lang.reflect.Field;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the element coordinate remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.iot_catalogue.service.impl.ElementCoordinateServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.iot_catalogue.service.impl.ElementCoordinateServiceImpl
 * @generated
 */
public abstract class ElementCoordinateServiceBaseImpl
	extends BaseServiceImpl
	implements AopService, ElementCoordinateService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ElementCoordinateService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ElementCoordinateServiceUtil</code>.
	 */
	@Deactivate
	protected void deactivate() {
		_setServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ElementCoordinateService.class, IdentifiableOSGiService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		elementCoordinateService = (ElementCoordinateService)aopProxy;

		_setServiceUtilService(elementCoordinateService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ElementCoordinateService.class.getName();
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

	private void _setServiceUtilService(
		ElementCoordinateService elementCoordinateService) {

		try {
			Field field = ElementCoordinateServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, elementCoordinateService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected com.iot_catalogue.service.ElementCoordinateLocalService
		elementCoordinateLocalService;

	protected ElementCoordinateService elementCoordinateService;

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
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserService userService;

}