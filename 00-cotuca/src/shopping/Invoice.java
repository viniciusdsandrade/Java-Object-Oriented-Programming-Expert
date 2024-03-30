package src.shopping;

import java.util.Arrays;
import java.util.Objects;

public class Invoice {

    private final int id;
    private Customer customer;
    private int nProducts = 0;
    private Product[] products = new Product[]{};
    private int[] quantities = new int[]{};

    public Invoice(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    public boolean addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) return false;

        for (int i = 0; i < nProducts; i++) {
            if (products[i].equals(product)) {
                quantities[i] += quantity;
                return true;
            }
        }

        Product[] newProducts = new Product[nProducts + 1];
        int[] newQuantities = new int[nProducts + 1];

        for (int i = 0; i < nProducts; i++) {
            newProducts[i] = products[i];
            newQuantities[i] = quantities[i];
        }

        newProducts[nProducts] = product;
        newQuantities[nProducts] = quantity;

        products = newProducts;
        quantities = newQuantities;
        nProducts++;

        return true;
    }

    public boolean removeProduct(Product product) {
        if (product == null) return false;

        for (int i = 0; i < nProducts; i++) {
            if (products[i].equals(product)) {
                Product[] newProducts = new Product[nProducts - 1];
                int[] newQuantities = new int[nProducts - 1];

                for (int j = 0, k = 0; j < nProducts; j++) {
                    if (j != i) {
                        newProducts[k] = products[j];
                        newQuantities[k] = quantities[j];
                        k++;
                    }
                }

                products = newProducts;
                quantities = newQuantities;
                nProducts--;

                return true;
            }
        }

        return false;
    }

    public double calculateTotal() {
        double total = 0.0;

        for (int i = 0; i < nProducts; i++)
            total += products[i].getPrice() * quantities[i];

        return total;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Invoice that = (Invoice) obj;

        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.nProducts, that.nProducts) &&
                Objects.equals(this.customer, that.customer) &&
                Arrays.equals(this.products, that.products) &&
                Arrays.equals(this.quantities, that.quantities);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + id;
        hash *= prime + nProducts;
        hash *= prime + Objects.hashCode(customer);
        hash *= prime + Arrays.hashCode(products);
        hash *= prime + Arrays.hashCode(quantities);

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Invoice[").append("id = ").append(id).append(", customer = ").append(customer.getName()).append(", products = [");

        for (int i = 0; i < nProducts; i++) {
            sb.append(products[i].getName()).append(" x ").append(quantities[i]);
            if (i < nProducts - 1) sb.append(", ");
        }

        sb.append("], total = ").append(calculateTotal()).append("]");

        return sb.toString();
    }
}
