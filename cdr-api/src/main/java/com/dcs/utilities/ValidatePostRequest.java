package com.dcs.utilities;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dcs.exception.InputRequestParameterMissing;
import com.dcs.exception.InvalidInputDataException;
import com.dcs.model.CDRecord;
import com.dcs.model.CreateCDRData;
import com.dcs.repository.CDRecordRepository;


@Component
public class ValidatePostRequest {

	@Autowired
	CDRecordRepository cdRecordRepository;

	public void validatePostRequest(CreateCDRData inputReq) throws InvalidInputDataException,InputRequestParameterMissing  {

		validateRequiredParameters(inputReq);
		validateStartTime(inputReq);
		validateEndTime(inputReq);
		validateCost(inputReq);

	}

	private void validateCost(CreateCDRData inputReq) throws InvalidInputDataException {
		if (inputReq.getTotalCost() < 0)
			throw new InvalidInputDataException("TotalCost cannot be less than 0","400412");
	}

	private void validateEndTime(CreateCDRData inputReq) throws InvalidInputDataException {
		if (inputReq.getEndTime().before(inputReq.getStartTime())) {
			throw new InvalidInputDataException("EndTime cannot be smaller than StartTime","400412");
		}

	}

	private void validateStartTime(CreateCDRData inputReq) throws InvalidInputDataException {

		List<CDRecord> listCDRecord = cdRecordRepository.findByVehicleid(inputReq.getVehicleId());

		Optional<CDRecord> cdRecord = listCDRecord.stream().max(Comparator.comparing(CDRecord::getendtime));

		if (cdRecord.isPresent()) {
			if (cdRecord.get().getendtime().after(inputReq.getStartTime()))
				throw new InvalidInputDataException("StartTime cannot be less than EndTime of an old Charging session","400412");
		}

	}

	void validateRequiredParameters(CreateCDRData inputReq) throws InputRequestParameterMissing {

		if (!Objects.nonNull(inputReq.getVehicleId())) {
			throw new InputRequestParameterMissing("Vehicle Id is missing in the Request.","400411");
		}
		if (!Objects.nonNull(inputReq.getStartTime())) {
			throw new InputRequestParameterMissing("StartTime is missing in the Request.","400411");
		}

		if (!Objects.nonNull(inputReq.getEndTime())) {
			throw new InputRequestParameterMissing("EndTime is missing in the Request.","400411");
		}

		if (!Objects.nonNull(inputReq.getTotalCost())) {
			throw new InputRequestParameterMissing("TotalCost is missing in the Request.","400411");
		}

	}

}
