package exercicios.lista_1.q1;

import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

/*
Escreva uma classe cujos objetos representam alunos matriculados em uma disciplina. Cada objeto
dessa classe deve guardar os seguintes dados do aluno:
    1 - matrícula,
    2 - nome,
    3 -  2 notas de prova e
    4 - 1 nota de trabalho.

Escreva os seguintes métodos para esta classe:
     1 - media calcula a média final do aluno (cada prova tem peso 2,5 e o trabalho tem peso 2)
     2 - final calcula quanto o aluno precisa para a prova final (retorna zero se ele não for para a final)
 */
public class Aluno implements Cloneable {

    private String matricula;
    private String nome;
    private double notaProva1, notaProva2, notaTrabalho;

    public Aluno() {
    }

    public Aluno(String matricula, String nome) {

        if (matricula == null || matricula.isEmpty())
            throw new IllegalArgumentException("A matrícula não pode ser nula ou vazia.");

        this.matricula = matricula;
        this.nome = nome;
    }

    public Aluno(String matricula,
                 String nome,
                 double notaProva1,
                 double notaProva2,
                 double notaTrabalho) {

        if (notaProva1 < 0 || notaProva1 > 10)
            throw new IllegalArgumentException("A nota da prova 1 deve estar entre 0 e 10.");

        if (notaProva2 < 0 || notaProva2 > 10)
            throw new IllegalArgumentException("A nota da prova 2 deve estar entre 0 e 10.");

        if (notaTrabalho < 0 || notaTrabalho > 10)
            throw new IllegalArgumentException("A nota do trabalho deve estar entre 0 e 10.");

        if (matricula == null || matricula.isEmpty())
            throw new IllegalArgumentException("A matrícula não pode ser nula ou vazia.");

        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");

        this.matricula = matricula;
        this.nome = nome;
        this.notaProva1 = notaProva1;
        this.notaProva2 = notaProva2;
        this.notaTrabalho = notaTrabalho;
    }

    public double media() {
        return (this.notaProva1 * 2.5 + this.notaProva2 * 2.5 + this.notaTrabalho * 2) / 7;
    }

    public boolean isAprovado() {
        return media() >= 6;
    }

    public double mediaFinalNecessaria() {
        if (!isAprovado())
            return 10 - media();
        return 0;
    }

    public void setMatricula(String matricula) {
        if (matricula == null || matricula.isEmpty())
            throw new IllegalArgumentException("A matrícula não pode ser nula ou vazia.");

        this.matricula = matricula;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isEmpty())
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");

        this.nome = nome;
    }

    public void setNotaProva1(double notaProva1) {
        if (notaProva1 < 0 || notaProva1 > 10)
            throw new IllegalArgumentException("A nota da prova 1 deve estar entre 0 e 10.");

        this.notaProva1 = notaProva1;
    }

    public void setNotaProva2(double notaProva2) {
        if (notaProva2 < 0 || notaProva2 > 10)
            throw new IllegalArgumentException("A nota da prova 2 deve estar entre 0 e 10.");

        this.notaProva2 = notaProva2;
    }

    public void setNotaTrabalho(double notaTrabalho) {
        if (notaTrabalho < 0 || notaTrabalho > 10)
            throw new IllegalArgumentException("A nota do trabalho deve estar entre 0 e 10.");

        this.notaTrabalho = notaTrabalho;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public double getNotaProva1() {
        return notaProva1;
    }

    public double getNotaProva2() {
        return notaProva2;
    }

    public double getNotaTrabalho() {
        return notaTrabalho;
    }

    public Aluno(Aluno aluno) {
        if (aluno == null)
            throw new IllegalArgumentException("O aluno não pode ser nulo.");

        this.matricula = (String) verifyAndCopy(aluno.matricula);
        this.nome = (String) verifyAndCopy(aluno.nome);
        this.notaProva1 = (double) verifyAndCopy(aluno.notaProva1);
        this.notaProva2 = (double) verifyAndCopy(aluno.notaProva2);
        this.notaTrabalho = (double) verifyAndCopy(aluno.notaTrabalho);
    }

    @Override
    public Aluno clone() {

        Aluno clone = null;
        try {
            clone = new Aluno(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + (this.matricula == null ? 0 : this.matricula.hashCode());
        hash *= prime + (this.nome == null ? 0 : this.nome.hashCode());
        hash *= prime + Double.hashCode(this.notaProva1);
        hash *= prime + Double.hashCode(this.notaProva2);
        hash *= prime + Double.hashCode(this.notaTrabalho);

        if (hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Aluno that = (Aluno) obj;

        return Objects.equals(this.matricula, that.matricula) &&
                Objects.equals(this.nome, that.nome) &&
                Objects.equals(this.notaProva1, that.notaProva1) &&
                Objects.equals(this.notaProva2, that.notaProva2) &&
                Objects.equals(this.notaTrabalho, that.notaTrabalho);
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"matricula\": \"" + this.matricula + "\",\n" +
                "  \"nome\": \"" + this.nome + "\",\n" +
                "  \"notaProva1\": " + this.notaProva1 + ",\n" +
                "  \"notaProva2\": " + this.notaProva2 + ",\n" +
                "  \"notaTrabalho\": " + this.notaTrabalho + "\n" +
                "}";
    }
}
