package org.example;

import java.util.Scanner;

/**
 * @author Cintia Muñoz Valdés
 * @version 1.0
 * Esta interfaz se implementará en la clase AlfiWallet que contiene métodos relacionados a transacciones bancarias
 **/
public interface IWallet {
    //Método para obtener saldo
    double obtenerSaldo();
    //Método para depositar
    void depositar(double cantidad);
    //Método para retirar saldo
    boolean retirarSaldo(double cantidad);
    //Método para convertir de pesos chilenos a otra divisa
    boolean convertirMoneda(double cantidad, String desdeMoneda);
}
