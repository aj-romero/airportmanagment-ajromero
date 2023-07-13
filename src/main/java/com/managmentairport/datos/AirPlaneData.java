package com.managmentairport.datos;

import com.managmentairport.entities.AirLine;
import com.managmentairport.entities.AirPlane;
import com.managmentairport.entities.AirPlaneState;
import java.util.ArrayList;
import java.util.List;

public abstract class AirPlaneData {
  public static List<AirPlane> airPlanes = new ArrayList<>();

  public AirPlaneData() {
    airPlanes.add(
        new AirPlane(new AirLine("Avianca"), new AirPlaneState("disponible"), "N904DE", 65));
    airPlanes.add(
        new AirPlane(new AirLine("VOLARIS"), new AirPlaneState("disponible"), "G-KELS", 15));
    airPlanes.add(
        new AirPlane(
            new AirLine("Copa AirLines"), new AirPlaneState("en mantenimiento"), "K-101943", 300));
  }
}
