package org.example;

import java.util.List;
import java.util.Scanner;

public class AlfiWallet implements IWallet{
    //Atributos de la clase AlfiWallet
    private double saldo = 500;
    private List<String> transacciones;
    private Scanner scan;

    //Constructor vacio
    public AlfiWallet() {
    }

    //Constructor con ambos atributos
    public AlfiWallet(double saldo, List<String> transacciones) {
        this.saldo = saldo;
        this.transacciones = transacciones;
    }

    //Getters y setters
    //public double getSaldo() {
      //  return saldo;
    //}

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
    @Override
    public double obtenerSaldo() { //Este es un getter, sólo mostrará el saldo

        return saldo;
    }


    @Override
    public void depositar(double cantidad) {
        System.out.println("Saldo Inicial: " + saldo);
        System.out.println("dinero ingresado " +cantidad);
        double resultado = saldo + cantidad;
        System.out.println("Saldo final: " + resultado);

    }

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
            System.out.println("Operación realizada con éxito: " + resultado);
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
