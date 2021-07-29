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

package com.iot_catalogue.service.persistence.impl;

import com.iot_catalogue.exception.NoSuchIoTComponentException;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.model.impl.IoTComponentImpl;
import com.iot_catalogue.model.impl.IoTComponentModelImpl;
import com.iot_catalogue.service.persistence.IoTComponentPersistence;
import com.iot_catalogue.service.persistence.impl.constants.IoTCataloguePersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.InlineSQLHelperUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the io t component service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = IoTComponentPersistence.class)
public class IoTComponentPersistenceImpl
	extends BasePersistenceImpl<IoTComponent>
	implements IoTComponentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IoTComponentUtil</code> to access the io t component persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IoTComponentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the io t components where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching io t components
	 */
	@Override
	public List<IoTComponent> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t components where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<IoTComponent> list = null;

		if (useFinderCache) {
			list = (List<IoTComponent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTComponent ioTComponent : list) {
					if (!uuid.equals(ioTComponent.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<IoTComponent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first io t component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByUuid_First(
			String uuid, OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByUuid_First(uuid, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the first io t component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByUuid_First(
		String uuid, OrderByComparator<IoTComponent> orderByComparator) {

		List<IoTComponent> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByUuid_Last(
			String uuid, OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByUuid_Last(uuid, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the last io t component in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByUuid_Last(
		String uuid, OrderByComparator<IoTComponent> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<IoTComponent> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where uuid = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent[] findByUuid_PrevAndNext(
			long iotComponentId, String uuid,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		uuid = Objects.toString(uuid, "");

		IoTComponent ioTComponent = findByPrimaryKey(iotComponentId);

		Session session = null;

		try {
			session = openSession();

			IoTComponent[] array = new IoTComponentImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ioTComponent, uuid, orderByComparator, true);

			array[1] = ioTComponent;

			array[2] = getByUuid_PrevAndNext(
				session, ioTComponent, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTComponent getByUuid_PrevAndNext(
		Session session, IoTComponent ioTComponent, String uuid,
		OrderByComparator<IoTComponent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ioTComponent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTComponent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t components where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (IoTComponent ioTComponent :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ioTComponent);
		}
	}

	/**
	 * Returns the number of io t components where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching io t components
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"ioTComponent.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ioTComponent.uuid IS NULL OR ioTComponent.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the io t component where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIoTComponentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByUUID_G(String uuid, long groupId)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByUUID_G(uuid, groupId);

		if (ioTComponent == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchIoTComponentException(sb.toString());
		}

		return ioTComponent;
	}

	/**
	 * Returns the io t component where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the io t component where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof IoTComponent) {
			IoTComponent ioTComponent = (IoTComponent)result;

			if (!Objects.equals(uuid, ioTComponent.getUuid()) ||
				(groupId != ioTComponent.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<IoTComponent> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					IoTComponent ioTComponent = list.get(0);

					result = ioTComponent;

					cacheResult(ioTComponent);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (IoTComponent)result;
		}
	}

	/**
	 * Removes the io t component where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the io t component that was removed
	 */
	@Override
	public IoTComponent removeByUUID_G(String uuid, long groupId)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = findByUUID_G(uuid, groupId);

		return remove(ioTComponent);
	}

	/**
	 * Returns the number of io t components where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching io t components
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"ioTComponent.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ioTComponent.uuid IS NULL OR ioTComponent.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ioTComponent.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching io t components
	 */
	@Override
	public List<IoTComponent> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<IoTComponent> list = null;

		if (useFinderCache) {
			list = (List<IoTComponent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTComponent ioTComponent : list) {
					if (!uuid.equals(ioTComponent.getUuid()) ||
						(companyId != ioTComponent.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<IoTComponent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the first io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<IoTComponent> orderByComparator) {

		List<IoTComponent> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the last io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<IoTComponent> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<IoTComponent> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent[] findByUuid_C_PrevAndNext(
			long iotComponentId, String uuid, long companyId,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		uuid = Objects.toString(uuid, "");

		IoTComponent ioTComponent = findByPrimaryKey(iotComponentId);

		Session session = null;

		try {
			session = openSession();

			IoTComponent[] array = new IoTComponentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ioTComponent, uuid, companyId, orderByComparator,
				true);

			array[1] = ioTComponent;

			array[2] = getByUuid_C_PrevAndNext(
				session, ioTComponent, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTComponent getByUuid_C_PrevAndNext(
		Session session, IoTComponent ioTComponent, String uuid, long companyId,
		OrderByComparator<IoTComponent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ioTComponent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTComponent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t components where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (IoTComponent ioTComponent :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ioTComponent);
		}
	}

	/**
	 * Returns the number of io t components where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching io t components
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"ioTComponent.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ioTComponent.uuid IS NULL OR ioTComponent.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ioTComponent.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the io t components where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t components
	 */
	@Override
	public List<IoTComponent> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t components where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<IoTComponent> list = null;

		if (useFinderCache) {
			list = (List<IoTComponent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTComponent ioTComponent : list) {
					if (groupId != ioTComponent.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<IoTComponent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first io t component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByGroupId_First(
			long groupId, OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByGroupId_First(
			groupId, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the first io t component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByGroupId_First(
		long groupId, OrderByComparator<IoTComponent> orderByComparator) {

		List<IoTComponent> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByGroupId_Last(
			long groupId, OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the last io t component in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByGroupId_Last(
		long groupId, OrderByComparator<IoTComponent> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<IoTComponent> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where groupId = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent[] findByGroupId_PrevAndNext(
			long iotComponentId, long groupId,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = findByPrimaryKey(iotComponentId);

		Session session = null;

		try {
			session = openSession();

			IoTComponent[] array = new IoTComponentImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, ioTComponent, groupId, orderByComparator, true);

			array[1] = ioTComponent;

			array[2] = getByGroupId_PrevAndNext(
				session, ioTComponent, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTComponent getByGroupId_PrevAndNext(
		Session session, IoTComponent ioTComponent, long groupId,
		OrderByComparator<IoTComponent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ioTComponent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTComponent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the io t components that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t components that the user has permission to view
	 */
	@Override
	public List<IoTComponent> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components that the user has permission to view
	 */
	@Override
	public List<IoTComponent> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components that the user has permission to view
	 */
	@Override
	public List<IoTComponent> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId(groupId, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				3 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_IOTCOMPONENT_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTComponent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, IoTComponentImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, IoTComponentImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<IoTComponent>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the io t components before and after the current io t component in the ordered set of io t components that the user has permission to view where groupId = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent[] filterFindByGroupId_PrevAndNext(
			long iotComponentId, long groupId,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				iotComponentId, groupId, orderByComparator);
		}

		IoTComponent ioTComponent = findByPrimaryKey(iotComponentId);

		Session session = null;

		try {
			session = openSession();

			IoTComponent[] array = new IoTComponentImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, ioTComponent, groupId, orderByComparator, true);

			array[1] = ioTComponent;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, ioTComponent, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTComponent filterGetByGroupId_PrevAndNext(
		Session session, IoTComponent ioTComponent, long groupId,
		OrderByComparator<IoTComponent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_IOTCOMPONENT_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTComponent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, IoTComponentImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, IoTComponentImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ioTComponent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTComponent> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t components where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (IoTComponent ioTComponent :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ioTComponent);
		}
	}

	/**
	 * Returns the number of io t components where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t components
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of io t components that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t components that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_IOTCOMPONENT_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTComponent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"ioTComponent.groupId = ?";

	private FinderPath _finderPathFetchByOriginalId;
	private FinderPath _finderPathCountByOriginalId;

	/**
	 * Returns the io t component where originalId = &#63; or throws a <code>NoSuchIoTComponentException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @return the matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByOriginalId(String originalId)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByOriginalId(originalId);

		if (ioTComponent == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("originalId=");
			sb.append(originalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchIoTComponentException(sb.toString());
		}

		return ioTComponent;
	}

	/**
	 * Returns the io t component where originalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByOriginalId(String originalId) {
		return fetchByOriginalId(originalId, true);
	}

	/**
	 * Returns the io t component where originalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByOriginalId(
		String originalId, boolean useFinderCache) {

		originalId = Objects.toString(originalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {originalId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByOriginalId, finderArgs, this);
		}

		if (result instanceof IoTComponent) {
			IoTComponent ioTComponent = (IoTComponent)result;

			if (!Objects.equals(originalId, ioTComponent.getOriginalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			boolean bindOriginalId = false;

			if (originalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORIGINALID_ORIGINALID_3);
			}
			else {
				bindOriginalId = true;

				sb.append(_FINDER_COLUMN_ORIGINALID_ORIGINALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOriginalId) {
					queryPos.add(originalId);
				}

				List<IoTComponent> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByOriginalId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {originalId};
							}

							_log.warn(
								"IoTComponentPersistenceImpl.fetchByOriginalId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					IoTComponent ioTComponent = list.get(0);

					result = ioTComponent;

					cacheResult(ioTComponent);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (IoTComponent)result;
		}
	}

	/**
	 * Removes the io t component where originalId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @return the io t component that was removed
	 */
	@Override
	public IoTComponent removeByOriginalId(String originalId)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = findByOriginalId(originalId);

		return remove(ioTComponent);
	}

	/**
	 * Returns the number of io t components where originalId = &#63;.
	 *
	 * @param originalId the original ID
	 * @return the number of matching io t components
	 */
	@Override
	public int countByOriginalId(String originalId) {
		originalId = Objects.toString(originalId, "");

		FinderPath finderPath = _finderPathCountByOriginalId;

		Object[] finderArgs = new Object[] {originalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			boolean bindOriginalId = false;

			if (originalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORIGINALID_ORIGINALID_3);
			}
			else {
				bindOriginalId = true;

				sb.append(_FINDER_COLUMN_ORIGINALID_ORIGINALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOriginalId) {
					queryPos.add(originalId);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORIGINALID_ORIGINALID_2 =
		"ioTComponent.originalId = ?";

	private static final String _FINDER_COLUMN_ORIGINALID_ORIGINALID_3 =
		"(ioTComponent.originalId IS NULL OR ioTComponent.originalId = '')";

	private FinderPath _finderPathFetchByOID_S;
	private FinderPath _finderPathCountByOID_S;

	/**
	 * Returns the io t component where originalId = &#63; and subscriptionId = &#63; or throws a <code>NoSuchIoTComponentException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByOID_S(String originalId, long subscriptionId)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByOID_S(originalId, subscriptionId);

		if (ioTComponent == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("originalId=");
			sb.append(originalId);

			sb.append(", subscriptionId=");
			sb.append(subscriptionId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchIoTComponentException(sb.toString());
		}

		return ioTComponent;
	}

	/**
	 * Returns the io t component where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByOID_S(String originalId, long subscriptionId) {
		return fetchByOID_S(originalId, subscriptionId, true);
	}

	/**
	 * Returns the io t component where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByOID_S(
		String originalId, long subscriptionId, boolean useFinderCache) {

		originalId = Objects.toString(originalId, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {originalId, subscriptionId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByOID_S, finderArgs, this);
		}

		if (result instanceof IoTComponent) {
			IoTComponent ioTComponent = (IoTComponent)result;

			if (!Objects.equals(originalId, ioTComponent.getOriginalId()) ||
				(subscriptionId != ioTComponent.getSubscriptionId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			boolean bindOriginalId = false;

			if (originalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_OID_S_ORIGINALID_3);
			}
			else {
				bindOriginalId = true;

				sb.append(_FINDER_COLUMN_OID_S_ORIGINALID_2);
			}

			sb.append(_FINDER_COLUMN_OID_S_SUBSCRIPTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOriginalId) {
					queryPos.add(originalId);
				}

				queryPos.add(subscriptionId);

				List<IoTComponent> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByOID_S, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									originalId, subscriptionId
								};
							}

							_log.warn(
								"IoTComponentPersistenceImpl.fetchByOID_S(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					IoTComponent ioTComponent = list.get(0);

					result = ioTComponent;

					cacheResult(ioTComponent);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (IoTComponent)result;
		}
	}

	/**
	 * Removes the io t component where originalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the io t component that was removed
	 */
	@Override
	public IoTComponent removeByOID_S(String originalId, long subscriptionId)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = findByOID_S(originalId, subscriptionId);

		return remove(ioTComponent);
	}

	/**
	 * Returns the number of io t components where originalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t components
	 */
	@Override
	public int countByOID_S(String originalId, long subscriptionId) {
		originalId = Objects.toString(originalId, "");

		FinderPath finderPath = _finderPathCountByOID_S;

		Object[] finderArgs = new Object[] {originalId, subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			boolean bindOriginalId = false;

			if (originalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_OID_S_ORIGINALID_3);
			}
			else {
				bindOriginalId = true;

				sb.append(_FINDER_COLUMN_OID_S_ORIGINALID_2);
			}

			sb.append(_FINDER_COLUMN_OID_S_SUBSCRIPTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOriginalId) {
					queryPos.add(originalId);
				}

				queryPos.add(subscriptionId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_OID_S_ORIGINALID_2 =
		"ioTComponent.originalId = ? AND ";

	private static final String _FINDER_COLUMN_OID_S_ORIGINALID_3 =
		"(ioTComponent.originalId IS NULL OR ioTComponent.originalId = '') AND ";

	private static final String _FINDER_COLUMN_OID_S_SUBSCRIPTIONID_2 =
		"ioTComponent.subscriptionId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the io t components where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching io t components
	 */
	@Override
	public List<IoTComponent> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByStatus(
		int status, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t components where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByStatus(
		int status, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<IoTComponent> list = null;

		if (useFinderCache) {
			list = (List<IoTComponent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTComponent ioTComponent : list) {
					if (status != ioTComponent.getStatus()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<IoTComponent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first io t component in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByStatus_First(
			int status, OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByStatus_First(
			status, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the first io t component in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByStatus_First(
		int status, OrderByComparator<IoTComponent> orderByComparator) {

		List<IoTComponent> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t component in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByStatus_Last(
			int status, OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByStatus_Last(
			status, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the last io t component in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByStatus_Last(
		int status, OrderByComparator<IoTComponent> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<IoTComponent> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where status = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent[] findByStatus_PrevAndNext(
			long iotComponentId, int status,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = findByPrimaryKey(iotComponentId);

		Session session = null;

		try {
			session = openSession();

			IoTComponent[] array = new IoTComponentImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, ioTComponent, status, orderByComparator, true);

			array[1] = ioTComponent;

			array[2] = getByStatus_PrevAndNext(
				session, ioTComponent, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTComponent getByStatus_PrevAndNext(
		Session session, IoTComponent ioTComponent, int status,
		OrderByComparator<IoTComponent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ioTComponent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTComponent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t components where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (IoTComponent ioTComponent :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ioTComponent);
		}
	}

	/**
	 * Returns the number of io t components where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching io t components
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"ioTComponent.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the io t components where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t components
	 */
	@Override
	public List<IoTComponent> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t components where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByG_S;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByG_S;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<IoTComponent> list = null;

		if (useFinderCache) {
			list = (List<IoTComponent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTComponent ioTComponent : list) {
					if ((groupId != ioTComponent.getGroupId()) ||
						(status != ioTComponent.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<IoTComponent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByG_S_First(
			long groupId, int status,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the first io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<IoTComponent> orderByComparator) {

		List<IoTComponent> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findByG_S_Last(
			long groupId, int status,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the last io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<IoTComponent> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<IoTComponent> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent[] findByG_S_PrevAndNext(
			long iotComponentId, long groupId, int status,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = findByPrimaryKey(iotComponentId);

		Session session = null;

		try {
			session = openSession();

			IoTComponent[] array = new IoTComponentImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, ioTComponent, groupId, status, orderByComparator,
				true);

			array[1] = ioTComponent;

			array[2] = getByG_S_PrevAndNext(
				session, ioTComponent, groupId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTComponent getByG_S_PrevAndNext(
		Session session, IoTComponent ioTComponent, long groupId, int status,
		OrderByComparator<IoTComponent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ioTComponent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTComponent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the io t components that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t components that the user has permission to view
	 */
	@Override
	public List<IoTComponent> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components that the user has permission to view
	 */
	@Override
	public List<IoTComponent> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components that the user has permission to view
	 */
	@Override
	public List<IoTComponent> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S(groupId, status, start, end, orderByComparator);
		}

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByFields().length * 2));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_IOTCOMPONENT_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			if (getDB().isSupportsInlineDistinct()) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator, true);
			}
			else {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_TABLE, orderByComparator, true);
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTComponent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, IoTComponentImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, IoTComponentImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<IoTComponent>)QueryUtil.list(
				sqlQuery, getDialect(), start, end);
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	/**
	 * Returns the io t components before and after the current io t component in the ordered set of io t components that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent[] filterFindByG_S_PrevAndNext(
			long iotComponentId, long groupId, int status,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				iotComponentId, groupId, status, orderByComparator);
		}

		IoTComponent ioTComponent = findByPrimaryKey(iotComponentId);

		Session session = null;

		try {
			session = openSession();

			IoTComponent[] array = new IoTComponentImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, ioTComponent, groupId, status, orderByComparator,
				true);

			array[1] = ioTComponent;

			array[2] = filterGetByG_S_PrevAndNext(
				session, ioTComponent, groupId, status, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTComponent filterGetByG_S_PrevAndNext(
		Session session, IoTComponent ioTComponent, long groupId, int status,
		OrderByComparator<IoTComponent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		if (getDB().isSupportsInlineDistinct()) {
			sb.append(_FILTER_SQL_SELECT_IOTCOMPONENT_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByConditionFields[i],
							true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByConditionFields[i],
							true));
				}

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				if (getDB().isSupportsInlineDistinct()) {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_ALIAS, orderByFields[i], true));
				}
				else {
					sb.append(
						getColumnName(
							_ORDER_BY_ENTITY_TABLE, orderByFields[i], true));
				}

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			if (getDB().isSupportsInlineDistinct()) {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTComponent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, IoTComponentImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, IoTComponentImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ioTComponent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTComponent> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t components where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (IoTComponent ioTComponent :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ioTComponent);
		}
	}

	/**
	 * Returns the number of io t components where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t components
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of io t components that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t components that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_IOTCOMPONENT_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTComponent.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			sqlQuery.addScalar(
				COUNT_COLUMN_NAME, com.liferay.portal.kernel.dao.orm.Type.LONG);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			Long count = (Long)sqlQuery.uniqueResult();

			return count.intValue();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 =
		"ioTComponent.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"ioTComponent.status = ?";

	private FinderPath _finderPathWithPaginationFindBySubscriptionId;
	private FinderPath _finderPathWithoutPaginationFindBySubscriptionId;
	private FinderPath _finderPathCountBySubscriptionId;

	/**
	 * Returns all the io t components where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching io t components
	 */
	@Override
	public List<IoTComponent> findBySubscriptionId(long subscriptionId) {
		return findBySubscriptionId(
			subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of matching io t components
	 */
	@Override
	public List<IoTComponent> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return findBySubscriptionId(subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator) {

		return findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t components where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t components
	 */
	@Override
	public List<IoTComponent> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<IoTComponent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindBySubscriptionId;
				finderArgs = new Object[] {subscriptionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindBySubscriptionId;
			finderArgs = new Object[] {
				subscriptionId, start, end, orderByComparator
			};
		}

		List<IoTComponent> list = null;

		if (useFinderCache) {
			list = (List<IoTComponent>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTComponent ioTComponent : list) {
					if (subscriptionId != ioTComponent.getSubscriptionId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

			sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				list = (List<IoTComponent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the first io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<IoTComponent> orderByComparator) {

		List<IoTComponent> list = findBySubscriptionId(
			subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component
	 * @throws NoSuchIoTComponentException if a matching io t component could not be found
	 */
	@Override
	public IoTComponent findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);

		if (ioTComponent != null) {
			return ioTComponent;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchIoTComponentException(sb.toString());
	}

	/**
	 * Returns the last io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t component, or <code>null</code> if a matching io t component could not be found
	 */
	@Override
	public IoTComponent fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<IoTComponent> orderByComparator) {

		int count = countBySubscriptionId(subscriptionId);

		if (count == 0) {
			return null;
		}

		List<IoTComponent> list = findBySubscriptionId(
			subscriptionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t components before and after the current io t component in the ordered set where subscriptionId = &#63;.
	 *
	 * @param iotComponentId the primary key of the current io t component
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent[] findBySubscriptionId_PrevAndNext(
			long iotComponentId, long subscriptionId,
			OrderByComparator<IoTComponent> orderByComparator)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = findByPrimaryKey(iotComponentId);

		Session session = null;

		try {
			session = openSession();

			IoTComponent[] array = new IoTComponentImpl[3];

			array[0] = getBySubscriptionId_PrevAndNext(
				session, ioTComponent, subscriptionId, orderByComparator, true);

			array[1] = ioTComponent;

			array[2] = getBySubscriptionId_PrevAndNext(
				session, ioTComponent, subscriptionId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTComponent getBySubscriptionId_PrevAndNext(
		Session session, IoTComponent ioTComponent, long subscriptionId,
		OrderByComparator<IoTComponent> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IOTCOMPONENT_WHERE);

		sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(IoTComponentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subscriptionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ioTComponent)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTComponent> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t components where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeBySubscriptionId(long subscriptionId) {
		for (IoTComponent ioTComponent :
				findBySubscriptionId(
					subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ioTComponent);
		}
	}

	/**
	 * Returns the number of io t components where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t components
	 */
	@Override
	public int countBySubscriptionId(long subscriptionId) {
		FinderPath finderPath = _finderPathCountBySubscriptionId;

		Object[] finderArgs = new Object[] {subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTCOMPONENT_WHERE);

			sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2 =
		"ioTComponent.subscriptionId = ?";

	public IoTComponentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(IoTComponent.class);

		setModelImplClass(IoTComponentImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the io t component in the entity cache if it is enabled.
	 *
	 * @param ioTComponent the io t component
	 */
	@Override
	public void cacheResult(IoTComponent ioTComponent) {
		entityCache.putResult(
			IoTComponentImpl.class, ioTComponent.getPrimaryKey(), ioTComponent);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {ioTComponent.getUuid(), ioTComponent.getGroupId()},
			ioTComponent);

		finderCache.putResult(
			_finderPathFetchByOriginalId,
			new Object[] {ioTComponent.getOriginalId()}, ioTComponent);

		finderCache.putResult(
			_finderPathFetchByOID_S,
			new Object[] {
				ioTComponent.getOriginalId(), ioTComponent.getSubscriptionId()
			},
			ioTComponent);
	}

	/**
	 * Caches the io t components in the entity cache if it is enabled.
	 *
	 * @param ioTComponents the io t components
	 */
	@Override
	public void cacheResult(List<IoTComponent> ioTComponents) {
		for (IoTComponent ioTComponent : ioTComponents) {
			if (entityCache.getResult(
					IoTComponentImpl.class, ioTComponent.getPrimaryKey()) ==
						null) {

				cacheResult(ioTComponent);
			}
		}
	}

	/**
	 * Clears the cache for all io t components.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IoTComponentImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the io t component.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IoTComponent ioTComponent) {
		entityCache.removeResult(IoTComponentImpl.class, ioTComponent);
	}

	@Override
	public void clearCache(List<IoTComponent> ioTComponents) {
		for (IoTComponent ioTComponent : ioTComponents) {
			entityCache.removeResult(IoTComponentImpl.class, ioTComponent);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IoTComponentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		IoTComponentModelImpl ioTComponentModelImpl) {

		Object[] args = new Object[] {
			ioTComponentModelImpl.getUuid(), ioTComponentModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ioTComponentModelImpl, false);

		args = new Object[] {ioTComponentModelImpl.getOriginalId()};

		finderCache.putResult(
			_finderPathCountByOriginalId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByOriginalId, args, ioTComponentModelImpl, false);

		args = new Object[] {
			ioTComponentModelImpl.getOriginalId(),
			ioTComponentModelImpl.getSubscriptionId()
		};

		finderCache.putResult(
			_finderPathCountByOID_S, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByOID_S, args, ioTComponentModelImpl, false);
	}

	/**
	 * Creates a new io t component with the primary key. Does not add the io t component to the database.
	 *
	 * @param iotComponentId the primary key for the new io t component
	 * @return the new io t component
	 */
	@Override
	public IoTComponent create(long iotComponentId) {
		IoTComponent ioTComponent = new IoTComponentImpl();

		ioTComponent.setNew(true);
		ioTComponent.setPrimaryKey(iotComponentId);

		String uuid = PortalUUIDUtil.generate();

		ioTComponent.setUuid(uuid);

		ioTComponent.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ioTComponent;
	}

	/**
	 * Removes the io t component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component that was removed
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent remove(long iotComponentId)
		throws NoSuchIoTComponentException {

		return remove((Serializable)iotComponentId);
	}

	/**
	 * Removes the io t component with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the io t component
	 * @return the io t component that was removed
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent remove(Serializable primaryKey)
		throws NoSuchIoTComponentException {

		Session session = null;

		try {
			session = openSession();

			IoTComponent ioTComponent = (IoTComponent)session.get(
				IoTComponentImpl.class, primaryKey);

			if (ioTComponent == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIoTComponentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ioTComponent);
		}
		catch (NoSuchIoTComponentException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected IoTComponent removeImpl(IoTComponent ioTComponent) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ioTComponent)) {
				ioTComponent = (IoTComponent)session.get(
					IoTComponentImpl.class, ioTComponent.getPrimaryKeyObj());
			}

			if (ioTComponent != null) {
				session.delete(ioTComponent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ioTComponent != null) {
			clearCache(ioTComponent);
		}

		return ioTComponent;
	}

	@Override
	public IoTComponent updateImpl(IoTComponent ioTComponent) {
		boolean isNew = ioTComponent.isNew();

		if (!(ioTComponent instanceof IoTComponentModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ioTComponent.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ioTComponent);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ioTComponent proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom IoTComponent implementation " +
					ioTComponent.getClass());
		}

		IoTComponentModelImpl ioTComponentModelImpl =
			(IoTComponentModelImpl)ioTComponent;

		if (Validator.isNull(ioTComponent.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ioTComponent.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ioTComponent.getCreateDate() == null)) {
			if (serviceContext == null) {
				ioTComponent.setCreateDate(now);
			}
			else {
				ioTComponent.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ioTComponentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ioTComponent.setModifiedDate(now);
			}
			else {
				ioTComponent.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ioTComponent);
			}
			else {
				ioTComponent = (IoTComponent)session.merge(ioTComponent);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			IoTComponentImpl.class, ioTComponentModelImpl, false, true);

		cacheUniqueFindersCache(ioTComponentModelImpl);

		if (isNew) {
			ioTComponent.setNew(false);
		}

		ioTComponent.resetOriginalValues();

		return ioTComponent;
	}

	/**
	 * Returns the io t component with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the io t component
	 * @return the io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIoTComponentException {

		IoTComponent ioTComponent = fetchByPrimaryKey(primaryKey);

		if (ioTComponent == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIoTComponentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ioTComponent;
	}

	/**
	 * Returns the io t component with the primary key or throws a <code>NoSuchIoTComponentException</code> if it could not be found.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component
	 * @throws NoSuchIoTComponentException if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent findByPrimaryKey(long iotComponentId)
		throws NoSuchIoTComponentException {

		return findByPrimaryKey((Serializable)iotComponentId);
	}

	/**
	 * Returns the io t component with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iotComponentId the primary key of the io t component
	 * @return the io t component, or <code>null</code> if a io t component with the primary key could not be found
	 */
	@Override
	public IoTComponent fetchByPrimaryKey(long iotComponentId) {
		return fetchByPrimaryKey((Serializable)iotComponentId);
	}

	/**
	 * Returns all the io t components.
	 *
	 * @return the io t components
	 */
	@Override
	public List<IoTComponent> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @return the range of io t components
	 */
	@Override
	public List<IoTComponent> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of io t components
	 */
	@Override
	public List<IoTComponent> findAll(
		int start, int end, OrderByComparator<IoTComponent> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t components.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTComponentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t components
	 * @param end the upper bound of the range of io t components (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of io t components
	 */
	@Override
	public List<IoTComponent> findAll(
		int start, int end, OrderByComparator<IoTComponent> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<IoTComponent> list = null;

		if (useFinderCache) {
			list = (List<IoTComponent>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IOTCOMPONENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IOTCOMPONENT;

				sql = sql.concat(IoTComponentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<IoTComponent>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the io t components from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IoTComponent ioTComponent : findAll()) {
			remove(ioTComponent);
		}
	}

	/**
	 * Returns the number of io t components.
	 *
	 * @return the number of io t components
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_IOTCOMPONENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "iotComponentId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_IOTCOMPONENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IoTComponentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the io t component persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new IoTComponentModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", IoTComponent.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathFetchByOriginalId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByOriginalId",
			new String[] {String.class.getName()}, new String[] {"originalId"},
			true);

		_finderPathCountByOriginalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOriginalId",
			new String[] {String.class.getName()}, new String[] {"originalId"},
			false);

		_finderPathFetchByOID_S = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByOID_S",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"originalId", "subscriptionId"}, true);

		_finderPathCountByOID_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOID_S",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"originalId", "subscriptionId"}, false);

		_finderPathWithPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"status"}, true);

		_finderPathWithoutPaginationFindByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			true);

		_finderPathCountByStatus = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()}, new String[] {"status"},
			false);

		_finderPathWithPaginationFindByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status"}, true);

		_finderPathWithoutPaginationFindByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, true);

		_finderPathCountByG_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, false);

		_finderPathWithPaginationFindBySubscriptionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubscriptionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"subscriptionId"}, true);

		_finderPathWithoutPaginationFindBySubscriptionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubscriptionId",
			new String[] {Long.class.getName()},
			new String[] {"subscriptionId"}, true);

		_finderPathCountBySubscriptionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubscriptionId",
			new String[] {Long.class.getName()},
			new String[] {"subscriptionId"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(IoTComponentImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = IoTCataloguePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = IoTCataloguePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = IoTCataloguePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IOTCOMPONENT =
		"SELECT ioTComponent FROM IoTComponent ioTComponent";

	private static final String _SQL_SELECT_IOTCOMPONENT_WHERE =
		"SELECT ioTComponent FROM IoTComponent ioTComponent WHERE ";

	private static final String _SQL_COUNT_IOTCOMPONENT =
		"SELECT COUNT(ioTComponent) FROM IoTComponent ioTComponent";

	private static final String _SQL_COUNT_IOTCOMPONENT_WHERE =
		"SELECT COUNT(ioTComponent) FROM IoTComponent ioTComponent WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"ioTComponent.iotComponentId";

	private static final String _FILTER_SQL_SELECT_IOTCOMPONENT_WHERE =
		"SELECT DISTINCT {ioTComponent.*} FROM IoTCatalogue_IoTComponent ioTComponent WHERE ";

	private static final String
		_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {IoTCatalogue_IoTComponent.*} FROM (SELECT DISTINCT ioTComponent.iotComponentId FROM IoTCatalogue_IoTComponent ioTComponent WHERE ";

	private static final String
		_FILTER_SQL_SELECT_IOTCOMPONENT_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN IoTCatalogue_IoTComponent ON TEMP_TABLE.iotComponentId = IoTCatalogue_IoTComponent.iotComponentId";

	private static final String _FILTER_SQL_COUNT_IOTCOMPONENT_WHERE =
		"SELECT COUNT(DISTINCT ioTComponent.iotComponentId) AS COUNT_VALUE FROM IoTCatalogue_IoTComponent ioTComponent WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "ioTComponent";

	private static final String _FILTER_ENTITY_TABLE =
		"IoTCatalogue_IoTComponent";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ioTComponent.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"IoTCatalogue_IoTComponent.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No IoTComponent exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No IoTComponent exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IoTComponentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class IoTComponentModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			IoTComponentModelImpl ioTComponentModelImpl =
				(IoTComponentModelImpl)baseModel;

			long columnBitmask = ioTComponentModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(ioTComponentModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						ioTComponentModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(ioTComponentModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			IoTComponentModelImpl ioTComponentModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = ioTComponentModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = ioTComponentModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}