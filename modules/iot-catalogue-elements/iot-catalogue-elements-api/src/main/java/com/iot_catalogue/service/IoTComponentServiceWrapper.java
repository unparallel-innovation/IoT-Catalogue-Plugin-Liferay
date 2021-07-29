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

package com.iot_catalogue.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link IoTComponentService}.
 *
 * @author Brian Wing Shun Chan
 * @see IoTComponentService
 * @generated
 */
public class IoTComponentServiceWrapper
	implements IoTComponentService, ServiceWrapper<IoTComponentService> {

	public IoTComponentServiceWrapper(IoTComponentService ioTComponentService) {
		_ioTComponentService = ioTComponentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ioTComponentService.getOSGiServiceIdentifier();
	}

	@Override
	public IoTComponentService getWrappedService() {
		return _ioTComponentService;
	}

	@Override
	public void setWrappedService(IoTComponentService ioTComponentService) {
		_ioTComponentService = ioTComponentService;
	}

	private IoTComponentService _ioTComponentService;

}