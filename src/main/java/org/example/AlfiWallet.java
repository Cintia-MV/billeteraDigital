package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author Cintia Muñoz Valdés
 * @version 1.0
 * La clase AlfiWallet implementa la interfaz IWallet que posee métodos para gestionar una billetera digital,
 * incluyendo depósitos, retiros, verificación de saldo, conversión de moneda e historial de transacciones.
 */
public class AlfiWallet implements IWallet{
    //Atributos de la clase AlfiWallet
    private double saldo;
    private List<String> transacciones;
    private Scanner scan;

    //Constructor con ambos atributos
    public AlfiWallet(double saldo, List<String> transacciones) {
        this.saldo = saldo;
        this.transacciones = transacciones;
    }

    //Constructor con instancia de Scanner y ArrayList
    public AlfiWallet() {
        scan =  new Scanner(System.in);
        transacciones = new ArrayList<>();
    }

    //Getters y setters
    public void setSaldo(double saldo) {

        this.saldo = saldo;
    }

    public void setTransacciones(List<String> transacciones) {

        this.transacciones = transacciones;
    }

    //Método obtenerTransacciones (Getter)
    public List<String> obtenerTransacciones() {

        return transacciones;
    }

    //Metodos implementados desde la interfaz
    /**
     * El método obtenerSaldo devuelve el saldo actual de la cuenta.
     */
    @Override
    public double obtenerSaldo() { //Este es un getter, sólo mostrará el saldo

        return saldo;
    }

    /**
     * El método depositar() deposita un monto en la cuenta y muestra el saldo actualizado.
     * @param cantidad La cantidad que ingresa el usuario para depositar en la cuenta. Está validado en el main
     *                 para que sólo se ingresen números enteros positivos, mayores a cero.
     */
    @Override
    public void depositar(double cantidad) {

        System.out.println("\n------------------------------------");
        System.out.println("Saldo Inicial: " + saldo);
        System.out.println("Dinero ingresado " +cantidad);
        saldo += cantidad; //Suma la cantidad al saldo
        System.out.println("Saldo final: " + saldo);
        System.out.println("------------------------------------\n");
        //Se agrega la cantidad depositada al historial de transacciones
        transacciones.add("Depósito: +" + cantidad);

    }

    /**
     * El método retirarSaldo retira una cantidad de la cuenta y actualiza el saldo si es posible.
     * @param cantidad La cantidad que ingresa el usuario para retirar de la cuenta.
     * @return true si la operación se realiza con éxito, false si no se puede realizar.
     * En caso que no tenga saldo o el monto a retirar es <= a cero, la operación se cancela y se le redirecciona al menú principal
     */
    @Override
    public boolean retirarSaldo(double cantidad) {

        if (cantidad <= 0) {
            System.out.println("El monto a retirar debe ser mayor a cero. Operación cancelada!");
            return false;
        }

        if (cantidad > saldo) {
            System.out.println("No tiene saldo suficiente para realizar esta transacción. Operación cancelada!");
            System.out.println("Saldo actual " +saldo);
            return false;
        }

        System.out.println("\n------------------------------------");
        System.out.println("Operación realizada con éxito.");
        System.out.println("Saldo inicial: " +saldo);
        System.out.println("Monto retirado: " +cantidad);
        saldo -= cantidad;
        System.out.println("Saldo final: " +saldo);
        System.out.println("------------------------------------\n");

        transacciones.add("Giro: -" + cantidad);
        return true;

    }

