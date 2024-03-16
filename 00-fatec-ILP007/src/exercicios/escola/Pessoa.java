package exercicios.escola;

import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class Pessoa implements Cloneable {

    private String nome;
    private String endereco;

    public Pessoa(Pessoa pessoa, String cpf, String rg) {
        this.nome = pessoa.getNome();
        this.endereco = pessoa.getEndereco();
    }


    public Pessoa(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Pessoa(Pessoa copia) {
        if (copia == null) throw new IllegalArgumentException("Cópia não pode ser nula");

        this.nome = (String) verifyAndCopy(copia.nome);
        this.endereco = (String) verifyAndCopy(copia.endereco);
    }

    @Override
    public Object clone() {
        Pessoa clone = null;

        try {
            clone = new Pessoa(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        return Objects.equals(this.nome, pessoa.nome) &&
                Objects.equals(this.endereco, pessoa.endereco);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.nome == null) ? 0 : this.nome.hashCode());
        hash *= prime + ((this.endereco == null) ? 0 : this.endereco.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"nome\": \"" + this.nome + "\",\n" +
                "  \"endereco\": \"" + this.endereco + "\"\n" +
                "}";
    }
}