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

import com.iot_catalogue.model.ValidationChild;
import com.iot_catalogue.service.base.ValidationChildLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the validation child local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.iot_catalogue.service.ValidationChildLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ValidationChildLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.iot_catalogue.model.ValidationChild",
	service = AopService.class
)
public class ValidationChildLocalServiceImpl
	extends ValidationChildLocalServiceBaseImpl {
	
	
	public ValidationChild addValidationChild(long userId, String validationOriginalId, String childValidationOriginalId, long subscriptionId, ServiceContext serviceContext) throws PortalException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();
		long validationChildId = counterLocalService.increment();
		
		ValidationChild validationChild = validationChildPersistence.create(validationChildId);
		
		validationChild.setUuid(serviceContext.getUuid());
		validationChild.setUserId(userId);
		validationChild.setGroupId(groupId);
		validationChild.setCompanyId(user.getCompanyId());
		validationChild.setUserName(user.getFullName());
		validationChild.setCreateDate(serviceContext.getCreateDate(now));
		validationChild.setCreateDate(serviceContext.getModifiedDate(now));
		validationChild.setExpandoBridgeAttributes(serviceContext);
		

		validationChild.setValidationOrignalId(validationOriginalId);
		validationChild.setChildValidationOriginalId(childValidationOriginalId);
		validationChild.setSubscriptionId(subscriptionId);
		
		validationChildPersistence.update(validationChild);
			
			
		return validationChild;
		
	}
	
	
	public List<ValidationChild> getValidationChilds(String validationOriginalId){
		return validationChildPersistence.findByValidationOrignalId(validationOriginalId);
		
	}
	
	public List<ValidationChild> getValidationChilds(String componentOriginalId, long subcriptionId){
		return validationChildPersistence.findByVOID_S(componentOriginalId, subcriptionId);
		
	}
	
	public List<ValidationChild> getValidationChildsByChild(String childId){
		return validationChildPersistence.findByChildValidationOrignalId(childId);
		
	}
	
	public List<ValidationChild> getValidationChildsByChild(String childId, long subscriptionId){
		return validationChildPersistence.findByCVOID_S(childId, subscriptionId);
		
	}
	
	public List<ValidationChild> getValidationChildsBySubscriptionId(long subscriptionId){
		//componentChildPersistence.findS
		return validationChildPersistence.findBySubscriptionId(subscriptionId);

		
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.iot_catalogue.service.ValidationChildLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.iot_catalogue.service.ValidationChildLocalServiceUtil</code>.
	 */
}