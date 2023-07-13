package com.managmentairport.ui;

import com.managmentairport.entities.Gate;
import java.util.List;

public class GateUI {
  public static Gate selectGate() {
    int id = -1;
    while (!checkValidId(id)) {
      DepartureGatesUI.showDepartureGatesState();
      System.out.printf(
          "%n%n | %-15s", "De la lista anterior ingrese el ID de la puerta a asignar:");
      id = UtilsUi.checkInput(DashboardUI.sc);
      if (isAvaible(id)) {
        id = -1;
        System.out.printf("%n%n | %-15s %n", "Verifique el numero ingresado!");
      }
    }
    return DashboardUI.gservice.find(id);
  }

  public static boolean checkValidId(int id) {
    if (id >= 0 && id < DashboardUI.gservice.findAll().size()) {
      return true;
    } else return false;
  }

  public static boolean isAvaible(int id) {
    List<Gate> g = DepartureGatesUI.noEnableGates();
    boolean res = false;
    for (int i = 0; i < DashboardUI.gservice.findAll().size(); i++) {
      if (g.contains(DashboardUI.gservice.find(i)) && i == id) res = true;
    }
    return res;
  }
}
