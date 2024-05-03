package p1.q6;

public class ContaTelefone {

    String numero;
    int codigo;
    int minutosFalados;

    public ContaTelefone(String numero, int codigo, int minutosFalados) {
        this.numero = numero;
        this.codigo = codigo;
        this.minutosFalados = minutosFalados;
    }


    /*
     Se a quantidade de tempo falando( em minutos) for menor ou igual a 30, o valor da conta é 0.6 vezes o número de minutos
     Caso contrário, o valor da conta é 0,4 vezes o número de minutos
     Sobrescreva o método public String toString() para retornar uma string com o número, o código, a quantidade de minutos falados e o valor da conta
     */
    public double getValorDaConta() {
        if (minutosFalados <= 30) {
            return minutosFalados * 0.6;
        } else {
            return minutosFalados * 0.4;
        }
    }

    @Override
    public String toString() {
        return "Número: " + numero + "\n" +
                "Código: " + codigo + "\n" +
                "Minutos Falados: " + minutosFalados + "\n" +
                "Valor da Conta: " + getValorDaConta();
    }
}
