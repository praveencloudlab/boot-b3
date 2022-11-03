package com.cts.ecart.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cts.ecart.model.Product;

@Repository
public class ProductDaoLambdaImpl {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	// implement RowMapper interface with lambda expressions
	 public Product findById(int productId) {
		 String q1="select * from product where id=?";
		 return jdbcTemplate.queryForObject(q1,(rs,rowNum) -> new Product(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"),rs.getString("description")),productId);	   
	 }

	 public List<Product> findAll() {
			return jdbcTemplate.query("select * from product",(rs, rowNum) ->
	                        new Product(
	                                rs.getInt("id"),
	                                rs.getString("name"),
	                                rs.getDouble("price"),
	                                rs.getString("description")));
	 
	 }
	 
	 
	 // CRUD operationsa
	 public void save(Product product) {
		 jdbcTemplate.update("insert into product values(?,?,?,?)",product.getId(),product.getName(),product.getPrice(),product.getDescription());
		 System.out.println("Record saved to database...");
	 }
	 
	 
	 
}








