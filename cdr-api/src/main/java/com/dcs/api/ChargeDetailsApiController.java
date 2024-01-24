package com.dcs.api;

import com.dcs.exception.ApiException;
import com.dcs.exception.InputRequestParameterMissing;
import com.dcs.exception.InvalidInputDataException;
import com.dcs.mapper.ChargingDetailsRecordMapper;
import com.dcs.model.CDRecord;
import com.dcs.model.CreateCDRData;
import com.dcs.repository.CDRecordRepository;
import com.dcs.service.ChargingDetailsRegisterService;
import com.dcs.utilities.ValidatePostRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-11-15T11:40:10.666931354Z[GMT]")
@RestController
public class ChargeDetailsApiController implements ChargeDetailsApi {

    private static final Logger log = LoggerFactory.getLogger(ChargeDetailsApiController.class);

   
    private final HttpServletRequest request;
    
    @Autowired
    CDRecordRepository cDRecordRepository;
    
    @Autowired
    ChargingDetailsRegisterService chargingDetailsRegisterService;
    
    @Autowired
    ValidatePostRequest validatePostRequest;

    @org.springframework.beans.factory.annotation.Autowired
    public ChargeDetailsApiController(HttpServletRequest request) {
        this.request = request;
    }



    public ResponseEntity<List<CDRecord>> listCDRByvehicleId(@NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "vehicleId", required = true) String vehicleId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	
            	List<CDRecord> cdrRecords = new ArrayList<CDRecord>();
            	
            	if(vehicleId!=null) {
            		cDRecordRepository.findByVehicleid(vehicleId).forEach(cdrRecords::add);
            	}

            	if(cdrRecords.isEmpty()) {
            		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            	}
            	  return new ResponseEntity<>(cdrRecords,HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CDRecord> retrieveCDRById(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
            	Optional<CDRecord> cdRecord= cDRecordRepository.findById(id);
            	
            	if(cdRecord.isPresent()) {
            		return new ResponseEntity<>(cdRecord.get(), HttpStatus.OK);
        		} else {
        			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        		}
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CDRecord>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CDRecord>(HttpStatus.NOT_IMPLEMENTED);
    }



	@Override
	public ResponseEntity<String> createCDR(@Valid CreateCDRData body)
			throws InvalidInputDataException, InputRequestParameterMissing, ApiException {
		 validatePostRequest.validatePostRequest(body);
		 chargingDetailsRegisterService.createCDRRequest(body);
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
	
	}

	
}
