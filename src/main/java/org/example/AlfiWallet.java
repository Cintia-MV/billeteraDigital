package org.example;

import java.util.List;
import java.util.Scanner;

public class AlfiWallet implements IWallet{
    //Atributos de la clase AlfiWallet
    private double saldo;
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
    public double getSaldo() {
        return saldo;
    }

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

        System.out.println("dinero ingresado " +cantidad);
        double resultado = saldo + cantidad;
        System.out.println(resultado);

    }

    @Override
    public boolean retirarSaldo(double cantidad) {
        return false;
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
