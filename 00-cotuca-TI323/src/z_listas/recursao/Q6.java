package src.z_listas.recursao;


import static src.z_listas.recursao.Q1.isNegative;
import static src.z_listas.recursao.Q5.multiplicacao;
import static src.z_listas.recursao.Q7.divisaoInteira;

public class Q6 {

    /*
    6. Faça uma ÚNICA função que, recebendo como parâmetro dois números inteiros, resulta a potenciação deles, ou seja, o primeiro deles elevado ao segundo deles.
    Importante lembrar que os números com os quais vocês trabalharão são inteiros, logo, podem ser positivos ou negativos

    Fica proibido:
     declarar variáveis,
     fazer uso de operadores aritméticos (+, -, *, / e %),
     dos operadores relacionais (!=, <, ≤, > e ≥),
     de operadores lógicos (!, && e ||),
     dos comandos de seleção (if com else e switch),
     de comandos repetitivos (while, do-while e for),
     try-catch
     e de funções auxiliares e de qualquer função de biblioteca ou de sua própria autoria, exceto funções implementadas em outros itens desta lista de exercícios.

    Dica: use ++, --, ==, if sem else, return, recursão.
    Faça um programa para testar sua função.
     */

    public static void main(String[] args) {

        for (int i = -6; i < 7; i++) {
            for (int j = -6; j < 7; j++) {
                System.out.println(i + " ^ " + j + " = " + potenciacao(i, j));
            }
        }
    }

    public static int potenciacao(int a, int b) {
        if (b == 0) return 1; // Caso base: qualquer número elevado a 0 é 1
        if (a == 0) return 0; // Caso base: 0 elevado a qualquer número (exceto 0) é 0

        if (isNegative(b)) {
            if (isNegative(a))
                return potenciacao(a, ++b) / a;
            return divisaoInteira(1, potenciacao(a, ++b)); // Caso especial: a ^ -b = 1 / (a ^ b
        }

        return multiplicacao(a, potenciacao(a, --b)); // Caso geral: a ^ b = a * (a ^ (b - 1))
    }
}
