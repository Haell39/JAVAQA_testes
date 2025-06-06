package PessoaTest;

public class Pessoa {
    private String nome;
    private int anoNascimento;
    private int anoAtual;

    public Pessoa(String nome, int anoNascimento, int anoAtual) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoAtual = anoAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public int getAnoAtual() {
        return anoAtual;
    }

    public void setAnoAtual(int anoAtual) {
        this.anoAtual = anoAtual;
    }

    public boolean isMaiorDeIdade() {
        return (this.anoAtual - this.anoNascimento) >= 18;
    }

    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("João", 2000, 2024);

        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Maior de idade? " + (pessoa.isMaiorDeIdade() ? "Sim" : "Não"));

        Pessoa menor = new Pessoa("Maria", 2010, 2024);
        System.out.println("\nNome: " + menor.getNome());
        System.out.println("Maior de idade? " + (menor.isMaiorDeIdade() ? "Sim" : "Não"));
    }
}


