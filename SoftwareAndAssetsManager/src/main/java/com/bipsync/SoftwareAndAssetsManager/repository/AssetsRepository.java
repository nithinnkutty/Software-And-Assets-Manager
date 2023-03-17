package com.bipsync.SoftwareAndAssetsManager.repository;

import com.bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.bipsync.SoftwareAndAssetsManager.form.EditAssetForm;

public interface AssetsRepository {
    public boolean addAsset(AddAssetForm addAssetForm);
    public Object getAllAssetsByStatus(String status);
    public Object getAllAssets();
    public Object getAllAssignedAssets();
    int updateDataBYID(int id, String state);
    public Object getAssetsSummary();
    boolean EditAsset(EditAssetForm editAssetForm);
    boolean DeleteAsset(EditAssetForm editAssetForm);
}
