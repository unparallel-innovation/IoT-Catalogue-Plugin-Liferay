
package com.iot_catalogue.portlet.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.iot_catalogue.model.Subscription;

public class RestUtils {
	
	public static String get(String url) throws IOException, InterruptedException, ExecutionException, TimeoutException {
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
	
	public static String getBaseURLFromSubscription(Subscription subscription) {
		if(subscription == null) return null;
		String protocol = subscription.getUseSSL()?"https":"http";
		String host = subscription.getHost();
		Integer port = subscription.getPort();
		String baseUrl = protocol + "://" + host + ":" + port;
		return baseUrl;
	}
}
