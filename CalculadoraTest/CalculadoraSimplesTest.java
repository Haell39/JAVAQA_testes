package CalculadoraTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraSimplesTest {

    @Test
    void testSomar() {
        CalculadoraSimples calc = new CalculadoraSimples();
        assertEquals(5, calc.somar(2, 3));
    }

    @Test
    void testSubtrair() {
        CalculadoraSimples calc = new CalculadoraSimples();
        assertEquals(1, calc.subtrair(3, 2));
    }

    @Test
    void testMultiplicar() {
        CalculadoraSimples calc = new CalculadoraSimples();
        assertEquals(6, calc.multiplicar(2, 3));
    }

    @Test
    void testDividir() {
        CalculadoraSimples calc = new CalculadoraSimples();
        assertEquals(2.0, calc.dividir(6, 3));
    }

    @Test
    void testDividirPorZero() {
        CalculadoraSimples calc = new CalculadoraSimples();
        assertThrows(IllegalArgumentException.class, () -> calc.dividir(5, 0));
    }
}