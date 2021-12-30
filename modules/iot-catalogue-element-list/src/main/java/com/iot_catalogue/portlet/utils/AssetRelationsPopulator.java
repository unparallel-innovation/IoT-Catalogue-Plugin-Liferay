package com.iot_catalogue.portlet.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.asset.kernel.service.AssetLinkLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class AssetRelationsPopulator {

	public AssetRelationsPopulator(AssetLinkLocalService assetLinkLocalService) {
		
		_assetLinkLocalService = assetLinkLocalService;
	}
	
	public AssetEntry getAssetEntry(Object element) {
		return null;
	}

	public AssetEntry getChildAssetEntry(Object element) {
		return null;
	}
	
	public void assetProcessed(Long assetId, List<Long> childAssetIds) {
		
	}
	
	public final void addAssetRelations(Object object, long userId) {
		HashMap<Long,List<Long>> hashMap = new HashMap<Long,List<Long>>();
		List<Object> elements = (List<Object>)object;
		for(Object element: elements) {
			AssetEntry assetEntry = getAssetEntry(element);
		
			AssetEntry childAssetEntry = getChildAssetEntry(element);
			if(assetEntry == null || childAssetEntry==null) {
				continue;
			}
			long assetEntryId = assetEntry.getEntryId();
			List<Long> childList = hashMap.get(assetEntryId);
			if(childList == null) {
				childList = new ArrayList<Long>();
				hashMap.put(assetEntry.getEntryId(), childList);
			}
			long childAssetEntryId = childAssetEntry.getEntryId();
			
			_log.info("Processing asset entry relation: " + assetEntryId + " -> " + childAssetEntryId);
			
			childList.add(childAssetEntryId);
		}
		
		for(Long entryId: hashMap.keySet()) {
			List<Long> childEntryIds = hashMap.get(entryId);
			long[] result = childEntryIds.stream().mapToLong(l -> l).toArray();
			try {
				_log.info("Adding asset relations for asset: " + entryId);
				_assetLinkLocalService.updateLinks(userId, entryId, result, AssetLinkConstants.TYPE_RELATED);
			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assetProcessed(entryId,childEntryIds);
		}
		
		
		
	}
	
	
	private AssetLinkLocalService _assetLinkLocalService;
	private static final Log _log = LogFactoryUtil.getLog(AssetRelationsPopulator.class);
	
}


