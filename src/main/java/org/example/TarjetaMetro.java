package org.example;

import javax.lang.model.util.ElementScanner6;

public class TarjetaMetro{
    private String titular;
    private String cedula;
    private int edad;
    private boolean tieneDiscapcidad;
    private double saldo;
    private int viajesRealizados;
    private double totalRecargado;


    public TarjetaMetro(){
        this.titular = "ANONIMO";
        this.cedula = "1111111111";
        this.edad = 30;
        this.tieneDiscapcidad = false;
        this.saldo = 0;
    }

    public static final double TARFIFA_GENERAL = 0.45;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular.isBlank()){
            this.titular = "ANONIMO";
        }else{
            this.titular = titular;
        }
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula.length() == 10){
            this.cedula = cedula;
        }else{
            this.cedula = "0000000000";
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 5 && edad <= 110){
            this.edad = edad;
        }else{
            this.edad = 18;
        }
    }

    public boolean isTieneDiscapcidad() {
        return tieneDiscapcidad;
    }

    public void setTieneDiscapcidad(boolean tieneDiscapcidad) {
        this.tieneDiscapcidad = tieneDiscapcidad;
    }

    public double getSaldo() {
        return saldo;
    }



    public int getViajesRealizados() {
        return viajesRealizados;
    }



    public double getTotalRecargado() {
        return totalRecargado;
    }

    public TarjetaMetro(String titular, String cedula, int edad, double saldo_Inical, boolean tieneDiscapcidad){
        setTitular(titular);
        setCedula(cedula);
        setEdad(edad);
        setTieneDiscapcidad(tieneDiscapcidad);
        if (saldo_Inical >= 0  && saldo_Inical <= 40){
            this.saldo = saldo_Inical;

        }else{
            this.saldo = 0;
        }

    }

    public static  void mostrarTarifa(){
        System.out.println("==Metro quito tarifas == ");
        System.out.println("Personas con discapacidad: $0.10 (tiene prioridad sobre la edad)");
        System.out.println("De 5 a 17 años o de 65 en adelante : $0.22" );
        System.out.println("Resto de usuarios $0.45");
        System.out.println("Reglas: ");
        System.out.println("Cada recarga debe ser de 1$ a 20$");
        System.out.println("El sado de la tarejta no puede superar los 40$");
        System.out.println("Un vieaje se permite cuabdo el saldo es mayor o igual a la tarifa ");

    }

    public double calcularTarifa(){
        if (tieneDiscapcidad){
            return 0.10;
        } else if ((edad >= 5 && edad <= 17) || edad >= 65) {
            return 0.22;
        }else {
            return TARFIFA_GENERAL;
        }

    }
    public double calcularViajesDisponibles(){
        return  saldo / calcularTarifa();
    }
    public double calcularViajesDisponibles(double montoAdicional){
        return  (saldo + montoAdicional) /calcularTarifa();
    }
    public boolean recargar(double monto){
        if (monto < 1 || monto > 20){
            System.out.println("MONTO NO PERMITIFO");
            return  false;
        }else if ((saldo + monto) > 40){
            System.out.println("SALDO MAXIMO");
            return false;

        }
        saldo += monto;
        totalRecargado += monto;
        System.out.println("El nuevo saldo es: "+ saldo);
        return  true;
    }

    public boolean pagarViaje(){
        if (saldo >= calcularTarifa()){
            saldo -= calcularTarifa();
            viajesRealizados += 1;
            System.out.println("ACCESO PERMITIDO");
            System.out.println("Pago exitoso, saldo restante "+ saldo);
            return  true;
        }else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    public void mostrarInformacion() {
        System.out.println("Titulr: " + titular);
        System.out.println("cedula: " + cedula);
        System.out.println("edad: "+ edad);
        System.out.println("tiene discapacida: "+tieneDiscapcidad);
        System.out.println("Tarifa: "+ calcularTarifa());
        System.out.println("saldo: "+ saldo);
        System.out.println("Viajes realizados: "+ viajesRealizados);
    }


}