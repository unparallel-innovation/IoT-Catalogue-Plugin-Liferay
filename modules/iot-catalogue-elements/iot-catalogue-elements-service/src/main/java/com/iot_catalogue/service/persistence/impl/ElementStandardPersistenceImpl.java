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

import com.iot_catalogue.exception.NoSuchElementStandardException;
import com.iot_catalogue.model.ElementStandard;
import com.iot_catalogue.model.impl.ElementStandardImpl;
import com.iot_catalogue.model.impl.ElementStandardModelImpl;
import com.iot_catalogue.service.persistence.ElementStandardPersistence;
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
 * The persistence implementation for the element standard service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElementStandardPersistence.class)
public class ElementStandardPersistenceImpl
	extends BasePersistenceImpl<ElementStandard>
	implements ElementStandardPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElementStandardUtil</code> to access the element standard persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElementStandardImpl.class.getName();

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
	 * Returns all the element standards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element standards
	 */
	@Override
	public List<ElementStandard> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element standards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element standards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element standards where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
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

		List<ElementStandard> list = null;

		if (useFinderCache) {
			list = (List<ElementStandard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementStandard elementStandard : list) {
					if (!uuid.equals(elementStandard.getUuid())) {
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

			sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
				sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementStandard>)QueryUtil.list(
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
	 * Returns the first element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByUuid_First(
			String uuid, OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByUuid_First(
			uuid, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByUuid_First(
		String uuid, OrderByComparator<ElementStandard> orderByComparator) {

		List<ElementStandard> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByUuid_Last(
			String uuid, OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByUuid_Last(
			uuid, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByUuid_Last(
		String uuid, OrderByComparator<ElementStandard> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ElementStandard> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where uuid = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard[] findByUuid_PrevAndNext(
			long elementStandardId, String uuid,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		uuid = Objects.toString(uuid, "");

		ElementStandard elementStandard = findByPrimaryKey(elementStandardId);

		Session session = null;

		try {
			session = openSession();

			ElementStandard[] array = new ElementStandardImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, elementStandard, uuid, orderByComparator, true);

			array[1] = elementStandard;

			array[2] = getByUuid_PrevAndNext(
				session, elementStandard, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementStandard getByUuid_PrevAndNext(
		Session session, ElementStandard elementStandard, String uuid,
		OrderByComparator<ElementStandard> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
			sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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
						elementStandard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementStandard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element standards where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ElementStandard elementStandard :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementStandard);
		}
	}

	/**
	 * Returns the number of element standards where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element standards
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTSTANDARD_WHERE);

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
		"elementStandard.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(elementStandard.uuid IS NULL OR elementStandard.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementStandardException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByUUID_G(String uuid, long groupId)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByUUID_G(uuid, groupId);

		if (elementStandard == null) {
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

			throw new NoSuchElementStandardException(sb.toString());
		}

		return elementStandard;
	}

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the element standard where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByUUID_G(
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

		if (result instanceof ElementStandard) {
			ElementStandard elementStandard = (ElementStandard)result;

			if (!Objects.equals(uuid, elementStandard.getUuid()) ||
				(groupId != elementStandard.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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

				List<ElementStandard> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ElementStandard elementStandard = list.get(0);

					result = elementStandard;

					cacheResult(elementStandard);
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
			return (ElementStandard)result;
		}
	}

	/**
	 * Removes the element standard where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element standard that was removed
	 */
	@Override
	public ElementStandard removeByUUID_G(String uuid, long groupId)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = findByUUID_G(uuid, groupId);

		return remove(elementStandard);
	}

	/**
	 * Returns the number of element standards where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element standards
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELEMENTSTANDARD_WHERE);

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
		"elementStandard.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(elementStandard.uuid IS NULL OR elementStandard.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"elementStandard.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element standards
	 */
	@Override
	public List<ElementStandard> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
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

		List<ElementStandard> list = null;

		if (useFinderCache) {
			list = (List<ElementStandard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementStandard elementStandard : list) {
					if (!uuid.equals(elementStandard.getUuid()) ||
						(companyId != elementStandard.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
				sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementStandard>)QueryUtil.list(
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
	 * Returns the first element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the first element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ElementStandard> orderByComparator) {

		List<ElementStandard> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the last element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ElementStandard> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ElementStandard> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard[] findByUuid_C_PrevAndNext(
			long elementStandardId, String uuid, long companyId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		uuid = Objects.toString(uuid, "");

		ElementStandard elementStandard = findByPrimaryKey(elementStandardId);

		Session session = null;

		try {
			session = openSession();

			ElementStandard[] array = new ElementStandardImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, elementStandard, uuid, companyId, orderByComparator,
				true);

			array[1] = elementStandard;

			array[2] = getByUuid_C_PrevAndNext(
				session, elementStandard, uuid, companyId, orderByComparator,
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

	protected ElementStandard getByUuid_C_PrevAndNext(
		Session session, ElementStandard elementStandard, String uuid,
		long companyId, OrderByComparator<ElementStandard> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
			sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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
						elementStandard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementStandard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element standards where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ElementStandard elementStandard :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(elementStandard);
		}
	}

	/**
	 * Returns the number of element standards where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element standards
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELEMENTSTANDARD_WHERE);

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
		"elementStandard.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(elementStandard.uuid IS NULL OR elementStandard.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"elementStandard.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the element standards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element standards
	 */
	@Override
	public List<ElementStandard> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element standards where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element standards where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element standards where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
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

		List<ElementStandard> list = null;

		if (useFinderCache) {
			list = (List<ElementStandard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementStandard elementStandard : list) {
					if (groupId != elementStandard.getGroupId()) {
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

			sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ElementStandard>)QueryUtil.list(
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
	 * Returns the first element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByGroupId_First(
			long groupId, OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByGroupId_First(
			groupId, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the first element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByGroupId_First(
		long groupId, OrderByComparator<ElementStandard> orderByComparator) {

		List<ElementStandard> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByGroupId_Last(
			long groupId, OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the last element standard in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByGroupId_Last(
		long groupId, OrderByComparator<ElementStandard> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ElementStandard> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where groupId = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard[] findByGroupId_PrevAndNext(
			long elementStandardId, long groupId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = findByPrimaryKey(elementStandardId);

		Session session = null;

		try {
			session = openSession();

			ElementStandard[] array = new ElementStandardImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, elementStandard, groupId, orderByComparator, true);

			array[1] = elementStandard;

			array[2] = getByGroupId_PrevAndNext(
				session, elementStandard, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementStandard getByGroupId_PrevAndNext(
		Session session, ElementStandard elementStandard, long groupId,
		OrderByComparator<ElementStandard> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
			sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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
						elementStandard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementStandard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element standards where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ElementStandard elementStandard :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementStandard);
		}
	}

	/**
	 * Returns the number of element standards where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element standards
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTSTANDARD_WHERE);

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
		"elementStandard.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the element standards where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element standards
	 */
	@Override
	public List<ElementStandard> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element standards where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element standards where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element standards where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
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

		List<ElementStandard> list = null;

		if (useFinderCache) {
			list = (List<ElementStandard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementStandard elementStandard : list) {
					if (status != elementStandard.getStatus()) {
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

			sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<ElementStandard>)QueryUtil.list(
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
	 * Returns the first element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByStatus_First(
			int status, OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByStatus_First(
			status, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the first element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByStatus_First(
		int status, OrderByComparator<ElementStandard> orderByComparator) {

		List<ElementStandard> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByStatus_Last(
			int status, OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByStatus_Last(
			status, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the last element standard in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByStatus_Last(
		int status, OrderByComparator<ElementStandard> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ElementStandard> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where status = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard[] findByStatus_PrevAndNext(
			long elementStandardId, int status,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = findByPrimaryKey(elementStandardId);

		Session session = null;

		try {
			session = openSession();

			ElementStandard[] array = new ElementStandardImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, elementStandard, status, orderByComparator, true);

			array[1] = elementStandard;

			array[2] = getByStatus_PrevAndNext(
				session, elementStandard, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementStandard getByStatus_PrevAndNext(
		Session session, ElementStandard elementStandard, int status,
		OrderByComparator<ElementStandard> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
			sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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
						elementStandard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementStandard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element standards where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (ElementStandard elementStandard :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementStandard);
		}
	}

	/**
	 * Returns the number of element standards where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element standards
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTSTANDARD_WHERE);

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
		"elementStandard.status = ?";

	private FinderPath _finderPathWithPaginationFindByS_E;
	private FinderPath _finderPathWithoutPaginationFindByS_E;
	private FinderPath _finderPathCountByS_E;

	/**
	 * Returns all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element standards
	 */
	@Override
	public List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
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

		List<ElementStandard> list = null;

		if (useFinderCache) {
			list = (List<ElementStandard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementStandard elementStandard : list) {
					if ((subscriptionId !=
							elementStandard.getSubscriptionId()) ||
						!elementOriginalId.equals(
							elementStandard.getElementOriginalId()) ||
						!elementClassName.equals(
							elementStandard.getElementClassName())) {

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

			sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
				sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementStandard>)QueryUtil.list(
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
	 * Returns the first element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
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

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator) {

		List<ElementStandard> list = findByS_E(
			subscriptionId, elementOriginalId, elementClassName, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
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

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator) {

		int count = countByS_E(
			subscriptionId, elementOriginalId, elementClassName);

		if (count == 0) {
			return null;
		}

		List<ElementStandard> list = findByS_E(
			subscriptionId, elementOriginalId, elementClassName, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard[] findByS_E_PrevAndNext(
			long elementStandardId, long subscriptionId,
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		ElementStandard elementStandard = findByPrimaryKey(elementStandardId);

		Session session = null;

		try {
			session = openSession();

			ElementStandard[] array = new ElementStandardImpl[3];

			array[0] = getByS_E_PrevAndNext(
				session, elementStandard, subscriptionId, elementOriginalId,
				elementClassName, orderByComparator, true);

			array[1] = elementStandard;

			array[2] = getByS_E_PrevAndNext(
				session, elementStandard, subscriptionId, elementOriginalId,
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

	protected ElementStandard getByS_E_PrevAndNext(
		Session session, ElementStandard elementStandard, long subscriptionId,
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
			sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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
						elementStandard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementStandard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	@Override
	public void removeByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		for (ElementStandard elementStandard :
				findByS_E(
					subscriptionId, elementOriginalId, elementClassName,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementStandard);
		}
	}

	/**
	 * Returns the number of element standards where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element standards
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

			sb.append(_SQL_COUNT_ELEMENTSTANDARD_WHERE);

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
		"elementStandard.subscriptionId = ? AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTORIGINALID_2 =
		"elementStandard.elementOriginalId = ? AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTORIGINALID_3 =
		"(elementStandard.elementOriginalId IS NULL OR elementStandard.elementOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTCLASSNAME_2 =
		"elementStandard.elementClassName = ?";

	private static final String _FINDER_COLUMN_S_E_ELEMENTCLASSNAME_3 =
		"(elementStandard.elementClassName IS NULL OR elementStandard.elementClassName = '')";

	private FinderPath _finderPathWithPaginationFindByElement;
	private FinderPath _finderPathWithoutPaginationFindByElement;
	private FinderPath _finderPathCountByElement;

	/**
	 * Returns all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element standards
	 */
	@Override
	public List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName) {

		return findByElement(
			elementOriginalId, elementClassName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end) {

		return findByElement(
			elementOriginalId, elementClassName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
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

		List<ElementStandard> list = null;

		if (useFinderCache) {
			list = (List<ElementStandard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementStandard elementStandard : list) {
					if (!elementOriginalId.equals(
							elementStandard.getElementOriginalId()) ||
						!elementClassName.equals(
							elementStandard.getElementClassName())) {

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

			sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
				sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementStandard>)QueryUtil.list(
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
	 * Returns the first element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByElement_First(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByElement_First(
			elementOriginalId, elementClassName, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the first element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByElement_First(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator) {

		List<ElementStandard> list = findByElement(
			elementOriginalId, elementClassName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findByElement_Last(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the last element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator) {

		int count = countByElement(elementOriginalId, elementClassName);

		if (count == 0) {
			return null;
		}

		List<ElementStandard> list = findByElement(
			elementOriginalId, elementClassName, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard[] findByElement_PrevAndNext(
			long elementStandardId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		ElementStandard elementStandard = findByPrimaryKey(elementStandardId);

		Session session = null;

		try {
			session = openSession();

			ElementStandard[] array = new ElementStandardImpl[3];

			array[0] = getByElement_PrevAndNext(
				session, elementStandard, elementOriginalId, elementClassName,
				orderByComparator, true);

			array[1] = elementStandard;

			array[2] = getByElement_PrevAndNext(
				session, elementStandard, elementOriginalId, elementClassName,
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

	protected ElementStandard getByElement_PrevAndNext(
		Session session, ElementStandard elementStandard,
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementStandard> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
			sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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
						elementStandard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementStandard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element standards where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	@Override
	public void removeByElement(
		String elementOriginalId, String elementClassName) {

		for (ElementStandard elementStandard :
				findByElement(
					elementOriginalId, elementClassName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(elementStandard);
		}
	}

	/**
	 * Returns the number of element standards where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element standards
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

			sb.append(_SQL_COUNT_ELEMENTSTANDARD_WHERE);

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
		"elementStandard.elementOriginalId = ? AND ";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_3 =
		"(elementStandard.elementOriginalId IS NULL OR elementStandard.elementOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_2 =
		"elementStandard.elementClassName = ?";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_3 =
		"(elementStandard.elementClassName IS NULL OR elementStandard.elementClassName = '')";

	private FinderPath _finderPathWithPaginationFindBySubscriptionId;
	private FinderPath _finderPathWithoutPaginationFindBySubscriptionId;
	private FinderPath _finderPathCountBySubscriptionId;

	/**
	 * Returns all the element standards where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element standards
	 */
	@Override
	public List<ElementStandard> findBySubscriptionId(long subscriptionId) {
		return findBySubscriptionId(
			subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element standards where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of matching element standards
	 */
	@Override
	public List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return findBySubscriptionId(subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element standards where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element standards where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element standards
	 */
	@Override
	public List<ElementStandard> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
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

		List<ElementStandard> list = null;

		if (useFinderCache) {
			list = (List<ElementStandard>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementStandard elementStandard : list) {
					if (subscriptionId != elementStandard.getSubscriptionId()) {
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

			sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

			sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				list = (List<ElementStandard>)QueryUtil.list(
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
	 * Returns the first element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the first element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ElementStandard> orderByComparator) {

		List<ElementStandard> list = findBySubscriptionId(
			subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard
	 * @throws NoSuchElementStandardException if a matching element standard could not be found
	 */
	@Override
	public ElementStandard findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);

		if (elementStandard != null) {
			return elementStandard;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchElementStandardException(sb.toString());
	}

	/**
	 * Returns the last element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element standard, or <code>null</code> if a matching element standard could not be found
	 */
	@Override
	public ElementStandard fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ElementStandard> orderByComparator) {

		int count = countBySubscriptionId(subscriptionId);

		if (count == 0) {
			return null;
		}

		List<ElementStandard> list = findBySubscriptionId(
			subscriptionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element standards before and after the current element standard in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementStandardId the primary key of the current element standard
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard[] findBySubscriptionId_PrevAndNext(
			long elementStandardId, long subscriptionId,
			OrderByComparator<ElementStandard> orderByComparator)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = findByPrimaryKey(elementStandardId);

		Session session = null;

		try {
			session = openSession();

			ElementStandard[] array = new ElementStandardImpl[3];

			array[0] = getBySubscriptionId_PrevAndNext(
				session, elementStandard, subscriptionId, orderByComparator,
				true);

			array[1] = elementStandard;

			array[2] = getBySubscriptionId_PrevAndNext(
				session, elementStandard, subscriptionId, orderByComparator,
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

	protected ElementStandard getBySubscriptionId_PrevAndNext(
		Session session, ElementStandard elementStandard, long subscriptionId,
		OrderByComparator<ElementStandard> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTSTANDARD_WHERE);

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
			sb.append(ElementStandardModelImpl.ORDER_BY_JPQL);
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
						elementStandard)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementStandard> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element standards where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeBySubscriptionId(long subscriptionId) {
		for (ElementStandard elementStandard :
				findBySubscriptionId(
					subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(elementStandard);
		}
	}

	/**
	 * Returns the number of element standards where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element standards
	 */
	@Override
	public int countBySubscriptionId(long subscriptionId) {
		FinderPath finderPath = _finderPathCountBySubscriptionId;

		Object[] finderArgs = new Object[] {subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTSTANDARD_WHERE);

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
		"elementStandard.subscriptionId = ?";

	public ElementStandardPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ElementStandard.class);

		setModelImplClass(ElementStandardImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the element standard in the entity cache if it is enabled.
	 *
	 * @param elementStandard the element standard
	 */
	@Override
	public void cacheResult(ElementStandard elementStandard) {
		entityCache.putResult(
			ElementStandardImpl.class, elementStandard.getPrimaryKey(),
			elementStandard);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				elementStandard.getUuid(), elementStandard.getGroupId()
			},
			elementStandard);
	}

	/**
	 * Caches the element standards in the entity cache if it is enabled.
	 *
	 * @param elementStandards the element standards
	 */
	@Override
	public void cacheResult(List<ElementStandard> elementStandards) {
		for (ElementStandard elementStandard : elementStandards) {
			if (entityCache.getResult(
					ElementStandardImpl.class,
					elementStandard.getPrimaryKey()) == null) {

				cacheResult(elementStandard);
			}
		}
	}

	/**
	 * Clears the cache for all element standards.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElementStandardImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the element standard.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ElementStandard elementStandard) {
		entityCache.removeResult(ElementStandardImpl.class, elementStandard);
	}

	@Override
	public void clearCache(List<ElementStandard> elementStandards) {
		for (ElementStandard elementStandard : elementStandards) {
			entityCache.removeResult(
				ElementStandardImpl.class, elementStandard);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElementStandardImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ElementStandardModelImpl elementStandardModelImpl) {

		Object[] args = new Object[] {
			elementStandardModelImpl.getUuid(),
			elementStandardModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, elementStandardModelImpl, false);
	}

	/**
	 * Creates a new element standard with the primary key. Does not add the element standard to the database.
	 *
	 * @param elementStandardId the primary key for the new element standard
	 * @return the new element standard
	 */
	@Override
	public ElementStandard create(long elementStandardId) {
		ElementStandard elementStandard = new ElementStandardImpl();

		elementStandard.setNew(true);
		elementStandard.setPrimaryKey(elementStandardId);

		String uuid = PortalUUIDUtil.generate();

		elementStandard.setUuid(uuid);

		elementStandard.setCompanyId(CompanyThreadLocal.getCompanyId());

		return elementStandard;
	}

	/**
	 * Removes the element standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard that was removed
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard remove(long elementStandardId)
		throws NoSuchElementStandardException {

		return remove((Serializable)elementStandardId);
	}

	/**
	 * Removes the element standard with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the element standard
	 * @return the element standard that was removed
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard remove(Serializable primaryKey)
		throws NoSuchElementStandardException {

		Session session = null;

		try {
			session = openSession();

			ElementStandard elementStandard = (ElementStandard)session.get(
				ElementStandardImpl.class, primaryKey);

			if (elementStandard == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElementStandardException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(elementStandard);
		}
		catch (NoSuchElementStandardException noSuchEntityException) {
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
	protected ElementStandard removeImpl(ElementStandard elementStandard) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(elementStandard)) {
				elementStandard = (ElementStandard)session.get(
					ElementStandardImpl.class,
					elementStandard.getPrimaryKeyObj());
			}

			if (elementStandard != null) {
				session.delete(elementStandard);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (elementStandard != null) {
			clearCache(elementStandard);
		}

		return elementStandard;
	}

	@Override
	public ElementStandard updateImpl(ElementStandard elementStandard) {
		boolean isNew = elementStandard.isNew();

		if (!(elementStandard instanceof ElementStandardModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(elementStandard.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					elementStandard);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in elementStandard proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ElementStandard implementation " +
					elementStandard.getClass());
		}

		ElementStandardModelImpl elementStandardModelImpl =
			(ElementStandardModelImpl)elementStandard;

		if (Validator.isNull(elementStandard.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			elementStandard.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (elementStandard.getCreateDate() == null)) {
			if (serviceContext == null) {
				elementStandard.setCreateDate(now);
			}
			else {
				elementStandard.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!elementStandardModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				elementStandard.setModifiedDate(now);
			}
			else {
				elementStandard.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(elementStandard);
			}
			else {
				elementStandard = (ElementStandard)session.merge(
					elementStandard);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ElementStandardImpl.class, elementStandardModelImpl, false, true);

		cacheUniqueFindersCache(elementStandardModelImpl);

		if (isNew) {
			elementStandard.setNew(false);
		}

		elementStandard.resetOriginalValues();

		return elementStandard;
	}

	/**
	 * Returns the element standard with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the element standard
	 * @return the element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElementStandardException {

		ElementStandard elementStandard = fetchByPrimaryKey(primaryKey);

		if (elementStandard == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElementStandardException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return elementStandard;
	}

	/**
	 * Returns the element standard with the primary key or throws a <code>NoSuchElementStandardException</code> if it could not be found.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard
	 * @throws NoSuchElementStandardException if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard findByPrimaryKey(long elementStandardId)
		throws NoSuchElementStandardException {

		return findByPrimaryKey((Serializable)elementStandardId);
	}

	/**
	 * Returns the element standard with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementStandardId the primary key of the element standard
	 * @return the element standard, or <code>null</code> if a element standard with the primary key could not be found
	 */
	@Override
	public ElementStandard fetchByPrimaryKey(long elementStandardId) {
		return fetchByPrimaryKey((Serializable)elementStandardId);
	}

	/**
	 * Returns all the element standards.
	 *
	 * @return the element standards
	 */
	@Override
	public List<ElementStandard> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @return the range of element standards
	 */
	@Override
	public List<ElementStandard> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the element standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of element standards
	 */
	@Override
	public List<ElementStandard> findAll(
		int start, int end,
		OrderByComparator<ElementStandard> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element standards.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementStandardModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element standards
	 * @param end the upper bound of the range of element standards (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of element standards
	 */
	@Override
	public List<ElementStandard> findAll(
		int start, int end,
		OrderByComparator<ElementStandard> orderByComparator,
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

		List<ElementStandard> list = null;

		if (useFinderCache) {
			list = (List<ElementStandard>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELEMENTSTANDARD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELEMENTSTANDARD;

				sql = sql.concat(ElementStandardModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ElementStandard>)QueryUtil.list(
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
	 * Removes all the element standards from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ElementStandard elementStandard : findAll()) {
			remove(elementStandard);
		}
	}

	/**
	 * Returns the number of element standards.
	 *
	 * @return the number of element standards
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELEMENTSTANDARD);

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
		return "elementStandardId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELEMENTSTANDARD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElementStandardModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the element standard persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ElementStandardModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ElementStandard.class.getName()));

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
		entityCache.removeCache(ElementStandardImpl.class.getName());

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

	private static final String _SQL_SELECT_ELEMENTSTANDARD =
		"SELECT elementStandard FROM ElementStandard elementStandard";

	private static final String _SQL_SELECT_ELEMENTSTANDARD_WHERE =
		"SELECT elementStandard FROM ElementStandard elementStandard WHERE ";

	private static final String _SQL_COUNT_ELEMENTSTANDARD =
		"SELECT COUNT(elementStandard) FROM ElementStandard elementStandard";

	private static final String _SQL_COUNT_ELEMENTSTANDARD_WHERE =
		"SELECT COUNT(elementStandard) FROM ElementStandard elementStandard WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "elementStandard.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ElementStandard exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ElementStandard exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ElementStandardPersistenceImpl.class);

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

	private static class ElementStandardModelArgumentsResolver
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

			ElementStandardModelImpl elementStandardModelImpl =
				(ElementStandardModelImpl)baseModel;

			long columnBitmask = elementStandardModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					elementStandardModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						elementStandardModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					elementStandardModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ElementStandardModelImpl elementStandardModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						elementStandardModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = elementStandardModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}