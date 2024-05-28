package exercicios.banco;

class Conta {
    private String titular;
    protected double saldo;

    // Construtor
    public Conta(String titular) {
        this.titular = titular;
        this.saldo = 0.0;
    }

    // Metodo para depositar dinheiro na conta
    public void depositar(double valor) {
        if (valor <= 0)
            throw new DepositoInvalidoException("Valor inválido para depósito.");

        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    // Metodo para sacar dinheiro da conta
    public void sacar(double valor) {
        if (valor <= 0 || saldo < valor)
            throw new SaldoInsuficienteException("Valor inválido para saque.");

        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    }

    // Método para consultar saldo da conta
    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + saldo);
    }
}