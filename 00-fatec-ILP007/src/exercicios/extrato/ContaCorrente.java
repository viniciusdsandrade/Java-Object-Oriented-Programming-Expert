package exercicios.extrato;

import exercicios.banco.SaldoInsuficienteException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaCorrente extends Conta implements GeradorExtrato {
    private double limiteChequeEspecial;

    public ContaCorrente(double saldo, double limiteChequeEspecial) {
        super(saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    @Override
    public void depositar(double valor) {
        if (valor <= 0) throw new DepositoInvalidoException("Valor inválido para depósito.");

        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
    }

    @Override
    public void sacar(double valor) {
        if (valor <= 0 || !((saldo + limiteChequeEspecial) >= valor))
            throw new SaldoInsuficienteException("Valor inválido para saque.");

        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
    }

    @Override
    public void getExtrato() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();

        String sb = "Extrato da conta corrente\n" +
                "Data: " + sdf.format(now) + "\n" +
                "Saldo: " + getSaldo() + "\n" +
                "Limite cheque especial: " + limiteChequeEspecial + "\n";

        System.out.println(sb);
    }

    @Override
    public String toString() {
        return "{ \"limiteChequeEspecial\": " + limiteChequeEspecial + ", \"saldo\": " + saldo + " }";
    }

    @Override
    public void impExtrato(Conta conta) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date now = new Date();

        String sb = "Extrato da conta corrente\n" +
                "Data: " + sdf.format(now) + "\n" +
                "Saldo: " + conta.getSaldo() + "\n" +
                "Limite cheque especial: " + ((ContaCorrente) conta).getLimiteChequeEspecial() + "\n";

        System.out.println(sb);
    }
}