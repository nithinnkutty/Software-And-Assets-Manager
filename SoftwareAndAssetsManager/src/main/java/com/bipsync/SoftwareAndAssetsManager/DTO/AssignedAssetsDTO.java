package com.Bipsync.SoftwareAndAssetsManager.DTO;

import java.util.Date;

public class AssignedAssetsDTO {
    private int ID;
    private String assetName;
    private String assetType;
    private String modelNumber;
    private String version;
    private String status;
    private Date dateOfPurchase;
    private Date dateOfExpiry;
    private Date assignedOn;
    private int employeeID;
    private String firstname;
    private String surname;
    private String region;

    public AssignedAssetsDTO(int ID, String assetName, String assetType, String modelNumber, String version, String status, Date dateOfPurchase, Date dateOfExpiry, Date assignedOn, int employeeID, String firstname, String surname, String region) {
        this.ID = ID;
        this.assetName = assetName;
        this.assetType = assetType;
        this.modelNumber = modelNumber;
        this.version = version;
        this.status = status;
        this.dateOfPurchase = dateOfPurchase;
        this.dateOfExpiry = dateOfExpiry;
        this.assignedOn = assignedOn;
        this.employeeID = employeeID;
        this.firstname = firstname;
        this.surname = surname;
        this.region = region;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public void setStatus(String status) {
        this.status = status;
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

    public Date getAssignedOn() {
        return assignedOn;
    }

    public void setAssignedOn(Date assignedOn) {
        this.assignedOn = assignedOn;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
