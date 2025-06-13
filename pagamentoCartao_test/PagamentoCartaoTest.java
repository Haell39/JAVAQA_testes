package pagamentoCartao_test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoCartaoTest {

    private PagamentoCartao pagamento;

    @BeforeEach
    void setUp() {
        pagamento = new PagamentoCartao(
                "1234 2312 6742 2242", // Número do cartão
                "12/25", // Data de validade
                "711", // CVV
                "Pedro", // Nome do titular
                3, // Quantidade de parcelas inicial
                BigDecimal.ZERO, // Valor da parcela (será calculado)
                new BigDecimal("50.00") // Valor total da compra
        );
    }

    @Test
    @DisplayName("Deve consultar se o valor de parcela está correto")
    void calcularValorParcela() {
        pagamento.calcularValorParcela();
        // Esperado: 30.00, Recebido: 16.67.
        // Resultado: FALHOU. O cálculo esperado (R$30,00) está incorreto para R$50,00 em 3 parcelas (R$16,67).
        assertEquals(new BigDecimal("30.00"), pagamento.getValorParcela(), "Valor da parcela incorreto");
        assertEquals(3, pagamento.getQuantidadeParcelas()); // Esperado: 3, Recebido: 3. PASSOU.
    }

    @Test
    @DisplayName("Quantidade de parcelas não deve ultrapassar o limite")
    void testQuantidadeParcelasLimite() {
        pagamento.setQuantidadeParcelas(7);
        pagamento.calcularValorParcela();
        // Resultado: PASSOU. A lógica do sistema ajustou para 5 ou menos, conforme esperado.
        assertTrue(pagamento.getQuantidadeParcelas() <= 5, "Parcelas devem ser no máximo 5");
    }

    @Test
    @DisplayName("Deve consultar o limite de parcelas e o valor")
    void testParcelamentoMaiorQueLimite() {
        pagamento.setQuantidadeParcelas(10); // Tenta 10 parcelas (maior que o limite)
        pagamento.calcularValorParcela();
        assertEquals(5, pagamento.getQuantidadeParcelas()); // Esperado: 5, Recebido: 5. PASSOU.
        // Esperado: 18.00, Recebido: 10.00.
        // Resultado: FALHOU. O valor de cada parcela para R$50,00 em 5x deveria ser R$10,00, não R$18,00.
        assertEquals(new BigDecimal("18.00"), pagamento.getValorParcela());
    }

    @Test
    @DisplayName("Deve consultar se o valor a vista está correto")
    void testPagamentoAVista() {
        pagamento.setQuantidadeParcelas(0);
        pagamento.calcularValorParcela();
        assertEquals(1, pagamento.getQuantidadeParcelas()); // Esperado: 1, Recebido: 1. PASSOU.
        assertEquals(new BigDecimal("50.00"), pagamento.getValorParcela()); // Esperado: 50.00, Recebido: 50.00. PASSOU.
        // Resultado: PASSOU. A lógica para pagamento à vista (0 ou 1 parcela) está correta.
    }

    @Test
    @DisplayName("Deve criar um pagamento com os dados corretos")
    void testConstrutorCompleto() {
        PagamentoCartao cartao = new PagamentoCartao(
                "1111 2222 3333 4444",
                "10/30",
                "322",
                "Maria", // Nome passado no construtor
                2,
                new BigDecimal("25.00"),
                new BigDecimal("50.00")
        );

        // Resultados para cada asserção:
        assertEquals("1111 2222 3333 4444", cartao.getNumeroCartao()); // PASSOU
        assertEquals("10/30", cartao.getDataValidade()); // PASSOU
        assertEquals("322", cartao.getCvv()); // PASSOU
        // Esperado: Leo, Recebido: Maria.
        // Resultado: FALHOU. O nome esperado no teste ("Leo") é diferente do nome usado na criação do objeto ("Maria").
        assertEquals("Leo", cartao.getNomeTitular());
        assertEquals(2, cartao.getQuantidadeParcelas()); // PASSOU
        assertEquals(new BigDecimal("25.00"), cartao.getValorParcela()); // PASSOU
        assertEquals(new BigDecimal("50.00"), cartao.getValorTotal()); // PASSOU
    }
}