    /**
     * El método convertirMoneda convierte una cantidad de una moneda a otra.
     * @param cantidad     La cantidad que se va a convertir.
     * @param desdeMoneda   La moneda de origen.
     * @return true si la conversión se realiza con éxito, false si no se puede realizar.
     * En caso que no tenga saldo o el monto a retirar es <= a cero, la operación se cancela y se le redirecciona al menú principal
     */
    @Override
    public boolean convertirMoneda(double cantidad, String desdeMoneda) {
        String aMoneda;
        int opcion;
        double resultado;

        if (cantidad <= 0) {
            System.out.println("No se puede realizar la operación. El monto a convertir debe ser mayor a cero.");
            return false;
        }

        do {
            System.out.println("\nSELECCIONE EL TIPO DE MONEDA AL QUE DESEA REALIZAR LA CONVERSIÓN: ");
            System.out.println("1. USD (dolar)");
            System.out.println("2. EUR (euro)");
            System.out.println("3. YUAN (China)");
            System.out.println("4. ARS (peso argentino)");
            System.out.println("5. VOLVER A MENÚ PRINCIPAL");
            aMoneda = scan.nextLine();
            opcion = Integer.parseInt(aMoneda);
            try {

                switch (opcion) {
                    case 1:
                        //Convertir de peso chileno a dolar americano
                        resultado = cantidad * 0.0010;
                        System.out.println(" ");
                        System.out.println("\n------------------------------------");
                        System.out.println(cantidad + desdeMoneda + " equivalen a " + resultado + " USD (dolares)");
                        System.out.println("Saldo Inicial: " + saldo);
                        System.out.println("Dinero ingresado " +cantidad);
                        saldo += cantidad;
                        System.out.println("Saldo final: " + saldo);
                        System.out.println("El saldo final en la cuenta equivale a " +(saldo*0.0010)+ " USD (dolares)");
                        System.out.println("------------------------------------");
                        //Agrego la transacción a la lista
                        transacciones.add("Dinero ("+ desdeMoneda + ") cambiados a USD: +" + cantidad);
                        break;
                    case 2:
                        //Convertit de peso chileno a euros
                        resultado = cantidad * 0.00095;
                        System.out.println("\n------------------------------------");
                        System.out.println(cantidad + desdeMoneda + " equivalen a " + resultado + " EUR (euros)");
                        System.out.println("Saldo Inicial: " + saldo);
                        System.out.println("Dinero ingresado " +cantidad);
                        saldo += cantidad;
                        System.out.println("Saldo final: " + saldo);
                        System.out.println("El saldo final en la cuenta equivale a " +(saldo*0.00095) +" EUR (euros)");
                        System.out.println("------------------------------------");
                        //Agrego la transacción a la lista
                        transacciones.add("Dinero ("+ desdeMoneda + ") cambiado a EUR: +" + cantidad);
                        break;
                    case 3:
                        //Convertir de peso chileno a yuan
                        resultado = cantidad * 0.0075;
                        System.out.println("\n------------------------------------");
                        System.out.println(cantidad + desdeMoneda + " equivalen a " + resultado + " YUAN (China)");
                        System.out.println("Saldo Inicial: " + saldo);
                        System.out.println("Dinero ingresado " +cantidad);
                        saldo += cantidad;
                        System.out.println("Saldo final: " + saldo);
                        System.out.println("El saldo final en la cuenta equivale a " +(saldo*0.0075) +" YUAN (China)");
                        System.out.println("------------------------------------");
                        transacciones.add("Dinero ("+ desdeMoneda + ") cambiado a YUAN: +" + cantidad);
                        break;
                    case 4:
                        //Convertir de peso chileno a peso argentino
                        resultado = cantidad * 0.88;
                        System.out.println("\n------------------------------------");
                        System.out.println(cantidad + desdeMoneda + " equivalen a " + resultado + " (ARS pesos argentinos)");
                        System.out.println("Saldo Inicial: " + saldo);
                        System.out.println("Dinero ingresado " +cantidad);
                        saldo += cantidad;
                        System.out.println("Saldo final: " + saldo);
                        System.out.println("El saldo en la cuenta equivale a " +(saldo*0.88) +" ARS (pesos argentinos)");
                        System.out.println("------------------------------------");
                        transacciones.add("Dinero ("+ desdeMoneda + ") cambiado a ARS: +" + cantidad);
                        break;
                    case 5:
                        System.out.println("******************");
                        System.out.println("Volviendo a menú de transacciones");
                        System.out.println("******************\n");
                        return true;
                    default:
                        System.out.println("Opción no disponible.");
                }
            }catch(NumberFormatException e){
                System.out.println("Error: Debe ingresar un valor numérico para la opción del menú.");
                opcion = 6;
            }
            System.out.println();
            return true;
        }while(true);

    }

    /**
     * Método toString que imprime el objeto usuario
     * @return Una cadena que representa al objeto Usuario.
     */
    @Override
    public String toString() {
        return "AlfiWallet{" +
                "saldo=" + saldo +
                ", transacciones=" + transacciones +
                '}';
    }
}
