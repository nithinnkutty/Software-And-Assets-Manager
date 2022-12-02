package com.bipsync.softwareandassetmanagementsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GeneralController {

    @RequestMapping(path="/homeSuperAdmin")
    public ModelAndView homePage(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("homeSuperAdmin");
        return mav;
    }
}
