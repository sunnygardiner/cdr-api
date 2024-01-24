package com.dcs.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@ActiveProfiles("dev")
class InvalidInputDataExceptionTest {

	private InvalidInputDataException invalidInputDataException;

	@Test
	void constructorTest() {
		String code = "400412";
		String msg = "StartTime cannot be less than EndTime of an old Charging session";
		invalidInputDataException = new InvalidInputDataException(msg, code);
		assertNotNull(invalidInputDataException);
		assertEquals(msg, invalidInputDataException.getMessage());
		assertEquals(code, invalidInputDataException.getCode());
	}

}
