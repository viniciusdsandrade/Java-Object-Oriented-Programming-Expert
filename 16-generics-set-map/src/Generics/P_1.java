package src.Generics;

import java.util.*;

public class P_1 {
    /*
    Deseja-se fazer um programa que leia uma quantidade N, e depois N números
    inteiros. Ao final, imprima esses números de forma organizada conforme
    exemplo. Em seguida, informar qual foi o primeiro valor informado.

    How many values? 3 
    10
    8
    23
    [10, 8, 23]
    First: 10
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("How many values? ");
        int n = sc.nextInt();

        PrintService<Integer> ps = new PrintService<>();
        
        for(int i = 0; i < n; i++) {
            System.out.print("Enter value #" + (i + 1) + ": ");
            int value = sc.nextInt();
            ps.addValue(value);
        }
        
        ps.print();
        Integer x = ps.first();
        
        System.out.println("First: " + x);
        sc.close();
    }
}