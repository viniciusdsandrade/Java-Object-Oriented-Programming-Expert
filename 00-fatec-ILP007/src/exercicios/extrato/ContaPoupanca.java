package exercicios.extrato;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaPoupanca extends Conta implements GeradorExtrato {
    private double taxaDeJuros;

    public ContaPoupanca(double saldo, double taxaDeJuros) {
        super(saldo);
        this.taxaDeJuros = taxaDeJuros;
    }

    public double getTaxaDeJuros() {
        return taxaDeJuros;
    }


    @Override
    public void depositar(double valor) {
        if (valor <= 0) throw new DepositoInvalidoException("Valor inválido para depósito.");
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0 || valor > saldo) throw new SaldoInsuficienteException("Valor inválido para saque.");
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    }

    @Override
    public void getExtrato() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();

        String sb = "Extrato da conta poupança\n" +
                "Data: " + sdf.format(now) + "\n" +
                "Saldo: " + getSaldo() + "\n" +
                "Taxa de juros: " + taxaDeJuros + "\n";

        System.out.println(sb);
    }

    @Override
    public String toString() {
        return "{ \"taxaDeJuros\": " + taxaDeJuros + ", \"saldo\": " + saldo + " }";
    }

    @Override
    public void impExtrato(Conta conta) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();

        String sb = "Extrato da conta poupança\n" +
                "Data: " + sdf.format(now) + "\n" +
                "Saldo: " + conta.getSaldo() + "\n" +
                "Taxa de juros: " + ((ContaPoupanca) conta).getTaxaDeJuros() + "\n";

        System.out.println(sb);
    }
}