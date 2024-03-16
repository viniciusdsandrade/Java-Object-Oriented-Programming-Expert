package exercicios.figura;

public class TrianguloRetanguloInterface extends Triangulo implements RetanguloInterface {

    private double catetoAdjacente;
    private double catetoOposto;
    private static final int NUMERO_LADOS = 3;

    public TrianguloRetanguloInterface(int numeroLados, double catetoOposto, double catetoAdjacente) {
        super(NUMERO_LADOS, catetoOposto, catetoAdjacente);
        this.catetoAdjacente = catetoAdjacente;
        this.catetoOposto = catetoOposto;
    }

    @Override
    public void setCatetos(double catetoAdjacente, double catetoOposto) {
        if (catetoAdjacente <= 0 || catetoOposto <= 0)
            throw new IllegalArgumentException("Os catetos devem ser maiores que zero.");

        this.catetoAdjacente = catetoAdjacente;
        this.catetoOposto = catetoOposto;
    }

    @Override
    public double calcularHipotenusa() {
        return Math.sqrt(Math.pow(this.catetoAdjacente, 2) + Math.pow(this.catetoOposto, 2));
    }

    @Override
    public double calcularArea() {
        return (this.catetoAdjacente * this.catetoOposto) / 2;
    }

    public double calcularAreaPeloPerimetro(double perimetro) {
        double semiPerimetro = perimetro / 2;
        return Math.sqrt(semiPerimetro * (semiPerimetro - this.catetoAdjacente) * (semiPerimetro - this.catetoOposto) * (semiPerimetro - calcularHipotenusa()));
    }

    @Override
    public double getPerimetro() {
        return this.catetoAdjacente + this.catetoOposto + calcularHipotenusa();
    }
}

