package org.example;
/**
 * @author Cintia Muñoz Valdés
 * @version 1.0
 * Esta es la interfaz que utilizará la clase AlfiWallet que contiene métodos para implementar
 **/
public interface IWallet {
    //Método para obtener saldo
    double obtenerSaldo();
    void depositar(double cantidad);
    boolean retirarSaldo(double cantidad);
    boolean convertirMoneda(double cantidad, String desdeMoneda, String aMoneda);
}
