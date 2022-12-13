package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.DTO.EmployeeDTO;
import com.Bipsync.SoftwareAndAssetsManager.model.EmployeeMapper;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.util.ReflectionTestUtils;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.*;
// how to write test for this type of classes?

public class EmployeeRepositoryJDBCTest {


    @Autowired private JdbcTemplate jdbcTemplate;

    @Test
    public void findAllEmployee() {

        assertNotNull(jdbcTemplate.query(
                "select ID,firstName,surname,username,Password,Department,authority,region from employees" ,
                new EmployeeMapper()));
      }

    @Test
    public void addEmployee() {
    }

    @Test
    public void editEmployee() {
    }

    @Test
    public void deleteEmployee() {
    }
}