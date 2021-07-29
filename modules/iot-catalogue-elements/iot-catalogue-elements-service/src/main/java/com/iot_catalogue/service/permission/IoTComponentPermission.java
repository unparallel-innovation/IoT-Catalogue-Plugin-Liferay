package com.iot_catalogue.service.permission;

import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.service.IoTComponentLocalService;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, property = { "model.class.name=com.iot_catalogue.model.IoTComponent" })
public class IoTComponentPermission implements BaseModelPermissionChecker {
	public static void check(PermissionChecker permissionChecker, long iotComponentId, String actionId) {
		try {
			if (!contains(permissionChecker, iotComponentId, actionId)) {
				throw new PrincipalException();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void check(PermissionChecker permissionChecker, long groupId, long iotComponentId, String actionId) {
		try {
			if (!contains(permissionChecker, groupId, actionId)) {
				throw new PrincipalException.MustHavePermission(permissionChecker, IoTComponent.class.getName(),
						iotComponentId, actionId);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId, long iotComponentId,
			String actionId)  {

		try {
			IoTComponent iotComponent = _iotComponentLocalService.getIoTComponent(iotComponentId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return IoTComponentModelPermission.contains(permissionChecker, groupId, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long iotComponentId, String actionId)
			 {

		IoTComponent iotComponent = null;
		try {
			iotComponent = _iotComponentLocalService.getIoTComponent(iotComponentId);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			return contains(permissionChecker, iotComponent, actionId);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public static boolean contains(PermissionChecker permissionChecker, IoTComponent iotComponent, String actionId)
			 {

		return permissionChecker.hasPermission(iotComponent.getGroupId(), IoTComponent.class.getName(),
				iotComponent.getIotComponentId(), actionId);

	}

	@Reference(unbind = "-")
	protected void setIoTComponentLocalService(IoTComponentLocalService iotComponentLocalService) {
		_iotComponentLocalService = iotComponentLocalService;
	}

	private static IoTComponentLocalService _iotComponentLocalService;

	@Override
	public void checkBaseModel(PermissionChecker permissionChecker, long groupId, long iotComponentId, String actionId)
			{
		check(permissionChecker, iotComponentId, actionId);
	}
}
