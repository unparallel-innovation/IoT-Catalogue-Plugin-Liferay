package com.iot_catalogue.tpi_plugin;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import com.keysolutions.ddpclient.DDPClient;
import com.keysolutions.ddpclient.DDPListener;
import com.keysolutions.ddpclient.DDPClient.CONNSTATE;

public class Connection extends DDPClient{
	
	public Connection(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String serviceId, String token, Object props, boolean subscribeUsingToken) throws URISyntaxException, InterruptedException {
		super(meteorServerIp, meteorServerPort, useSSL);
		this.meteorServerIp = meteorServerIp;
		this.meteorServerPort = meteorServerPort;
		this.subscribeUsingToken = subscribeUsingToken;
		this.connect();
		this.token = token;
		this.serviceId = serviceId;
		this.props = props;
		timer = new Timer();
		Connection that = this;
		timer.scheduleAtFixedRate(new TimerTask(){
		    @Override
		    public void run(){
		    	CONNSTATE state = that.getState();
		    	if(CONNSTATE.Closed ==state && tryToReconnect) {
		    		that.connect();
		    	}
   	 
		  
		    }
		},0,pingInterval);
		observeQueue();
	}
	
	public Connection(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String serviceId, String token, Object props) throws URISyntaxException, InterruptedException {
		this(meteorServerIp, meteorServerPort, useSSL, serviceId, token, props, false );
	}
	
	
	public Connection(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String serviceId, String token) throws URISyntaxException, InterruptedException {
		this(meteorServerIp, meteorServerPort, useSSL,serviceId,token, null );
	}
	
	public Connection(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String token) throws URISyntaxException, InterruptedException {

		this(meteorServerIp, meteorServerPort, useSSL, null, token, null, true );
	}
	public Connection(String meteorServerIp, Integer meteorServerPort, boolean useSSL, String token, Object props) throws URISyntaxException, InterruptedException {

		this(meteorServerIp, meteorServerPort, useSSL, null, token, props, true );
	}
	@Override
	public void connect() {
		super.connect();
		tryToReconnect = true;
	}
	
	@Override
	public void disconnect() {
		super.disconnect();
		tryToReconnect = false;
	}
	

	
	
	private void getServiceInfo(String sessionId) throws InterruptedException {
		DDPListener ddpListener = new DDPListener() {
			@Override
			 public void onResult(Map<String, Object> resultFields) {
				System.out.println("************************");
				onConnected(sessionId, resultFields.get("result"));
			}
		};
		
		


		
		callWithToken("getExternalServiceInfo",  ddpListener);
	}
	

	
	public int callWithToken(String method, Object[] params, DDPListener resultListener) {
		Object[] paramsWithToken = getParamsWithToken(params);
		return this.call(method, paramsWithToken, resultListener);
	}
	
	
    public int callWithToken(String method, Object[] params) {
		Object[] paramsWithToken = getParamsWithToken(params);
        return this.call(method, paramsWithToken, null);
    }
	public int callWithToken(String method,  DDPListener resultListener) {
		Object[] paramsWithToken = getParamsWithToken();
		return this.call(method, paramsWithToken, resultListener);
	}
    private void subscribeToQueue(String sessionId) {
    	Object[] methodArgs = new Object[3];
    	methodArgs[0] = serviceId;
    	methodArgs[1] = token;
    	methodArgs[2] = props;
    	DDPListener ddpListener = new DDPListener() {
    		@Override
    		public void onReady(String callId) {
    			try {
					getServiceInfo(sessionId);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	};
    	this.subscribe(subscriptionName, methodArgs, ddpListener);
    }
	
    private void subscribeToQueueWithToken(String sessionId) {
    	Object[] methodArgs = new Object[2];
    	methodArgs[0] = token;
    	methodArgs[1] = props;
    	DDPListener ddpListener = new DDPListener() {
    		@Override
    		public void onReady(String callId) {
    			try {
					getServiceInfo(sessionId);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    	};
    	
    	this.subscribe(subscriptionWithTokenName, methodArgs, ddpListener);
    }
	
   
    
	
	private Object[] getParamsWithToken(Object[] params) {
		
		Object[] paramsWithToken = new Object[params.length + 1];
		int i;
		for(i = 0; i < params.length; i++) {
			paramsWithToken[i] = params[i];

		}
		paramsWithToken[params.length] = token;
		return paramsWithToken;

	}
	
	private Object[] getParamsWithToken() {
		Object[] methodArgs = new Object[0];
		return getParamsWithToken(methodArgs);

	}
	
	
	private void observeQueue() throws InterruptedException {

		observer = new Observer() {


			@Override
			public void update(Observable o, Object arg) {
	
				String msg =  (String) ((Map) arg).get("msg");
				Object remote =  ((Map) arg).get("remote");
				String sessionId = (String) ((Map) arg).get("session");

				if(msg.equals("connected")) {
					if(subscribeUsingToken) {
						subscribeToQueueWithToken(sessionId);
					}else {
						subscribeToQueue(sessionId);
					}
					
				}
			

				if(msg.equals("closed") &&  remote != null && (boolean) remote == true) {
					onDisconnectedFromRemote();
				}

				if(msg.equals("added")) {
					onAdded(arg);
				}
				if(msg.equals("changed")) {
					onChanged(arg);
				}
				if(msg.equals("removed")) {
					onRemoved(arg);
				}
				if(msg.equals("added") || msg.equals("changed") || msg.equals("removed")) {
					String collectionName =  (String) ((Map) arg).get("collection");
					String id =  ((String) ((Map) arg).get("id")).substring(1);
					Object fields =  (Object) ((Map) arg).get("fields");
					onQueueChanged(arg, msg);
					onQueueChanged(collectionName, id, fields, msg);
				}
				
				prevMsg = msg;

				
			}
		};
		this.addObserver(observer);

	
	}
	
	public void destroy() {
		this.deleteObserver(observer);

	}
	
	public void onConnected(String sessionId, Object serviceInfo) {
		
	}
	public void onDisconnectedFromRemote() {
		
	}
	
	
	public void onAdded(Object object) {
		
	}
	
	
	public void onChanged(Object object) {
		
	}
	
	public void onRemoved(Object object) {
		
	}
	
	public void onQueueChanged(Object object, String action) {
		
	}
	
	public void onQueueChanged(String collectionName, String id, Object fields, String action) {
		
	}
	
	//private DDPClient ddpClient = null;
	private String token = null;
	private String serviceId = null;
	private Object props = null;
	
	private Timer timer = null;
	private int pingInterval = 2000;
	
	private String meteorServerIp = null;
	private Integer meteorServerPort = null;
	
	private boolean tryToReconnect = true;
	
	private boolean subscribeUsingToken = false;
	private String prevMsg = "";
	
	private Observer observer = null;
	
	private final String subscriptionName = "externalServiceQueue";
	private final String subscriptionWithTokenName = "externalServiceQueueUsingToken";
	
}
