package exercicios.lista_3.q3;
/*
    Questão 3
    Dada uma classe denominada Controle, definida em um sistema de controle de transporte de
    pluviômetros, que possui dois métodos estáticos:

    leString() Solicita ao usuário uma String pelo teclado e retorna através do metodo (função tipo String).
    leInteito() Solicita ao usuário um valor inteiro pelo teclado e retorna através do metodo (função tipo int).

    Escreva uma classe herdeira de Controle que acrescente um metodo estático responsável pela
    seleção do caminhão mais apto a distribuição de pluviômetros. O caminhão será aquele capaz de conduzir
    pluviômetros cuja soma de capacidade seja a maior, independente do tipo de cada um deles.
    O programa irá solicitar uma lista de caminhões.

    Para cada caminhão ele pergunta:
        1 - Tipo do caminhão (‘Alfa’ ou ‘Beta’);
        2 - número de pluviômetros a ser transportados;
        3 - lista dos pluviômetros a ser transportados no caminhão (para cada pluviômetro é digitado
    apenas seu tipo).
    A lista encerra quando é digitado ‘Fim’ para o Tipo do caminhão.
    Após digitada toda a lista o programa imprime na tela (System.out) os seguintes dados do
    caminhão mais apto:
        1 - tipo do caminhão (Alfa ou Beta);
        2 - lista dos pluviômetros transportados no caminhão.
    Em ambas as questões, devem ser criados os atributos que se fizerem necessários.
 */

import java.util.Scanner;

public class Controle {

    public static String leString(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int leInteiro(String mensagem) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensagem);
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            System.out.print(mensagem);
            scanner.next(); // Consumir a entrada inválida
        }
        return scanner.nextInt();
    }
}
