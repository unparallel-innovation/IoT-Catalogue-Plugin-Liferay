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

import com.iot_catalogue.exception.NoSuchElementCoordinateException;
import com.iot_catalogue.model.ElementCoordinate;
import com.iot_catalogue.model.impl.ElementCoordinateImpl;
import com.iot_catalogue.model.impl.ElementCoordinateModelImpl;
import com.iot_catalogue.service.persistence.ElementCoordinatePersistence;
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
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the element coordinate service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElementCoordinatePersistence.class)
public class ElementCoordinatePersistenceImpl
	extends BasePersistenceImpl<ElementCoordinate>
	implements ElementCoordinatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElementCoordinateUtil</code> to access the element coordinate persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElementCoordinateImpl.class.getName();

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
	 * Returns all the element coordinates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element coordinates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element coordinates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element coordinates where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
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

		List<ElementCoordinate> list = null;

		if (useFinderCache) {
			list = (List<ElementCoordinate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementCoordinate elementCoordinate : list) {
					if (!uuid.equals(elementCoordinate.getUuid())) {
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

			sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

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
				sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementCoordinate>)QueryUtil.list(
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
	 * Returns the first element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByUuid_First(
			String uuid, OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByUuid_First(
			uuid, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByUuid_First(
		String uuid, OrderByComparator<ElementCoordinate> orderByComparator) {

		List<ElementCoordinate> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByUuid_Last(
			String uuid, OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByUuid_Last(
			uuid, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByUuid_Last(
		String uuid, OrderByComparator<ElementCoordinate> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ElementCoordinate> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where uuid = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate[] findByUuid_PrevAndNext(
			long elementCoordinateId, String uuid,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		uuid = Objects.toString(uuid, "");

		ElementCoordinate elementCoordinate = findByPrimaryKey(
			elementCoordinateId);

		Session session = null;

		try {
			session = openSession();

			ElementCoordinate[] array = new ElementCoordinateImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, elementCoordinate, uuid, orderByComparator, true);

			array[1] = elementCoordinate;

			array[2] = getByUuid_PrevAndNext(
				session, elementCoordinate, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementCoordinate getByUuid_PrevAndNext(
		Session session, ElementCoordinate elementCoordinate, String uuid,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

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
			sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
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
						elementCoordinate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementCoordinate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element coordinates where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ElementCoordinate elementCoordinate :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementCoordinate);
		}
	}

	/**
	 * Returns the number of element coordinates where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element coordinates
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTCOORDINATE_WHERE);

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
		"elementCoordinate.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(elementCoordinate.uuid IS NULL OR elementCoordinate.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementCoordinateException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByUUID_G(String uuid, long groupId)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByUUID_G(uuid, groupId);

		if (elementCoordinate == null) {
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

			throw new NoSuchElementCoordinateException(sb.toString());
		}

		return elementCoordinate;
	}

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the element coordinate where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByUUID_G(
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

		if (result instanceof ElementCoordinate) {
			ElementCoordinate elementCoordinate = (ElementCoordinate)result;

			if (!Objects.equals(uuid, elementCoordinate.getUuid()) ||
				(groupId != elementCoordinate.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

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

				List<ElementCoordinate> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ElementCoordinate elementCoordinate = list.get(0);

					result = elementCoordinate;

					cacheResult(elementCoordinate);
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
			return (ElementCoordinate)result;
		}
	}

	/**
	 * Removes the element coordinate where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element coordinate that was removed
	 */
	@Override
	public ElementCoordinate removeByUUID_G(String uuid, long groupId)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = findByUUID_G(uuid, groupId);

		return remove(elementCoordinate);
	}

	/**
	 * Returns the number of element coordinates where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element coordinates
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELEMENTCOORDINATE_WHERE);

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
		"elementCoordinate.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(elementCoordinate.uuid IS NULL OR elementCoordinate.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"elementCoordinate.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
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

		List<ElementCoordinate> list = null;

		if (useFinderCache) {
			list = (List<ElementCoordinate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementCoordinate elementCoordinate : list) {
					if (!uuid.equals(elementCoordinate.getUuid()) ||
						(companyId != elementCoordinate.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

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
				sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementCoordinate>)QueryUtil.list(
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
	 * Returns the first element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the first element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		List<ElementCoordinate> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the last element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ElementCoordinate> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate[] findByUuid_C_PrevAndNext(
			long elementCoordinateId, String uuid, long companyId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		uuid = Objects.toString(uuid, "");

		ElementCoordinate elementCoordinate = findByPrimaryKey(
			elementCoordinateId);

		Session session = null;

		try {
			session = openSession();

			ElementCoordinate[] array = new ElementCoordinateImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, elementCoordinate, uuid, companyId, orderByComparator,
				true);

			array[1] = elementCoordinate;

			array[2] = getByUuid_C_PrevAndNext(
				session, elementCoordinate, uuid, companyId, orderByComparator,
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

	protected ElementCoordinate getByUuid_C_PrevAndNext(
		Session session, ElementCoordinate elementCoordinate, String uuid,
		long companyId, OrderByComparator<ElementCoordinate> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

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
			sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
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
						elementCoordinate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementCoordinate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element coordinates where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ElementCoordinate elementCoordinate :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(elementCoordinate);
		}
	}

	/**
	 * Returns the number of element coordinates where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element coordinates
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELEMENTCOORDINATE_WHERE);

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
		"elementCoordinate.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(elementCoordinate.uuid IS NULL OR elementCoordinate.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"elementCoordinate.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the element coordinates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element coordinates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element coordinates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element coordinates where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
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

		List<ElementCoordinate> list = null;

		if (useFinderCache) {
			list = (List<ElementCoordinate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementCoordinate elementCoordinate : list) {
					if (groupId != elementCoordinate.getGroupId()) {
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

			sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ElementCoordinate>)QueryUtil.list(
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
	 * Returns the first element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByGroupId_First(
			long groupId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByGroupId_First(
			groupId, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the first element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByGroupId_First(
		long groupId, OrderByComparator<ElementCoordinate> orderByComparator) {

		List<ElementCoordinate> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByGroupId_Last(
			long groupId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the last element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByGroupId_Last(
		long groupId, OrderByComparator<ElementCoordinate> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ElementCoordinate> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where groupId = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate[] findByGroupId_PrevAndNext(
			long elementCoordinateId, long groupId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = findByPrimaryKey(
			elementCoordinateId);

		Session session = null;

		try {
			session = openSession();

			ElementCoordinate[] array = new ElementCoordinateImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, elementCoordinate, groupId, orderByComparator, true);

			array[1] = elementCoordinate;

			array[2] = getByGroupId_PrevAndNext(
				session, elementCoordinate, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementCoordinate getByGroupId_PrevAndNext(
		Session session, ElementCoordinate elementCoordinate, long groupId,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

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
			sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
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
						elementCoordinate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementCoordinate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element coordinates where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ElementCoordinate elementCoordinate :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementCoordinate);
		}
	}

	/**
	 * Returns the number of element coordinates where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element coordinates
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTCOORDINATE_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"elementCoordinate.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the element coordinates where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element coordinates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByStatus(
		int status, int start, int end) {

		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element coordinates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element coordinates where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
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

		List<ElementCoordinate> list = null;

		if (useFinderCache) {
			list = (List<ElementCoordinate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementCoordinate elementCoordinate : list) {
					if (status != elementCoordinate.getStatus()) {
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

			sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<ElementCoordinate>)QueryUtil.list(
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
	 * Returns the first element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByStatus_First(
			int status, OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByStatus_First(
			status, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the first element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByStatus_First(
		int status, OrderByComparator<ElementCoordinate> orderByComparator) {

		List<ElementCoordinate> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByStatus_Last(
			int status, OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByStatus_Last(
			status, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the last element coordinate in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByStatus_Last(
		int status, OrderByComparator<ElementCoordinate> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ElementCoordinate> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where status = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate[] findByStatus_PrevAndNext(
			long elementCoordinateId, int status,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = findByPrimaryKey(
			elementCoordinateId);

		Session session = null;

		try {
			session = openSession();

			ElementCoordinate[] array = new ElementCoordinateImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, elementCoordinate, status, orderByComparator, true);

			array[1] = elementCoordinate;

			array[2] = getByStatus_PrevAndNext(
				session, elementCoordinate, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementCoordinate getByStatus_PrevAndNext(
		Session session, ElementCoordinate elementCoordinate, int status,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

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
			sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
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
						elementCoordinate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementCoordinate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element coordinates where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (ElementCoordinate elementCoordinate :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementCoordinate);
		}
	}

	/**
	 * Returns the number of element coordinates where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element coordinates
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTCOORDINATE_WHERE);

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
		"elementCoordinate.status = ?";

	private FinderPath _finderPathWithPaginationFindByS_E;
	private FinderPath _finderPathWithoutPaginationFindByS_E;
	private FinderPath _finderPathCountByS_E;

	/**
	 * Returns all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_E;
				finderArgs = new Object[] {
					subscriptionId, elementOriginalId, elementClassName
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_E;
			finderArgs = new Object[] {
				subscriptionId, elementOriginalId, elementClassName, start, end,
				orderByComparator
			};
		}

		List<ElementCoordinate> list = null;

		if (useFinderCache) {
			list = (List<ElementCoordinate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementCoordinate elementCoordinate : list) {
					if ((subscriptionId !=
							elementCoordinate.getSubscriptionId()) ||
						!elementOriginalId.equals(
							elementCoordinate.getElementOriginalId()) ||
						!elementClassName.equals(
							elementCoordinate.getElementClassName())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

			sb.append(_FINDER_COLUMN_S_E_SUBSCRIPTIONID_2);

			boolean bindElementOriginalId = false;

			if (elementOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_ELEMENTORIGINALID_3);
			}
			else {
				bindElementOriginalId = true;

				sb.append(_FINDER_COLUMN_S_E_ELEMENTORIGINALID_2);
			}

			boolean bindElementClassName = false;

			if (elementClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_ELEMENTCLASSNAME_3);
			}
			else {
				bindElementClassName = true;

				sb.append(_FINDER_COLUMN_S_E_ELEMENTCLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				if (bindElementOriginalId) {
					queryPos.add(elementOriginalId);
				}

				if (bindElementClassName) {
					queryPos.add(elementClassName);
				}

				list = (List<ElementCoordinate>)QueryUtil.list(
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
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append(", elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		List<ElementCoordinate> list = findByS_E(
			subscriptionId, elementOriginalId, elementClassName, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append(", elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		int count = countByS_E(
			subscriptionId, elementOriginalId, elementClassName);

		if (count == 0) {
			return null;
		}

		List<ElementCoordinate> list = findByS_E(
			subscriptionId, elementOriginalId, elementClassName, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate[] findByS_E_PrevAndNext(
			long elementCoordinateId, long subscriptionId,
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		ElementCoordinate elementCoordinate = findByPrimaryKey(
			elementCoordinateId);

		Session session = null;

		try {
			session = openSession();

			ElementCoordinate[] array = new ElementCoordinateImpl[3];

			array[0] = getByS_E_PrevAndNext(
				session, elementCoordinate, subscriptionId, elementOriginalId,
				elementClassName, orderByComparator, true);

			array[1] = elementCoordinate;

			array[2] = getByS_E_PrevAndNext(
				session, elementCoordinate, subscriptionId, elementOriginalId,
				elementClassName, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementCoordinate getByS_E_PrevAndNext(
		Session session, ElementCoordinate elementCoordinate,
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

		sb.append(_FINDER_COLUMN_S_E_SUBSCRIPTIONID_2);

		boolean bindElementOriginalId = false;

		if (elementOriginalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_S_E_ELEMENTORIGINALID_3);
		}
		else {
			bindElementOriginalId = true;

			sb.append(_FINDER_COLUMN_S_E_ELEMENTORIGINALID_2);
		}

		boolean bindElementClassName = false;

		if (elementClassName.isEmpty()) {
			sb.append(_FINDER_COLUMN_S_E_ELEMENTCLASSNAME_3);
		}
		else {
			bindElementClassName = true;

			sb.append(_FINDER_COLUMN_S_E_ELEMENTCLASSNAME_2);
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
			sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(subscriptionId);

		if (bindElementOriginalId) {
			queryPos.add(elementOriginalId);
		}

		if (bindElementClassName) {
			queryPos.add(elementClassName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						elementCoordinate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementCoordinate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	@Override
	public void removeByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		for (ElementCoordinate elementCoordinate :
				findByS_E(
					subscriptionId, elementOriginalId, elementClassName,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementCoordinate);
		}
	}

	/**
	 * Returns the number of element coordinates where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element coordinates
	 */
	@Override
	public int countByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		FinderPath finderPath = _finderPathCountByS_E;

		Object[] finderArgs = new Object[] {
			subscriptionId, elementOriginalId, elementClassName
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ELEMENTCOORDINATE_WHERE);

			sb.append(_FINDER_COLUMN_S_E_SUBSCRIPTIONID_2);

			boolean bindElementOriginalId = false;

			if (elementOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_ELEMENTORIGINALID_3);
			}
			else {
				bindElementOriginalId = true;

				sb.append(_FINDER_COLUMN_S_E_ELEMENTORIGINALID_2);
			}

			boolean bindElementClassName = false;

			if (elementClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_ELEMENTCLASSNAME_3);
			}
			else {
				bindElementClassName = true;

				sb.append(_FINDER_COLUMN_S_E_ELEMENTCLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				if (bindElementOriginalId) {
					queryPos.add(elementOriginalId);
				}

				if (bindElementClassName) {
					queryPos.add(elementClassName);
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

	private static final String _FINDER_COLUMN_S_E_SUBSCRIPTIONID_2 =
		"elementCoordinate.subscriptionId = ? AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTORIGINALID_2 =
		"elementCoordinate.elementOriginalId = ? AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTORIGINALID_3 =
		"(elementCoordinate.elementOriginalId IS NULL OR elementCoordinate.elementOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTCLASSNAME_2 =
		"elementCoordinate.elementClassName = ?";

	private static final String _FINDER_COLUMN_S_E_ELEMENTCLASSNAME_3 =
		"(elementCoordinate.elementClassName IS NULL OR elementCoordinate.elementClassName = '')";

	private FinderPath _finderPathWithPaginationFindByElement;
	private FinderPath _finderPathWithoutPaginationFindByElement;
	private FinderPath _finderPathCountByElement;

	/**
	 * Returns all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName) {

		return findByElement(
			elementOriginalId, elementClassName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end) {

		return findByElement(
			elementOriginalId, elementClassName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean useFinderCache) {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByElement;
				finderArgs = new Object[] {elementOriginalId, elementClassName};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByElement;
			finderArgs = new Object[] {
				elementOriginalId, elementClassName, start, end,
				orderByComparator
			};
		}

		List<ElementCoordinate> list = null;

		if (useFinderCache) {
			list = (List<ElementCoordinate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementCoordinate elementCoordinate : list) {
					if (!elementOriginalId.equals(
							elementCoordinate.getElementOriginalId()) ||
						!elementClassName.equals(
							elementCoordinate.getElementClassName())) {

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

			sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

			boolean bindElementOriginalId = false;

			if (elementOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_3);
			}
			else {
				bindElementOriginalId = true;

				sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_2);
			}

			boolean bindElementClassName = false;

			if (elementClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_3);
			}
			else {
				bindElementClassName = true;

				sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindElementOriginalId) {
					queryPos.add(elementOriginalId);
				}

				if (bindElementClassName) {
					queryPos.add(elementClassName);
				}

				list = (List<ElementCoordinate>)QueryUtil.list(
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
	 * Returns the first element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByElement_First(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByElement_First(
			elementOriginalId, elementClassName, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the first element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByElement_First(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		List<ElementCoordinate> list = findByElement(
			elementOriginalId, elementClassName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findByElement_Last(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the last element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		int count = countByElement(elementOriginalId, elementClassName);

		if (count == 0) {
			return null;
		}

		List<ElementCoordinate> list = findByElement(
			elementOriginalId, elementClassName, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate[] findByElement_PrevAndNext(
			long elementCoordinateId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		ElementCoordinate elementCoordinate = findByPrimaryKey(
			elementCoordinateId);

		Session session = null;

		try {
			session = openSession();

			ElementCoordinate[] array = new ElementCoordinateImpl[3];

			array[0] = getByElement_PrevAndNext(
				session, elementCoordinate, elementOriginalId, elementClassName,
				orderByComparator, true);

			array[1] = elementCoordinate;

			array[2] = getByElement_PrevAndNext(
				session, elementCoordinate, elementOriginalId, elementClassName,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementCoordinate getByElement_PrevAndNext(
		Session session, ElementCoordinate elementCoordinate,
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementCoordinate> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

		boolean bindElementOriginalId = false;

		if (elementOriginalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_3);
		}
		else {
			bindElementOriginalId = true;

			sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_2);
		}

		boolean bindElementClassName = false;

		if (elementClassName.isEmpty()) {
			sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_3);
		}
		else {
			bindElementClassName = true;

			sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_2);
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
			sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindElementOriginalId) {
			queryPos.add(elementOriginalId);
		}

		if (bindElementClassName) {
			queryPos.add(elementClassName);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						elementCoordinate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementCoordinate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element coordinates where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	@Override
	public void removeByElement(
		String elementOriginalId, String elementClassName) {

		for (ElementCoordinate elementCoordinate :
				findByElement(
					elementOriginalId, elementClassName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(elementCoordinate);
		}
	}

	/**
	 * Returns the number of element coordinates where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element coordinates
	 */
	@Override
	public int countByElement(
		String elementOriginalId, String elementClassName) {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		FinderPath finderPath = _finderPathCountByElement;

		Object[] finderArgs = new Object[] {
			elementOriginalId, elementClassName
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELEMENTCOORDINATE_WHERE);

			boolean bindElementOriginalId = false;

			if (elementOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_3);
			}
			else {
				bindElementOriginalId = true;

				sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_2);
			}

			boolean bindElementClassName = false;

			if (elementClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_3);
			}
			else {
				bindElementClassName = true;

				sb.append(_FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindElementOriginalId) {
					queryPos.add(elementOriginalId);
				}

				if (bindElementClassName) {
					queryPos.add(elementClassName);
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

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_2 =
		"elementCoordinate.elementOriginalId = ? AND ";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_3 =
		"(elementCoordinate.elementOriginalId IS NULL OR elementCoordinate.elementOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_2 =
		"elementCoordinate.elementClassName = ?";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_3 =
		"(elementCoordinate.elementClassName IS NULL OR elementCoordinate.elementClassName = '')";

	private FinderPath _finderPathWithPaginationFindBySubscriptionId;
	private FinderPath _finderPathWithoutPaginationFindBySubscriptionId;
	private FinderPath _finderPathCountBySubscriptionId;

	/**
	 * Returns all the element coordinates where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findBySubscriptionId(long subscriptionId) {
		return findBySubscriptionId(
			subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element coordinates where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return findBySubscriptionId(subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element coordinates where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element coordinates where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element coordinates
	 */
	@Override
	public List<ElementCoordinate> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
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

		List<ElementCoordinate> list = null;

		if (useFinderCache) {
			list = (List<ElementCoordinate>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementCoordinate elementCoordinate : list) {
					if (subscriptionId !=
							elementCoordinate.getSubscriptionId()) {

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

			sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

			sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				list = (List<ElementCoordinate>)QueryUtil.list(
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
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the first element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		List<ElementCoordinate> list = findBySubscriptionId(
			subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate
	 * @throws NoSuchElementCoordinateException if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);

		if (elementCoordinate != null) {
			return elementCoordinate;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchElementCoordinateException(sb.toString());
	}

	/**
	 * Returns the last element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element coordinate, or <code>null</code> if a matching element coordinate could not be found
	 */
	@Override
	public ElementCoordinate fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		int count = countBySubscriptionId(subscriptionId);

		if (count == 0) {
			return null;
		}

		List<ElementCoordinate> list = findBySubscriptionId(
			subscriptionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element coordinates before and after the current element coordinate in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementCoordinateId the primary key of the current element coordinate
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate[] findBySubscriptionId_PrevAndNext(
			long elementCoordinateId, long subscriptionId,
			OrderByComparator<ElementCoordinate> orderByComparator)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = findByPrimaryKey(
			elementCoordinateId);

		Session session = null;

		try {
			session = openSession();

			ElementCoordinate[] array = new ElementCoordinateImpl[3];

			array[0] = getBySubscriptionId_PrevAndNext(
				session, elementCoordinate, subscriptionId, orderByComparator,
				true);

			array[1] = elementCoordinate;

			array[2] = getBySubscriptionId_PrevAndNext(
				session, elementCoordinate, subscriptionId, orderByComparator,
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

	protected ElementCoordinate getBySubscriptionId_PrevAndNext(
		Session session, ElementCoordinate elementCoordinate,
		long subscriptionId,
		OrderByComparator<ElementCoordinate> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELEMENTCOORDINATE_WHERE);

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
			sb.append(ElementCoordinateModelImpl.ORDER_BY_JPQL);
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
						elementCoordinate)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementCoordinate> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element coordinates where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeBySubscriptionId(long subscriptionId) {
		for (ElementCoordinate elementCoordinate :
				findBySubscriptionId(
					subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(elementCoordinate);
		}
	}

	/**
	 * Returns the number of element coordinates where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element coordinates
	 */
	@Override
	public int countBySubscriptionId(long subscriptionId) {
		FinderPath finderPath = _finderPathCountBySubscriptionId;

		Object[] finderArgs = new Object[] {subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTCOORDINATE_WHERE);

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
		"elementCoordinate.subscriptionId = ?";

	public ElementCoordinatePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ElementCoordinate.class);

		setModelImplClass(ElementCoordinateImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the element coordinate in the entity cache if it is enabled.
	 *
	 * @param elementCoordinate the element coordinate
	 */
	@Override
	public void cacheResult(ElementCoordinate elementCoordinate) {
		entityCache.putResult(
			ElementCoordinateImpl.class, elementCoordinate.getPrimaryKey(),
			elementCoordinate);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				elementCoordinate.getUuid(), elementCoordinate.getGroupId()
			},
			elementCoordinate);
	}

	/**
	 * Caches the element coordinates in the entity cache if it is enabled.
	 *
	 * @param elementCoordinates the element coordinates
	 */
	@Override
	public void cacheResult(List<ElementCoordinate> elementCoordinates) {
		for (ElementCoordinate elementCoordinate : elementCoordinates) {
			if (entityCache.getResult(
					ElementCoordinateImpl.class,
					elementCoordinate.getPrimaryKey()) == null) {

				cacheResult(elementCoordinate);
			}
		}
	}

	/**
	 * Clears the cache for all element coordinates.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElementCoordinateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the element coordinate.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ElementCoordinate elementCoordinate) {
		entityCache.removeResult(
			ElementCoordinateImpl.class, elementCoordinate);
	}

	@Override
	public void clearCache(List<ElementCoordinate> elementCoordinates) {
		for (ElementCoordinate elementCoordinate : elementCoordinates) {
			entityCache.removeResult(
				ElementCoordinateImpl.class, elementCoordinate);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElementCoordinateImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ElementCoordinateModelImpl elementCoordinateModelImpl) {

		Object[] args = new Object[] {
			elementCoordinateModelImpl.getUuid(),
			elementCoordinateModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, elementCoordinateModelImpl, false);
	}

	/**
	 * Creates a new element coordinate with the primary key. Does not add the element coordinate to the database.
	 *
	 * @param elementCoordinateId the primary key for the new element coordinate
	 * @return the new element coordinate
	 */
	@Override
	public ElementCoordinate create(long elementCoordinateId) {
		ElementCoordinate elementCoordinate = new ElementCoordinateImpl();

		elementCoordinate.setNew(true);
		elementCoordinate.setPrimaryKey(elementCoordinateId);

		String uuid = PortalUUIDUtil.generate();

		elementCoordinate.setUuid(uuid);

		elementCoordinate.setCompanyId(CompanyThreadLocal.getCompanyId());

		return elementCoordinate;
	}

	/**
	 * Removes the element coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate that was removed
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate remove(long elementCoordinateId)
		throws NoSuchElementCoordinateException {

		return remove((Serializable)elementCoordinateId);
	}

	/**
	 * Removes the element coordinate with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the element coordinate
	 * @return the element coordinate that was removed
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate remove(Serializable primaryKey)
		throws NoSuchElementCoordinateException {

		Session session = null;

		try {
			session = openSession();

			ElementCoordinate elementCoordinate =
				(ElementCoordinate)session.get(
					ElementCoordinateImpl.class, primaryKey);

			if (elementCoordinate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElementCoordinateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(elementCoordinate);
		}
		catch (NoSuchElementCoordinateException noSuchEntityException) {
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
	protected ElementCoordinate removeImpl(
		ElementCoordinate elementCoordinate) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(elementCoordinate)) {
				elementCoordinate = (ElementCoordinate)session.get(
					ElementCoordinateImpl.class,
					elementCoordinate.getPrimaryKeyObj());
			}

			if (elementCoordinate != null) {
				session.delete(elementCoordinate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (elementCoordinate != null) {
			clearCache(elementCoordinate);
		}

		return elementCoordinate;
	}

	@Override
	public ElementCoordinate updateImpl(ElementCoordinate elementCoordinate) {
		boolean isNew = elementCoordinate.isNew();

		if (!(elementCoordinate instanceof ElementCoordinateModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(elementCoordinate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					elementCoordinate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in elementCoordinate proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ElementCoordinate implementation " +
					elementCoordinate.getClass());
		}

		ElementCoordinateModelImpl elementCoordinateModelImpl =
			(ElementCoordinateModelImpl)elementCoordinate;

		if (Validator.isNull(elementCoordinate.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			elementCoordinate.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (elementCoordinate.getCreateDate() == null)) {
			if (serviceContext == null) {
				elementCoordinate.setCreateDate(now);
			}
			else {
				elementCoordinate.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!elementCoordinateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				elementCoordinate.setModifiedDate(now);
			}
			else {
				elementCoordinate.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(elementCoordinate);
			}
			else {
				elementCoordinate = (ElementCoordinate)session.merge(
					elementCoordinate);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ElementCoordinateImpl.class, elementCoordinateModelImpl, false,
			true);

		cacheUniqueFindersCache(elementCoordinateModelImpl);

		if (isNew) {
			elementCoordinate.setNew(false);
		}

		elementCoordinate.resetOriginalValues();

		return elementCoordinate;
	}

	/**
	 * Returns the element coordinate with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the element coordinate
	 * @return the element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElementCoordinateException {

		ElementCoordinate elementCoordinate = fetchByPrimaryKey(primaryKey);

		if (elementCoordinate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElementCoordinateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return elementCoordinate;
	}

	/**
	 * Returns the element coordinate with the primary key or throws a <code>NoSuchElementCoordinateException</code> if it could not be found.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate
	 * @throws NoSuchElementCoordinateException if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate findByPrimaryKey(long elementCoordinateId)
		throws NoSuchElementCoordinateException {

		return findByPrimaryKey((Serializable)elementCoordinateId);
	}

	/**
	 * Returns the element coordinate with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementCoordinateId the primary key of the element coordinate
	 * @return the element coordinate, or <code>null</code> if a element coordinate with the primary key could not be found
	 */
	@Override
	public ElementCoordinate fetchByPrimaryKey(long elementCoordinateId) {
		return fetchByPrimaryKey((Serializable)elementCoordinateId);
	}

	/**
	 * Returns all the element coordinates.
	 *
	 * @return the element coordinates
	 */
	@Override
	public List<ElementCoordinate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @return the range of element coordinates
	 */
	@Override
	public List<ElementCoordinate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the element coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of element coordinates
	 */
	@Override
	public List<ElementCoordinate> findAll(
		int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element coordinates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementCoordinateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element coordinates
	 * @param end the upper bound of the range of element coordinates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of element coordinates
	 */
	@Override
	public List<ElementCoordinate> findAll(
		int start, int end,
		OrderByComparator<ElementCoordinate> orderByComparator,
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

		List<ElementCoordinate> list = null;

		if (useFinderCache) {
			list = (List<ElementCoordinate>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELEMENTCOORDINATE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELEMENTCOORDINATE;

				sql = sql.concat(ElementCoordinateModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ElementCoordinate>)QueryUtil.list(
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
	 * Removes all the element coordinates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ElementCoordinate elementCoordinate : findAll()) {
			remove(elementCoordinate);
		}
	}

	/**
	 * Returns the number of element coordinates.
	 *
	 * @return the number of element coordinates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELEMENTCOORDINATE);

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
		return "elementCoordinateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELEMENTCOORDINATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElementCoordinateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the element coordinate persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ElementCoordinateModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ElementCoordinate.class.getName()));

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

		_finderPathWithPaginationFindByS_E = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {
				"subscriptionId", "elementOriginalId", "elementClassName"
			},
			true);

		_finderPathWithoutPaginationFindByS_E = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {
				"subscriptionId", "elementOriginalId", "elementClassName"
			},
			true);

		_finderPathCountByS_E = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_E",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {
				"subscriptionId", "elementOriginalId", "elementClassName"
			},
			false);

		_finderPathWithPaginationFindByElement = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByElement",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"elementOriginalId", "elementClassName"}, true);

		_finderPathWithoutPaginationFindByElement = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByElement",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"elementOriginalId", "elementClassName"}, true);

		_finderPathCountByElement = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByElement",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"elementOriginalId", "elementClassName"}, false);

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
		entityCache.removeCache(ElementCoordinateImpl.class.getName());

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

	private static final String _SQL_SELECT_ELEMENTCOORDINATE =
		"SELECT elementCoordinate FROM ElementCoordinate elementCoordinate";

	private static final String _SQL_SELECT_ELEMENTCOORDINATE_WHERE =
		"SELECT elementCoordinate FROM ElementCoordinate elementCoordinate WHERE ";

	private static final String _SQL_COUNT_ELEMENTCOORDINATE =
		"SELECT COUNT(elementCoordinate) FROM ElementCoordinate elementCoordinate";

	private static final String _SQL_COUNT_ELEMENTCOORDINATE_WHERE =
		"SELECT COUNT(elementCoordinate) FROM ElementCoordinate elementCoordinate WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "elementCoordinate.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ElementCoordinate exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ElementCoordinate exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ElementCoordinatePersistenceImpl.class);

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

	private static class ElementCoordinateModelArgumentsResolver
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

			ElementCoordinateModelImpl elementCoordinateModelImpl =
				(ElementCoordinateModelImpl)baseModel;

			long columnBitmask = elementCoordinateModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					elementCoordinateModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						elementCoordinateModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					elementCoordinateModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ElementCoordinateModelImpl elementCoordinateModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						elementCoordinateModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = elementCoordinateModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}