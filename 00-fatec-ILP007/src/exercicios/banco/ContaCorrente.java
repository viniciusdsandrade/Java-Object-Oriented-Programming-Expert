package exercicios.banco;

class ContaCorrente extends Conta {
    private double limiteChequeEspecial;

    // Construtor
    public ContaCorrente(String titular, double limiteChequeEspecial) {
        super(titular);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    // Método para sobrescrever o saque considerando o limite do cheque especial
    @Override
    public void sacar(double valor) {
        if (valor <= 0 || !((saldo + limiteChequeEspecial) >= valor))
            throw new SaldoInsuficienteException("Valor inválido para saque.");

        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    }
}