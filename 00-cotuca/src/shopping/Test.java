package src.shopping;

public class Test {
    public static void main(String[] args) {
        Product product = new Product(1, "Apple", 1.99);
        Product product2 = new Product(1, "MacBook", 4056.99);
        Customer customer = new Customer(1, "John", 2);

        Invoice invoice = new Invoice(1, customer);
        invoice.addProduct(product, 234);
        invoice.addProduct(product2, 234);

        System.out.println(invoice);
    }
}
