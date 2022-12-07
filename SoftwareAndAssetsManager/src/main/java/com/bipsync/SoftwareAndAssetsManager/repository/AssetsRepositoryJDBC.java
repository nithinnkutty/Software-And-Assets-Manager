package com.Bipsync.SoftwareAndAssetsManager.repository;


import com.Bipsync.SoftwareAndAssetsManager.DTO.AssetDTO;
import com.Bipsync.SoftwareAndAssetsManager.DTO.AssignedAssetsDTO;
import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.SearchAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.model.AssetMapper;
import com.Bipsync.SoftwareAndAssetsManager.model.AssignedAssetsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetsRepositoryJDBC implements com.Bipsync.SoftwareAndAssetsManager.repository.AssetsRepository {

    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    private JdbcTemplate jdbcTemplate;

//? no beans of jdbc?
    @Autowired
    public AssetsRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    //in this class ,write the sql statements
    @Override
    public boolean addAsset(AddAssetForm addAssetForm) {
        int rows = jdbcTemplate.update(
                "insert into assets (assetName,assetType,status,dateOfPurchase,dateOfExpiry) values(?,?,?,?,?)" ,
                new Object[]{addAssetForm.getAssetName(), addAssetForm.getAssetType(),
                        addAssetForm.getStatus(), addAssetForm.getDateOfPurchase(), addAssetForm.getDateOfExpiry()});
        return rows>0;

    }

    @Override
    public Object searchAsset(SearchAssetForm searchAssetForm) {
        return jdbcTemplate.query(
                "select * from assets" ,
                new AssetMapper());
    }


    @Override
    public List<AssetDTO> getAllAssets() {
        return jdbcTemplate.query(
                "select * from assets" ,
                new AssetMapper());
    }

    @Override
    public List<AssignedAssetsDTO> getAllAssignedAssets() {
        return jdbcTemplate.query(
                "select b.*, e.firstname, e.surname, e.region\n" +
                        "from (select a.*, s.assignedOn, s.employeeID\n" +
                        "      from assets a\n" +
                        "               left join assigned s on a.id = s.assetID) b\n" +
                        "         left join employees e on b.employeeID = e.ID" ,
                new AssignedAssetsMapper());
    }

}
