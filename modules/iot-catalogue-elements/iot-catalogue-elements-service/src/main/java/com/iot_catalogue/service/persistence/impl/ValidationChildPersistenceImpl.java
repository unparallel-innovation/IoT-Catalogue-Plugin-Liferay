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

import com.iot_catalogue.exception.NoSuchValidationChildException;
import com.iot_catalogue.model.ValidationChild;
import com.iot_catalogue.model.impl.ValidationChildImpl;
import com.iot_catalogue.model.impl.ValidationChildModelImpl;
import com.iot_catalogue.service.persistence.ValidationChildPersistence;
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
 * The persistence implementation for the validation child service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ValidationChildPersistence.class)
public class ValidationChildPersistenceImpl
	extends BasePersistenceImpl<ValidationChild>
	implements ValidationChildPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ValidationChildUtil</code> to access the validation child persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ValidationChildImpl.class.getName();

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
	 * Returns all the validation childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching validation childs
	 */
	@Override
	public List<ValidationChild> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the validation childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the validation childs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
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

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValidationChild validationChild : list) {
					if (!uuid.equals(validationChild.getUuid())) {
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

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

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
				sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
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

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Returns the first validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByUuid_First(
			String uuid, OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByUuid_First(
			uuid, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByUuid_First(
		String uuid, OrderByComparator<ValidationChild> orderByComparator) {

		List<ValidationChild> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByUuid_Last(
			String uuid, OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByUuid_Last(
			uuid, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByUuid_Last(
		String uuid, OrderByComparator<ValidationChild> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ValidationChild> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where uuid = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild[] findByUuid_PrevAndNext(
			long id, String uuid,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		uuid = Objects.toString(uuid, "");

		ValidationChild validationChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValidationChild[] array = new ValidationChildImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, validationChild, uuid, orderByComparator, true);

			array[1] = validationChild;

			array[2] = getByUuid_PrevAndNext(
				session, validationChild, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ValidationChild getByUuid_PrevAndNext(
		Session session, ValidationChild validationChild, String uuid,
		OrderByComparator<ValidationChild> orderByComparator,
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

		sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

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
			sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
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
						validationChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValidationChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the validation childs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ValidationChild validationChild :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching validation childs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

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
		"validationChild.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(validationChild.uuid IS NULL OR validationChild.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchValidationChildException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByUUID_G(String uuid, long groupId)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByUUID_G(uuid, groupId);

		if (validationChild == null) {
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

			throw new NoSuchValidationChildException(sb.toString());
		}

		return validationChild;
	}

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the validation child where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByUUID_G(
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

		if (result instanceof ValidationChild) {
			ValidationChild validationChild = (ValidationChild)result;

			if (!Objects.equals(uuid, validationChild.getUuid()) ||
				(groupId != validationChild.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

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

				List<ValidationChild> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ValidationChild validationChild = list.get(0);

					result = validationChild;

					cacheResult(validationChild);
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
			return (ValidationChild)result;
		}
	}

	/**
	 * Removes the validation child where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the validation child that was removed
	 */
	@Override
	public ValidationChild removeByUUID_G(String uuid, long groupId)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = findByUUID_G(uuid, groupId);

		return remove(validationChild);
	}

	/**
	 * Returns the number of validation childs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching validation childs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

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
		"validationChild.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(validationChild.uuid IS NULL OR validationChild.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"validationChild.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching validation childs
	 */
	@Override
	public List<ValidationChild> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
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

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValidationChild validationChild : list) {
					if (!uuid.equals(validationChild.getUuid()) ||
						(companyId != validationChild.getCompanyId())) {

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

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

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
				sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
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

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Returns the first validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the first validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ValidationChild> orderByComparator) {

		List<ValidationChild> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the last validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ValidationChild> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ValidationChild> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild[] findByUuid_C_PrevAndNext(
			long id, String uuid, long companyId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		uuid = Objects.toString(uuid, "");

		ValidationChild validationChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValidationChild[] array = new ValidationChildImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, validationChild, uuid, companyId, orderByComparator,
				true);

			array[1] = validationChild;

			array[2] = getByUuid_C_PrevAndNext(
				session, validationChild, uuid, companyId, orderByComparator,
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

	protected ValidationChild getByUuid_C_PrevAndNext(
		Session session, ValidationChild validationChild, String uuid,
		long companyId, OrderByComparator<ValidationChild> orderByComparator,
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

		sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

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
			sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
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
						validationChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValidationChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the validation childs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ValidationChild validationChild :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching validation childs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

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
		"validationChild.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(validationChild.uuid IS NULL OR validationChild.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"validationChild.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the validation childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching validation childs
	 */
	@Override
	public List<ValidationChild> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the validation childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByGroupId(
		long groupId, int start, int end) {

		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the validation childs where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
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

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValidationChild validationChild : list) {
					if (groupId != validationChild.getGroupId()) {
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

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Returns the first validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByGroupId_First(
			long groupId, OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByGroupId_First(
			groupId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the first validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByGroupId_First(
		long groupId, OrderByComparator<ValidationChild> orderByComparator) {

		List<ValidationChild> list = findByGroupId(
			groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByGroupId_Last(
			long groupId, OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByGroupId_Last(
			groupId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the last validation child in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByGroupId_Last(
		long groupId, OrderByComparator<ValidationChild> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<ValidationChild> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where groupId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild[] findByGroupId_PrevAndNext(
			long id, long groupId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValidationChild[] array = new ValidationChildImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, validationChild, groupId, orderByComparator, true);

			array[1] = validationChild;

			array[2] = getByGroupId_PrevAndNext(
				session, validationChild, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ValidationChild getByGroupId_PrevAndNext(
		Session session, ValidationChild validationChild, long groupId,
		OrderByComparator<ValidationChild> orderByComparator,
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

		sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

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
			sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
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
						validationChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValidationChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the validation childs where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (ValidationChild validationChild :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching validation childs
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

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
		"validationChild.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByValidationOrignalId;
	private FinderPath _finderPathWithoutPaginationFindByValidationOrignalId;
	private FinderPath _finderPathCountByValidationOrignalId;

	/**
	 * Returns all the validation childs where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @return the matching validation childs
	 */
	@Override
	public List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId) {

		return findByValidationOrignalId(
			validationOrignalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the validation childs where validationOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end) {

		return findByValidationOrignalId(validationOrignalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs where validationOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return findByValidationOrignalId(
			validationOrignalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the validation childs where validationOrignalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByValidationOrignalId(
		String validationOrignalId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		validationOrignalId = Objects.toString(validationOrignalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByValidationOrignalId;
				finderArgs = new Object[] {validationOrignalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByValidationOrignalId;
			finderArgs = new Object[] {
				validationOrignalId, start, end, orderByComparator
			};
		}

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValidationChild validationChild : list) {
					if (!validationOrignalId.equals(
							validationChild.getValidationOrignalId())) {

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

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

			boolean bindValidationOrignalId = false;

			if (validationOrignalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_VALIDATIONORIGNALID_VALIDATIONORIGNALID_3);
			}
			else {
				bindValidationOrignalId = true;

				sb.append(
					_FINDER_COLUMN_VALIDATIONORIGNALID_VALIDATIONORIGNALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindValidationOrignalId) {
					queryPos.add(validationOrignalId);
				}

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByValidationOrignalId_First(
			String validationOrignalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByValidationOrignalId_First(
			validationOrignalId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("validationOrignalId=");
		sb.append(validationOrignalId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByValidationOrignalId_First(
		String validationOrignalId,
		OrderByComparator<ValidationChild> orderByComparator) {

		List<ValidationChild> list = findByValidationOrignalId(
			validationOrignalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByValidationOrignalId_Last(
			String validationOrignalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByValidationOrignalId_Last(
			validationOrignalId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("validationOrignalId=");
		sb.append(validationOrignalId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByValidationOrignalId_Last(
		String validationOrignalId,
		OrderByComparator<ValidationChild> orderByComparator) {

		int count = countByValidationOrignalId(validationOrignalId);

		if (count == 0) {
			return null;
		}

		List<ValidationChild> list = findByValidationOrignalId(
			validationOrignalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where validationOrignalId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param validationOrignalId the validation orignal ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild[] findByValidationOrignalId_PrevAndNext(
			long id, String validationOrignalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		validationOrignalId = Objects.toString(validationOrignalId, "");

		ValidationChild validationChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValidationChild[] array = new ValidationChildImpl[3];

			array[0] = getByValidationOrignalId_PrevAndNext(
				session, validationChild, validationOrignalId,
				orderByComparator, true);

			array[1] = validationChild;

			array[2] = getByValidationOrignalId_PrevAndNext(
				session, validationChild, validationOrignalId,
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

	protected ValidationChild getByValidationOrignalId_PrevAndNext(
		Session session, ValidationChild validationChild,
		String validationOrignalId,
		OrderByComparator<ValidationChild> orderByComparator,
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

		sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

		boolean bindValidationOrignalId = false;

		if (validationOrignalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_VALIDATIONORIGNALID_VALIDATIONORIGNALID_3);
		}
		else {
			bindValidationOrignalId = true;

			sb.append(_FINDER_COLUMN_VALIDATIONORIGNALID_VALIDATIONORIGNALID_2);
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
			sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindValidationOrignalId) {
			queryPos.add(validationOrignalId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						validationChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValidationChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the validation childs where validationOrignalId = &#63; from the database.
	 *
	 * @param validationOrignalId the validation orignal ID
	 */
	@Override
	public void removeByValidationOrignalId(String validationOrignalId) {
		for (ValidationChild validationChild :
				findByValidationOrignalId(
					validationOrignalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs where validationOrignalId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @return the number of matching validation childs
	 */
	@Override
	public int countByValidationOrignalId(String validationOrignalId) {
		validationOrignalId = Objects.toString(validationOrignalId, "");

		FinderPath finderPath = _finderPathCountByValidationOrignalId;

		Object[] finderArgs = new Object[] {validationOrignalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

			boolean bindValidationOrignalId = false;

			if (validationOrignalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_VALIDATIONORIGNALID_VALIDATIONORIGNALID_3);
			}
			else {
				bindValidationOrignalId = true;

				sb.append(
					_FINDER_COLUMN_VALIDATIONORIGNALID_VALIDATIONORIGNALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindValidationOrignalId) {
					queryPos.add(validationOrignalId);
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
		_FINDER_COLUMN_VALIDATIONORIGNALID_VALIDATIONORIGNALID_2 =
			"validationChild.validationOrignalId = ?";

	private static final String
		_FINDER_COLUMN_VALIDATIONORIGNALID_VALIDATIONORIGNALID_3 =
			"(validationChild.validationOrignalId IS NULL OR validationChild.validationOrignalId = '')";

	private FinderPath _finderPathWithPaginationFindByVOID_S;
	private FinderPath _finderPathWithoutPaginationFindByVOID_S;
	private FinderPath _finderPathCountByVOID_S;

	/**
	 * Returns all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @return the matching validation childs
	 */
	@Override
	public List<ValidationChild> findByVOID_S(
		String validationOrignalId, long subscriptionId) {

		return findByVOID_S(
			validationOrignalId, subscriptionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByVOID_S(
		String validationOrignalId, long subscriptionId, int start, int end) {

		return findByVOID_S(
			validationOrignalId, subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByVOID_S(
		String validationOrignalId, long subscriptionId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return findByVOID_S(
			validationOrignalId, subscriptionId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByVOID_S(
		String validationOrignalId, long subscriptionId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		validationOrignalId = Objects.toString(validationOrignalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByVOID_S;
				finderArgs = new Object[] {validationOrignalId, subscriptionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByVOID_S;
			finderArgs = new Object[] {
				validationOrignalId, subscriptionId, start, end,
				orderByComparator
			};
		}

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValidationChild validationChild : list) {
					if (!validationOrignalId.equals(
							validationChild.getValidationOrignalId()) ||
						(subscriptionId !=
							validationChild.getSubscriptionId())) {

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

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

			boolean bindValidationOrignalId = false;

			if (validationOrignalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_VOID_S_VALIDATIONORIGNALID_3);
			}
			else {
				bindValidationOrignalId = true;

				sb.append(_FINDER_COLUMN_VOID_S_VALIDATIONORIGNALID_2);
			}

			sb.append(_FINDER_COLUMN_VOID_S_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindValidationOrignalId) {
					queryPos.add(validationOrignalId);
				}

				queryPos.add(subscriptionId);

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByVOID_S_First(
			String validationOrignalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByVOID_S_First(
			validationOrignalId, subscriptionId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("validationOrignalId=");
		sb.append(validationOrignalId);

		sb.append(", subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the first validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByVOID_S_First(
		String validationOrignalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		List<ValidationChild> list = findByVOID_S(
			validationOrignalId, subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByVOID_S_Last(
			String validationOrignalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByVOID_S_Last(
			validationOrignalId, subscriptionId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("validationOrignalId=");
		sb.append(validationOrignalId);

		sb.append(", subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the last validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByVOID_S_Last(
		String validationOrignalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		int count = countByVOID_S(validationOrignalId, subscriptionId);

		if (count == 0) {
			return null;
		}

		List<ValidationChild> list = findByVOID_S(
			validationOrignalId, subscriptionId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild[] findByVOID_S_PrevAndNext(
			long id, String validationOrignalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		validationOrignalId = Objects.toString(validationOrignalId, "");

		ValidationChild validationChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValidationChild[] array = new ValidationChildImpl[3];

			array[0] = getByVOID_S_PrevAndNext(
				session, validationChild, validationOrignalId, subscriptionId,
				orderByComparator, true);

			array[1] = validationChild;

			array[2] = getByVOID_S_PrevAndNext(
				session, validationChild, validationOrignalId, subscriptionId,
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

	protected ValidationChild getByVOID_S_PrevAndNext(
		Session session, ValidationChild validationChild,
		String validationOrignalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator,
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

		sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

		boolean bindValidationOrignalId = false;

		if (validationOrignalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_VOID_S_VALIDATIONORIGNALID_3);
		}
		else {
			bindValidationOrignalId = true;

			sb.append(_FINDER_COLUMN_VOID_S_VALIDATIONORIGNALID_2);
		}

		sb.append(_FINDER_COLUMN_VOID_S_SUBSCRIPTIONID_2);

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
			sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindValidationOrignalId) {
			queryPos.add(validationOrignalId);
		}

		queryPos.add(subscriptionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						validationChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValidationChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the validation childs where validationOrignalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeByVOID_S(
		String validationOrignalId, long subscriptionId) {

		for (ValidationChild validationChild :
				findByVOID_S(
					validationOrignalId, subscriptionId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs where validationOrignalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param validationOrignalId the validation orignal ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching validation childs
	 */
	@Override
	public int countByVOID_S(String validationOrignalId, long subscriptionId) {
		validationOrignalId = Objects.toString(validationOrignalId, "");

		FinderPath finderPath = _finderPathCountByVOID_S;

		Object[] finderArgs = new Object[] {
			validationOrignalId, subscriptionId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

			boolean bindValidationOrignalId = false;

			if (validationOrignalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_VOID_S_VALIDATIONORIGNALID_3);
			}
			else {
				bindValidationOrignalId = true;

				sb.append(_FINDER_COLUMN_VOID_S_VALIDATIONORIGNALID_2);
			}

			sb.append(_FINDER_COLUMN_VOID_S_SUBSCRIPTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindValidationOrignalId) {
					queryPos.add(validationOrignalId);
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

	private static final String _FINDER_COLUMN_VOID_S_VALIDATIONORIGNALID_2 =
		"validationChild.validationOrignalId = ? AND ";

	private static final String _FINDER_COLUMN_VOID_S_VALIDATIONORIGNALID_3 =
		"(validationChild.validationOrignalId IS NULL OR validationChild.validationOrignalId = '') AND ";

	private static final String _FINDER_COLUMN_VOID_S_SUBSCRIPTIONID_2 =
		"validationChild.subscriptionId = ?";

	private FinderPath _finderPathWithPaginationFindByChildValidationOrignalId;
	private FinderPath
		_finderPathWithoutPaginationFindByChildValidationOrignalId;
	private FinderPath _finderPathCountByChildValidationOrignalId;

	/**
	 * Returns all the validation childs where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @return the matching validation childs
	 */
	@Override
	public List<ValidationChild> findByChildValidationOrignalId(
		String childValidationOriginalId) {

		return findByChildValidationOrignalId(
			childValidationOriginalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the validation childs where childValidationOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByChildValidationOrignalId(
		String childValidationOriginalId, int start, int end) {

		return findByChildValidationOrignalId(
			childValidationOriginalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs where childValidationOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByChildValidationOrignalId(
		String childValidationOriginalId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return findByChildValidationOrignalId(
			childValidationOriginalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the validation childs where childValidationOriginalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByChildValidationOrignalId(
		String childValidationOriginalId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		childValidationOriginalId = Objects.toString(
			childValidationOriginalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByChildValidationOrignalId;
				finderArgs = new Object[] {childValidationOriginalId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByChildValidationOrignalId;
			finderArgs = new Object[] {
				childValidationOriginalId, start, end, orderByComparator
			};
		}

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValidationChild validationChild : list) {
					if (!childValidationOriginalId.equals(
							validationChild.getChildValidationOriginalId())) {

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

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

			boolean bindChildValidationOriginalId = false;

			if (childValidationOriginalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CHILDVALIDATIONORIGNALID_CHILDVALIDATIONORIGINALID_3);
			}
			else {
				bindChildValidationOriginalId = true;

				sb.append(
					_FINDER_COLUMN_CHILDVALIDATIONORIGNALID_CHILDVALIDATIONORIGINALID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindChildValidationOriginalId) {
					queryPos.add(childValidationOriginalId);
				}

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Returns the first validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByChildValidationOrignalId_First(
			String childValidationOriginalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByChildValidationOrignalId_First(
			childValidationOriginalId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("childValidationOriginalId=");
		sb.append(childValidationOriginalId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the first validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByChildValidationOrignalId_First(
		String childValidationOriginalId,
		OrderByComparator<ValidationChild> orderByComparator) {

		List<ValidationChild> list = findByChildValidationOrignalId(
			childValidationOriginalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByChildValidationOrignalId_Last(
			String childValidationOriginalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByChildValidationOrignalId_Last(
			childValidationOriginalId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("childValidationOriginalId=");
		sb.append(childValidationOriginalId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the last validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByChildValidationOrignalId_Last(
		String childValidationOriginalId,
		OrderByComparator<ValidationChild> orderByComparator) {

		int count = countByChildValidationOrignalId(childValidationOriginalId);

		if (count == 0) {
			return null;
		}

		List<ValidationChild> list = findByChildValidationOrignalId(
			childValidationOriginalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where childValidationOriginalId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param childValidationOriginalId the child validation original ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild[] findByChildValidationOrignalId_PrevAndNext(
			long id, String childValidationOriginalId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		childValidationOriginalId = Objects.toString(
			childValidationOriginalId, "");

		ValidationChild validationChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValidationChild[] array = new ValidationChildImpl[3];

			array[0] = getByChildValidationOrignalId_PrevAndNext(
				session, validationChild, childValidationOriginalId,
				orderByComparator, true);

			array[1] = validationChild;

			array[2] = getByChildValidationOrignalId_PrevAndNext(
				session, validationChild, childValidationOriginalId,
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

	protected ValidationChild getByChildValidationOrignalId_PrevAndNext(
		Session session, ValidationChild validationChild,
		String childValidationOriginalId,
		OrderByComparator<ValidationChild> orderByComparator,
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

		sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

		boolean bindChildValidationOriginalId = false;

		if (childValidationOriginalId.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_CHILDVALIDATIONORIGNALID_CHILDVALIDATIONORIGINALID_3);
		}
		else {
			bindChildValidationOriginalId = true;

			sb.append(
				_FINDER_COLUMN_CHILDVALIDATIONORIGNALID_CHILDVALIDATIONORIGINALID_2);
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
			sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindChildValidationOriginalId) {
			queryPos.add(childValidationOriginalId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						validationChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValidationChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the validation childs where childValidationOriginalId = &#63; from the database.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 */
	@Override
	public void removeByChildValidationOrignalId(
		String childValidationOriginalId) {

		for (ValidationChild validationChild :
				findByChildValidationOrignalId(
					childValidationOriginalId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs where childValidationOriginalId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @return the number of matching validation childs
	 */
	@Override
	public int countByChildValidationOrignalId(
		String childValidationOriginalId) {

		childValidationOriginalId = Objects.toString(
			childValidationOriginalId, "");

		FinderPath finderPath = _finderPathCountByChildValidationOrignalId;

		Object[] finderArgs = new Object[] {childValidationOriginalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

			boolean bindChildValidationOriginalId = false;

			if (childValidationOriginalId.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_CHILDVALIDATIONORIGNALID_CHILDVALIDATIONORIGINALID_3);
			}
			else {
				bindChildValidationOriginalId = true;

				sb.append(
					_FINDER_COLUMN_CHILDVALIDATIONORIGNALID_CHILDVALIDATIONORIGINALID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindChildValidationOriginalId) {
					queryPos.add(childValidationOriginalId);
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
		_FINDER_COLUMN_CHILDVALIDATIONORIGNALID_CHILDVALIDATIONORIGINALID_2 =
			"validationChild.childValidationOriginalId = ?";

	private static final String
		_FINDER_COLUMN_CHILDVALIDATIONORIGNALID_CHILDVALIDATIONORIGINALID_3 =
			"(validationChild.childValidationOriginalId IS NULL OR validationChild.childValidationOriginalId = '')";

	private FinderPath _finderPathWithPaginationFindByCVOID_S;
	private FinderPath _finderPathWithoutPaginationFindByCVOID_S;
	private FinderPath _finderPathCountByCVOID_S;

	/**
	 * Returns all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @return the matching validation childs
	 */
	@Override
	public List<ValidationChild> findByCVOID_S(
		String childValidationOriginalId, long subscriptionId) {

		return findByCVOID_S(
			childValidationOriginalId, subscriptionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByCVOID_S(
		String childValidationOriginalId, long subscriptionId, int start,
		int end) {

		return findByCVOID_S(
			childValidationOriginalId, subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByCVOID_S(
		String childValidationOriginalId, long subscriptionId, int start,
		int end, OrderByComparator<ValidationChild> orderByComparator) {

		return findByCVOID_S(
			childValidationOriginalId, subscriptionId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findByCVOID_S(
		String childValidationOriginalId, long subscriptionId, int start,
		int end, OrderByComparator<ValidationChild> orderByComparator,
		boolean useFinderCache) {

		childValidationOriginalId = Objects.toString(
			childValidationOriginalId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCVOID_S;
				finderArgs = new Object[] {
					childValidationOriginalId, subscriptionId
				};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCVOID_S;
			finderArgs = new Object[] {
				childValidationOriginalId, subscriptionId, start, end,
				orderByComparator
			};
		}

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValidationChild validationChild : list) {
					if (!childValidationOriginalId.equals(
							validationChild.getChildValidationOriginalId()) ||
						(subscriptionId !=
							validationChild.getSubscriptionId())) {

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

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

			boolean bindChildValidationOriginalId = false;

			if (childValidationOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CVOID_S_CHILDVALIDATIONORIGINALID_3);
			}
			else {
				bindChildValidationOriginalId = true;

				sb.append(_FINDER_COLUMN_CVOID_S_CHILDVALIDATIONORIGINALID_2);
			}

			sb.append(_FINDER_COLUMN_CVOID_S_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindChildValidationOriginalId) {
					queryPos.add(childValidationOriginalId);
				}

				queryPos.add(subscriptionId);

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Returns the first validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByCVOID_S_First(
			String childValidationOriginalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByCVOID_S_First(
			childValidationOriginalId, subscriptionId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("childValidationOriginalId=");
		sb.append(childValidationOriginalId);

		sb.append(", subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the first validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByCVOID_S_First(
		String childValidationOriginalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		List<ValidationChild> list = findByCVOID_S(
			childValidationOriginalId, subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findByCVOID_S_Last(
			String childValidationOriginalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByCVOID_S_Last(
			childValidationOriginalId, subscriptionId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("childValidationOriginalId=");
		sb.append(childValidationOriginalId);

		sb.append(", subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the last validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchByCVOID_S_Last(
		String childValidationOriginalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		int count = countByCVOID_S(childValidationOriginalId, subscriptionId);

		if (count == 0) {
			return null;
		}

		List<ValidationChild> list = findByCVOID_S(
			childValidationOriginalId, subscriptionId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild[] findByCVOID_S_PrevAndNext(
			long id, String childValidationOriginalId, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		childValidationOriginalId = Objects.toString(
			childValidationOriginalId, "");

		ValidationChild validationChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValidationChild[] array = new ValidationChildImpl[3];

			array[0] = getByCVOID_S_PrevAndNext(
				session, validationChild, childValidationOriginalId,
				subscriptionId, orderByComparator, true);

			array[1] = validationChild;

			array[2] = getByCVOID_S_PrevAndNext(
				session, validationChild, childValidationOriginalId,
				subscriptionId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ValidationChild getByCVOID_S_PrevAndNext(
		Session session, ValidationChild validationChild,
		String childValidationOriginalId, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator,
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

		sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

		boolean bindChildValidationOriginalId = false;

		if (childValidationOriginalId.isEmpty()) {
			sb.append(_FINDER_COLUMN_CVOID_S_CHILDVALIDATIONORIGINALID_3);
		}
		else {
			bindChildValidationOriginalId = true;

			sb.append(_FINDER_COLUMN_CVOID_S_CHILDVALIDATIONORIGINALID_2);
		}

		sb.append(_FINDER_COLUMN_CVOID_S_SUBSCRIPTIONID_2);

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
			sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindChildValidationOriginalId) {
			queryPos.add(childValidationOriginalId);
		}

		queryPos.add(subscriptionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						validationChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValidationChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63; from the database.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeByCVOID_S(
		String childValidationOriginalId, long subscriptionId) {

		for (ValidationChild validationChild :
				findByCVOID_S(
					childValidationOriginalId, subscriptionId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs where childValidationOriginalId = &#63; and subscriptionId = &#63;.
	 *
	 * @param childValidationOriginalId the child validation original ID
	 * @param subscriptionId the subscription ID
	 * @return the number of matching validation childs
	 */
	@Override
	public int countByCVOID_S(
		String childValidationOriginalId, long subscriptionId) {

		childValidationOriginalId = Objects.toString(
			childValidationOriginalId, "");

		FinderPath finderPath = _finderPathCountByCVOID_S;

		Object[] finderArgs = new Object[] {
			childValidationOriginalId, subscriptionId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

			boolean bindChildValidationOriginalId = false;

			if (childValidationOriginalId.isEmpty()) {
				sb.append(_FINDER_COLUMN_CVOID_S_CHILDVALIDATIONORIGINALID_3);
			}
			else {
				bindChildValidationOriginalId = true;

				sb.append(_FINDER_COLUMN_CVOID_S_CHILDVALIDATIONORIGINALID_2);
			}

			sb.append(_FINDER_COLUMN_CVOID_S_SUBSCRIPTIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindChildValidationOriginalId) {
					queryPos.add(childValidationOriginalId);
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

	private static final String
		_FINDER_COLUMN_CVOID_S_CHILDVALIDATIONORIGINALID_2 =
			"validationChild.childValidationOriginalId = ? AND ";

	private static final String
		_FINDER_COLUMN_CVOID_S_CHILDVALIDATIONORIGINALID_3 =
			"(validationChild.childValidationOriginalId IS NULL OR validationChild.childValidationOriginalId = '') AND ";

	private static final String _FINDER_COLUMN_CVOID_S_SUBSCRIPTIONID_2 =
		"validationChild.subscriptionId = ?";

	private FinderPath _finderPathWithPaginationFindBySubscriptionId;
	private FinderPath _finderPathWithoutPaginationFindBySubscriptionId;
	private FinderPath _finderPathCountBySubscriptionId;

	/**
	 * Returns all the validation childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the matching validation childs
	 */
	@Override
	public List<ValidationChild> findBySubscriptionId(long subscriptionId) {
		return findBySubscriptionId(
			subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the validation childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end) {

		return findBySubscriptionId(subscriptionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return findBySubscriptionId(
			subscriptionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the validation childs where subscriptionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param subscriptionId the subscription ID
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching validation childs
	 */
	@Override
	public List<ValidationChild> findBySubscriptionId(
		long subscriptionId, int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
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

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ValidationChild validationChild : list) {
					if (subscriptionId != validationChild.getSubscriptionId()) {
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

			sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

			sb.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(subscriptionId);

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Returns the first validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findBySubscriptionId_First(
			long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchBySubscriptionId_First(
			subscriptionId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the first validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchBySubscriptionId_First(
		long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		List<ValidationChild> list = findBySubscriptionId(
			subscriptionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child
	 * @throws NoSuchValidationChildException if a matching validation child could not be found
	 */
	@Override
	public ValidationChild findBySubscriptionId_Last(
			long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchBySubscriptionId_Last(
			subscriptionId, orderByComparator);

		if (validationChild != null) {
			return validationChild;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("subscriptionId=");
		sb.append(subscriptionId);

		sb.append("}");

		throw new NoSuchValidationChildException(sb.toString());
	}

	/**
	 * Returns the last validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching validation child, or <code>null</code> if a matching validation child could not be found
	 */
	@Override
	public ValidationChild fetchBySubscriptionId_Last(
		long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator) {

		int count = countBySubscriptionId(subscriptionId);

		if (count == 0) {
			return null;
		}

		List<ValidationChild> list = findBySubscriptionId(
			subscriptionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the validation childs before and after the current validation child in the ordered set where subscriptionId = &#63;.
	 *
	 * @param id the primary key of the current validation child
	 * @param subscriptionId the subscription ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild[] findBySubscriptionId_PrevAndNext(
			long id, long subscriptionId,
			OrderByComparator<ValidationChild> orderByComparator)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			ValidationChild[] array = new ValidationChildImpl[3];

			array[0] = getBySubscriptionId_PrevAndNext(
				session, validationChild, subscriptionId, orderByComparator,
				true);

			array[1] = validationChild;

			array[2] = getBySubscriptionId_PrevAndNext(
				session, validationChild, subscriptionId, orderByComparator,
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

	protected ValidationChild getBySubscriptionId_PrevAndNext(
		Session session, ValidationChild validationChild, long subscriptionId,
		OrderByComparator<ValidationChild> orderByComparator,
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

		sb.append(_SQL_SELECT_VALIDATIONCHILD_WHERE);

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
			sb.append(ValidationChildModelImpl.ORDER_BY_JPQL);
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
						validationChild)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ValidationChild> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the validation childs where subscriptionId = &#63; from the database.
	 *
	 * @param subscriptionId the subscription ID
	 */
	@Override
	public void removeBySubscriptionId(long subscriptionId) {
		for (ValidationChild validationChild :
				findBySubscriptionId(
					subscriptionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs where subscriptionId = &#63;.
	 *
	 * @param subscriptionId the subscription ID
	 * @return the number of matching validation childs
	 */
	@Override
	public int countBySubscriptionId(long subscriptionId) {
		FinderPath finderPath = _finderPathCountBySubscriptionId;

		Object[] finderArgs = new Object[] {subscriptionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VALIDATIONCHILD_WHERE);

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
		"validationChild.subscriptionId = ?";

	public ValidationChildPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ValidationChild.class);

		setModelImplClass(ValidationChildImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the validation child in the entity cache if it is enabled.
	 *
	 * @param validationChild the validation child
	 */
	@Override
	public void cacheResult(ValidationChild validationChild) {
		entityCache.putResult(
			ValidationChildImpl.class, validationChild.getPrimaryKey(),
			validationChild);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				validationChild.getUuid(), validationChild.getGroupId()
			},
			validationChild);
	}

	/**
	 * Caches the validation childs in the entity cache if it is enabled.
	 *
	 * @param validationChilds the validation childs
	 */
	@Override
	public void cacheResult(List<ValidationChild> validationChilds) {
		for (ValidationChild validationChild : validationChilds) {
			if (entityCache.getResult(
					ValidationChildImpl.class,
					validationChild.getPrimaryKey()) == null) {

				cacheResult(validationChild);
			}
		}
	}

	/**
	 * Clears the cache for all validation childs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ValidationChildImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the validation child.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ValidationChild validationChild) {
		entityCache.removeResult(ValidationChildImpl.class, validationChild);
	}

	@Override
	public void clearCache(List<ValidationChild> validationChilds) {
		for (ValidationChild validationChild : validationChilds) {
			entityCache.removeResult(
				ValidationChildImpl.class, validationChild);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ValidationChildImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ValidationChildModelImpl validationChildModelImpl) {

		Object[] args = new Object[] {
			validationChildModelImpl.getUuid(),
			validationChildModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, validationChildModelImpl, false);
	}

	/**
	 * Creates a new validation child with the primary key. Does not add the validation child to the database.
	 *
	 * @param id the primary key for the new validation child
	 * @return the new validation child
	 */
	@Override
	public ValidationChild create(long id) {
		ValidationChild validationChild = new ValidationChildImpl();

		validationChild.setNew(true);
		validationChild.setPrimaryKey(id);

		String uuid = PortalUUIDUtil.generate();

		validationChild.setUuid(uuid);

		validationChild.setCompanyId(CompanyThreadLocal.getCompanyId());

		return validationChild;
	}

	/**
	 * Removes the validation child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child that was removed
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild remove(long id)
		throws NoSuchValidationChildException {

		return remove((Serializable)id);
	}

	/**
	 * Removes the validation child with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the validation child
	 * @return the validation child that was removed
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild remove(Serializable primaryKey)
		throws NoSuchValidationChildException {

		Session session = null;

		try {
			session = openSession();

			ValidationChild validationChild = (ValidationChild)session.get(
				ValidationChildImpl.class, primaryKey);

			if (validationChild == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchValidationChildException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(validationChild);
		}
		catch (NoSuchValidationChildException noSuchEntityException) {
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
	protected ValidationChild removeImpl(ValidationChild validationChild) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(validationChild)) {
				validationChild = (ValidationChild)session.get(
					ValidationChildImpl.class,
					validationChild.getPrimaryKeyObj());
			}

			if (validationChild != null) {
				session.delete(validationChild);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (validationChild != null) {
			clearCache(validationChild);
		}

		return validationChild;
	}

	@Override
	public ValidationChild updateImpl(ValidationChild validationChild) {
		boolean isNew = validationChild.isNew();

		if (!(validationChild instanceof ValidationChildModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(validationChild.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					validationChild);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in validationChild proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ValidationChild implementation " +
					validationChild.getClass());
		}

		ValidationChildModelImpl validationChildModelImpl =
			(ValidationChildModelImpl)validationChild;

		if (Validator.isNull(validationChild.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			validationChild.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (validationChild.getCreateDate() == null)) {
			if (serviceContext == null) {
				validationChild.setCreateDate(now);
			}
			else {
				validationChild.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!validationChildModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				validationChild.setModifiedDate(now);
			}
			else {
				validationChild.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(validationChild);
			}
			else {
				validationChild = (ValidationChild)session.merge(
					validationChild);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ValidationChildImpl.class, validationChildModelImpl, false, true);

		cacheUniqueFindersCache(validationChildModelImpl);

		if (isNew) {
			validationChild.setNew(false);
		}

		validationChild.resetOriginalValues();

		return validationChild;
	}

	/**
	 * Returns the validation child with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the validation child
	 * @return the validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild findByPrimaryKey(Serializable primaryKey)
		throws NoSuchValidationChildException {

		ValidationChild validationChild = fetchByPrimaryKey(primaryKey);

		if (validationChild == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchValidationChildException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return validationChild;
	}

	/**
	 * Returns the validation child with the primary key or throws a <code>NoSuchValidationChildException</code> if it could not be found.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child
	 * @throws NoSuchValidationChildException if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild findByPrimaryKey(long id)
		throws NoSuchValidationChildException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the validation child with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the validation child
	 * @return the validation child, or <code>null</code> if a validation child with the primary key could not be found
	 */
	@Override
	public ValidationChild fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the validation childs.
	 *
	 * @return the validation childs
	 */
	@Override
	public List<ValidationChild> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the validation childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @return the range of validation childs
	 */
	@Override
	public List<ValidationChild> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the validation childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of validation childs
	 */
	@Override
	public List<ValidationChild> findAll(
		int start, int end,
		OrderByComparator<ValidationChild> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the validation childs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ValidationChildModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of validation childs
	 * @param end the upper bound of the range of validation childs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of validation childs
	 */
	@Override
	public List<ValidationChild> findAll(
		int start, int end,
		OrderByComparator<ValidationChild> orderByComparator,
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

		List<ValidationChild> list = null;

		if (useFinderCache) {
			list = (List<ValidationChild>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VALIDATIONCHILD);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VALIDATIONCHILD;

				sql = sql.concat(ValidationChildModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ValidationChild>)QueryUtil.list(
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
	 * Removes all the validation childs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ValidationChild validationChild : findAll()) {
			remove(validationChild);
		}
	}

	/**
	 * Returns the number of validation childs.
	 *
	 * @return the number of validation childs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VALIDATIONCHILD);

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
		return _SQL_SELECT_VALIDATIONCHILD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ValidationChildModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the validation child persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ValidationChildModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ValidationChild.class.getName()));

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

		_finderPathWithPaginationFindByValidationOrignalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByValidationOrignalId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"validationOrignalId"}, true);

		_finderPathWithoutPaginationFindByValidationOrignalId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByValidationOrignalId",
				new String[] {String.class.getName()},
				new String[] {"validationOrignalId"}, true);

		_finderPathCountByValidationOrignalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByValidationOrignalId", new String[] {String.class.getName()},
			new String[] {"validationOrignalId"}, false);

		_finderPathWithPaginationFindByVOID_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByVOID_S",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"validationOrignalId", "subscriptionId"}, true);

		_finderPathWithoutPaginationFindByVOID_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByVOID_S",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"validationOrignalId", "subscriptionId"}, true);

		_finderPathCountByVOID_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVOID_S",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"validationOrignalId", "subscriptionId"}, false);

		_finderPathWithPaginationFindByChildValidationOrignalId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByChildValidationOrignalId",
				new String[] {
					String.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"childValidationOriginalId"}, true);

		_finderPathWithoutPaginationFindByChildValidationOrignalId =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByChildValidationOrignalId",
				new String[] {String.class.getName()},
				new String[] {"childValidationOriginalId"}, true);

		_finderPathCountByChildValidationOrignalId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByChildValidationOrignalId",
			new String[] {String.class.getName()},
			new String[] {"childValidationOriginalId"}, false);

		_finderPathWithPaginationFindByCVOID_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCVOID_S",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"childValidationOriginalId", "subscriptionId"}, true);

		_finderPathWithoutPaginationFindByCVOID_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCVOID_S",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"childValidationOriginalId", "subscriptionId"}, true);

		_finderPathCountByCVOID_S = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCVOID_S",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"childValidationOriginalId", "subscriptionId"},
			false);

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
		entityCache.removeCache(ValidationChildImpl.class.getName());

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

	private static final String _SQL_SELECT_VALIDATIONCHILD =
		"SELECT validationChild FROM ValidationChild validationChild";

	private static final String _SQL_SELECT_VALIDATIONCHILD_WHERE =
		"SELECT validationChild FROM ValidationChild validationChild WHERE ";

	private static final String _SQL_COUNT_VALIDATIONCHILD =
		"SELECT COUNT(validationChild) FROM ValidationChild validationChild";

	private static final String _SQL_COUNT_VALIDATIONCHILD_WHERE =
		"SELECT COUNT(validationChild) FROM ValidationChild validationChild WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "validationChild.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ValidationChild exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ValidationChild exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ValidationChildPersistenceImpl.class);

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

	private static class ValidationChildModelArgumentsResolver
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

			ValidationChildModelImpl validationChildModelImpl =
				(ValidationChildModelImpl)baseModel;

			long columnBitmask = validationChildModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					validationChildModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						validationChildModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					validationChildModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ValidationChildModelImpl validationChildModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						validationChildModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = validationChildModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}