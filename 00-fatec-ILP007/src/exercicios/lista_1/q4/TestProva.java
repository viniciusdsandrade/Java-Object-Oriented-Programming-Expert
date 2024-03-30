package exercicios.lista_1.q4;

public class TestProva {
    public static void main(String[] args) {

        Gabarito gabarito = new Gabarito();
        Prova prova = new Prova(gabarito);

        char[] respostas = {
                'A', 'B', 'C', 'D', 'E',
                'A', 'B', 'C', 'D', 'E',
                'A', 'B', 'C', 'D', 'E'
        };

        for (char resposta : respostas)
            prova.respostaAluno(resposta);

        System.out.println("Acertos: " + prova.acertos());
        System.out.println("Nota: " + prova.nota());
        System.out.println(prova);

        Prova prova2 = new Prova(prova);
        Prova prova3 = (Prova) prova.clone();

        System.out.println("copia: " + prova2);
        System.out.println("clone: " + prova3);

        System.out.println("copia.hashCode() = " + prova2.hashCode());
        System.out.println("clone.hashCode() = " + prova3.hashCode());
        System.out.println("prova.hashCode() = " + prova.hashCode());

        System.out.println("copia.equals(prova) = " + prova2.equals(prova));
        System.out.println("clone.equals(prova) = " + prova3.equals(prova));
        System.out.println("copia.equals(clone) = " + prova2.equals(prova3));
    }
}
