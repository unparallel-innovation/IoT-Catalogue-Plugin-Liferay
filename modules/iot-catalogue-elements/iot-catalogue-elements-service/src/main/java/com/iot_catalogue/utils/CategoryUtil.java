package com.iot_catalogue.utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;

public class CategoryUtil {
	
	
	private static AssetVocabulary getVocabulary(String vocabularyTitle , ServiceContext serviceContext) {
		AssetVocabulary assetVocabulary = null;
		try {
			
			assetVocabulary = AssetVocabularyLocalServiceUtil.getGroupVocabulary(serviceContext.getScopeGroupId(),vocabularyTitle.toLowerCase());
			

		}catch(Exception ex) {
			
		}
		 
		if(assetVocabulary == null) {
			try {
				assetVocabulary = AssetVocabularyLocalServiceUtil.addVocabulary(serviceContext.getUserId(), serviceContext.getScopeGroupId(), vocabularyTitle, serviceContext);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return assetVocabulary;
	}
	public static HashMap<String, List<HashMap<String,String>>> getVocabulariesCategories(AssetEntry assetEntry) throws PortalException{
		List<AssetCategory> assetCategories = assetEntry.getCategories();

		HashMap<String, List<HashMap<String,String>>> vocabulariesCategories = new HashMap<String,List<HashMap<String,String>>>();
		for(AssetCategory assetCategory: assetCategories) {
		
			AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getAssetVocabulary(assetCategory.getVocabularyId());
			String vocabularyTitle = assetVocabulary.getTitle();
			List<HashMap<String,String>> list = vocabulariesCategories.get(vocabularyTitle);
			if(list == null) {
				list = new ArrayList<HashMap<String,String>>();
				vocabulariesCategories.put(vocabularyTitle, list);
			}
			HashMap<String, String> category = new HashMap<String, String>();
			category.put("categoryName", assetCategory.getName().replaceAll(",", ""));
			AssetCategory parentCategory = assetCategory.getParentCategory();
			if(parentCategory!=null) {
				category.put("parentCategoryName", parentCategory.getName().replaceAll(",", ""));
			}
			list.add(category);
		}
			
		return vocabulariesCategories;
		
	}
	
	public static long[] getCategoryIds(List<HashMap<String, Object>> categoriesPath, ServiceContext serviceContext) throws PortalException{
		long[] categoryIds = null;
		if(categoriesPath != null) {
			List<Long> values = new ArrayList<Long>();
			for(HashMap<String, Object> hashMap: categoriesPath) {
				List<String> categoryNames =(List<String>)hashMap.get("path");
				String vocabularyTitle = (String)hashMap.get("vocabularyTitle");
				AssetCategory assetCategory = addCategoryPath(categoryNames,vocabularyTitle, serviceContext);
				values.add(assetCategory.getCategoryId());
			}
			categoryIds = values.stream().mapToLong(l -> l).toArray();
		}
		return categoryIds;


	}
	
	public static AssetCategory addCategoryPath(List<String> categoryNames,String vocabularyTitle,  ServiceContext serviceContext) throws PortalException {
		return addCategoryPath(categoryNames,vocabularyTitle, serviceContext, null, 0);
	}
	public static AssetCategory addCategoryPath(List<String> categoryNames, String vocabularyTitle, ServiceContext serviceContext, AssetCategory parentCategory, int index) throws PortalException {
		if(categoryNames.size() == 0) {
			return parentCategory;
		}
		

		
		
		AssetCategory newCategory = addCategory(categoryNames.get(0), vocabularyTitle, parentCategory, serviceContext);

		return addCategoryPath(categoryNames.subList(1, categoryNames.size()),vocabularyTitle, serviceContext, newCategory, index + 1);

	}
	
	private static AssetCategory  addCategory(String name, String vocabularyTitle,  AssetCategory parentCategory, ServiceContext serviceContext) throws PortalException {
		AssetVocabulary assetVocabulary  = getVocabulary(vocabularyTitle, serviceContext);

		AssetCategory newCategory = null;
		try {
			newCategory = AssetCategoryLocalServiceUtil.fetchCategory(	
				serviceContext.getScopeGroupId(), 
				parentCategory!=null?parentCategory.getCategoryId():0, 
				name, 
				assetVocabulary.getVocabularyId()
			);
		}catch(Exception ex) {
			
		}
		

		if(newCategory == null) {
			
			Map<Locale,String> titleMap = new HashMap<Locale,String>();
			Locale locale = LocaleUtil.getDefault();
			titleMap.put(locale, name);
			Map<Locale,String> descriptionMap = new HashMap<Locale,String>();
			try {
				newCategory = AssetCategoryLocalServiceUtil.addCategory(
						serviceContext.getUserId(),
						serviceContext.getScopeGroupId(),
						parentCategory!=null?parentCategory.getCategoryId():0,
						titleMap,
						descriptionMap,
						assetVocabulary.getVocabularyId(),
						null,
						serviceContext
					);
			}catch(Exception ex) {
				ex.printStackTrace();
			}


		}

		return newCategory;
	}
	

	//private static String vocabularyTitle = "IoT Catalogue";
	private static final Log _log = LogFactoryUtil.getLog(CategoryUtil.class);
}
