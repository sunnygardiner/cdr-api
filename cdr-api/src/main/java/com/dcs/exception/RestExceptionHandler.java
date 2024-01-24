package com.dcs.exception;


import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.hibernate.JDBCException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.dcs.model.Error;
import com.fasterxml.jackson.databind.JsonMappingException.Reference;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String CONTENT_TYPE = "Content-Type";

	private static final String JSON = "application/json;charset=utf-8";

	

	

	@ExceptionHandler(JDBCException.class)
	public ResponseEntity<Error> handleDatabaseExceptions(JDBCException ex) {

		Error error = new Error();
		error.setCode("32050021");
		error.setReason("DB/SQL exception - " + ex.getMessage() + " : " + ex.getSQLException());

		// Actual exception handling
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(InputRequestParameterMissing.class)
	public ResponseEntity<Error> handleMissingParams(InputRequestParameterMissing ex) {

		Error error = new Error();
		error.setCode(ex.getCode());
		error.setReason(ex.getMessage());
		// Actual exception handling
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

	

	@ExceptionHandler({ InvalidInputDataException.class })
	protected ResponseEntity<Object> handleInvalidInputData(WebRequest request, InvalidInputDataException ex) {
		final HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add(CONTENT_TYPE, JSON);
		Error error = new Error();
		error.setCode(ex.getCode());
		error.setReason(ex.getMessage());

		return new ResponseEntity<>(error, responseHeaders, HttpStatus.BAD_REQUEST);
	}

	
}
