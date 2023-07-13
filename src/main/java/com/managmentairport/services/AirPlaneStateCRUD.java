package com.managmentairport.services;

import com.managmentairport.entities.AirPlaneState;
import java.util.List;

public interface AirPlaneStateCRUD {
  public List<AirPlaneState> findAll();

  public AirPlaneState search(String name);

  public AirPlaneState find(int id);

  public AirPlaneState save(AirPlaneState airPlaneState);

  public void delete(int id);
}
