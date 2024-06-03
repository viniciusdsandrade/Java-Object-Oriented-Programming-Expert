package src.z_listas.recursao;

import static src.z_listas.recursao.Q3.subtracao;
import static src.z_listas.recursao.Q9.isMenor;

public class Q8 {

    /*
    8. Faça uma ÚNICA função que, recebendo como parâmetro dois números inteiros, resulta o resto da divisão inteira deles (o resto da divisão inteira do primeiro deles pelo segundo).
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
                System.out.println(i + " % " + j + " = " + restoDivisaoInteira(i, j));
            }
        }
    }

    public static int restoDivisaoInteira(int i, int j) {
        if (i == 0) return 0; // Caso base: 0 dividido por qualquer número (exceto 0) é 0
        if (j == 0) return 0; // Caso base: qualquer número dividido por 0 é 0
        // Caso especial: se i - j for negativo, i é menor que j, logo o resto é i
        if (isMenor(i, j)) return i;
        return restoDivisaoInteira(subtracao(i, j), j); // Caso geral: i % j = (i - j) % j
    }
}
