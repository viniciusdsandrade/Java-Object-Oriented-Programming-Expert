package exercicios.lista_1.q4;

public class Gabarito {

    public char respostaQuestao(int numeroQuestao) {
        return switch (numeroQuestao) {
            case 1, 6, 11 -> 'A';
            case 2, 7, 12 -> 'B';
            case 3, 8, 13 -> 'C';
            case 4, 9, 14 -> 'D';
            case 5, 10, 15 -> 'E';
            default -> throw new IllegalArgumentException("Questão inválida.");
        };
    }
}