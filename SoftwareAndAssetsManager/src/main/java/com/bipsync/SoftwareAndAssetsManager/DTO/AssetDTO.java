package com.Bipsync.SoftwareAndAssetsManager.DTO;

import java.util.Date;

public class AssetDTO {
    private int ID;
    private int employeeID;
    private String assetName;
    private String assetType;
    private String modelNumber;
    private String version;
    private String status;
    private Date dateOfPurchase;
    private Date dateOfExpiry;
    private Date assignedOn;
    private String firstName;
    private String surname;
    private String department;
    private String region;


    public AssetDTO(int ID, int employeeID, String assetName, String assetType, String modelNumber, String version, String status, Date dateOfPurchase, Date dateOfExpiry, Date assignedOn, String firstName, String surname, String department, String region) {
        this.ID = ID;
        this.employeeID = employeeID;
        this.assetName = assetName;
        this.assetType = assetType;
        this.modelNumber = modelNumber;
        this.version = version;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfExpiry = dateOfExpiry;
        this.assignedOn = assignedOn;
        this.firstName = firstName;
        this.surname = surname;
        this.department = department;
        this.region = region;
    }

    public int getID() {
        return ID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public String getAssetName() {
        return assetName;
    }

    public String getAssetType() {
        return assetType;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public String getVersion() {
        return version;
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

    public Date getAssignedOn() {
        return assignedOn;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartment() {
        return department;
    }

    public String getRegion() {
        return region;
    }
}





