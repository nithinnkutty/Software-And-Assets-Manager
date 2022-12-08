package com.Bipsync.SoftwareAndAssetsManager.Controller;


import com.Bipsync.SoftwareAndAssetsManager.form.AddEmployeeForm;
import com.Bipsync.SoftwareAndAssetsManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/*
This is the controller connecting repos..
 */
@Controller
public class EmployeeController {

    private EmployeeRepository employeeRepo;

    @Autowired
    public EmployeeController(EmployeeRepository pRepo) {
        employeeRepo = pRepo;
    }


    @RequestMapping(path="/Employee", method = RequestMethod.GET)
    // path="/Employee" calls the method "/Employee/" using GET,this method is from the HTML file
    //if a form in the html is called, this method will be invoked
    public ModelAndView search(@RequestParam(value="surname", defaultValue="null") String surnameString) {
        //ModelAndView is a holder for both Model and View in the web MVC framework
        //make it possible for a controller to return both model and view in a single return value.
        ModelAndView mav = new ModelAndView();
        mav.addObject(employeeRepo.findEmployeeByName(surnameString));
        //Result find, and set the result in the following html
        //Each result return to a different html, and assigned to different address.
        mav.setViewName("EmployeeDetails");

        return mav;
    }

    //different from the previous one, this mapping calls for a POST method
    @RequestMapping(path="/Employee", method = RequestMethod.POST)
    public ModelAndView addEmployee(AddEmployeeForm addEmployeeForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            mav.setViewName("Main");
        } else {
            if (employeeRepo.addEmployee(addEmployeeForm)) {
                System.out.println("added student");
                mav.addObject("employees", employeeRepo.findAllEmployee());
                mav.setViewName("AllEmployeeDetails");
            }else{
                mav.setViewName("Main");
            }
        }
        return mav;
    }

    @RequestMapping(path="/EmployeeAll", method = RequestMethod.GET)
    public ModelAndView search() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("employees",employeeRepo.findAllEmployee());
        mav.setViewName("AllEmployeeDetails");
        return mav;
    }



    //Here handles the data from the HTML page
    @RequestMapping(path="/Sample", method = RequestMethod.POST)
    public ModelAndView SampleFunction(AddEmployeeForm addEmployeeForm, BindingResult br) {
        ModelAndView mav = new ModelAndView();
        //if add error the lead the user back to the home page
        if (br.hasErrors()) {
            mav.setViewName("Main");
        } else {
            if (employeeRepo.SampleFunction(addEmployeeForm)) {
                System.out.println("added employee");
                mav.addObject("sampleAttribute", employeeRepo.findAllEmployee());

                mav.setViewName("Sample");
            }else{
                mav.setViewName("Main");
            }
        }
        return mav;
    }


}

