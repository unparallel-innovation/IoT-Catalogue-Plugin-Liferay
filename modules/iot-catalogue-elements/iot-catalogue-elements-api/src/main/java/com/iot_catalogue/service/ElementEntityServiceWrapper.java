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
 * Provides a wrapper for {@link ElementEntityService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElementEntityService
 * @generated
 */
public class ElementEntityServiceWrapper
	implements ElementEntityService, ServiceWrapper<ElementEntityService> {

	public ElementEntityServiceWrapper(
		ElementEntityService elementEntityService) {

		_elementEntityService = elementEntityService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _elementEntityService.getOSGiServiceIdentifier();
	}

	@Override
	public ElementEntityService getWrappedService() {
		return _elementEntityService;
	}

	@Override
	public void setWrappedService(ElementEntityService elementEntityService) {
		_elementEntityService = elementEntityService;
	}

	private ElementEntityService _elementEntityService;

}