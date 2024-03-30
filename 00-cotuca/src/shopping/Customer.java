package src.shopping;

import java.util.Objects;

public class Customer {

    private final int id;
    private String name;
    private int discount;

    public Customer(int id, String name, int discount) {
        this.id = id;
        this.name = name;

        if (discount < 0 || discount > 100)
            throw new IllegalArgumentException("Discount must be between 0 and 100");

        this.discount = discount;
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

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Customer that = (Customer) obj;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.discount, that.discount);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + this.id;
        hash *= prime + this.name.hashCode();
        hash *= prime + this.discount;

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "Customer[id = " + id + ", name = " + name + ", discount = " + discount + "]";
    }
}
