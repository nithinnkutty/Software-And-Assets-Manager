package com.Bipsync.SoftwareAndAssetsManager.form;

public class SearchAssetForm {
    String assetType;
    String assetName;
    String firstName;
    String surName;

    public SearchAssetForm(String assetType, String assetName, String firstName, String surName) {
        this.assetType = assetType;
        this.assetName = assetName;
        this.firstName = firstName;
        this.surName = surName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
