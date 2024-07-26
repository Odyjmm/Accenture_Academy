package Erros;

public class DepositoInvalidoException extends RuntimeException {
    public DepositoInvalidoException() {
        super();
    }

    public DepositoInvalidoException(String message) {
        super(message);
    }
}
