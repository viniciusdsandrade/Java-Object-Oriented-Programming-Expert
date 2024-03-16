package exercicios.escola;

import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class PessoaJuridica extends Pessoa implements Cloneable {

    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(String nome,
                          String endereco,
                          String cnpj,
                          String razaoSocial) {
        super(nome, endereco);
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public PessoaJuridica(PessoaJuridica copia) {
        super(copia);

        super.setNome((String) verifyAndCopy(copia.getNome()));
        super.setEndereco((String) verifyAndCopy(copia.getEndereco()));
        this.cnpj = (String) verifyAndCopy(copia.cnpj);
        this.razaoSocial = (String) verifyAndCopy(copia.razaoSocial);
    }

    @Override
    public Object clone() {
        PessoaJuridica clone = null;

        try {
            clone = new PessoaJuridica(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        PessoaJuridica that = (PessoaJuridica) o;

        return super.equals(o) &&
                Objects.equals(this.cnpj, that.cnpj) &&
                Objects.equals(this.razaoSocial, that.razaoSocial);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = super.hashCode();

        hash *= prime + ((this.cnpj == null) ? 0 : this.cnpj.hashCode());
        hash *= prime + ((this.razaoSocial == null) ? 0 : this.razaoSocial.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                " \"nome\": \"" + getNome() + "\",\n" +
                " \"endereco\": \"" + getEndereco() + "\",\n" +
                "  \"cnpj\": \"" + this.cnpj + "\",\n" +
                "  \"razaoSocial\": \"" + this.razaoSocial + "\"\n" +
                "}";
    }
}