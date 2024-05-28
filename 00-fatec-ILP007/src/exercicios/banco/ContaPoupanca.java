package exercicios.banco;

// Subclasse para Conta Poupança que herda de Conta
class ContaPoupanca extends Conta {
    private double taxaRendimento;

    // Construtor
    public ContaPoupanca(String titular, double taxaRendimento) {
        super(titular);
        this.taxaRendimento = taxaRendimento;
    }

    // Metodo para aplicar rendimento na conta poupança
    public void aplicarRendimento() {
        saldo *= (1 + taxaRendimento);
        System.out.println("Rendimento aplicado. Novo saldo: R$" + saldo);
    }
}
