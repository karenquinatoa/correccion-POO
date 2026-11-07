package org.example;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.table.TableRowSorter;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            TarjetaMetro.mostrarTarifa();

        System.out.print("titular: ");
        String titular = sc.nextLine();
        System.out.print("cedula: ");
        String cedula = sc.nextLine();
        System.out.print("edad: ");
        int edad = sc.nextInt();
        sc.nextLine();
        System.out.print("Discapcidad: ");
        String discapcidad = sc.nextLine();
        boolean tieneDiscapcidad = discapcidad.equalsIgnoreCase("s");
        System.out.print("saldo: ");
        double saldo = sc.nextDouble();

        TarjetaMetro tj = new TarjetaMetro(titular, cedula, edad, saldo, tieneDiscapcidad);

        while(true){
            System.out.println("== MENU == ");
            System.out.println(" 1.Recargar:");
            System.out.println("2. Pagar viaje");
            System.out.println("3. Consultar tarjeta");
            System.out.println("4. simulsar recarga");
            System.out.println("5.salir");
            System.out.print("Ingrese una opcion: ");
            int opcion = sc.nextInt();

            if (opcion == 1){
                System.out.print("Ingrese un moneto a recragar: ");
                double monto = sc.nextDouble();
                tj.recargar(monto);
            } else if (opcion == 2) {
                tj.pagarViaje();

            } else if (opcion == 3) {
                tj.mostrarInformacion();

            } else if (opcion == 4) {
                System.out.print("Ingrese el monto a simular: ");
                double simular = sc.nextDouble();
                System.out.println("Si recarga "+ simular+ " tendria " + tj.calcularViajesDisponibles(simular));
            } else if (opcion == 5) {
                System.out.println("Saliendo");
                break;
            }else {
                System.out.println("OPcion incorrecta, intentelo denuevo");
            }
        }




    }
}