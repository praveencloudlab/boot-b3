package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.ecart.dao.ProductDaoImpl;

@Service
public class ProductServiceImpl {
	
	@Autowired
	private ProductDaoImpl prodDao;


	public void saveProduct() {
		System.out.println("SERVICE:: saving product..");
		prodDao.save();
	}

}
