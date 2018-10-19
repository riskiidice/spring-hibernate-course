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
		   "select user.username as username, role.name as role from user"
		   + " inner join user_role on user_role.user_id = user.id"
		   + " inner join role on role.id = user_role.role_id"
		   + " where user.username=?");		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
					.antMatchers("/h2-console").permitAll()
					.antMatchers("/").hasRole("EMPLOYEE")
					.antMatchers("/leaders/**").hasRole("MANAGER")
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
