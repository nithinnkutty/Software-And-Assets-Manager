//package com.Bipsync.SoftwareAndAssetsManager.Configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//
//// This configuration file allows us to hard code user details into the memory for use (will later be replaced when we
//// move to using JPA or JDBC authentication) and then authenticate the login of an admin or superadmin to access different
//// content with a custom made login page. Also added logout configuration to each template.
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    // Defining roles and details in this Bean.
//
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//        UserDetails generalAdmin = User.withDefaultPasswordEncoder()
//                .username("generaladmin@cardiff")
//                .password("password1")
//                .roles("GENERALADMIN")
//                .build();
//
//        UserDetails superAdmin = User.withDefaultPasswordEncoder()
//                .username("superadmin@cardiff")
//                .password("password2")
//                .roles("SUPERADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(generalAdmin,superAdmin);
//    }
//
//    // Defining the privileges here for each role and enforcing authentication through a custom login page
////
////    @Bean
////    public DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception {
////        http
////                .csrf().disable()
////                .authorizeRequests()
////                .mvcMatchers("/").permitAll()
////                .mvcMatchers("/generalAdmin/**").hasRole("GENERALADMIN")
////                .mvcMatchers("/superAdmin/**").hasRole("SUPERADMIN")
////                .anyRequest().authenticated()
////                .and()
////                .formLogin()
////                .loginPage("/login").permitAll()
////                .failureUrl("/login")
////                .defaultSuccessUrl("/success",true)
////                .and()
////                .logout(logout -> logout
////                        .logoutUrl("/logout")
////                        .logoutSuccessUrl("/login")
////                        .invalidateHttpSession(true)
////                )
////                .httpBasic();
////        return http.build();
////    }
//}
