package exercicios.escola;

import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class Aluno extends PessoaFisica implements Cloneable {

    private String matricula;
    private String curso;

    public Aluno(String nome,
                 String endereco,
                 String rg,
                 String cpf,
                 String matricula,
                 String curso) {
        super(nome, endereco, rg, cpf);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Aluno(Aluno modelo) {
        super(modelo);

        this.matricula = (String) verifyAndCopy(modelo.matricula);
        this.curso = (String) verifyAndCopy(modelo.curso);
    }

    @Override
    public Object clone() {
        Aluno clone = null;

        try {
            clone = new Aluno(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Aluno that = (Aluno) o;

        return super.equals(o) &&
                Objects.equals(this.matricula, that.matricula) &&
                Objects.equals(this.curso, that.curso);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = super.hashCode();

        hash *= prime + ((this.matricula == null) ? 0 : this.matricula.hashCode());
        hash *= prime + ((this.curso == null) ? 0 : this.curso.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"nome\": \"" + getNome() + "\",\n" +
                "  \"endereco\": \"" + getEndereco() + "\",\n" +
                "  \"cpf\": \"" + getCpf() + "\",\n" +
                "  \"rg\": \"" + getRg() + "\",\n" +
                "  \"matricula\": \"" + this.matricula + "\",\n" +
                "  \"curso\": \"" + this.curso + "\"\n" +
                "}";
    }
}