package com.managmentairport.services;

import com.managmentairport.datos.DepartureGateData;
import com.managmentairport.entities.DepartureGate;
import com.managmentairport.entities.Gate;
import java.util.List;

public class DepartureGateService extends DepartureGateData
    implements IListActions<DepartureGate>, ICUD<DepartureGate> {

  @Override
  public DepartureGate save(DepartureGate entity) {
    departureGates.add(entity);
    return entity;
  }

  @Override
  public void delete(int id) {
    departureGates.remove(id);
  }

  @Override
  public void update(int idx, DepartureGate entity) {
    departureGates.set(idx, entity);
  }

  @Override
  public List<DepartureGate> findAll() {
    return departureGates;
  }

  @Override
  public DepartureGate find(int id) {
    return departureGates.get(id);
  }

  public DepartureGate findByGate(Gate gate) {
    DepartureGate res = null;
    for (DepartureGate departureGate : departureGates) {
      if (!departureGate.isDeparture() && departureGate.getGate().equals(gate)) {
        res = departureGate;
      }
    }
    return res;
  }

  public int findIdByGate(Gate gate) {
    int res = 0;
    for (DepartureGate departureGate : departureGates) {
      if (!departureGate.isDeparture() && departureGate.getGate().equals(gate)) {
        break;
      }
      res++;
    }
    return res;
  }
}
