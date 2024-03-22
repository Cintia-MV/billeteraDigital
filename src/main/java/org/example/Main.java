package org.example;
import java.util.List;
import java.util.Scanner;

/**
 * @author Cintia Muñoz Valdés
 * @version 1.0
 * */
public class Main {
    //Método principal dónde se ejecuta la aplicación
    public static void main(String[] args) {

        //Declaro variables globales
        int opcion;
        double cantidad;
        String cantidadString;

        //Instancias de clases
        Scanner scan = new Scanner(System.in);
        Usuario user = new Usuario();

        //Creación de usuario al llamar al método crearUsuario()
        System.out.println("********************************");
        System.out.println("CREACIÓN DE CUENTA");
        System.out.println("********************************\n");
        user.crearUsuario();

        //Menú principal. Se presentan las opciones del menú y se solicita al usuario que ingrese el número según la opción necesaria
        do {
            System.out.println("#############################");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("#############################");
            System.out.println("1. Ver saldo disponible");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Convertir monto a ingresar a otra divisa");
            System.out.println("5. Historial de transacciones");
            System.out.println("6. Cerrar Sesión");
            System.out.print("Ingrese una opción: ");
            String input = scan.nextLine();

            //Agrego try-catch para validar que sólo se ingresen datos numéricos
            try {
                opcion = Integer.parseInt(input); //Parsear variable a int

                switch (opcion) {

                    case 1:
                        // Ver saldo disponible llamando al método obtenerSaldo
                        System.out.println("\n*****************");
                        System.out.println("SALDO");
                        System.out.println("Cliente: "+user.getNombre());
                        System.out.println("Número de cuenta: "+user.getNroCuenta());
                        System.out.println("El saldo disponible es: " + user.getWallet().obtenerSaldo());
                        break;

                    case 2:
                        // Ingresar dinero llamando al método depositar
                        System.out.println("\n*****************");
                        System.out.println("DEPOSITAR DINERO A LA CUENTA");
                        System.out.println("Cliente: "+user.getNombre());
                        System.out.println("Número de cuenta: "+user.getNroCuenta());
                        System.out.println("Ingrese monto a depositar: ");
                        cantidadString = scan.nextLine();
                        //Este while es para validar que el valor ingresado sea un número y que no dejen en blanco
                        while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?") || cantidadString.equals("0")) {
                            System.out.println("Debe ingresa sólo números enteros positivos");
                            cantidadString = scan.nextLine();
                        }
                        cantidad = Double.parseDouble(cantidadString); //Se transforma el string ingresado a double
                        user.getWallet().depositar(cantidad); //Llamada al método
                        break;

                    case 3:
                        // Retirar dinero a traves del método retirarSaldo
                        System.out.println("\n*****************");
                        System.out.println("RETIRAR DINERO DESDE LA CUENTA");
                        System.out.println("Cliente: "+user.getNombre());
                        System.out.println("Número de cuenta: "+user.getNroCuenta());
                        System.out.println("Ingrese monto a retirar: ");
                        cantidadString = scan.nextLine();

                        while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?")) {
                            System.out.println("Debe ingresa sólo números enteros positivos");
                            cantidadString = scan.nextLine();
                        }
                        cantidad = Double.parseDouble(cantidadString);
                        user.getWallet().retirarSaldo(cantidad);
                        break;

                    case 4:
                        // Convertir monto a otra divisa
                        System.out.println("\n*****************");
                        System.out.println("CONVERSOR DE DIVISAS");
                        System.out.println("Cliente: "+user.getNombre());
                        System.out.println("Número de cuenta: "+user.getNroCuenta());
                        System.out.println("Ingrese la cantidad a convertir: ");
                        cantidadString = scan.nextLine();

                        while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?")) {
                            System.out.println("Debe ingresa sólo números enteros positivos");
                            cantidadString = scan.nextLine();
                        }
                        cantidad = Double.parseDouble(cantidadString);
                        user.getWallet().convertirMoneda(cantidad, "CLP");
                        break;

                    case 5:
                        // Historial de transacciones realizadas por el cliente
                        System.out.println("\n------------------------------------");
                        System.out.println("Cliente: "+user.getNombre());
                        System.out.println("Número de cuenta: "+user.getNroCuenta());
                        List<String> historial = user.getWallet().obtenerTransacciones();
                        System.out.println("Historial de transacciones: "+historial);
                        System.out.println("------------------------------------\n");
                        break;
                    case 6:
                        // Cerrar sesión
                        System.out.println("******************");
                        System.out.println("Sesión cerrada con éxito");
                        break;

                    default:
                        System.out.println("Debe ingresar un número del menú (entre 1 a 6). Intente nuevamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor numérico para la opción del menú.");
                opcion = 7;
            }
            System.out.println();
        } while (opcion != 6);
    }
}