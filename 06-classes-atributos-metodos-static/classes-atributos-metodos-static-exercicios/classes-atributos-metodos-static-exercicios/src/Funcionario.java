import java.util.Objects;

public class Funcionario {

    private final String nome;
    private final double salarioBruto;
    private final double imposto;

    public Funcionario(String nome, double salarioBruto, double imposto) {
        this.nome = nome;
        this.salarioBruto = salarioBruto;
        this.imposto = imposto;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getImposto() {
        return imposto;
    }

    public double netSalary() {
        return salarioBruto - imposto;
    }

    public void increaseSalary(double percentage) {
        double newSalary = salarioBruto + (salarioBruto * percentage / 100);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Double.compare(this.salarioBruto, that.salarioBruto) == 0 &&
                Double.compare(this.imposto, that.imposto) == 0 &&
                Objects.equals(this.nome, that.nome);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash = prime * hash + Objects.hashCode(this.nome);
        hash = prime * hash + Objects.hashCode(this.salarioBruto);
        hash = prime * hash + Objects.hashCode(this.imposto);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString(){
        return "{" +
                "\"nome\": \"" + this.nome + "\", " +
                "\"salarioBruto\": " + this.salarioBruto + ", " +
                "\"imposto\": " + this.imposto +
                "}";
    }
}