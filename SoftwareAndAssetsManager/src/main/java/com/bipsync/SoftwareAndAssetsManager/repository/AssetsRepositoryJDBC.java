package com.Bipsync.SoftwareAndAssetsManager.repository;


import com.Bipsync.SoftwareAndAssetsManager.DTO.AssetDTO;
import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.model.AssetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetsRepositoryJDBC implements AssetsRepository {

    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AssetsRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    //in this class ,write the sql statements
    @Override
    public boolean addAsset(AddAssetForm addAssetForm) {
        int rows = jdbcTemplate.update(
                "insert into assets (assetName,assetType,status,modelNumber,version,dateOfPurchase,dateOfExpiry) values(?,?,?,?,?,?,?)" ,
                new Object[]{addAssetForm.getAssetName(), addAssetForm.getAssetType(),
                        addAssetForm.getStatus(),addAssetForm.getModelNumber(),
                        addAssetForm.getVersion(), addAssetForm.getDateOfPurchase(),
                        addAssetForm.getDateOfExpiry()});
        return rows>0;

    }

    @Override
    public List<AssetDTO> getAllAssets() {
        return jdbcTemplate.query(
                "SELECT assets.*," +
                        "employees.firstName," +
                        "employees.surname," +
                        "employees.department," +
                        "employees.region " +
                        "FROM assets LEFT OUTER JOIN employees " +
                        "ON assets.employeeID = employees.ID" ,
                new AssetMapper());
    }
    @Override
    public List<AssetDTO> getAssetsSummary() {
        return jdbcTemplate.query(
                "select ID,assetName,assetType,status,modelNumber,version,dateOfPurchase,dateOfExpiry from assets" ,
                new AssetMapper());
    }
    @Override
    public List<AssetDTO> getAllAssetsByStatus(String status) {
            String andSql = "";
            if(status != null){
                andSql= "where STATUS = '"+status+"'";
            }
            List query = jdbcTemplate.query(
                    "SELECT assets.*," +
                            "employees.firstName," +
                            "employees.surname," +
                            "employees.department," +
                            "employees.region " +
                            "FROM " +
                            "assets " +
                            " LEFT join  employees on employees.id = assets.employeeID  " + andSql,

                    new AssetMapper());
            return  query;
        }

    @Override
    public int updateDataBYID(int id, String state) {
        int update = jdbcTemplate.update("update assets set status = '" + state + "' where id = '" + id + "'");
        return update;
    }
}
