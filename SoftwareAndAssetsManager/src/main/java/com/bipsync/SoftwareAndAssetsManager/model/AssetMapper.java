package com.Bipsync.SoftwareAndAssetsManager.model;
import com.Bipsync.SoftwareAndAssetsManager.DTO.AssetDTO;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AssetMapper implements RowMapper {
    //public T query(String sqlQuery, RowMapper<T> rowMapper
    //query class
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AssetDTO(rs.getInt("ID"),
                rs.getString("assetName"),
                rs.getString("assetType"),
                rs.getString("status"),
                rs.getDate("dateOfPurchase"),
                rs.getDate("dateOfExpiry"));
    }
}