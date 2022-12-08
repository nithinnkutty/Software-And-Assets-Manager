package com.Bipsync.SoftwareAndAssetsManager.DTO;

import java.util.Date;

public class AssetDTO {
    // In this class, one line == one column in db table
    // Provided with corresponding getters and setters
    private int id;
    private String assetName;
    private String assetType;
    private String modelNumber;
    private String version;
    private String status;
    private String modelNumber;
    private String version;
    private Date dateOfPurchase;
    private Date dateOfExpiry;

    public AssetDTO(int id, String assetName, String assetType, String status, String modelNumber, String version,
            Date dateOfPurchase, Date dateOfExpiry) {
        this.id = id;
        this.assetName = assetName;
        this.assetType = assetType;
        this.modelNumber = modelNumber;
        this.version = version;
        this.status = status;
        this.modelNumber = modelNumber;
        this.version = version;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfExpiry = dateOfExpiry;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getStatus() {
        return status;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getVersion() {
        return version;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }
}
