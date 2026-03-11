package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
 Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void calcularTotalCompra() {
        assertEquals(100.0, main.calcularTotalCompra(20.0, 5));
    }

    @Test
    void compraConCero() {
        assertEquals(0.0, main.calcularTotalCompra(50.0, 0));
    }

    @Test
    void descuentoTotal() {
        assertEquals(0.0, main.aplicarDescuento(100.0, 100.0));
    }

    @Test
    void compraSinDescuento() {
        assertEquals(150.0, main.aplicarDescuento(150.0, 0.0));
    }

    @Test
    void descuentoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            main.aplicarDescuento(100.0, -10.0);
        });
    }
}