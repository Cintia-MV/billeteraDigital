package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Cintia Muñoz Valdés
 * @version 1.0
 * Clase de prueba de métodos de la clase AlfiWallet a través de la clase usuario
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

    /**
     * Test unitario para el array de transacciones
     * Se realizan distintas transacciones y se comparan con el tamaño del arreglo o lista
     */
    @Test
    public void testListaTransacciones() {


        usuario.getWallet().setSaldo(5000.0);

        System.out.println("Historial de transacciones");
        usuario.getWallet().depositar(2000.0);
        usuario.getWallet().depositar(3000.0);
        usuario.getWallet().retirarSaldo(1000.0);

        assertEquals(3, usuario.getWallet().obtenerTransacciones().size());
    }

}