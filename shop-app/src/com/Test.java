package com;

public class Test {

	public static void main(String[] args) {

		String[] cart1 = { "P01", "P02", "P03" };
		String[] cart2 = { "P01", "P02"};
		
		//================================================
		PriceMatrixImpl price=new PriceMatrixImpl(); // dependency object
		//================================================

		BillingImpl biller = new BillingImpl(); // dependent object
		
		biller.setPrice(price); // injecting/passing dependency object (price) to the dependent object (biller) is called DI
		
		double total = biller.getCartTotal(cart1);
		System.out.println("Cart1 total is " + total);
		
		total=biller.getCartTotal(cart2);
		System.out.println("Cart2 total is " + total);

		

	}

}
