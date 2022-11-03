package com.cts.ecart.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cts.ecart.entity.Product;

@Configuration
@ComponentScan(basePackages = {"com.cts.ecart.service,com.cts.ecart.dao"})
@PropertySource("application.properties")
@EnableTransactionManagement
public class AppConfig {
	
	@Autowired
	private Environment environment;
	
	// step-1 : create data source
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("db-url"));
		driverManagerDataSource.setUsername(environment.getProperty("db-user"));
		driverManagerDataSource.setPassword(environment.getProperty("db-password"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("db-driver-class"));
		return driverManagerDataSource;
	}
	
	// step-2 : create hibernate session factory
	@Bean
	public LocalSessionFactoryBean getHibernateSession() throws IOException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		Properties props = new Properties();
		props.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		props.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		props.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
		props.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		
		sessionFactory.setHibernateProperties(props);
		sessionFactory.afterPropertiesSet();
		sessionFactory.setAnnotatedClasses(Product.class);
		
		return sessionFactory;
	}

	// step-3 : create transaction manager
	
	 @Bean
	    public PlatformTransactionManager hibernateTransactionManager() throws IOException {
	        HibernateTransactionManager transactionManager
	          = new HibernateTransactionManager();
	        transactionManager.setSessionFactory(getHibernateSession().getObject());
	        return transactionManager;
	    }
	
	
	
	

}

