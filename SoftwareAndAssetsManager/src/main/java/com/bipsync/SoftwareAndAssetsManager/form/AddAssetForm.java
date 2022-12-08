package com.Bipsync.SoftwareAndAssetsManager.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddAssetForm {
    private String assetName;
    private String assetType;
    private String status;
    private String modelNumber;
    private String version;
    private Date dateOfPurchase;
    private Date dateOfExpiry;

    public AddAssetForm(String assetName, String assetType, String status, String modelNumber, String version, String dateOfPurchase, String dateOfExpiry) throws ParseException {
        this.assetName = assetName;
        this.assetType = assetType;
        this.status = status;
        this.modelNumber = modelNumber;
        this.version = version;
        this.dateOfPurchase = formatDate(dateOfPurchase);
        this.dateOfExpiry = formatDate(dateOfExpiry);
    }

    public Date formatDate(String dateOfExpiry) throws ParseException {
        String dateString = dateOfExpiry;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateString);
        System.out.println("Date value: "+date);
        return date;
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
