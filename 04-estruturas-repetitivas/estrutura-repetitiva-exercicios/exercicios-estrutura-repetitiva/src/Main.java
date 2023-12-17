import java.util.Scanner;

public class Main {

    private static final int MAX_EXERCISES = 16;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exitProgram = false;

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
        switch (choice) {
            case 1:
                ProblemaCrescente exercise01 = new ProblemaCrescente();
                break;
            case 2:
                ProblemaMediaIdades exercise02 = new ProblemaMediaIdades();
                break;
            case 3:
                ProblemaSenhaFixa exercise03 = new ProblemaSenhaFixa();
                break;
            case 4:
                ProblemaQuadrante exercise04 = new ProblemaQuadrante();
                break;
            case 5:
                ProblemaValidacaoDeNota exercise05 = new ProblemaValidacaoDeNota();
                break;
            case 6:
                ProblemaCombustivel exercise06 = new ProblemaCombustivel();
                break;
            case 7:
                ProblemaParesConsecutivos exercise07 = new ProblemaParesConsecutivos();
                break;
            case 8:
                ProblemaTabuada exercise08 = new ProblemaTabuada();
                break;
            case 9:
                ProblemaSomaImpares exercise09 = new ProblemaSomaImpares();
                break;
            case 10:
                ProblemaSequenciaImpares exercise10 = new ProblemaSequenciaImpares();
                break;
            case 11:
                ProblemaDentroFora exercise11 = new ProblemaDentroFora();
                break;
            case 12:
                ProblemaParImpar exercise12 = new ProblemaParImpar();
                break;
            case 13:
                ProblemaMediaPonderada exercise13 = new ProblemaMediaPonderada();
                break;
            case 14:
                ProblemaDivisao exercise14 = new ProblemaDivisao();
                break;
            case 15:
                ProblemaFatorial exercise15 = new ProblemaFatorial();
                break;
            case 16:
                ProblemaExperiencias exercise16 = new ProblemaExperiencias();
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }

    private static int displayMenuAndGetChoice(Scanner scanner) {
        System.out.println("1 - Problema Crescente");
        System.out.println("2 - Problema Média de Idades");
        System.out.println("3 - Problema Senha Fixa");
        System.out.println("4 - Problema Quadrante");
        System.out.println("5 - Problema Validação de Nota");
        System.out.println("6 - Problema Combustível");
        System.out.println("7 - Problema Pares Consecutivos");
        System.out.println("8 - Problema Tabuada");
        System.out.println("9 - Problema Soma de Ímpares");
        System.out.println("10 - Problema Sequência de Ímpares");
        System.out.println("11 - Problema Dentro e Fora");
        System.out.println("12 - Problema Par ou Ímpar");
        System.out.println("13 - Problema Média Ponderada");
        System.out.println("14 - Problema Divisão");
        System.out.println("15 - Problema Fatorial");
        System.out.println("16 - Problema Experiências");

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