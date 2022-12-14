package com.Bipsync.SoftwareAndAssetsManager.DTO;

public class AssetSummaryDTO {

    private int ID;
    private String assetName;
    private String assetType;
    private int assigned;
    private int unassigned;
    private int total;

    public AssetSummaryDTO(int ID, String assetName, String assetType, int assigned, int unassigned, int total) {
        this.ID = ID;
        this.assetName = assetName;
        this.assetType = assetType;
        this.assigned = assigned;
        this.unassigned = unassigned;
        this.total = total;
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
}
