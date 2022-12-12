package com.Bipsync.SoftwareAndAssetsManager.Controller;

import com.Bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.form.DeleteEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.repository.EmployeeRepositoryJDBC;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    private EmployeeController testEmployeeC;
    private EmployeeRepositoryJDBC testEmployeeR;

    private  AddEmployeeForm addTest =  new AddEmployeeForm("fn","sn","","","COMSC","None","UK");

    private EditEmployeeForm editTest = new EditEmployeeForm(999,"fe","se","","","COMSC", "NONE","UK");
    private DeleteEmployeeForm deleteTest = new DeleteEmployeeForm(999,"fe","se","","","COMSC", "NONE","UK");
    @Mock
    private BindingResult bindingResultTest;
    @Before
    public void setupTest() {
        MockitoAnnotations.initMocks(this);
        // While the default boolean return value for a mock is 'false',
        // it's good to be explicit anyway:
        Mockito.when(bindingResultTest.hasErrors()).thenReturn(false);
    }


    @Test
    public void searchAll() {

        assertNotNull(testEmployeeC.searchAll());
        ModelAndView mav = testEmployeeC.searchAll();
        assertEquals("redirect:/manageAdminSupAdmin",mav.getViewName());
    }

    @Test
    public void addAdmin() {
        // Simulate having errors just for this test:
        Mockito.when(bindingResultTest.hasErrors()).thenReturn(true);

        ModelAndView mav = testEmployeeC.AddAdmin(addTest,bindingResultTest);

        // Check that we returned back to the original form:
        assertEquals("redirect:/manageAdminSupAdmin", mav.getViewName());
    }

    @Test
    public void editAdmin() {
        // Simulate having errors just for this test:
        Mockito.when(bindingResultTest.hasErrors()).thenReturn(true);

        ModelAndView mav = testEmployeeC.EditAdmin(editTest,bindingResultTest);

        // Check that we returned back to the original form:
        assertEquals("redirect:/manageAdminSupAdmin", mav.getViewName());

    }

    @Test
    public void deleteAdmin() {
        // Simulate having errors just for this test:
        Mockito.when(bindingResultTest.hasErrors()).thenReturn(true);

        ModelAndView mav = testEmployeeC.DeleteAdmin(deleteTest,bindingResultTest);

        // Check that we returned back to the original form:
        assertEquals("redirect:/manageAdminSupAdmin", mav.getViewName());

    }
}