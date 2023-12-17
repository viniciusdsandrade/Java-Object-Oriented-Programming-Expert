import java.util.Scanner;

public class Main {
    /*
    Em um bar, o ingresso custa
    10 reais para homens e
    8 reais para mulheres.

    Cada cerveja custa 5 reais,
    cada refrigerante 3 reais e
    cada espetinho custa7.

    Além disso, o bar cobra uma taxa de couvert artístico no valor de 4 reais,
    porém, se o valor gasto com consumo for superior a 30 reais, o couvert
    artístico não é cobrado.

    Fazer um programa para ler os seguintes dados de
    um cliente do bar: sexo (F ou M),
    quantidade de cervejas, refrigerantes e espetinhos consumidos.

    O programa deve então mostrar um relatório com a conta a ser paga pelo cliente.
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sexo: ");
        char gender = scanner.next().charAt(0);

        System.out.print("Quantidade de cervejas: ");
        int beer = scanner.nextInt();

        System.out.print("Quantidade de refrigerantes: ");
        int softDrink = scanner.nextInt();

        System.out.print("Quantidade de espetinhos: ");
        int barbecue = scanner.nextInt();

        Bill bill = new Bill(gender, beer, barbecue, softDrink);

        System.out.println("\nRELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f\n", bill.feeding());
        if (bill.cover() == 0)
            System.out.println("Isento de Couvert");
        else
            System.out.printf("Couvert = R$ %.2f\n", bill.cover());
        System.out.printf("Ingresso = R$ %.2f\n", bill.ticket());
        System.out.printf("\nValor a pagar = R$ %.2f\n", bill.total());
    }
}