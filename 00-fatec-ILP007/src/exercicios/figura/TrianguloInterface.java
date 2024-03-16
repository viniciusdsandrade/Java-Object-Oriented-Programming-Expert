package exercicios.figura;

public interface TrianguloInterface {

    boolean exists();

    boolean isEquilatero();

    boolean isIsosceles();

    boolean isEscaleno();

    double calcularArea();

    double getPerimetro();

    double getAltura();

    double getBase();

    double getHipotenusa();

    void setCatetos(double catetoAdjacente, double catetoOposto);

    void setLados(double lado1, double lado2, double lado3);

    void setBaseAltura(double base, double altura);

    void setLadosBaseAltura(double lado1, double lado2, double base, double altura);
}
