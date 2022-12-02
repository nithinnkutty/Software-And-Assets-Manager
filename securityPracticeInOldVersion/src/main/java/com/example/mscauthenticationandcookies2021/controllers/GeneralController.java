package com.example.mscauthenticationandcookies2021.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GeneralController {


    @RequestMapping(path = "/")
    public String rootRedirect(String name) {
        return "loginNew";
    }

    @RequestMapping(path = "public/login")
    public String loginStuff(String name) {
        return "loginNew";
    }

    @RequestMapping(path = "admin/view")
    public String generalAdminView(String name) {
        return "adminViewNew";
    }

    @RequestMapping(path = "/superAdmin/view")
    public String superAdminView(String name) {
        return "superAdminViewNew";
    }


}