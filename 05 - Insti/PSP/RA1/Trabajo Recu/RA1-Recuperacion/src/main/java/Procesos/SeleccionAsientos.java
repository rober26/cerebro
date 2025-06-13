package Procesos;

//Roberto Lespe Herrera roberto.lespe@educa.madrid.org

import java.util.Scanner;

public class SeleccionAsientos {
    public static void main(String[] args) {
        String[] asientos = {"A1", "A2", "B1", "B2", "C1", "C2"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Asientos disponibles: " + String.join(", ", asientos));
        System.out.print("Elije un asiento: ");
        String asiento = sc.nextLine().trim().toUpperCase();

        for (String a : asientos) {
            if (a.equals(asiento)) {
                System.out.println(asiento);
                return;
            }
        }
        System.out.println("");
    }
}