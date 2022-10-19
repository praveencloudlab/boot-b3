package com.cts.ecart;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.ecart.service.ProductServiceImpl;

public class AppMain {

	public static void main(String[] args) {

		System.out.println("main");

		// create spring container

		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		
		//ProductServiceImpl ps= (ProductServiceImpl) ac.getBean("ps");
		//ProductServiceImpl ps = ac.getBean("ps",ProductServiceImpl.class);
		ProductServiceImpl ps = ac.getBean(ProductServiceImpl.class);
		ps.f1();
		

	}

}
