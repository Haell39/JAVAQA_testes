package CalculadoraTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraUtilsTest {

    @Test
    void testSoma() {
        assertEquals(6, CalculadoraUtils.calcular("+", new double[]{1, 2, 3}));
    }

    @Test
    void testSubtracao() {
        assertEquals(-4, CalculadoraUtils.calcular("-", new double[]{1, 2, 3}));
    }

    @Test
    void testMultiplicacao() {
        assertEquals(6, CalculadoraUtils.calcular("*", new double[]{1, 2, 3}));
    }

    @Test
    void testDivisao() {
        assertEquals(2, CalculadoraUtils.calcular("/", new double[]{8, 2, 2}));
    }

    @Test
    void testDivisaoPorZero() {
        assertThrows(IllegalArgumentException.class, () -> CalculadoraUtils.calcular("/", new double[]{5, 0}));
    }

    @Test
    void testOperacaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> CalculadoraUtils.calcular("%", new double[]{1, 2}));
    }
}
