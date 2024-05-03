package p1.q2;

public class Aluno extends Pessoa {

    public String matricula;

    public Aluno(String nome, String CPF, String matricula) {
        super(nome, CPF);
        this.matricula = matricula;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Matrícula: " + matricula);
    }
}
