package exercicios.extrato;

public abstract class Conta {
    protected double saldo;

    public Conta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void getExtrato();
    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
}