import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Perguntar quantas aulas tem o curso
        System.out.print("Quantas aulas tem o curso? ");
        int numLessons = scanner.nextInt();

        // Limpar o buffer após a leitura do número
        scanner.nextLine();

        // Criar uma lista para armazenar todas as aulas
        List<Lesson> lessons = new ArrayList<>();

        // Preencher a lista com as informações das aulas
        for (int i = 0; i < numLessons; i++) {
            System.out.println("\nDados da " + (i + 1) + "a aula:");

            // Perguntar se é conteúdo ou tarefa
            System.out.print("Conteúdo ou tarefa (c/t)? ");
            char lessonType = scanner.next().charAt(0);

            // Limpar o buffer após a leitura do caractere
            scanner.nextLine();

            // Preencher os dados da aula com base no tipo
            if (lessonType == 'c') {
                System.out.print("Título: ");
                String title = scanner.nextLine();
                System.out.print("URL do vídeo: ");
                String url = scanner.nextLine();
                System.out.print("Duração em segundos: ");
                int duration = scanner.nextInt();

                // Limpar o buffer após a leitura do número
                scanner.nextLine();

                // Adicionar uma aula de vídeo à lista
                lessons.add(new Video(title, url, duration));
            } else if (lessonType == 't') {
                System.out.print("Título: ");
                String title = scanner.nextLine();
                System.out.print("Descrição: ");
                String description = scanner.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionCount = scanner.nextInt();

                // Limpar o buffer após a leitura do número
                scanner.nextLine();

                // Adicionar uma aula de tarefa à lista
                lessons.add(new Task(title, description, questionCount));
            } else {
                System.out.println("Opção inválida. Use 'c' para conteúdo ou 't' para tarefa.");
                i--; // Repetir a iteração
            }
        }

        // Calcular a duração total do curso
        int totalDuration = calculateTotalDuration(lessons);

        // Exibir a duração total do curso
        System.out.println("DURAÇÃO TOTAL DO CURSO = " + totalDuration + " segundos");
    }

    private static int calculateTotalDuration(List<Lesson> lessons) {
        int totalDuration = 0;
        for (Lesson lesson : lessons) {
            totalDuration += lesson.durationInMinutes(); // Converter minutos para segundos
        }
        return totalDuration;
    }
}
