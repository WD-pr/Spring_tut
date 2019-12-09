package com.demo.springsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// JDBC authentication based on BCrypt algorithm - https://bcryptcalculator.com/
		
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	/* Configuring security web paths, login, logout support ... */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				//.anyRequest().authenticated() - for authorizing any request
			.antMatchers("/").permitAll() // - public access
			.antMatchers("/home/**").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER") // - access for managers only
			.antMatchers("/systems/**").hasRole("ADMIN")
			.and()
			.formLogin()
				.loginPage("/loginPage")
				.loginProcessingUrl("/authenticateUser")
				.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/")
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied") //Custom access denied page
			;
	
	}
	
	

}
