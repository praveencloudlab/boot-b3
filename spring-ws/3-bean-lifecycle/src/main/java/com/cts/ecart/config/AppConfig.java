package com.cts.ecart.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.cts.ecart.service", "com.cts.ecart.dao" })
public class AppConfig {

	/*
	 * Spring life cycle methods =================================== 
	 * 1.constructor
	 * 2.post construct 
	 * 3.bean 
	 * 4.predestroy
	 */

	/*
	public AppConfig() {
		System.out.println("1.AppConfig object created..");
	}
	
	*/

	/*
	@PostConstruct
	public void f1() {
		System.out.println("2.post construct :: f1 method");
	}

	@PostConstruct
	public void f2() {
		System.out.println("2.post construct :: f2 method");
	}

	@Bean
	public void f3() {
		System.out.println("3.bean :: f3 method");
	}

	@Bean
	public void f4() {
		System.out.println("3.bean :: f4 method");
	}

	@PreDestroy
	public void f5() {
		System.out.println("4.pre-destroy :: f5 method");
	}
	*/

}
