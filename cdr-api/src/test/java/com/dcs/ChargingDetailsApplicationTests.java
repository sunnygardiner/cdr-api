package com.dcs;



import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dcs.api.ChargeDetailsApiController;
import com.dcs.repository.CDRecordRepository;
import com.dcs.service.ChargingDetailsRegisterService;



@RunWith(SpringRunner.class)
class ChargingDetailsApplicationTests{

	
	@Test
	public void main() throws Exception {
		ChargingDetailsApplication.main(new String[] {});
	   }

	
}
