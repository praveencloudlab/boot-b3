package com.cts.ecart.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.cts.ecart.dao,com.cts.ecart.service")
@PropertySource(value = "application.properties")
public class AppConfig {

	@Autowired
	private Environment environment;

	// step1 :: data source

	@Bean
	public DataSource mysqlDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		return dataSource;
	}

	// step2 :: jdbc-template
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(mysqlDataSource());
	}
	
	// step3 :: transaction
	
	

}
