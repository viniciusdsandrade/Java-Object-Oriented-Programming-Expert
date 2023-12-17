import java.util.Scanner;

public class Main {

    private static final int MAX_EXERCISES = 13;

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

    private static boolean getExitChoice(Scanner scanner) {
        int exitChoice;
        do {
            System.out.print("Do you want to exit?\n"
                    + "Enter (1) for Yes or (0) for No: ");
            exitChoice = scanner.nextInt();
        } while (exitChoice != 0 && exitChoice != 1);
        return exitChoice == 1;
    }

    private static int displayMenuAndGetChoice(Scanner scanner) {
        System.out.println("1 - Problemas Notas");
        System.out.println("2 - Problemas Bhaskara");
        System.out.println("3 - Problemas Menor de Três");
        System.out.println("4 - Problemas Operadora");
        System.out.println("5 - Problemas Troco Verificado");
        System.out.println("6 - Problemas Glicose");
        System.out.println("7 - Problemas Dardo");
        System.out.println("8 - Problemas Temperatura");
        System.out.println("9 - Problemas Lanchonete");
        System.out.println("10 - Problemas Múltiplos");
        System.out.println("11 - Problemas Aumento");
        System.out.println("12 - Problemas Tempo de Jogo");
        System.out.println("13 - Problemas Coordenadas");

        System.out.print("Enter the number of the exercise you want to execute: ");
        return scanner.nextInt();
    }

    private static void executeExercise(int choice) {
        switch (choice) {
            case 1:
                ProblemaNotas exercise01 = new ProblemaNotas();
                break;
            case 2:
                ProblemaBhaskara exercise02 = new ProblemaBhaskara();
                break;
            case 3:
                ProblemaMenorDeTres exercise03 = new ProblemaMenorDeTres();
                break;
            case 4:
                ProblemaOperadora exercise04 = new ProblemaOperadora();
                break;
            case 5:
                ProblemaTrocoVerificado exercise05 = new ProblemaTrocoVerificado();
                break;
            case 6:
                ProblemaGlicose exercise06 = new ProblemaGlicose();
                break;
            case 7:
                ProblemaDardo exercise07 = new ProblemaDardo();
                break;
            case 8:
                ProblemaTemperatura exercise08 = new ProblemaTemperatura();
                break;
            case 9:
                ProblemaLanchonete exercise09 = new ProblemaLanchonete();
                break;
            case 10:
                ProblemaMultiplos exercise10 = new ProblemaMultiplos();
                break;
            case 11:
                ProblemaAumento exercise11 = new ProblemaAumento();
                break;
            case 12:
                ProblemaTempoDeJogo exercise12 = new ProblemaTempoDeJogo();
                break;
            case 13:
                ProblemaCoordenadas exercise13 = new ProblemaCoordenadas();
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }

    }
}