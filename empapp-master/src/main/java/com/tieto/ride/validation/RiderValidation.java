package com.tieto.ride.validation;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tieto.ride.model.Rider;
import com.tieto.ride.response.RiderResponse;

public class RiderValidation {

	private static final Logger logger = LoggerFactory.getLogger(RiderValidation.class);

	public static RiderResponse isInvalidcreateRiderRequest(Rider createRiderRequest) {

		RiderResponse createRiderResponse = new RiderResponse();
		if (null == createRiderRequest) {
			createRiderResponse.setResMsg("Rider creation failed, required parameters are missing");
			addErrr(createRiderRequest, createRiderResponse);
			return createRiderResponse;
		}else{
			addErrr(createRiderRequest, createRiderResponse);
			return createRiderResponse;
		}
				
	}

	public static void addErrr(Rider createRiderRequest,RiderResponse createRiderResponse){
		Map<String, String> errors = new HashMap<String, String>();
		if (null == createRiderRequest.getfName()) {
				errors.put("First Name", "Required Parameter Missing");
		}
		if (null == createRiderRequest.getlName()) {
			errors.put("Last Name", "Required Parameter Missing");
		}
		if (null == createRiderRequest.getEmail()) {
			errors.put("Email", "Required Parameter Missing");
		}
		if (null == createRiderRequest.getBirthDate()) {
			errors.put("Birth Date", "Required Parameter Missing");
		}
		createRiderResponse.setValErrors(errors);
	}
}
