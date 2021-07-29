package com.iot_catalogue.service.permission;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.iot_catalogue.service.IoTValidationLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.BaseModelPermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(
	    immediate = true,
	    property = {"model.class.name=com.iot_catalogue.model.IoTValidation"}
	)
public class IoTValidationPermission implements BaseModelPermissionChecker {
    public static void check(
            PermissionChecker permissionChecker, long iotValidationId, String actionId)
            throws PortalException, SystemException {

            if (!contains(permissionChecker, iotValidationId, actionId)) {
                throw new PrincipalException();
            }
        }
    
    public static void check(
            PermissionChecker permissionChecker, long groupId, long iotValidationId,
            String actionId)
            throws PortalException {

            if (!contains(permissionChecker, groupId, actionId)) {
                throw new PrincipalException.MustHavePermission(
                    permissionChecker, IoTValidation.class.getName(), iotValidationId,
                    actionId);
            }
        }
    public static boolean contains(
            PermissionChecker permissionChecker, long groupId, long iotValidationId, String actionId) 
                throws PortalException {

            IoTValidation iotValidation = _iotValidationLocalService.getIoTValidation(iotValidationId);

            return IoTValidationModelPermission.contains(permissionChecker, groupId, actionId);
        }
    
    public static boolean contains(
            PermissionChecker permissionChecker, long iotValidationId, String actionId)
            throws PortalException, SystemException {

    		IoTValidation iotValidation = _iotValidationLocalService.getIoTValidation(iotValidationId);

            return contains(permissionChecker, iotValidation, actionId);
        }
    
    public static boolean contains(
            PermissionChecker permissionChecker, IoTValidation iotValidation, String actionId) 
                throws PortalException, SystemException {

            return permissionChecker.hasPermission(
            		iotValidation.getGroupId(), IoTValidation.class.getName(), iotValidation.getIotValidationId(), actionId);

        }
    
    @Reference(unbind = "-")
    protected void setIoTValidationLocalService(IoTValidationLocalService iotValidationLocalService) {
    	_iotValidationLocalService = iotValidationLocalService;
    }

    private static IoTValidationLocalService _iotValidationLocalService;
    
    @Override
    public void checkBaseModel(
        PermissionChecker permissionChecker, long groupId, long iotValidationId, String actionId) throws PortalException {
            check(permissionChecker, iotValidationId, actionId);
    }
}
