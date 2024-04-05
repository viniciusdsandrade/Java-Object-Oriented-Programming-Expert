package exercicios.banco;

public class DepositoInvalidoException extends RuntimeException{
    public DepositoInvalidoException(String message) {
        super(message);
    }
}
