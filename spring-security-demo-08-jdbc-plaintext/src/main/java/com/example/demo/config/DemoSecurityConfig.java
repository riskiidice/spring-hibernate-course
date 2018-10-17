package com.example.demo.config;

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
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// use jdbc authentication ...	
		auth.jdbcAuthentication().dataSource(securityDataSource)
		  .usersByUsernameQuery(
		   "select username,password, enabled from user where username=?")
		  .authoritiesByUsernameQuery(
		   "select B.username as username, C.name as role from user_role  A"
		   + "inner join user B on A.user_id = B.id"
		   + "inner join role C on A.role_id = C.id"
		   + " where B.username=?");		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
					.antMatchers("/h2-console").permitAll()
					.antMatchers("/").hasRole("EMPLOYEE")
					.antMatchers("/leaders/**").hasRole("MANAGERS")
					.antMatchers("/systems/**").hasRole("ADMIN")				
				.and().csrf().ignoringAntMatchers("/h2-console/**")//don't apply CSRF protection to /h2-console
				.and().headers().frameOptions().sameOrigin()//allow use of frame to same origin urls
				.and()
				.formLogin()
					.loginPage("/showMyLoginPage")
					.loginProcessingUrl("/authenticateUser")
					.permitAll()
				.and()
				.logout().permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
		
	}

	
	
}
