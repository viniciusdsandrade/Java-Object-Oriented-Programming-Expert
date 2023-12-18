
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Quantos contribuintes deseja cadastrar? ");
            int n = input.nextInt();

            TaxPayer[] taxPayers = new TaxPayer[n];

            for (int i = 0; i < n; i++) {
                System.out.println("\nDigite os dados do contribuinte " + (i + 1) + "°:");
                System.out.print("Renda anual com salário: ");
                double salaryIncome = input.nextDouble();

                System.out.print("Renda anual com prestação de serviço: ");
                double servicesIncome = input.nextDouble();

                System.out.print("Renda anual com ganho de capital: ");
                double capitalIncome = input.nextDouble();

                System.out.print("Gastos médicos: ");
                double healthSpending = input.nextDouble();

                System.out.print("Gastos educacionais: ");
                double educationSpending = input.nextDouble();
                System.out.println();

                taxPayers[i] = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
            }

            for (int i = 0; i < n; i++) {
                System.out.println();
                System.out.println("Resumo do " + (i + 1) + "° contribuinte:");
                System.out.println("Imposto bruto total: " + taxPayers[i].getGrossTax());
                System.out.println("Abatimento: " + taxPayers[i].getTaxRebate());
                System.out.println("Imposto devido: " + taxPayers[i].getNetTax());
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println("Erro: Entrada inválida. Certifique-se de inserir números corretos.");
        }
    }
}