package CalculadoraTest;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha a operação (+, -, *, /):");
        String operacao = scanner.nextLine();

        double resultado = 0;
        boolean primeiroNumero = true;

        System.out.println("Digite números (ou 'out' para sair e vê o resultado):");
        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("out")) {
                break;
            }
            try {
                double numero = Double.parseDouble(entrada);
                if (primeiroNumero) {
                    resultado = numero;
                    primeiroNumero = false;
                } else {
                    switch (operacao) {
                        case "+":
                            resultado += numero;
                            break;
                        case "-":
                            resultado -= numero;
                            break;
                        case "*":
                            resultado *= numero;
                            break;
                        case "/":
                            if (numero == 0) {
                                System.out.println("Divisão por zero não permitida.");
                                continue;
                            }
                            resultado /= numero;
                            break;
                        default:
                            System.out.println("Operação inválida.");
                            return;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número ou 'out'.");
            }
        }

        System.out.println("Resultado: " + resultado);
        scanner.close();
    }
}

// Testes
