package com.dcs.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dcs.model.CDRecord;
import com.dcs.model.CreateCDRData;





@Mapper
public interface ChargingDetailsRecordMapper {

	static final Logger LOGGER = LoggerFactory.getLogger(ChargingDetailsRecordMapper.class);
	
	ChargingDetailsRecordMapper INSTANCE = Mappers.getMapper(ChargingDetailsRecordMapper.class);
	
	
	 @Mappings({@Mapping(target = "vehicleid", ignore = true),
	        @Mapping(target = "starttime", ignore = true), 
	        @Mapping(target = "endtime", ignore = true),
	        @Mapping(target = "totalcost", ignore = true)})
	    CDRecord mapToCDRecord(CreateCDRData createCDRData, @MappingTarget CDRecord cdRecord);

}
