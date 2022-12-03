package com.bipsync.SoftwareAndAssetsManager.model;

import com.bipsync.SoftwareAndAssetsManager.DTO.AdminDTO;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper {
    //public T query(String sqlQuery, RowMapper<T> rowMapper
    //query class
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new AdminDTO(rs.getInt("ID"),
                rs.getString("Name"),
                rs.getString("Department"),
                rs.getString("Authority"));
    }
}