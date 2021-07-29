package com.iot_catalogue.service.permission;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseResourcePermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.ResourcePermissionChecker;

@Component(immediate = true, property = {
		"resource.name=" + IoTComponentModelPermission.RESOURCE_NAME }, service = ResourcePermissionChecker.class)
public class IoTComponentModelPermission extends BaseResourcePermissionChecker {
	public static final String RESOURCE_NAME = "com.iot_catalogue";

	public static void check(PermissionChecker permissionChecker, long groupId, String actionId) {
		try {
			if (!contains(permissionChecker, groupId, actionId)) {
				throw new PrincipalException.MustHavePermission(permissionChecker, RESOURCE_NAME, groupId, actionId);
			}
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, String actionId) {
		boolean permission = permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId, actionId);

		return permission;
	}

	@Override
	public Boolean checkResource(PermissionChecker permissionChecker, long classPK, String actionId) {
		Boolean permission = contains(permissionChecker, classPK, actionId);
		return permission;
	}
}
