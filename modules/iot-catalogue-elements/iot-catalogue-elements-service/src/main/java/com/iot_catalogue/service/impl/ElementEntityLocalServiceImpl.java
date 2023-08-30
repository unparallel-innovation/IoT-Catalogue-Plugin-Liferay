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

import com.iot_catalogue.model.ElementCoordinate;
import com.iot_catalogue.model.ElementEntity;
import com.iot_catalogue.service.base.ElementEntityLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the element entity local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.iot_catalogue.service.ElementEntityLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntityLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.iot_catalogue.model.ElementEntity",
	service = AopService.class
)
public class ElementEntityLocalServiceImpl
	extends ElementEntityLocalServiceBaseImpl {

	public ElementEntity addElementEntity(long userId, String originalId, String elementClassName, String name, String website, String label, long subscriptionId,ServiceContext serviceContext) throws PortalException {
		/*
		 * 		<column name="name" type="String"/>
		<column name="website" type="String"/>
		<column name="label" type="String"/>
		 * 
		 * */
		User user = userLocalService.getUserById(userId);
		Date now = new Date();
		long elementEntityId = counterLocalService.increment();
		long groupId = serviceContext.getScopeGroupId();
		ElementEntity elementEntity = elementEntityPersistence.create(elementEntityId);
		elementEntity.setUuid(serviceContext.getUuid());
		elementEntity.setUserId(userId);
		elementEntity.setGroupId(groupId);
		elementEntity.setCompanyId(user.getCompanyId());
		elementEntity.setUserName(user.getFullName());
		elementEntity.setCreateDate(serviceContext.getCreateDate(now));
		elementEntity.setModifiedDate(serviceContext.getModifiedDate(now));
		elementEntity.setExpandoBridgeAttributes(serviceContext);
		
		elementEntity.setSubscriptionId(subscriptionId);
	     elementEntity.setElementOriginalId(originalId);
	     elementEntity.setElementClassName(elementClassName);
	     
	     elementEntity.setName(name);
	     elementEntity.setWebsite(website);
	     elementEntity.setLabel(label);
	     elementEntityPersistence.update(elementEntity);
	     return elementEntity;
	}
	
	public List<ElementEntity> getElementEntities(){
		return elementEntityPersistence.findAll();
	}
	

	public List<ElementEntity> getElementCoordinatesByGroupId(long groupId){
		return elementEntityPersistence.findByGroupId(groupId);
	}
	
	
	 public List<ElementEntity> getElementEntities(String originalId, String elementClassName, String label){
		   return elementEntityPersistence.findByE_L(originalId, elementClassName,label);
		 }
	
	 public List<ElementEntity> getElementEntities(long subscriptionId, String originalId, String elementClassName){
		   return elementEntityPersistence.findByS_E(subscriptionId, originalId, elementClassName);
		 }
	 public List<ElementEntity> getElementEntities(long subscriptionId, String originalId, String elementClassName, String label){
	   return elementEntityPersistence.findByS_E_L(subscriptionId, originalId, elementClassName,label);
	 }
	 
	 public List<ElementEntity> getElementEntitiesBySubscriptionId(long subscriptionId){

	   return elementEntityPersistence.findBySubscriptionId(subscriptionId);
	 }
	 
	 public List<ElementEntity> deleteElementEntities(long subscriptionId, String originalId, String elementClassName){

		   List<ElementEntity> elementEntities = this.getElementEntities(subscriptionId, originalId, elementClassName);
		   for(ElementEntity elementEntitiy: elementEntities) {
		     this.deleteElementEntity(elementEntitiy);
		   }
		   return elementEntities;
		 }
	 public List<ElementEntity> deleteElementEntities(long subscriptionId, String originalId, String elementClassName, String label){

		   List<ElementEntity> elementEntities = this.getElementEntities(subscriptionId, originalId, elementClassName,label);
		   for(ElementEntity elementEntitiy: elementEntities) {
		     this.deleteElementEntity(elementEntitiy);
		   }
		   return elementEntities;
		 }
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.iot_catalogue.service.ElementEntityLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.iot_catalogue.service.ElementEntityLocalServiceUtil</code>.
	 */
}