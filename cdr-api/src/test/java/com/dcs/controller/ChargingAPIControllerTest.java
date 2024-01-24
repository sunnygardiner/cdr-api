package com.dcs.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dcs.api.ChargeDetailsApiController;
import com.dcs.model.CDRecord;
import com.dcs.model.CreateCDRData;
import com.dcs.repository.CDRecordRepository;
import com.dcs.service.ChargingDetailsRegisterService;
import com.fasterxml.jackson.databind.ObjectMapper;

//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(ChargeDetailsApiController.class)
//@ActiveProfiles("dev")
public class ChargingAPIControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@InjectMocks
	ChargeDetailsApiController cdChargeDetailsApiController;

	@MockBean
	ChargingDetailsRegisterService cdChargingDetailsRegisterService;
	
	@MockBean
	CDRecordRepository cdRecordRepository;

	private HttpHeaders httpHeaders;


	@Test
	void testgetCDRecord() throws Exception {
		//String url = "/charge-details/1";
		mockMvc.perform(MockMvcRequestBuilders
	  			.get("/charge-details/1")
	  			.accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$.charge-details").exists())
				//.andExpect(jsonPath("$.charge-details[*].sessionid").value("1"));
		
	}

	
	@Test
	void testCreateCDRRequest() throws Exception {
		String url = "/charge-details";
/*
		mockMvc.perform(post(url).content(asJsonString(new CreateCDRData())).contentType(MediaType.APPLICATION_JSON)
				.headers(httpHeaders).accept(MediaType.APPLICATION_JSON))
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
*/
		CreateCDRData cdrData = new CreateCDRData();
		cdrData.setVehicleId("233");
		cdrData.setStartTime(new Date());
		cdrData.setEndTime(new Date());
		cdrData.setTotalCost(23.3);
		mockMvc.perform( MockMvcRequestBuilders
			      .post("/charge-details")
			      .content(asJsonString(cdrData))
			      .contentType(MediaType.APPLICATION_JSON)
			      .accept(MediaType.APPLICATION_JSON))
		      .andExpect(status().isCreated())
		      .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
		
	}


	 @Test
	void testlistCDRRecords() throws Exception {
		String url = "/charge-details";
/*
		mockMvc.perform(get(url).headers(httpHeaders).contentType(MediaType.APPLICATION_JSON).param("vehicleid", "233")).andDo(MockMvcResultHandlers.print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk());
*/
		
		
		mockMvc.perform(MockMvcRequestBuilders
	  			.get("/charge-details/?vehicleId=233")
	  			.accept(MediaType.APPLICATION_JSON))
	      .andDo(print())
	      .andExpect(MockMvcResultMatchers.status().isOk());
		
	      //.andExpect(status().isOk())
	     // .andExpect(MockMvcResultMatchers.jsonPath("$.charge-details").exists())
	     // .andExpect(MockMvcResultMatchers.jsonPath("$.charge-details[*].vehicleid").isNotEmpty());
	
		
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
