package pagamentoCartao_test;

import java.math.BigDecimal;
import java.util.Scanner;

import java.math.BigDecimal; // Importa a classe para lidar com números decimais com precisão (como valores em dinheiro).
import java.util.Scanner; // Importa a classe Scanner, usada para ler a entrada do usuário (o que você digita no teclado).
import cinema.pagamentocartao.PagamentoCartao; // Importa a classe PagamentoCartao que criamos (ou testamos) anteriormente.
import org.springframework.boot.SpringApplication; // Parte do Spring Boot, usada para rodar a aplicação.
import org.springframework.boot.autoconfigure.SpringBootApplication; // Anotação que configura a aplicação Spring Boot automaticamente.

@SpringBootApplication // Esta anotação é do Spring Boot e indica que esta é a classe principal da sua aplicação.
public class MainApplication { // Esta é a classe principal onde o programa começa a rodar.

    public static void main(String[] args) { // Este é o método principal onde a execução do programa começa.
        SpringApplication.run(MainApplication.class, args); // Inicia a aplicação Spring Boot.
        Scanner scanf = new Scanner(System.in); // Cria um objeto Scanner para ler o que o usuário digita no console.

        BigDecimal valorTotal = new BigDecimal("50.00"); // Define o valor total da compra como R$ 50,00.

        System.out.print("Digite o número do cartão: "); // Pede ao usuário para digitar o número do cartão.
        String numeroCartao = scanf.nextLine(); // Lê e guarda o número do cartão digitado pelo usuário.

        System.out.print("Digite a validade (MM/AA): "); // Pede ao usuário para digitar a validade do cartão.
        String dataValidade = scanf.nextLine(); // Lê e guarda a validade digitada.

        System.out.print("Digite o CVV: "); // Pede ao usuário para digitar o CVV.
        String cvv = scanf.nextLine(); // Lê e guarda o CVV digitado.

        System.out.print("Digite o nome do titular: "); // Pede ao usuário para digitar o nome do titular.
        String nomeTitular = scanf.nextLine(); // Lê e guarda o nome do titular digitado.

        int quantidadeParcelas; // Declara uma variável para a quantidade de parcelas.
        do { // Inicia um laço 'do-while' para garantir que a quantidade de parcelas seja válida.
            System.out.print("Digite a quantidade de parcelas (0 ou 1 para à vista, máximo 5): "); // Pede a quantidade de parcelas.
            quantidadeParcelas = scanf.nextInt(); // Lê a quantidade de parcelas digitada.

            if (quantidadeParcelas < 0 || quantidadeParcelas > 5) { // Verifica se a quantidade de parcelas está fora do limite permitido (0 a 5).
                System.out.println("Número inválido de parcelas! Deve ser entre 0 e 5."); // Se inválido, exibe uma mensagem de erro.
            }
        } while (quantidadeParcelas < 0 || quantidadeParcelas > 5); // Repete o laço enquanto a quantidade de parcelas for inválida.


        // Cria um novo objeto PagamentoCartao com as informações que o usuário digitou.
        PagamentoCartao pagamento = new PagamentoCartao(
                numeroCartao, // Número do cartão.
                dataValidade, // Data de validade.
                cvv, // CVV.
                nomeTitular, // Nome do titular.
                quantidadeParcelas, // Quantidade de parcelas escolhida.
                BigDecimal.ZERO, // Valor inicial da parcela (será calculado pela classe PagamentoCartao).
                valorTotal // Valor total da compra.
        );

        pagamento.calcularValorParcela(); // Chama o método da classe PagamentoCartao para calcular o valor de cada parcela.

        System.out.println("\nPagamento efetuado com sucesso:"); // Exibe uma mensagem de sucesso.
        System.out.println("Cartão: " + pagamento.getNumeroCartao()); // Mostra o número do cartão.
        System.out.println("Titular: " + pagamento.getNomeTitular()); // Mostra o nome do titular.
        System.out.println("Validade: " + pagamento.getDataValidade()); // Mostra a validade do cartão.
        System.out.println("Quantidade de parcelas: " + pagamento.getQuantidadeParcelas()); // Mostra a quantidade final de parcelas (já ajustada se for o caso).
        System.out.println("Valor total: R$ " + pagamento.getValorTotal()); // Mostra o valor total.
        System.out.println("Valor de cada parcela: R$ " + pagamento.getValorParcela()); // Mostra o valor de cada parcela.

        scanf.close(); // Fecha o Scanner para liberar recursos.

    }
}
