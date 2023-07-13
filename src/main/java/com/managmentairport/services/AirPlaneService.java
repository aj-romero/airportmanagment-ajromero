package com.managmentairport.services;

import com.managmentairport.datos.AirPlaneData;
import com.managmentairport.entities.AirPlane;
import java.util.List;

public class AirPlaneService extends AirPlaneData implements AirPlaneCRUD {
  @Override
  public List<AirPlane> findAll() {
    return airPlanes;
  }

  @Override
  public AirPlane search(String register) {
    for (AirPlane airPlane : airPlanes) {
      if (airPlane.getRegisterNumber().equals(register)) {
        return airPlane;
      }
    }
    return null;
  }

  @Override
  public AirPlane find(int id) {
    return airPlanes.get(id);
  }

  @Override
  public AirPlane save(AirPlane airPlane) {
    airPlanes.add(airPlane);
    return airPlane;
  }

  @Override
  public void delete(int id) {
    airPlanes.remove(id);
  }
}
