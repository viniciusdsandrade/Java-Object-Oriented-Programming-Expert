package src.z_listas.recursao;

import static src.z_listas.recursao.Q1.isNegative;
import static src.z_listas.recursao.Q3.subtracao;

public class Q10 {

    /*
    10. Faça uma ÚNICA função que, recebendo como parâmetro dois números inteiros, resulta verdadeiro, caso o primeiro seja menor ou igual ao segundo, ou falso, caso contrário.
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
        for (int i = -10; i < 10; i++) {
            for (int j = -10; j < 10; j++) {
                System.out.println(i + " ≤ " + j + " = " + isMenorOuIgual(i, j));
            }
        }
    }

    public static boolean isMenorOuIgual(int a, int b) {
        if (a == b) return true;
        return isNegative(subtracao(a, b)); // Se a - b for negativo, 'a' é menor que 'b'
    }
}
