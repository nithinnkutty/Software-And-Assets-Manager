package com.bipsync.softwareandassetmanagementsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// This controller is used to map the login, general admin and super admin HTML pages onto specific URLs, aiding the
// use of security and authentication.

@Controller
public class homeController {

    @RequestMapping(path = "/")
    public String rootRedirect(String name) {
        return "login";
    }

    @RequestMapping(path = "generalAdmin/view")
    public String generalAdminView(String name) {
        return "template_generalAdmin";
    }

    @RequestMapping(path = "/superAdmin/view")
    public String superAdminView(String name) {
        return "template_superAdmin";
    }

}
