package com.managmentairport.ui;

import com.managmentairport.services.*;
import java.util.Scanner;

public class DashboardUI {
  static AirLineService aiservice = new AirLineService();
  static AirPlaneStateService aipsservices = new AirPlaneStateService();
  static AirPlaneService aipservice = new AirPlaneService();
  static DepartureGateService dgservice = new DepartureGateService();
  static GateService gservice = new GateService();
  static Scanner sc = new Scanner(System.in);

  public static void inicio() {
    DepartureGatesUI.setValues();
    showHello();
    DepartureGatesUI.showDepartureGatesState();
    showMainMenu();
    showMainAction();
  }

  public static void showHello() {
    System.out.printf(" | %-60s %n", "-".repeat(60));
    System.out.printf(" | Bienvenido a la Gestion y Asignacion de aviones en un aerpuerto %n");
    System.out.printf(" | %-60s %n", "-".repeat(60));
  }

  public static void showMainMenu() {
    System.out.printf("%n%n | %-15s %n", "Menu Principal");
    System.out.printf(" | %-30s %n", "-".repeat(30));
    System.out.printf(" | %-5s | %-20s%n", "No", "Accion");
    System.out.printf(" | %-30s %n", "-".repeat(30));
    System.out.printf(" | %-5d | %-20s%n", 1, "Gestion de Aviones");
    System.out.printf(" | %-5d | %-20s%n", 2, "Asignacion de puertas");
    System.out.printf(" | %-5d | %-20s%n", 3, "Salir");
    System.out.printf("%n%n | %-15s ", "Ingrese el numero de la accion a realizar:");
  }

  public static void showMainAction() {
    int acc = UtilsUi.checkInput(sc);
    if (acc > 0 && acc < 4) {
      switch (acc) {
        case 1:
          AirPlaneUI.showMain();
          break;
        case 2:
          DepartureGatesUI.showMainActions();
          break;
        case 3:
          System.out.println("Hasta luego!");
          System.exit(0);
        default:
          showMainMenu();
          showMainAction();
          break;
      }
    } else {
      showMainMenu();
      showMainAction();
    }
  }
}
