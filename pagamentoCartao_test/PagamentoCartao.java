package pagamentoCartao_test;

import org.springframework.stereotype.Component; // Importa uma anotação do Spring para marcar esta classe como um "componente" gerenciável.

import java.math.BigDecimal; // Importa a classe BigDecimal para lidar com valores monetários de forma precisa.

public class PagamentoCartao { // Declara a classe PagamentoCartao, que representa um pagamento feito com cartão.
    private String numeroCartao; // Armazena o número do cartão (privado para segurança).
    private String dataValidade; // Armazena a data de validade do cartão.
    private String cvv; // Armazena o CVV (código de segurança) do cartão.
    private String nomeTitular; // Armazena o nome do titular do cartão.
    private int quantidadeParcelas; // Armazena a quantidade de parcelas selecionada pelo usuário.
    private BigDecimal valorParcela; // Armazena o valor de cada parcela.
    private BigDecimal valorTotal; // Armazena o valor total da compra.
    private static final int MAX_PARCELAS = 5; // Define uma constante para o número máximo de parcelas permitidas (5).

    public PagamentoCartao () {
        // Construtor vazio. Permite criar um objeto PagamentoCartao sem passar dados inicialmente.
    }

    public PagamentoCartao(String numeroCartao, String dataValidade, String cvv, String nomeTitular, int quantidadeParcelas, BigDecimal valorParcela, BigDecimal valorTotal) {
        // Construtor completo. Usado para criar um objeto PagamentoCartao já com todos os dados.
        this.numeroCartao = numeroCartao;
        this.dataValidade = dataValidade;
        this.cvv = cvv;
        this.nomeTitular = nomeTitular;
        this.quantidadeParcelas = quantidadeParcelas;
        this.valorParcela = valorParcela;
        this.valorTotal = valorTotal;
    }

    // --- Métodos Getters e Setters ---
    // São métodos padrão para acessar (get) e modificar (set) os valores das propriedades da classe.
    // Eles permitem que outras partes do programa interajam com os dados do cartão de forma controlada.

    public String getNumeroCartao() { return numeroCartao; }
    public void setNumeroCartao(String numeroCartao) { this.numeroCartao = numeroCartao; }

    public String getDataValidade() { return dataValidade; }
    public void setDataValidade(String dataValidade) { this.dataValidade = dataValidade; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public String getNomeTitular() { return nomeTitular; }
    public void setNomeTitular(String nomeTitular) { this.nomeTitular = nomeTitular; }

    public int getQuantidadeParcelas() { return quantidadeParcelas; }
    public void setQuantidadeParcelas(int quantidadeParcelas) { this.quantidadeParcelas = quantidadeParcelas; }

    public BigDecimal getValorParcela() { return valorParcela; }
    public void setValorParcela(BigDecimal valorParcela) { this.valorParcela = valorParcela; }

    public BigDecimal getValorTotal() { return valorTotal; }
    public void setValorTotal(BigDecimal valorTotal) { this.valorTotal = valorTotal; }

    // --- Lógica de Negócio ---

    public void calcularValorParcela() {
        // Regra: Se a quantidade de parcelas for 0 ou negativa, considera-se 1 parcela (pagamento à vista).
        int parcelas = quantidadeParcelas <= 0 ? 1 : quantidadeParcelas;

        // Regra: Se a quantidade de parcelas exceder o limite máximo (MAX_PARCELAS), ajusta para o máximo.
        if(parcelas > MAX_PARCELAS) {
            parcelas = MAX_PARCELAS;
        }

        // Atualiza a quantidade de parcelas no objeto com o valor final ajustado.
        this.quantidadeParcelas = parcelas;

        // Calcula o valor de cada parcela: valor total dividido pela quantidade de parcelas.
        // O "2" define 2 casas decimais e "BigDecimal.ROUND_HALF_UP" é o método de arredondamento.
        this.valorParcela = valorTotal.divide(new BigDecimal(parcelas), 2, BigDecimal.ROUND_HALF_UP);
    }
}