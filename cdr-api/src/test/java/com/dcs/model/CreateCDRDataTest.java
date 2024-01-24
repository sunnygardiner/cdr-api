package com.dcs.model;

import org.junit.Test;

public class CreateCDRDataTest {

	
	@Test
	public void testObjectMethod() {
		CreateCDRData createCDRData = new CreateCDRData();
		createCDRData.equals(new CreateCDRData());
		createCDRData.hashCode();
		createCDRData.toString();
	}
	
	 @Test
	    public void testAll() {
		 CreateCDRData object = new CreateCDRData();
	        object.equals(CreateCDRData.class);
	    }

}
