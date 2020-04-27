package com.tieto.ride.service;

import org.springframework.http.ResponseEntity;

import com.tieto.ride.model.Rider;
import com.tieto.ride.response.RiderResponse;

public interface RiderService {
     ResponseEntity<RiderResponse> createRider(Rider createRiderRequest);
     ResponseEntity<RiderResponse> updateRider(Rider createRiderRequest);
     ResponseEntity<RiderResponse> deleteRider(String RiderId);

}
