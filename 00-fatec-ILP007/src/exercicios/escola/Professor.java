package exercicios.escola;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class Professor extends PessoaFisica implements Cloneable {

    private LocalDate dataAdmissao;
    private String titulacao;
    private BigDecimal salario;
    private List<String> disciplinas;

    public Professor(String nome,
                     String endereco,
                     String cpf,
                     String rg,
                     LocalDate dataAdmissao,
                     String titulacao,
                     BigDecimal salario,
                     List<String> disciplinas) {
        super(nome, endereco, cpf, rg);
        this.dataAdmissao = dataAdmissao;
        this.titulacao = titulacao;
        this.salario = salario;
        this.disciplinas = new ArrayList<>(disciplinas);
    }

    public Professor(String nome,
                     String endereco,
                     String cpf,
                     String rg,
                     LocalDate dataAdmissao,
                     String titulacao,
                     BigDecimal salario) {
        super(nome, endereco, cpf, rg);
        this.dataAdmissao = dataAdmissao;
        this.titulacao = titulacao;
        this.salario = salario;
        this.disciplinas = new ArrayList<>();
    }

    public void addDisciplina(String disciplina) {
        this.disciplinas.add(disciplina);
    }

    public void addDisciplinas(List<String> disciplinas) {
        this.disciplinas.addAll(disciplinas);
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public List<String> getDisciplinas() {
        return disciplinas;
    }

    public Professor(Professor modelo) {
        super(modelo);

        if (modelo == null) throw new IllegalArgumentException("Cópia não pode ser nula");

        super.setNome((String) verifyAndCopy(modelo.getNome()));
        super.setEndereco((String) verifyAndCopy(modelo.getEndereco()));
        super.setCpf((String) verifyAndCopy(modelo.getCpf()));
        super.setRg((String) verifyAndCopy(modelo.getRg()));

        this.dataAdmissao = (LocalDate) verifyAndCopy(modelo.dataAdmissao);
        this.titulacao = (String) verifyAndCopy(modelo.titulacao);
        this.salario = (BigDecimal) verifyAndCopy(modelo.salario);
        this.disciplinas = new ArrayList<>(modelo.disciplinas);
    }

    @Override
    public Object clone() {
        Professor clone = null;

        try {
            clone = new Professor(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Professor that = (Professor) o;

        return super.equals(o) &&
                Objects.equals(this.dataAdmissao, that.dataAdmissao) &&
                Objects.equals(this.titulacao, that.titulacao) &&
                Objects.equals(this.salario, that.salario) &&
                Objects.equals(this.disciplinas, that.disciplinas);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = super.hashCode();

        hash *= prime + ((this.dataAdmissao == null) ? 0 : this.dataAdmissao.hashCode());
        hash *= prime + ((this.titulacao == null) ? 0 : this.titulacao.hashCode());
        hash *= prime + ((this.salario == null) ? 0 : this.salario.hashCode());
        hash *= prime + ((this.disciplinas == null) ? 0 : this.disciplinas.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"cpf\": \"" + getCpf() + "\",\n" +
                "  \"rg\": \"" + getRg() + "\",\n" +
                "  \"dataAdmissao\": \"" + this.dataAdmissao + "\",\n" +
                "  \"titulacao\": \"" + this.titulacao + "\",\n" +
                "  \"salario\": \"" + this.salario + "\",\n" +
                "  \"disciplinas\": " + this.disciplinas.toString() + "\n" +
                "}";
    }
}