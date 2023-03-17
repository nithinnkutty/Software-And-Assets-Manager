package com.bipsync.SoftwareAndAssetsManager.Unittests;

import com.bipsync.SoftwareAndAssetsManager.DTO.AssetDTO;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Unittests {
    @Test
    public void AssetDTOTest() throws ParseException {

        SimpleDateFormat S = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOfPurchase = S.parse("2020-10-15");
        Date dateOfExpiry   = S.parse("2025-10-15");
        Date assignedOn     = S.parse("2021-05-02");

        AssetDTO assetDTO = new AssetDTO(1000,100,"assetName","assetType",
                "model Number","version", "status",dateOfPurchase,dateOfExpiry,
                assignedOn,"Name","Surname","finance","region");
        assertEquals(assetDTO.getAssetName(),"assetName");
        assertEquals(assetDTO.getAssetType(),"assetType");
        assertEquals(assetDTO.getAssignedOn().toString(),"Sun May 02 00:00:00 BST 2021");
        assertEquals(assetDTO.getDateOfPurchase().toString(),"Thu Oct 15 00:00:00 BST 2020");
        assertEquals(assetDTO.getDateOfExpiry().toString(),"Wed Oct 15 00:00:00 BST 2025");
    }


}
