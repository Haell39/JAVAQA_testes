package CalculadoraTest;

public class CalculadoraUtils {
    public static double calcular(String operacao, double[] numeros) {
        if (numeros == null || numeros.length == 0) throw new IllegalArgumentException("Nenhum número fornecido");
        double resultado = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            switch (operacao) {
                case "+":
                    resultado += numeros[i];
                    break;
                case "-":
                    resultado -= numeros[i];
                    break;
                case "*":
                    resultado *= numeros[i];
                    break;
                case "/":
                    if (numeros[i] == 0) throw new IllegalArgumentException("Divisão por zero");
                    resultado /= numeros[i];
                    break;
                default:
                    throw new IllegalArgumentException("Operação inválida");
            }
        }
        return resultado;
    }
}
