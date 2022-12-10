package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;

public interface AssetsRepository {

    public Object getAllAssets();
    public Object getAllAssignedAssets();
    boolean EditAsset(EditAssetForm editAssetForm);
    boolean DeleteAsset(EditAssetForm editAssetForm);
}
