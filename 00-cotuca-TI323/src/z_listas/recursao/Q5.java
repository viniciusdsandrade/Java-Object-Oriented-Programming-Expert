package src.z_listas.recursao;

import static src.z_listas.recursao.Q1.isNegative;
import static src.z_listas.recursao.Q2.soma;
import static src.z_listas.recursao.Q3.subtracao;

public class Q5 {
    /*
    Faça uma ÚNICA função que, recebendo como parâmetro dois números inteiros, resulta a multiplicação deles.
    Importante lembrar que os números com os quais vocês trabalharão são inteiros, logo, podem ser positivos ou negativos
    Fica proibido declarar variáveis, fazer uso de

        1 - operadores aritméticos (+, -, *, / e %),
        2 - dos operadores relacionais (!=, <, <=, > e >=),
        3 - de operadores lógicos (!, && e ||),
        4 - dos comandos de seleção (if com else e switch),
        5 - de comandos repetitivos (while, do-while e for),
        6 - try-catch
        7 - qualquer função de biblioteca ou de sua própria autoria

     Observação: fica liberado o uso de funções auxiliares que seguem as mesmas regras aqui impostas e o uso de funções implementadas nesta lista de exercícios em outras funções da mesma lista de exercícios).

    Dica: use ++, --, ==, if sem else, return, recursão.
    Faça um programa para testar sua função.
     */

    public static void main(String[] args) {
        for (int i = -10; i <= 10; i++) {
            for (int j = -10; j <= 10; j++) {
                String iStr = Q1.isNegative(i) ? Integer.toString(i) : "+" + i;
                String jStr = Q1.isNegative(j) ? Integer.toString(j) : "+" + j;
                System.out.println(i + " * " + j + " = " + multiplicacao(i, j));
            }
        }
    }

    public static int multiplicacao(int a, int b) {
        if (b == 0) return 0; // Caso base: se b é 0, o resultado é 0
        if (isNegative(b))
            return subtracao(multiplicacao(a, ++b), a);
        return soma(multiplicacao(a, --b), a); // Caso geral: soma a resultado da multiplicação dê a (b-1)
    }
}