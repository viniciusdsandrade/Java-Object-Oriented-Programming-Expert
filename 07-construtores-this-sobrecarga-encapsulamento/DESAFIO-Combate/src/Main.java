import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Champion champion1 = createChampion(scanner, "primeiro");
        System.out.println();

        Champion champion2 = createChampion(scanner, "segundo");
        System.out.println();

        System.out.print("Quantos turnos você deseja executar? ");
        int numberOfTurns = scanner.nextInt();
        System.out.println();

        simulateCombat(champion1, champion2, numberOfTurns);
    }

    private static Champion createChampion(Scanner scanner, String ordinal) {
        System.out.println(STR."Digite os dados do \{ordinal} campeão:");
        System.out.print("Nome: ");
        String name = scanner.next();
        System.out.print("Vida inicial: ");
        int health = scanner.nextInt();
        System.out.print("Ataque: ");
        int attack = scanner.nextInt();
        System.out.print("Armadura: ");
        int armor = scanner.nextInt();

        return new Champion(name, health, attack, armor);
    }

    private static void simulateCombat(Champion champion1, Champion champion2, int numberOfTurns) {
        for (int turn = 1; turn <= numberOfTurns; turn++) {
            System.out.println(STR."Resultado do turno \{turn}:");

            champion1.takeDamage(champion2);
            champion2.takeDamage(champion1);

            System.out.println(champion1.status());
            System.out.println(champion2.status());

            System.out.println();

            if (champion1.getLife() == 0 || champion2.getLife() == 0) {
                System.out.println("FIM DO COMBATE");
                break;
            }
        }
    }
}