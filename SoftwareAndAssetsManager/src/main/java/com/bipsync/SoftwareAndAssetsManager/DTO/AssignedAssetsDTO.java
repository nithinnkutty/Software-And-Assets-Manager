package com.Bipsync.SoftwareAndAssetsManager.DTO;

import java.util.Date;

public class AssignedAssetsDTO {
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

    public AssignedAssetsDTO(int ID, int employeeID, String assetName, String assetType, String modelNumber, String version, String status, Date dateOfPurchase, Date dateOfExpiry, Date assignedOn, String firstName, String surname, String department, String region) {
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
        //        If the asset is unallocated, it will show "unallocated" on the front end to make it easier for the user to understand
        if(employeeID==0){
            this.firstName="Un";
            this.surname = "allocated";
        }else {
//            If allocation information exists, it is displayed normally
            this.firstName = firstName;
            this.surname = surname;}
        this.department = department;
        this.region = region;
    }

    @Override
    public String toString() {
        return "AssignedAssetsDTO{" +
                "ID=" + ID +
                ", employeeID=" + employeeID +
                ", assetName='" + assetName + '\'' +
                ", assetType='" + assetType + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", version='" + version + '\'' +
                ", status='" + status + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", dateOfExpiry=" + dateOfExpiry +
                ", assignedOn=" + assignedOn +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", region='" + region + '\'' +
                '}';
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
