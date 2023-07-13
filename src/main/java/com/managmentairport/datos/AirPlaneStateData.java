package com.managmentairport.datos;

import com.managmentairport.entities.AirPlaneState;

import java.util.ArrayList;
import java.util.List;

public abstract class AirPlaneStateData {
    public static List<AirPlaneState> airPlaneStates = new ArrayList<>();

    public AirPlaneStateData(){
        airPlaneStates.add(new AirPlaneState("disponible"));
        airPlaneStates.add(new AirPlaneState("en Mantenimiento"));
        airPlaneStates.add(new AirPlaneState("en vuelo"));
        airPlaneStates.add(new AirPlaneState("no disponible"));
    }
}
