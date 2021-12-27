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

import com.iot_catalogue.exception.NoSuchComponentChildException;
import com.iot_catalogue.model.ComponentChild;
import com.iot_catalogue.model.impl.ComponentChildImpl;
import com.iot_catalogue.model.impl.ComponentChildModelImpl;
import com.iot_catalogue.service.persistence.ComponentChildPersistence;
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
 * The persistence implementation for the component child service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ComponentChildPersistence.class)
public class ComponentChildPersistenceImpl
	extends BasePersistenceImpl<ComponentChild>
	implements ComponentChildPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ComponentChildUtil</code> to access the component child persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ComponentChildImpl.class.getName();

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
	 * Returns all the component childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching component childs
	 */
	@Override
	public List<ComponentChild> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the component childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the component childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the component childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
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

		List<ComponentChild> list = null;

		if (useFinderCache) {
			list = (List<ComponentChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ComponentChild componentChild : list) {
					if (!uuid.equals(componentChild.getUuid())) {
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

			sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

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
				sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
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

				list = (List<ComponentChild>)QueryUtil.list(
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
	 * Returns the first component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByUuid_First(
			String uuid, OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByUuid_First(
			uuid, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the first component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByUuid_First(
		String uuid, OrderByComparator<ComponentChild> orderByComparator) {

		List<ComponentChild> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByUuid_Last(
			String uuid, OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByUuid_Last(
			uuid, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the last component child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByUuid_Last(
		String uuid, OrderByComparator<ComponentChild> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ComponentChild> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		uuid = Objects.toString(uuid, "");

		ComponentChild componentChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ComponentChild[] array = new ComponentChildImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, componentChild, uuid, orderByComparator, true);

			array[1] = componentChild;

			array[2] = getByUuid_PrevAndNext(
				session, componentChild, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ComponentChild getByUuid_PrevAndNext(
		Session session, ComponentChild componentChild, String uuid,
		OrderByComparator<ComponentChild> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

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
			sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
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
						componentChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ComponentChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the component childs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ComponentChild componentChild :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(componentChild);
		}
	}

	/**
	 * Returns the number of component childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching component childs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMPONENTCHILD_WHERE);

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
		"componentChild.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(componentChild.uuid IS NULL OR componentChild.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchComponentChildException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByUUID_G(String uuid, long groupId)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByUUID_G(uuid, groupId);

		if (componentChild == null) {
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

			throw new NoSuchComponentChildException(sb.toString());
		}

		return componentChild;
	}

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the component child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByUUID_G(
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

		if (result instanceof ComponentChild) {
			ComponentChild componentChild = (ComponentChild)result;

			if (!Objects.equals(uuid, componentChild.getUuid()) ||
				(groupId != componentChild.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

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

				List<ComponentChild> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ComponentChild componentChild = list.get(0);

					result = componentChild;

					cacheResult(componentChild);
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
			return (ComponentChild)result;
		}
	}

	/**
	 * Removes the component child where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the component child that was removed
	 */
	@Override
	public ComponentChild removeByUUID_G(String uuid, long groupId)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = findByUUID_G(uuid, groupId);

		return remove(componentChild);
	}

	/**
	 * Returns the number of component childs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching component childs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMPONENTCHILD_WHERE);

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
		"componentChild.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(componentChild.uuid IS NULL OR componentChild.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"componentChild.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching component childs
	 */
	@Override
	public List<ComponentChild> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
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

		List<ComponentChild> list = null;

		if (useFinderCache) {
			list = (List<ComponentChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ComponentChild componentChild : list) {
					if (!uuid.equals(componentChild.getUuid()) ||
						(companyId != componentChild.getCompanyId())) {

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

			sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

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
				sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
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

				list = (List<ComponentChild>)QueryUtil.list(
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
	 * Returns the first component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the first component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ComponentChild> orderByComparator) {

		List<ComponentChild> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the last component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ComponentChild> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ComponentChild> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		uuid = Objects.toString(uuid, "");

		ComponentChild componentChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ComponentChild[] array = new ComponentChildImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, componentChild, uuid, companyId, orderByComparator,
				true);

			array[1] = componentChild;

			array[2] = getByUuid_C_PrevAndNext(
				session, componentChild, uuid, companyId, orderByComparator,
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

	protected ComponentChild getByUuid_C_PrevAndNext(
		Session session, ComponentChild componentChild, String uuid,
		long companyId, OrderByComparator<ComponentChild> orderByComparator,
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

		sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

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
			sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
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
						componentChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ComponentChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the component childs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ComponentChild componentChild :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(componentChild);
		}
	}

	/**
	 * Returns the number of component childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching component childs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_COMPONENTCHILD_WHERE);

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
		"componentChild.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(componentChild.uuid IS NULL OR componentChild.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"componentChild.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the component childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching component childs
	 */
	@Override
	public List<ComponentChild> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the component childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the component childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the component childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
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

		List<ComponentChild> list = null;

		if (useFinderCache) {
			list = (List<ComponentChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ComponentChild componentChild : list) {
					if (groupId != componentChild.getGroupId()) {
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

			sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ComponentChild>)QueryUtil.list(
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
	 * Returns the first component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByGroupId_First(
			long groupId, OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByGroupId_First(
			groupId, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the first component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByGroupId_First(
		long groupId, OrderByComparator<ComponentChild> orderByComparator) {

		List<ComponentChild> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByGroupId_Last(
			long groupId, OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the last component child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByGroupId_Last(
		long groupId, OrderByComparator<ComponentChild> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ComponentChild> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild[] findByGroupId_PrevAndNext(
			long id, long groupId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ComponentChild[] array = new ComponentChildImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, componentChild, groupId, orderByComparator, true);

			array[1] = componentChild;

			array[2] = getByGroupId_PrevAndNext(
				session, componentChild, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ComponentChild getByGroupId_PrevAndNext(
		Session session, ComponentChild componentChild, long groupId,
		OrderByComparator<ComponentChild> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

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
			sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
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
						componentChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ComponentChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the component childs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ComponentChild componentChild :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(componentChild);
		}
	}

	/**
	 * Returns the number of component childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching component childs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMPONENTCHILD_WHERE);

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
		"componentChild.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByComponentOrignalId;
	private FinderPath _finderPathWithoutPaginationFindByComponentOrignalId;
	private FinderPath _finderPathCountByComponentOrignalId;

	/**
	 * Returns all the component childs where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @return the matching component childs
	 */
	@Override
	public List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId) {

		return findByComponentOrignalId(
			componentOrignalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the component childs where componentOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end) {

		return findByComponentOrignalId(componentOrignalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the component childs where componentOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return findByComponentOrignalId(
			componentOrignalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the component childs where componentOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findByComponentOrignalId(
		String componentOrignalId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
		boolean useFinderCache) {

		componentOrignalId = Objects.toString(componentOrignalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByComponentOrignalId;
				finderArgs = new Object[] {componentOrignalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByComponentOrignalId;
			finderArgs = new Object[] {
				componentOrignalId, start, end, orderByComparator
			};
		}

		List<ComponentChild> list = null;

		if (useFinderCache) {
			list = (List<ComponentChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ComponentChild componentChild : list) {
					if (!componentOrignalId.equals(
							componentChild.getComponentOrignalId())) {

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

			sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

			boolean bindComponentOrignalId = false;

			if (componentOrignalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COMPONENTORIGNALID_COMPONENTORIGNALID_3);
			}
			else {
				bindComponentOrignalId = true;

				sb.append(
					_FINDER_COLUMN_COMPONENTORIGNALID_COMPONENTORIGNALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindComponentOrignalId) {
					queryPos.add(componentOrignalId);
				}

				list = (List<ComponentChild>)QueryUtil.list(
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
	 * Returns the first component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByComponentOrignalId_First(
			String componentOrignalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByComponentOrignalId_First(
			componentOrignalId, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("componentOrignalId=");
		sb.append(componentOrignalId);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the first component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByComponentOrignalId_First(
		String componentOrignalId,
		OrderByComparator<ComponentChild> orderByComparator) {

		List<ComponentChild> list = findByComponentOrignalId(
			componentOrignalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findByComponentOrignalId_Last(
			String componentOrignalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByComponentOrignalId_Last(
			componentOrignalId, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("componentOrignalId=");
		sb.append(componentOrignalId);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the last component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchByComponentOrignalId_Last(
		String componentOrignalId,
		OrderByComparator<ComponentChild> orderByComparator) {

		int count = countByComponentOrignalId(componentOrignalId);

		if (count == 0) {
			return null;
		}

		List<ComponentChild> list = findByComponentOrignalId(
			componentOrignalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where componentOrignalId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param componentOrignalId the component orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild[] findByComponentOrignalId_PrevAndNext(
			long id, String componentOrignalId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		componentOrignalId = Objects.toString(componentOrignalId, "");

		ComponentChild componentChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ComponentChild[] array = new ComponentChildImpl[3];

			array[0] = getByComponentOrignalId_PrevAndNext(
				session, componentChild, componentOrignalId, orderByComparator,
				true);

			array[1] = componentChild;

			array[2] = getByComponentOrignalId_PrevAndNext(
				session, componentChild, componentOrignalId, orderByComparator,
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

	protected ComponentChild getByComponentOrignalId_PrevAndNext(
		Session session, ComponentChild componentChild,
		String componentOrignalId,
		OrderByComparator<ComponentChild> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

		boolean bindComponentOrignalId = false;

		if (componentOrignalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_COMPONENTORIGNALID_COMPONENTORIGNALID_3);
		}
		else {
			bindComponentOrignalId = true;

			sb.append(_FINDER_COLUMN_COMPONENTORIGNALID_COMPONENTORIGNALID_2);
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
			sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindComponentOrignalId) {
			queryPos.add(componentOrignalId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						componentChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ComponentChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the component childs where componentOrignalId = &#63; from the database.
	 *
	 * @param componentOrignalId the component orignal ID
	 */
	@Override
	public void removeByComponentOrignalId(String componentOrignalId) {
		for (ComponentChild componentChild :
				findByComponentOrignalId(
					componentOrignalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(componentChild);
		}
	}

	/**
	 * Returns the number of component childs where componentOrignalId = &#63;.
	 *
	 * @param componentOrignalId the component orignal ID
	 * @return the number of matching component childs
	 */
	@Override
	public int countByComponentOrignalId(String componentOrignalId) {
		componentOrignalId = Objects.toString(componentOrignalId, "");

		FinderPath finderPath = _finderPathCountByComponentOrignalId;

		Object[] finderArgs = new Object[] {componentOrignalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMPONENTCHILD_WHERE);

			boolean bindComponentOrignalId = false;

			if (componentOrignalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_COMPONENTORIGNALID_COMPONENTORIGNALID_3);
			}
			else {
				bindComponentOrignalId = true;

				sb.append(
					_FINDER_COLUMN_COMPONENTORIGNALID_COMPONENTORIGNALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindComponentOrignalId) {
					queryPos.add(componentOrignalId);
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

	private static final String
		_FINDER_COLUMN_COMPONENTORIGNALID_COMPONENTORIGNALID_2 =
			"componentChild.componentOrignalId = ?";

	private static final String
		_FINDER_COLUMN_COMPONENTORIGNALID_COMPONENTORIGNALID_3 =
			"(componentChild.componentOrignalId IS NULL OR componentChild.componentOrignalId = '')";

	private FinderPath _finderPathWithPaginationFindBySubscriptionId;
	private FinderPath _finderPathWithoutPaginationFindBySubscriptionId;
	private FinderPath _finderPathCountBySubscriptionId;

	/**
	 * Returns all the component childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching component childs
	 */
	@Override
	public List<ComponentChild> findBySubscriptionId(long subscriptionId) {
		return findBySubscriptionId(
			subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the component childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of matching component childs
	 */
	@Override
	public List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return findBySubscriptionId(subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the component childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the component childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching component childs
	 */
	@Override
	public List<ComponentChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ComponentChild> orderByComparator,
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

		List<ComponentChild> list = null;

		if (useFinderCache) {
			list = (List<ComponentChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ComponentChild componentChild : list) {
					if (subscriptionId != componentChild.getSubscriptionId()) {
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

			sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

			sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				list = (List<ComponentChild>)QueryUtil.list(
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
	 * Returns the first component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the first component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator) {

		List<ComponentChild> list = findBySubscriptionId(
			subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child
	 * @throws NoSuchComponentChildException if a matching component child could not be found
	 */
	@Override
	public ComponentChild findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);

		if (componentChild != null) {
			return componentChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchComponentChildException(sb.toString());
	}

	/**
	 * Returns the last component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching component child, or <code>null</code> if a matching component child could not be found
	 */
	@Override
	public ComponentChild fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator) {

		int count = countBySubscriptionId(subscriptionId);

		if (count == 0) {
			return null;
		}

		List<ComponentChild> list = findBySubscriptionId(
			subscriptionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the component childs before and after the current component child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current component child
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild[] findBySubscriptionId_PrevAndNext(
			long id, long subscriptionId,
			OrderByComparator<ComponentChild> orderByComparator)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ComponentChild[] array = new ComponentChildImpl[3];

			array[0] = getBySubscriptionId_PrevAndNext(
				session, componentChild, subscriptionId, orderByComparator,
				true);

			array[1] = componentChild;

			array[2] = getBySubscriptionId_PrevAndNext(
				session, componentChild, subscriptionId, orderByComparator,
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

	protected ComponentChild getBySubscriptionId_PrevAndNext(
		Session session, ComponentChild componentChild, long subscriptionId,
		OrderByComparator<ComponentChild> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_COMPONENTCHILD_WHERE);

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
			sb.append(ComponentChildModelImpl.ORDER_BY_JPQL);
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
						componentChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ComponentChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the component childs where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeBySubscriptionId(long subscriptionId) {
		for (ComponentChild componentChild :
				findBySubscriptionId(
					subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(componentChild);
		}
	}

	/**
	 * Returns the number of component childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching component childs
	 */
	@Override
	public int countBySubscriptionId(long subscriptionId) {
		FinderPath finderPath = _finderPathCountBySubscriptionId;

		Object[] finderArgs = new Object[] {subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_COMPONENTCHILD_WHERE);

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
		"componentChild.subscriptionId = ?";

	public ComponentChildPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ComponentChild.class);

		setModelImplClass(ComponentChildImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the component child in the entity cache if it is enabled.
	 *
	 * @param componentChild the component child
	 */
	@Override
	public void cacheResult(ComponentChild componentChild) {
		entityCache.putResult(
			ComponentChildImpl.class, componentChild.getPrimaryKey(),
			componentChild);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				componentChild.getUuid(), componentChild.getGroupId()
			},
			componentChild);
	}

	/**
	 * Caches the component childs in the entity cache if it is enabled.
	 *
	 * @param componentChilds the component childs
	 */
	@Override
	public void cacheResult(List<ComponentChild> componentChilds) {
		for (ComponentChild componentChild : componentChilds) {
			if (entityCache.getResult(
					ComponentChildImpl.class, componentChild.getPrimaryKey()) ==
						null) {

				cacheResult(componentChild);
			}
		}
	}

	/**
	 * Clears the cache for all component childs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ComponentChildImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the component child.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ComponentChild componentChild) {
		entityCache.removeResult(ComponentChildImpl.class, componentChild);
	}

	@Override
	public void clearCache(List<ComponentChild> componentChilds) {
		for (ComponentChild componentChild : componentChilds) {
			entityCache.removeResult(ComponentChildImpl.class, componentChild);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ComponentChildImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ComponentChildModelImpl componentChildModelImpl) {

		Object[] args = new Object[] {
			componentChildModelImpl.getUuid(),
			componentChildModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, componentChildModelImpl, false);
	}

	/**
	 * Creates a new component child with the primary key. Does not add the component child to the database.
	 *
	 * @param id the primary key for the new component child
	 * @return the new component child
	 */
	@Override
	public ComponentChild create(long id) {
		ComponentChild componentChild = new ComponentChildImpl();

		componentChild.setNew(true);
		componentChild.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		componentChild.setUuid(uuid);

		componentChild.setCompanyId(CompanyThreadLocal.getCompanyId());

		return componentChild;
	}

	/**
	 * Removes the component child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the component child
	 * @return the component child that was removed
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild remove(long id) throws NoSuchComponentChildException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the component child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the component child
	 * @return the component child that was removed
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild remove(Serializable primaryKey)
		throws NoSuchComponentChildException {

		Session session = null;

		try {
			session = openSession();

			ComponentChild componentChild = (ComponentChild)session.get(
				ComponentChildImpl.class, primaryKey);

			if (componentChild == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchComponentChildException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(componentChild);
		}
		catch (NoSuchComponentChildException noSuchEntityException) {
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
	protected ComponentChild removeImpl(ComponentChild componentChild) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(componentChild)) {
				componentChild = (ComponentChild)session.get(
					ComponentChildImpl.class,
					componentChild.getPrimaryKeyObj());
			}

			if (componentChild != null) {
				session.delete(componentChild);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (componentChild != null) {
			clearCache(componentChild);
		}

		return componentChild;
	}

	@Override
	public ComponentChild updateImpl(ComponentChild componentChild) {
		boolean isNew = componentChild.isNew();

		if (!(componentChild instanceof ComponentChildModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(componentChild.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					componentChild);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in componentChild proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ComponentChild implementation " +
					componentChild.getClass());
		}

		ComponentChildModelImpl componentChildModelImpl =
			(ComponentChildModelImpl)componentChild;

		if (Validator.isNull(componentChild.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			componentChild.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (componentChild.getCreateDate() == null)) {
			if (serviceContext == null) {
				componentChild.setCreateDate(now);
			}
			else {
				componentChild.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!componentChildModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				componentChild.setModifiedDate(now);
			}
			else {
				componentChild.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(componentChild);
			}
			else {
				componentChild = (ComponentChild)session.merge(componentChild);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ComponentChildImpl.class, componentChildModelImpl, false, true);

		cacheUniqueFindersCache(componentChildModelImpl);

		if (isNew) {
			componentChild.setNew(false);
		}

		componentChild.resetOriginalValues();

		return componentChild;
	}

	/**
	 * Returns the component child with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the component child
	 * @return the component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild findByPrimaryKey(Serializable primaryKey)
		throws NoSuchComponentChildException {

		ComponentChild componentChild = fetchByPrimaryKey(primaryKey);

		if (componentChild == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchComponentChildException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return componentChild;
	}

	/**
	 * Returns the component child with the primary key or throws a <code>NoSuchComponentChildException</code> if it could not be found.
	 *
	 * @param id the primary key of the component child
	 * @return the component child
	 * @throws NoSuchComponentChildException if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild findByPrimaryKey(long id)
		throws NoSuchComponentChildException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the component child with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the component child
	 * @return the component child, or <code>null</code> if a component child with the primary key could not be found
	 */
	@Override
	public ComponentChild fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the component childs.
	 *
	 * @return the component childs
	 */
	@Override
	public List<ComponentChild> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the component childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @return the range of component childs
	 */
	@Override
	public List<ComponentChild> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the component childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of component childs
	 */
	@Override
	public List<ComponentChild> findAll(
		int start, int end,
		OrderByComparator<ComponentChild> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the component childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ComponentChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of component childs
	 * @param end the upper bound of the range of component childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of component childs
	 */
	@Override
	public List<ComponentChild> findAll(
		int start, int end, OrderByComparator<ComponentChild> orderByComparator,
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

		List<ComponentChild> list = null;

		if (useFinderCache) {
			list = (List<ComponentChild>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMPONENTCHILD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMPONENTCHILD;

				sql = sql.concat(ComponentChildModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ComponentChild>)QueryUtil.list(
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
	 * Removes all the component childs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ComponentChild componentChild : findAll()) {
			remove(componentChild);
		}
	}

	/**
	 * Returns the number of component childs.
	 *
	 * @return the number of component childs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMPONENTCHILD);

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
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMPONENTCHILD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ComponentChildModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the component child persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ComponentChildModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ComponentChild.class.getName()));

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

		_finderPathWithPaginationFindByComponentOrignalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByComponentOrignalId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"componentOrignalId"}, true);

		_finderPathWithoutPaginationFindByComponentOrignalId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByComponentOrignalId",
				new String[] {String.class.getName()},
				new String[] {"componentOrignalId"}, true);

		_finderPathCountByComponentOrignalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByComponentOrignalId", new String[] {String.class.getName()},
			new String[] {"componentOrignalId"}, false);

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
		entityCache.removeCache(ComponentChildImpl.class.getName());

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

	private static final String _SQL_SELECT_COMPONENTCHILD =
		"SELECT componentChild FROM ComponentChild componentChild";

	private static final String _SQL_SELECT_COMPONENTCHILD_WHERE =
		"SELECT componentChild FROM ComponentChild componentChild WHERE ";

	private static final String _SQL_COUNT_COMPONENTCHILD =
		"SELECT COUNT(componentChild) FROM ComponentChild componentChild";

	private static final String _SQL_COUNT_COMPONENTCHILD_WHERE =
		"SELECT COUNT(componentChild) FROM ComponentChild componentChild WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "componentChild.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ComponentChild exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ComponentChild exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ComponentChildPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "id"});

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

	private static class ComponentChildModelArgumentsResolver
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

			ComponentChildModelImpl componentChildModelImpl =
				(ComponentChildModelImpl)baseModel;

			long columnBitmask = componentChildModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					componentChildModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						componentChildModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					componentChildModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ComponentChildModelImpl componentChildModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						componentChildModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = componentChildModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}