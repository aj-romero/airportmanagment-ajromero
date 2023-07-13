package com.managmentairport.services;

import com.managmentairport.entities.AirLine;
import java.util.List;

public interface AirLineCRUD {
  public List<AirLine> findAll();

  public AirLine search(String name);

  public AirLine find(int id);

  public AirLine save(AirLine airline);

  public void delete(int id);
}
