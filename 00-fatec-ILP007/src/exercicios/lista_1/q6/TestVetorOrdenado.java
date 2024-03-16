package exercicios.lista_1.q6;

public class TestVetorOrdenado {

    public static void main(String[] args) {

        VectorOrdered<Integer> inteiros1 = new VectorOrdered<>(5);
        VectorOrdered<Integer> inteiros2 = new VectorOrdered<>(5);
        inteiros2.insert(10);
        inteiros1.insert(9);
        inteiros2.insert(8);
        inteiros1.insert(7);
        inteiros2.insert(6);
        inteiros1.insert(5);
        inteiros2.insert(4);
        inteiros1.insert(3);
        inteiros2.insert(2);
        inteiros1.insert(1);
        System.out.println("inteiros1: " + inteiros1);
        System.out.println("inteiros2: " + inteiros2);

        VectorOrdered<Integer> inteiros3 = inteiros1.merge(inteiros2);
        System.out.println("Merge de inteiros1 e inteiros2");
        System.out.println("inteiros3: " + inteiros3);

        VectorOrdered<String> vetor = new VectorOrdered<>(5);
        vetor.insert("Elias");
        vetor.insert("Dora");
        vetor.insert("Carlos");
        vetor.insert("Bia");
        vetor.insert("Arthur");
        System.out.println(vetor);
        vetor.remove(2);
        System.out.println("Removendo Carlos");
        System.out.println(vetor);

        VectorOrdered<Integer> vetor2 = new VectorOrdered<>(5);
        vetor2.insert(5);
        vetor2.insert(4);
        vetor2.insert(3);
        vetor2.insert(2);
        vetor2.insert(1);
        System.out.println(vetor2);

        VectorOrdered<Character> vetor3 = new VectorOrdered<>(5);
        vetor3.insert('E');
        vetor3.insert('D');
        vetor3.insert('C');
        vetor3.insert('B');
        vetor3.insert('A');
        System.out.println(vetor3);

        VectorOrdered<Float> vetor4 = new VectorOrdered<>(5);
        vetor4.insert(5.0f);
        vetor4.insert(4.0f);
        vetor4.insert(3.0f);
        vetor4.insert(2.0f);
        vetor4.insert(1.0f);
        System.out.println(vetor4);

        VectorOrdered<Double> vetor5 = new VectorOrdered<>(5);
        vetor5.insert(5.0);
        vetor5.insert(4.0);
        vetor5.insert(3.0);
        vetor5.insert(2.0);
        vetor5.insert(1.0);
        System.out.println(vetor5);

        VectorOrdered<Long> vetor6 = new VectorOrdered<>(5);
        vetor6.insert(5L);
        vetor6.insert(4L);
        vetor6.insert(3L);
        vetor6.insert(2L);
        vetor6.insert(1L);
        System.out.println(vetor6);

        VectorOrdered<Short> vetor7 = new VectorOrdered<>(5);
        vetor7.insert((short) 5);
        vetor7.insert((short) 4);
        vetor7.insert((short) 3);
        vetor7.insert((short) 2);
        vetor7.insert((short) 1);
        System.out.println(vetor7);

        VectorOrdered<Byte> vetor8 = new VectorOrdered<>(5);
        vetor8.insert((byte) 5);
        vetor8.insert((byte) 4);
        vetor8.insert((byte) 3);
        vetor8.insert((byte) 2);
        vetor8.insert((byte) 1);
        System.out.println(vetor8);
    }
}
