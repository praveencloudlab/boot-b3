package com.cts.ecart;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.ecart.config.AppConfig;
import com.cts.ecart.dao.ProductDaoImpl;

public class MainApp {

	public static void main(String[] args) {

		System.out.println(">> main");

		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);

		//prodDao.findAllProducts().forEach(System.out::println);
		
		Map<String, Object> product = prodDao.findById(38);
		System.out.println(product);

	}

}
