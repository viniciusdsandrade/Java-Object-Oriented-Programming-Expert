package exercicios.lista_2.q1;

import exercicios.lista_1.q2.Data;

import java.util.Arrays;


public class TestVoo2 {
    public static void main(String[] args) {

        Voo2 voo = new Voo2(
                1,
                new Data((byte) 1, (byte) 1, (short) 2020),
                10,
                5,
                5
        );

        System.out.println(voo);

        //Testar isCadeiraFumante
        for (int i = 0; i < 10; i++)
            System.out.println("Cadeira " + i + " é fumante? " + voo.isCadeiraFumante(i));

        //Testar buscaPrimeiraCadeiraNaoFumante
        System.out.println("Primeira cadeira não fumante: " + voo.buscaPrimeiraCadeiraNaoFumante());

        //testar isCadeiraNaoFumante
        for (int i = 0; i < 10; i++)
            System.out.println("Cadeira " + i + " é não fumante? " + voo.isCadeiraNaoFumante(i));

        //Testar buscarPrimeiraCadeiraFumante
        System.out.println("Primeira cadeira fumante: " + voo.buscaPrimeiraCadeiraFumante());


        int getVagasNaoFumantesRestantes = voo.getVagasNaoFumantesRestantes();
        System.out.println("Vagas não fumantes restantes: " + getVagasNaoFumantesRestantes);

        int getVagasFumantesRestantes = voo.getVagasFumantesRestantes();
        System.out.println("Vagas fumantes restantes: " + getVagasFumantesRestantes);


        char[] cadeirasLivres = voo.getCadeirasLivres();
        System.out.println("Cadeiras livres: " + Arrays.toString(cadeirasLivres));

        int totalDeVagasDisponiveis = voo.vagas();
        System.out.println("Total de vagas disponíveis: " + totalDeVagasDisponiveis);


        boolean verifica;

        for (int i = 0; i < 10; i++) {
            verifica = voo.verifica(i);
            System.out.println("Cadeira valida?: " + verifica);
        }

        voo.ocupa(0);
        voo.ocupa(2);
        voo.ocupa(4);
        voo.ocupa(6);
        voo.ocupa(8);

        cadeirasLivres = voo.getCadeirasLivres();
        String cadeirasLivresString = voo.getCadeirasLivresString();
        System.out.println("Cadeiras livres: " + cadeirasLivresString);
    }
}