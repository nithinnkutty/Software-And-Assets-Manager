package com.bipsync.SoftwareAndAssetsManager.DTO;

import lombok.Data;

import java.util.Date;

@Data
public class AssetDTO {
    private Date dateOfExpiry;
    //In this class, one line == one column in db table
    //Provided with corresponding getters and setters
    private int id;
    private String assetName;
    private String assetType;
    private String serialNumber;
    private String status;
    private Integer employeeID;
    private String department;
    private String region;
    private Date dateOfPurchase;



    public AssetDTO(int id, String assetName, String assetType, String serialNumber, String status, int employeeID, String department, String region, Date dateOfPurchase, Date dateOfExpiry) {
        this.id = id;
        this.assetName = assetName;
        this.assetType = assetType;
        this.serialNumber = serialNumber;
        this.status = status;
        this.employeeID = employeeID;
        this.department = department;
        this.region = region;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfExpiry = dateOfExpiry;
    }

    public AssetDTO(int id, String assetName, String assetType,String serialNumber, String status, Integer employeeID,String department, String region,java.sql.Date dateOfPurchase,java.sql.Date dateOfExpiry) {
    }

//    public AssetDTO(int id, String assetName, String assetType, String status, String dateOfPurchase, java.sql.Date dateOfExpiry, java.sql.Date employeeID, int serialNumber) {
//    }

    public int getId() {
        return id;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getStatus() {
        return status;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public String getDepartment() {
        return department;
    }

    public String getRegion() {
        return region;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }
    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

}

