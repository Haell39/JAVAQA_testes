package PessoaTest;

import PessoaTest.Pessoa;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void testMaiorDeIdade() {
        Pessoa pessoa = new Pessoa("João", 2000, 2024);
        assertTrue(pessoa.isMaiorDeIdade());
    }

    @Test
    void testMenorDeIdade() {
        Pessoa pessoa = new Pessoa("Maria", 2010, 2024);
        assertFalse(pessoa.isMaiorDeIdade());
    }

    @Test
    void testNomeEhString() {
        Pessoa pessoa = new Pessoa("João", 2000, 2024);
        assertInstanceOf(String.class, pessoa.getNome());
    }
}


