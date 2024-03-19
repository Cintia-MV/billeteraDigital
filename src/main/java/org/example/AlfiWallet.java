package org.example;

import java.util.List;
import java.util.Scanner;
/**
 * @author Cintia Muñoz Valdés
 * @version 1.0
 * La clase AlfiWallet implementa la interfaz IWallet que posee métodos para gestionar una billetera digital,
 * incluyendo depósitos, retiros, verificación de saldo y conversión de moneda.
 */
public class AlfiWallet implements IWallet{
    //Atributos de la clase AlfiWallet
    private double saldo = 500; //Cuando llenemos el arreglo hay que borrarle los 500
    private List<String> transacciones;
    private Scanner scan;

    //Constructor sólo con Scanner
    public AlfiWallet() {
        scan=  new Scanner(System.in);
    }

    //Constructor con ambos atributos
    public AlfiWallet(double saldo, List<String> transacciones) {
        this.saldo = saldo;
        this.transacciones = transacciones;
    }

    //Getters y setters
    //public double getSaldo() {return saldo;}
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
    /**
     * El método obtenerSaldo evuelve el saldo actual de la cuenta.
     */
    @Override
    public double obtenerSaldo() { //Este es un getter, sólo mostrará el saldo

        return saldo;
    }

    /**
     * El método depositar deposita un monto en la cuenta y muestra el saldo actualizado.
     * @param cantidad La cantidad que ingresa el usuario para depositar en la cuenta.
     */
    @Override
    public void depositar(double cantidad) {
        System.out.println("Saldo Inicial: " + saldo);
        System.out.println("Dinero ingresado " +cantidad);
        saldo += cantidad;
        System.out.println("Saldo final: " + saldo);

    }

    /**
     * El método retirarSaldo retira una cantidad de la cuenta y actualiza el saldo si es posible.
     * @param cantidad La cantidad que ingresa el usuario para retirar de la cuenta.
     * @return true si la operación se realiza con éxito, false si no se puede realizar.
     */
    @Override
    public boolean retirarSaldo(double cantidad) {

            if (cantidad <= 0) {
                System.out.println("El monto a retirar debe ser mayor a cero.");
                return false;
            }

            if (cantidad > saldo) {
                System.out.println("No tiene saldo suficiente para realizar esta transacción");
                System.out.println("Saldo actual " +saldo);
                return false;
            }

            double resultado = saldo - cantidad;
            System.out.println("Operación realizada con éxito.");
            System.out.println("Saldo inicial: " +saldo);
            System.out.println("Monto retirado: " +cantidad);
            System.out.println("Saldo final: " +resultado);
            return true;

    }

    /**
     * El método convertirMoneda convierte una cantidad de una moneda a otra.
     * @param cantidad     La cantidad que se va a convertir.
     * @param desdeMoneda   La moneda de origen.
     * @return true si la conversión se realiza con éxito, false si no se puede realizar.
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
                System.out.println(" ");
                System.out.println("SELECCIONE EL TIPO DE MONEDA AL QUE DESEA REALIZAR LA CONVERSIÓN: ");
                System.out.println("1. USD (dolar)");
                System.out.println("2. EUR (euro)");
                System.out.println("3. YUAN (China)");
                System.out.println("4. ARS (peso argentino)");
                System.out.println("5. VOLVER A MENÚ PRINCIPAL");
                aMoneda = scan.nextLine();

                try {
                    opcion = Integer.parseInt(aMoneda);
                    switch (opcion) {
                        case 1:
                            resultado = cantidad * 0.0010;
                            System.out.println(" ");
                            System.out.println(cantidad + desdeMoneda + " equivalen a " + resultado + " USD (dolares)");
                            break;
                        case 2:
                            resultado = cantidad * 0.00095;
                            System.out.println(" ");
                            System.out.println(cantidad + desdeMoneda + " equivalen a " + resultado + " EUR (euros)");
                            break;
                        case 3:
                            resultado = cantidad * 0.0075;
                            System.out.println(" ");
                            System.out.println(cantidad + desdeMoneda + " equivalen a " + resultado + " YUAN (China)");
                            break;
                        case 4:
                            resultado = cantidad * 0.88;
                            System.out.println(" ");
                            System.out.println(cantidad + desdeMoneda + " equivalen a " + resultado + " ARS pesos argentinos");
                            break;
                        case 5:
                            System.out.println("******************");
                            System.out.println("Volviendo a menú principal");
                            System.out.println("******************");
                            System.out.println(" ");
                            return true;
                        default:

                            System.out.println("Opción no disponible.");

                    }
                }catch(NumberFormatException e){
                    System.out.println("Error: Debe ingresar un valor numérico para la opción del menú.");
                    opcion = 6; // le doy un número que no está en el menú para que vuelva al ciclo y muestre el menú
                }
                System.out.println();
            }while (opcion != 5);
            return true;
        }


    @Override
    public String toString() {
        return "AlfiWallet{" +
                "saldo=" + saldo +
                ", transacciones=" + transacciones +
                '}';
    }
}
