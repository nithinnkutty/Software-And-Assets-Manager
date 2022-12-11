package com.Bipsync.SoftwareAndAssetsManager.Controller;

import com.Bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    private EmployeeController testEmployeeC;

    @Test
    public void searchAll() {
        assertNotNull(testEmployeeC.searchAll());
    }

    @Test
    public void addAdmin() {

    }

    @Test
    public void editAdmin() {
    }

    @Test
    public void deleteAdmin() {
    }
}