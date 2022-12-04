package com.bipsync.SoftwareAndAssetsManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GeneralController {
    /**
     * This is controller for all the pages
     */
    /*
    Navigating to home
     */

//Do not use it when the setviewname is not underlined!!!!!!

    /*
        Navigating to Search
         */
    @RequestMapping(path = "/homeSuperAdmin")
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("allAssetsSupAdmin");
        return mav;
    }

    @RequestMapping(path = "/Site/EmployeeSearch", method = RequestMethod.GET)
    public ModelAndView studentSearch() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("EmployeeSearchForm");
        return mav;
    }

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
    @RequestMapping(path = "/Site/Sample", method = RequestMethod.GET)
    public ModelAndView SampleFunction() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("Sample");
        return mav;
    }

}
