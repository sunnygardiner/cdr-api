package com.dcs.exception;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-11-15T10:47:30.519Z[GMT]")
public class ApiException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public ApiException (int code, String msg) {
        super(msg);
    }
}
