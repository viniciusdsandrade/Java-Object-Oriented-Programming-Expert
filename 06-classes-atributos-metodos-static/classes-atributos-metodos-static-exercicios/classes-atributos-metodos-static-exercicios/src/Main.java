import java.util.Scanner;

public class Main {

    private static final int MAX_EXERCISES = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exitProgram;

        do {
            int choice = displayMenuAndGetChoice(scanner);

            if (choice >= 1 && choice <= MAX_EXERCISES)
                executeExercise(choice);
            else
                System.out.println("Invalid option!");

            exitProgram = getExitChoice(scanner);
        } while (!exitProgram);

        System.out.println("Thank you for using this program!");
        scanner.close();
    }

    private static void executeExercise(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("Entre com a largura e altura do retângulo:");
                double width = scanner.nextDouble();
                double height = scanner.nextDouble();

                Retangulo exercise01 = new Retangulo(width, height);

                System.out.printf("AREA = %.2f%n", exercise01.getArea());
                System.out.printf("PERIMETRO = %.2f%n", exercise01.getPerimetro());
                System.out.printf("DIAGONAL = %.2f%n", exercise01.getDiagonal());
                break;
            case 2:
                System.out.print("Nome: ");
                String name = scanner.nextLine();

                System.out.print("Salário bruto: ");
                double grossSalary = scanner.nextDouble();

                System.out.print("Imposto: ");
                double tax = scanner.nextDouble();

                Funcionario exercise02 = new Funcionario(name, grossSalary, tax);

                System.out.println("Funcionário: " + exercise02.getNome() + ", $ " + exercise02.netSalary());
                System.out.print("Digite a porcentagem para aumentar o salário: ");
                break;
            case 3:
                String nome = scanner.nextLine();
                double nota1 = scanner.nextDouble();
                double nota2 = scanner.nextDouble();
                double nota3 = scanner.nextDouble();

                Alunos exercise03 = new Alunos(nome, nota1, nota2, nota3);
                System.out.println("NOTA FINAL = " + exercise03.finalGrade());

                if (exercise03.finalGrade() < 60.0) {
                    System.out.println("FAILED");
                    System.out.println("MISSING " + exercise03.missingPoints() + " POINTS");
                } else {
                    System.out.println("PASS");
                }
                break;
            case 4:
                System.out.print("Qual é a cotação do dólar? ");
                double dolar = scanner.nextDouble();

                System.out.print("Quantos dólares você vai comprar? ");
                double quantidade = scanner.nextDouble();

                System.out.printf("Valor a ser pago em reais = %.2f%n", Cambio.dolarParaReal(dolar, quantidade));
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }

    private static int displayMenuAndGetChoice(Scanner scanner) {
        System.out.println("1. Retangulo");
        System.out.println("2. Funcionario");
        System.out.println("3. Alunos");
        System.out.println("4. Cambio");

        System.out.print("Digite o número do exercício que você deseja executar: ");
        return scanner.nextInt();
    }

    private static boolean getExitChoice(Scanner scanner) {
        int exitChoice;
        do {
            System.out.print("Do you want to exit?\n"
                    + "Enter (1) for Yes or (0) for No: ");
            exitChoice = scanner.nextInt();
        } while (exitChoice != 0 && exitChoice != 1);
        return exitChoice == 1;
    }
}