package com.Bipsync.SoftwareAndAssetsManager.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Collection of editing forms obtained from the front end
//This class is used for both edit and delete functions
public class EditAssetForm {
    private int ID;

    private int employeeID;
    private String assetName;
    private String assetType;
    private String modelNumber;
    private String version;
    private Date dateOfPurchase;
    private Date assignedOn;

    public EditAssetForm(int ID, int employeeID,String assetName, String assetType, String modelNumber, String version,String dateOfPurchase,String assignedOn) throws ParseException {

        this.ID = ID;
        this.employeeID = employeeID;
        this.assetName = assetName;
        this.assetType = assetType;
        this.modelNumber = modelNumber;
        this.version = version;
        this.dateOfPurchase = formatDate(dateOfPurchase);
//        Resolved an issue that could not be modified if a date was not assigned. (Date does not accept null)
        if (assignedOn==""){
            this.assignedOn = null;
        }else {this.assignedOn = formatDate(assignedOn);}

    }

    @Override
    public String toString() {
        return "EditAssetForm{" +
                "ID=" + ID +
                ", employeeID=" + employeeID +
                ", assetName='" + assetName + '\'' +
                ", assetType='" + assetType + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", version='" + version + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                ", dateOfAssigned=" + assignedOn +
                '}';
    }

    private Date formatDate(String dateInfo) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateInfo);
        System.out.println("Date value: "+date);
        return date;
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

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public Date getAssignedOn() {
        return assignedOn;
    }
}
