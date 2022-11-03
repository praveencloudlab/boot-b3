package com.cts.ecart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cts.ecart.dao.ProductDaoImpl;

@Controller
public class ProductController {
	
	@Autowired
	private ProductDaoImpl prodDao;
	
	@RequestMapping(value = "/s1")
	public String f1(Model model) {
		System.out.println(">>>>>> ProductController f1 method  <<<<<<<");
		model.addAttribute("user", "Praveen");
		model.addAttribute("products", prodDao.findAll());
		
		return "one";
	}

}
