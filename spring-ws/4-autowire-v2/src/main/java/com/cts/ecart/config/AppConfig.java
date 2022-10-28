package com.cts.ecart.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = { "com.cts.ecart.service", "com.cts.ecart.dao" })
@PropertySource(value = {"abc.properties"})
public class AppConfig {
	
	//@Value("${name}") // spEL
	//private String personName;

	@Autowired
	private Environment env;
	
	
	public AppConfig() {
		System.out.println("AppConfig object created...");
	}
	
	@Bean
	public void f1() {
		System.out.println("name is "+env.getProperty("name"));
	}

	@Bean(name = "rejected")
	public List<String> nameList() {
		List<String> names = new ArrayList<>();
		names.add("Abc");
		names.add("John");
		names.add("Adam");
		names.add("Harry");
		return names;
	}
	
	@Bean(name = "approved")
	public List<String> approvedList() {
		List<String> names = new ArrayList<>();
		names.add("Kavitha");
		names.add("Saravanan");
		names.add("Sangeetha");
		names.add("Swetha");
		return names;
	}
	
	
	
	

}
