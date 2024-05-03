package p1.q2;

public abstract class Pessoa {

    public String nome;
    public String CPF;

    public Pessoa(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public abstract void imprimeDados();
}

