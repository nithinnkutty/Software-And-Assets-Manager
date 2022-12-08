package com.Bipsync.SoftwareAndAssetsManager.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//Collection of editing forms obtained from the front end
public class EditAssetForm {
    private int ID;
    private String assetName;
    private String assetType;
    private String modelNumber;
    private String version;
    private Date dateOfPurchase;

    public EditAssetForm(int ID, String assetName, String assetType, String modelNumber, String version,String dateOfPurchase) throws ParseException {
        this.ID = ID;
        this.assetName = assetName;
        this.assetType = assetType;
        this.modelNumber = modelNumber;
        this.version = version;
        this.dateOfPurchase = formatDate(dateOfPurchase);
    }

    @Override
    public String toString() {
        return "EditAssetForm{" +
                "ID=" + ID +
                ", assetName='" + assetName + '\'' +
                ", assetType='" + assetType + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", version='" + version + '\'' +
                ", dateOfPurchase=" + dateOfPurchase +
                '}';
    }

    private Date formatDate(String dateOfPurchase) throws ParseException {
        String dateString = dateOfPurchase;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateString);
        System.out.println("Date value: "+date);
        return date;
    }

    public int getID() {
        return ID;
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
}
