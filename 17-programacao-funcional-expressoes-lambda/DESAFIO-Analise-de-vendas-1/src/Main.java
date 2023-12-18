import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\Pichau\\Desktop\\java-spring-ultimate\\nelio-object-oriented-programing\\Java-Object-Oriented-Programming-Expert\\17-programacao-funcional-expressoes-lambda\\base-de-dados\\base-de-dados.csv";
            Map<String, Double> totalSalesBySeller = calculateTotalSalesBySeller(filePath);
            displayTotalSalesBySeller(totalSalesBySeller);
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static Map<String, Double> calculateTotalSalesBySeller(String filePath) throws IOException {
        Map<String, Double> totalSalesBySeller = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                // Assuming the structure of the CSV file matches the Sale class
                Integer month = Integer.parseInt(data[0]);
                Integer day = Integer.parseInt(data[1]);
                String seller = data[2];
                Integer items = Integer.parseInt(data[3]);
                Double total = Double.parseDouble(data[4]);

                Sale sale = new Sale(month, day, seller, items, total);

                // Accumulate total sales for each seller
                totalSalesBySeller.merge(seller, sale.getTotal(), Double::sum);

                // Display details for each sale
                System.out.println(sale.saleDetails());
                System.out.println("Média de preço: R$ " + sale.averagePrice());
                System.out.println("----------------------");
            }
        }

        return totalSalesBySeller;
    }

    private static void displayTotalSalesBySeller(Map<String, Double> totalSalesBySeller) {
        System.out.println("Total de vendas por vendedor:");
        Set<Map.Entry<String, Double>> entries = totalSalesBySeller.entrySet();
        for (Map.Entry<String, Double> entry : entries) {
            System.out.printf("%s - R$ %.2f%n", entry.getKey(), entry.getValue());
        }
    }
}