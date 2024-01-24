package com.dcs.model;

import org.junit.Test;

public class ErrorTest {

	
	@Test
	public void testObjectMethod() {
		Error error = new Error();
		error.equals(new Error());
		error.hashCode();
		error.toString();
	}
	
	 @Test
	    public void testAll() {
		 Error object = new Error();
	        object.equals(Error.class);
	    }
}
