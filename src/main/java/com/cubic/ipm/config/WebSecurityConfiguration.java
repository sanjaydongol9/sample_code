/**
 * Copyright 2016 (C) Cubic Technologies LLC
 * All Rights Reserved
 * @author Sanjay Dongol
 */

package com.cubic.ipm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService customUserDetailsService;
	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//Admin Section 
		http.authorizeRequests().antMatchers("/masteradmin/**").access("hasRole('ROLE_MASTERADMIN')")
	    .antMatchers("/admin/**").access("hasAnyRole('ROLE_MASTERADMIN','ROLE_ADMIN')")
		//Marketing Section
		.antMatchers("/marketer/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_MASTERADMIN','ROLE_MARKETING')")
		// Vendor Call Taker Section
		.antMatchers("/vc/**").access("hasAnyRole('ROLE_ADMIN','ROLE_MASTERADMIN','ROLE_VC')")
		.antMatchers("/bchecker/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_MASTERADMIN','ROLE_BCHECKER')")
		//.antMatchers("/admin/get-technology").permitAll()
		.and()
		//Form Login Section 
		.formLogin().loginPage("/login").loginProcessingUrl("/postLogin")
		.usernameParameter("username").passwordParameter("password") 
		.defaultSuccessUrl("/welcome", true).failureUrl("/loginfailed")
		.and()
		//Logout Section 
		.logout().logoutSuccessUrl("/logout").logoutUrl("/doLogout")
		.and().csrf().disable()
		.exceptionHandling().accessDeniedPage("/error-forbidden");
	}
	
	/* Password Encryptor Using Bcrypt Algo, Level-> 7 */ 
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
