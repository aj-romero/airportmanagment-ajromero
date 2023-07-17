package com.managmentairport.ui;

import com.managmentairport.entities.AirLine;
import com.managmentairport.services.AirLineService;
import com.managmentairport.services.IListActions;
import java.util.List;

public class AirLineUI {
  static IListActions<AirLine> aiservice = new AirLineService();

  public static void printAll(List<AirLine> airLines) {
    System.out.printf("%n%-5s | %-20s %n", "ID", "Aerolinea");
    System.out.println("___________________________________________");
    for (int i = 0; i < airLines.size(); i++) {
      System.out.printf("%-5d | %-20s%n", i, airLines.get(i).getAirLineName());
    }
  }

  public static boolean checkValidId(int id) {
    return (id >= 0 && id < aiservice.findAll().size());
  }

  public static AirLine selectAirline() {
    int idAirLine = -1;
    while (!checkValidId(idAirLine)) {
      System.out.printf(
          "%n%n | %-15s %n", "De la siguiente lista favor seleccione la aerolinea del avion");
      printAll(aiservice.findAll());
      idAirLine = UtilsUi.checkInput(DashboardUI.sc);
      if (!checkValidId(idAirLine)) {
        System.out.printf("%n%n | %-15s %n", "Verifique el numero ingresado!");
      }
    }
    return aiservice.find(idAirLine);
  }
}
