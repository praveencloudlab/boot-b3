package com.cts.ecart;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.ecart.config.AppConfig;

public class MainApp {

	public static void main(String[] args) {

		// get container using annotation based technique
		System.out.println(">> main ");

		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	  	AppConfig app = ac.getBean(AppConfig.class);
		app.test();
		app.f3();
		app.f4();
		app.f44();
		
		//ProductServiceImpl ps1 = ac.getBean(ProductServiceImpl.class);
		//ProductServiceImpl ps2 = ac.getBean(ProductServiceImpl.class);
		//ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);
		
		//ps1.f1();
		//ps2.f1();

		//ac.registerShutdownHook();

	}

}
