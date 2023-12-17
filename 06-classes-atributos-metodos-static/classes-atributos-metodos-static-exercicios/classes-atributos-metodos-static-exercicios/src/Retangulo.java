import java.util.Objects;

public class Retangulo {

    private final double width;
    private final double height;

    public Retangulo(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimetro() {
        return 2 * (width + height);
    }

    public double getDiagonal() {
        return Math.sqrt(width * width + height * height);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Retangulo retangulo = (Retangulo) o;

        return Double.compare(this.width, retangulo.width) == 0 &&
                Double.compare(this.height, retangulo.height) == 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash = prime * hash + Objects.hashCode(this.width);
        hash = prime * hash + Objects.hashCode(this.height);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"width\": \"" + this.height + "\",\n" +
                "  \"height\": " + this.height + ",\n" +
                "}";
    }
}
