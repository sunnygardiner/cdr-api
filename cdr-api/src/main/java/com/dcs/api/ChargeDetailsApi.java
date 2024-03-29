/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.50).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.dcs.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dcs.exception.ApiException;
import com.dcs.exception.InputRequestParameterMissing;
import com.dcs.exception.InvalidInputDataException;
import com.dcs.model.CDRecord;
import com.dcs.model.CreateCDRData;
import com.dcs.model.CDRecord;

import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-11-15T11:40:10.666931354Z[GMT]")
@Validated
@RestController
public interface ChargeDetailsApi {

    @Operation(summary = "create charge details record", description = "This operation creates the CDR data.", tags={ "create CDR by session details" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json;charset&#x3D;utf-8", schema = @Schema(implementation = CDRecord.class))) })
    @RequestMapping(value = "/charge-details",
        produces = { "application/json;charset=utf-8" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<String> createCDR(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody CreateCDRData body)
    throws InvalidInputDataException, InputRequestParameterMissing, ApiException;


    @Operation(summary = "List all CDR details based on filter criteria", description = "This operation retrieves all Charge detail records matching the filter criteria.", tags={ "cdr" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json;charset&#x3D;utf-8", schema = @Schema(implementation = CDRecord.class))) })
    @RequestMapping(value = "/charge-details",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<CDRecord>> listCDRByvehicleId( @NotNull @Parameter(in = ParameterIn.QUERY, description = "" ,required=true,schema=@Schema()) @Valid @RequestParam(value = "vehicleId", required = true) String vehicleId);


    @Operation(summary = "Retrieves a charge details by ID", description = "This operation retrieves a CDRecord entity.", tags={ "Retrieves a charge details by ID" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json;charset&#x3D;utf-8", schema = @Schema(implementation = CDRecord.class))) })
    @RequestMapping(value = "/charge-details/{id}",
        produces = { "application/json;charset=utf-8" }, 
        method = RequestMethod.GET)
    ResponseEntity<CDRecord> retrieveCDRById( @Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id") Long id);

}

