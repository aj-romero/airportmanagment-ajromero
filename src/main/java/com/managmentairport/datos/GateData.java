package com.managmentairport.datos;

import com.managmentairport.entities.Gate;
import java.util.ArrayList;
import java.util.List;

public abstract class GateData {
  public static List<Gate> gates = new ArrayList<>();

  public GateData() {
    gates.add(new Gate("1"));
    gates.add(new Gate("2"));
    gates.add(new Gate("3"));
    gates.add(new Gate("4"));
    gates.add(new Gate("TERM M-G1"));
    gates.add(new Gate("TERM M-G2"));
    gates.add(new Gate("TERM M-G3"));
  }
}
