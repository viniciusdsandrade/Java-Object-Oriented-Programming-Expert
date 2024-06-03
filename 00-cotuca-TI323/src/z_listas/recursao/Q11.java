package src.z_listas.recursao;

import static src.z_listas.recursao.Q9.isMenor;

public class Q11 {

    /*
    11. Faça uma ÚNICA função que, recebendo como parâmetro dois números inteiros, resulta verdadeiro, caso o primeiro seja maior do que o segundo, ou falso, caso contrário.
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
                System.out.println(i + " > " + j + " = " + isMaior(i, j));
            }
        }
    }

    public static boolean isMaior(int a, int b) {
        return isMenor(b, a); // 'b' é menor que 'a' implica que 'a' é maior que 'b'
    }
}
