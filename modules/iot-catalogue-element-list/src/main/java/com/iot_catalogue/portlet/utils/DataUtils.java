package com.iot_catalogue.portlet.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtils {
	public static List<HashMap<String, Object>> getCategoriesPathFromTagsPath(Object tagsPath){
		
		if(tagsPath!=null) {
			List<Object> array = (List<Object>)tagsPath;
			List<HashMap<String, Object>> categoriesPath = new ArrayList<HashMap<String, Object>>();
			for(Object tagPath: array) {
				List<Map<String, String>> reversedTagPath = new ArrayList<>((List<Map<String, String>>)tagPath);
				Collections.reverse(reversedTagPath);
				String vocabularyTitle = reversedTagPath.get(0).get("typeName");
				List<String> path = new ArrayList<String>();
				for(Map<String, String> entry:reversedTagPath) {
					path.add(entry.get("name"));
				}
				
				HashMap<String, Object> hashMap = new HashMap<String, Object>();
				hashMap.put("vocabularyTitle", vocabularyTitle);
				hashMap.put("path", path);
				categoriesPath.add(hashMap);

			}
			return categoriesPath;
		}
		

		return null;
		
	}
}
