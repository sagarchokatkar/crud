
package com.tieto.ride.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tieto.ride.controller.RiderRestController;
import com.tieto.ride.model.Rider;

@Component
public class RiderDaoImpl implements RiderDao {

	private static final Logger logger = LoggerFactory.getLogger(RiderRestController.class);
	
	private List<Rider> RiderList = new ArrayList<>();
	
	@Override
	public Rider saveRider(Rider createRiderRequest) {
		String RiderId = UUID.randomUUID().toString();
		createRiderRequest.setId(RiderId);
		createRiderRequest.setIsActive(Boolean.TRUE);
		RiderList.add(createRiderRequest);
		logger.debug("After adding Rider");
		showRiderList();
		return createRiderRequest;
	}

	@Override
	public Rider updateRider(Rider createRiderRequest) {
		Rider foundRider = findRider(createRiderRequest.getId());
		remove(foundRider);
		Rider updatedRider = foundRider;
		if(createRiderRequest.getBirthDate() != null){
			updatedRider.setBirthDate(createRiderRequest.getBirthDate());
		}
		if(createRiderRequest.getPinCode() != null){
			updatedRider.setPinCode(createRiderRequest.getPinCode());
		}
		this.RiderList.add(updatedRider);
		logger.debug("After updating Rider");
		showRiderList();
		return updatedRider;
	}

	@Override
	public Boolean removeRider(String RiderId) {
//		return this.RiderList.removeIf(emp -> emp.getId().equals(RiderId));
		Rider foundRider = findRider(RiderId);
		remove(foundRider);
		Rider updatedRider = foundRider;
		updatedRider.setIsActive(Boolean.FALSE);
		this.RiderList.add(updatedRider);
		logger.debug("After deleting Rider");
		showRiderList();
		return true;

	}
	
	
	public Boolean isRiderAlreadyExist(Rider Rider){
		logger.debug("checking emp with same details present or not {} " , this.RiderList.stream().anyMatch(emp -> emp.getEmail().equals(Rider.getEmail()) && emp.getIsActive()));
		return this.RiderList.stream().anyMatch(emp -> emp.getEmail().equals(Rider.getEmail()) && emp.getIsActive());
	}
	
	private void showRiderList() {
		this.RiderList.forEach(emp -> logger.debug("\n Rider {} " , emp));
	}

	@Override
	public Rider findRider(String RiderId) {
		return this.RiderList.stream().filter(emp -> emp.getId().equals(RiderId)).findFirst().get();
	}
	
	
	public void remove(Rider old){
		this.RiderList.remove(old);
	}

}
