package com.iot_catalogue.portlet.upgrade;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Filter;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.kernel.upgrade.UpgradeException;
import com.liferay.portal.upgrade.release.BaseUpgradeServiceModuleRelease;

public class PortletBundleActivator implements BundleActivator{
	@Override
	public void stop(BundleContext bundleContext) throws Exception {
	    _serviceTracker.close();
	}
	
	@Override
	public void start(BundleContext bundleContext) throws Exception {
	    Filter filter = bundleContext.createFilter(
	        StringBundler.concat(
	            "(&(objectClass=", ModuleServiceLifecycle.class.getName(), ")",
	            ModuleServiceLifecycle.DATABASE_INITIALIZED, ")"));

	    _serviceTracker = new ServiceTracker<Object, Object>(
	        bundleContext, filter, null) {
	    	@Override
	    	public Object addingService(
	    	    ServiceReference<Object> serviceReference) {

	    	    try {
	    	        BaseUpgradeServiceModuleRelease
	    	                upgradeServiceModuleRelease =
	    	            new BaseUpgradeServiceModuleRelease() {

	    	                @Override
	    	                protected String getNamespace() {
	    	                    return "IoTCatalogue";
	    	                }

	    	                @Override
	    	                protected String getNewBundleSymbolicName() {
	    	                    return "com.iot_catalogue.portlet";
	    	                }

	    	                @Override
	    	                protected String getOldBundleSymbolicName() {
	    	                    return "com.iot_catalogue.portlet";
	    	                }

	    	            };

	    	        upgradeServiceModuleRelease.upgrade();

	    	        return null;
	    	    }
	    	    catch (UpgradeException ue) {
	    	        throw new RuntimeException(ue);
	    	    }
	    	}
	    };

	    _serviceTracker.open();
	}
	
	
	
	private ServiceTracker<Object, Object> _serviceTracker;
}
