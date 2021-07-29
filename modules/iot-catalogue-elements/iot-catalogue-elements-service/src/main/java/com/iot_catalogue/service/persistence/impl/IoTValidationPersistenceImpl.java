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

import com.iot_catalogue.exception.NoSuchIoTValidationException;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.model.impl.IoTValidationImpl;
import com.iot_catalogue.model.impl.IoTValidationModelImpl;
import com.iot_catalogue.service.persistence.IoTValidationPersistence;
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
 * The persistence implementation for the io t validation service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = IoTValidationPersistence.class)
public class IoTValidationPersistenceImpl
	extends BasePersistenceImpl<IoTValidation>
	implements IoTValidationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>IoTValidationUtil</code> to access the io t validation persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		IoTValidationImpl.class.getName();

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
	 * Returns all the io t validations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching io t validations
	 */
	@Override
	public List<IoTValidation> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t validations where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
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

		List<IoTValidation> list = null;

		if (useFinderCache) {
			list = (List<IoTValidation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTValidation ioTValidation : list) {
					if (!uuid.equals(ioTValidation.getUuid())) {
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

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
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

				list = (List<IoTValidation>)QueryUtil.list(
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
	 * Returns the first io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByUuid_First(
			String uuid, OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByUuid_First(
			uuid, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByUuid_First(
		String uuid, OrderByComparator<IoTValidation> orderByComparator) {

		List<IoTValidation> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByUuid_Last(
			String uuid, OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByUuid_Last(uuid, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByUuid_Last(
		String uuid, OrderByComparator<IoTValidation> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<IoTValidation> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where uuid = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation[] findByUuid_PrevAndNext(
			long iotValidationId, String uuid,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		uuid = Objects.toString(uuid, "");

		IoTValidation ioTValidation = findByPrimaryKey(iotValidationId);

		Session session = null;

		try {
			session = openSession();

			IoTValidation[] array = new IoTValidationImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ioTValidation, uuid, orderByComparator, true);

			array[1] = ioTValidation;

			array[2] = getByUuid_PrevAndNext(
				session, ioTValidation, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTValidation getByUuid_PrevAndNext(
		Session session, IoTValidation ioTValidation, String uuid,
		OrderByComparator<IoTValidation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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
			sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						ioTValidation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTValidation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t validations where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (IoTValidation ioTValidation :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ioTValidation);
		}
	}

	/**
	 * Returns the number of io t validations where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching io t validations
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
		"ioTValidation.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ioTValidation.uuid IS NULL OR ioTValidation.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByUUID_G(String uuid, long groupId)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByUUID_G(uuid, groupId);

		if (ioTValidation == null) {
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

			throw new NoSuchIoTValidationException(sb.toString());
		}

		return ioTValidation;
	}

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the io t validation where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByUUID_G(
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

		if (result instanceof IoTValidation) {
			IoTValidation ioTValidation = (IoTValidation)result;

			if (!Objects.equals(uuid, ioTValidation.getUuid()) ||
				(groupId != ioTValidation.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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

				List<IoTValidation> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					IoTValidation ioTValidation = list.get(0);

					result = ioTValidation;

					cacheResult(ioTValidation);
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
			return (IoTValidation)result;
		}
	}

	/**
	 * Removes the io t validation where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the io t validation that was removed
	 */
	@Override
	public IoTValidation removeByUUID_G(String uuid, long groupId)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = findByUUID_G(uuid, groupId);

		return remove(ioTValidation);
	}

	/**
	 * Returns the number of io t validations where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching io t validations
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
		"ioTValidation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ioTValidation.uuid IS NULL OR ioTValidation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ioTValidation.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching io t validations
	 */
	@Override
	public List<IoTValidation> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
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

		List<IoTValidation> list = null;

		if (useFinderCache) {
			list = (List<IoTValidation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTValidation ioTValidation : list) {
					if (!uuid.equals(ioTValidation.getUuid()) ||
						(companyId != ioTValidation.getCompanyId())) {

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

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
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

				list = (List<IoTValidation>)QueryUtil.list(
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
	 * Returns the first io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the first io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<IoTValidation> orderByComparator) {

		List<IoTValidation> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the last io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<IoTValidation> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<IoTValidation> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation[] findByUuid_C_PrevAndNext(
			long iotValidationId, String uuid, long companyId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		uuid = Objects.toString(uuid, "");

		IoTValidation ioTValidation = findByPrimaryKey(iotValidationId);

		Session session = null;

		try {
			session = openSession();

			IoTValidation[] array = new IoTValidationImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ioTValidation, uuid, companyId, orderByComparator,
				true);

			array[1] = ioTValidation;

			array[2] = getByUuid_C_PrevAndNext(
				session, ioTValidation, uuid, companyId, orderByComparator,
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

	protected IoTValidation getByUuid_C_PrevAndNext(
		Session session, IoTValidation ioTValidation, String uuid,
		long companyId, OrderByComparator<IoTValidation> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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
			sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						ioTValidation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTValidation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t validations where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (IoTValidation ioTValidation :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ioTValidation);
		}
	}

	/**
	 * Returns the number of io t validations where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching io t validations
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
		"ioTValidation.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ioTValidation.uuid IS NULL OR ioTValidation.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ioTValidation.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the io t validations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t validations
	 */
	@Override
	public List<IoTValidation> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t validations where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
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

		List<IoTValidation> list = null;

		if (useFinderCache) {
			list = (List<IoTValidation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTValidation ioTValidation : list) {
					if (groupId != ioTValidation.getGroupId()) {
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

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<IoTValidation>)QueryUtil.list(
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
	 * Returns the first io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByGroupId_First(
			long groupId, OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByGroupId_First(
			groupId, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByGroupId_First(
		long groupId, OrderByComparator<IoTValidation> orderByComparator) {

		List<IoTValidation> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByGroupId_Last(
			long groupId, OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByGroupId_Last(
		long groupId, OrderByComparator<IoTValidation> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<IoTValidation> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where groupId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation[] findByGroupId_PrevAndNext(
			long iotValidationId, long groupId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = findByPrimaryKey(iotValidationId);

		Session session = null;

		try {
			session = openSession();

			IoTValidation[] array = new IoTValidationImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, ioTValidation, groupId, orderByComparator, true);

			array[1] = ioTValidation;

			array[2] = getByGroupId_PrevAndNext(
				session, ioTValidation, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTValidation getByGroupId_PrevAndNext(
		Session session, IoTValidation ioTValidation, long groupId,
		OrderByComparator<IoTValidation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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
			sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ioTValidation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTValidation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching io t validations that the user has permission to view
	 */
	@Override
	public List<IoTValidation> filterFindByGroupId(long groupId) {
		return filterFindByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations that the user has permission to view
	 */
	@Override
	public List<IoTValidation> filterFindByGroupId(
		long groupId, int start, int end) {

		return filterFindByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations that the user has permissions to view where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations that the user has permission to view
	 */
	@Override
	public List<IoTValidation> filterFindByGroupId(
		long groupId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_IOTVALIDATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(IoTValidationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTValidation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, IoTValidationImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, IoTValidationImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			return (List<IoTValidation>)QueryUtil.list(
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
	 * Returns the io t validations before and after the current io t validation in the ordered set of io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation[] filterFindByGroupId_PrevAndNext(
			long iotValidationId, long groupId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByGroupId_PrevAndNext(
				iotValidationId, groupId, orderByComparator);
		}

		IoTValidation ioTValidation = findByPrimaryKey(iotValidationId);

		Session session = null;

		try {
			session = openSession();

			IoTValidation[] array = new IoTValidationImpl[3];

			array[0] = filterGetByGroupId_PrevAndNext(
				session, ioTValidation, groupId, orderByComparator, true);

			array[1] = ioTValidation;

			array[2] = filterGetByGroupId_PrevAndNext(
				session, ioTValidation, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTValidation filterGetByGroupId_PrevAndNext(
		Session session, IoTValidation ioTValidation, long groupId,
		OrderByComparator<IoTValidation> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_IOTVALIDATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(IoTValidationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTValidation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, IoTValidationImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, IoTValidationImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ioTValidation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTValidation> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t validations where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (IoTValidation ioTValidation :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ioTValidation);
		}
	}

	/**
	 * Returns the number of io t validations where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t validations
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
	 * Returns the number of io t validations that the user has permission to view where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching io t validations that the user has permission to view
	 */
	@Override
	public int filterCountByGroupId(long groupId) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByGroupId(groupId);
		}

		StringBundler sb = new StringBundler(2);

		sb.append(_FILTER_SQL_COUNT_IOTVALIDATION_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTValidation.class.getName(),
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
		"ioTValidation.groupId = ?";

	private FinderPath _finderPathFetchByOriginalId;
	private FinderPath _finderPathCountByOriginalId;

	/**
	 * Returns the io t validation where originalId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByOriginalId(String originalId)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByOriginalId(originalId);

		if (ioTValidation == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("originalId=");
			sb.append(originalId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchIoTValidationException(sb.toString());
		}

		return ioTValidation;
	}

	/**
	 * Returns the io t validation where originalId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByOriginalId(String originalId) {
		return fetchByOriginalId(originalId, true);
	}

	/**
	 * Returns the io t validation where originalId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByOriginalId(
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

		if (result instanceof IoTValidation) {
			IoTValidation ioTValidation = (IoTValidation)result;

			if (!Objects.equals(originalId, ioTValidation.getOriginalId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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

				List<IoTValidation> list = query.list();

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
								"IoTValidationPersistenceImpl.fetchByOriginalId(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					IoTValidation ioTValidation = list.get(0);

					result = ioTValidation;

					cacheResult(ioTValidation);
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
			return (IoTValidation)result;
		}
	}

	/**
	 * Removes the io t validation where originalId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @return the io t validation that was removed
	 */
	@Override
	public IoTValidation removeByOriginalId(String originalId)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = findByOriginalId(originalId);

		return remove(ioTValidation);
	}

	/**
	 * Returns the number of io t validations where originalId = &#63;.
	 *
	 * @param originalId the original ID
	 * @return the number of matching io t validations
	 */
	@Override
	public int countByOriginalId(String originalId) {
		originalId = Objects.toString(originalId, "");

		FinderPath finderPath = _finderPathCountByOriginalId;

		Object[] finderArgs = new Object[] {originalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
		"ioTValidation.originalId = ?";

	private static final String _FINDER_COLUMN_ORIGINALID_ORIGINALID_3 =
		"(ioTValidation.originalId IS NULL OR ioTValidation.originalId = '')";

	private FinderPath _finderPathFetchByOID_S;
	private FinderPath _finderPathCountByOID_S;

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByOID_S(String originalId, long subscriptionId)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByOID_S(originalId, subscriptionId);

		if (ioTValidation == null) {
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

			throw new NoSuchIoTValidationException(sb.toString());
		}

		return ioTValidation;
	}

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByOID_S(String originalId, long subscriptionId) {
		return fetchByOID_S(originalId, subscriptionId, true);
	}

	/**
	 * Returns the io t validation where originalId = &#63; and subscriptionId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByOID_S(
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

		if (result instanceof IoTValidation) {
			IoTValidation ioTValidation = (IoTValidation)result;

			if (!Objects.equals(originalId, ioTValidation.getOriginalId()) ||
				(subscriptionId != ioTValidation.getSubscriptionId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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

				List<IoTValidation> list = query.list();

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
								"IoTValidationPersistenceImpl.fetchByOID_S(String, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					IoTValidation ioTValidation = list.get(0);

					result = ioTValidation;

					cacheResult(ioTValidation);
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
			return (IoTValidation)result;
		}
	}

	/**
	 * Removes the io t validation where originalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the io t validation that was removed
	 */
	@Override
	public IoTValidation removeByOID_S(String originalId, long subscriptionId)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = findByOID_S(originalId, subscriptionId);

		return remove(ioTValidation);
	}

	/**
	 * Returns the number of io t validations where originalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param originalId the original ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t validations
	 */
	@Override
	public int countByOID_S(String originalId, long subscriptionId) {
		originalId = Objects.toString(originalId, "");

		FinderPath finderPath = _finderPathCountByOID_S;

		Object[] finderArgs = new Object[] {originalId, subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
		"ioTValidation.originalId = ? AND ";

	private static final String _FINDER_COLUMN_OID_S_ORIGINALID_3 =
		"(ioTValidation.originalId IS NULL OR ioTValidation.originalId = '') AND ";

	private static final String _FINDER_COLUMN_OID_S_SUBSCRIPTIONID_2 =
		"ioTValidation.subscriptionId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the io t validations where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching io t validations
	 */
	@Override
	public List<IoTValidation> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByStatus(
		int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t validations where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByStatus(
		int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
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

		List<IoTValidation> list = null;

		if (useFinderCache) {
			list = (List<IoTValidation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTValidation ioTValidation : list) {
					if (status != ioTValidation.getStatus()) {
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

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<IoTValidation>)QueryUtil.list(
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
	 * Returns the first io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByStatus_First(
			int status, OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByStatus_First(
			status, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the first io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByStatus_First(
		int status, OrderByComparator<IoTValidation> orderByComparator) {

		List<IoTValidation> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByStatus_Last(
			int status, OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByStatus_Last(
			status, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the last io t validation in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByStatus_Last(
		int status, OrderByComparator<IoTValidation> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<IoTValidation> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where status = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation[] findByStatus_PrevAndNext(
			long iotValidationId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = findByPrimaryKey(iotValidationId);

		Session session = null;

		try {
			session = openSession();

			IoTValidation[] array = new IoTValidationImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, ioTValidation, status, orderByComparator, true);

			array[1] = ioTValidation;

			array[2] = getByStatus_PrevAndNext(
				session, ioTValidation, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected IoTValidation getByStatus_PrevAndNext(
		Session session, IoTValidation ioTValidation, int status,
		OrderByComparator<IoTValidation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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
			sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ioTValidation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTValidation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t validations where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (IoTValidation ioTValidation :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ioTValidation);
		}
	}

	/**
	 * Returns the number of io t validations where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching io t validations
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
		"ioTValidation.status = ?";

	private FinderPath _finderPathWithPaginationFindByG_S;
	private FinderPath _finderPathWithoutPaginationFindByG_S;
	private FinderPath _finderPathCountByG_S;

	/**
	 * Returns all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t validations
	 */
	@Override
	public List<IoTValidation> findByG_S(long groupId, int status) {
		return findByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end) {

		return findByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return findByG_S(groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t validations where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
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

		List<IoTValidation> list = null;

		if (useFinderCache) {
			list = (List<IoTValidation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTValidation ioTValidation : list) {
					if ((groupId != ioTValidation.getGroupId()) ||
						(status != ioTValidation.getStatus())) {

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

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

			sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

			sb.append(_FINDER_COLUMN_G_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<IoTValidation>)QueryUtil.list(
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
	 * Returns the first io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByG_S_First(
			long groupId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByG_S_First(
			groupId, status, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the first io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByG_S_First(
		long groupId, int status,
		OrderByComparator<IoTValidation> orderByComparator) {

		List<IoTValidation> list = findByG_S(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findByG_S_Last(
			long groupId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByG_S_Last(
			groupId, status, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the last io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchByG_S_Last(
		long groupId, int status,
		OrderByComparator<IoTValidation> orderByComparator) {

		int count = countByG_S(groupId, status);

		if (count == 0) {
			return null;
		}

		List<IoTValidation> list = findByG_S(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation[] findByG_S_PrevAndNext(
			long iotValidationId, long groupId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = findByPrimaryKey(iotValidationId);

		Session session = null;

		try {
			session = openSession();

			IoTValidation[] array = new IoTValidationImpl[3];

			array[0] = getByG_S_PrevAndNext(
				session, ioTValidation, groupId, status, orderByComparator,
				true);

			array[1] = ioTValidation;

			array[2] = getByG_S_PrevAndNext(
				session, ioTValidation, groupId, status, orderByComparator,
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

	protected IoTValidation getByG_S_PrevAndNext(
		Session session, IoTValidation ioTValidation, long groupId, int status,
		OrderByComparator<IoTValidation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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
			sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						ioTValidation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTValidation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching io t validations that the user has permission to view
	 */
	@Override
	public List<IoTValidation> filterFindByG_S(long groupId, int status) {
		return filterFindByG_S(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations that the user has permission to view
	 */
	@Override
	public List<IoTValidation> filterFindByG_S(
		long groupId, int status, int start, int end) {

		return filterFindByG_S(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations that the user has permissions to view where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations that the user has permission to view
	 */
	@Override
	public List<IoTValidation> filterFindByG_S(
		long groupId, int status, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

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
			sb.append(_FILTER_SQL_SELECT_IOTVALIDATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(IoTValidationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTValidation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		Session session = null;

		try {
			session = openSession();

			SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

			if (getDB().isSupportsInlineDistinct()) {
				sqlQuery.addEntity(
					_FILTER_ENTITY_ALIAS, IoTValidationImpl.class);
			}
			else {
				sqlQuery.addEntity(
					_FILTER_ENTITY_TABLE, IoTValidationImpl.class);
			}

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);

			queryPos.add(groupId);

			queryPos.add(status);

			return (List<IoTValidation>)QueryUtil.list(
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
	 * Returns the io t validations before and after the current io t validation in the ordered set of io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation[] filterFindByG_S_PrevAndNext(
			long iotValidationId, long groupId, int status,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return findByG_S_PrevAndNext(
				iotValidationId, groupId, status, orderByComparator);
		}

		IoTValidation ioTValidation = findByPrimaryKey(iotValidationId);

		Session session = null;

		try {
			session = openSession();

			IoTValidation[] array = new IoTValidationImpl[3];

			array[0] = filterGetByG_S_PrevAndNext(
				session, ioTValidation, groupId, status, orderByComparator,
				true);

			array[1] = ioTValidation;

			array[2] = filterGetByG_S_PrevAndNext(
				session, ioTValidation, groupId, status, orderByComparator,
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

	protected IoTValidation filterGetByG_S_PrevAndNext(
		Session session, IoTValidation ioTValidation, long groupId, int status,
		OrderByComparator<IoTValidation> orderByComparator, boolean previous) {

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
			sb.append(_FILTER_SQL_SELECT_IOTVALIDATION_WHERE);
		}
		else {
			sb.append(
				_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_1);
		}

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		if (!getDB().isSupportsInlineDistinct()) {
			sb.append(
				_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_2);
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
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
			}
			else {
				sb.append(IoTValidationModelImpl.ORDER_BY_SQL);
			}
		}

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTValidation.class.getName(),
			_FILTER_ENTITY_TABLE_FILTER_PK_COLUMN, groupId);

		SQLQuery sqlQuery = session.createSynchronizedSQLQuery(sql);

		sqlQuery.setFirstResult(0);
		sqlQuery.setMaxResults(2);

		if (getDB().isSupportsInlineDistinct()) {
			sqlQuery.addEntity(_FILTER_ENTITY_ALIAS, IoTValidationImpl.class);
		}
		else {
			sqlQuery.addEntity(_FILTER_ENTITY_TABLE, IoTValidationImpl.class);
		}

		QueryPos queryPos = QueryPos.getInstance(sqlQuery);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ioTValidation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTValidation> list = sqlQuery.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t validations where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByG_S(long groupId, int status) {
		for (IoTValidation ioTValidation :
				findByG_S(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ioTValidation);
		}
	}

	/**
	 * Returns the number of io t validations where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t validations
	 */
	@Override
	public int countByG_S(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByG_S;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
	 * Returns the number of io t validations that the user has permission to view where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching io t validations that the user has permission to view
	 */
	@Override
	public int filterCountByG_S(long groupId, int status) {
		if (!InlineSQLHelperUtil.isEnabled(groupId)) {
			return countByG_S(groupId, status);
		}

		StringBundler sb = new StringBundler(3);

		sb.append(_FILTER_SQL_COUNT_IOTVALIDATION_WHERE);

		sb.append(_FINDER_COLUMN_G_S_GROUPID_2);

		sb.append(_FINDER_COLUMN_G_S_STATUS_2);

		String sql = InlineSQLHelperUtil.replacePermissionCheck(
			sb.toString(), IoTValidation.class.getName(),
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
		"ioTValidation.groupId = ? AND ";

	private static final String _FINDER_COLUMN_G_S_STATUS_2 =
		"ioTValidation.status = ?";

	private FinderPath _finderPathWithPaginationFindBySubscriptionId;
	private FinderPath _finderPathWithoutPaginationFindBySubscriptionId;
	private FinderPath _finderPathCountBySubscriptionId;

	/**
	 * Returns all the io t validations where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching io t validations
	 */
	@Override
	public List<IoTValidation> findBySubscriptionId(long subscriptionId) {
		return findBySubscriptionId(
			subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return findBySubscriptionId(subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t validations where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching io t validations
	 */
	@Override
	public List<IoTValidation> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<IoTValidation> orderByComparator,
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

		List<IoTValidation> list = null;

		if (useFinderCache) {
			list = (List<IoTValidation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (IoTValidation ioTValidation : list) {
					if (subscriptionId != ioTValidation.getSubscriptionId()) {
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

			sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

			sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				list = (List<IoTValidation>)QueryUtil.list(
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
	 * Returns the first io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the first io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<IoTValidation> orderByComparator) {

		List<IoTValidation> list = findBySubscriptionId(
			subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation
	 * @throws NoSuchIoTValidationException if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);

		if (ioTValidation != null) {
			return ioTValidation;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchIoTValidationException(sb.toString());
	}

	/**
	 * Returns the last io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching io t validation, or <code>null</code> if a matching io t validation could not be found
	 */
	@Override
	public IoTValidation fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<IoTValidation> orderByComparator) {

		int count = countBySubscriptionId(subscriptionId);

		if (count == 0) {
			return null;
		}

		List<IoTValidation> list = findBySubscriptionId(
			subscriptionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the io t validations before and after the current io t validation in the ordered set where subscriptionId = &#63;.
	 *
	 * @param iotValidationId the primary key of the current io t validation
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation[] findBySubscriptionId_PrevAndNext(
			long iotValidationId, long subscriptionId,
			OrderByComparator<IoTValidation> orderByComparator)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = findByPrimaryKey(iotValidationId);

		Session session = null;

		try {
			session = openSession();

			IoTValidation[] array = new IoTValidationImpl[3];

			array[0] = getBySubscriptionId_PrevAndNext(
				session, ioTValidation, subscriptionId, orderByComparator,
				true);

			array[1] = ioTValidation;

			array[2] = getBySubscriptionId_PrevAndNext(
				session, ioTValidation, subscriptionId, orderByComparator,
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

	protected IoTValidation getBySubscriptionId_PrevAndNext(
		Session session, IoTValidation ioTValidation, long subscriptionId,
		OrderByComparator<IoTValidation> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_IOTVALIDATION_WHERE);

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
			sb.append(IoTValidationModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subscriptionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ioTValidation)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<IoTValidation> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the io t validations where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeBySubscriptionId(long subscriptionId) {
		for (IoTValidation ioTValidation :
				findBySubscriptionId(
					subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ioTValidation);
		}
	}

	/**
	 * Returns the number of io t validations where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching io t validations
	 */
	@Override
	public int countBySubscriptionId(long subscriptionId) {
		FinderPath finderPath = _finderPathCountBySubscriptionId;

		Object[] finderArgs = new Object[] {subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_IOTVALIDATION_WHERE);

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
		"ioTValidation.subscriptionId = ?";

	public IoTValidationPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(IoTValidation.class);

		setModelImplClass(IoTValidationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the io t validation in the entity cache if it is enabled.
	 *
	 * @param ioTValidation the io t validation
	 */
	@Override
	public void cacheResult(IoTValidation ioTValidation) {
		entityCache.putResult(
			IoTValidationImpl.class, ioTValidation.getPrimaryKey(),
			ioTValidation);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {ioTValidation.getUuid(), ioTValidation.getGroupId()},
			ioTValidation);

		finderCache.putResult(
			_finderPathFetchByOriginalId,
			new Object[] {ioTValidation.getOriginalId()}, ioTValidation);

		finderCache.putResult(
			_finderPathFetchByOID_S,
			new Object[] {
				ioTValidation.getOriginalId(), ioTValidation.getSubscriptionId()
			},
			ioTValidation);
	}

	/**
	 * Caches the io t validations in the entity cache if it is enabled.
	 *
	 * @param ioTValidations the io t validations
	 */
	@Override
	public void cacheResult(List<IoTValidation> ioTValidations) {
		for (IoTValidation ioTValidation : ioTValidations) {
			if (entityCache.getResult(
					IoTValidationImpl.class, ioTValidation.getPrimaryKey()) ==
						null) {

				cacheResult(ioTValidation);
			}
		}
	}

	/**
	 * Clears the cache for all io t validations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IoTValidationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the io t validation.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(IoTValidation ioTValidation) {
		entityCache.removeResult(IoTValidationImpl.class, ioTValidation);
	}

	@Override
	public void clearCache(List<IoTValidation> ioTValidations) {
		for (IoTValidation ioTValidation : ioTValidations) {
			entityCache.removeResult(IoTValidationImpl.class, ioTValidation);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(IoTValidationImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		IoTValidationModelImpl ioTValidationModelImpl) {

		Object[] args = new Object[] {
			ioTValidationModelImpl.getUuid(),
			ioTValidationModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ioTValidationModelImpl, false);

		args = new Object[] {ioTValidationModelImpl.getOriginalId()};

		finderCache.putResult(
			_finderPathCountByOriginalId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByOriginalId, args, ioTValidationModelImpl, false);

		args = new Object[] {
			ioTValidationModelImpl.getOriginalId(),
			ioTValidationModelImpl.getSubscriptionId()
		};

		finderCache.putResult(
			_finderPathCountByOID_S, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByOID_S, args, ioTValidationModelImpl, false);
	}

	/**
	 * Creates a new io t validation with the primary key. Does not add the io t validation to the database.
	 *
	 * @param iotValidationId the primary key for the new io t validation
	 * @return the new io t validation
	 */
	@Override
	public IoTValidation create(long iotValidationId) {
		IoTValidation ioTValidation = new IoTValidationImpl();

		ioTValidation.setNew(true);
		ioTValidation.setPrimaryKey(iotValidationId);

		String uuid = PortalUUIDUtil.generate();

		ioTValidation.setUuid(uuid);

		ioTValidation.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ioTValidation;
	}

	/**
	 * Removes the io t validation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation that was removed
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation remove(long iotValidationId)
		throws NoSuchIoTValidationException {

		return remove((Serializable)iotValidationId);
	}

	/**
	 * Removes the io t validation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the io t validation
	 * @return the io t validation that was removed
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation remove(Serializable primaryKey)
		throws NoSuchIoTValidationException {

		Session session = null;

		try {
			session = openSession();

			IoTValidation ioTValidation = (IoTValidation)session.get(
				IoTValidationImpl.class, primaryKey);

			if (ioTValidation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIoTValidationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ioTValidation);
		}
		catch (NoSuchIoTValidationException noSuchEntityException) {
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
	protected IoTValidation removeImpl(IoTValidation ioTValidation) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ioTValidation)) {
				ioTValidation = (IoTValidation)session.get(
					IoTValidationImpl.class, ioTValidation.getPrimaryKeyObj());
			}

			if (ioTValidation != null) {
				session.delete(ioTValidation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ioTValidation != null) {
			clearCache(ioTValidation);
		}

		return ioTValidation;
	}

	@Override
	public IoTValidation updateImpl(IoTValidation ioTValidation) {
		boolean isNew = ioTValidation.isNew();

		if (!(ioTValidation instanceof IoTValidationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ioTValidation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ioTValidation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ioTValidation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom IoTValidation implementation " +
					ioTValidation.getClass());
		}

		IoTValidationModelImpl ioTValidationModelImpl =
			(IoTValidationModelImpl)ioTValidation;

		if (Validator.isNull(ioTValidation.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ioTValidation.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ioTValidation.getCreateDate() == null)) {
			if (serviceContext == null) {
				ioTValidation.setCreateDate(now);
			}
			else {
				ioTValidation.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ioTValidationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ioTValidation.setModifiedDate(now);
			}
			else {
				ioTValidation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ioTValidation);
			}
			else {
				ioTValidation = (IoTValidation)session.merge(ioTValidation);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			IoTValidationImpl.class, ioTValidationModelImpl, false, true);

		cacheUniqueFindersCache(ioTValidationModelImpl);

		if (isNew) {
			ioTValidation.setNew(false);
		}

		ioTValidation.resetOriginalValues();

		return ioTValidation;
	}

	/**
	 * Returns the io t validation with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the io t validation
	 * @return the io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIoTValidationException {

		IoTValidation ioTValidation = fetchByPrimaryKey(primaryKey);

		if (ioTValidation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIoTValidationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ioTValidation;
	}

	/**
	 * Returns the io t validation with the primary key or throws a <code>NoSuchIoTValidationException</code> if it could not be found.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation
	 * @throws NoSuchIoTValidationException if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation findByPrimaryKey(long iotValidationId)
		throws NoSuchIoTValidationException {

		return findByPrimaryKey((Serializable)iotValidationId);
	}

	/**
	 * Returns the io t validation with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iotValidationId the primary key of the io t validation
	 * @return the io t validation, or <code>null</code> if a io t validation with the primary key could not be found
	 */
	@Override
	public IoTValidation fetchByPrimaryKey(long iotValidationId) {
		return fetchByPrimaryKey((Serializable)iotValidationId);
	}

	/**
	 * Returns all the io t validations.
	 *
	 * @return the io t validations
	 */
	@Override
	public List<IoTValidation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the io t validations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @return the range of io t validations
	 */
	@Override
	public List<IoTValidation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the io t validations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of io t validations
	 */
	@Override
	public List<IoTValidation> findAll(
		int start, int end,
		OrderByComparator<IoTValidation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the io t validations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>IoTValidationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of io t validations
	 * @param end the upper bound of the range of io t validations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of io t validations
	 */
	@Override
	public List<IoTValidation> findAll(
		int start, int end, OrderByComparator<IoTValidation> orderByComparator,
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

		List<IoTValidation> list = null;

		if (useFinderCache) {
			list = (List<IoTValidation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_IOTVALIDATION);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_IOTVALIDATION;

				sql = sql.concat(IoTValidationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<IoTValidation>)QueryUtil.list(
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
	 * Removes all the io t validations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (IoTValidation ioTValidation : findAll()) {
			remove(ioTValidation);
		}
	}

	/**
	 * Returns the number of io t validations.
	 *
	 * @return the number of io t validations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_IOTVALIDATION);

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
		return "iotValidationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_IOTVALIDATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IoTValidationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the io t validation persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new IoTValidationModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", IoTValidation.class.getName()));

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
		entityCache.removeCache(IoTValidationImpl.class.getName());

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

	private static final String _SQL_SELECT_IOTVALIDATION =
		"SELECT ioTValidation FROM IoTValidation ioTValidation";

	private static final String _SQL_SELECT_IOTVALIDATION_WHERE =
		"SELECT ioTValidation FROM IoTValidation ioTValidation WHERE ";

	private static final String _SQL_COUNT_IOTVALIDATION =
		"SELECT COUNT(ioTValidation) FROM IoTValidation ioTValidation";

	private static final String _SQL_COUNT_IOTVALIDATION_WHERE =
		"SELECT COUNT(ioTValidation) FROM IoTValidation ioTValidation WHERE ";

	private static final String _FILTER_ENTITY_TABLE_FILTER_PK_COLUMN =
		"ioTValidation.iotValidationId";

	private static final String _FILTER_SQL_SELECT_IOTVALIDATION_WHERE =
		"SELECT DISTINCT {ioTValidation.*} FROM IoTCatalogue_IoTValidation ioTValidation WHERE ";

	private static final String
		_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_1 =
			"SELECT {IoTCatalogue_IoTValidation.*} FROM (SELECT DISTINCT ioTValidation.iotValidationId FROM IoTCatalogue_IoTValidation ioTValidation WHERE ";

	private static final String
		_FILTER_SQL_SELECT_IOTVALIDATION_NO_INLINE_DISTINCT_WHERE_2 =
			") TEMP_TABLE INNER JOIN IoTCatalogue_IoTValidation ON TEMP_TABLE.iotValidationId = IoTCatalogue_IoTValidation.iotValidationId";

	private static final String _FILTER_SQL_COUNT_IOTVALIDATION_WHERE =
		"SELECT COUNT(DISTINCT ioTValidation.iotValidationId) AS COUNT_VALUE FROM IoTCatalogue_IoTValidation ioTValidation WHERE ";

	private static final String _FILTER_ENTITY_ALIAS = "ioTValidation";

	private static final String _FILTER_ENTITY_TABLE =
		"IoTCatalogue_IoTValidation";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ioTValidation.";

	private static final String _ORDER_BY_ENTITY_TABLE =
		"IoTCatalogue_IoTValidation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No IoTValidation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No IoTValidation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		IoTValidationPersistenceImpl.class);

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

	private static class IoTValidationModelArgumentsResolver
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

			IoTValidationModelImpl ioTValidationModelImpl =
				(IoTValidationModelImpl)baseModel;

			long columnBitmask = ioTValidationModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(ioTValidationModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						ioTValidationModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(ioTValidationModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			IoTValidationModelImpl ioTValidationModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						ioTValidationModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = ioTValidationModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}