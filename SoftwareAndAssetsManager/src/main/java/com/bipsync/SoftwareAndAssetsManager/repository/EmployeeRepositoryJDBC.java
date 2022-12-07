package com.bipsync.SoftwareAndAssetsManager.repository;


import com.bipsync.SoftwareAndAssetsManager.DTO.EmployeeDTO;
import com.bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import com.bipsync.SoftwareAndAssetsManager.model.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryJDBC implements com.bipsync.SoftwareAndAssetsManager.repository.EmployeeRepository {

    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    private JdbcTemplate jdbcTemplate;

    //? no beans of jdbc?
    @Autowired
    public EmployeeRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }

    //in this class ,write the sql statements
    @Override
    public EmployeeDTO findEmployeeByName(String surname) {
        EmployeeDTO employeeDTO = (EmployeeDTO) jdbcTemplate.queryForObject(
                // queryForObject(String sql, Object[] args, RowMapper<T> rowMapper)
                "select ID,Name,Department,Authority from employee where name=?" ,
                new Object[]{surname}, new EmployeeMapper());
        return employeeDTO;

    }

    @Override
    public List<EmployeeDTO> findAllEmployee() {
        return jdbcTemplate.query(
                "select ID,Name,Department,Authority from Employee" ,
                new EmployeeMapper());
    }

    @Override
    public boolean addEmployee(AddEmployeeForm addEmployeeForm) {
        int rows = jdbcTemplate.update(
                "insert into Employee (Name,Department,Authority) values(?,?,?)" ,
                new Object[]{addEmployeeForm.getName(),addEmployeeForm.getDepartment(),addEmployeeForm.getAuthority()});
        return rows>0;
    }

    public boolean SampleFunction(AddEmployeeForm addEmployeeForm) {
        int rows = jdbcTemplate.update(
                "insert into Employee (Name,Department,Authority) values(?,?,?)" ,
                new Object[]{addEmployeeForm.getName(),addEmployeeForm.getDepartment(),addEmployeeForm.getAuthority()});
        return rows>0;
    }


}
