package com.cts.ecart.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("main...");
		
		// get container using annotation based technique
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		
		
		
		
		
		

	}

}
