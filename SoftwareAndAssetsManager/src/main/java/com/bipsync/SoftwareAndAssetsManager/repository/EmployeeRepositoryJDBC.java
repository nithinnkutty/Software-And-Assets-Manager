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
                "select ID,firstName,surname,Username,Password,Department,Authority,Region from employee" ,
                new EmployeeMapper());
    }

//    @Override
//    public List<EmployeeDTO> findGeneral() {
//        String GeneralAdmin = "General";
//        return jdbcTemplate.query(
//                "select ID,firstName,surname,username,Password,Department,Authority,Region from employee where Authority = '" + GeneralAdmin + "'",
//                new EmployeeMapper());
//    }
//
//    @Override
//    public List<EmployeeDTO> findSuper() {
//        String SuperAdmin = "Super";
//        return jdbcTemplate.query(
//                "select ID,firstName,surname,username,Password,Department,Authority,Region from employee where Authority = '" + SuperAdmin + "'",
//                new EmployeeMapper());
//    }

    public boolean AddEmployee(AddEmployeeForm addEmployeeForm) {
        System.out.println("this is password value from input" + addEmployeeForm.getAuthority());
        int rows = jdbcTemplate.update(
                "insert into employee (firstName,surname,username, Password,Department,Authority,Region) values(?,?,?,?,?,?,?)" ,
                new Object[]{addEmployeeForm.getFirstName(),
                        addEmployeeForm.getsurname(),
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
        System.out.println(editEmployeeForm.getAuthority());

        int rows = jdbcTemplate.update("update employee set firstName= ?, surname = ? , username=?, Password = ?, Department = ?, Authority = ? , Region = ? where id = ?",
                editEmployeeForm.getFirstName(), editEmployeeForm.getsurname(), editEmployeeForm.getUsername(),editEmployeeForm.getPassword(), editEmployeeForm.getDepartment(), editEmployeeForm.getAuthority(), editEmployeeForm.getRegion(), editEmployeeForm.getID());
        System.out.println("rows = " + rows);
        return(rows>0);
    }

    @Override
    public boolean DeleteEmployee(DeleteEmployeeForm deleteEmployeeForm) {
        int rows = jdbcTemplate.update("delete from employee where id = ?", deleteEmployeeForm.getID());
        System.out.println("deleted");
        return (rows>0 );

    }


}
