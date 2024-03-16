package exercicios.figura;

public class Triangulo extends Poligono {

    private final double base;
    private final double altura;
    private static final int NUMERO_LADOS = 3;

    public Triangulo(int numeroLados, double base, double altura) {
        super(NUMERO_LADOS);
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    public double getHipotenusa() {
        return Math.sqrt(Math.pow(base, 2) + Math.pow(altura, 2));
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }

    @Override
    public double getPerimetro() {
        return base + altura + getHipotenusa();
    }
}
