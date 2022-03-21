package com.iot_catalogue.portlet.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

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
	
	
	public static List<String> getPathFromAssetVocabulary(AssetCategory assetCategory) {
		List<String> path = new ArrayList<String>();
		return getPathFromAssetVocabulary(assetCategory, path);
	}
	public static List<String> getPathFromAssetVocabulary(AssetCategory assetCategory, List<String> path) {
		if(assetCategory==null) {
			List<String>  reversedPath = new ArrayList<>(path);
			Collections.reverse(reversedPath);
			return reversedPath;
		}
		path.add(assetCategory.getTitle());
		return getPathFromAssetVocabulary(assetCategory.getParentCategory(), path);
		
	}

	public static HashMap<String,String> strToHashMap(String str){
		String[] keyValuePairs = str.substring(1, str.length()-1).split(",");              //split the string to creat key-value pairs
		HashMap<String,String> map = new HashMap<>();               

		for(String pair : keyValuePairs)                        //iterate over the pairs
		{
		    String[] entry = pair.split("=");                   //split the pairs to get key and value 
		    map.put(entry[0].trim(), entry[1].trim());          //add them to the hashmap and trim whitespaces
		}
		return map;

	}
	
}
