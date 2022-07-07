package com.iot_catalogue.portlet.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.iot_catalogue.tpi_plugin.Connection;
import com.keysolutions.ddpclient.DDPListener;

public class PDFGeneration {

	public static void addRequestToQueue(boolean includeComponents, boolean  includeValidations,String token, Connection connection, String logo) throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<Map<String, Object>> completableFuture = new CompletableFuture<Map<String, Object>>();
		
    	DDPListener ddpListener = new DDPListener() {
			@Override
			public void onResult(Map<String, Object> resultFields) {
				completableFuture.complete(resultFields);
			}
		};
		Object[] params = new Object[1];
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("token",token);
		hashMap.put("includeComponents",includeComponents);
		hashMap.put("includeValidations",includeValidations);
		if(logo != null) {
			hashMap.put("logo",logo);		
		}
		
		params[0] = hashMap;
		connection.call("generatePDFFromTPI",params,ddpListener);
		completableFuture.get(10,TimeUnit.SECONDS);

	}
	
	public static List<Map<String,Object>> getQueueEntries(Connection connection, String token) throws InterruptedException, ExecutionException, TimeoutException{
		return getQueueEntries(connection, token, false,null);
	}
	public static List<Map<String,Object>> getQueueEntries(Connection connection, String token, boolean onlyStats) throws InterruptedException, ExecutionException, TimeoutException{
		return getQueueEntries(connection, token, onlyStats,null);
	}
	public static List<Map<String,Object>> getQueueEntries(Connection connection, String token, boolean onlyStats, String requestId) throws InterruptedException, ExecutionException, TimeoutException {
		CompletableFuture<List<Map<String,Object>>> completableFuture = new CompletableFuture<List<Map<String,Object>>>();
		DDPListener ddpListener = new DDPListener() {
			@Override
			public void onResult(Map<String, Object> resultFields) {
				List<Map<String,Object>> entries = (List<Map<String,Object>>)resultFields.get("result");
				completableFuture.complete(entries);
			}
		};
		
		Object[] params = new Object[3];
		params[0] = token;
		params[1] = onlyStats;
		params[2] = requestId;
		
		connection.call("getTPIPDFQueue",params,ddpListener);
		return completableFuture.get(10, TimeUnit.SECONDS);
		
	}
	
	public static void deleteExportedDocuments(Connection connection, String requestId, String token) throws InterruptedException, ExecutionException, TimeoutException {
		
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
		DDPListener ddpListener = new DDPListener() {
			@Override
			public void onResult(Map<String, Object> resultFields) {
				completableFuture.complete("");
			}
		};
		Object[] params = new Object[2];
		params[0] = requestId;
		params[1] = token;
		connection.call("deleteTPIExportedDocuments",params,ddpListener);
		completableFuture.get(10,TimeUnit.SECONDS);
	}
}
