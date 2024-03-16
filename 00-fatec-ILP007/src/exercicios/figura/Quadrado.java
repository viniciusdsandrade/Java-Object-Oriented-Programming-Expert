package exercicios.figura;

public class Quadrado extends Poligono {

    private final double tamanhoLado;
    private static final int NUMERO_DE_LADOS = 4;


    public Quadrado(int numeroLados, double tamanhoLado) {
        super(NUMERO_DE_LADOS);
        this.tamanhoLado = tamanhoLado;
    }

    @Override
    public double calcularArea() {
        return Math.pow(tamanhoLado, 2);
    }

    @Override
    public double getPerimetro() {
        return tamanhoLado * NUMERO_DE_LADOS;
    }
}
