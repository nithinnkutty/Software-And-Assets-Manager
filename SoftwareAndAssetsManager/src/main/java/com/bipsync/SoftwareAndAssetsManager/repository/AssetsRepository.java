package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;

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
