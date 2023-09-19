package com.iot_catalogue.portlet;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.iot_catalogue.exception.NoSuchIoTComponentException;
import com.iot_catalogue.exception.NoSuchIoTValidationException;
import com.iot_catalogue.model.ComponentChild;
import com.iot_catalogue.model.ElementCoordinate;
import com.iot_catalogue.model.ElementEntity;
import com.iot_catalogue.model.ElementStandard;
import com.iot_catalogue.model.IoTComponent;
import com.iot_catalogue.model.IoTValidation;
import com.iot_catalogue.model.Subscription;
import com.iot_catalogue.model.ValidationChild;
import com.iot_catalogue.portlet.constants.ElementListPortletKeys;
import com.iot_catalogue.portlet.utils.AssetRelationsPopulator;
import com.iot_catalogue.portlet.utils.DataUtils;
import com.iot_catalogue.portlet.utils.FileRequest;
import com.iot_catalogue.portlet.utils.PDFGeneration;
import com.iot_catalogue.portlet.utils.ZIPDownloader;
import com.iot_catalogue.service.ComponentChildLocalService;
import com.iot_catalogue.service.ElementCoordinateLocalService;
import com.iot_catalogue.service.ElementEntityLocalService;
import com.iot_catalogue.service.ElementStandardLocalService;
import com.iot_catalogue.service.IoTComponentLocalService;
import com.iot_catalogue.service.IoTValidationLocalService;
import com.iot_catalogue.service.SubscriptionLocalService;
import com.iot_catalogue.service.ValidationChildLocalService;
import com.iot_catalogue.tpi_plugin.Connection;
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
import com.liferay.portal.kernel.search.IndexWriterHelperUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

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

			String subscriptionId = ParamUtil.getString(renderRequest, "subscriptionId");
			boolean getEntries = ParamUtil.getBoolean(renderRequest, "getEntries");
			if (getEntries && !subscriptionId.equals("")) {
				Subscription subscription = _subscriptionLocalService.getSubscription(Long.parseLong(subscriptionId));
				String token = subscription.getToken();
			//	Connection connection = connections.get(subscriptionId).getConnection();
				//List<Map<String, Object>> entries = PDFGeneration.getQueueEntries(connection, token, true);

			//	renderRequest.setAttribute("entries", entries);
			}


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
		deleteClassEntityDocuments(IoTComponent.class.getName());
		deleteClassEntityDocuments(IoTValidation.class.getName());
		List<ElementCoordinate> elementCoordinates = _elementCoordinateLocalService.getElementCoordinates();

		for (ElementCoordinate elementCoordinate : elementCoordinates) {
			_elementCoordinateLocalService.deleteElementCoordinate(elementCoordinate);
		}
	
		List<ElementEntity> elementEntities = _elementEntityLocalService.getElementEntities();
		
		for(ElementEntity elementEntity : elementEntities) {
			_elementEntityLocalService.deleteElementEntity(elementEntity);
		}
		
		List<ElementStandard> elementStandards = _elementStandardLocalService.getElementStandards();
		
		
		
		for(ElementStandard elementStandard: elementStandards) {
			_elementStandardLocalService.deleteElementStandard(elementStandard);
		}
		
		List<Subscription> subscriptions = _subscriptionLocalService.getSubscriptions();

		for (Subscription subscription : subscriptions) {
			syncDataWithIoTCatalogue(subscription);
		}
	}

	private void deleteClassEntityDocuments(String className) {
		Indexer<?> indexer = IndexerRegistryUtil.getIndexer(className);
		try {
			IndexWriterHelperUtil.deleteEntityDocuments(indexer.getSearchEngineId(), PortalUtil.getDefaultCompanyId(),
					className, true);
		} catch (SearchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void closeAllConnection() {
		for (Entry<String, TPIData> entry : connections.entrySet()) {
			TPIData tpiData = entry.getValue();
			tpiData.disconnect();

		}

	}

	public void addFilesToQueue(ActionRequest request, ActionResponse response)
			throws InterruptedException, NumberFormatException, PortalException, ExecutionException {
	/*	boolean includeComponents = ParamUtil.getString(request, "includeComponents").equals("on")
				|| ParamUtil.getString(request, "includeComponents").equals("true");
		boolean includeValidations = ParamUtil.getString(request, "includeValidations").equals("on")
				|| ParamUtil.getString(request, "includeValidations").equals("true");
		String subcriptionId = ParamUtil.getString(request, "subscriptionId");
		Subscription subscription = _subscriptionLocalService.getSubscription(Long.parseLong(subcriptionId));
		TPIData connection = connections.get(subcriptionId);
		try {
			ThemeDisplay  themeDisplay=(ThemeDisplay)request.getAttribute(		WebKeys.THEME_DISPLAY);

			String logo = themeDisplay.getLayoutSetLogo()!=null?themeDisplay.getLayoutSetLogo():themeDisplay.getCompanyLogo();
			String logoPath = PortalUtil.getPortalURL(themeDisplay) + logo;
			PDFGeneration.addRequestToQueue(includeComponents, includeValidations, subscription.getToken(),
					connection.getConnection(),logoPath);

			// response.setRenderParameter("addedToQueue", "true");
		} catch (TimeoutException e) {
			SessionErrors.add(request, e.getClass());
		}*/

	}
	
	public void deleteExportedDocuments(ActionRequest request, ActionResponse response) throws NumberFormatException, PortalException, InterruptedException, ExecutionException {
	/*	String subcriptionId = ParamUtil.getString(request, "subscriptionId");
		String requestId = ParamUtil.getString(request, "requestId");
		
		Subscription subscription = _subscriptionLocalService.getSubscription(Long.parseLong(subcriptionId));
		Connection connection = connections.get(subcriptionId).getConnection();
		String token = subscription.getToken();
		try {
			PDFGeneration.deleteExportedDocuments(connection, requestId, token);
		}catch (TimeoutException e) {
			SessionErrors.add(request, e.getClass());
		}*/
		
	}

	public void addSubscription(ActionRequest request, ActionResponse response)
			throws PortalException, InterruptedException, ExecutionException {
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

		CompletableFuture<String> completableFuture = syncDataWithIoTCatalogue(subscription);
		try {
			if (!completableFuture.isDone()) {
				completableFuture.get(10, TimeUnit.SECONDS);
			}

			SessionMessages.add(request, "subscriptionAdded");
		} catch (TimeoutException e) {
			SessionErrors.add(request, e.getClass());
		}

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

	private CompletableFuture<String> syncDataWithIoTCatalogue(Subscription subscription) {
		return syncDataWithIoTCatalogue(subscription, 0);
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

	private CompletableFuture<String> syncDataWithIoTCatalogue(Subscription subscription, long delay) {
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
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
					public void onConnected(String sessionId) {
						
						_log.info("Connected to IoTCatalogue, host:" + host + " port:" + port);
						try {

							_subscriptionLocalService.setSubscriptionConnectionInfo(subscription.getSubscriptionId(),
									sessionId, String.valueOf(this.getConnectionState()));
							completableFuture.complete("");
						} catch (PortalException e) {
							// TODO Auto-generated catch block

							e.printStackTrace();
						}
						super.onConnected(sessionId);
					}

					@Override
					public void onDisconnectedFromRemote() {
						_log.info("***************Disconnected from IoT Catalogue");
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
					/*	System.out.println("******onTPIChanged");
						System.out.println(data);
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
						this.subscribeToCollections();*/

					}

					@Override
					public void onElementChanged(String collectionName, String id, Object fields, String action) {
						/*System.out.println("********onElementChanged");
						System.out.println(collectionName);
						System.out.println(id);
						System.out.println(fields);
						System.out.println(action);*/
						_log.info("Element " + action + " on IoT Catalogue collection: " + collectionName + ", id: "+ id);
						System.out.println("xxxxx");
						try {
							_log.info(1);
							ServiceContext serviceContext = getServiceContextFromSubscription(subscription);
							_log.info(2);
							if (collectionName.equals(componentsCollectionName)) {
								_log.info(3);
								timer.reset(false);
								_log.info(4);
								if (action.equals(TPIData.ADDED) || action.equals(TPIData.CHANGED)) {
									_log.info(5);
									updateIoTComponent(id, fields, serviceContext, subscription);
									_log.info(6);
								} else if (action.equals(TPIData.REMOVED)) {
									_log.info(7);
									deleteIoTComponent(id, subscription, serviceContext);
								}
							}
							if (collectionName.equals(validationsCollectionName)) {
								_log.info(8);
								timer.reset(false);
								_log.info(9);
								if (action.equals(TPIData.ADDED) || action.equals(TPIData.CHANGED)) {
									_log.info(10);
									updateIoTValidation(id, fields, serviceContext, subscription);
									_log.info(11);
								} else if (action.equals(TPIData.REMOVED)) {
									_log.info(12);
									deleteIoTValidation(id, subscription, serviceContext);
									_log.info(13);
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
		} else {
			completableFuture.complete("");
		}

		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return completableFuture;
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

			iotValidation = _iotValidationLocalService.getIoTValidationByOriginalId(id, subscription.getSubscriptionId());
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

		_log.info("deleteIoTComponent");
		try {

			ioTComponent = _ioTComponentLocalService.getIoTComponentByOriginalId(id, subscription.getSubscriptionId());
			
		} catch (NoSuchIoTComponentException e) {
			// TODO Auto-generated catch block
			_log.error(e);
		}
		_log.info(ioTComponent==null?"null":"not null");
		_log.info(subscription.getSubscriptionId());
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
			_log.error(e);

		}
		

		Map<String, Object> hashMap = (Map<String, Object>) fields;

		String name = (String) hashMap.get("name");
		String embeddedUrl = (String) hashMap.get("_embeddedUrl");
		String imageUrl = (String) hashMap.get("_imageUrl");
		String description = (String) hashMap.get("description");
		String website = (String) hashMap.get("_website");
		String status = (String) hashMap.get("_status");
		String license = (String) hashMap.get("_license");
		String trl = "";
		
		if(hashMap.get("_trl") != null) {
			trl = hashMap.get("_trl").toString();
			
		}
		

		
		
		List<String> tagNames = (List<String>) hashMap.get("_tagNames");
		List<HashMap<String, Object>> categoriesPaths = DataUtils
				.getCategoriesPathFromTagsPath(hashMap.get("_tagsPath"));
		List<Object> components = (List<Object>) hashMap.get("components");
	
		processComponentIds(id, components, subscription, serviceContext);
		long userId = subscription.getUserId();
		List<Map<String, String>> manufacturers = (List<Map<String, String>>) hashMap.get("_manufacturers");
		List<Map<String, String>> developers = (List<Map<String, String>>) hashMap.get("_developers");
		List<String> standards = (List<String>) hashMap.get("_standards");
		if (iotComponent == null) {

			IoTComponent newIoTComponent = _ioTComponentLocalService.addIoTComponent(userId, name, description, website,
					embeddedUrl, imageUrl, status,license, trl, categoriesPaths, id, subscription.getSubscriptionId(),
					serviceContext);
			addElementEntities(subscription,newIoTComponent.getOriginalId(),developers,manufacturers,serviceContext);
			addElementStandards(subscription,newIoTComponent.getOriginalId(),standards,serviceContext);

		} else {

			long iotComponentId = iotComponent.getIotComponentId();
			_ioTComponentLocalService.updateIoTComponent(userId, iotComponentId, name, description, website,
					embeddedUrl, imageUrl, status,license, trl, categoriesPaths, serviceContext);
			addElementEntities(subscription, iotComponent.getOriginalId(),developers,manufacturers,serviceContext);
			addElementStandards(subscription,iotComponent.getOriginalId(),standards,serviceContext);
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
			_log.error(e);

		}

		Map<String, Object> hashMap = (Map<String, Object>) fields;
		List<Map<String, Double>> coordinates = (List<Map<String, Double>>) hashMap.get("_coordinates");

		String name = (String) hashMap.get("name");
		String embeddedUrl = (String) hashMap.get("_embeddedUrl");
		String imageUrl = (String) hashMap.get("_imageUrl");
		String description = (String) hashMap.get("description");
		String website = (String) hashMap.get("_website");
		String status = (String) hashMap.get("_status");

		List<String> tagNames = (List<String>) hashMap.get("_tagNames");

		List<HashMap<String, Object>> categoriesPaths = DataUtils
				.getCategoriesPathFromTagsPath(hashMap.get("_tagsPath"));

		String parent = (String) hashMap.get("parent");
		processValidationParent(id, parent, subscription, serviceContext);
		long userId = subscription.getUserId();

		if (iotValidation == null) {

			IoTValidation newIoTValidation = _iotValidationLocalService.addIoTValidation(userId, name, description,
					website, embeddedUrl, imageUrl, status, categoriesPaths, id, subscription.getSubscriptionId(),
					serviceContext);
			addElementCoordinates(subscription,newIoTValidation.getOriginalId(),coordinates,serviceContext);


		} else {
			long iotValidationId = iotValidation.getIotValidationId();
			addElementCoordinates(subscription,iotValidation.getOriginalId(),coordinates,serviceContext);
			_iotValidationLocalService.updateIoTValidation(userId, iotValidationId, name, description, website,
					embeddedUrl, imageUrl, status, categoriesPaths, serviceContext);
		}

	}

	
	private void addElementCoordinates(Subscription subscription, String originalId,List<Map<String, Double>>  coordinates, ServiceContext serviceContext) throws PortalException {
		long userId = subscription.getUserId();
		_elementCoordinateLocalService.deleteElementCoordinates(subscription.getSubscriptionId(),
				originalId, IoTValidation.class.getName());
		if (coordinates != null) {
			for (Map<String, Double> coordinate : coordinates) {
				double latitude = coordinate.get("lat").doubleValue();
				double longitude = coordinate.get("long").doubleValue();
				_elementCoordinateLocalService.addElementCoordinate(userId, originalId,
						IoTValidation.class.getName(), latitude, longitude, subscription.getSubscriptionId(),
						serviceContext);
			}
		}
	
	}
	
	private void addElementEntities(Subscription subscription, String originalId, List<Map<String, String>> developers, List<Map<String, String>> manufacturers, ServiceContext serviceContext) throws PortalException {
		long userId = subscription.getUserId();
		if(developers != null || manufacturers != null) {
			_elementEntityLocalService.deleteElementEntities(subscription.getSubscriptionId(),originalId,IoTComponent.class.getName());
		}
		
		
		if(developers != null) {
			for(Map<String, String> developer :developers) {
				_elementEntityLocalService.addElementEntity(userId,originalId,IoTComponent.class.getName(),developer.get("name"),developer.get("website"),"Developer",subscription.getSubscriptionId(),serviceContext);
			}
		}
		if(manufacturers != null) {
			for(Map<String, String> manufacturer :manufacturers) {
				_elementEntityLocalService.addElementEntity(userId,originalId,IoTComponent.class.getName(),manufacturer.get("name"),manufacturer.get("website"),"Manufacturer",subscription.getSubscriptionId(),serviceContext);
			}
		}
		
		
	}
	private void addElementStandards(Subscription subscription, String originalId, List<String> standards,ServiceContext serviceContext) throws PortalException {
		long userId = subscription.getUserId();
		
		if(standards != null) {
			_elementStandardLocalService.deleteElementStandards(subscription.getSubscriptionId(), originalId, IoTComponent.class.getName());
			for(String standard :standards) {
				_elementStandardLocalService.addElementStandard(userId, originalId, IoTComponent.class.getName(), standard,subscription.getSubscriptionId(),  serviceContext);
			}
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

				List<ElementEntity> elementEntities = _elementEntityLocalService.getElementEntitiesBySubscriptionId(subscription.getSubscriptionId());
				List<ElementStandard> elementStandards = _elementStandardLocalService.getElementStandardsBySubscriptionId(subscription.getSubscriptionId());
						
				for (IoTComponent iotComponent : iotComponents) {
					_ioTComponentLocalService.deleteIoTComponent(iotComponent, serviceContext);
				}

				for (IoTValidation iotValidation : iotValidations) {
					_iotValidationLocalService.deleteIoTValidation(iotValidation, serviceContext);
				}
				for (ElementCoordinate elementCoordinate : elementCoordinates) {
					_elementCoordinateLocalService.deleteElementCoordinate(elementCoordinate);
				}
				


				for(ElementEntity elementEntity:elementEntities) {

					_elementEntityLocalService.deleteElementEntity(elementEntity);
				}
				
				for(ElementStandard elementStandard:elementStandards) {
					_elementStandardLocalService.deleteElementStandard(elementStandard);
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
				System.out.println(tpiData.getConnectionState());
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


	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {

	/*	String subscriptionId = ParamUtil.getString(resourceRequest, "subscriptionId");
		String requestId = ParamUtil.getString(resourceRequest, "requestId");
		if (!subscriptionId.equals("") && !requestId.equals("")) {

			Connection connection = connections.get(subscriptionId).getConnection();

			try {
				Subscription subscription = _subscriptionLocalService.getSubscription(Long.parseLong(subscriptionId));
				_log.info("Starting download");
				Map<String, Object> entry = PDFGeneration
						.getQueueEntries(connection, subscription.getToken(), false, requestId).get(0);
				String status = (String) entry.get("status");
				if (status.equals("Finished")) {
					String requestDateStr = (String)entry.get("requestDateStr");
					List<Map<String, String>> files = (List<Map<String, String>>) entry.get("files");
					ArrayList<FileRequest> fileRequests = new ArrayList<FileRequest>();
					for (Map<String, String> file : files) {
						String url = file.get("url");
						String filename = file.get("filename");
						String path = file.get("path");
						FileRequest fileRequest = new FileRequest(url, filename, path);
						fileRequests.add(fileRequest);
					}

					resourceResponse.setContentType("application/application-download");
					resourceResponse.setProperty("Content-disposition", "attachement; filename=GeneratedDocuments_" + requestDateStr +".zip");

					OutputStream outputStream = resourceResponse.getPortletOutputStream();
					ZIPDownloader zipDownloader = new ZIPDownloader(outputStream, fileRequests);
					zipDownloader.start();
					outputStream.flush();
					outputStream.close();
					resourceResponse.setContentType("application/zip");
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}*/

	}

	public void test(ActionRequest request, ActionResponse resourceResponse)
			throws PortalException, InterruptedException, ExecutionException {
	
		
	
		

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
	private void setElementEntityLocalService(ElementEntityLocalService elementEntityLocalService) {
		_elementEntityLocalService = elementEntityLocalService;
	}
	
	private ElementEntityLocalService _elementEntityLocalService;
	
	@Reference(unbind = "-")
	private void setElementStandardLocalService(ElementStandardLocalService elementStandardLocalService) {
		_elementStandardLocalService = elementStandardLocalService;
	}
	
	private ElementStandardLocalService _elementStandardLocalService;
	
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
	private static final int timeout = 10000;
}
