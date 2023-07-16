package com.managmentairport.services;

import com.managmentairport.datos.AirLineData;
import com.managmentairport.entities.AirLine;
import java.util.List;

public class AirLineService extends AirLineData implements IListActions<AirLine> {

  @Override
  public List<AirLine> findAll() {
    return airLines;
  }

  @Override
  public AirLine find(int id) {
    return airLines.get(id);
  }
}
