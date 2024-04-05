package exercicios.banco;

public class TestBanco {
    public static void main(String[] args) {
        ContaCorrente contaCorrente = new ContaCorrente("João", 200.0);
        contaCorrente.depositar(1000.0);
        contaCorrente.sacar(500.0);
        contaCorrente.consultarSaldo();

        // Criando uma conta poupança
        ContaPoupanca contaPoupanca = new ContaPoupanca("Maria", 0.05);
        contaPoupanca.depositar(2000.0);
        contaPoupanca.aplicarRendimento();
        contaPoupanca.consultarSaldo();
    }
}
