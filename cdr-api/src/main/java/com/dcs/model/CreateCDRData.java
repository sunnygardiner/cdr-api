package com.dcs.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * create Charge details record
 */
@Schema(description = "create Charge details record")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-11-15T11:40:10.666931354Z[GMT]")


public class CreateCDRData   {
  @JsonProperty("vehicleId")
  private String vehicleId = null;

  @JsonProperty("startTime")
  private Date startTime = null;

  @JsonProperty("endTime")
  private Date endTime = null;

  @JsonProperty("totalCost")
  private Double totalCost = null;

  public CreateCDRData vehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
    return this;
  }

  /**
   * Get vehicleId
   * @return vehicleId
   **/
  @Schema(description = "")
  
    public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public CreateCDRData startTime(Date startTime) {
    this.startTime = startTime;
    return this;
  }

  /**
   * Get startTime
   * @return startTime
   **/
  @Schema(description = "")
  
    @Valid
    public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public CreateCDRData endTime(Date endTime) {
    this.endTime = endTime;
    return this;
  }

  /**
   * Get endTime
   * @return endTime
   **/
  @Schema(description = "")
  
    @Valid
    public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public CreateCDRData totalCost(Double totalCost) {
    this.totalCost = totalCost;
    return this;
  }

  /**
   * Get totalCost
   * @return totalCost
   **/
  @Schema(description = "")
  
    public Double getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(Double totalCost) {
    this.totalCost = totalCost;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCDRData createCDRData = (CreateCDRData) o;
    return Objects.equals(this.vehicleId, createCDRData.vehicleId) &&
        Objects.equals(this.startTime, createCDRData.startTime) &&
        Objects.equals(this.endTime, createCDRData.endTime) &&
        Objects.equals(this.totalCost, createCDRData.totalCost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleId, startTime, endTime, totalCost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCDRData {\n");
    
    sb.append("    vehicleId: ").append(toIndentedString(vehicleId)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    endTime: ").append(toIndentedString(endTime)).append("\n");
    sb.append("    totalCost: ").append(toIndentedString(totalCost)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
