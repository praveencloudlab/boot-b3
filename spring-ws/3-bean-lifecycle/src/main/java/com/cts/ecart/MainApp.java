package com.cts.ecart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.ecart.config.AppConfig;
import com.cts.ecart.dao.ProductDaoImpl;
import com.cts.ecart.service.ProductServiceImpl;

public class MainApp {

	public static void main(String[] args) {

		// get container using annotation based technique

		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductServiceImpl ps1 = ac.getBean(ProductServiceImpl.class);
		ProductServiceImpl ps2 = ac.getBean(ProductServiceImpl.class);
		ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);
		
		ps1.f1();
		ps2.f1();

		ac.registerShutdownHook();

	}

}
