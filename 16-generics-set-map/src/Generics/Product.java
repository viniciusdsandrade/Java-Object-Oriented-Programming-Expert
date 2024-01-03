package src.Generics;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Comparable<Product>{
    
    private String name;
    private Double price;

    @Override
    public String toString() {
        return name + ", " + String.format("%.2f", price);
    }

    @Override
    public int compareTo(Product o) {
        return price.compareTo(o.getPrice());
    }
}
