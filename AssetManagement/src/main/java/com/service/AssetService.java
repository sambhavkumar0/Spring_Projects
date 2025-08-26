package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.exception.AssetInvalidException;
import com.model.AssetInfo;

@Service
public class AssetService {

    private List<AssetInfo> assetList = new ArrayList<>();

    public AssetService() {
        // Sample Asset Data
        assetList.add(new AssetInfo(2001, "Laptop", "ELECTRONIC", "John Doe", LocalDate.of(2022, 5, 10), 75000, true, "GOOD"));
        assetList.add(new AssetInfo(2002, "Office Chair", "FURNITURE", "Jane Smith", LocalDate.of(2021, 3, 15), 5000, true, "NEW"));
        assetList.add(new AssetInfo(2003, "Projector", "ELECTRONIC", "Conference Room", LocalDate.of(2020, 6, 25), 40000, true, "NEEDS_REPAIR"));
        assetList.add(new AssetInfo(2004, "Car", "VEHICLE", "Logistics Team", LocalDate.of(2019, 11, 5), 500000, true, "GOOD"));
        assetList.add(new AssetInfo(2005, "Printer", "HARDWARE", "IT Department", LocalDate.of(2023, 1, 20), 25000, true, "NEW"));
    }

    public List<AssetInfo> getAssetList() {
        return assetList;
    }

    public void setAssetList(List<AssetInfo> assetList) {
        this.assetList = assetList;
    }

    // Add Asset
    public AssetInfo addAsset(AssetInfo assetObj) {
    	 assetList.add(assetObj);
    	    return assetObj;
    }

    // View Asset by ID
    public AssetInfo viewAssetById(int assetId) throws AssetInvalidException {
    	 return assetList.stream()
    		        .filter(asset -> asset.getAssetId() == assetId)
    		        .findFirst()
    		        .orElseThrow(() -> new AssetInvalidException("Asset ID " + assetId + " does not exist"));
    }
    

    // View Assets by Type and Operational Status
    public List<AssetInfo> viewAssetsByTypeAndCondition(String assetType, String assetCondition) {

    	List<AssetInfo> filteredList = new ArrayList<>();
        for (AssetInfo asset : assetList) {
            if (asset.getAssetType().equalsIgnoreCase(assetType) &&
                asset.getAssetCondition().equalsIgnoreCase(assetCondition)) {
                filteredList.add(asset);
            }
        }
        return filteredList;
    }

    // Update Asset Condition
    public AssetInfo updateAssetCondition(int assetId, String newCondition) throws AssetInvalidException {
    	 AssetInfo asset = viewAssetById(assetId);  // throws if not found
    	    asset.setAssetCondition(newCondition);
    	    return asset;
    }

    // Delete Asset
    public boolean deleteAsset(int assetId) throws AssetInvalidException {
    	 AssetInfo asset = viewAssetById(assetId); // throws if not found
    	    return assetList.remove(asset);	
}
}