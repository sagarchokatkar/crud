
package com.teksys.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teksys.test.model.Rider;
import com.teksys.test.response.RiderResponse;
import com.teksys.test.service.RiderService;

@RestController
@RequestMapping(value="/Rider")
public class RestWS {

	
	private static final Logger logger = LoggerFactory.getLogger(RestWS.class);
	
	@Autowired
	private RiderService RiderService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String welcome(){
		return "Welcome to intellect Rider webservices";
	}
	
	@RequestMapping(value="/activities/{id}/fetchData", method = RequestMethod.POST)
	public ResponseEntity<RiderResponse> create(@RequestBody Rider createRiderRequest){
		logger.debug("Entering inside create(@RequestBody Rider createRiderRequest) method");
		return RiderService.createRider(createRiderRequest);
	}
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ResponseEntity<RiderResponse> update(@RequestBody Rider updateRiderRequest){
		logger.debug("Entering inside create(@RequestBody Rider createRiderRequest) method");
		return RiderService.updateRider(updateRiderRequest);
	}
	
	@RequestMapping(value="/activities/{id}/fetchData", method = RequestMethod.GET)
	public ResponseEntity<RiderResponse> delete(@PathVariable("id") String id){
		logger.debug("Entering inside delete(@RequestBody Rider createRiderRequest) method");
		return RiderService.deleteRider(RiderId);
	}
	
}


 



 



//reuqest URL = "/activities/1234/fetchData" 

