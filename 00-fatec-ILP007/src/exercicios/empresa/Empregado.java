package exercicios.empresa;

import java.math.BigDecimal;
import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class Empregado implements Cloneable {

    private static final int CODE = 100;
    private static int PROX_COD = CODE;

    private final int codigo;
    private String nome;
    private String departamento;
    private BigDecimal salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Empregado(String nome) {
        this.codigo = PROX_COD;
        this.nome = nome;

        PROX_COD++;
    }

    public Empregado(String nome, String departamento) {
        this.nome = nome;
        this.codigo = PROX_COD;
        this.departamento = departamento;
        this.salario = new BigDecimal("0.00");

        PROX_COD++;
    }

    public Empregado(String nome, String departamento, BigDecimal salario) {
        this.nome = nome;
        this.codigo = PROX_COD;
        this.departamento = departamento;
        this.salario = salario;

        PROX_COD++;
    }

    public static int totalFuncionario() {
        return PROX_COD - CODE;
    }

    public static String getDepartamento(Empregado empregado) {
        return empregado.departamento;
    }

    public Empregado(Empregado empregado) {

        if (empregado == null) throw new IllegalArgumentException("Empregado não pode ser nulo");

        this.codigo = (int) verifyAndCopy(empregado.codigo);
        this.nome = (String) verifyAndCopy(empregado.nome);
        this.departamento = (String) verifyAndCopy(empregado.departamento);
        this.salario = (BigDecimal) verifyAndCopy(empregado.salario);

        PROX_COD++;
    }

    @Override
    public Object clone() {
        Empregado clone = null;

        try {
            clone = new Empregado(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Empregado that = (Empregado) obj;

        return Objects.equals(this.codigo, that.codigo)
                && Objects.equals(this.nome, that.nome)
                && Objects.equals(this.departamento, that.departamento)
                && Objects.equals(this.salario, that.salario);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + Integer.hashCode(codigo);
        hash *= prime + String.valueOf(nome).hashCode();
        hash *= prime + String.valueOf(departamento).hashCode();
        hash *= prime + Objects.hashCode(salario);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return String.format("""
                {
                  "Nome": "%s",
                  "Salario": %.2f,
                  "Codigo": %d,
                  "Departamento": "%s"
                }""", nome, salario, codigo, departamento);
    }
}