package com.iot_catalogue.portlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.iot_catalogue.exception.NoSuchIoTComponentException;
import com.iot_catalogue.exception.NoSuchIoTValidationException;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.model.Subscription;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.iot_catalogue.service.IoTValidationLocalService;
import com.iot_catalogue.service.SubscriptionLocalService;
import com.iot_catalogue.tpi_plugin.TPIData;
import com.iot_catalogue.utils.TagManager;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import pt.unparallel.iot_catalogue.connector.Connector;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.hidden",
		"com.liferay.portlet.scopeable=true", "javax.portlet.display-name=IoT Catalogue Element List",
		"javax.portlet.expiration-cache=0", "javax.portlet.init-param.portlet-title-based-navigation=true",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/elementslistadminportlet/view.jsp",
		"javax.portlet.name=" + ElementListPortletKeys.ELEMENT_LIST_ADMIN,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=administrator",
		"javax.portlet.supports.mime-type=text/html",
		"com.liferay.portlet.add-default-resource=true" }, service = Portlet.class)
public class ElementListAdminPortlet extends MVCPortlet {

	@Override
	public void destroy() {
		closeAllConnection();
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
			List<AssetEntry> assetEntries = AssetEntryLocalServiceUtil.getAssetEntries(0,
					AssetEntryLocalServiceUtil.getAssetEntriesCount());
			/*
			 * System.out.println("Asset names");
			 * System.out.println("********************** Adding new tag"); ServiceContext
			 * sc =
			 * getServiceContextFromSubscription(_subscriptionLocalService.getSubscriptions(
			 * ).get(0));
			 * AssetTagServiceUtil.addTag(serviceContext.getScopeGroupId(),"tag from init 3"
			 * ,sc);
			 */
			// System.out.println(TagManager.getTagByName(
			// _subscriptionLocalService.getSubscriptions().get(0).getGroupId(),
			// "newtag3"));
			// List<AssetTag> tags =
			// AssetTagServiceUtil.getTags(serviceContext.getScopeGroup().getGroupId(),"newtag3",0,20);
			// System.out.println(tags);
			for (int i = 0; i < assetEntries.size(); i++) {
				AssetEntry assetEntry = assetEntries.get(i);
				// TagManager.addTagNameToAsset(serviceContext, "new tag from renderxxx",
				// assetEntry.getEntryId());
				// System.out.println(assetEntry.getTitle());
				// AssetEntryLocalServiceUtil.addAssetTagAssetEntry(33, assetEntry.getEntryId())
				// ;
			}
			/*
			 * AssetTag assetTag =
			 * AssetTagServiceUtil.addTag(serviceContext.getScopeGroup().getGroupId(),
			 * "newtag3",serviceContext); System.out.println( assetTag.getPrimaryKey());
			 * for(int i = 0; i< assetEntries.size();i++) { if(i%2 == 0 ) {
			 * System.out.println("even"); AssetEntry assetEntry = assetEntries.get(i);
			 * //System.out.println(assetEntry.getTitle());
			 * AssetEntryLocalServiceUtil.addAssetTagAssetEntry(assetTag.getPrimaryKey(),
			 * assetEntry.getEntryId()) ; }else { System.out.println("odd"); }
			 * 
			 * }
			 */

			// System.out.println( AssetTagServiceUtil.getTag(1));
			ArrayList<User> users = getActiveUsers(serviceContext);
			ArrayList<Group> sites = getSites(serviceContext);
			renderRequest.setAttribute("users", users);
			renderRequest.setAttribute("sites", sites);
		} catch (Exception e) {
			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);
	}

	private ArrayList<User> getActiveUsers(ServiceContext serviceContext) {
		ArrayList<User> activeUsers = new ArrayList<User>();
		Integer userCount = UserLocalServiceUtil.getCompanyUsersCount(serviceContext.getCompanyId());

		List<User> users = UserLocalServiceUtil.getCompanyUsers(serviceContext.getCompanyId(), 0, userCount);
		for (User usr : users) {
			if (usr.isActive()) {
				activeUsers.add(usr);
			}
		}
		return activeUsers;
	}

	private ArrayList<Group> getSites(ServiceContext serviceContext) {
		ArrayList<Group> sites = new ArrayList<Group>();
		Integer groupCount = GroupLocalServiceUtil.getGroupsCount();
		List<Group> groups = GroupLocalServiceUtil.getCompanyGroups(serviceContext.getCompanyId(), 0, groupCount);
		for (Group group : groups) {
			if (group.isSite() && group.isRegularSite()) {

				sites.add(group);
			}
		}

		return sites;
	}

	@Override
	public void init() throws PortletException {

		super.init();
		_log.info("Starting IoT Catalogue plugin");
		List<Subscription> subscriptions = _subscriptionLocalService.getSubscriptions();

		for (Subscription subscription : subscriptions) {

			try {

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			syncDataWithIoTCatalogue(subscription);
		}
	}

	private void closeAllConnection() {
		_log.info("Closing all connections");
		
		for(Entry<String, Connector> entry: connections.entrySet()) {
			Connector connection = entry.getValue();
			connection.disconnect();
		}
		
		/*
		 * for (Entry<String, TPIData> entry : connections.entrySet()) { TPIData tpiData
		 * = entry.getValue(); tpiData.disconnect();
		 * 
		 * }
		 */

	}

	public void addSubscription(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subscription.class.getName(), request);

		String token = ParamUtil.getString(request, "token");
		String socketAddress = ParamUtil.getString(request, "socketAddress");

		long userId = ParamUtil.getLong(request, "User");
		long groupId = ParamUtil.getLong(request, "Site");
		long[] ids = serviceContext.getAssetCategoryIds();

		Subscription subscription = _subscriptionLocalService.addSubscription(userId, groupId, token, socketAddress,
				serviceContext);
		syncDataWithIoTCatalogue(subscription, 100);
		SessionMessages.add(request, "subscriptionAdded");

	}

	public void test(ActionRequest request, ActionResponse response) {
		/*try {
			//deleteAll(request,response);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
		List<IoTComponent> iotComponents = _ioTComponentLocalService.getIoTComponents();
		for(IoTComponent iotComponent: iotComponents) {
			System.out.println(iotComponent.getName() + " " + iotComponent.getSubscriptionId());
		}

		/*try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			System.out.println(serviceContext.getScopeGroupId());
			Subscription subscription = _subscriptionLocalService.getSubscriptions().get(0);
			System.out.println(subscription.getGroupId());
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			IoTValidation iotValidation = _iotValidationLocalService
					.getIoTValidationByOriginalId("5c3dc3770efe600de5612ea6");

			AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(IoTValidation.class.getName(),
					iotValidation.getPrimaryKey());

			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			TagManager.addTagNameToAsset(serviceContext, "New tag for validation", assetEntry.getEntryId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

	}

	public void deleteSubscriptionAction(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		long subscriptionId = Long.parseLong(request.getParameter("subscriptionId"));
		Subscription subscription = null;
		subscription = _subscriptionLocalService.getSubscription(subscriptionId);
		deleteSubscription(subscription, serviceContext, false);
	}

	public void deleteSubscriptionAndDataAction(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		long subscriptionId = Long.parseLong(request.getParameter("subscriptionId"));
		Subscription subscription = null;
		subscription = _subscriptionLocalService.getSubscription(subscriptionId);
		deleteSubscription(subscription, serviceContext, true);
	}

	public void disconnectAction(ActionRequest request, ActionResponse response) throws PortalException {

		long subscriptionId = Long.parseLong(request.getParameter("subscriptionId"));
		Subscription subscription = null;
		subscription = _subscriptionLocalService.getSubscription(subscriptionId);
		disconnect(subscription, 100);
	}

	public void connectAction(ActionRequest request, ActionResponse response) throws PortalException {
		long subscriptionId = Long.parseLong(request.getParameter("subscriptionId"));
		Subscription subscription = null;
		subscription = _subscriptionLocalService.getSubscription(subscriptionId);
		connect(subscription, 100);
	}

	public void deleteAll(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		deleteAllIoTComponents(serviceContext);
		deleteAllIoTValidations(serviceContext);
	}

	public void deleteAllIoTComponents(ServiceContext serviceContext) throws PortalException {

		List<IoTComponent> iotComponents = _ioTComponentLocalService.getIoTComponents();
		for (IoTComponent iotComponent : iotComponents) {
			_ioTComponentLocalService.deleteIoTComponent(iotComponent, serviceContext);
		}
	}

	public void deleteAllIoTValidations(ServiceContext serviceContext) throws PortalException {

		List<IoTValidation> iotValidations = _iotValidationLocalService.getIoTValidations();
		for (IoTValidation iotValidation : iotValidations) {
			_iotValidationLocalService.deleteIoTValidation(iotValidation, serviceContext);
		}
	}

	private void syncDataWithIoTCatalogue(Subscription subscription) {
		syncDataWithIoTCatalogue(subscription, 0);
	}

	private void syncDataWithIoTCatalogue(Subscription subscription, long delay) {

		String key = String.valueOf(subscription.getSubscriptionId());
		if (connections.get(key) == null) {

			try {

				String socketAddress = subscription.getSocketAddress();

				String token = subscription.getToken();
				//HashMap<String, String> props = new HashMap<String, String>();

				_log.info("Connecting to IoTCatalogue, socket address: " + socketAddress);
				HashMap<String, Object> props = new HashMap<String, Object>();
				HashMap<String, Integer> dataFields = new HashMap<String, Integer>();
				dataFields.put("name", 1);
				dataFields.put("tags", 1);
				dataFields.put("description", 1);
				props.put("dataFields", dataFields);
				Connector connection = new Connector(socketAddress, token, null,props ) {
					@Override
					public void onConnected() {
						// TODO Auto-generated method stub
						super.onConnected();
						_log.info("Connected to IoTCatalogue, socket address: " + socketAddress);
						/* todo: move to on loggin method*/
						String sessionId = "fake session id";
						try {
							_subscriptionLocalService.setSubscriptionConnectionInfo(subscription.getSubscriptionId(),
									sessionId, CONNECTED);
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}	
					
					/*
					@Override
					public void onLoggedIn() {
						
					}
					*/
					
					@Override
					public void onDisconnected() {
						// TODO Auto-generated method stub
						super.onDisconnected();
						_log.info("Disconnected from IoT Catalogue");
						try {
							_subscriptionLocalService.setSubscriptionConnectionState(subscription.getSubscriptionId(),DISCONNECTED);
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
					@Override
					public void onDataChange(String collectionName, String actionName, String id, Object obj) {
						// TODO Auto-generated method stub
						super.onDataChange(collectionName, actionName, id, obj);
						System.out.println(obj);
						try {
							ServiceContext serviceContext = getServiceContextFromSubscription(subscription);
							if(collectionName.equals(componentsCollectionName)) {
								if(actionName.equals(ADDED) || actionName.equals(CHANGED)) {
									updateIoTComponent(id, obj, serviceContext, subscription);
								}else if(actionName.equals(REMOVED)) {
									deleteIoTComponent(id, subscription, serviceContext);
								}
							}
							
							if(collectionName.equals(validationsCollectionName)) {
								if(actionName.equals(ADDED) || actionName.equals(CHANGED)) {
									updateIoTValidation(id, obj, serviceContext, subscription);
								}else if(actionName.equals(REMOVED)) {
									deleteIoTValidation(id, subscription, serviceContext);
								}
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				};
				/*TPIData tpiData = new TPIData(host, port, useSSL, token, props) {

					@Override
					public void onConnected(String sessionId, Object serviceInfo) {
						super.onConnected(sessionId, serviceInfo);
						_log.info("Connected to IoTCatalogue, host:" + host + " port:" + port);
						try {

							_subscriptionLocalService.setSubscriptionConnectionInfo(subscription.getSubscriptionId(),
									sessionId, String.valueOf(this.getConnectionState()));
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					@Override
					public void onDisconnectedFromRemote() {
						_log.info("Disconnected from IoT Catalogue");
						try {
							_subscriptionLocalService.setSubscriptionConnectionState(subscription.getSubscriptionId(),
									String.valueOf(this.getConnectionState()));
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

			
					}

					@Override
					public void onTPIChanged(Map<String, Object> data, String action,
							ArrayList<String> collectionNames) {
						ServiceContext serviceContext;
						try {
							serviceContext = getServiceContextFromSubscription(subscription);
							checkIoTComponentsToDelete(data, subscription, serviceContext);
							checkIoTValidationsToDelete(data, subscription, serviceContext);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						_log.info("Subscribe to collections on IoT Catalogue");
						this.subscribeToCollections();

					}

					@Override
					public void onElementChanged(String collectionName, String id, Object fields, String action) {
						_log.info("Element " + action + " on IoT Catalogue collection: " + collectionName + ", id: "
								+ id);
						try {
							ServiceContext serviceContext = getServiceContextFromSubscription(subscription);
							if (collectionName.equals(componentsCollectionName)) {
								if (action.equals(TPIData.ADDED) || action.equals(TPIData.CHANGED)) {
									updateIoTComponent(id, fields, serviceContext, subscription);
								} else if (action.equals(TPIData.REMOVED)) {
									deleteIoTComponent(id, subscription, serviceContext);
								}
							}
							if (collectionName.equals(validationsCollectionName)) {
								if (action.equals(TPIData.ADDED) || action.equals(TPIData.CHANGED)) {
									updateIoTValidation(id, fields, serviceContext, subscription);
								} else if (action.equals(TPIData.REMOVED)) {
									deleteIoTValidation(id, subscription, serviceContext);
								}
							}

						} catch (Exception ex) {
							ex.printStackTrace();
						}

					}
				};*/
				connections.put(key, connection);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private ServiceContext getServiceContextFromSubscription(Subscription subscription) throws Exception {
		ServiceContext serviceContext = new ServiceContext();
		long userId = subscription.getUserId();
		long companyId = CompanyLocalServiceUtil.getCompanyIdByUserId(userId);
		serviceContext.setUserId(userId);
		serviceContext.setScopeGroupId(subscription.getGroupId());
		serviceContext.setCompanyId(companyId);

		return serviceContext;
	}

	private void deleteIoTValidation(String id, Subscription subscription, ServiceContext serviceContext)
			throws PortalException {
		IoTValidation iotValidation = null;

		try {
			long groupId = subscription.getGroupId();
			iotValidation = _iotValidationLocalService.getIoTValidationByOriginalId(id, groupId);
		} catch (NoSuchIoTValidationException e) {
			// TODO Auto-generated catch block

		}
		if (iotValidation != null) {
			_iotValidationLocalService.deleteIoTValidation(iotValidation, serviceContext);
		}
	}

	private void deleteIoTComponent(String id, Subscription subscription, ServiceContext serviceContext)
			throws PortalException {
		IoTComponent ioTComponent = null;

		try {
			long groupId = subscription.getGroupId();
			ioTComponent = _ioTComponentLocalService.getIoTComponentByOriginalId(id, groupId);
		} catch (NoSuchIoTComponentException e) {
			// TODO Auto-generated catch block

		}

		if (ioTComponent != null) {
			_ioTComponentLocalService.deleteIoTComponent(ioTComponent, serviceContext);
		}
	}

	private void updateIoTComponent(String id, Object fields, ServiceContext serviceContext, Subscription subscription)
			throws PortalException {

		IoTComponent iotComponent = null;

		try {
			long groupId = subscription.getGroupId();
			iotComponent = _ioTComponentLocalService.getIoTComponentByOriginalId(id, subscription.getSubscriptionId());
		} catch (NoSuchIoTComponentException e) {
			// TODO Auto-generated catch block

		}

		Map<String, String> hashMap = (Map<String, String>) fields;

		String name = hashMap.get("name");
		String embeddedUrl = hashMap.get("_iframeURL");
		String imageUrl = hashMap.get("_imageUrl");
		String description = hashMap.get("description");

		long userId = subscription.getUserId();
		if (iotComponent == null) {
			_ioTComponentLocalService.addIoTComponent(userId, name, description, embeddedUrl, imageUrl, id,
					subscription.getSubscriptionId(), serviceContext);

		} else {
			long iotComponentId = iotComponent.getIotComponentId();
			_ioTComponentLocalService.updateIoTComponent(userId, iotComponentId, name, description, embeddedUrl,
					imageUrl, serviceContext);
		}

	}

	private void updateIoTValidation(String id, Object fields, ServiceContext serviceContext, Subscription subscription)
			throws PortalException {

		IoTValidation iotValidation = null;
		try {
			long groupId = subscription.getGroupId();
			iotValidation = _iotValidationLocalService.getIoTValidationByOriginalId(id,
					subscription.getSubscriptionId());
		} catch (NoSuchIoTValidationException e) {
			// TODO Auto-generated catch block

		}

		Map<String, String> hashMap = (Map<String, String>) fields;

		String name = hashMap.get("name");
		String embeddedUrl = hashMap.get("_embeddedUrl");
		String imageUrl = hashMap.get("_imageUrl");
		String description = hashMap.get("description");

		long userId = subscription.getUserId();
		if (iotValidation == null) {

			_iotValidationLocalService.addIoTValidation(userId, name, description, embeddedUrl, imageUrl, id,
					subscription.getSubscriptionId(), serviceContext);

		} else {
			long iotValidationId = iotValidation.getIotValidationId();
			_iotValidationLocalService.updateIoTValidation(userId, iotValidationId, name, description, embeddedUrl,
					imageUrl, serviceContext);
		}

	}

	private HashMap<String, Boolean> getIdsHashMap(ArrayList<String> ids) {
		HashMap<String, Boolean> idsHashMap = new HashMap<String, Boolean>();
		if (ids != null) {
			for (String id : ids) {
				idsHashMap.put(id, true);
			}

		}
		return idsHashMap;
	}

	private void checkIoTComponentsToDelete(Map<String, Object> data, Subscription subscription,
			ServiceContext serviceContext) {
		HashMap<String, HashMap<String, Boolean>> collectionHashMap = new HashMap<String, HashMap<String, Boolean>>();

		Map<String, ArrayList<String>> hashMap = (Map<String, ArrayList<String>>) data.get(componentsCollectionName);
		if (hashMap != null) {
			ArrayList<String> ids = hashMap.get("ids");
			long groupId = subscription.getGroupId();
			HashMap<String, Boolean> idsHashMap = getIdsHashMap(ids);

			List<IoTComponent> iotComponents = _ioTComponentLocalService
					.getIoTComponentsBySubscriptionId(subscription.getSubscriptionId());
			for (IoTComponent iotComponent : iotComponents) {
				try {

					String originalId = iotComponent.getOriginalId();

					Boolean exists = idsHashMap.get(originalId);
					if (exists == null || exists == false) {
						_ioTComponentLocalService.deleteIoTComponent(iotComponent, serviceContext);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}

		}

	}

	private void checkIoTValidationsToDelete(Map<String, Object> data, Subscription subscription,
			ServiceContext serviceContext) {
		HashMap<String, HashMap<String, Boolean>> collectionHashMap = new HashMap<String, HashMap<String, Boolean>>();

		Map<String, ArrayList<String>> hashMap = (Map<String, ArrayList<String>>) data.get(validationsCollectionName);
		if (hashMap != null) {

			ArrayList<String> ids = hashMap.get("ids");

			long groupId = subscription.getGroupId();
			HashMap<String, Boolean> idsHashMap = getIdsHashMap(ids);

			List<IoTValidation> iotValidations = _iotValidationLocalService
					.getIoTValidationsBySubscriptionId(subscription.getSubscriptionId());
			for (IoTValidation iotValidation : iotValidations) {
				try {

					String originalId = iotValidation.getOriginalId();

					Boolean exists = idsHashMap.get(originalId);
					if (exists == null || exists == false) {
						_iotValidationLocalService.deleteIoTValidation(iotValidation, serviceContext);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}

			}
		}

	}

	public void deleteSubscription(Subscription subscription, ServiceContext serviceContext,
			boolean shouldDeleteSubscriptionData) {
			String key = String.valueOf(subscription.getSubscriptionId());
			disconnect(subscription);
			Connector connector = connections.get(key);
			if (connector != null) {
	
				//connector.destroy();
				connector.disconnect();
				connections.remove(key);
			}
			if (shouldDeleteSubscriptionData) {
				try {
	
					List<IoTComponent> iotComponents = _ioTComponentLocalService
							.getIoTComponentsBySubscriptionId(subscription.getSubscriptionId());
					List<IoTValidation> iotValidations = _iotValidationLocalService
							.getIoTValidationsBySubscriptionId(subscription.getSubscriptionId());
					for (IoTComponent iotComponent : iotComponents) {
						_ioTComponentLocalService.deleteIoTComponent(iotComponent, serviceContext);
					}
	
					for (IoTValidation iotValidation : iotValidations) {
						_iotValidationLocalService.deleteIoTValidation(iotValidation, serviceContext);
					}
	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
			}

		_subscriptionLocalService.deleteSubscription(subscription);

	}

	private void disconnect(Subscription subscription) {
		disconnect(subscription, 0);
	}

	private void disconnect(Subscription subscription, long delay) {
		String key = String.valueOf(subscription.getSubscriptionId());
		_log.info("Disconnecting from IoT Catalogue subscriptionId: " + key);
		Connector connection = connections.get(key);
		if (connection != null) { 
			connection.disconnect();
			
			try {
				Thread.sleep(delay);
				_subscriptionLocalService.setSubscriptionConnectionState(subscription.getSubscriptionId(),DISCONNECTED);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void connect(Subscription subscription) {
		connect(subscription, 0);
	}

	private void connect(Subscription subscription, long delay) {
		
		 String key = String.valueOf(subscription.getSubscriptionId());
		 
		 Connector connection = connections.get(key);
		 if(connection != null) {
			 connection.connect();
			 try {
				_subscriptionLocalService.setSubscriptionConnectionState(subscription.getSubscriptionId(), CONNECTED);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }

	}

	public void deleteAllSubscriptions(ActionRequest request, ActionResponse response) throws PortalException {
		/*
		 * _log.info("Deleting all subscriptions"); ServiceContext serviceContext =
		 * ServiceContextFactory.getInstance(request); List<Subscription> subscriptions
		 * = _subscriptionLocalService.getSubscriptions(); for (Subscription
		 * subscription : subscriptions) { deleteSubscription(subscription,
		 * serviceContext, false); }
		 */
	}

	@Reference(unbind = "-")
	protected void setIoTComponentLocalService(IoTComponentLocalService ioTComponentLocalService) {
		_ioTComponentLocalService = ioTComponentLocalService;
	}

	private IoTComponentLocalService _ioTComponentLocalService;

	@Reference(unbind = "-")
	protected void setIoTValidationLocalService(IoTValidationLocalService iotValidationLocalService) {
		_iotValidationLocalService = iotValidationLocalService;
	}

	private IoTValidationLocalService _iotValidationLocalService;

	@Reference(unbind = "-")
	protected void setSubscriptionLocalService(SubscriptionLocalService subscriptionLocalService) {

		_subscriptionLocalService = subscriptionLocalService;
	}

	private SubscriptionLocalService _subscriptionLocalService;

	// private TPIData tpiData = null;

	private HashMap<String, Connector> connections = new HashMap<String, Connector>();

	// private Subscription currentSubscription = null;

	private final String componentsCollectionName = "components";
	private final String validationsCollectionName = "validations";

	private static final Log _log = LogFactoryUtil.getLog(ElementListAdminPortlet.class);
	
	private static final String CONNECTED = "Connected";
	private static final String DISCONNECTED = "Disconnected";
	
	private static final String ADDED = "added";
	private static final String CHANGED = "changed";
	private static final String REMOVED = "removed";

}
