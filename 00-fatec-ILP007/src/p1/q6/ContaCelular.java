package p1.q6;

public class ContaCelular extends ContaTelefone {

    private final String operadora;

    public ContaCelular(String numero, int codigo, int minutosFalados, String operadora) {
        super(numero, codigo, minutosFalados);
        this.operadora = operadora;
    }

    /*
    Se a quantidade de tempo falado for menor ou igual a 20, o valor da conta é 0,9 vezes o número de minutos
    Caso contrario, o valor da conta é 1.8 vezes o número de minutos
    Se o nome da operadora é "CPS" acrescente 40 ao valor da conta
    Sobrescreva o método public String toString() para retornar uma string com o número,
    o código, a quantidade de minutos falados, o nome da operadora e o valor da conta
     */
    @Override
    public double getValorDaConta() {
        if (super.minutosFalados <= 20) {
            if (operadora.equals("CPS"))
                return minutosFalados * 0.9 + 40;
            else
                return minutosFalados * 0.9;
        } else {
            if (operadora.equals("CPS"))
                return minutosFalados * 1.8 + 40;
            else
                return minutosFalados * 1.8;
        }
    }
}
