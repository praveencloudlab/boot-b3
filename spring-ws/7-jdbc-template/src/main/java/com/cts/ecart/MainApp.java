package com.cts.ecart;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.ecart.config.AppConfig;
import com.cts.ecart.dao.ProductDaoImpl;
import com.cts.ecart.dao.ProductDaoLambdaImpl;
import com.cts.ecart.model.Product;

public class MainApp {

	public static void main(String[] args) {


		ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductDaoImpl prodDao = ac.getBean(ProductDaoImpl.class);
		ProductDaoLambdaImpl prodDaoV1 = ac.getBean(ProductDaoLambdaImpl.class);

		//prodDao.findAllProducts().forEach(System.out::println);
		
		//Map<String, Object> product = prodDao.findById(38);
		//System.out.println(product);
		
		
		//prodDao.findAll().forEach(System.out::println);
		
		/*
		Product product = prodDao.findByIdRowMapper(380);
		if(product!=null) {
			System.out.println(product);
		}else {
			System.out.println("No record found");
		}
		*/
		
		/*
		Product product = prodDao.findByIdRowMapperV1(37).orElseThrow(()->new NoSuchRecordFoundException("Provided product Id not found in database."));
		
		if(product!=null) {
			System.out.println(product);
		}else {
			System.out.println("No record found");
		}
		*/
		
		
		//prodDao.findAllResultsetExtractor().forEach(System.out::println);
		
		/*
		Product product = prodDao.findByIdResultsetExtractor(307);
		if(product!=null) {
			System.out.println(product);
		}else {
			System.out.println("No record found");
		}
		*/
		
		prodDaoV1.save(new Product(41, "IPAD", 85000, "M2 IPAD"));
		
		prodDaoV1.findAll().forEach(System.out::println);
		

	}

}
