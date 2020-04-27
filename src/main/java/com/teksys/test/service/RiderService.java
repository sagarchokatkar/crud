package com.teksys.test.service;

import org.springframework.http.ResponseEntity;

import com.teksys.test.model.Rider;
import com.teksys.test.response.RiderResponse;

public interface RiderService {
     ResponseEntity<RiderResponse> createRider(Rider createRiderRequest);
     ResponseEntity<RiderResponse> updateRider(Rider createRiderRequest);
     ResponseEntity<RiderResponse> deleteRider(String RiderId);

}
