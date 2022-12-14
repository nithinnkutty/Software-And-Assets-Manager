package com.Bipsync.SoftwareAndAssetsManager.model;
import com.Bipsync.SoftwareAndAssetsManager.DTO.AssignedAssetsDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AssignedAssetsMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        AssignedAssetsDTO assignedAssetsDTO= new AssignedAssetsDTO(rs.getInt("ID"),
                rs.getInt("employeeID"),
                rs.getString("assetName"),
                rs.getString("assetType"),
                rs.getString("modelNumber"),
                rs.getString("version"),
                rs.getString("status"),
                rs.getDate("dateOfPurchase"),
                rs.getDate("dateOfExpiry"),
                rs.getDate("assignedOn"),
                rs.getString("firstName"),
                rs.getString("surname"),
                rs.getString("department"),
                rs.getString("region"));
//             System.out.println(assignedAssetsDTO);
            return assignedAssetsDTO;
    }
}
