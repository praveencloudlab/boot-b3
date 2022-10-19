package com;

//dependent
public class BillingImpl {
	
	/*
	 * ====================
	 * design issues
	 * ====================
	 * 
	 * -> too many dependency objects creation.
	 * 		-> performance goes down
	 * 		-> issues with memory management
	 * 
	 *  why this issue happened?
	 *  ----------------------------
	 *  -> dependent class itself creating dependency class object.
	 *  
	 *  what is the solution?
	 *  ------------------------
	 *  -> don't create dependency object in the dependent class directly
	 *  -> instead, use look up techniques like JNDI .. etc
	 *  -> JNDI location is tightly coupled with dependent class object
	 *  
	 *  what is the best solution?
	 *  -------------------------------
	 *  -> do not create, or do not look up. Instead ask some one to pass /inject (container):  IoC (inversion of controller)
	 *  
	 *  how to implement IoC?
	 *  ------------------------
	 *  -> IoC can be implemented using dependency injection technique
	 *  
	 *  what is dependency injection (DI)?
	 *  ------------------------------------
	 *  -> injecting dependency object to the dependent object is called DI
	 *  
	 *   how to implement DI? : 2 ways
	 *   ---------------------------------
	 *   1.setter based DI
	 *   2.constructor based DI
	 *   
	 *   1.Setter based DI
	 *   =====================
	 *   rules
	 *   -----
	 *   1.create dependency class reference at class level
	 *   2.create setter for above defined reference
	 *   
	 *   
	 *  
	 *  
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	private PriceMatrixImpl price;
	

	public void setPrice(PriceMatrixImpl price) {
		this.price = price;
	}



	public double getCartTotal(String[] cart) {

		double total = 0.0;

		//PriceMatrixImpl price = new PriceMatrixImpl();// dependency

		for (String itemCode : cart) {
			total = total + price.getItemPrice(itemCode);
		}
		return total;

	}

}
