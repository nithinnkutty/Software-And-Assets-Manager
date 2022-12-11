package com.Bipsync.SoftwareAndAssetsManager.Controller;



import com.Bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.form.DeleteEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.form.EditEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/*
This is the controller connecting repos..
 */
@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository pRepo) {
        employeeRepository = pRepo;
    }


    @RequestMapping(path="/AdminAll", method = RequestMethod.GET)
    public ModelAndView searchAll() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("employeeAttribute",employeeRepository.findAllEmployee());
        mav.setViewName("redirect:/manageAdminSupAdmin");
        return mav;
    }





    //Here handles the data from the HTML page
    @RequestMapping(path="/AddAdmin", method = RequestMethod.POST)
    public ModelAndView AddAdmin(AddEmployeeForm addEmployeeForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            mav.setViewName("redirect:/manageAdminSupAdmin");
            //this line means sql error, cannot find data as expected//sql result is not bound.
        } else {
            if (employeeRepository.AddEmployee(addEmployeeForm)) {
                System.out.println("added employee");
                mav.addObject("employeeAttribute", employeeRepository.findAllEmployee());
                //here, successfully added
                mav.setViewName("redirect:/manageAdminSupAdmin");
            }else{
                mav.setViewName("redirect:/manageAdminSupAdmin");
                //add is a boolean function, boolean rows>0 is false. this is in repository.
            }
        }
        return mav;
    }

    //Here handles the data from the HTML page
    @RequestMapping(path="/EditAdmin", method = RequestMethod.POST)
    public ModelAndView EditAdmin(EditEmployeeForm editEmployeeForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        System.out.println(br);
        if (br.hasErrors()) {
            System.out.println("br errors");
            mav.setViewName("redirect:/manageAdminSupAdmin");
        } else {
            if (employeeRepository.EditEmployee(editEmployeeForm)) {
                System.out.println("Edited Admin");
                mav.addObject("employeeAttribute", employeeRepository.findAllEmployee());

                mav.setViewName("redirect:/manageAdminSupAdmin");
            }else{
                System.out.println("added failed");
                mav.setViewName("redirect:/manageAdminSupAdmin");
            }
        }
        return mav;
    }

    @RequestMapping(path="/DeleteAdmin", method = RequestMethod.POST)
    public ModelAndView DeleteAdmin(DeleteEmployeeForm deleteEmployeeForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            System.out.println("br error delete:" + br.hasErrors() +br.getAllErrors());
            mav.setViewName("redirect:/manageAdminSupAdmin");
        } else {
            if (employeeRepository.DeleteEmployee(deleteEmployeeForm)) {
                mav.addObject("employeeAttribute",employeeRepository.findAllEmployee());
                mav.setViewName("redirect:/manageAdminSupAdmin");
            }else{
                mav.setViewName("redirect:/manageAdminSupAdmin");
            }
        }
        return mav;
    }


}

