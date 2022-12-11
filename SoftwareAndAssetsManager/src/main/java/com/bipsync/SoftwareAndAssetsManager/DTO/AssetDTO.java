package com.Bipsync.SoftwareAndAssetsManager.DTO;

import java.util.Date;

public class AssetDTO {
    //In this class, one line == one column in db table
    //Provided with corresponding getters and setters
    private int id;
    private String assetName;
    private String assetType;
    private String status;
    private String modelNumber;
    private String version;
    private Date dateOfPurchase;
    private Date dateOfExpiry;
    private Integer employeeID;

    private String department;
    private String region;


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public AssetDTO(int id, String assetName, String assetType, String status, String modelNumber, String version, Date dateOfPurchase,
                    Date dateOfExpiry, Integer employeeID, String department, String region) {
        this.id = id;
        this.assetName = assetName;
        this.assetType = assetType;
        this.status = status;
        this.modelNumber = modelNumber;
        this.version = version;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfExpiry = dateOfExpiry;
        this.employeeID = employeeID;
        this.department = department;
        this.region = region;
    }

    public int getId() {
        return id;
    }
    public Integer getEmployeeID() {
        return employeeID;
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

    public String getModelNumber() {
        return modelNumber;
    }

    public String getVersion() {
        return version;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }
}

