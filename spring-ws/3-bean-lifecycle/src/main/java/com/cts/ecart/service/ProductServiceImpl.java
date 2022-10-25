package com.cts.ecart.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

//@Component
@Service
//@Repository
//@Controller
//@Configuration

//@Scope("singleton")
//@Scope("prototype")
public class ProductServiceImpl {

	public ProductServiceImpl() {
		System.out.println("ProductServiceImpl object created by "+this.hashCode());
	}

	
	public void f1() {
		System.out.println("ProductServiceImpl :: f1 method by "+this.hashCode());
	}

}
