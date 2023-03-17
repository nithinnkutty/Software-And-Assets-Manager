package com.bipsync.SoftwareAndAssetsManager.model;

import com.bipsync.SoftwareAndAssetsManager.DTO.EmployeeDTO;
import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper {
    //public T query(String sqlQuery, RowMapper<T> rowMapper
    //query class
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmployeeDTO(rs.getInt("ID"),
                rs.getString("firstName"),
                rs.getString("surname"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("department"),
                rs.getString("authority"),
                rs.getString("region"));
    }
}