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

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.iot_catalogue.model.ComponentChild;
import com.iot_catalogue.service.base.ComponentChildLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the component child local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.iot_catalogue.service.ComponentChildLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ComponentChildLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.iot_catalogue.model.ComponentChild",
	service = AopService.class
)
public class ComponentChildLocalServiceImpl
	extends ComponentChildLocalServiceBaseImpl {
	
	public ComponentChild addComponentChild(long userId, String componentOriginalId, String childComponentOriginalId, long subscriptionId, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();

			User user = userLocalService.getUserById(userId);

			Date now = new Date();
			long childComponentId = counterLocalService.increment();
			
			ComponentChild componentChild = componentChildPersistence.create(childComponentId);
			
			componentChild.setUuid(serviceContext.getUuid());
			componentChild.setUserId(userId);
			componentChild.setGroupId(groupId);
			componentChild.setCompanyId(user.getCompanyId());
			componentChild.setUserName(user.getFullName());
			componentChild.setCreateDate(serviceContext.getCreateDate(now));
			componentChild.setCreateDate(serviceContext.getModifiedDate(now));
			componentChild.setExpandoBridgeAttributes(serviceContext);
			

			componentChild.setComponentOrignalId(componentOriginalId);
			componentChild.setChildComponentOriginalId(childComponentOriginalId);
			
			componentChildPersistence.update(componentChild);
			
			
		return componentChild;
		
	}
	
	
	public List<ComponentChild> getComponentChilds(String componentOriginalId){
		return componentChildPersistence.findByComponentOrignalId(componentOriginalId);
		
	}
	
	public List<ComponentChild> getComponentChildsBySubscriptionId(long subscriptionId){
		//componentChildPersistence.findS
		return componentChildPersistence.findBySubscriptionId(subscriptionId);

		
	}
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.iot_catalogue.service.ComponentChildLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.iot_catalogue.service.ComponentChildLocalServiceUtil</code>.
	 */
}