package com.cts.ecart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.cts.ecart.service","com.cts.ecart.dao"})
public class AppConfig {

	public AppConfig() {
		System.out.println("AppConfig object created...");
	}

}
