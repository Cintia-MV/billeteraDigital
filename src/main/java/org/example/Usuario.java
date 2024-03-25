package org.example;

import java.util.List;
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

    Scanner scanUsuario = new Scanner(System.in);

    /**
     * Método para crear un nuevo usuario.
     * Se solicita al usuario que ingrese su nombre y se genera un número de cuenta aleatorio.
     * Se realizan validaciones correspondientes
     */
    // Método para crear n cantidad de usuarios
    public static void crearUsuario(int cantidadUsuarios, Scanner scan, List<Usuario> usuarios) {
        String expRegular = "^[a-zA-ZñÑáéíóúÁÉÍÓÚüÜ\\- ']+$";

        for (int i = 0; i < cantidadUsuarios; i++) {
            System.out.println("********************************");
            System.out.println("CREACIÓN DE CUENTA - Usuario " + (i + 1));
            System.out.println("********************************\n");

            System.out.println("Ingrese nombre de cliente: ");
            String nombre = scan.nextLine();

            if (nombre.matches(expRegular)) {
                int nroCuenta = (int) (Math.random() * 100000);
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setNombre(nombre);
                nuevoUsuario.setNroCuenta(nroCuenta);
                usuarios.add(nuevoUsuario);
                System.out.println("\n::::::::::::::::::::::::::::");
                System.out.println("¡Cuenta creada con éxito!");
                System.out.println("Nombre cliente: " + nombre);
                System.out.println("Número de cuenta " + nroCuenta);
                System.out.println("::::::::::::::::::::::::::::\n");
            } else {
                System.out.println("Sólo se permite el ingreso de letras. Por favor ingrese el nombre nuevamente.\n");
                i--; // Repetir la misma iteración
            }
        }
    }

    public static void mostrarUsuarios(List<Usuario> usuarios) {
        System.out.println("\nUsuarios creados:");
        for (Usuario usuario : usuarios) {
            System.out.println("Nombre: " + usuario.getNombre() + ", Número de cuenta: " + usuario.getNroCuenta());
        }
    }

    public static Usuario buscarUsuario(List<Usuario> usuarios, int nroCuenta) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNroCuenta() == nroCuenta) {
                return usuario;
            }
        }
        return null; // Si no se encuentra el usuario
    }


}