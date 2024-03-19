package org.example;

import java.util.List;
import java.util.Scanner;

public class AlfiWallet implements IWallet{
    //Atributos de la clase AlfiWallet
    private double saldo = 500;
    private List<String> transacciones;
    //private Scanner scan; eliminarlo si no me sirve

    //Constructor vacio
    public AlfiWallet() {
    }

    //Constructor con ambos atributos
    public AlfiWallet(double saldo, List<String> transacciones) {
        this.saldo = saldo;
        this.transacciones = transacciones;
    }

    //Getters y setters
    //public double getSaldo() {return saldo;}

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<String> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<String> transacciones) {
        this.transacciones = transacciones;
    }


    //Metodos implementados desde la interfaz
    /**
     * Devuelve el saldo actual de la cuenta.
     */
    @Override
    public double obtenerSaldo() { //Este es un getter, sólo mostrará el saldo

        return saldo;
    }

    /**
     * Deposita una cantidad en la cuenta y actualiza el saldo.
     *
     * @param cantidad La cantidad que ingresa el usuario para depositar en la cuenta.
     */
    @Override
    public void depositar(double cantidad) {
        System.out.println("Saldo Inicial: " + saldo);
        System.out.println("Dinero ingresado " +cantidad);
        double resultado = saldo + cantidad;
        System.out.println("Saldo final: " + resultado);

    }

    /**
     * Retira una cantidad de la cuenta y actualiza el saldo si es posible.
     *
     * @param cantidad La cantidad que ingresa el usuario para retirar de la cuenta.
     * @return true si la operación se realiza con éxito, false si no se puede realizar.
     */
    @Override
    public boolean retirarSaldo(double cantidad) {

            if (cantidad <= 0) {
                System.out.println("El monto a retirar debe ser mayor a cero");
                return false;
            }

            if (cantidad > saldo) {
                System.out.println("No tiene saldo suficiente para realizar esta transacción");
                return false;
            }

            double resultado = saldo - cantidad;
            System.out.println("Operación realizada con éxito.");
            System.out.println("Saldo inicial: " +saldo);
            System.out.println("Monto retirado: " +cantidad);
            System.out.println("Saldo final: " +resultado);
            return true;

    }

    @Override
    public boolean convertirMoneda(double cantidad, String desdeMoneda, String aMoneda) {
        return false;
    }

    @Override
    public String toString() {
        return "AlfiWallet{" +
                "saldo=" + saldo +
                ", transacciones=" + transacciones +
                '}';
    }
}
