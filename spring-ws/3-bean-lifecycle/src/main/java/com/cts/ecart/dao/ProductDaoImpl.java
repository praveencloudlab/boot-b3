package com.cts.ecart.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy(value = true)
public class ProductDaoImpl {
	
	public ProductDaoImpl() {
		System.out.println("ProductDaoImpl object created by "+this.hashCode());
	}

}
