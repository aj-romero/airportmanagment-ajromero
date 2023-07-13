package com.managmentairport.services;

import com.managmentairport.entities.AirPlane;
import java.util.List;

public interface AirPlaneCRUD {
  public List<AirPlane> findAll();

  public AirPlane search(String register);

  public AirPlane find(int id);

  public AirPlane save(AirPlane airPlane);

  public void delete(int id);
}
