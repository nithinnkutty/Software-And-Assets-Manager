package com.Bipsync.SoftwareAndAssetsManager.model;


import com.Bipsync.SoftwareAndAssetsManager.DTO.AssetSummaryDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssetSummaryMapper implements RowMapper {
    //public T query(String sqlQuery, RowMapper<T> rowMapper
    //query class
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AssetSummaryDTO((rowNum +1),
                rs.getString("assetName"),
                rs.getString("assetType"),
                rs.getInt("Assigned"),
                rs.getInt("Unassigned"),
                rs.getInt("Total"));
    }
}