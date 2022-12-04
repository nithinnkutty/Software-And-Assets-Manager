package com.Bipsync.SoftwareAndAssetsManager.form;

import java.util.Date;

public class AddAssetForm {
    //getter/setter/model for adding function.
    private String assetName;
    private String assetType;
    private String status;
    private Date dateOfPurchase;
    private Date dateOfExpiry;

    public AddAssetForm(String assetName, String assetType, String status, Date dateOfPurchase, Date dateOfExpiry) {
        this.assetName = assetName;
        this.assetType = assetType;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }
}
