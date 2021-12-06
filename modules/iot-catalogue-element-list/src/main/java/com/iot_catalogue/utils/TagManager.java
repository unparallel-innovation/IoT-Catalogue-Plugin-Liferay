package com.iot_catalogue.utils;

import java.util.List;

import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;

public class TagManager {




	public static AssetTag getTagByName(ServiceContext serviceContext, String tagName) throws PortalException {
		String lowerCaseTagName = StringUtil.toLowerCase(StringUtil.trim(tagName));
		long groupId = serviceContext.getScopeGroup().getGroupId();
		List<AssetTag> tags = AssetTagServiceUtil.getTags(groupId,lowerCaseTagName,0,1);
		if(tags.size() > 0) {
			return tags.get(0);
		}
		return null;
	}




	public static AssetTag addTagNameToAsset(ServiceContext serviceContext, String tagName, long entryId) throws PortalException {
		String lowerCaseTagName = StringUtil.toLowerCase(StringUtil.trim(tagName));
		long groupId = serviceContext.getScopeGroup().getGroupId();
		AssetTag assetTag = getTagByName(serviceContext, lowerCaseTagName);
		if(assetTag == null) {
			assetTag = AssetTagServiceUtil.addTag(groupId,lowerCaseTagName,serviceContext);
		}
		_log.info("Adding tag " + assetTag.getTagId() + " to entry "+ entryId);
		AssetEntryLocalServiceUtil.addAssetTagAssetEntry(assetTag.getTagId(), entryId);
		return assetTag;
	}
	private static final Log _log = LogFactoryUtil.getLog(TagManager.class);
}
