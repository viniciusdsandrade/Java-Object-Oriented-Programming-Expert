package exercicios.figura;

public abstract class Poligono {

    private int numeroLados;

    protected Poligono(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    public abstract double calcularArea();

    public abstract double getPerimetro();
}
