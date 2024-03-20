package org.example;

import static org.junit.jupiter.api.Assertions.*;

class AlfiWalletTest {
    AlfiWallet alfi = new AlfiWallet();
    @org.junit.jupiter.api.Test
    void obtenerSaldo() {
        double resultadoObtenido = alfi.obtenerSaldo();
        double resultadoEsperado = 0;

        assertEquals(resultadoEsperado, resultadoObtenido, 0);
    }

    @org.junit.jupiter.api.Test
    void depositar() {
        double saldoInicial = alfi.obtenerSaldo(); //El saldo inicial es 0
        double cantidad = 100.0; //Cantidad de prueba para depositar
        double resultadoEsperado = saldoInicial+cantidad; //Sumo el saldo inicial + cantidad

        // Ejecución del método
        alfi.depositar(cantidad);

        double resultadoObtenido= alfi.obtenerSaldo(); //Llamo al getter de saldo para saber si se sumó la cantidad después de ejecutar el método

        // Comprobación
        assertEquals(resultadoEsperado, resultadoObtenido, 0);
    }
}