package com;

//dependency
public class PriceMatrixImpl {
	
	public PriceMatrixImpl() {
		System.out.println(">>> PriceMatrixImpl object created..");
	}
	
	/*
	 * types of objects: 2 types
	 * ==============================
	 * 1.dependency: works
	 * independently. never depends on any other objects 2.dependent: always depends
	 * on dependency objects
	 */

	public double getItemPrice(String itemCode) {
		// code to connect to DB and fetch price for given item-code
		return 100.00;
	}

}
