package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.DTO.AssetDTO;
import com.Bipsync.SoftwareAndAssetsManager.DTO.AssetSummaryDTO;
import com.Bipsync.SoftwareAndAssetsManager.DTO.AssignedAssetsDTO;
import com.Bipsync.SoftwareAndAssetsManager.form.AddAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditAssetForm;
import com.Bipsync.SoftwareAndAssetsManager.model.AssetMapper;
import com.Bipsync.SoftwareAndAssetsManager.model.AssetSummaryMapper;
import com.Bipsync.SoftwareAndAssetsManager.model.AssignedAssetsMapper;
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
    public List<AssetSummaryDTO> getAssetsSummary() {
        return jdbcTemplate.query(
                "SELECT assets.assetName," +
                        "assets.assetType," +
                        "count(assets.employeeID)-count(case when assets.employeeID = 0 then 1 end) as assigned," +
                        "count(case when assets.employeeID = 0 then 1 end)+count(case when assets.employeeID is null then 1 end) as Unassigned," +
                        "count(*) as total" +
                        " FROM assets LEFT OUTER JOIN employees " +
                        "ON assets.employeeID = employees.ID " +
                        "group by assets.assetName,assets.assetType" ,
                new AssetSummaryMapper());
    }
//    Multi-table search :Instantiate the queried AssignedAsset via the corresponding Mapper for use by the front-end
    @Override
    public List<AssignedAssetsDTO> getAllAssignedAssets() {
        return jdbcTemplate.query(
                "select a.*,e.firstName,e.surname,e.department,e.region from assets a left join employees e on a.employeeID = e.ID",
                new AssignedAssetsMapper());
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

    @Override
    public boolean EditAsset(EditAssetForm editAssetForm) {
        int rows = jdbcTemplate.update(
                "update assets set assetName = ? ,employeeID=?, assetType = ?, modelNumber = ?, version = ?,dateOfPurchase= ?,assignedOn= ? where ID = ?",
                editAssetForm.getAssetName(), editAssetForm.getEmployeeID(),editAssetForm.getAssetType(), editAssetForm.getModelNumber(),
                editAssetForm.getVersion(),editAssetForm.getDateOfPurchase(),editAssetForm.getAssignedOn(), editAssetForm.getID());
        return rows>0;
    }

    @Override
    public boolean DeleteAsset(EditAssetForm editAssetForm) {
        int rows = jdbcTemplate.update("delete from assets where ID = ?", editAssetForm.getID());
        System.out.println("deleted");
        return rows>0 ;
    }

}
