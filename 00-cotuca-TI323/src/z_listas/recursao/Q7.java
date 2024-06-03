package src.z_listas.recursao;

import static src.z_listas.recursao.Q1.isNegative;
import static src.z_listas.recursao.Q2.soma;
import static src.z_listas.recursao.Q3.subtracao;

public class Q7 {

    /*
    7. Faça uma ÚNICA função que, recebendo como parâmetro dois números inteiros, resulta a divisão inteira deles (o primeiro dividido pelo segundo).
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
                System.out.println(i + " / " + j + " = " + divisaoInteira(i, j));
            }
        }
    }

    public static int divisaoInteira(int i, int j) {
        if (i == 0) return 0; // Caso base: 0 dividido por qualquer número (exceto 0) é 0
        if (j == 0) return 0; // Caso base: qualquer número dividido por 0 é 0
        // Caso especial: se i - j for negativo, i é menor que j, logo a divisão é 0
        if (isNegative(subtracao(i, j))) return 0;
        return soma(1, divisaoInteira(subtracao(i, j), j)); // Caso geral: i / j = 1 + (i - j) / j
    }
}
