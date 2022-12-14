package com.Bipsync.SoftwareAndAssetsManager.repository;

import com.Bipsync.SoftwareAndAssetsManager.DTO.EmployeeDTO;
import com.Bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.form.DeleteEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.model.EmployeeMapper;
import com.Bipsync.SoftwareAndAssetsManager.form.EditEmployeeForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryJDBC implements EmployeeRepository {

    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    private JdbcTemplate jdbcTemplate;

//? no beans of jdbc?
    @Autowired
    public EmployeeRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }



    @Override
    public List<EmployeeDTO> findAllEmployee() {

        return jdbcTemplate.query(
                "select ID,firstName,surname,username,password ,department,authority,region from employees" ,
                new EmployeeMapper());
    }

//    @Override
//    public List<EmployeeDTO> findGeneral() {
//        String GeneralAdmin = "General";
//        return jdbcTemplate.query(
//                "select ID,firstName,surname,username,password

//,department,authority,region from employee where authority = '" + GeneralAdmin + "'",
//                new EmployeeMapper());
//    }
//
//    @Override
//    public List<EmployeeDTO> findSuper() {
//        String SuperAdmin = "Super";
//        return jdbcTemplate.query(
//                "select ID,firstName,surname,username,password

//,department,authority,region from employee where authority = '" + SuperAdmin + "'",
//                new EmployeeMapper());
//    }

    public boolean AddEmployee(AddEmployeeForm addEmployeeForm) {
        int rows = jdbcTemplate.update(
                "insert into employees (firstName,surname,username,password,department,authority,region) values(?,?,?,?,?,?,?)" ,
                new Object[]{addEmployeeForm.getFirstName(),
                        addEmployeeForm.getSurname(),
                        addEmployeeForm.getUsername(),
                        addEmployeeForm.getPassword(),
                        addEmployeeForm.getDepartment(),
                        addEmployeeForm.getAuthority(),
                        addEmployeeForm.getRegion()});

        System.out.println(rows);
        return (rows>0);
    }

    @Override
    public boolean EditEmployee(EditEmployeeForm editEmployeeForm) {

        int rows = jdbcTemplate.update("update employees set firstName= ?, surname = ? , username=?,password = ?, Department = ?, authority = ? , region = ? where id = ?",
                editEmployeeForm.getFirstName(), editEmployeeForm.getSurname(), editEmployeeForm.getUsername(),editEmployeeForm.getPassword(), editEmployeeForm.getDepartment(), editEmployeeForm.getAuthority(), editEmployeeForm.getRegion(), editEmployeeForm.getID());
        System.out.println("rows = " + rows);
        return(rows>0);
    }

    @Override
    public boolean DeleteEmployee(DeleteEmployeeForm deleteEmployeeForm) {
        int rows = jdbcTemplate.update("delete from employees where id = ?", deleteEmployeeForm.getID());
        System.out.println("deleted");
        return (rows>0 );

    }


}
