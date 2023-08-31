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

import com.iot_catalogue.model.ElementStandard;
import com.iot_catalogue.service.base.ElementStandardLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the element standard local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.iot_catalogue.service.ElementStandardLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementStandardLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.iot_catalogue.model.ElementStandard",
	service = AopService.class
)
public class ElementStandardLocalServiceImpl
	extends ElementStandardLocalServiceBaseImpl {

	public ElementStandard addElementStandard(long userId, String originalId, String elementClassName, String name, long subscriptionId,ServiceContext serviceContext) throws PortalException {
		 User user = userLocalService.getUserById(userId);
		 Date now = new Date();
		 long elementStandarId = counterLocalService.increment();
		 long groupId = serviceContext.getScopeGroupId();
		 ElementStandard elementStandard = elementStandardPersistence.create(elementStandarId);
		 elementStandard.setUuid(serviceContext.getUuid());
		 elementStandard.setUserId(userId);
		 elementStandard.setGroupId(groupId);
		 elementStandard.setCompanyId(user.getCompanyId());
		 elementStandard.setUserName(user.getFullName());
		 elementStandard.setCreateDate(serviceContext.getCreateDate(now));
		 elementStandard.setModifiedDate(serviceContext.getModifiedDate(now));
		 elementStandard.setExpandoBridgeAttributes(serviceContext);		 
		 elementStandard.setSubscriptionId(subscriptionId);
		 elementStandard.setElementOriginalId(originalId);
		 elementStandard.setElementClassName(elementClassName);
		
		 elementStandard.setName(name);		
		 elementStandardPersistence.update(elementStandard);
		 return elementStandard;
	}
	public List<ElementStandard> getElementStandards(){
		 return elementStandardPersistence.findAll();
	 }
	
	 public List<ElementStandard> getElementStandardsByGroupId(long groupId){
		 return elementStandardPersistence.findByGroupId(groupId);
	 }
	 
	public List<ElementStandard> getElementStandards(String originalId, String elementClassName){
		return elementStandardPersistence.findByElement(originalId, elementClassName);
	}
	public List<ElementStandard> getElementStandards(long subscriptionId, String originalId, String elementClassName){
		return elementStandardPersistence.findByS_E(subscriptionId, originalId, elementClassName);
	}
	public List<ElementStandard> getElementStandardsBySubscriptionId(long subscriptionId){

		return elementStandardPersistence.findBySubscriptionId(subscriptionId);
	}
	
	public List<ElementStandard> deleteElementStandards(long subscriptionId, String originalId, String elementClassName){

		List<ElementStandard> elementStandards = this.getElementStandards(subscriptionId, originalId, elementClassName);
		for(ElementStandard elementStandard: elementStandards) {
			this.deleteElementStandard(elementStandard);
		}
		return elementStandards;
	}
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.iot_catalogue.service.ElementStandardLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.iot_catalogue.service.ElementStandardLocalServiceUtil</code>.
	 */
}