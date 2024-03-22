package org.example;

import java.util.Scanner;

/**
 * @author Cintia Muñoz Valdés
 * @version 1.0
 * La clase Usuario representa a un cliente en el sistema bancario.
 */
public class Usuario {
    //Declaro los atributos de la clase
    private int nroCuenta;
    private String nombre;
    private AlfiWallet wallet;

    /**
     * Constructor de la clase Usuario con los siguientes parámetros.
     * @param nroCuenta El número de cuenta del usuario.
     * @param nombre El nombre del usuario.
     */
    public Usuario(int nroCuenta, String nombre) {
        this.nroCuenta = nroCuenta;
        this.nombre = nombre;
    }

    /**
     * Constructor exclusivo para instancia de clase AlfiWallet.
     * Inicializa el objeto wallet como una nueva instancia de AlfiWallet.
     */
    public Usuario() {

        wallet = new AlfiWallet();
    }

    //Getters y setters
    public int getNroCuenta() {

        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {

        this.nroCuenta = nroCuenta;
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


    /**
     * Método para crear un nuevo usuario.
     * Se solicita al usuario que ingrese su nombre y se genera un número de cuenta aleatorio.
     * Se realizan validaciones correspondientes
     */
    public void crearUsuario() {
        String expRegular = "^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\- ']+$";

        Scanner scanUsuario = new Scanner(System.in);
        do {
            System.out.println("Ingrese nombre de cliente: ");
            nombre = scanUsuario.nextLine();
            // Se valida que no se ingresen números, caracteres no válidos o espacios en blanco
            if (nombre.matches(expRegular)) {
                // Si el nombre es válido, se genera un número de cuenta aleatorio
                nroCuenta = (int) (Math.random() * 100000);
                System.out.println("\n::::::::::::::::::::::::::::");
                System.out.println("¡Cuenta creada con éxito!");
                System.out.println("Nombre cliente: " + nombre);
                System.out.println("Número de cuenta " + nroCuenta);
                System.out.println("::::::::::::::::::::::::::::\n");
            } else {
                System.out.println("Sólo se permite el ingreso de letras. Por favor ingrese el nombre nuevamente.\n");
            }
        } while (!nombre.matches(expRegular));
    }


    //Método to String
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + nroCuenta +
                ", nombre='" + nombre + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}