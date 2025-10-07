package com.example.udemy_apirest_prod.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {

    @Test
    void testSuma() {
        int resultado = 5 + 3;
        assertEquals(8, resultado, "La suma debe ser 8");
    }

    @Test
    void testResta() {
        int resultado = 10 - 4;
        assertEquals(6, resultado, "La resta debe ser 6");
    }

    @Test
    void testMultiplicacion() {
        int resultado = 7 * 3;
        assertEquals(21, resultado, "La multiplicación debe ser 21");
    }

    @Test
    void testDivision() {
        int resultado = 20 / 5;
        assertEquals(4, resultado, "La división debe ser 4");
    }

    @Test
    void testModulo() {
        int resultado = 17 % 5;
        assertEquals(2, resultado, "El módulo debe ser 2");
    }
}
