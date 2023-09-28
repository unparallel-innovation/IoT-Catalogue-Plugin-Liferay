package com.iot_catalogue.utils;

public class StringUtils {
	public static String StripHTML(String html) {
		if(html!=null) {
			return html.replaceAll("</[^>]*>", "\n").replaceAll("<[^>]*>","");
		}
		return null;	
		
	}
}
