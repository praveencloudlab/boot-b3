package com.cts.ecart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PersonNameServiceImpl {

	@Autowired
	@Qualifier(value = "approved")
	private List<String> namesList;

	public List<String> getNamesList() {
		return namesList;
	}

	public void setNamesList(List<String> namesList) {
		this.namesList = namesList;
	}

}
