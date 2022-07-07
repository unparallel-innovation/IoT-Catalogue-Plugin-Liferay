package com.iot_catalogue.upgrade;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.felix.service.command.CommandProcessor;
import org.apache.felix.service.command.CommandSession;
import org.apache.felix.service.command.Converter;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.iot_catalogue.upgrade.v_1_1_0.ElementCoordinateUpgrade;
import com.iot_catalogue.upgrade.v_1_2_0.ComponentChildUpgrade;
import com.iot_catalogue.upgrade.v_1_2_0.ValidationChildUpgrade;
import com.iot_catalogue.upgrade.v_1_3_0.AddElementStatusField;
import com.liferay.petra.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.petra.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

@Component(
		enabled = true, immediate = true, service = UpgradeStepRegistrator.class
	)
public class Upgrade implements UpgradeStepRegistrator{

	@Override
	public void register(Registry registry) {
		// TODO Auto-generated method stub

		_log.info("Service upgrade step registrator started");
		registry.register("1.0.0", "1.1.0", new ElementCoordinateUpgrade());
		registry.register("1.1.0", "1.2.0", new ComponentChildUpgrade(), new ValidationChildUpgrade());
		registry.register("1.2.0", "1.3.0", new AddElementStatusField());

	}
	

	@Activate
	protected void activate(final BundleContext bundleContext) {
		ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);
		scheduler.schedule(new Runnable() {
			public void run() {
				try {
					if(bundleContext != null) {
						Bundle bundle = bundleContext.getBundle();
						if(bundle != null) {
							upgradeBundle(bundle.getSymbolicName());
						}
					}
				} catch (PortalException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
		}, waitTime, TimeUnit.MILLISECONDS);

		
	}
	
	
	private void upgradeBundle(final String bundleSymbolicName) throws PortalException {
		_log.info("Running upgrade for " + bundleSymbolicName);
		  CommandSession commandSession = null;
			
		  InputStream emptyInputStream = null;
		  UnsyncByteArrayOutputStream outputUnsyncByteArrayOutputStream = null;
		  UnsyncByteArrayOutputStream errorUnsyncByteArrayOutputStream = null;
		  PrintStream outputPrintStream = null;
		  PrintStream errorPrintStream = null;
			
		  try {
		    emptyInputStream = new UnsyncByteArrayInputStream(new byte[0]);
				
		    outputUnsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
		    errorUnsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				
		    outputPrintStream = new PrintStream(outputUnsyncByteArrayOutputStream);
		    errorPrintStream = new PrintStream(errorUnsyncByteArrayOutputStream);
				
		    commandSession = _commandProcessor.createSession(emptyInputStream, 
		      outputPrintStream, errorPrintStream);
				
		    // invoke the gogo upgrade:execute command and provide the BSN
		    Object result = commandSession.execute("upgrade:execute " + bundleSymbolicName);
				
		    if (result != null) {
		      outputPrintStream.print(commandSession.format(result, Converter.INSPECT));
		    }
				
		    errorPrintStream.flush();
		    outputPrintStream.flush();
				
		    String errorContent = errorUnsyncByteArrayOutputStream.toString();
				
		    if (Validator.isNotNull(errorContent)) {
		      throw new Exception(errorContent);
		    }
				
		    String outputContent = outputUnsyncByteArrayOutputStream.toString();
				
		    if (Validator.isNotNull(outputContent)) {
		      _log.info(outputContent);
		    }
		  } catch (Exception e) {
		    _log.error("Error upgrading bundle: " + e.getMessage(), e);
		    throw new PortalException(e);
		  } finally {
		    // close all of the resources...
		  }
		}
	
	@Reference
	private CommandProcessor _commandProcessor;
	private static final long waitTime = 2000;
	private static final Log _log = LogFactoryUtil.getLog(
			Upgrade.class);
}
