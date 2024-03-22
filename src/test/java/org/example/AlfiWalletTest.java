package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cintia Muñoz Valdés
 * @version 1.0
 * Clase de prueba para la clase AlfiWallet.
 * */
class AlfiWalletTest {
    //Instancia de la clase usuario
    Usuario usuario = new Usuario();

    /**
     * Test unitario para el método obtenerSaldo().
     * Se establece un saldo específico a través del set y se comprueba si se obtiene el saldo esperado.
     */
    @Test
    void obtenerSaldo() {
        usuario.getWallet().setSaldo(500000);
        double saldoEsperado = 500000;
        double saldoReal = usuario.getWallet().obtenerSaldo();

        assertEquals(saldoEsperado, saldoReal, 0);
    }

    /**
     * Test unitario para el método depositar().
     * Se establece un saldo inicial, se deposita una cantidad y se comprueba si el saldo se actualiza correctamente.
     */
    @Test
    void depositar() {
        usuario.getWallet().setSaldo(50000.0);
        double saldoInicial = usuario.getWallet().obtenerSaldo(); //El saldo inicial es 0
        double cantidad = 100000.0; //Cantidad de prueba para depositar
        double resultadoEsperado = saldoInicial+cantidad; //Suma el saldo inicial + cantidad

        // Ejecución del método
        usuario.getWallet().depositar(cantidad);
        //Se ejecuta el método obtenerSaldo después de ejecutar el método depositar, para confirmar que se realizó la operación correctamente
        double resultadoObtenido= usuario.getWallet().obtenerSaldo();

        // Comprobación
        assertEquals(resultadoEsperado, resultadoObtenido, 0);

    }
}