package src.shopping;

import java.util.Objects;

public class Product {

    private final int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new IllegalArgumentException("Price must be non-negative");

        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Product that = (Product) obj;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.price, that.price);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + this.id;
        hash *= prime + this.name.hashCode();
        hash *= prime + Double.hashCode(this.price);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "Product[id = " + id + ", name = " + name + ", price = " + price + "]";
    }
}
