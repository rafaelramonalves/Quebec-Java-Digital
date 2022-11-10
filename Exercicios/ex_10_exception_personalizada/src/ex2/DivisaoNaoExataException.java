package ex2;

public class DivisaoNaoExataException extends Exception{

    private int numerador;
    private int demonominador;

    public DivisaoNaoExataException(String message, int numerador, int demonominador) {
        super(message);
        this.numerador = numerador;
        this.demonominador = demonominador;
    }
}
