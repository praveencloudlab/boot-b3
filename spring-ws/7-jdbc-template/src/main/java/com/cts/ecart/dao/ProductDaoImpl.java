package com.cts.ecart.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.ecart.model.Product;

/*
 * JDBC template
 * ===================
 *  non-domain based operations : 2 types
 *  
    -> When expecting a single row
		– Use queryForMap(..)
		
	-> When expecting multiple rows
		– Use queryForList(..)
		
		
		
  domain based operations
  ------------------------------
  	1.RowMapper interface
  	2.ResultsetExtractor interface
  	3.RowCallbackHandler
  	
  	
  	1.RowMapper interface
  	-------------------------
  	- Spring provides a RowMapper interface for mapping a single row of a ResultSet to an object
	– Can be used for both single and multiple row queries
	- Best choice when each row of a ResultSet maps to domain object
	- queryForObject method to fetch single record
	- query method for multiple rows
	
	2.ResultsetExtractor interface
	---------------------------------
	- Spring provides a ResultSetExtractor interface for processing an entire ResultSet at once
	– You are responsible for iterating the ResultSet
	

		
		 
		 
		 
		 
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
	
	// fetch multiple rows using RowMapper interface
	//========================================================
	
	public List<Product> findAll() {
		 List<Product> products = jdbcTemplate.query("select * from product", new RowMapperDemo());
		return products;
	}
	
	// fetch single record
	public Product findByIdRowMapper(int id) {
		Product product = jdbcTemplate.queryForObject("select * from product where id=?", new RowMapperDemo(),id);
		return product;
	}
	
	// fetch single record
		public Optional<Product> findByIdRowMapperV1(int id) {
			Product product = jdbcTemplate.queryForObject("select * from product where id=?", new RowMapperDemo(),id);
			Optional<Product> optional = Optional.of(product);			
			return optional;
		}
		
		
		// 2.ResultsetExtractor interface :: find all (multiple records)
		
		public List<Product> findAllResultsetExtractor(){
			List<Product> products = jdbcTemplate.query("select * from product", new ResultSetExtractorDemo());
			return products;
		}
		
		
		// 2.ResultsetExtractor interface :: find by ID (single record)
		
	  
		public Product findByIdResultsetExtractor(int id) {
			Product product = jdbcTemplate.query("select * from product where id=?", new ResultSetExtractorDemoV1(),id);
			return product;
		}
		
		
		
}

class ResultSetExtractorDemoV1 implements ResultSetExtractor<Product>{
	
	@Override
	public Product extractData(ResultSet rs) throws SQLException, DataAccessException {
		Product prod=null;
		if(rs.next()) {
	    prod=new Product();
		prod.setId(rs.getInt("id"));
		prod.setName(rs.getString("name"));
		prod.setPrice(rs.getDouble("price"));
		prod.setDescription(rs.getString("description"));
		}
		return prod;
	}
	
}

class ResultSetExtractorDemo implements ResultSetExtractor<List<Product>>{
	private List<Product> prods=new ArrayList<>();
	
	@Override
	public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		while(rs.next()) {
			Product prod=new Product();
			prod.setId(rs.getInt("id"));
			prod.setName(rs.getString("name"));
			prod.setPrice(rs.getDouble("price"));
			prod.setDescription(rs.getString("description"));
			prods.add(prod);
		}
		
		return prods;
	}
	
}

class RowMapperDemo implements RowMapper<Product>{
	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product prod=new Product();
		prod.setId(rs.getInt("id"));
		prod.setName(rs.getString("name"));
		prod.setPrice(rs.getDouble("price"));
		prod.setDescription(rs.getString("description"));
		return prod;
	}
}







