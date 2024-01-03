package src.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EqualsAndHashSet {

    public static void main(String[] args) {

        Set<Product> set = new HashSet<>();

        set.add(new Product("TV", 900.0));
        set.add(new Product("Notebook", 1200.0));
        set.add(new Product("Tablet", 400.0));

        Product prod = new Product("Notebook", 1200.0);

        System.out.println(set.contains(prod));

        System.out.println("------------------------------------------------");

        Set<Product> set2 = new TreeSet<>(
                Set.of(new Product("TV", 900.0),
                        new Product("Notebook", 1200.0),
                        new Product("Tablet", 400.0))
        );

        Product prod2 = new Product("Notebook", 1200.0);

        System.out.println(set2.contains(prod2));
    }
}
