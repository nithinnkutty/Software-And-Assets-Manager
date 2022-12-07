package com.bipsync.SoftwareAndAssetsManager.repository;


import com.bipsync.SoftwareAndAssetsManager.DTO.AssetDTO;
import com.bipsync.SoftwareAndAssetsManager.model.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetsRepositoryJDBC implements com.bipsync.SoftwareAndAssetsManager.repository.AssetsRepository {

    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    private JdbcTemplate jdbcTemplate;

//? no beans of jdbc?
    @Autowired
    public AssetsRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    //in this class ,write the sql statements
    @Override
    public boolean addAsset(com.bipsync.SoftwareAndAssetsManager.form.AddAssetForm addAssetForm) {
        int rows = jdbcTemplate.update(
                "insert into assets (assetName,assetType,status,dateOfPurchase,dateOfExpiry) values(?,?,?,?,?)" ,
                new Object[]{addAssetForm.getAssetName(), addAssetForm.getAssetType(),
                        addAssetForm.getStatus(), addAssetForm.getDateOfPurchase(), addAssetForm.getDateOfExpiry()});
        return rows>0;

    }

    @Override
    public List<AssetDTO> getAllAssets() {
        return jdbcTemplate.query(
                "SELECT " +
                        "  assets.ID, " +
                        "  assetName, " +
                        "  assetType, " +
                        "  STATUS, " +
                        "  dateOfPurchase, " +
                        "  dateOfExpiry, " +
                        "  employeeID , " +
                        "  employees.department, " +
                        "  employees.region, " +
                        "  assets.serialNumber " +
                        "FROM " +
                        "  assets " +
                        "  INNER JOIN assigned  on   assets.id = assigned.employeeID " +
                        "  inner join  employees on employees.id = assigned.employeeID " ,

                new AssetMapper());
    }

    @Override
    public int updateDataBYID(int id, String state) {
        int update = jdbcTemplate.update("update assets set status = '" + state + "' where id = '" + id + "'");
        return update;
    }
}
