package com.cts.ecart.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.ecart.dao.ProductDaoImpl;
import com.cts.ecart.service.ProductServiceImpl;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("main...");
		
		// get container using annotation based technique
		
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		
	//	ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);
		
		ProductServiceImpl ps = ac.getBean(ProductServiceImpl.class);
		
		//ps.setProdDao(prodDao); // DI
		
		ps.saveProduct();
		
		
		
		

	}

}
