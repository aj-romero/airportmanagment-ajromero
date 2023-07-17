package com.managmentairport.ui;

import com.managmentairport.entities.AirPlaneState;
import com.managmentairport.services.AirPlaneStateService;


import java.util.List;

public class AirPlaneStateUI {

  static AirPlaneStateService aipsservice = new AirPlaneStateService();

  public static AirPlaneState selectAirPlaneState() {
    int idAirPlaneState = -1;
    while (!checkValidId(idAirPlaneState)) {
      System.out.printf(
          "%n%n | %-15s %n", "De la siguiente lista favor seleccione el estado del avion");
      printAll(aipsservice.findAll());
      idAirPlaneState = UtilsUi.checkInput(DashboardUI.sc);
      if (!checkValidId(idAirPlaneState)) {
        System.out.printf("%n%n | %-15s %n", "Verifique el numero ingresado!");
      }
    }
    return aipsservice.find(idAirPlaneState);
  }

  public static void printAll(List<AirPlaneState> airPlaneStates) {
    System.out.printf("%n%-5s | %-20s %n", "ID", "Estado de avion");
    System.out.println("___________________________________________");
    for (int i = 0; i < airPlaneStates.size(); i++) {
      System.out.printf("%-5d | %-20s%n", i, airPlaneStates.get(i).getStateName());
    }
  }

  public static boolean checkValidId(int id) {
    return (id >= 0 && id < aipsservice.findAll().size());
  }
}
