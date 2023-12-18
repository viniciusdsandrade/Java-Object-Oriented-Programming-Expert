import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String filePath = null;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEntre o caminho do arquivo: ");
            //String filePath = "C:\\Users\\Pichau\\Desktop\\java-spring-ultimate\\nelio-object-oriented-programing\\Java-Object-Oriented-Programming-Expert\\17-programacao-funcional-expressoes-lambda\\base-de-dados\\base-de-dados.csv";
            filePath = sc.next();
            List<Sale> sales = readSalesFromCsv(filePath);

            // Análise 1: Cinco primeiras vendas de 2016 de maior preço médio
            analyzeTop5Sales2016(sales);

            System.out.println();

            // Análise 2: Valor total vendido pelo vendedor Logan nos meses 1 e 7 de qualquer ano
            analyzeTotalSalesBySeller(sales, "Logan", 1, 7);
            sc.close();
        } catch (IOException e) {
            //Erro: c:\temp\in (O sistema não pode encontrar o arquivo especificado)
            System.out.printf("Erro: %s (O sistema não pode encontrar o arquivo especificado)", filePath);
        }
    }

    private static List<Sale> readSalesFromCsv(String filePath) throws IOException {
        List<Sale> sales = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                Integer month = Integer.parseInt(fields[0]);
                Integer year = Integer.parseInt(fields[1]);
                String seller = fields[2];
                Integer unitsSold = Integer.parseInt(fields[3]);
                Double totalValue = Double.parseDouble(fields[4]);

                sales.add(new Sale(month, year, seller, unitsSold, totalValue));
                line = br.readLine();
            }
        }
        return sales;
    }

    private static void analyzeTop5Sales2016(List<Sale> sales) {
        Comparator<Sale> comp = Comparator.comparingDouble(Sale::averagePrice).reversed();
        List<Sale> topSales = sales.stream()
                .filter(s -> s.getYear().equals(2016))
                .sorted(comp)
                .limit(5)
                .toList();

        System.out.println("Cinco primeiras vendas de 2016 de maior preço médio");
        for (Sale s : topSales) {
            System.out.println(s);
        }
    }

    private static void analyzeTotalSalesBySeller(List<Sale> sales, String seller, Integer... months) {
        double totalSales = sales.stream()
                .filter(sale -> sale.getSeller().equals(seller) && List.of(months).contains(sale.getMonth()))
                .mapToDouble(Sale::getTotal)
                .sum();

        System.out.printf("Valor total vendido pelo vendedor %s nos meses %s = %.2f%n",
                seller, List.of(months), totalSales);
    }
}