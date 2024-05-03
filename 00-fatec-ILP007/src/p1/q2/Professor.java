package p1.q2;

public class Professor extends Pessoa {

    public int AnoDefesa;
    public String instituicao;

    public Professor(String nome, String CPF, int AnoDefesa, String instituicao) {
        super(nome, CPF);
        this.AnoDefesa = AnoDefesa;
        this.instituicao = instituicao;
    }

    @Override
    public void imprimeDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + CPF);
        System.out.println("Ano de Defesa: " + AnoDefesa);
        System.out.println("Instituição: " + instituicao);
    }
}
