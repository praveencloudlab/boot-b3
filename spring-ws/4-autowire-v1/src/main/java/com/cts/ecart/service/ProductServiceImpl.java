package com.cts.ecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cts.ecart.dao.ProductDao;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productMySQLDaoImpl") // bean id of ProductOracleDaoImpl class
	private ProductDao prodDao;

	@Override
	public void saveProduct() {
		System.out.println("SERVICE:: saving product..");
		prodDao.save();
	}

}
