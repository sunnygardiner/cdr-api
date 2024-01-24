package com.dcs.model;

import java.util.Date;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * CDRecord
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-11-15T11:40:10.666931354Z[GMT]")

@Entity
@Table
public class CDRecord   {
	
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long sessionid = null;

  @Column(name = "vehicleid")
  private String vehicleid;

  @Column(name = "starttime")
  private Date starttime;

  @Column(name = "endtime")
  private Date endtime;

  @Column(name = "totalcost")
  private Double totalcost;

  public CDRecord sessionid(Long sessionid) {
    this.sessionid = sessionid;
    return this;
  }

  /**
   * Unique identifier for CDR session identification.
   * @return sessionid
   **/
  @Schema(required = true, description = "Unique identifier for CDR session identification.")
      @NotNull

    public Long getsessionid() {
    return sessionid;
  }

  public void setsessionid(Long sessionid) {
    this.sessionid = sessionid;
  }

  public CDRecord vehicleid(String vehicleid) {
    this.vehicleid = vehicleid;
    return this;
  }

  /**
   * Unique identifier for CDR vehicle identification.
   * @return vehicleid
   **/
  @Schema(required = true, description = "Unique identifier for CDR vehicle identification.")
      @NotNull

    public String getvehicleid() {
    return vehicleid;
  }

  public void setvehicleid(String vehicleid) {
    this.vehicleid = vehicleid;
  }

  public CDRecord starttime(Date starttime) {
    this.starttime = starttime;
    return this;
  }

  /**
   * start time of the charging session
   * @return starttime
   **/
  @Schema(description = "start time of the charging session")
  
    @Valid
    public Date getstarttime() {
    return starttime;
  }

  public void setstarttime(Date starttime) {
    this.starttime = starttime;
  }

  public CDRecord endtime(Date endtime) {
    this.endtime = endtime;
    return this;
  }

  /**
   * start time of the charging session
   * @return endtime
   **/
  @Schema(description = "start time of the charging session")
  
    @Valid
    public Date getendtime() {
    return endtime;
  }

  public void setendtime(Date endtime) {
    this.endtime = endtime;
  }

  public CDRecord totalcost(Double totalcost) {
    this.totalcost = totalcost;
    return this;
  }

  /**
   * total cost of the charging session
   * @return totalcost
   **/
  @Schema(description = "total cost of the charging session")
  
    public Double gettotalcost() {
    return totalcost;
  }

  public void settotalcost(Double totalcost) {
    this.totalcost = totalcost;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CDRecord cdRecord = (CDRecord) o;
    return Objects.equals(this.sessionid, cdRecord.sessionid) &&
        Objects.equals(this.vehicleid, cdRecord.vehicleid) &&
        Objects.equals(this.starttime, cdRecord.starttime) &&
        Objects.equals(this.endtime, cdRecord.endtime) &&
        Objects.equals(this.totalcost, cdRecord.totalcost);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sessionid, vehicleid, starttime, endtime, totalcost);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CDRecord {\n");
    
    sb.append("    sessionid: ").append(toIndentedString(sessionid)).append("\n");
    sb.append("    vehicleid: ").append(toIndentedString(vehicleid)).append("\n");
    sb.append("    starttime: ").append(toIndentedString(starttime)).append("\n");
    sb.append("    endtime: ").append(toIndentedString(endtime)).append("\n");
    sb.append("    totalcost: ").append(toIndentedString(totalcost)).append("\n");
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
