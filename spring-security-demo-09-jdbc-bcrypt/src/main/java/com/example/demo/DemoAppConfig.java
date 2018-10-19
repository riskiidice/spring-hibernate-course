package com.example.demo;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DemoAppConfig {

	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource securityDataSource
		 = new ComboPooledDataSource();
		
		try {
			securityDataSource.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		} catch (PropertyVetoException e) {
				throw new RuntimeException(e);
		}
		
		logger.info(">>jdbc url : "+env.getProperty("spring.datasource.url"));
		logger.info(">>jdbc username : "+env.getProperty("spring.datasource.username"));
		
		securityDataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
		securityDataSource.setUser(env.getProperty("spring.datasource.username"));
		securityDataSource.setPassword(env.getProperty("spring.datasource.password"));
		return securityDataSource;
	}
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		int intPropVal =  Integer.parseInt(propVal);
		
		return intPropVal;
	}
}
