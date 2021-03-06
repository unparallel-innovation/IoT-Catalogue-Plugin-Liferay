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

package com.iot_catalogue.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.iot_catalogue.exception.NoSuchIoTValidationException;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.service.base.IoTValidationLocalServiceBaseImpl;
import com.iot_catalogue.utils.CategoryUtil;
import com.iot_catalogue.utils.TagUtils;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * The implementation of the iot validation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.iot_catalogue.service.IoTValidationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IoTValidationLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.iot_catalogue.model.IoTValidation", service = AopService.class)
public class IoTValidationLocalServiceImpl extends IoTValidationLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public IoTValidation addIoTValidation(
			long userId, 
			String name, 
			String description, 
			String website,
			String embeddedUrl,
			String imageUrl,
			String elementStatus,
			List<HashMap<String, Object>> categoriesPath  , 
			String originalId, 
			long subscriptionId, 
			ServiceContext serviceContext
			)
			throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		// validate(name, description, originalId);

		long iotValidationId = counterLocalService.increment();

		IoTValidation iotValidation = ioTValidationPersistence.create(iotValidationId);

		iotValidation.setUuid(serviceContext.getUuid());
		iotValidation.setUserId(userId);
		iotValidation.setGroupId(groupId);
		iotValidation.setCompanyId(user.getCompanyId());
		iotValidation.setUserName(user.getFullName());
		iotValidation.setCreateDate(serviceContext.getCreateDate(now));
		iotValidation.setModifiedDate(serviceContext.getModifiedDate(now));
		iotValidation.setName(name);
		iotValidation.setDescription(description);
		iotValidation.setEmbeddedUrl(embeddedUrl);
		iotValidation.setImageUrl(imageUrl);
		iotValidation.setElementStatus(elementStatus);
		iotValidation.setOriginalId(originalId);
		iotValidation.setExpandoBridgeAttributes(serviceContext);
		iotValidation.setSubscriptionId(subscriptionId);
		ioTValidationPersistence.update(iotValidation);
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, IoTValidation.class.getName(),
				iotValidationId, false, true, true);
		
		AssetEntry assetEntry = updateAsset(userId, groupId, iotValidation,website, categoriesPath, serviceContext);
		//tagManager.addTagNamesToAsset(serviceContext, tagNames, assetEntry.getEntryId());
		return iotValidation;

	}

	private AssetEntry updateAsset(long userId, long groupId, IoTValidation iotValidation, String website,List<HashMap<String, Object>> categoriesPath, ServiceContext serviceContext) throws PortalException {

		String[] tagArray = TagUtils.getTagNamesFromCategoriesPaths(categoriesPath);
		long[] categoryIds = CategoryUtil.getCategoryIds(categoriesPath,serviceContext);
		/*long[] categoryIds = null;
		if(tagsPaths != null) {
			List<Long> values = new ArrayList<Long>();
			for(List<String> tagPaths:tagsPaths) {
				List<String> categoryNames = new ArrayList<>(tagPaths);
				Collections.reverse(categoryNames);
				AssetCategory assetCategory = CategoryUtil.addCategoryPath(categoryNames, serviceContext);
				values.add(assetCategory.getCategoryId());
			}
			categoryIds = values.stream().mapToLong(l -> l).toArray();
		}*/
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, // userId
				groupId, // groupId
				iotValidation.getCreateDate(), // createDate
				iotValidation.getModifiedDate(), // modifiedDate
				IoTValidation.class.getName(), // className
				iotValidation.getIotValidationId(), // classPK
				iotValidation.getUserUuid(), // classUuid
				0, // classTypeId
				categoryIds, // categoryIds
				tagArray, // tagNames
				true, // listable
				true, // visible
				null, // startDate
				null, // endDate
				null, // publishDate
				null, // expirationDate
				ContentTypes.TEXT_HTML, // mimeType
				iotValidation.getName(), // title
				iotValidation.getDescription(), // description
				null, // summary
				website, // url
				null, // layoutUuid
				0, // height
				0, // width
				null// priority
		);
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), null, AssetLinkConstants.TYPE_RELATED);
		return assetEntry;

	}

	@Indexable(type = IndexableType.DELETE)
	public IoTValidation deleteIoTValidation(IoTValidation iotValidation, ServiceContext serviceContext)
			throws PortalException {

		try {
			AssetEntry assetEntry = assetEntryLocalService.fetchEntry(IoTValidation.class.getName(),
					iotValidation.getIotValidationId());
			resourceLocalService.deleteResource(serviceContext.getCompanyId(), IoTValidation.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, iotValidation.getIotValidationId());
			assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
			assetEntryLocalService.deleteEntry(assetEntry);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.deleteIoTValidation(iotValidation.getIotValidationId());
	}




	@Indexable(type = IndexableType.REINDEX)
	public IoTValidation updateIoTValidation(
			long userId, 
			long iotValidationId, 
			String name, 
			String description,
			String website,
			String embeddedUrl, 
			String imageUrl,
			String elementStatus,
			List<HashMap<String, Object>> categoriesPath , 
			ServiceContext serviceContext) throws PortalException {
		Date now = new Date();
		long groupId = serviceContext.getScopeGroupId();
		IoTValidation iotValidation = getIoTValidation(iotValidationId);
		User user = userLocalService.getUserById(userId);
		iotValidation.setUserId(userId);
		iotValidation.setGroupId(groupId);
		iotValidation.setUserName(user.getFullName());
		iotValidation.setModifiedDate(serviceContext.getModifiedDate(now));

		if (name != null) {
			iotValidation.setName(name);
		}
		if (description != null) {
			iotValidation.setDescription(description);
		}
		if (embeddedUrl != null) {
			iotValidation.setEmbeddedUrl(embeddedUrl);
		}
		if (imageUrl != null) {
			iotValidation.setImageUrl(imageUrl);
		}
		String prevElementStatus = iotValidation.getElementStatus();
		
		if(
				elementStatus!=null && prevElementStatus!=null && (
					elementStatus == null && 	prevElementStatus!=null ||
					elementStatus != null && 	prevElementStatus==null ||
					!elementStatus.equals(prevElementStatus)
				)
		
				
			) {
			iotValidation.setElementStatus(elementStatus);
		}
		iotValidation.setExpandoBridgeAttributes(serviceContext);

		ioTValidationPersistence.update(iotValidation);
		/*
		 * resourceLocalService.updateResources(serviceContext.getCompanyId(),
		 * serviceContext.getScopeGroupId(), IoTValidation.class.getName(),
		 * iotValidationId,
		 * serviceContext.getModelPermissions().getActionIds(RoleConstants.
		 * PLACEHOLDER_DEFAULT_GROUP_ROLE),
		 * serviceContext.getModelPermissions().getActionIds(RoleConstants.GUEST));
		 */

		AssetEntry assetEntry = updateAsset(userId, groupId, iotValidation,website, categoriesPath, serviceContext);
		//tagManager.addTagNamesToAsset(serviceContext, tagNames, assetEntry.getEntryId());
		return iotValidation;

	}

	public List<IoTValidation> getIoTValidations() {

		return ioTValidationPersistence.findAll();
	}

	public List<IoTValidation> getIoTValidations(long groupId) {

		return ioTValidationPersistence.findByGroupId(groupId);
	}

	public List<IoTValidation> getIoTValidations(long groupId, int start, int end,
			OrderByComparator<IoTValidation> obc) {

		return ioTValidationPersistence.findByGroupId(groupId, start, end, obc);
	}

	public IoTValidation getIoTValidationByOriginalId(String originalId) throws NoSuchIoTValidationException {
		return ioTValidationPersistence.findByOriginalId(originalId);
	}

	public IoTValidation getIoTValidationByOriginalId(String originalId, long subscriptionId)
			throws NoSuchIoTValidationException {
		return ioTValidationPersistence.findByOID_S(originalId, subscriptionId);
	}

	public List<IoTValidation> getIoTValidations(long groupId, int start, int end) {

		return ioTValidationPersistence.findByGroupId(groupId, start, end);
	}

	public int getIoTValidationsCount(long groupId) {

		return ioTValidationPersistence.countByGroupId(groupId);
	}

	public List<IoTValidation> getIoTValidationsBySubscriptionId(long subscriptionId) {
		return ioTValidationPersistence.findBySubscriptionId(subscriptionId);
	}

	public List<IoTValidation> getIoTValidationsBySubscriptionId(long subscriptionId, int start, int end) {
		return ioTValidationPersistence.findBySubscriptionId(subscriptionId, start, end);
	}

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.iot_catalogue.service.IoTValidationLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.iot_catalogue.service.IoTValidationLocalServiceUtil</code>.
	 */

	
	
}