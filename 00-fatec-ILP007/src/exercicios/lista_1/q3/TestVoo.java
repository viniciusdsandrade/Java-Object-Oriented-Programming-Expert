package exercicios.lista_1.q3;

import exercicios.lista_1.q2.Data;

public class TestVoo {
    public static void main(String[] args) {

        Voo voo1 = new Voo(1616, new Data((byte) 1, (byte) 1, (short) 2001), 15);
        Voo voo2 = new Voo(1616, new Data((byte) 1, (byte) 1, (short) 2001), 15);
        Voo voo3 = new Voo(1616, new Data((byte) 1, (byte) 1, (short) 2001), 15);
        Voo voo4 = new Voo(voo1);
        Voo voo5 = (Voo) voo1.clone();

        System.out.println("voo.hashCode()  = " + voo1.hashCode());
        System.out.println("voo2.hashCode() = " + voo2.hashCode());
        System.out.println("voo3.hashCode() = " + voo3.hashCode());
        System.out.println("voo4.hashCode() = " + voo4.hashCode());
        System.out.println("voo5.hashCode() = " + voo5.hashCode());

        System.out.println("voo.equals(voo2) = " + voo1.equals(voo2));
        System.out.println("voo.equals(voo3) = " + voo1.equals(voo3));
        System.out.println("voo.equals(voo4) = " + voo1.equals(voo4));
        System.out.println("voo.equals(voo5) = " + voo1.equals(voo5));

        System.out.println("voo1.compareTo(voo2) = " + voo1.compareTo(voo2));
        System.out.println("voo1.compareTo(voo3) = " + voo1.compareTo(voo3));
        System.out.println("voo1.compareTo(voo4) = " + voo1.compareTo(voo4));
        System.out.println("voo1.compareTo(voo5) = " + voo1.compareTo(voo5));

        System.out.println(voo1);
        System.out.println(voo2);
        System.out.println(voo3);
        System.out.println(voo4);
        System.out.println(voo5);
    }
}
