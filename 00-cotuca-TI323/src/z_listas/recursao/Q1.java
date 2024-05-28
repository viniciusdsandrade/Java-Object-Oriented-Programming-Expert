package src.z_listas.recursao;

import java.util.stream.IntStream;

public class Q1 {
    /*
    1.
    Faça uma função que, recebendo como parâmetro um único número inteiro, resulta verdadeiro, caso o mesmo seja negativo, ou falso, caso contrário.
    Na implementação de sua função,
    fica proibido declarar variáveis, fazer uso de
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
        IntStream.rangeClosed(-100, 100).mapToObj(i -> i + " é negativo? " + isNegative(i)).forEach(System.out::println);
    }

    public static boolean isNegative(int numero) {
        if (numero == 0) return false;
        return isNegativeAuxiliar(numero, numero);
    }

    public static boolean isNegativeAuxiliar(int a, int b) {
        if (a == 0) return true;
        if (b == 0) return false;
        return isNegativeAuxiliar(++a, --b);
    }
}
