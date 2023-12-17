import java.util.Scanner;

public class Main {

    /*
    Fazer um programa para ler uma quantidade N (supor N > 0), depois ler os dados de N atletas (nome,
    sexo, altura, peso). Depois, mostrar um relatório contendo:

         Peso médio dos atletas
         Nome do atleta mais alto
         Porcentagem de homens
         Altura média das mulheres

    Caso não sejam digitadas mulheres, a altura média não poderá ser calculada (pois divisão por zero não
    existe). Neste caso, apenas mostrar a mensagem "Não há mulheres cadastradas".

    Fazer validações de dados para altura e peso, não permitindo digitar valores não positivos para esses
    dados.

    Faça também a validação do sexo, não permitindo valores diferentes de F e M.

    Dica: para validar o sexo, a lógica é: tem que pedir para o usuário digitar novamente enquanto o valor
    digitado for diferente de "F" E diferente de "M"
    */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double pesoMedio = 0f;
        double alturaMediaMulheres = 0f;
        int qtdMulheres = 0;
        double maiorAltura = 0f;
        String nomeMaiorAltura = "";

        int n;
        System.out.print("Qual a quantidade de atletas? ");
        do {
            while (!sc.hasNextInt()) {
                System.out.print("Isso não é um número inteiro. Por favor, digite novamente: ");
                sc.next(); // descarta a entrada inválida
            }
            n = sc.nextInt();
            if (n < 0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
            }
        } while (n < 0);

        sc.nextLine(); // Consumir a quebra de linha pendente

        for (int i = 0; i < n; i++) {
            System.out.printf("Digite os dados do atleta numero %d:\n", (i + 1));

            System.out.print("Nome: ");
            String nome = sc.nextLine().trim();

            while (nome.length() < 3) {
                System.out.println("O nome deve ter pelo menos 3 caracteres. Por favor, digite novamente.");
                System.out.print("Nome: ");
                nome = sc.nextLine().trim();
            }

            char sexo;
            do {
                System.out.print("Sexo: ");
                sexo = sc.next().charAt(0);
                if (sexo != 'F' && sexo != 'f' && sexo != 'M' && sexo != 'm') {
                    System.out.print("Valor invalido! Favor digitar F ou M: ");
                }
            } while (sexo != 'F' && sexo != 'f' && sexo != 'M' && sexo != 'm');


            double altura;
            System.out.print("Altura: ");
            do {

                while (!sc.hasNextDouble()) {
                    System.out.print("Valor inválido! Digitar um valor do tipo Double: ");
                    sc.next(); // descarta a entrada inválida
                }
                altura = sc.nextDouble();

                if (altura <= 0 || altura > 3.0) {
                    System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                }
            } while (altura <= 0 || altura > 3.0);

            if (sexo == 'F' || sexo == 'f') {
                alturaMediaMulheres += altura;
                qtdMulheres++;
            }

            if (altura > maiorAltura) {
                maiorAltura = altura;
                nomeMaiorAltura = nome;
            }

            double peso;
            System.out.print("Peso: ");
            do {

                while (!sc.hasNextDouble()) {
                    System.out.print("Isso não é um número válido. Por favor, digite novamente: ");
                    sc.next(); // descarta a entrada inválida
                }
                peso = sc.nextDouble();
                if (peso <= 0 || peso > 500) {
                    System.out.print("Peso inválido. O peso deve ser um valor positivo e menor ou igual a 500. Por favor, digite novamente: ");
                }
            } while (peso <= 0 || peso > 500);

            sc.nextLine(); // Consumir a quebra de linha pendente

            pesoMedio += peso;
        }

        System.out.println("\nRELATÓRIO: ");
        System.out.printf("Peso médio dos atletas: %.2f \n", pesoMedio / n);
        System.out.println("Nome do atleta mais alto: " + nomeMaiorAltura);
        System.out.printf("Porcentagem de homens: %.1f %%\n", (double) (n - qtdMulheres) / n * 100);
        if (qtdMulheres > 0)
            System.out.printf("Altura média das mulheres: %.2f \n", alturaMediaMulheres / qtdMulheres);
        else
            System.out.println("Não há mulheres cadastradas");
    }
}