package com.dcs.model;

import org.junit.Test;

public class CDRecordTest {
	
	@Test
	public void testObjectMethod() {
		CDRecord cdRecord = new CDRecord();
		cdRecord.equals(new CDRecord());
		cdRecord.hashCode();
		cdRecord.toString();
	}
	
	 @Test
	    public void testAll() {
		 CDRecord object = new CDRecord();
	        object.equals(CDRecord.class);
	    }

}
