package com.managmentairport.services;

import com.managmentairport.datos.AirPlaneStateData;
import com.managmentairport.entities.AirPlaneState;
import java.util.List;

public class AirPlaneStateService extends AirPlaneStateData implements IListActions<AirPlaneState> {

  @Override
  public List<AirPlaneState> findAll() {
    return airPlaneStates;
  }

  @Override
  public AirPlaneState find(int id) {
    return airPlaneStates.get(id);
  }
}
