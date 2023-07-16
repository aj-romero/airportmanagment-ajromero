package com.managmentairport.services;

import com.managmentairport.datos.AirPlaneData;
import com.managmentairport.entities.AirPlane;
import java.util.List;

public class AirPlaneService extends AirPlaneData
    implements IListActions<AirPlane>, ICUD<AirPlane> {

  @Override
  public List<AirPlane> findAll() {
    return airPlanes;
  }

  @Override
  public AirPlane find(int id) {
    return airPlanes.get(id);
  }

  @Override
  public AirPlane save(AirPlane entity) {
    airPlanes.add(entity);
    return entity;
  }

  @Override
  public void delete(int id) {
    airPlanes.remove(id);
  }

  @Override
  public void update(int idx, AirPlane entity) {
    airPlanes.set(idx, entity);
  }
}
