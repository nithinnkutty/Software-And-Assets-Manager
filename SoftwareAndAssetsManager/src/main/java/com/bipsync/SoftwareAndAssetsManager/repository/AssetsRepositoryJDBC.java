package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.DTO.AssetDTO;
import com.Bipsync.SoftwareAndAssetsManager.DTO.AssignedAssetsDTO;
import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.model.AssetMapper;
import com.Bipsync.SoftwareAndAssetsManager.model.AssignedAssetsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetsRepositoryJDBC implements com.Bipsync.SoftwareAndAssetsManager.repository.AssetsRepository {

    // https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    private JdbcTemplate jdbcTemplate;

    // ? no beans of jdbc?
    @Autowired
    public AssetsRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    // in this class ,write the sql statements
    @Override
    public boolean addAsset(AddAssetForm addAssetForm) {
        int rows = jdbcTemplate.update(
                "insert into assets (assetName,assetType,status,modelNumber,version,dateOfPurchase,dateOfExpiry) values(?,?,?,?,?,?,?)",
                new Object[] { addAssetForm.getAssetName(), addAssetForm.getAssetType(),
                        addAssetForm.getStatus(), addAssetForm.getModelNumber(),
                        addAssetForm.getVersion(), addAssetForm.getDateOfPurchase(),
                        addAssetForm.getDateOfExpiry() });
        return rows > 0;

    }


    @Override
    public List<AssetDTO> getAllAssets() {
        return jdbcTemplate.query(
                "select ID,assetName,assetType,status,dateOfPurchase,dateOfExpiry from assets",
                new AssetMapper());
    }


//    Multi-table search :Instantiate the queried AssignedAsset via the corresponding Mapper for use by the front-end
    @Override
    public List<AssignedAssetsDTO> getAllAssignedAssets() {
        return jdbcTemplate.query(
                "select b.*, e.firstname, e.surname, e.region\n" +
                        "from (select a.*, s.assignedOn, s.employeeID\n" +
                        "      from assets a\n" +
                        "               left join assigned s on a.id = s.assetID) b\n" +
                        "         left join employees e on b.employeeID = e.ID",
                new AssignedAssetsMapper());
    }


    @Override
    public boolean EditAsset(EditAssetForm editAssetForm) {
        int rows = jdbcTemplate.update(
                "update assets set assetName = ? , assetType = ?, modelNumber = ?, version = ?,dateOfPurchase= ? where ID = ?",
                editAssetForm.getAssetName(), editAssetForm.getAssetType(), editAssetForm.getModelNumber(),
                editAssetForm.getVersion(),editAssetForm.getDateOfPurchase(), editAssetForm.getID());
        return rows > 0;
    }

}
