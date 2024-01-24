package com.dcs.exception;



import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@ActiveProfiles("dev")
class InputRequestParameterMissingTest {

	@Test
	void constructorTest() {
		String msg = "Vehicle Id is missing in the Request.";
		InputRequestParameterMissing inReqParMis = new InputRequestParameterMissing(msg, "400411");
		assertNotNull(inReqParMis);
		assertEquals(msg, inReqParMis.getMessage());
	}
}
