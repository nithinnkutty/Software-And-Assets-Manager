package com.bipsync.SoftwareAndAssetsManager.Controller;



import com.bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import com.bipsync.SoftwareAndAssetsManager.form.DeleteEmployeeForm;
import com.bipsync.SoftwareAndAssetsManager.form.EditEmployeeForm;
import com.bipsync.SoftwareAndAssetsManager.repository.EmployeeRepository;
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

    private EmployeeRepository adminRepo;

    @Autowired
    public EmployeeController(EmployeeRepository pRepo) {
        adminRepo = pRepo;
    }


    @RequestMapping(path="/AdminAll", method = RequestMethod.GET)
    public ModelAndView searchAll() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("employeeAttribute",adminRepo.findAllEmployee());
        mav.setViewName("redirect:/ManageAdmin_SA");
        return mav;
    }





    //Here handles the data from the HTML page
    @RequestMapping(path="/AddAdmin", method = RequestMethod.POST)
    public ModelAndView AddAdmin(AddEmployeeForm addEmployeeForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            mav.setViewName("ManageAdmin_SA");
            //this line means sql error, cannot find data as expected//sql result is not bound.
        } else {
            if (adminRepo.AddEmployee(addEmployeeForm)) {
                System.out.println("added employee");
                mav.addObject("employeeAttribute", adminRepo.findAllEmployee());
                //here, successfully added
                mav.setViewName("redirect:/ManageAdmin_SA");
            }else{
                mav.setViewName("ManageAdmin_SA");
                //add is a boolean function, boolean rows>0 is false. this is in repository.
            }
        }
        return mav;
    }

    //Here handles the data from the HTML page
    @RequestMapping(path="/EditAdmin", method = RequestMethod.POST)
    public ModelAndView EditAdmin(EditEmployeeForm editEmployeeForm, BindingResult br) {
        System.out.println("in EditAdmin of Controller");
        ModelAndView mav = new ModelAndView();
        System.out.println(br);
        if (br.hasErrors()) {
            System.out.println("br errors");
            mav.setViewName("ManageAdmin_SA");
        } else {
            if (adminRepo.EditEmployee(editEmployeeForm)) {
                System.out.println("Edited Admin");
                mav.addObject("employeeAttribute", adminRepo.findAllEmployee());

                mav.setViewName("redirect:/ManageAdmin_SA");
            }else{
                System.out.println("added failed");
                mav.setViewName("ManageAdmin_SA");
            }
        }
        return mav;
    }

    @RequestMapping(path="/DeleteAdmin", method = RequestMethod.POST)
    public ModelAndView DeleteAdmin(DeleteEmployeeForm deleteEmployeeForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            mav.setViewName("ManageAdmin_SA");
        } else {
            if (adminRepo.DeleteEmployee(deleteEmployeeForm)) {
                mav.addObject("employeeAttribute",adminRepo.findAllEmployee());
                mav.setViewName("redirect:/ManageAdmin_SA");
            }else{
                mav.setViewName("ManageAdmin_SA");
            }
        }
        return mav;
    }


}

