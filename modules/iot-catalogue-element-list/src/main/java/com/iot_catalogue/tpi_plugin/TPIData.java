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
import com.keysolutions.ddpclient.DDPClient;
import com.keysolutions.ddpclient.DDPClient.CONNSTATE;
import com.keysolutions.ddpclient.DDPListener;



public class TPIData {

	public TPIData(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String token, Object props) throws URISyntaxException, InterruptedException {
		
		String protocol = useSSL?"https":"http";
		this.baseUrl = protocol + "://" + meteorServerIp + ":" + meteorServerPort;
		System.out.println("***********");
		this.tpiIds = new HashMap<String, IDInformation[]>() ; 
		this.connectionId = UUID.randomUUID().toString();
		this.connectionState = CONNSTATE.Connected;
		this.onConnected(connectionId);
		
		//http://127.0.0.1:3000/api/getTPIIds?pageName=components&access_token=9XvzDS--Uzk9OISrlTPC9zWQplF8k9aGBMV1QfTfjE_
		//http://127.0.0.1:3000/api/getTPIElement?pageName=components&access_token=9XvzDS--Uzk9OISrlTPC9zWQplF8k9aGBMV1QfTfjE_&id=5f75f650357f1b002daa1a3d
		TPIData that = this;
		
		
		this.timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("*********** init");
				try {
					that.updateTPIData();
				} catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}, 80000, 60000);
		
		
		this.token = token;
	
		try {
			this.getTPIData();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	/*	connection = new Connection(meteorServerIp, meteorServerPort, useSSL, this.token, props) {
			@Override
			public void onConnected(String sessionId, Object serviceInfo) {
				//that.onConnected(sessionId, serviceInfo);
			
			}
			
			@Override
			public void onDisconnectedFromRemote() {
				//that.onDisconnectedFromRemote();
			}
			
			@Override
			public void onQueueChanged(String collectionName, String id, Object fields, String action) {
				//that.onQueueChanged(collectionName, id, fields, action);

			}
		};*/
	}
	
	private void getTPIData() throws IOException, InterruptedException, ExecutionException, TimeoutException {
		for(String collectionName:_collectionNames) {
			this.setCollectionIds(collectionName);
		}
	
		for(String collectionName:_collectionNames) {
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
		for(String collectionName:_collectionNames) {
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
					System.out.println("added");
					action = TPIData.ADDED;
				}else if(timestamp > oldTimestamp) {
					System.out.println("changed");
					action = TPIData.CHANGED;
				}
				if(action !=null) {
					updateTPIIds = true;
					this.updateElement(id.get_id(), collectionName, action);
				}
			}
			
			for(IDInformation id:oldIds) {
				Long newTimestamp = newIdsHM.get(id.get_id());
				if(collectionName.equals("components")) {
					System.out.println(id.get_id());
					System.out.println(newIdsHM.get(id.get_id()));
				}
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
		String response = TPIData.get(url);
		
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
		String response = TPIData.get(url);
	
		
		if(response != null && !response.equals("{}")) {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(response, Object.class);
		}
		return null;
	}
	
	private static String get(String url) throws IOException, InterruptedException, ExecutionException, TimeoutException {
		URL obj = new URL(url);
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		//con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			completableFuture.complete(response.toString());
		} else {
			completableFuture.complete(null);
		}
		return completableFuture.get(60, TimeUnit.SECONDS);

	

	}
	
	public TPIData(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String token) throws URISyntaxException, InterruptedException {
		this(meteorServerIp, meteorServerPort, useSSL, token, null);
	}
	
	public void onConnected(String sessionId) {
		//subscribeToTPIInfo();
	}
	
	public void onDisconnectedFromRemote() {
		
	}
	
	
	
	private void onQueueChanged(String collectionName, String id, Object fields, String action) {
	
		if(collectionName.equals(tpiCollectionName)) {
			Map<String, Object> hashMap = (Map<String, Object>) fields;
			Map<String, Object> data = (Map<String, Object>) hashMap.get("data");

			onTPIChanged(data, action, collectionNames);
			
		}else if(!collectionName.equals(queueCollectionName)) {
			//onElementChanged(collectionName, id, fields, action);
		}

	}
	
	
	public void disconnect() {
		this.connectionState = CONNSTATE.Disconnected;
		this.timer.cancel();
		//connection.disconnect();
	}
	
	public void connect() {
		this.connectionState = CONNSTATE.Connected;
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
	
	private ArrayList<String> collectionNames = null;
	
	private String[] _collectionNames = {"components", "problems", "userEnities", "validations", "projectPages", "userEntities"};
	
	private HashMap<String, Integer> subscriptionHashMap = new HashMap<String, Integer>();
	
	private final String tpiCollectionName = "thirdPartyIntegrations";
	
	private final String queueCollectionName = "queue";
	
	public static final String ADDED = DDPClient.DdpMessageType.ADDED;
	public static final String CHANGED = DDPClient.DdpMessageType.CHANGED;
	public static final String REMOVED = DDPClient.DdpMessageType.REMOVED;
	
	private String token;
	
	private String baseUrl;

	private String connectionId; 
	
	
	private CONNSTATE connectionState;
	
	private  HashMap<String, IDInformation[]> tpiIds; 
	
	private Timer timer;
	
}
