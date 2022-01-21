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

import com.iot_catalogue.model.ElementCoordinate;
import com.iot_catalogue.service.base.ElementCoordinateLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the element coordinate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.iot_catalogue.service.ElementCoordinateLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElementCoordinateLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.iot_catalogue.model.ElementCoordinate",
	service = AopService.class
)
public class ElementCoordinateLocalServiceImpl
	extends ElementCoordinateLocalServiceBaseImpl {
	public ElementCoordinate addElementCoordinate(long userId, String originalId, String elementClassName, double latitude, double longitude, long subscriptionId, ServiceContext serviceContext ) throws PortalException {
		User user = userLocalService.getUserById(userId);
	    Date now = new Date();
	    long elementCoordinateId = counterLocalService.increment();
	    long groupId = serviceContext.getScopeGroupId();
	    ElementCoordinate elementCoordinate = elementCoordinatePersistence.create(elementCoordinateId);
	    elementCoordinate.setUuid(serviceContext.getUuid());
	    elementCoordinate.setUserId(userId);
	    elementCoordinate.setGroupId(groupId);
	    elementCoordinate.setCompanyId(user.getCompanyId());
	    elementCoordinate.setUserName(user.getFullName());
	    elementCoordinate.setCreateDate(serviceContext.getCreateDate(now));
	    elementCoordinate.setModifiedDate(serviceContext.getModifiedDate(now));
	    elementCoordinate.setExpandoBridgeAttributes(serviceContext);
	    
	    elementCoordinate.setSubscriptionId(subscriptionId);
	    elementCoordinate.setElementOriginalId(originalId);
	    elementCoordinate.setElementClassName(elementClassName);
	   
	    elementCoordinate.setLatitude(latitude);
	    elementCoordinate.setLongitude(longitude);
	    
	    elementCoordinatePersistence.update(elementCoordinate);
	    
		return elementCoordinate;
	}
	
	public List<ElementCoordinate> getElementCoordinates(){
		return elementCoordinatePersistence.findAll();
	}
	
	public List<ElementCoordinate> getElementCoordinatesByGroupId(long groupId){
		return elementCoordinatePersistence.findByGroupId(groupId);
	}
	
	public List<ElementCoordinate> getElementCoordinates(long subscriptionId, String originalId, String elementClassName){
		return elementCoordinatePersistence.findByS_E(subscriptionId, originalId, elementClassName);
	}
	
	
	public List<ElementCoordinate> getElementCoordinatesBySubscriptionId(long subscriptionId){

		return elementCoordinatePersistence.findBySubscriptionId(subscriptionId);
	}
	
	
	
	public List<ElementCoordinate> deleteElementCoordinates(long subscriptionId, String originalId, String elementClassName){

		List<ElementCoordinate> elementCoordinates = this.getElementCoordinates(subscriptionId, originalId, elementClassName);
		for(ElementCoordinate elementCoordinate: elementCoordinates) {
			this.deleteElementCoordinate(elementCoordinate);
		}
		return elementCoordinates;
	}
	
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.iot_catalogue.service.ElementCoordinateLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.iot_catalogue.service.ElementCoordinateLocalServiceUtil</code>.
	 */
}