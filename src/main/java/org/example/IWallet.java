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
    void depositar(double cantidad);
    boolean retirarSaldo(double cantidad);
    boolean convertirMoneda(double cantidad, String desdeMoneda);
}
