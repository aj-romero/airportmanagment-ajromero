package com.managmentairport.datos;

import com.managmentairport.entities.AirLine;
import java.util.ArrayList;
import java.util.List;

public abstract class AirLineData {

  public static List<AirLine> airLines = new ArrayList<>();

  public AirLineData() {
    airLines.add(new AirLine("Avianca"));
    airLines.add(new AirLine("JetBlue Airways"));
    airLines.add(new AirLine("Copa Airlines"));
    airLines.add(new AirLine("LATAM AirLines"));
    airLines.add(new AirLine("TAME"));
    airLines.add(new AirLine("VOLARIS"));
    airLines.add(new AirLine("Southwest Airlines"));
  }
}
