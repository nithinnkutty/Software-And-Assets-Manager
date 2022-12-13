package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;

public interface AssetsRepository {
    public boolean addAsset(AddAssetForm addAssetForm);
    public Object getAllAssetsByStatus(String status);
    public Object getAllAssets();
    int updateDataBYID(int id, String state);
    public Object getAssetsSummary();
}
