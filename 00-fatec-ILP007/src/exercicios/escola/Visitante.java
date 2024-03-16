package exercicios.escola;

import java.time.LocalDateTime;
import java.util.Objects;

public class Visitante extends PessoaFisica {

    private LocalDateTime inicioVisita;
    private LocalDateTime fimVisita;

    public Visitante(String nome,
                     String endereco,
                     String cpf,
                     String rg,
                     LocalDateTime inicioVisita,
                     LocalDateTime fimVisita) {
        super(nome, endereco, cpf, rg);
        this.inicioVisita = inicioVisita;
        this.fimVisita = fimVisita;
    }

    public LocalDateTime getInicioVisita() {
        return inicioVisita;
    }

    public void setInicioVisita(LocalDateTime inicioVisita) {
        this.inicioVisita = inicioVisita;
    }

    public LocalDateTime getFimVisita() {
        return fimVisita;
    }

    public void setFimVisita(LocalDateTime fimVisita) {
        this.fimVisita = fimVisita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Visitante that = (Visitante) o;

        return super.equals(o) &&
                Objects.equals(this.inicioVisita, that.inicioVisita) &&
                Objects.equals(this.fimVisita, that.fimVisita);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = super.hashCode();

        hash *= prime + ((this.inicioVisita == null) ? 0 : this.inicioVisita.hashCode());
        hash *= prime + ((this.fimVisita == null) ? 0 : this.fimVisita.hashCode());

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
                "  \"inicioVisita\": \"" + this.inicioVisita + "\",\n" +
                "  \"fimVisita\": \"" + this.fimVisita + "\"\n" +
                "}";
    }
}
