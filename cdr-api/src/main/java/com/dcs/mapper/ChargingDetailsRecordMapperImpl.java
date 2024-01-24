package com.dcs.mapper;

import java.util.Random;

import com.dcs.model.CDRecord;
import com.dcs.model.CreateCDRData;

public class ChargingDetailsRecordMapperImpl implements ChargingDetailsRecordMapper {

	@Override
	public CDRecord mapToCDRecord(CreateCDRData createCDRData, CDRecord cdRecord) {
		
		final Random RANDOM = new Random(); 
		
		if(createCDRData==null) {
			return null;
		}
		CDRecord cdRecord2 = new CDRecord();
		cdRecord2.setsessionid(RANDOM.nextLong());
		cdRecord2.setvehicleid(createCDRData.getVehicleId());
		cdRecord2.setstarttime(createCDRData.getStartTime());
		cdRecord2.setendtime(createCDRData.getEndTime());
		cdRecord2.settotalcost(createCDRData.getTotalCost());
		return cdRecord2;
	}

}
