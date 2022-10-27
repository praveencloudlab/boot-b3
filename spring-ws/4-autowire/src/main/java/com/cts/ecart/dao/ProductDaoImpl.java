package com.cts.ecart.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl {
	
	
	public void save() {
		System.out.println("DAO:: saving product");
	}

}
