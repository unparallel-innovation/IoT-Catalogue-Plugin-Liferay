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

import com.iot_catalogue.exception.NoSuchIoTComponentException;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.service.base.IoTComponentLocalServiceBaseImpl;
import com.iot_catalogue.service.persistence.IoTComponentPersistence;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.OrderByComparator;



import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the io t component local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.iot_catalogue.service.IoTComponentLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IoTComponentLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.iot_catalogue.model.IoTComponent", service = AopService.class)
public class IoTComponentLocalServiceImpl extends IoTComponentLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public IoTComponent addIoTComponent(long userId, String name, String description, String embeddedUrl,
			String imageUrl, String originalId, long subscriptionId, ServiceContext serviceContext)
			throws PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		// validate(name, description, originalId);

		long iotComponentId = counterLocalService.increment();

		IoTComponent iotComponent = ioTComponentPersistence.create(iotComponentId);

		iotComponent.setUuid(serviceContext.getUuid());
		iotComponent.setUserId(userId);
		iotComponent.setGroupId(groupId);
		iotComponent.setCompanyId(user.getCompanyId());
		iotComponent.setUserName(user.getFullName());
		iotComponent.setCreateDate(serviceContext.getCreateDate(now));
		iotComponent.setModifiedDate(serviceContext.getModifiedDate(now));
		iotComponent.setName(name);
		iotComponent.setDescription(description);
		iotComponent.setEmbeddedUrl(embeddedUrl);
		iotComponent.setImageUrl(imageUrl);
		iotComponent.setOriginalId(originalId);
		iotComponent.setSubscriptionId(subscriptionId);
	
		iotComponent.setExpandoBridgeAttributes(serviceContext);

		ioTComponentPersistence.update(iotComponent);
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, IoTComponent.class.getName(),
				iotComponentId, false, true, true);
		updateAsset(userId, groupId, iotComponent);
		return iotComponent;

	}



	@Indexable(type = IndexableType.DELETE)
	public IoTComponent deleteIoTComponent(IoTComponent iotComponent, ServiceContext serviceContext)
			throws PortalException {

		try {

			AssetEntry assetEntry = assetEntryLocalService.fetchEntry(IoTComponent.class.getName(),
					iotComponent.getIotComponentId());
			resourceLocalService.deleteResource(serviceContext.getCompanyId(), IoTComponent.class.getName(),
					ResourceConstants.SCOPE_INDIVIDUAL, iotComponent.getIotComponentId());
			assetLinkLocalService.deleteLinks(assetEntry.getEntryId());
			assetEntryLocalService.deleteEntry(assetEntry);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.deleteIoTComponent(iotComponent.getIotComponentId());
	}

	private void updateAsset(long userId, long groupId, IoTComponent iotComponent) throws PortalException {

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, // userId
				groupId, // groupId
				iotComponent.getCreateDate(), // createDate
				iotComponent.getModifiedDate(), // modifiedDate
				IoTComponent.class.getName(), // className
				iotComponent.getIotComponentId(), // classPK
				iotComponent.getUserUuid(), // classUuid
				0, // classTypeId
				null, // categoryIds
				null, // tagNames
				true, // listable
				true, // visible
				null, // startDate
				null, // endDate
				null, // publishDate
				null, // expirationDate
				ContentTypes.TEXT_HTML, // mimeType
				iotComponent.getName(), // title
				iotComponent.getDescription(), // description
				null, // summary
				null, // url
				null, // layoutUuid
				0, // height
				0, // width
				null// priority
		);
		
		
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), null, AssetLinkConstants.TYPE_RELATED);

	}

	@Indexable(type = IndexableType.REINDEX)
	public IoTComponent updateIoTComponent(long userId, long iotComponentId, String name, String description,
			String embeddedUrl, String imageUrl, ServiceContext serviceContext) throws PortalException {
		Date now = new Date();

		long groupId = serviceContext.getScopeGroupId();
		IoTComponent iotComponent = getIoTComponent(iotComponentId);
		User user = userLocalService.getUserById(userId);
		iotComponent.setUserId(userId);
		iotComponent.setUserName(user.getFullName());
		iotComponent.setModifiedDate(serviceContext.getModifiedDate(now));
		if (name != null) {
			iotComponent.setName(name);
		}
		if (description != null) {
			iotComponent.setDescription(description);
		}
		if (embeddedUrl != null) {
			iotComponent.setEmbeddedUrl(embeddedUrl);
		}
		if (imageUrl != null) {
			iotComponent.setImageUrl(imageUrl);
		}
		iotComponent.setExpandoBridgeAttributes(serviceContext);

		ioTComponentPersistence.update(iotComponent);
		/*
		 * resourceLocalService.updateResources(serviceContext.getCompanyId(),
		 * serviceContext.getScopeGroupId(), IoTComponent.class.getName(),
		 * iotComponentId,
		 * serviceContext.getModelPermissions().getActionIds(RoleConstants.
		 * PLACEHOLDER_DEFAULT_GROUP_ROLE),
		 * serviceContext.getModelPermissions().getActionIds(RoleConstants.GUEST));
		 * updateAsset(userId, groupId, iotComponent);
		 */

		return iotComponent;

	}

	public void test() {
	}

	public List<IoTComponent> getIoTComponents() {

		return ioTComponentPersistence.findAll();
	}

	public List<IoTComponent> getIoTComponents(long groupId) {

		return ioTComponentPersistence.findByGroupId(groupId);
	}

	public List<IoTComponent> getIoTComponents(long groupId, int start, int end, OrderByComparator<IoTComponent> obc) {

		return ioTComponentPersistence.findByGroupId(groupId, start, end, obc);
	}

	public List<IoTComponent> getIoTComponents(long groupId, int start, int end) {

		return ioTComponentPersistence.findByGroupId(groupId, start, end);
	}

	public IoTComponent getIoTComponentByOriginalId(String originalId) throws NoSuchIoTComponentException {
		return ioTComponentPersistence.findByOriginalId(originalId);
	}

	public IoTComponent getIoTComponentByOriginalId(String originalId, long subscriptionId)
			throws NoSuchIoTComponentException {
		return ioTComponentPersistence.findByOID_S(originalId, subscriptionId);
	}

	public List<IoTComponent> getIoTComponentsBySubscriptionId(long subscriptionId) {
		return ioTComponentPersistence.findBySubscriptionId(subscriptionId);
	}

	public List<IoTComponent> getIoTComponentsBySubscriptionId(long subscriptionId, int start, int end) {
		return ioTComponentPersistence.findBySubscriptionId(subscriptionId, start, end);
	}

	public int getIoTComponentsCount(long groupId) {

		return ioTComponentPersistence.countByGroupId(groupId);
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.iot_catalogue.service.IoTComponentLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.iot_catalogue.service.IoTComponentLocalServiceUtil</code>.
	 */
}