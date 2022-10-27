package com.cts.ecart.config;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = { "com.cts.ecart.service", "com.cts.ecart.dao" })
@Scope("prototype")
@Lazy(value = false)
public class AppConfig {

	/*
	 * Spring life cycle methods =================================== 
	 * 1.constructor
	 * 2.post construct 
	 * 3.bean 
	 * 4.predestroy
	 */

	
	public AppConfig() {
		System.out.println("1.AppConfig object created by "+this.hashCode());
	}
	

	public void test() {
		System.out.println(">>>>>>> test by "+this.hashCode());
	}

	
	@PostConstruct
	public void f1() {
		System.out.println("2.post construct :: f1 method by "+this.hashCode());
	}

	@PostConstruct
	public void f2() {
		System.out.println("2.post construct :: f2 method by"+this.hashCode());
	}

	@Bean
	public void f3() {
		System.out.println("3.bean :: f3 method by "+this.hashCode());
	}

	@Bean
	public void f4() {
		System.out.println("3.bean :: f4 method by"+this.hashCode());
	}
	
	@Bean
	public void f44() {
		System.out.println("3.bean :: f44 method by"+this.hashCode());
	}

	@PreDestroy
	public void f5() {
		System.out.println("4.pre-destroy :: f5 method for "+this.hashCode());
	}
	

}
