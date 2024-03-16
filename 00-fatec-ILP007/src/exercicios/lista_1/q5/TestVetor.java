package exercicios.lista_1.q5;

public class TestVetor {
    public static void main(String[] args) {
        VectorUnordered<String> vetor1 = new VectorUnordered<>(3);

        vetor1.insert("A");
        vetor1.insert("B");
        vetor1.insert("C");

        VectorUnordered<String> vetor2 = new VectorUnordered<>(vetor1);
        VectorUnordered<String> vetor3 = (VectorUnordered<String>) vetor1.clone();

        System.out.println("vetor.hashCode()  = " + vetor1.hashCode());
        System.out.println("vetor2.hashCode() = " + vetor2.hashCode());
        System.out.println("vetor3.hashCode() = " + vetor3.hashCode());

        System.out.println(vetor1);
        System.out.println(vetor2);
        System.out.println(vetor3);

        vetor1.insert("D");
        System.out.println("insert(\"D\")");

        System.out.println(vetor1);
        System.out.println(vetor2);
        System.out.println(vetor3);

        vetor1.remove(0);
        System.out.println("remove(0)");
        System.out.println(vetor1);
        System.out.println(vetor2);
        System.out.println(vetor3);
    }
}
