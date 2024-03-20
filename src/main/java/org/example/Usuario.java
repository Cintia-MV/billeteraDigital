package org.example;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private int id;
    private String nombre;
    private AlfiWallet wallet;

    //public Usuario() {
    //}

    //Constructor con parametros
    public Usuario(int id, String nombre, AlfiWallet wallet) {
        this.id = id;
        this.nombre = nombre;
        wallet = new AlfiWallet();
    }

    public Usuario(){
        wallet = new AlfiWallet();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public AlfiWallet getWallet() {
        return wallet;
    }

    public void setWallet(AlfiWallet wallet) {
        this.wallet = wallet;
    }



    //Método para crear usuario
    public void crearUsuario(){
        Scanner scanUsuario = new Scanner(System.in);

        id = (int) (Math.random() * 100000);
        System.out.println("Ingrese nombre de cliente: ");
        nombre = scanUsuario.nextLine();

        /*System.out.println("Ingrese saldo inicial de la cuenta: ");
        double saldo = scanUsuario.nextDouble();
        wallet.setSaldo(saldo);
        String transaccion = "Apertura de cuenta";
        List<String> transacciones = wallet.getTransacciones();
        transacciones.add(transaccion + saldo);
        wallet.setTransacciones(transacciones);*/

        System.out.println("Cuenta creada con los siguientes datos: ");
        System.out.println("Número de cuenta: " +id);
        System.out.println("Nombre cliente: " +nombre);
        //System.out.println("Tipo transacción: " +transaccion);
        //System.out.println("Saldo inicial: " +wallet.obtenerSaldo());
        //System.out.println(wallet.getTransacciones());
    }


    //Método to String
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
