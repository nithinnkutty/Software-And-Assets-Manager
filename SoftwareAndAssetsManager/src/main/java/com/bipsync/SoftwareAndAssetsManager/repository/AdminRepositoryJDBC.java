package com.bipsync.SoftwareAndAssetsManager.repository;


import com.bipsync.SoftwareAndAssetsManager.DTO.AdminDTO;
import com.bipsync.SoftwareAndAssetsManager.form.AddAdminForm;
import com.bipsync.SoftwareAndAssetsManager.form.DeleteAdminForm;
import com.bipsync.SoftwareAndAssetsManager.model.AdminMapper;
import com.bipsync.SoftwareAndAssetsManager.form.EditAdminForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public class AdminRepositoryJDBC implements AdminRepository {

    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/JdbcTemplate.html
    private JdbcTemplate jdbcTemplate;

//? no beans of jdbc?
    @Autowired
    public AdminRepositoryJDBC(JdbcTemplate aTemplate) {
        jdbcTemplate = aTemplate;
    }



    @Override
    public List<AdminDTO> findAllAdmin() {
        return jdbcTemplate.query(
                "select ID,Name,Department,Authority from admin" ,
                new AdminMapper());
    }

    public boolean AddAdmin(AddAdminForm addAdminForm) {
        int rows = jdbcTemplate.update(
                "insert into admin (Name,Department,Authority) values(?,?,?)" ,
                new Object[]{addAdminForm.getName(), addAdminForm.getDepartment(), addAdminForm.getAuthority()});
        int license = jdbcTemplate.update(
                "insert into login (password) values(?)" ,
                new Object[]{addAdminForm.getPassword()});
        return (rows>0 && license>0);
    }

    @Override
    public boolean EditAdmin(EditAdminForm editAdminForm) {
        int rows = jdbcTemplate.update("update admin set Name = ? , Department = ?, Authority = ? where id = ?",
                editAdminForm.getName(),editAdminForm.getDepartment(),editAdminForm.getAuthority(),editAdminForm.getID());
        int license = jdbcTemplate.update(
                "update login set password = ? where ID = ?" ,editAdminForm.getPassword(),editAdminForm.getID());
               return(rows>0 && license>0);
    }

    @Override
    public boolean DeleteAdmin(DeleteAdminForm deleteAdminForm) {
        int rows = jdbcTemplate.update("delete from admin where id = ?",deleteAdminForm.getID());
        int license = jdbcTemplate.update(" delete from login where id = ?",deleteAdminForm.getID());
        return (rows>0 && license>0);

    }


}
