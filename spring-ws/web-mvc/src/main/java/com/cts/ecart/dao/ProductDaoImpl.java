package com.cts.ecart.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.ecart.entity.Product;

@Repository
public class ProductDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	// list all products
	@Transactional
	public List<Product> findAll() {
		Session ses1 = sessionFactory.openSession();
		Query<Product> q1 = ses1.createQuery("from Product"); // HQL
		List<Product> products = q1.getResultList();
		// ses1.close();
		return products;
	}

	// find a product by id
	public Product findById(int id) {
		Session s2 = sessionFactory.openSession();
		Product product = s2.get(Product.class, id);
		if (product != null)
			return product;
		else
			return null;
	}
	
	// save new product
	public void saveProduct(Product product) {
		Session s3 = sessionFactory.openSession();
		s3.save(product);
		s3.beginTransaction().commit();
		System.out.println("DAO: saved..");
	}

}
