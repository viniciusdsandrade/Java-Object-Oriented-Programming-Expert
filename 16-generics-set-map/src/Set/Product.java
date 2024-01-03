package src.Set;

import org.jetbrains.annotations.NotNull;

public class Product implements Comparable<Product> {

    private final String name;
    private final Double price;

    public Product(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Product other = (Product) obj;

        if (this.name == null) {
            return other.name == null;
        } else return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((name == null) ? 0 : name.hashCode());
        hash *= prime + ((price == null) ? 0 : price.hashCode());

        if (hash < 0)
            hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }

    @Override
    public int compareTo(@NotNull Product o) {
        return name.toUpperCase().compareTo(o.getName().toUpperCase());
    }
}
