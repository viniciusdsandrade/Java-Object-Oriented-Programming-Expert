package exercicios.figura;

public abstract class Poligono {

    protected int numeroLados;

    protected Poligono(int numeroLados) {
        this.numeroLados = numeroLados;
    }

    protected abstract double calcularArea();

    protected abstract double getPerimetro();
}
