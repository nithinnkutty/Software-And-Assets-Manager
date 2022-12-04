package com.bipsync.SoftwareAndAssetsManager.Controller;

import com.bipsync.SoftwareAndAssetsManager.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GeneralController {
    private AdminRepository adminRepo;

    @Autowired
    public GeneralController(AdminRepository pRepo) {
        adminRepo = pRepo;
    }
/**
     * This is controller for all the pages
     */
    /*
    Navigating to home
     */

//Do not use it when the setviewname is not underlined!!!!!!

//    /*
//        Navigating to Add Admin
//         */
//    @RequestMapping(path="/Site/AddEmployee", method = RequestMethod.GET)
//    public ModelAndView addEmployee(){
//        ModelAndView mav = new ModelAndView();
//        mav.setViewName("AddEmployeeForm");
//        return mav;
//    }

    /*
       Assign this address to Sample page
        */
    @RequestMapping(path="/ManageAdmin_SA", method = RequestMethod.GET)
    public ModelAndView ManageAdmin_SA(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("adminAttribute",adminRepo.findAllAdmin());
        mav.setViewName("ManageAdmin_SA");
        return mav;
    }

}
