package src.z_listas.recursao;

import java.util.stream.IntStream;

import static src.z_listas.recursao.Q1.isNegative;
import static src.z_listas.recursao.Q3.subtracao;

public class Q4 {
    /*
    4.
    Faça uma única função que, recebendo como parâmetro um número inteiro, resulta módulo (valor absoluto) dele.
    Importante lembrar que o número com o qual vocês trabalharão é inteiro, logo, pode ser positivo ou negativo.
    Fica proibido declarar variáveis, fazer uso de

        1 - operadores aritméticos (+, -, *, / e %),
        2 - dos operadores relacionais (!=, <, <=, > e >=),
        3 - de operadores lógicos (!, && e ||),
        4 - dos comandos de seleção (if com else e switch),
        5 - de comandos repetitivos (while, do-while e for),
        6 - try-catch e de
        7 - qualquer função de biblioteca ou de sua própria autoria

     Observação: fica liberado o uso de funções auxiliares que seguem as mesmas regras aqui impostas e o uso de funções implementadas nesta lista de exercícios em outras funções da mesma lista de exercícios).

    Dica: use ++, --, ==, if sem else, return, recursão.
    Faça um programa para testar sua função.
     */

    public static void main(String[] args) {
        IntStream.rangeClosed(-1000, 1000).mapToObj(i -> "O módulo de " + i + " é " + modulo(i)).forEach(System.out::println);
    }

    public static int modulo(int n) {
        if (isNegative(n))
            return subtracao(-n, 0);
        return n;
    }
}
