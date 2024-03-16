package exercicios.figura;

public class TestFigura {
    public static void main(String[] args) {
        TrianguloRetanguloInterface trianguloRetangulo = new TrianguloRetanguloInterface(3, 3, 4);
        trianguloRetangulo.setCatetos(3, 4);

        System.out.println("Área do triângulo retângulo:                " + trianguloRetangulo.calcularArea());
        System.out.println("Perímetro do triângulo retângulo:           " + trianguloRetangulo.getPerimetro());
        System.out.println("Área do triângulo retângulo pelo perímetro: " + trianguloRetangulo.calcularAreaPeloPerimetro(trianguloRetangulo.getPerimetro()));
    }
}
