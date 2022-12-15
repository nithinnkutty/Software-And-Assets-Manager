package com.Bipsync.SoftwareAndAssetsManager.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// This controller is used to handle GET requests from which one can receive the post of the login form.

@Controller
@RequestMapping("/")
public class templateController {

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

//    @RequestMapping("/success")
//    public void loginPageRedirect(HttpServletRequest request, HttpServletResponse response, Authentication authResult) throws IOException, ServletException, IOException {
//
//        String role =  authResult.getAuthorities().toString();
//
//        if(role.contains("GENERALADMIN")){
//            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/assetsSummaryGenAdmin"));
//        }
//        else if(role.contains("SUPERADMIN")) {
//            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/assetsSummarySupAdmin"));
//        }
//    }

}
