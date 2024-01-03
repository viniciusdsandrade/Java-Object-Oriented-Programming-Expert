package src.Generics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class P_2 {
    
    /*
    Problema

    Criar um serviço de cálculo:
    Computer,890.50
    IPhone X,910.00
    Tablet,550.00
    Most expensive:
    IPhone, 910.00

    Uma empresa de consultoria deseja avaliar a performance de produtos,
    funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar
    o maior dentre um conjunto de elementos. Fazer um programa que leia um
    conjunto de produtos a partir de um arquivo, conforme exemplo, e depois
    mostre o mais caro deles.
     */

    public static void main(String[] args) {

        List<Product> list = new ArrayList<>();
        Locale.setDefault(Locale.US);
        String path = "C:\\Users\\Pichau\\Desktop\\poo-ultimate\\Java-Object-Oriented-Programming-Expert\\16-generics-set-map\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                list.add(new Product(fields[0], Double.parseDouble(fields[1])));
            }

            Product x = CalculationService.max(list);
            System.out.println("Most expensive:\n" + x);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}