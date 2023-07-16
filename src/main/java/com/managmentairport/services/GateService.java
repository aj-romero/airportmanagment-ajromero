package com.managmentairport.services;

import com.managmentairport.datos.GateData;
import com.managmentairport.entities.Gate;
import java.util.List;

public class GateService extends GateData implements IListActions<Gate> {

  @Override
  public List<Gate> findAll() {
    return gates;
  }

  @Override
  public Gate find(int id) {
    return gates.get(id);
  }
}
