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

import com.iot_catalogue.exception.NoSuchElementEntityException;
import com.iot_catalogue.model.ElementEntity;
import com.iot_catalogue.model.impl.ElementEntityImpl;
import com.iot_catalogue.model.impl.ElementEntityModelImpl;
import com.iot_catalogue.service.persistence.ElementEntityPersistence;
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
 * The persistence implementation for the element entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElementEntityPersistence.class)
public class ElementEntityPersistenceImpl
	extends BasePersistenceImpl<ElementEntity>
	implements ElementEntityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElementEntityUtil</code> to access the element entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElementEntityImpl.class.getName();

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
	 * Returns all the element entities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element entities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
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

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if (!uuid.equals(elementEntity.getUuid())) {
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

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByUuid_First(
			String uuid, OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByUuid_First(
			uuid, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByUuid_First(
		String uuid, OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByUuid_Last(
			String uuid, OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByUuid_Last(uuid, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByUuid_Last(
		String uuid, OrderByComparator<ElementEntity> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where uuid = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findByUuid_PrevAndNext(
			long elementEntityId, String uuid,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		uuid = Objects.toString(uuid, "");

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, elementEntity, uuid, orderByComparator, true);

			array[1] = elementEntity;

			array[2] = getByUuid_PrevAndNext(
				session, elementEntity, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementEntity getByUuid_PrevAndNext(
		Session session, ElementEntity elementEntity, String uuid,
		OrderByComparator<ElementEntity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ElementEntity elementEntity :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching element entities
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

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
		"elementEntity.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(elementEntity.uuid IS NULL OR elementEntity.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchElementEntityException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByUUID_G(String uuid, long groupId)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByUUID_G(uuid, groupId);

		if (elementEntity == null) {
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

			throw new NoSuchElementEntityException(sb.toString());
		}

		return elementEntity;
	}

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the element entity where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByUUID_G(
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

		if (result instanceof ElementEntity) {
			ElementEntity elementEntity = (ElementEntity)result;

			if (!Objects.equals(uuid, elementEntity.getUuid()) ||
				(groupId != elementEntity.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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

				List<ElementEntity> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ElementEntity elementEntity = list.get(0);

					result = elementEntity;

					cacheResult(elementEntity);
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
			return (ElementEntity)result;
		}
	}

	/**
	 * Removes the element entity where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the element entity that was removed
	 */
	@Override
	public ElementEntity removeByUUID_G(String uuid, long groupId)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = findByUUID_G(uuid, groupId);

		return remove(elementEntity);
	}

	/**
	 * Returns the number of element entities where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching element entities
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

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
		"elementEntity.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(elementEntity.uuid IS NULL OR elementEntity.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"elementEntity.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
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

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if (!uuid.equals(elementEntity.getUuid()) ||
						(companyId != elementEntity.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ElementEntity> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findByUuid_C_PrevAndNext(
			long elementEntityId, String uuid, long companyId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		uuid = Objects.toString(uuid, "");

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, elementEntity, uuid, companyId, orderByComparator,
				true);

			array[1] = elementEntity;

			array[2] = getByUuid_C_PrevAndNext(
				session, elementEntity, uuid, companyId, orderByComparator,
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

	protected ElementEntity getByUuid_C_PrevAndNext(
		Session session, ElementEntity elementEntity, String uuid,
		long companyId, OrderByComparator<ElementEntity> orderByComparator,
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

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ElementEntity elementEntity :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching element entities
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

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
		"elementEntity.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(elementEntity.uuid IS NULL OR elementEntity.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"elementEntity.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the element entities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element entities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
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

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if (groupId != elementEntity.getGroupId()) {
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

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByGroupId_First(
			long groupId, OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByGroupId_First(
			groupId, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByGroupId_First(
		long groupId, OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByGroupId_Last(
			long groupId, OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByGroupId_Last(
		long groupId, OrderByComparator<ElementEntity> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where groupId = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findByGroupId_PrevAndNext(
			long elementEntityId, long groupId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, elementEntity, groupId, orderByComparator, true);

			array[1] = elementEntity;

			array[2] = getByGroupId_PrevAndNext(
				session, elementEntity, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementEntity getByGroupId_PrevAndNext(
		Session session, ElementEntity elementEntity, long groupId,
		OrderByComparator<ElementEntity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ElementEntity elementEntity :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching element entities
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

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
		"elementEntity.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the element entities where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element entities where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByStatus(
		int status, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
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

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if (status != elementEntity.getStatus()) {
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

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(status);

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByStatus_First(
			int status, OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByStatus_First(
			status, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByStatus_First(
		int status, OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findByStatus(
			status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByStatus_Last(
			int status, OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByStatus_Last(
			status, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByStatus_Last(
		int status, OrderByComparator<ElementEntity> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where status = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findByStatus_PrevAndNext(
			long elementEntityId, int status,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, elementEntity, status, orderByComparator, true);

			array[1] = elementEntity;

			array[2] = getByStatus_PrevAndNext(
				session, elementEntity, status, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementEntity getByStatus_PrevAndNext(
		Session session, ElementEntity elementEntity, int status,
		OrderByComparator<ElementEntity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (ElementEntity elementEntity :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching element entities
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

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
		"elementEntity.status = ?";

	private FinderPath _finderPathWithPaginationFindByS_E;
	private FinderPath _finderPathWithoutPaginationFindByS_E;
	private FinderPath _finderPathCountByS_E;

	/**
	 * Returns all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findByS_E(
			subscriptionId, elementOriginalId, elementClassName, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByS_E(
		long subscriptionId, String elementOriginalId, String elementClassName,
		int start, int end, OrderByComparator<ElementEntity> orderByComparator,
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

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if ((subscriptionId != elementEntity.getSubscriptionId()) ||
						!elementOriginalId.equals(
							elementEntity.getElementOriginalId()) ||
						!elementClassName.equals(
							elementEntity.getElementClassName())) {

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

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByS_E_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByS_E_First(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
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

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByS_E_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findByS_E(
			subscriptionId, elementOriginalId, elementClassName, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByS_E_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByS_E_Last(
			subscriptionId, elementOriginalId, elementClassName,
			orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
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

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByS_E_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator) {

		int count = countByS_E(
			subscriptionId, elementOriginalId, elementClassName);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findByS_E(
			subscriptionId, elementOriginalId, elementClassName, count - 1,
			count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findByS_E_PrevAndNext(
			long elementEntityId, long subscriptionId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getByS_E_PrevAndNext(
				session, elementEntity, subscriptionId, elementOriginalId,
				elementClassName, orderByComparator, true);

			array[1] = elementEntity;

			array[2] = getByS_E_PrevAndNext(
				session, elementEntity, subscriptionId, elementOriginalId,
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

	protected ElementEntity getByS_E_PrevAndNext(
		Session session, ElementEntity elementEntity, long subscriptionId,
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	@Override
	public void removeByS_E(
		long subscriptionId, String elementOriginalId,
		String elementClassName) {

		for (ElementEntity elementEntity :
				findByS_E(
					subscriptionId, elementOriginalId, elementClassName,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element entities
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

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

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
		"elementEntity.subscriptionId = ? AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTORIGINALID_2 =
		"elementEntity.elementOriginalId = ? AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTORIGINALID_3 =
		"(elementEntity.elementOriginalId IS NULL OR elementEntity.elementOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_S_E_ELEMENTCLASSNAME_2 =
		"elementEntity.elementClassName = ?";

	private static final String _FINDER_COLUMN_S_E_ELEMENTCLASSNAME_3 =
		"(elementEntity.elementClassName IS NULL OR elementEntity.elementClassName = '')";

	private FinderPath _finderPathWithPaginationFindByS_E_L;
	private FinderPath _finderPathWithoutPaginationFindByS_E_L;
	private FinderPath _finderPathCountByS_E_L;

	/**
	 * Returns all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label) {

		return findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end) {

		return findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");
		label = Objects.toString(label, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByS_E_L;
				finderArgs = new Object[] {
					subscriptionId, elementOriginalId, elementClassName, label
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByS_E_L;
			finderArgs = new Object[] {
				subscriptionId, elementOriginalId, elementClassName, label,
				start, end, orderByComparator
			};
		}

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if ((subscriptionId != elementEntity.getSubscriptionId()) ||
						!elementOriginalId.equals(
							elementEntity.getElementOriginalId()) ||
						!elementClassName.equals(
							elementEntity.getElementClassName()) ||
						!label.equals(elementEntity.getLabel())) {

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
					6 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(6);
			}

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

			sb.append(_FINDER_COLUMN_S_E_L_SUBSCRIPTIONID_2);

			boolean bindElementOriginalId = false;

			if (elementOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_L_ELEMENTORIGINALID_3);
			}
			else {
				bindElementOriginalId = true;

				sb.append(_FINDER_COLUMN_S_E_L_ELEMENTORIGINALID_2);
			}

			boolean bindElementClassName = false;

			if (elementClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_L_ELEMENTCLASSNAME_3);
			}
			else {
				bindElementClassName = true;

				sb.append(_FINDER_COLUMN_S_E_L_ELEMENTCLASSNAME_2);
			}

			boolean bindLabel = false;

			if (label.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_L_LABEL_3);
			}
			else {
				bindLabel = true;

				sb.append(_FINDER_COLUMN_S_E_L_LABEL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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

				if (bindLabel) {
					queryPos.add(label);
				}

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByS_E_L_First(
			long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByS_E_L_First(
			subscriptionId, elementOriginalId, elementClassName, label,
			orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append(", elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append(", label=");
		sb.append(label);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByS_E_L_First(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByS_E_L_Last(
			long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByS_E_L_Last(
			subscriptionId, elementOriginalId, elementClassName, label,
			orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(10);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append(", elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append(", label=");
		sb.append(label);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByS_E_L_Last(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label, OrderByComparator<ElementEntity> orderByComparator) {

		int count = countByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findByS_E_L(
			subscriptionId, elementOriginalId, elementClassName, label,
			count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findByS_E_L_PrevAndNext(
			long elementEntityId, long subscriptionId, String elementOriginalId,
			String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");
		label = Objects.toString(label, "");

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getByS_E_L_PrevAndNext(
				session, elementEntity, subscriptionId, elementOriginalId,
				elementClassName, label, orderByComparator, true);

			array[1] = elementEntity;

			array[2] = getByS_E_L_PrevAndNext(
				session, elementEntity, subscriptionId, elementOriginalId,
				elementClassName, label, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementEntity getByS_E_L_PrevAndNext(
		Session session, ElementEntity elementEntity, long subscriptionId,
		String elementOriginalId, String elementClassName, String label,
		OrderByComparator<ElementEntity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				7 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(6);
		}

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

		sb.append(_FINDER_COLUMN_S_E_L_SUBSCRIPTIONID_2);

		boolean bindElementOriginalId = false;

		if (elementOriginalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_S_E_L_ELEMENTORIGINALID_3);
		}
		else {
			bindElementOriginalId = true;

			sb.append(_FINDER_COLUMN_S_E_L_ELEMENTORIGINALID_2);
		}

		boolean bindElementClassName = false;

		if (elementClassName.isEmpty()) {
			sb.append(_FINDER_COLUMN_S_E_L_ELEMENTCLASSNAME_3);
		}
		else {
			bindElementClassName = true;

			sb.append(_FINDER_COLUMN_S_E_L_ELEMENTCLASSNAME_2);
		}

		boolean bindLabel = false;

		if (label.isEmpty()) {
			sb.append(_FINDER_COLUMN_S_E_L_LABEL_3);
		}
		else {
			bindLabel = true;

			sb.append(_FINDER_COLUMN_S_E_L_LABEL_2);
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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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

		if (bindLabel) {
			queryPos.add(label);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 */
	@Override
	public void removeByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label) {

		for (ElementEntity elementEntity :
				findByS_E_L(
					subscriptionId, elementOriginalId, elementClassName, label,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where subscriptionId = &#63; and elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the number of matching element entities
	 */
	@Override
	public int countByS_E_L(
		long subscriptionId, String elementOriginalId, String elementClassName,
		String label) {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");
		label = Objects.toString(label, "");

		FinderPath finderPath = _finderPathCountByS_E_L;

		Object[] finderArgs = new Object[] {
			subscriptionId, elementOriginalId, elementClassName, label
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

			sb.append(_FINDER_COLUMN_S_E_L_SUBSCRIPTIONID_2);

			boolean bindElementOriginalId = false;

			if (elementOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_L_ELEMENTORIGINALID_3);
			}
			else {
				bindElementOriginalId = true;

				sb.append(_FINDER_COLUMN_S_E_L_ELEMENTORIGINALID_2);
			}

			boolean bindElementClassName = false;

			if (elementClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_L_ELEMENTCLASSNAME_3);
			}
			else {
				bindElementClassName = true;

				sb.append(_FINDER_COLUMN_S_E_L_ELEMENTCLASSNAME_2);
			}

			boolean bindLabel = false;

			if (label.isEmpty()) {
				sb.append(_FINDER_COLUMN_S_E_L_LABEL_3);
			}
			else {
				bindLabel = true;

				sb.append(_FINDER_COLUMN_S_E_L_LABEL_2);
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

				if (bindLabel) {
					queryPos.add(label);
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

	private static final String _FINDER_COLUMN_S_E_L_SUBSCRIPTIONID_2 =
		"elementEntity.subscriptionId = ? AND ";

	private static final String _FINDER_COLUMN_S_E_L_ELEMENTORIGINALID_2 =
		"elementEntity.elementOriginalId = ? AND ";

	private static final String _FINDER_COLUMN_S_E_L_ELEMENTORIGINALID_3 =
		"(elementEntity.elementOriginalId IS NULL OR elementEntity.elementOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_S_E_L_ELEMENTCLASSNAME_2 =
		"elementEntity.elementClassName = ? AND ";

	private static final String _FINDER_COLUMN_S_E_L_ELEMENTCLASSNAME_3 =
		"(elementEntity.elementClassName IS NULL OR elementEntity.elementClassName = '') AND ";

	private static final String _FINDER_COLUMN_S_E_L_LABEL_2 =
		"elementEntity.label = ?";

	private static final String _FINDER_COLUMN_S_E_L_LABEL_3 =
		"(elementEntity.label IS NULL OR elementEntity.label = '')";

	private FinderPath _finderPathWithPaginationFindByE_L;
	private FinderPath _finderPathWithoutPaginationFindByE_L;
	private FinderPath _finderPathCountByE_L;

	/**
	 * Returns all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label) {

		return findByE_L(
			elementOriginalId, elementClassName, label, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end) {

		return findByE_L(
			elementOriginalId, elementClassName, label, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findByE_L(
			elementOriginalId, elementClassName, label, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByE_L(
		String elementOriginalId, String elementClassName, String label,
		int start, int end, OrderByComparator<ElementEntity> orderByComparator,
		boolean useFinderCache) {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");
		label = Objects.toString(label, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByE_L;
				finderArgs = new Object[] {
					elementOriginalId, elementClassName, label
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByE_L;
			finderArgs = new Object[] {
				elementOriginalId, elementClassName, label, start, end,
				orderByComparator
			};
		}

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if (!elementOriginalId.equals(
							elementEntity.getElementOriginalId()) ||
						!elementClassName.equals(
							elementEntity.getElementClassName()) ||
						!label.equals(elementEntity.getLabel())) {

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

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

			boolean bindElementOriginalId = false;

			if (elementOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_L_ELEMENTORIGINALID_3);
			}
			else {
				bindElementOriginalId = true;

				sb.append(_FINDER_COLUMN_E_L_ELEMENTORIGINALID_2);
			}

			boolean bindElementClassName = false;

			if (elementClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_L_ELEMENTCLASSNAME_3);
			}
			else {
				bindElementClassName = true;

				sb.append(_FINDER_COLUMN_E_L_ELEMENTCLASSNAME_2);
			}

			boolean bindLabel = false;

			if (label.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_L_LABEL_3);
			}
			else {
				bindLabel = true;

				sb.append(_FINDER_COLUMN_E_L_LABEL_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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

				if (bindLabel) {
					queryPos.add(label);
				}

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByE_L_First(
			String elementOriginalId, String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByE_L_First(
			elementOriginalId, elementClassName, label, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append(", label=");
		sb.append(label);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByE_L_First(
		String elementOriginalId, String elementClassName, String label,
		OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findByE_L(
			elementOriginalId, elementClassName, label, 0, 1,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByE_L_Last(
			String elementOriginalId, String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByE_L_Last(
			elementOriginalId, elementClassName, label, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append(", label=");
		sb.append(label);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByE_L_Last(
		String elementOriginalId, String elementClassName, String label,
		OrderByComparator<ElementEntity> orderByComparator) {

		int count = countByE_L(elementOriginalId, elementClassName, label);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findByE_L(
			elementOriginalId, elementClassName, label, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findByE_L_PrevAndNext(
			long elementEntityId, String elementOriginalId,
			String elementClassName, String label,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");
		label = Objects.toString(label, "");

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getByE_L_PrevAndNext(
				session, elementEntity, elementOriginalId, elementClassName,
				label, orderByComparator, true);

			array[1] = elementEntity;

			array[2] = getByE_L_PrevAndNext(
				session, elementEntity, elementOriginalId, elementClassName,
				label, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ElementEntity getByE_L_PrevAndNext(
		Session session, ElementEntity elementEntity, String elementOriginalId,
		String elementClassName, String label,
		OrderByComparator<ElementEntity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

		boolean bindElementOriginalId = false;

		if (elementOriginalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_E_L_ELEMENTORIGINALID_3);
		}
		else {
			bindElementOriginalId = true;

			sb.append(_FINDER_COLUMN_E_L_ELEMENTORIGINALID_2);
		}

		boolean bindElementClassName = false;

		if (elementClassName.isEmpty()) {
			sb.append(_FINDER_COLUMN_E_L_ELEMENTCLASSNAME_3);
		}
		else {
			bindElementClassName = true;

			sb.append(_FINDER_COLUMN_E_L_ELEMENTCLASSNAME_2);
		}

		boolean bindLabel = false;

		if (label.isEmpty()) {
			sb.append(_FINDER_COLUMN_E_L_LABEL_3);
		}
		else {
			bindLabel = true;

			sb.append(_FINDER_COLUMN_E_L_LABEL_2);
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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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

		if (bindLabel) {
			queryPos.add(label);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 */
	@Override
	public void removeByE_L(
		String elementOriginalId, String elementClassName, String label) {

		for (ElementEntity elementEntity :
				findByE_L(
					elementOriginalId, elementClassName, label,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where elementOriginalId = &#63; and elementClassName = &#63; and label = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param label the label
	 * @return the number of matching element entities
	 */
	@Override
	public int countByE_L(
		String elementOriginalId, String elementClassName, String label) {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");
		label = Objects.toString(label, "");

		FinderPath finderPath = _finderPathCountByE_L;

		Object[] finderArgs = new Object[] {
			elementOriginalId, elementClassName, label
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

			boolean bindElementOriginalId = false;

			if (elementOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_L_ELEMENTORIGINALID_3);
			}
			else {
				bindElementOriginalId = true;

				sb.append(_FINDER_COLUMN_E_L_ELEMENTORIGINALID_2);
			}

			boolean bindElementClassName = false;

			if (elementClassName.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_L_ELEMENTCLASSNAME_3);
			}
			else {
				bindElementClassName = true;

				sb.append(_FINDER_COLUMN_E_L_ELEMENTCLASSNAME_2);
			}

			boolean bindLabel = false;

			if (label.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_L_LABEL_3);
			}
			else {
				bindLabel = true;

				sb.append(_FINDER_COLUMN_E_L_LABEL_2);
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

				if (bindLabel) {
					queryPos.add(label);
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

	private static final String _FINDER_COLUMN_E_L_ELEMENTORIGINALID_2 =
		"elementEntity.elementOriginalId = ? AND ";

	private static final String _FINDER_COLUMN_E_L_ELEMENTORIGINALID_3 =
		"(elementEntity.elementOriginalId IS NULL OR elementEntity.elementOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_E_L_ELEMENTCLASSNAME_2 =
		"elementEntity.elementClassName = ? AND ";

	private static final String _FINDER_COLUMN_E_L_ELEMENTCLASSNAME_3 =
		"(elementEntity.elementClassName IS NULL OR elementEntity.elementClassName = '') AND ";

	private static final String _FINDER_COLUMN_E_L_LABEL_2 =
		"elementEntity.label = ?";

	private static final String _FINDER_COLUMN_E_L_LABEL_3 =
		"(elementEntity.label IS NULL OR elementEntity.label = '')";

	private FinderPath _finderPathWithPaginationFindByElement;
	private FinderPath _finderPathWithoutPaginationFindByElement;
	private FinderPath _finderPathCountByElement;

	/**
	 * Returns all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName) {

		return findByElement(
			elementOriginalId, elementClassName, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end) {

		return findByElement(
			elementOriginalId, elementClassName, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findByElement(
			elementOriginalId, elementClassName, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findByElement(
		String elementOriginalId, String elementClassName, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
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

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if (!elementOriginalId.equals(
							elementEntity.getElementOriginalId()) ||
						!elementClassName.equals(
							elementEntity.getElementClassName())) {

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

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByElement_First(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByElement_First(
			elementOriginalId, elementClassName, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByElement_First(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findByElement(
			elementOriginalId, elementClassName, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findByElement_Last(
			String elementOriginalId, String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByElement_Last(
			elementOriginalId, elementClassName, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("elementOriginalId=");
		sb.append(elementOriginalId);

		sb.append(", elementClassName=");
		sb.append(elementClassName);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchByElement_Last(
		String elementOriginalId, String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator) {

		int count = countByElement(elementOriginalId, elementClassName);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findByElement(
			elementOriginalId, elementClassName, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findByElement_PrevAndNext(
			long elementEntityId, String elementOriginalId,
			String elementClassName,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		elementOriginalId = Objects.toString(elementOriginalId, "");
		elementClassName = Objects.toString(elementClassName, "");

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getByElement_PrevAndNext(
				session, elementEntity, elementOriginalId, elementClassName,
				orderByComparator, true);

			array[1] = elementEntity;

			array[2] = getByElement_PrevAndNext(
				session, elementEntity, elementOriginalId, elementClassName,
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

	protected ElementEntity getByElement_PrevAndNext(
		Session session, ElementEntity elementEntity, String elementOriginalId,
		String elementClassName,
		OrderByComparator<ElementEntity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where elementOriginalId = &#63; and elementClassName = &#63; from the database.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 */
	@Override
	public void removeByElement(
		String elementOriginalId, String elementClassName) {

		for (ElementEntity elementEntity :
				findByElement(
					elementOriginalId, elementClassName, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where elementOriginalId = &#63; and elementClassName = &#63;.
	 *
	 * @param elementOriginalId the element original ID
	 * @param elementClassName the element class name
	 * @return the number of matching element entities
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

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

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
		"elementEntity.elementOriginalId = ? AND ";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTORIGINALID_3 =
		"(elementEntity.elementOriginalId IS NULL OR elementEntity.elementOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_2 =
		"elementEntity.elementClassName = ?";

	private static final String _FINDER_COLUMN_ELEMENT_ELEMENTCLASSNAME_3 =
		"(elementEntity.elementClassName IS NULL OR elementEntity.elementClassName = '')";

	private FinderPath _finderPathWithPaginationFindBySubscriptionId;
	private FinderPath _finderPathWithoutPaginationFindBySubscriptionId;
	private FinderPath _finderPathCountBySubscriptionId;

	/**
	 * Returns all the element entities where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching element entities
	 */
	@Override
	public List<ElementEntity> findBySubscriptionId(long subscriptionId) {
		return findBySubscriptionId(
			subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of matching element entities
	 */
	@Override
	public List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return findBySubscriptionId(subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching element entities
	 */
	@Override
	public List<ElementEntity> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ElementEntity> orderByComparator,
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

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ElementEntity elementEntity : list) {
					if (subscriptionId != elementEntity.getSubscriptionId()) {
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

			sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

			sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Returns the first element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the first element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ElementEntity> orderByComparator) {

		List<ElementEntity> list = findBySubscriptionId(
			subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity
	 * @throws NoSuchElementEntityException if a matching element entity could not be found
	 */
	@Override
	public ElementEntity findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);

		if (elementEntity != null) {
			return elementEntity;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchElementEntityException(sb.toString());
	}

	/**
	 * Returns the last element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching element entity, or <code>null</code> if a matching element entity could not be found
	 */
	@Override
	public ElementEntity fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ElementEntity> orderByComparator) {

		int count = countBySubscriptionId(subscriptionId);

		if (count == 0) {
			return null;
		}

		List<ElementEntity> list = findBySubscriptionId(
			subscriptionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the element entities before and after the current element entity in the ordered set where subscriptionId = &#63;.
	 *
	 * @param elementEntityId the primary key of the current element entity
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity[] findBySubscriptionId_PrevAndNext(
			long elementEntityId, long subscriptionId,
			OrderByComparator<ElementEntity> orderByComparator)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = findByPrimaryKey(elementEntityId);

		Session session = null;

		try {
			session = openSession();

			ElementEntity[] array = new ElementEntityImpl[3];

			array[0] = getBySubscriptionId_PrevAndNext(
				session, elementEntity, subscriptionId, orderByComparator,
				true);

			array[1] = elementEntity;

			array[2] = getBySubscriptionId_PrevAndNext(
				session, elementEntity, subscriptionId, orderByComparator,
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

	protected ElementEntity getBySubscriptionId_PrevAndNext(
		Session session, ElementEntity elementEntity, long subscriptionId,
		OrderByComparator<ElementEntity> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELEMENTENTITY_WHERE);

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
			sb.append(ElementEntityModelImpl.ORDER_BY_JPQL);
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
						elementEntity)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ElementEntity> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the element entities where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeBySubscriptionId(long subscriptionId) {
		for (ElementEntity elementEntity :
				findBySubscriptionId(
					subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching element entities
	 */
	@Override
	public int countBySubscriptionId(long subscriptionId) {
		FinderPath finderPath = _finderPathCountBySubscriptionId;

		Object[] finderArgs = new Object[] {subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELEMENTENTITY_WHERE);

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
		"elementEntity.subscriptionId = ?";

	public ElementEntityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ElementEntity.class);

		setModelImplClass(ElementEntityImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the element entity in the entity cache if it is enabled.
	 *
	 * @param elementEntity the element entity
	 */
	@Override
	public void cacheResult(ElementEntity elementEntity) {
		entityCache.putResult(
			ElementEntityImpl.class, elementEntity.getPrimaryKey(),
			elementEntity);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {elementEntity.getUuid(), elementEntity.getGroupId()},
			elementEntity);
	}

	/**
	 * Caches the element entities in the entity cache if it is enabled.
	 *
	 * @param elementEntities the element entities
	 */
	@Override
	public void cacheResult(List<ElementEntity> elementEntities) {
		for (ElementEntity elementEntity : elementEntities) {
			if (entityCache.getResult(
					ElementEntityImpl.class, elementEntity.getPrimaryKey()) ==
						null) {

				cacheResult(elementEntity);
			}
		}
	}

	/**
	 * Clears the cache for all element entities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElementEntityImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the element entity.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ElementEntity elementEntity) {
		entityCache.removeResult(ElementEntityImpl.class, elementEntity);
	}

	@Override
	public void clearCache(List<ElementEntity> elementEntities) {
		for (ElementEntity elementEntity : elementEntities) {
			entityCache.removeResult(ElementEntityImpl.class, elementEntity);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElementEntityImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ElementEntityModelImpl elementEntityModelImpl) {

		Object[] args = new Object[] {
			elementEntityModelImpl.getUuid(),
			elementEntityModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, elementEntityModelImpl, false);
	}

	/**
	 * Creates a new element entity with the primary key. Does not add the element entity to the database.
	 *
	 * @param elementEntityId the primary key for the new element entity
	 * @return the new element entity
	 */
	@Override
	public ElementEntity create(long elementEntityId) {
		ElementEntity elementEntity = new ElementEntityImpl();

		elementEntity.setNew(true);
		elementEntity.setPrimaryKey(elementEntityId);

		String uuid = PortalUUIDUtil.generate();

		elementEntity.setUuid(uuid);

		elementEntity.setCompanyId(CompanyThreadLocal.getCompanyId());

		return elementEntity;
	}

	/**
	 * Removes the element entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity that was removed
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity remove(long elementEntityId)
		throws NoSuchElementEntityException {

		return remove((Serializable)elementEntityId);
	}

	/**
	 * Removes the element entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the element entity
	 * @return the element entity that was removed
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity remove(Serializable primaryKey)
		throws NoSuchElementEntityException {

		Session session = null;

		try {
			session = openSession();

			ElementEntity elementEntity = (ElementEntity)session.get(
				ElementEntityImpl.class, primaryKey);

			if (elementEntity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElementEntityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(elementEntity);
		}
		catch (NoSuchElementEntityException noSuchEntityException) {
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
	protected ElementEntity removeImpl(ElementEntity elementEntity) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(elementEntity)) {
				elementEntity = (ElementEntity)session.get(
					ElementEntityImpl.class, elementEntity.getPrimaryKeyObj());
			}

			if (elementEntity != null) {
				session.delete(elementEntity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (elementEntity != null) {
			clearCache(elementEntity);
		}

		return elementEntity;
	}

	@Override
	public ElementEntity updateImpl(ElementEntity elementEntity) {
		boolean isNew = elementEntity.isNew();

		if (!(elementEntity instanceof ElementEntityModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(elementEntity.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					elementEntity);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in elementEntity proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ElementEntity implementation " +
					elementEntity.getClass());
		}

		ElementEntityModelImpl elementEntityModelImpl =
			(ElementEntityModelImpl)elementEntity;

		if (Validator.isNull(elementEntity.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			elementEntity.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (elementEntity.getCreateDate() == null)) {
			if (serviceContext == null) {
				elementEntity.setCreateDate(now);
			}
			else {
				elementEntity.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!elementEntityModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				elementEntity.setModifiedDate(now);
			}
			else {
				elementEntity.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(elementEntity);
			}
			else {
				elementEntity = (ElementEntity)session.merge(elementEntity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ElementEntityImpl.class, elementEntityModelImpl, false, true);

		cacheUniqueFindersCache(elementEntityModelImpl);

		if (isNew) {
			elementEntity.setNew(false);
		}

		elementEntity.resetOriginalValues();

		return elementEntity;
	}

	/**
	 * Returns the element entity with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the element entity
	 * @return the element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElementEntityException {

		ElementEntity elementEntity = fetchByPrimaryKey(primaryKey);

		if (elementEntity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElementEntityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return elementEntity;
	}

	/**
	 * Returns the element entity with the primary key or throws a <code>NoSuchElementEntityException</code> if it could not be found.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity
	 * @throws NoSuchElementEntityException if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity findByPrimaryKey(long elementEntityId)
		throws NoSuchElementEntityException {

		return findByPrimaryKey((Serializable)elementEntityId);
	}

	/**
	 * Returns the element entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param elementEntityId the primary key of the element entity
	 * @return the element entity, or <code>null</code> if a element entity with the primary key could not be found
	 */
	@Override
	public ElementEntity fetchByPrimaryKey(long elementEntityId) {
		return fetchByPrimaryKey((Serializable)elementEntityId);
	}

	/**
	 * Returns all the element entities.
	 *
	 * @return the element entities
	 */
	@Override
	public List<ElementEntity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the element entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @return the range of element entities
	 */
	@Override
	public List<ElementEntity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the element entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of element entities
	 */
	@Override
	public List<ElementEntity> findAll(
		int start, int end,
		OrderByComparator<ElementEntity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the element entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElementEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of element entities
	 * @param end the upper bound of the range of element entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of element entities
	 */
	@Override
	public List<ElementEntity> findAll(
		int start, int end, OrderByComparator<ElementEntity> orderByComparator,
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

		List<ElementEntity> list = null;

		if (useFinderCache) {
			list = (List<ElementEntity>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELEMENTENTITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELEMENTENTITY;

				sql = sql.concat(ElementEntityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ElementEntity>)QueryUtil.list(
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
	 * Removes all the element entities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ElementEntity elementEntity : findAll()) {
			remove(elementEntity);
		}
	}

	/**
	 * Returns the number of element entities.
	 *
	 * @return the number of element entities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELEMENTENTITY);

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
		return "elementEntityId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELEMENTENTITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElementEntityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the element entity persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ElementEntityModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ElementEntity.class.getName()));

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

		_finderPathWithPaginationFindByS_E_L = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS_E_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {
				"subscriptionId", "elementOriginalId", "elementClassName",
				"label"
			},
			true);

		_finderPathWithoutPaginationFindByS_E_L = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS_E_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"subscriptionId", "elementOriginalId", "elementClassName",
				"label"
			},
			true);

		_finderPathCountByS_E_L = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS_E_L",
			new String[] {
				Long.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"subscriptionId", "elementOriginalId", "elementClassName",
				"label"
			},
			false);

		_finderPathWithPaginationFindByE_L = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByE_L",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"elementOriginalId", "elementClassName", "label"},
			true);

		_finderPathWithoutPaginationFindByE_L = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByE_L",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"elementOriginalId", "elementClassName", "label"},
			true);

		_finderPathCountByE_L = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_L",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"elementOriginalId", "elementClassName", "label"},
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
		entityCache.removeCache(ElementEntityImpl.class.getName());

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

	private static final String _SQL_SELECT_ELEMENTENTITY =
		"SELECT elementEntity FROM ElementEntity elementEntity";

	private static final String _SQL_SELECT_ELEMENTENTITY_WHERE =
		"SELECT elementEntity FROM ElementEntity elementEntity WHERE ";

	private static final String _SQL_COUNT_ELEMENTENTITY =
		"SELECT COUNT(elementEntity) FROM ElementEntity elementEntity";

	private static final String _SQL_COUNT_ELEMENTENTITY_WHERE =
		"SELECT COUNT(elementEntity) FROM ElementEntity elementEntity WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "elementEntity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ElementEntity exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ElementEntity exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ElementEntityPersistenceImpl.class);

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

	private static class ElementEntityModelArgumentsResolver
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

			ElementEntityModelImpl elementEntityModelImpl =
				(ElementEntityModelImpl)baseModel;

			long columnBitmask = elementEntityModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(elementEntityModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						elementEntityModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(elementEntityModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ElementEntityModelImpl elementEntityModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						elementEntityModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = elementEntityModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}