package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.SearchAssetForm;

public interface AssetsRepository {
    public boolean addAsset(AddAssetForm addAssetForm);

    public Object searchAsset(SearchAssetForm searchAssetForm);
    public Object getAllAssets();
    public Object getAllAssignedAssets();
    boolean EditAsset(EditAssetForm editAssetForm);
}
