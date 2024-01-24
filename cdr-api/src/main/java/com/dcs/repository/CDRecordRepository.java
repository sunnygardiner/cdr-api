package com.dcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcs.model.CDRecord;


public interface CDRecordRepository extends JpaRepository<CDRecord, Long> {
	
	List<CDRecord> findByVehicleid(String vehicleid);
	
	CDRecord findBySessionid(Long sessionid);

}
