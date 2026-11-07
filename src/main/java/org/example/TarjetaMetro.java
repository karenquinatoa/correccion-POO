package org.example;

public class TarjetaMetro{
    private  String titular;
    private String cedula;
    private int edad;
    private boolean tieneDiscapacidad;
    private double saldo;
    private int viajesRealizados;
    private double totalRecargado;

    public static final double TARIFA_GENERAL = 0.45;


    public TarjetaMetro(){
        this.titular = "ANONIMO";
        this.cedula = "1111111111";
        this.edad = 30;
        this.tieneDiscapacidad = false;
        this.saldo = 0;

    }
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if (titular.isBlank()) {
            this.titular = "SIN NOMBRE";
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
            System.out.println("cedula incorrecta");
            this.cedula = "0000000000";
        }
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 5 && edad <= 110){
            this.edad = edad;
        }else {
            this.edad = 18;
        }
    }

    public boolean isTieneDiscapacidad() {
        return tieneDiscapacidad;
    }

    public void setTieneDiscapacidad(boolean tieneDiscapacidad) {
        this.tieneDiscapacidad = tieneDiscapacidad;
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

    public TarjetaMetro(String titular, String cedula, int edad, double saldo_inical, boolean tieneDiscapacidad  ){
        setTitular(titular);
        setCedula(cedula);
        setEdad(edad);
        setTieneDiscapacidad(tieneDiscapacidad);
        if (saldo_inical >= 0 && saldo_inical <= 40 ){
            this.saldo = saldo_inical;
        }else{
            System.out.println("El saldo inical esta fuera de rango");
            this.saldo = 0;
        }

    }

    public static void mostrarTarifas(){
        System.out.println("==Metro de quito tarifas ==");
        System.out.println("Personas con dispacidad: $0.10 (tiene prioridad sobre la edad)");
        System.out.println("De 5 a 17  años o de 65 en adelante: $ 0.22");
        System.out.println("Resto de usarios: $0.45");
        System.out.println("Reglas: ");
        System.out.println("Cada  recraga debe ser de $1 a $2");
        System.out.println("El saldo de la tarejta no puede superar los $40");
        System.out.println("Un viaje se permite cuando el saldo es mayor o igual a la tarifa");

    }

    public double  calcularTarifa(){
        if (tieneDiscapacidad){
            return 0.10;

        }else if ((edad >= 5 && edad <= 17) || edad >= 65 ){
            return 0.22;
        }else {
            return  TARIFA_GENERAL;
        }
    }

    public double calcularViajesDisponibles(){
        return  saldo / calcularTarifa();
    }

    public double calcularViajesDisponibles(double montoAdicional){
        return (saldo + montoAdicional) / calcularTarifa();
    }

    public boolean recargar(double monto){
        if (monto <1 || monto >20) {
            System.out.println("Monto no permitido");
            return  false;


        }else if (saldo + monto > 40){
            System.out.println("SUPERA EL SALDO MAXIMO");
            return false;

        }

        saldo += monto;
        totalRecargado += monto;
        System.out.println("El nuevo saldo es :$" + saldo);
        return  true;

    }

    public boolean pagarViaje(){
        if (saldo >= calcularTarifa()){
            saldo -= calcularTarifa();
            viajesRealizados += 1;
            System.out.println("ACCESO PERMITIDO");
            System.out.println("Pago exitoso, su saldo restante es : $"+ saldo);
            return  true;
        }else {
            System.out.println("saldo insufciente");
            return  false;
        }

    }
    public void mostrarInformacion(){
        System.out.println("titulat: "+ titular);
        System.out.println("cedula: "+ cedula);
        System.out.println("edad: "+ edad);
        System.out.println("Discapacidad: "+ tieneDiscapacidad);
        System.out.println("Tarifa aplicada: "+ calcularTarifa());
        System.out.println("Saldo: "+ saldo);
        System.out.println("Viajes realizados: "+ viajesRealizados);
        System.out.println("Total recargado: "+ totalRecargado);
    }





}