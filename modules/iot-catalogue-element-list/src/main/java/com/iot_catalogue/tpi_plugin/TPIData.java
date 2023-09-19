package com.iot_catalogue.tpi_plugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot_catalogue.portlet.utils.RestUtils;
import com.keysolutions.ddpclient.DDPClient;
import com.keysolutions.ddpclient.DDPClient.CONNSTATE;




public class TPIData {

	public TPIData(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String token, Object props) throws URISyntaxException, InterruptedException {
		
		String protocol = useSSL?"https":"http";
		this.token = token;
		this.baseUrl = protocol + "://" + meteorServerIp + ":" + meteorServerPort;
		this.tpiIds = new HashMap<String, IDInformation[]>() ; 
		this.connectionId = UUID.randomUUID().toString();
		this.connectionState = CONNSTATE.Connected;
		this.onConnected(connectionId);
		this.setTimer();

		
		
		
	

	}
	
	private void setTimer() {
		System.out.println("setTimer");
		try {
			if(this.timer != null) this.timer.cancel();
		}catch(Exception e) {
			
		}

		
		this.timer = new Timer();
		TPIData that = this;
		
		this.timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					that.updateTPIData();
				} catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}, this.updateTPIDataDelay, this.updateTPIDataInterval);
		
		
		this.token = token;
	
		try {
			this.getTPIData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void getTPIData() throws IOException, InterruptedException, ExecutionException, TimeoutException {
		for(String collectionName:collectionNames) {
			this.setCollectionIds(collectionName);
		}
	
		for(String collectionName:collectionNames) {
			IDInformation[] ids = tpiIds.get(collectionName);
			if(ids==null) continue;
			for(IDInformation id: ids) {
				Object element = this.getDataElement(id.get_id(), collectionName);
				if(element == null) continue;
				onElementChanged(collectionName, id.get_id(), element, TPIData.ADDED);
		
			}
		}
	}
	
	private void updateTPIData() throws IOException, InterruptedException, ExecutionException, TimeoutException {
		for(String collectionName:collectionNames) {
			boolean updateTPIIds = false;
			IDInformation[] newIds = this.getCollectionIds(collectionName);
			IDInformation[] oldIds = this.tpiIds.get(collectionName);
			if(newIds == null || oldIds == null) continue;
			HashMap<String, Long> oldIdsHM = new HashMap<String, Long>();
			HashMap<String, Long> newIdsHM = new HashMap<String, Long>();
			for(IDInformation id:oldIds) {
				oldIdsHM.put(id.get_id(), id.get_lastUpdateTimestamp());
			}
			for(IDInformation id:newIds) {
				newIdsHM.put(id.get_id(), id.get_lastUpdateTimestamp());
			}
			for(IDInformation id:newIds) {
				Long oldTimestamp = oldIdsHM.get(id.get_id());
				long timestamp = id.get_lastUpdateTimestamp();
				String action = null;;
				if(oldTimestamp == null) {
			
					action = TPIData.ADDED;
				}else if(timestamp > oldTimestamp) {
		
					action = TPIData.CHANGED;
				}
				if(action !=null) {
					updateTPIIds = true;
					this.updateElement(id.get_id(), collectionName, action);
				}
			}
			
			for(IDInformation id:oldIds) {
				Long newTimestamp = newIdsHM.get(id.get_id());
	
				if(newTimestamp ==null) {
					updateTPIIds = true;
					onElementChanged(collectionName, id.get_id(),null,TPIData.REMOVED);
				}
			}
			
			if(updateTPIIds) {
				this.tpiIds.put(collectionName, newIds);
			}
			
		}
	}
	
	private void updateElement(String id, String collectionName, String action) throws IOException, InterruptedException, ExecutionException, TimeoutException {
		Object element = this.getDataElement(id, collectionName);
		if(element != null) {
			onElementChanged(collectionName, id, element,action);
		}
		
	}
	
	
	private IDInformation[] getCollectionIds(String collectionName) throws IOException, InterruptedException, ExecutionException, TimeoutException {
		String url = this.baseUrl + "/api/getTPIElementsId?ignoreTPIFilter=true&pageName=" + collectionName + "&access_token=" + this.token;
		String response = RestUtils.get(url);
		
		if(response !=null && response.startsWith("[")) {
	
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			return mapper.readValue(response,IDInformation[].class);
			
		}
		return null;

	}
	
	private void setCollectionIds(String collectionName) throws IOException, InterruptedException, ExecutionException, TimeoutException {
		IDInformation[] ids = this.getCollectionIds(collectionName);
		if(ids!=null) {
			this.tpiIds.put(collectionName, ids);
		}


	}
	
	private Object getDataElement(String id, String collectionName) throws IOException, InterruptedException, ExecutionException, TimeoutException {
		String url = this.baseUrl + "/api/getTPIElement?ignoreTPIFilter=true&pageName=" + collectionName + "&id=" + id+ "&access_token=" + this.token;
		String response = RestUtils.get(url);
	
		
		if(response != null && !response.equals("{}")) {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(response, Object.class);
		}
		return null;
	}
	
	
	
	public TPIData(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String token) throws URISyntaxException, InterruptedException {
		this(meteorServerIp, meteorServerPort, useSSL, token, null);
	}
	
	public void onConnected(String sessionId) {
		//subscribeToTPIInfo();
	}
	
	public void onDisconnectedFromRemote() {
		
	}
	
	

	
	
	public void disconnect() {
		this.connectionState = CONNSTATE.Disconnected;
		try {
			if(this.timer != null) this.timer.cancel();
		}catch(Exception e) {
			
		}

		//connection.disconnect();
	}
	
	public void connect() {
		this.connectionState = CONNSTATE.Connected;
		this.setTimer();

		//connection.connect();

	}
	
	public void destroy() {
		this.connectionState = CONNSTATE.Disconnected;
		//connection.destroy();
	}
	
	public void onTPIChanged(Map<String, Object> data, String action, ArrayList<String> collectionNames) {
		
	}
	
	public void onElementChanged(String collectionName, String id, Object fields, String action) {
		
	}

	public CONNSTATE getConnectionState() {
		return this.connectionState;
	}
	

	

	
	//private Connection connection = null;
	private String tpiId = null;
	
	
	private String[] collectionNames = {"components", "problems", "userEnities", "validations", "projectPages", "userEntities"};
	
	private HashMap<String, Integer> subscriptionHashMap = new HashMap<String, Integer>();
	
	private final String tpiCollectionName = "thirdPartyIntegrations";
	
	private final String queueCollectionName = "queue";
	
	public static final String ADDED = DDPClient.DdpMessageType.ADDED;
	public static final String CHANGED = DDPClient.DdpMessageType.CHANGED;
	public static final String REMOVED = DDPClient.DdpMessageType.REMOVED;
	
	private String token;
	
	private String baseUrl;

	private String connectionId; 
	private long updateTPIDataDelay = 120000L;
	private long updateTPIDataInterval = 600000L;
	
	private CONNSTATE connectionState;
	
	private  HashMap<String, IDInformation[]> tpiIds; 
	
	private Timer timer;
	
}
