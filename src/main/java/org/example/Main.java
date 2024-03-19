package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
* @author Cintia Muñoz Valdés
* @version 1.0
* */
public class Main {
    //Método principal dónde se ejecuta la aplicación
    public static void main(String[] args) {

        //Estas instancias la tengo cómo pruebas, después hay que eliminarlas
        List<String> transacciones = new ArrayList<>();
        transacciones.add("transaccion 1");
        Usuario usuario1 = new Usuario(1, "juan", new AlfiWallet(20, Collections.singletonList("x")));



        //Declaro variables globales
        int opcion;
        double cantidad;
        String cantidadString;
        AlfiWallet alfi = new AlfiWallet();

        //Instancio las clases
        Scanner scan = new Scanner(System.in);

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
            String input = scan.nextLine();

            //Agrego try-catch para validar que sólo se ingresen datos numéricos
            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        System.out.println("Crear cuenta");
                        break;

                    case 2:
                        System.out.println(" ");
                        System.out.println("*****************");
                        System.out.println("SALDO");
                        System.out.println("El saldo disponible es: " + alfi.obtenerSaldo());
                        break;

                    case 3:
                        System.out.println(" ");
                        System.out.println("*****************");
                        System.out.println("DEPOSITAR DINERO A LA CUENTA");
                        System.out.println("Ingrese monto a depositar: ");
                        cantidadString = scan.nextLine();
                        //Este while es para validar que el valor ingresado sea un número y que no dejen en blanco
                        while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?")) {
                            System.out.println("Debe ingresa sólo números, no se admiten letras.");
                            cantidadString = scan.nextLine();
                        }
                        cantidad = Double.parseDouble(cantidadString); //Transformo el dato ingresado a double
                        alfi.depositar(cantidad); // ejecuta el método
                        break;

                    case 4:
                        System.out.println(" ");
                        System.out.println("*****************");
                        System.out.println("RETIRAR DINERO DESDE LA CUENTA");
                        System.out.println("Ingrese monto a retirar: ");
                        cantidadString = scan.nextLine();

                        while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?")) {
                            System.out.println("Debe ingresa sólo números, no se admiten letras.");
                            cantidadString = scan.nextLine();
                        }
                        cantidad = Double.parseDouble(cantidadString);
                        alfi.retirarSaldo(cantidad);
                        break;

                    case 5:
                        System.out.println(" ");
                        System.out.println("*****************");
                        System.out.println("CONVERSOR DE DIVISAS");
                        System.out.println("Ingrese la cantidad a convertir: ");
                        cantidadString = scan.nextLine();

                        while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?")) {
                            System.out.println("Debe ingresa sólo números, no se admiten letras.");
                            cantidadString = scan.nextLine();
                        }
                        cantidad = Double.parseDouble(cantidadString);
                        alfi.convertirMoneda(cantidad, "CLP");
                        break;

                    case 6:
                        System.out.println("******************");
                        System.out.println("Programa finalizado");
                        break;

                    default:
                        System.out.println("Debe ingresar un número del menú (entre 1 a 6). Intente nuevamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor numérico para la opción del menú.");
                opcion = 7; // le doy un número que no está en el menú para que vuelva al ciclo y muestre el menú
            }
            System.out.println();
        } while (opcion != 6);
    }
}