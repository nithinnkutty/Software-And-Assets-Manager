package com.Bipsync.SoftwareAndAssetsManager.DTO;

import java.util.Date;

public class AssetDTO {
    //In this class, one line == one column in db table
    //Provided with corresponding getters and setters
    private int id;
    private String assetName;
    private String assetType;
    private String status;
    private Date dateOfPurchase;
    private Date dateOfExpiry;


    public AssetDTO(int id, String assetName, String assetType, String status,
                    Date dateOfPurchase,Date dateOfExpiry ) {
        this.id = id;
        this.assetName = assetName;
        this.assetType = assetType;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfExpiry = dateOfExpiry;
    }

    public int getId() {
        return id;
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

