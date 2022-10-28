package com.cts.ecart.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/*
 * JDBC template
 * ===================
 *  non-domain based operations : 2 types
 *  
    -> When expecting a single row
		– Use queryForMap(..)
		
	-> When expecting multiple rows
		– Use queryForList(..)
 * 
 * 
 * 
 * 
 */


@Repository
public class ProductDaoImpl {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Map<String, Object>> findAllProducts() {
		List<Map<String, Object>> products = jdbcTemplate.queryForList("select * from product");
		return products;
	}
	
	
	public Map<String, Object> findById(int id){
		Map<String, Object> product = jdbcTemplate.queryForMap("select * from product where id=?",id);
		return product;
	}
	
	
	
	
	
	
	
	
	
	
	

}
