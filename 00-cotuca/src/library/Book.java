package src.library;

import java.util.Objects;

public class Book {

    private String name;
    private Author author;
    private double price;
    private int quantity = 0;

    public Book(String name, Author author, double price) {
        this.name = name;
        this.author = author;

        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public Book(String name, Author author, double price, int quantity) {
        this.name = name;
        this.author = author;

        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;

        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Book that = (Book) obj;

        return Objects.equals(this.name, that.name) &&
                Objects.equals(this.author, that.author) &&
                Objects.equals(this.price, that.price) &&
                Objects.equals(this.quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + name.hashCode();
        hash *= prime + author.hashCode();
        hash *= prime + Double.hashCode(price);
        hash *= prime + quantity;

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "Book[name = " + name + ", " + author + ", price = " + price + ", quantity = " + quantity + "]";
    }
}
