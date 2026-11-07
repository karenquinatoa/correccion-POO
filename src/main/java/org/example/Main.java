package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TarjetaMetro.mostrarTarifas();
        System.out.print("Ingrese el titular: ");
        String titular = sc.nextLine();
        System.out.print("Ingrese cedula: ");
        String cedula = sc.nextLine();
        System.out.print("Ingrese edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese si tiene discapacidad s/n: ");
        String discapacidad = sc.nextLine();
        boolean tieneDiscacidad = discapacidad.equalsIgnoreCase("s");
        System.out.print("Ingrese el saldo inical: ");
        double saldo = sc.nextDouble();

        TarjetaMetro tj = new TarjetaMetro(titular, cedula, edad, saldo, tieneDiscacidad );

        while (true){
            System.out.println("== MENU==");
            System.out.println("1. Recargar");
            System.out.println("2. Pagar viaje ");
            System.out.println("3. consultar tarjeta");
            System.out.println("4. simular recarga");
            System.out.println("5.salir ");
            System.out.print("Ingrese una opcion: ");
            int opcion = sc.nextInt();

            if (opcion == 1){
                System.out.print("Ingrese el montp a recargar: ");
                double monto = sc.nextDouble();
                tj.recargar(monto);
            } else if (opcion == 2) {
                tj.pagarViaje();

            } else if ( opcion == 3) {
                tj.mostrarInformacion();

            } else if (opcion == 4) {
                System.out.print("Ingrese el moento a simular: ");
                double simular = sc.nextDouble();
                System.out.println("Si recrga $" + simular + " tendia " + tj.calcularViajesDisponibles(simular));

            }else if (opcion == 5){
                System.out.println("Saliendo");
                break;
            }else {
                System.out.println("Opcion incorrecta, intentelo denuevo" );
            }

        }



    }
}