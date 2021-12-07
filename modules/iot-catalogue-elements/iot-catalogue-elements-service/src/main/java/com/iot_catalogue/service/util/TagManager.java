package com.iot_catalogue.service.util;

import java.util.List;

import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.asset.kernel.service.AssetTagLocalService;
import com.liferay.petra.string.CharPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.petra.string.StringBundler;

public class TagManager {

	public TagManager() {
		this(null,null);
	}
	
	public TagManager(AssetTagLocalService assetTagLocalService, AssetEntryLocalService assetEntryLocalService){
		_assetTagLocalService = assetTagLocalService;
		_assetEntryLocalService = assetEntryLocalService;
	}
	
	public void setAssetTagLocalService(AssetTagLocalService assetTagLocalService) {
		_assetTagLocalService = assetTagLocalService;
	}


	public void setAssetEntryLocalService(AssetEntryLocalService assetEntryLocalService) {
		_assetEntryLocalService = assetEntryLocalService;
	}
	
	public AssetTag addTag(long userId, long groupId, String name, ServiceContext serviceContext) throws PortalException {
		return _assetTagLocalService.addTag(userId, groupId, name, serviceContext);
	}
	

	public AssetTag getTagByName(ServiceContext serviceContext, String tagName) throws PortalException {
		AssetTag assetTag = null;
		String sanitizedTagName = sanitizeTagName(tagName);
		long groupId = serviceContext.getScopeGroup().getGroupId();
		try {
			assetTag = _assetTagLocalService.getTag(groupId,sanitizedTagName);
		}catch(Exception NoSuchTagException) {
			
		}
		
		return assetTag;

	}




	public AssetTag addTagNameToAsset(ServiceContext serviceContext, String tagName, long entryId) throws PortalException {
		String sanitizedTagName = sanitizeTagName(tagName);
		long groupId = serviceContext.getScopeGroup().getGroupId();
		AssetTag assetTag = getTagByName(serviceContext, sanitizedTagName);
		if(assetTag == null) {
			assetTag = _assetTagLocalService.addTag(serviceContext.getUserId(), groupId,sanitizedTagName,serviceContext);
		}
		_log.info("Adding tag " + assetTag.getTagId() + " to entry "+ entryId);
		_assetEntryLocalService.addAssetTagAssetEntry(assetTag.getTagId(), entryId);
		
		return assetTag;
	}
	
	public void addTagNamesToAsset(ServiceContext serviceContext, List<String> tagNames, long entryId) throws PortalException {
		if(tagNames!=null) {
			for(String tagName: tagNames) {
				addTagNameToAsset(serviceContext, tagName, entryId);
			}
		}
	}
	
	public void printAllAssets() {
		System.out.println(_assetEntryLocalService.getAssetEntriesCount());
	}
	

	
	private static String sanitizeTagName(String tagName) {
		String lowerCaseTagName = StringUtil.toLowerCase(StringUtil.trim(tagName));
		String str = "";

		char[] wordCharArray = lowerCaseTagName.toCharArray();

		for (char c : wordCharArray) {
			boolean isCharInvalid = false;
			for (char invalidChar : _INVALID_CHARACTERS) {
				if (c == invalidChar) {
					isCharInvalid = true;
					break;
				}
			}
			if(isCharInvalid) {
				str = str + charToReplace;
			}else {
				str = str + c;

			}
		}

		return str;
	}
	
	private static final char[] _INVALID_CHARACTERS = {
			CharPool.AMPERSAND, CharPool.APOSTROPHE, CharPool.AT,
			CharPool.BACK_SLASH, CharPool.CLOSE_BRACKET, CharPool.CLOSE_CURLY_BRACE,
			CharPool.COLON, CharPool.COMMA, CharPool.EQUAL, CharPool.GREATER_THAN,
			CharPool.FORWARD_SLASH, CharPool.LESS_THAN, CharPool.NEW_LINE,
			CharPool.OPEN_BRACKET, CharPool.OPEN_CURLY_BRACE, CharPool.PERCENT,
			CharPool.PIPE, CharPool.PLUS, CharPool.POUND, CharPool.PRIME,
			CharPool.QUESTION, CharPool.QUOTE, CharPool.RETURN, CharPool.SEMICOLON,
			CharPool.SLASH, CharPool.STAR, CharPool.TILDE
		};
	
	
	private static final String charToReplace = "_";
	
	private static final Log _log = LogFactoryUtil.getLog(TagManager.class);
	
	private AssetTagLocalService _assetTagLocalService;
	
	private AssetEntryLocalService _assetEntryLocalService;
	

}
