package p1.q3;

public class Exercicio03 {

    public static int x =  7;
    public int y = 3;

    public static void main(String[] args) {
        Exercicio03 a = new Exercicio03();
        Exercicio03 b = new Exercicio03();

        a.y = 5;
        b.y = 6;
        a.x = 1;
        b.x = 2;

        System.out.println("a.x = " + a.x);
        System.out.println("b.x = " + b.x);
        System.out.println("a.y = " + a.y);
        System.out.println("b.y = " + b.y);
        System.out.println("Exercicio03.x = " + Exercicio03.x);
    }
}
