package com.iot_catalogue.tpi_plugin;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.keysolutions.ddpclient.DDPClient;
import com.keysolutions.ddpclient.DDPClient.CONNSTATE;
import com.keysolutions.ddpclient.DDPListener;



public class TPIData {

	public TPIData(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String token, Object props) throws URISyntaxException, InterruptedException {
		TPIData that = this;
		this.token = token;
		connection = new Connection(meteorServerIp, meteorServerPort, useSSL, this.token, props) {
			@Override
			public void onConnected(String sessionId, Object serviceInfo) {
				that.onConnected(sessionId, serviceInfo);
			
			}
			
			@Override
			public void onDisconnectedFromRemote() {
				that.onDisconnectedFromRemote();
			}
			
			@Override
			public void onQueueChanged(String collectionName, String id, Object fields, String action) {
				that.onQueueChanged(collectionName, id, fields, action);

			}
		};
	}
	
	
	public TPIData(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String token) throws URISyntaxException, InterruptedException {
		this(meteorServerIp, meteorServerPort, useSSL, token, null);
	}
	
	public void onConnected(String sessionId, Object serviceInfo) {
		subscribeToTPIInfo();
	}
	
	public void onDisconnectedFromRemote() {
		
	}
	
	
	
	private void onQueueChanged(String collectionName, String id, Object fields, String action) {
	
		if(collectionName.equals(tpiCollectionName)) {
			Map<String, Object> hashMap = (Map<String, Object>) fields;
			Map<String, Object> data = (Map<String, Object>) hashMap.get("data");

			onTPIChanged(data, action, collectionNames);
			
		}else if(!collectionName.equals(queueCollectionName)) {

			onElementChanged(collectionName, id, fields, action);
		}

	}
	
	
	public void disconnect() {
		connection.disconnect();
	}
	
	public void connect() {
		connection.connect();

	}
	
	public void destroy() {
		connection.destroy();
	}
	
	public void onTPIChanged(Map<String, Object> data, String action, ArrayList<String> collectionNames) {
		
	}
	
	public void onElementChanged(String collectionName, String id, Object fields, String action) {
		
	}
	
	public Connection getConnection() {
		return connection;
	}
	
	private void subscribeToTPIInfo() {
		DDPListener ddpListener = new DDPListener() {
			@Override
			public void onResult(Map<String, Object> resultFields) {
				collectionNames =(ArrayList<String>) resultFields.get("result");
				
				DDPListener ddpListener = new DDPListener() {
					@Override
					public void onReady(String callId) {
			
					}
				};
				
				connection.subscribe("tpiChanges",null, ddpListener);
	


			}
		};

		connection.call("getTPICollectionNames", null,ddpListener);

	}
	
	public CONNSTATE getConnectionState() {
		return 	connection.getState();
	}
	
	public void subscribeToCollections() {

		for(String collectionName: collectionNames) {
			subscribeToCollection(collectionName);
		}
	}
	
	private void subscribeToCollection(String collectionName) {
		
		Integer subscriptionId = subscriptionHashMap.get(collectionName);
		if(subscriptionId!= null) {
			connection.unsubscribe(subscriptionId);
		}
		
		
		String[] methodArgs = new String[2];
		methodArgs[0] = collectionName;
		methodArgs[1] = this.token;
		Integer newSubscriptionId = connection.subscribe("tpiCollectionUpdates", methodArgs);
		subscriptionHashMap.put(collectionName, newSubscriptionId);
		
	}
	
	private Connection connection = null;
	private String tpiId = null;
	
	private ArrayList<String> collectionNames = null;
	
	private HashMap<String, Integer> subscriptionHashMap = new HashMap<String, Integer>();
	
	private final String tpiCollectionName = "thirdPartyIntegrations";
	
	private final String queueCollectionName = "queue";
	
	public static final String ADDED = DDPClient.DdpMessageType.ADDED;
	public static final String CHANGED = DDPClient.DdpMessageType.CHANGED;
	public static final String REMOVED = DDPClient.DdpMessageType.REMOVED;
	
	private String token;

	
}
