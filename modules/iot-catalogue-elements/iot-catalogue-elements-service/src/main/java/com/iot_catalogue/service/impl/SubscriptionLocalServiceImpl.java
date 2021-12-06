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


import com.iot_catalogue.exception.NoSuchSubscriptionException;
import com.iot_catalogue.exception.SubscriptionConnectionIdException;
import com.iot_catalogue.exception.SubscriptionConnectionStateException;
import com.iot_catalogue.exception.SubscriptionHostException;
import com.iot_catalogue.exception.SubscriptionPortException;
import com.iot_catalogue.exception.SubscriptionTokenException;
import com.iot_catalogue.exception.SubscriptionUseSSLException;
import com.iot_catalogue.model.Subscription;
import com.iot_catalogue.service.base.SubscriptionLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.iot_catalogue.service.SubscriptionLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.iot_catalogue.model.Subscription",
	service = AopService.class
)
public class SubscriptionLocalServiceImpl
	extends SubscriptionLocalServiceBaseImpl {

	
	public Subscription addSubscription(long userId, long groupId, String token, String socketAddress, ServiceContext serviceContext) throws PortalException {
		

		
		User user = userLocalService.getUserById(userId);

		validate(token, socketAddress);
		
	    Date now = new Date();
	    long subscriptionId = counterLocalService.increment();
		
		Subscription subscription = subscriptionPersistence.create(subscriptionId);
		
		subscription.setUuid(serviceContext.getUuid());
		subscription.setUserId(userId);
		subscription.setGroupId(groupId);
		subscription.setCompanyId(user.getCompanyId());
		subscription.setUserName(user.getFullName());
		subscription.setCreateDate(serviceContext.getCreateDate(now));
		subscription.setModifiedDate(serviceContext.getModifiedDate(now));
		subscription.setExpandoBridgeAttributes(serviceContext);
		
		
		
		subscription.setToken(token);
		subscription.setSocketAddress(socketAddress);

		
		subscriptionPersistence.update(subscription);
		return subscription;
	}
	
	
		
	
	public Subscription setSubscriptionConnectionInfo(long subscriptionId, String connectionId, String connectionState) throws PortalException {
		Date now = new Date();
		
		validate(connectionId, connectionState);
		
		Subscription subscription = getSubscription(subscriptionId);
		

		subscription.setConnectionId(connectionId);
		subscription.setConnectionState(connectionState);
		subscriptionPersistence.update(subscription);
		return subscription;
	}
	
	public Subscription setSubscriptionConnectionId(long subscriptionId, String connectionId) throws PortalException {
		Date now = new Date();
		
		
		Subscription subscription = getSubscription(subscriptionId);
		

		subscription.setConnectionId(connectionId);
		subscriptionPersistence.update(subscription);
		return subscription;
	}
	
	public Subscription setSubscriptionConnectionState(long subscriptionId, String connectionState) throws PortalException {
		Date now = new Date();
		
		
		Subscription subscription = getSubscription(subscriptionId);
		
		subscription.setConnectionState(connectionState);
		subscriptionPersistence.update(subscription);
		return subscription;
	}
	
	
	public int getSubscriptionCount() {
		return subscriptionPersistence.countAll();
	}
	public int getSubscriptionCount(long groupId) {
		return subscriptionPersistence.countBygroupId(groupId);
	}
	
	
	public List<Subscription> getSubscriptions(){
		return subscriptionPersistence.findAll();
	}
	
	
	public List<Subscription> getSubscriptions( int start, int end){
		return subscriptionPersistence.findAll(start, end);
	}
	
	public List<Subscription> getSubscriptions(long groupId, int start, int end){
		return subscriptionPersistence.findBygroupId(groupId, start, end);
	}
	
	public Subscription getSubscriptionById(long subscriptionId) throws NoSuchSubscriptionException {
		return subscriptionPersistence.findBysubscriptionId(subscriptionId);
	}
	
	
	public Subscription getSubscriptionByGroupId(long groupId) throws NoSuchSubscriptionException {
		return subscriptionPersistence.findBygroupId(groupId).get(0);
	}
	

	
	protected void validate(String connectionId, String host)
		    throws PortalException {

		   if (Validator.isNull(connectionId)) {
		        throw new SubscriptionConnectionIdException();
		    }
	
		    if (Validator.isNull(host)) {
		        throw new SubscriptionConnectionStateException();
		    }

		}
	

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.iot_catalogue.service.SubscriptionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.iot_catalogue.service.SubscriptionLocalServiceUtil</code>.
	 */
}