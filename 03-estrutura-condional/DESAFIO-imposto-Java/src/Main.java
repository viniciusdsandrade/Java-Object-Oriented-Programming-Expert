import java.util.Scanner;

public class Main {

    /*
    Para calcular o imposto de renda que uma pessoa deve pagar, um país aplica as seguintes regras:

    1) Imposto sobre salário: a pessoa paga
    imposto sobre seu salário conforme a tabela abaixo.

    Salário MENSAL Imposto
    Abaixo de 3000 por mês Isento
    3000 até 5000 exclusive 10%
    5000 ou acima 20%

    2) Se a pessoa obteve renda com prestação de serviços, o imposto cobrado é de 15%.

    3) Se a pessoa obteve ganho de capital (imóveis, ações, etc.), o imposto cobrado é de 20%.

    4) A pessoa pode abater até 30% do seu imposto bruto devido com gastos médicos ou educacionais. Mas
    se seus gastos médicos e educacionais forem abaixo desses 30%, apenas os gastos médicos e
    educacionais podem ser abatidos.


    Fazer um programa para ler quanto a pessoa obteve de renda anual com salário, prestação de serviço e
    ganho de capital. Leia também quando a pessoal teve de gastos médicos e educacionais no ano. Seu
    programa deverá então produzir um relatório de imposto de renda dessa pessoa conforme exemplos.
    Considere a renda mensal com salário como sendo a renda anual dividida por 12.
    */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double rendaAnualSalario, rendaAnualServico, rendaAnualCapital, gastosMedicos, gastosEducacionais;
        double impostoSalario, impostoServico, impostoCapital;
        double impostoBruto, maximoDedutivel, gastosDedutiveis, abatimento, impostoDevido;

        rendaAnualSalario = lerRendaAnual(input, "Digite a renda anual com salário");
        rendaAnualServico = lerRendaAnual(input, "Digite a renda anual com prestação de serviço");
        rendaAnualCapital = lerRendaAnual(input, "Digite a renda anual com ganho de capital");

        gastosMedicos = lerGastos(input, "Digite os gastos médicos");
        gastosEducacionais = lerGastos(input, "Digite os gastos educacionais");

        input.close();

        System.out.println("\nRELATÓRIO DE IMPOSTO DE RENDA");
        System.out.println("\nCONSOLIDADO DE RENDA:");
        impostoSalario = calcularImpostoSalario(rendaAnualSalario);
        impostoServico = calcularImpostoServico(rendaAnualServico);
        impostoCapital = calcularImpostoCapital(rendaAnualCapital);

        System.out.printf("Imposto sobre salário: %.2f%n", impostoSalario);
        System.out.printf("Imposto sobre serviços: %.2f%n", impostoServico);
        System.out.printf("Imposto sobre ganho de capital: %.2f%n", impostoCapital);

        System.out.println("\nDEDUÇÕES:");
        impostoBruto = impostoSalario + impostoServico + impostoCapital;
        maximoDedutivel = impostoBruto * 0.3;
        gastosDedutiveis = gastosMedicos + gastosEducacionais;

        System.out.printf("Máximo dedutível: %.2f%n", maximoDedutivel);
        System.out.printf("Gastos dedutíveis: %.2f%n", gastosDedutiveis);

        System.out.println("\nRESUMO:");
        abatimento = Math.min(maximoDedutivel, gastosDedutiveis);
        impostoDevido = impostoBruto - abatimento;

        System.out.printf("Imposto bruto total: %.2f%n", impostoBruto);
        System.out.printf("Abatimento: %.2f%n", abatimento);
        System.out.printf("Imposto devido: %.2f%n", impostoDevido);
    }

    private static double lerRendaAnual(Scanner input, String mensagem) {
        System.out.print(mensagem + ": ");
        return input.nextDouble();
    }

    private static double lerGastos(Scanner input, String mensagem) {
        System.out.print(mensagem + ": ");
        return input.nextDouble();
    }

    public static double calcularImpostoSalario(double rendaAnualSalario) {
        double rendaMensalSalario = rendaAnualSalario / 12;
        double aliquota;

        if (rendaMensalSalario < 3000)
            aliquota = 0;
        else if (rendaMensalSalario < 5000)
            aliquota = 0.1;
        else
            aliquota = 0.2;

        return rendaAnualSalario * aliquota;
    }

    public static double calcularImpostoServico(double rendaAnualServico) {
        return rendaAnualServico * 0.15;
    }

    public static double calcularImpostoCapital(double rendaAnualCapital) {
        return rendaAnualCapital * 0.2;
    }
}