package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* @author Cintia Muñoz Valdés
* @version 1.0
* */
public class Main {
    //Método principal dónde se ejecuta la aplicación
    public static void main(String[] args) {
        List<String> transacciones = new ArrayList<>();
        transacciones.add("transaccion 1");
        Usuario usuario1 = new Usuario(1, "juan", new AlfiWallet());
        AlfiWallet alfi = new AlfiWallet();


        Scanner scan = new Scanner(System.in);
        int opcion;

        //Instancio las clases


        //Menú de opciones
        do {
            System.out.println("********************");
            System.out.println("Menú:");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Ver saldo disponible");
            System.out.println("3. Ingresar dinero");
            System.out.println("4. Retirar dinero");
            System.out.println("5. Convertir saldo a otro tipo de moneda");
            System.out.println("6. Finalizar programa");
            System.out.print("Ingrese una opción: ");
            opcion = scan.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Crear cuenta");
                    break;
                case 2:
                    System.out.println("El saldo disponible es: " + alfi.obtenerSaldo());
                    break;
                case 3:
                    alfi.depositar(500);
                    break;
                case 4:
                    alfi.retirarSaldo(600);
                    break;
                case 5:
                    //alfi.convertirMoneda();
                    break;
                case 6:
                    System.out.println("******************");
                    System.out.println("Programa finalizado");
                    break;
                default:
                    System.out.println("Debe ingresar un número del menú (entre 1 a 6). Intente nuevamente.");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println(" ");
            }
            System.out.println();
        } while (opcion != 6);














    }
}

