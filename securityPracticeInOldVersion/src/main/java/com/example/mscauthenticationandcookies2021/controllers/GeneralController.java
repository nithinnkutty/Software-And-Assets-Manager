package com.example.mscauthenticationandcookies2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {


    @RequestMapping(path = "/")
    public String rootRedirect(String name) {
        return "home";
    }

    @RequestMapping(path = "public/home")
    public String homeStuff(String name) {
        return "home";
    }

    @RequestMapping(path = "public/aboutUs")
    public String aboutUs(String name) {
        return "aboutUs";
    }

    @RequestMapping(path = "admin/stuff")
    public String adminStuff(String name) {
        return "admin";
    }
    @RequestMapping(path = "admin/restricted")
    public String restricted(String name) {
        return "restricted";
    }

    @RequestMapping(path = "/superUser/superUser")
    public String superUser(String name) {
        return "superUser";
    }

}