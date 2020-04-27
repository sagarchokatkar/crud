package com.tieto.ride.service;


import static com.tieto.ride.validation.RiderValidation.isInvalidcreateRiderRequest;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.tieto.ride.dao.RiderDao;
import com.tieto.ride.dao.RiderDaoImpl;
import com.tieto.ride.model.Rider;
import com.tieto.ride.response.RiderResponse;;

@Service
public class RiderServiceImpl implements RiderService {

	private static final Logger logger = LoggerFactory.getLogger(RiderServiceImpl.class);
	
	@Autowired
	private RiderService RiderService;

	@Autowired
	private RiderDao RiderDao;
	
	@Override
	public ResponseEntity<RiderResponse> createRider(Rider createRiderRequest) {
		logger.debug("entering inside createRider(Rider createRiderRequest) method");
		logger.debug("Create Rider Request : {} ", createRiderRequest);
		RiderResponse createRiderResponse = isInvalidcreateRiderRequest(createRiderRequest);
		if(!createRiderResponse.getValErrors().isEmpty()){
			return new ResponseEntity<RiderResponse>(createRiderResponse, HttpStatus.OK);
		}
		createRiderResponse = new RiderResponse();
		if(RiderDao.isRiderAlreadyExist(createRiderRequest)){
			logger.debug("entering inside createRider(Rider createRiderRequest) method");
			createRiderResponse.setResMsg("Rider with the given email id already exist, please try another email id");
			return new ResponseEntity<RiderResponse>(createRiderResponse, HttpStatus.OK);
		}
		Rider foundEmp = RiderDao.saveRider(createRiderRequest);
		createRiderResponse.setUserId(foundEmp.getId());
		createRiderResponse.setResMsg("Rider with given information created successfully");
		return new ResponseEntity<RiderResponse>(createRiderResponse, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<RiderResponse> updateRider(Rider createRiderRequest) {
		logger.debug("entering inside updateRider(Rider createRiderRequest) method");
		logger.debug("Update Rider Request : {} ", createRiderRequest);
		RiderResponse updateRiderResponse = new RiderResponse();
		Rider foundRider = RiderDao.findRider(createRiderRequest.getId());
		if(null == foundRider){
			updateRiderResponse.setResMsg("Rider with given details not found");
			return new ResponseEntity<RiderResponse>(updateRiderResponse, HttpStatus.OK);
		}
		foundRider = RiderDao.updateRider(createRiderRequest);
		updateRiderResponse.setResMsg("Rider with given details updated successfully");
		updateRiderResponse.setUserId(foundRider.getId());
		return new ResponseEntity<RiderResponse>(updateRiderResponse, HttpStatus.OK);	
	}


	@Override
	public ResponseEntity<RiderResponse> deleteRider(String RiderId) {
		logger.debug("entering inside deleteRider(String RiderId) method");
		logger.debug("Delete Rider Request : {} ", RiderId);
		RiderResponse deleteResponse = new RiderResponse(); 
		if(RiderDao.isRiderAlreadyExist(new Rider(RiderId))){
			deleteResponse.setUserId(RiderId);
			deleteResponse.setResMsg("Rider to be deleted with given if not found");
		}
		if(RiderDao.removeRider(RiderId)){
			deleteResponse.setUserId(RiderId);
			deleteResponse.setResMsg("Rider successfully deleted with given id");
		}else{
			deleteResponse.setUserId(RiderId);
			deleteResponse.setResMsg("Rider deletion with given id failed");
		}
		return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
	}
}
