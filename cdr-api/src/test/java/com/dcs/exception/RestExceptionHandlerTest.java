package com.dcs.exception;




import org.hibernate.JDBCException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MapBindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;

import com.dcs.model.Error;

import java.lang.reflect.Executable;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ActiveProfiles("dev")
class RestExceptionHandlerTest {

	private RestExceptionHandler restExceptionHandler;
	private InputRequestParameterMissing irpex;
	private InvalidInputDataException invalDataEx;
	
	@Mock
	InvalidInputDataException invalidInputDataException;

	private MissingServletRequestParameterException missingServletRequestParameterException;

	@BeforeEach
	void setup() {

		restExceptionHandler = new RestExceptionHandler();
		irpex = new InputRequestParameterMissing("Input parameter is missing", "400411");
		invalDataEx = new InvalidInputDataException("Invalid input data", "400412");
		
		missingServletRequestParameterException = new MissingServletRequestParameterException("Test1", "String");
	}




	@Test
	void testHandleMissingParams() {

		ResponseEntity<Error> respEntity = restExceptionHandler.handleMissingParams(irpex);
		assertNotNull(respEntity);
		assertEquals(HttpStatus.BAD_REQUEST, respEntity.getStatusCode());
		assertEquals("400411", Objects.requireNonNull(respEntity.getBody()).getCode());
	}

	@Test
	void testHandleInvalidInputData() {
		ResponseEntity<Object> respEntity = restExceptionHandler.handleInvalidInputData(null,
				invalidInputDataException);
		assertNotNull(respEntity);
		assertEquals(HttpStatus.BAD_REQUEST, respEntity.getStatusCode());
	}
	

}
