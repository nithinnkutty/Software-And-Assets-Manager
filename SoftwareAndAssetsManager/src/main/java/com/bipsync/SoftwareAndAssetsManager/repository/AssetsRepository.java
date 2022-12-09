package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;

public interface AssetsRepository {
    public boolean addAsset(AddAssetForm addAssetForm);

//    public Object searchAsset(SearchAssetForm searchAssetForm);
    public Object getAllAssets();
    public Object getAllAssignedAssets();
    boolean EditAsset(EditAssetForm editAssetForm);
    boolean DeleteAsset(EditAssetForm editAssetForm);
}
