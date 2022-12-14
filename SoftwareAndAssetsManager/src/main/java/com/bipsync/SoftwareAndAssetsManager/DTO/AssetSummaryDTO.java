package com.Bipsync.SoftwareAndAssetsManager.DTO;

public class AssetSummaryDTO {

    private int ID;
    private String assetName;
    private String assetType;
    private int assigned;
    private int unassigned;
    private int total;

    private static int totalAssigned = 0;
    private static int totalUnassigned = 0;
    private static int totalAssets = 0;


    public AssetSummaryDTO(int ID, String assetName, String assetType, int assigned, int unassigned, int total) {
        this.ID = ID;
        this.assetName = assetName;
        this.assetType = assetType;
        this.assigned = assigned;
        this.unassigned = unassigned;
        this.total = total;

        if(ID==1){
            totalAssigned =0;
            totalUnassigned= 0;
            totalAssets = 0;
        }
        totalAssigned= totalAssigned + assigned;
        totalUnassigned = totalUnassigned + unassigned;
        totalAssets = totalAssets + total;
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


    public int getAssigned() {
        return assigned;
    }

    public int getUnassigned() {
        return unassigned;
    }

    public int getTotal() {
        return total;
    }

    public static int getTotalAssigned() {
        return totalAssigned;
    }

    public static int getTotalUnassigned() {
        return totalUnassigned;
    }

    public static int getTotalAssets() {
        return totalAssets;
    }
}
