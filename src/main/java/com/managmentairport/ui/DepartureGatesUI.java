package com.managmentairport.ui;

import com.managmentairport.entities.AirPlane;
import com.managmentairport.entities.DepartureGate;
import com.managmentairport.entities.Gate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepartureGatesUI {

    public  static void setValues(){
        DashboardUI.dgservice.save(new DepartureGate(DashboardUI.aipservice.find(0),DashboardUI.gservice.find(0),false ));
        DashboardUI.dgservice.save(new DepartureGate(DashboardUI.aipservice.find(1),DashboardUI.gservice.find(3),false ));
    }
    public static void showDepartureGatesState(){

        System.out.println("Las puertas disponibles y ocupadas son las siguientes");
        System.out.printf("%n%-5s | %-20s | %-10s %n","ID", "Puerta", "Estado");
        System.out.println("___________________________________________");
        List<Gate> gates = DashboardUI.gservice.findAll();
        List<Gate> g = noEnableGates();

        for(int i=0; i < gates.size(); i++){
            if(g.contains(gates.get(i)))
                System.out.printf("%-5d | %-20s | %-10s%n", i, gates.get(i).getGateName(), "No disponible");
            else
                System.out.printf("%-5d | %-20s | %-10s%n", i, gates.get(i).getGateName(), "Disponible");
        }
    }

    public static List<Gate> noEnableGates(){
        List<Gate> gates = new ArrayList<>();
        List<DepartureGate> departureGates = DashboardUI.dgservice.findAll();
        for (int k=0; k < departureGates.size(); k++){
            if(!departureGates.get(k).isDeparture()){
                gates.add(departureGates.get(k).getGate());
            }
        }
        return gates;
    }

    public static List<AirPlane> noEnableAirPlane(){
        List<AirPlane> airPlanes = new ArrayList<>();
        List<DepartureGate> departureGates = DashboardUI.dgservice.findAll();
        for (int k=0; k < departureGates.size(); k++){
            if(!departureGates.get(k).isDeparture()){
                airPlanes.add(departureGates.get(k).getAirPlane());
            }
        }
        return airPlanes;
    }
    public static void showMenu(){
        System.out.printf("%n%n | %-10s | %-10s | %-20s | %-10s%n","[1] Asignar", "[2] Liberar","[3] Regresar al menu principal","[4] Salir");
        System.out.printf(" | %-15s ","Ingrese el numero de la accion a realizar:");
    }
    public static void showMainActions(){
        showDepartureGatesState();
        showMenu();
        int acc = UtilsUi.checkInput(DashboardUI.sc);
        if(acc > 0 && acc < 5){
            switch (acc){
                case 1:
                    asignarAction();
                    break;
                case 2:
                    liberarAction();
                    break;
                case 3:
                    DashboardUI.showMainMenu();
                    DashboardUI.showMainAction();
                    break;
                case 4:
                    System.out.println("Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    showMainActions();
                    break;
            }
        }else{
            showMainActions();
        }
    }

    public static void asignarAction(){
        DepartureGate departureGate = new DepartureGate();
        departureGate.setGate(GateUI.selectGate());
        departureGate.setAirPlane(AirPlaneUI.selectAirPlane());
        departureGate.setDeparture(false);
        DashboardUI.dgservice.save(departureGate);
        showMainActions();
    }

    public static void liberarAction(){
        int id = -1;
        while (!GateUI.checkValidId(id)){
            DepartureGatesUI.showDepartureGatesState();
            System.out.printf("%n%n | %-15s","De la lista anterior ingrese el ID de la puerta a liberar:");
            id = UtilsUi.checkInput(DashboardUI.sc);
            if(!GateUI.isAvaible(id)){
                id = -1;
                System.out.printf("%n%n | %-15s %n","Verifique el numero ingresado!");
            }
        }
        Gate gate = DashboardUI.gservice.find(id);
        DepartureGate departureGate = DashboardUI.dgservice.findByGate(gate);
        int idDeGate = DashboardUI.dgservice.findIdByGate(gate);
        departureGate.setDeparture(true);
        DashboardUI.dgservice.update(departureGate, idDeGate);
        showMainActions();

    }
}
