package com.example.mscauthenticationandcookies2021;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .mvcMatchers("public/login").permitAll()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/public/**").authenticated()
                .mvcMatchers("/admin/**").authenticated()
                .mvcMatchers("/superAdmin/**").hasRole("SA")
                .anyRequest().denyAll()
                .and()
                .formLogin();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("generaladmin@admin").password("{noop}password").roles("ADMIN");
        auth
                .inMemoryAuthentication()
                .withUser("superadmin@admin").password("{noop}su").roles("SA");
    }
}