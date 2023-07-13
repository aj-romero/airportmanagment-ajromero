package com.managmentairport.ui;

import java.util.Scanner;

public class UtilsUi {

  public static int checkInput(Scanner es) {
    int acc = -1;
    while (acc == -1) {
      try {
        acc = Integer.parseInt(es.nextLine());
      } catch (Exception e) {
        acc = -1;
        System.out.printf("%n%n | %-15s: ", "Ingrese un numero entero positivo");
      }
    }
    return acc;
  }
}
