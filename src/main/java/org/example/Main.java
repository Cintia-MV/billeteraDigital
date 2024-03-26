package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que contiene el método main y controla la ejecución de la aplicación de gestión de usuarios y transacciones.
 * Permite la creación de usuarios, la realización de transacciones y el cierre del programa.
 *
 * @author Cintia Muñoz Valdés
 * @version 1.0
 */
public class Main {
    /**
     * Método main ejecuta la aplicación.
     * Permite la interacción con el sistema a través de un menú de opciones.
     *
     */
    public static void main(String[] args) {

        //Declaración variables
        int opcion;

        //Instancias de clases
        Scanner scan = new Scanner(System.in);
        List<Usuario> usuarios = new ArrayList<>();

        do {
            System.out.println("#############################");
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("#############################");
            System.out.println("1. Crear usuarios");
            System.out.println("2. Lista de usuarios");
            System.out.println("3. Seleccionar usuario para realizar transacciones");
            System.out.println("4. Cerrar programa");
            System.out.print("Ingrese una opción: ");
            String input = scan.nextLine();

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1:
                        //Crear usuario
                        System.out.println("\n*************************************************************************************");
                        System.out.println("Se pueden crear usuarios de forma masiva o un sólo usuario, según la cantidad necesaria");
                        System.out.println("Ingrese la cantidad de usuarios que desea crear: ");
                        int cantidadUsuarios = Integer.parseInt(scan.nextLine());
                        Usuario.crearUsuario(cantidadUsuarios, scan, usuarios); //Llamada al métod
                        break;
                    case 2:
                        //Lista de usuarios
                        if (usuarios.isEmpty()) {
                            System.out.println("\nNo hay usuarios creados. Por favor, cree al menos un usuario.");
                        } else {
                            System.out.println("\n------------------------------------");
                            System.out.println("LISTA DE USUARIOS");
                            Usuario.mostrarUsuarios(usuarios);
                            System.out.println("------------------------------------\n");
                        }
                        break;
                    case 3:
                        //Seleccionar usuario
                        if (usuarios.isEmpty()) {
                            System.out.println("\nNo hay usuarios creados. Por favor, cree al menos un usuario.");
                        } else {
                            System.out.println("\n------------------------------------");
                            System.out.println("LISTA DE USUARIOS PARA SELECCIONAR");
                            Usuario.mostrarUsuarios(usuarios);
                            System.out.println("\n*************************************************************");
                            System.out.println("Ingrese el número de cuenta del usuario que desea seleccionar, " +
                                    "para realizar transacciones: ");
                            int seleccionUsuario = Integer.parseInt(scan.nextLine());
                            Usuario usuarioSeleccionado = Usuario.seleccionarUsuario(usuarios, seleccionUsuario);
                            System.out.println("------------------------------------\n");
                            if (usuarioSeleccionado != null) {
                                menuTransacciones(usuarioSeleccionado, scan);
                            } else {
                                System.out.println("\nUsuario no encontrado.");
                            }
                        }
                        break;
                    case 4:System.out.println("\n*****************");
                        System.out.println("Programa finalizado");
                        System.out.println("*****************");
                        break;
                    default:
                        System.out.println("\nDebe ingresar un número del menú (entre 1 a 4). Intente nuevamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n¡ERROR!");
                System.out.println("Debe ingresar un valor numérico. Intentelo nuevamente");
                opcion = 5;
            }
            System.out.println();
        } while (opcion != 4);
    }

    /**
     * Método que muestra el menú de transacciones y permite al usuario realizar diferentes operaciones con su cuenta.
     *
     * @param usuario El usuario seleccionado para realizar las transacciones.
     * @param scan    El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void menuTransacciones(Usuario usuario, Scanner scan) {
        //Declaración de variables
        double cantidad;
        String cantidadString;
        int opcion;

         do {
                System.out.println("#############################");
                System.out.println("MENÚ TRANSACCIONES");
                System.out.println("#############################");
                System.out.println("1. Ver saldo disponible");
                System.out.println("2. Ingresar dinero");
                System.out.println("3. Retirar dinero");
                System.out.println("4. Convertir divisa");
                System.out.println("5. Historial de transacciones");
                System.out.println("6. Volver al menú principal");
                System.out.print("Ingrese una opción: ");
                String input = scan.nextLine();

                //Try-catch para validar que sólo se ingresen datos numéricos
                try {
                    opcion = Integer.parseInt(input); //Parsear variable a int

                    switch (opcion) {

                        case 1:
                            //Mostrar saldo disponible
                            System.out.println("\n*****************");
                            System.out.println("SALDO");
                            System.out.println("Cliente: "+usuario.getNombre());
                            System.out.println("Número de cuenta: "+usuario.getNroCuenta());
                            System.out.println("El saldo disponible es: " + usuario.getWallet().obtenerSaldo());
                            break;
                        case 2:
                            // Ingresar dinero llamando al método depositar
                            System.out.println("\n*****************");
                            System.out.println("DEPOSITAR DINERO A LA CUENTA");
                            System.out.println("Cliente: "+usuario.getNombre());
                            System.out.println("Número de cuenta: "+usuario.getNroCuenta());
                            System.out.println("Ingrese monto a depositar: ");
                            cantidadString = scan.nextLine();
                            //Este while es para validar que el valor ingresado sea un número y que no dejen en blanco
                            while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?") || cantidadString.equals("0")) {
                                System.out.println("Debe ingresa sólo números enteros positivos");
                                cantidadString = scan.nextLine();
                            }
                            cantidad = Double.parseDouble(cantidadString); //Se transforma el string ingresado a double
                            usuario.getWallet().depositar(cantidad); //Llamada al método
                            break;

                        case 3:
                            // Retirar dinero a traves del método retirarSaldo
                            System.out.println("\n*****************");
                            System.out.println("RETIRAR DINERO DESDE LA CUENTA");
                            System.out.println("Cliente: "+usuario.getNombre());
                            System.out.println("Número de cuenta: "+usuario.getNroCuenta());
                            System.out.println("Ingrese monto a retirar: ");
                            cantidadString = scan.nextLine();

                            while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?")) {
                                System.out.println("Debe ingresa sólo números enteros positivos");
                                cantidadString = scan.nextLine();
                            }
                            cantidad = Double.parseDouble(cantidadString);
                            usuario.getWallet().retirarSaldo(cantidad);
                            break;

                        case 4:
                            // Convertir monto a otra divisa
                            System.out.println("\n*****************");
                            System.out.println("CONVERSOR DE DIVISAS");
                            System.out.println("Cliente: "+usuario.getNombre());
                            System.out.println("Número de cuenta: "+usuario.getNroCuenta());
                            System.out.println("Ingrese la cantidad a convertir: ");
                            cantidadString = scan.nextLine();

                            while (cantidadString.isEmpty() || !cantidadString.matches("\\d+(\\.\\d+)?")) {
                                System.out.println("Debe ingresa sólo números enteros positivos");
                                cantidadString = scan.nextLine();
                            }
                            cantidad = Double.parseDouble(cantidadString);
                            usuario.getWallet().convertirMoneda(cantidad, "CLP");
                            break;

                        case 5:
                            // Historial de transacciones realizadas por el cliente
                            System.out.println("\n------------------------------------");
                            System.out.println("Cliente: "+usuario.getNombre());
                            System.out.println("Número de cuenta: "+usuario.getNroCuenta());
                            List<String> historial = usuario.getWallet().obtenerTransacciones();
                            System.out.println("Historial de transacciones: "+historial);
                            System.out.println("------------------------------------\n");
                            break;
                        case 6:
                            // Volver al menú usuario
                            System.out.println("******************");
                            System.out.println("Volviendo a menú usuario");
                            break;

                        default: //En caso de ingresar un número que no esté en el menú
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