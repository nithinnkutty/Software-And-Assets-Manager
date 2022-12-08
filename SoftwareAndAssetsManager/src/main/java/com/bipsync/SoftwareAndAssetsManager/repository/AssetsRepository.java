package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;

public interface AssetsRepository {
    public boolean addAsset(AddAssetForm addAssetForm);
    public Object getAllAssets();
    public Object getAssetsSummary();
}
