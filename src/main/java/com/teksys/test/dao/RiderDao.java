package com.teksys.test.dao;

import com.teksys.test.model.Rider;

public interface RiderDao {
  public Rider saveRider(Rider createRiderRequest);
  public Rider updateRider(Rider createRiderRequest);
  public Boolean removeRider(String RiderId);
  public Boolean isRiderAlreadyExist(Rider Rider);
  public Rider findRider(String RiderId);
  
}
