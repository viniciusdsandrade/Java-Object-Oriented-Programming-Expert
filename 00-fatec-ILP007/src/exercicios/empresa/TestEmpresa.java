package exercicios.empresa;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import static exercicios.empresa.Empregado.getDepartamento;
import static exercicios.empresa.Empregado.totalFuncionario;

public class TestEmpresa {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        System.out.print("Digite o nome do empresa: ");
        String nome = entrada.nextLine();

        System.out.print("Digite o departamento do empresa: ");
        String departamento = entrada.nextLine();

        System.out.print("Digite o salário do empresa: ");
        BigDecimal salario = entrada.nextBigDecimal();

        Empregado e5 = new Empregado(nome, departamento, salario);
        System.out.println(e5);

        Empregado e1 = new Empregado("João", "TI");
        Empregado e2 = new Empregado("Maria", "RH", new BigDecimal("3000.00"));
        Empregado e3 = new Empregado("José", "RH", new BigDecimal("4000.00"));
        Empregado e4 = new Empregado("Maria", "TI", new BigDecimal("5000.00"));

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);

        BigDecimal mediaSalarial = new BigDecimal("0.00");

        List<Empregado> empregados = List.of(e1, e2, e3, e4, e5);

        for (Empregado empregado : empregados)
            mediaSalarial = mediaSalarial.add(empregado.getSalario());

        System.out.println("Total de funcionários: " + totalFuncionario());
        System.out.println("Departamento e1: " + e1.getDepartamento());
        System.out.println("Departamento e2: " + getDepartamento(e1));
    }
}
