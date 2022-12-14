package com.Bipsync.SoftwareAndAssetsManager.Configuration;

import com.Bipsync.SoftwareAndAssetsManager.Configuration.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(new PasswordEnconderTest())
			.usersByUsernameQuery("select username,password,'true' as enabled from employees where username = ?")
			.authoritiesByUsernameQuery("select username, authority from employees where username=?")
			;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/assetsSummarySupAdmin").hasAuthority("Super")
				.antMatchers("/assetsSummaryGenAdmin").hasAuthority("General")
				//.antMatchers("/").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().successHandler(new CustomAuthenticationSuccessHandler())
				.loginPage("/login").permitAll()
				.and()
				.logout(logout -> logout
						.logoutUrl("/logout")
						.logoutSuccessUrl("/login")
						.invalidateHttpSession(true)
				)
				.exceptionHandling().accessDeniedPage("/403")
		;
		http.csrf().disable();
	}
	
	
	
}
