package exercicios.escola;

import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class PessoaFisica extends Pessoa implements Cloneable {

    private String cpf;
    private String rg;

    public PessoaFisica(String nome,
                        String endereco,
                        String cpf,
                        String rg) {
        super(nome, endereco);
        this.cpf = cpf;
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public PessoaFisica(PessoaFisica modelo) {
        super(modelo);

        if (modelo == null) throw new IllegalArgumentException("Cópia não pode ser nula");

        super.setNome((String) verifyAndCopy(modelo.getNome()));
        super.setEndereco((String) verifyAndCopy(modelo.getEndereco()));

        this.cpf = (String) verifyAndCopy(modelo.cpf);
        this.rg = (String) verifyAndCopy(modelo.rg);
    }

    @Override
    public Object clone() {
        PessoaFisica clone = null;

        try {
            clone = new PessoaFisica(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        PessoaFisica that = (PessoaFisica) o;

        return super.equals(o) &&
                Objects.equals(this.cpf, that.cpf) &&
                Objects.equals(this.rg, that.rg);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = super.hashCode();

        hash *= prime + ((this.cpf == null) ? 0 : this.cpf.hashCode());
        hash *= prime + ((this.rg == null) ? 0 : this.rg.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n"
                + "  \"nome\": \"" + getNome() + "\",\n"
                + "  \"endereco\": \"" + getEndereco() + "\",\n"
                + "  \"cpf\": \"" + this.cpf + "\",\n"
                + "  \"rg\": \"" + this.rg + "\"\n"
                + "}";
    }

}
