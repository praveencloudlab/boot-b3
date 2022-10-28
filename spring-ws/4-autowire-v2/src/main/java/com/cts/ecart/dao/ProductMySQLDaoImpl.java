package com.cts.ecart.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class ProductMySQLDaoImpl implements ProductDao {
	
	
	@Override
	public void save() {
		System.out.println("MySQL-DAO:: saving product");
	}

}
