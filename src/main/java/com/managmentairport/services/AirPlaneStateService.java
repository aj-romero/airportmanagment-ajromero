package com.managmentairport.services;

import com.managmentairport.datos.AirPlaneStateData;
import com.managmentairport.entities.AirPlaneState;
import java.util.List;

public class AirPlaneStateService extends AirPlaneStateData implements AirPlaneStateCRUD {
  @Override
  public List<AirPlaneState> findAll() {
    return airPlaneStates;
  }

  @Override
  public AirPlaneState search(String name) {
    for (AirPlaneState airPlaneState : airPlaneStates) {
      if (airPlaneState.getStateName().equals(name)) {
        return airPlaneState;
      }
    }
    return null;
  }

  @Override
  public AirPlaneState find(int id) {
    return airPlaneStates.get(id);
  }

  @Override
  public AirPlaneState save(AirPlaneState airPlaneState) {
    airPlaneStates.add(airPlaneState);
    return airPlaneState;
  }

  @Override
  public void delete(int id) {
    airPlaneStates.remove(id);
  }
}
