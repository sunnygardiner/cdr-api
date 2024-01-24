package com.dcs.exception;

public class InputRequestParameterMissing extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5739728401006328408L;

	
	private String code;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public InputRequestParameterMissing(String msg, final String code) {
		super(msg);
		this.code = code;

	}
}
