package com.bipsync.softwareandassetmanagementsystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// This controller is used to handle GET requests from which one can receive the post of the login form.

@Controller
@RequestMapping("/")
public class templateController {

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

}
