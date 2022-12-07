package com.bipsync.SoftwareAndAssetsManager.repository;

import com.bipsync.SoftwareAndAssetsManager.form.AddAssetForm;

public interface AssetsRepository {
    public boolean addAsset(AddAssetForm addAssetForm);
    public Object getAllAssets();

    int updateDataBYID(int id, String state);
}
