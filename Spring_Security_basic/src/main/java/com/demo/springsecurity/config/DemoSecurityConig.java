package com.demo.springsecurity.config;

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

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// Deprecated in-memory authentication
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("john").password("test").roles("EMPLOYEE"))
			.withUser(users.username("manago").password("test").roles("EMPLOYEE","MANAGER"))
			.withUser(users.username("admin").password("test").roles("EMPLOYEE","ADMIN"));
			
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
