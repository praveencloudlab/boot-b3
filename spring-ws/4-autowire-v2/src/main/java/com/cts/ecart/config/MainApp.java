package com.cts.ecart.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.ecart.dao.ProductMySQLDaoImpl;
import com.cts.ecart.service.PersonNameServiceImpl;
import com.cts.ecart.service.ProductService;
import com.cts.ecart.service.ProductServiceImpl;

public class MainApp {

	public static void main(String[] args) {

		System.out.println("main...");

		// get container using annotation based technique

		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		// ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);

		// ProductService ps = ac.getBean(ProductServiceImpl.class);
		PersonNameServiceImpl ps = ac.getBean(PersonNameServiceImpl.class);
		// ps.printNamesList();

		ps.getNamesList().forEach(System.out::println);

		// add new data to the collection
		ps.getNamesList().add("Praveen");
		ps.getNamesList().add("Bucky Wall");

		System.out.println("-----------------------------");

		ps.getNamesList().forEach(System.out::println);

		// ps.setProdDao(prodDao); // DI

		// ps.saveProduct();

	}

}
