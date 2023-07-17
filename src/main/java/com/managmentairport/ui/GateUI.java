package com.managmentairport.ui;

import com.managmentairport.entities.Gate;
import com.managmentairport.services.GateService;
import java.util.List;

public class GateUI {
  static GateService gservice = new GateService();

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
    return gservice.find(id);
  }

  public static boolean checkValidId(int id) {
    return (id >= 0 && id < gservice.findAll().size());
  }

  public static boolean isAvaible(int id) {
    List<Gate> g = DepartureGatesUI.noEnableGates();
    boolean res = false;
    for (int i = 0; i < gservice.findAll().size(); i++) {
      if (g.contains(gservice.find(i)) && i == id) res = true;
    }
    return res;
  }
}
