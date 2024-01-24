
package com.dcs.service;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;

import com.dcs.api.ChargeDetailsApiController;
import com.dcs.exception.ApiException;
import com.dcs.exception.InputRequestParameterMissing;
import com.dcs.exception.InvalidInputDataException;
import com.dcs.mapper.ChargingDetailsRecordMapperImpl;
import com.dcs.model.CDRecord;
import com.dcs.model.CreateCDRData;
import com.dcs.repository.CDRecordRepository;

@SpringBootTest
//@WebMvcTest(ChargingDetailsRegisterService.class)
//@ActiveProfiles("dev")
public class ChargingDetailsRegisterServiceTest {

	
	@Autowired
	Environment env;

	@MockBean
	ChargingDetailsRecordMapperImpl chargingDetailsRecordMapperImpl;

	@MockBean
	ChargingDetailsRegisterService cdChargingDetailsRegisterService;
	
	@MockBean
	CDRecordRepository cDRecordRepository;

	@SuppressWarnings("unchecked")

	 @Test
	public void testCreateCDRRecord() throws InputRequestParameterMissing, InvalidInputDataException, ApiException {

		CreateCDRData createCDRData = new CreateCDRData();

		long millis = System.currentTimeMillis();

		java.util.Date date = new java.util.Date(millis);

		createCDRData.setStartTime(date);
		createCDRData.setEndTime(date);

		createCDRData.setVehicleId("233");
		createCDRData.setTotalCost(23.33);

/*		
		Mockito.when(chargingDetailsRecordMapperImpl.mapToCDRecord(Mockito.any(), Mockito.any())).thenReturn(cdRecord);

		cdChargingDetailsRegisterService.createCDRRequest(createCDRData);

		verify(cdChargingDetailsRegisterService, times(1)).createCDRRequest(createCDRData);
*/
		
		
		assertThrows(Exception.class, () -> {
	            new ChargingDetailsRegisterService().createCDRRequest(createCDRData);
	        });
		
	}

}
