package com.dcs.service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dcs.mapper.ChargingDetailsRecordMapper;
import com.dcs.model.CDRecord;
import com.dcs.model.CreateCDRData;
import com.dcs.repository.CDRecordRepository;

@Component
public class ChargingDetailsRegisterService {

	@Autowired
	EntityManager entityManager;
	
	@Autowired
	CDRecordRepository cDRecordRepository;
	
	@Transactional
	public void createCDRRequest(@Valid CreateCDRData body) {
		CDRecord cdRecord = ChargingDetailsRecordMapper.INSTANCE.mapToCDRecord(body, null);
		//entityManager.persist(cdRecord);
		cDRecordRepository.save(cdRecord);
	}

}
