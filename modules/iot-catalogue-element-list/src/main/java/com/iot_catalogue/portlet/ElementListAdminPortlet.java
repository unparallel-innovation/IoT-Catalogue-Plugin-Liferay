package com.iot_catalogue.portlet;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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
import com.iot_catalogue.model.ComponentChild;
import com.iot_catalogue.model.ElementCoordinate;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.model.Subscription;
import com.iot_catalogue.model.ValidationChild;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.portlet.utils.AssetRelationsPopulator;
import com.iot_catalogue.service.ComponentChildLocalService;
import com.iot_catalogue.service.ElementCoordinateLocalService;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.iot_catalogue.service.IoTValidationLocalService;
import com.iot_catalogue.service.SubscriptionLocalService;
import com.iot_catalogue.service.ValidationChildLocalService;
import com.iot_catalogue.tpi_plugin.TPIData;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
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

		List<ElementCoordinate> elementCoordinates = _elementCoordinateLocalService.getElementCoordinates();

		for (ElementCoordinate elementCoordinate : elementCoordinates) {
			_elementCoordinateLocalService.deleteElementCoordinate(elementCoordinate);
		}

		List<Subscription> subscriptions = _subscriptionLocalService.getSubscriptions();

		for (Subscription subscription : subscriptions) {
			syncDataWithIoTCatalogue(subscription);
		}
	}

	private void closeAllConnection() {
		_log.info("Closing all connections");
		for (Entry<String, TPIData> entry : connections.entrySet()) {
			TPIData tpiData = entry.getValue();
			tpiData.disconnect();

		}

	}

	public void addSubscription(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subscription.class.getName(), request);

		String token = ParamUtil.getString(request, "token");
		String host = ParamUtil.getString(request, "host");

		String componentPagePath = ParamUtil.getString(request, "componentPagePath");
		String validationPagePath = ParamUtil.getString(request, "validationPagePath");

		Integer port = ParamUtil.getInteger(request, "port");
		long userId = ParamUtil.getLong(request, "User");
		long groupId = ParamUtil.getLong(request, "Site");
		boolean useSSL = ParamUtil.getString(request, "useSSL").equals("on")
				|| ParamUtil.getString(request, "useSSL").equals("true");
		long[] ids = serviceContext.getAssetCategoryIds();

		Subscription subscription = _subscriptionLocalService.addSubscription(userId, groupId, token, host,
				componentPagePath, validationPagePath, port, useSSL, serviceContext);

		syncDataWithIoTCatalogue(subscription, 100);
		SessionMessages.add(request, "subscriptionAdded");

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

	private ResettableTimer getTimer(Subscription subscription) {
		ScheduledExecutorService scheduler = new ScheduledThreadPoolExecutor(1);
		final ResettableTimer timer = new ResettableTimer(scheduler, timeout, TimeUnit.MILLISECONDS, new Runnable() {
			public void run() {
				_log.info("Processing asset relations");
				addComponentAssetRelations(subscription);
				addValidationAssetRelations(subscription);

			}
		});
		return timer;
	}

	private void addComponentAssetRelations(Subscription subscription) {

		AssetRelationsPopulator assetRelationsPopulator = new AssetRelationsPopulator(_assetLinkLocalService) {
			@Override
			public AssetEntry getAssetEntry(Object element) {
				ComponentChild componentChild = (ComponentChild) element;
				try {
					IoTComponent iotComponent = _ioTComponentLocalService.getIoTComponentByOriginalId(
							componentChild.getComponentOrignalId(), subscription.getSubscriptionId());

					return _assetEntryLocalService.getEntry(IoTComponent.class.getName(), iotComponent.getPrimaryKey());
				} catch (PortalException e) {
				}
				return null;
			}

			@Override
			public AssetEntry getChildAssetEntry(Object element) {
				ComponentChild componentChild = (ComponentChild) element;
				try {
					IoTComponent childComponent = _ioTComponentLocalService.getIoTComponentByOriginalId(
							componentChild.getChildComponentOriginalId(), subscription.getSubscriptionId());
					return _assetEntryLocalService.getEntry(IoTComponent.class.getName(),
							childComponent.getPrimaryKey());
				} catch (PortalException e) {
				}
				return null;

			}
		};
		List<ComponentChild> componentChilds = _componentChildLocalService
				.getComponentChildsBySubscriptionId(subscription.getSubscriptionId());
		_log.info("Processing component relations");
		assetRelationsPopulator.addAssetRelations(componentChilds, subscription.getUserId());

	}

	private void addValidationAssetRelations(Subscription subscription) {

		AssetRelationsPopulator assetRelationsPopulator = new AssetRelationsPopulator(_assetLinkLocalService) {
			@Override
			public AssetEntry getAssetEntry(Object element) {
				ValidationChild validationChild = (ValidationChild) element;
				try {
					IoTValidation ioTValidation = _iotValidationLocalService.getIoTValidationByOriginalId(
							validationChild.getValidationOrignalId(), subscription.getSubscriptionId());

					return _assetEntryLocalService.getEntry(IoTValidation.class.getName(),
							ioTValidation.getPrimaryKey());
				} catch (PortalException e) {
				}
				return null;
			}

			@Override
			public AssetEntry getChildAssetEntry(Object element) {
				ValidationChild validationChild = (ValidationChild) element;
				try {
					IoTValidation ioTValidation = _iotValidationLocalService.getIoTValidationByOriginalId(
							validationChild.getChildValidationOriginalId(), subscription.getSubscriptionId());
					return _assetEntryLocalService.getEntry(IoTValidation.class.getName(),
							ioTValidation.getPrimaryKey());
				} catch (PortalException e) {
				}
				return null;

			}

			@Override
			public void assetProcessed(Long assetId, List<Long> childAssetIds) {

			}
		};
		List<ValidationChild> validationChilds = _validationChildLocalService
				.getValidationChildsBySubscriptionId(subscription.getSubscriptionId());
		_log.info("Processing validations relations");
		assetRelationsPopulator.addAssetRelations(validationChilds, subscription.getUserId());

	}

	private void syncDataWithIoTCatalogue(Subscription subscription, long delay) {
		ResettableTimer timer = getTimer(subscription);
		String key = String.valueOf(subscription.getSubscriptionId());
		if (connections.get(key) == null) {

			try {

				String host = subscription.getHost();
				Integer port = subscription.getPort();
				boolean useSSL = subscription.getUseSSL();
				String token = subscription.getToken();
				HashMap<String, String> props = new HashMap<String, String>();
				props.put("componentPagePath", subscription.getComponentPagePath());
				props.put("validationPagePath", subscription.getValidationPagePath());
				_log.info("Connecting to IoTCatalogue, host: " + host + ", port: " + port);
				TPIData tpiData = new TPIData(host, port, useSSL, token, props) {

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

						/*
						 * try {
						 * 
						 * //_subscriptionLocalService.setSubscriptionConnectionState(subscription.
						 * getSubscriptionId(), String.valueOf(this.getConnectionState())); } catch
						 * (PortalException e) { // TODO Auto-generated catch block e.printStackTrace();
						 * }
						 */
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
								timer.reset(false);
								if (action.equals(TPIData.ADDED) || action.equals(TPIData.CHANGED)) {
									updateIoTComponent(id, fields, serviceContext, subscription);
								} else if (action.equals(TPIData.REMOVED)) {
									deleteIoTComponent(id, subscription, serviceContext);
								}
							}
							if (collectionName.equals(validationsCollectionName)) {
								timer.reset(false);
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
				};
				connections.put(key, tpiData);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
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
			_elementCoordinateLocalService.deleteElementCoordinates(subscription.getSubscriptionId(),
					iotValidation.getOriginalId(), IoTValidation.class.getName());
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
			_elementCoordinateLocalService.deleteElementCoordinates(subscription.getSubscriptionId(),
					ioTComponent.getOriginalId(), IoTComponent.class.getName());
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

		Map<String, Object> hashMap = (Map<String, Object>) fields;

		String name = (String) hashMap.get("name");
		String embeddedUrl = (String) hashMap.get("_embeddedUrl");
		String imageUrl = (String) hashMap.get("_imageUrl");
		String description = (String) hashMap.get("description");
		List<String> tagNames = (List<String>) hashMap.get("_tagNames");
		List<Object> components = (List<Object>) hashMap.get("components");
		System.out.println("*******");
		if(components != null) {
			System.out.println(components.size());
		}
		processComponentIds(id, components, subscription, serviceContext);
		long userId = subscription.getUserId();

		if (iotComponent == null) {

			IoTComponent newIoTComponent = _ioTComponentLocalService.addIoTComponent(userId, name, description,
					embeddedUrl, imageUrl, tagNames, id, subscription.getSubscriptionId(), serviceContext);

		} else {
			long iotComponentId = iotComponent.getIotComponentId();
			_ioTComponentLocalService.updateIoTComponent(userId, iotComponentId, name, description, embeddedUrl,
					imageUrl, tagNames, serviceContext);
		}

	}

	private void processComponentIds(String originalId, List<Object> components, Subscription subscription,
			ServiceContext serviceContext) {

		List<ComponentChild> componentChilds = _componentChildLocalService.getComponentChilds(originalId,
				subscription.getSubscriptionId());

		for (ComponentChild componentChild : componentChilds) {
			try {
				_componentChildLocalService.deleteComponentChild(componentChild.getId());
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		long userId = subscription.getUserId();
		if (components != null) {
			for (Object element : components) {
				Map<String, Object> hashMap = (Map<String, Object>) element;
				List<String> newIds = (List<String>) hashMap.get("ids");
				for (String id : newIds) {
					try {
						_componentChildLocalService.addComponentChild(userId, originalId, id,
								subscription.getSubscriptionId(), serviceContext);
					} catch (PortalException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
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

		Map<String, Object> hashMap = (Map<String, Object>) fields;
		List<Map<String, Double>> coordinates = (List<Map<String, Double>>) hashMap.get("_coordinates");

		String name = (String) hashMap.get("name");
		String embeddedUrl = (String) hashMap.get("_embeddedUrl");
		String imageUrl = (String) hashMap.get("_imageUrl");
		String description = (String) hashMap.get("description");
		List<String> tagNames = (List<String>) hashMap.get("_tagNames");
		String parent = (String) hashMap.get("parent");
		processValidationParent(id, parent, subscription, serviceContext);
		long userId = subscription.getUserId();

		if (iotValidation == null) {

			IoTValidation newIoTValidation = _iotValidationLocalService.addIoTValidation(userId, name, description,
					embeddedUrl, imageUrl, tagNames, id, subscription.getSubscriptionId(), serviceContext);
			_elementCoordinateLocalService.deleteElementCoordinates(subscription.getSubscriptionId(),
					newIoTValidation.getOriginalId(), IoTValidation.class.getName());

			if (coordinates != null) {
				for (Map<String, Double> coordinate : coordinates) {
					double latitude = coordinate.get("lat").doubleValue();
					double longitude = coordinate.get("long").doubleValue();
					_elementCoordinateLocalService.addElementCoordinate(userId, newIoTValidation.getOriginalId(),
							IoTValidation.class.getName(), latitude, longitude, subscription.getSubscriptionId(),
							serviceContext);
				}
			}

		} else {
			long iotValidationId = iotValidation.getIotValidationId();
			_elementCoordinateLocalService.deleteElementCoordinates(subscription.getSubscriptionId(),
					iotValidation.getOriginalId(), IoTValidation.class.getName());
			if (coordinates != null) {
				for (Map<String, Double> coordinate : coordinates) {
					double latitude = coordinate.get("lat").doubleValue();
					double longitude = coordinate.get("long").doubleValue();
					_elementCoordinateLocalService.addElementCoordinate(userId, iotValidation.getOriginalId(),
							IoTValidation.class.getName(), latitude, longitude, subscription.getSubscriptionId(),
							serviceContext);
				}
			}
			_iotValidationLocalService.updateIoTValidation(userId, iotValidationId, name, description, embeddedUrl,
					imageUrl, tagNames, serviceContext);
		}

	}

	private void processValidationParent(String id, String parent, Subscription subscription,
			ServiceContext serviceContext) {

		List<ValidationChild> validationChilds = _validationChildLocalService.getValidationChildsByChild(id,
				subscription.getSubscriptionId());
		for (ValidationChild validationChild : validationChilds) {
			try {
				_validationChildLocalService.deleteValidationChild(validationChild.getId());
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long userId = subscription.getUserId();
		if (parent != null) {
			try {
				_validationChildLocalService.addValidationChild(userId, parent, id, subscription.getSubscriptionId(),
						serviceContext);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
						_elementCoordinateLocalService.deleteElementCoordinates(subscription.getSubscriptionId(),
								iotComponent.getOriginalId(), IoTComponent.class.getName());
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
						_elementCoordinateLocalService.deleteElementCoordinates(subscription.getSubscriptionId(),
								iotValidation.getOriginalId(), IoTValidation.class.getName());
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
		TPIData tpiData = connections.get(key);
		if (tpiData != null) {

			tpiData.destroy();
			connections.remove(key);
		}
		if (shouldDeleteSubscriptionData) {
			try {

				List<IoTComponent> iotComponents = _ioTComponentLocalService
						.getIoTComponentsBySubscriptionId(subscription.getSubscriptionId());
				List<IoTValidation> iotValidations = _iotValidationLocalService
						.getIoTValidationsBySubscriptionId(subscription.getSubscriptionId());

				List<ElementCoordinate> elementCoordinates = _elementCoordinateLocalService
						.getElementCoordinatesBySubscriptionId(subscription.getSubscriptionId());

				for (IoTComponent iotComponent : iotComponents) {
					_ioTComponentLocalService.deleteIoTComponent(iotComponent, serviceContext);
				}

				for (IoTValidation iotValidation : iotValidations) {
					_iotValidationLocalService.deleteIoTValidation(iotValidation, serviceContext);
				}
				for (ElementCoordinate elementCoordinate : elementCoordinates) {
					_elementCoordinateLocalService.deleteElementCoordinate(elementCoordinate);
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
		TPIData tpiData = connections.get(key);

		if (tpiData != null) {
			try {

				tpiData.disconnect();
				Thread.sleep(delay);
				_subscriptionLocalService.setSubscriptionConnectionState(subscription.getSubscriptionId(),
						String.valueOf(tpiData.getConnectionState()));
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

		TPIData tpiData = connections.get(key);
		if (tpiData != null) {
			tpiData.connect();

			try {
				Thread.sleep(delay);
				_subscriptionLocalService.setSubscriptionConnectionState(subscription.getSubscriptionId(),
						String.valueOf(tpiData.getConnectionState()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void test(ActionRequest request, ActionResponse response) throws PortalException {
		System.out.println(_elementCoordinateLocalService.getElementCoordinatesCount());
		System.out.println(_elementCoordinateLocalService.getElementCoordinates(0, 100));
		/*
		 * Object o = new DLFileEntryDDMFormValuesReader(null, null); AssetRenderer ar =
		 * null;
		 * 
		 * 
		 * 
		 * DDMFormFieldValue ddmFormFieldValue = new DDMFormFieldValue();
		 * 
		 * Value value = new LocalizedValue(); value.addString(null,
		 * "{\"latitude\":38.0119156,\"longitude\":-6.8663008}");
		 * ddmFormFieldValue.setValue(value);
		 */

		/*
		 * System.out.println(_assetEntryLocalService.getAssetEntriesCount());
		 * 
		 * List<AssetEntry> assetEntries = _assetEntryLocalService.getAssetEntries(0,
		 * 200); for(AssetEntry assetEntry: assetEntries) {
		 * if(assetEntry.getClassName().equals(JournalArticle.class.getName())) {
		 * System.out.println(assetEntry.getTitle()); AssetRenderer assetRenderer =
		 * assetEntry.getAssetRenderer(); DDMFormValuesReader ddmFormValuesReader =
		 * assetRenderer.getDDMFormValuesReader();
		 * printCoordinatesFromDDMForm(ddmFormValuesReader);
		 * 
		 * }
		 * 
		 * }
		 */
	}

	public void deleteAllSubscriptions(ActionRequest request, ActionResponse response) throws PortalException {
		_log.info("Deleting all subscriptions");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		List<Subscription> subscriptions = _subscriptionLocalService.getSubscriptions();
		for (Subscription subscription : subscriptions) {
			deleteSubscription(subscription, serviceContext, false);
		}
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

	@Reference(unbind = "-")
	protected void setElementCoordinateLocalService(ElementCoordinateLocalService elementCoordinateLocalService) {

		_elementCoordinateLocalService = elementCoordinateLocalService;
	}

	private ElementCoordinateLocalService _elementCoordinateLocalService;

	@Reference(unbind = "-")
	protected void setAssetEntryLocalService(AssetEntryLocalService assetEntryLocalService) {

		_assetEntryLocalService = assetEntryLocalService;
	}

	private AssetEntryLocalService _assetEntryLocalService = null;

	// private TPIData tpiData = null;

	private HashMap<String, TPIData> connections = new HashMap<String, TPIData>();

	// private Subscription currentSubscription = null;

	private final String componentsCollectionName = "components";
	private final String validationsCollectionName = "validations";

	@Reference(unbind = "-")
	protected void setAssetLinkLocalService(AssetLinkLocalService assetLinkLocalService) {

		_assetLinkLocalService = assetLinkLocalService;
	}

	@Reference(unbind = "-")
	protected void setValidationChildLocalService(ValidationChildLocalService validationChildLocalService) {

		_validationChildLocalService = validationChildLocalService;
	}

	private ValidationChildLocalService _validationChildLocalService = null;

	@Reference(unbind = "-")
	protected void setComponentChildLocalService(ComponentChildLocalService componentChildLocalService) {

		_componentChildLocalService = componentChildLocalService;
	}

	private ComponentChildLocalService _componentChildLocalService = null;

	private AssetLinkLocalService _assetLinkLocalService = null;
	private static final Log _log = LogFactoryUtil.getLog(ElementListAdminPortlet.class);
	private HashMap<String, ResettableTimer> timers = new HashMap<String, ResettableTimer>();
	private static final int timeout = 5000;
}
