package com.cts.ecart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.ecart.config.AppConfig;
import com.cts.ecart.dao.ProductDaoImpl;
import com.cts.ecart.entity.Product;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ac=new AnnotationConfigApplicationContext(AppConfig.class);
		ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);
		
		//prodDao.findAll().forEach(System.out::println);
		//Product product = prodDao.findById(39);
		//System.out.println(product);
		
		prodDao.saveProduct(new Product("Monitor", 45000, "Dell Wireless"));
	}

}
