package com.dcs.exception;


public class InvalidInputDataException extends Exception{

     /**
	 * 
	 */
	private static final long serialVersionUID = 6183768377889265614L;

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	/**
	 * 
	 */
	
	
	private String code;

	public InvalidInputDataException(final String msg,final String code) {
       super(msg);
       this.code=code;
    
    }

}
