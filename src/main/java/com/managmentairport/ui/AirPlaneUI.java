package com.managmentairport.ui;

import com.managmentairport.entities.AirPlane;
import java.util.List;

public class AirPlaneUI {
  public static void printAll(List<AirPlane> airPlanes) {
    System.out.printf(
        "%n%-5s | %-20s | %-20s | %-20s | %-10s%n",
        "ID", "Num Registro", "Aerolinea", "Capacidad(Pasajeros)", "Estado");
    System.out.println(
        "________________________________________________________________________________________________________");
    for (int i = 0; i < airPlanes.size(); i++) {
      System.out.printf("%-5d | %-20s", i, airPlanes.get(i).getRegisterNumber());
      System.out.printf(" | %-20s", airPlanes.get(i).getAirLine().getAirLineName());
      System.out.printf(" | %-20s", airPlanes.get(i).getCapacity());
      System.out.printf(" | %-10s%n", airPlanes.get(i).getState().getStateName());
    }
  }

  public static void printMenuCRUD() {
    System.out.printf(
        "%n%n | %-10s | %-10s | %-10s | %-20s | %-10s%n",
        "[1] Agregar", "[2] Editar", "[3] Eliminar", "[4] Regresar al menu principal", "[5] Salir");
    System.out.printf(" | %-15s ", "Ingrese el numero de la accion a realizar:");
  }

  public static void showMain() {
    printAll(DashboardUI.aipservice.findAll());
    printMenuCRUD();
    int acc = UtilsUi.checkInput(DashboardUI.sc);
    if (acc > 0 && acc < 6) {
      switch (acc) {
        case 1:
          agregarAction();
          break;
        case 2:
          editarAction();
          break;
        case 3:
          eliminarAction();
          break;
        case 4:
          DashboardUI.showMainMenu();
          DashboardUI.showMainAction();
          break;
        case 5:
          System.out.println("Hasta luego!");
          System.exit(0);
          break;
        default:
          showMain();
          break;
      }
    } else {
      showMain();
    }
  }

  public static void agregarAction() {
    AirPlane airPlane = new AirPlane();
    System.out.printf("%n%n | %-15s %n", "Ingresar el numero de registro del avion");
    airPlane.setRegisterNumber(DashboardUI.sc.nextLine());
    System.out.printf("%n%n | %-15s %n", "Ingresar la capacidad de pasajeros del avion");
    airPlane.setCapacity(UtilsUi.checkInput(DashboardUI.sc));
    airPlane.setAirLine(AirLineUI.selectAirline());
    airPlane.setState(AirPlaneStateUI.selectAirPlaneState());
    DashboardUI.aipservice.save(airPlane);
    showMain();
  }

  public static void editarAction() {
    int id = -1;
    while (!checkValidId(id)) {
      System.out.printf(
          "%n%n | %-15s %n", "Ingresar el numero correspondiente al avion que desea editar");
      id = UtilsUi.checkInput(DashboardUI.sc);
      if (!checkValidId(id)) {
        System.out.printf("%n%n | %-15s %n", "Verifique el numero ingresado!");
      }
    }
    updateAirPlane(id);
  }

  public static boolean checkValidId(int id) {
    return ((id >= 0) && (id < DashboardUI.aipservice.findAll().size()));
  }

  public static void updateAirPlane(int id) {
    AirPlane airPlane = DashboardUI.aipservice.find(id);
    System.out.printf("%n | %-15s %n", "Ingresar el numero de registro del avion");
    airPlane.setRegisterNumber(DashboardUI.sc.nextLine());
    System.out.printf(" | %-15s %n", "Ingresar la capacidad de pasajeros del avion");
    airPlane.setCapacity(UtilsUi.checkInput(DashboardUI.sc));
    airPlane.setAirLine(AirLineUI.selectAirline());
    airPlane.setState(AirPlaneStateUI.selectAirPlaneState());

    DashboardUI.aipservice.update(id, airPlane);
    showMain();
  }

  public static void eliminarAction() {
    int id = -1;
    while (!checkValidId(id)) {
      System.out.printf(
          "%n%n | %-15s %n", "Ingresar el numero correspondiente al avion que desea eliminar");
      id = UtilsUi.checkInput(DashboardUI.sc);
      if (!checkValidId(id)) {
        System.out.printf(" | %-15s %n", "Verifique el numero ingresado!");
      }
    }

    AirPlane airPlane = DashboardUI.aipservice.find(id);
    System.out.printf(
        "%n%-5s | %-20s | %-20s | %-20s | %-10s%n",
        "ID", "Num Registro", "Aerolinea", "Capacidad(Pasajeros)", "Estado");
    System.out.println(
        "________________________________________________________________________________________________________");
    System.out.printf("%-5d | %-20s", id, airPlane.getRegisterNumber());
    System.out.printf(" | %-20s", airPlane.getAirLine().getAirLineName());
    System.out.printf(" | %-20s", airPlane.getCapacity());
    System.out.printf(" | %-10s%n", airPlane.getState().getStateName());
    System.out.printf(
        "%n | %-15s %s [1]?",
        "Esta seguro de eliminar el avion con registro ", airPlane.getRegisterNumber());
    if (UtilsUi.checkInput(DashboardUI.sc) == 1) {
      System.out.printf(
          "%n | %-15s %s exitosamente!",
          "Se elimino el avion con registro  ", airPlane.getRegisterNumber());
      DashboardUI.aipservice.delete(id);
      showMain();
    } else {
      showMain();
    }
  }

  public static AirPlane selectAirPlane() {
    int id = -1;
    while (!checkValidId(id)) {
      System.out.printf(
          "%n%n | %-15s %n", "De la siguiente lista favor seleccione el ID del avion a asignar");
      printAll(DashboardUI.aipservice.findAll());
      id = UtilsUi.checkInput(DashboardUI.sc);
      if (isAvaible(id)) {
        id = -1;
        System.out.printf(
            "%n | %-15s %n",
            "Verifique el numero ingresado! el avion ya ha sido asignado a una puerta");
      } else if (!DashboardUI.aipservice.find(id).getState().getStateName().equals("disponible")) {
        id = -1;
        System.out.printf(
            "%n | %-15s %n",
            "Verifique el numero ingresado! el avion no esta disponible para ser asignado");
      }
    }
    return DashboardUI.aipservice.find(id);
  }

  public static boolean isAvaible(int id) {
    List<AirPlane> a = DepartureGatesUI.noEnableAirPlane();
    boolean res = false;
    for (int i = 0; i < DashboardUI.aipservice.findAll().size(); i++) {
      if (a.contains(DashboardUI.aipservice.find(i)) && i == id) res = true;
    }
    return res;
  }
}
