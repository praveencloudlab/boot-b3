package com.cts.ecart.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class ProductOracleDaoImpl implements ProductDao {
	
	
	@Override
	public void save() {
		System.out.println("ORACLE-DAO:: saving product");
	}

}
