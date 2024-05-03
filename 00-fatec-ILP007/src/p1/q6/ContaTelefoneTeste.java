package p1.q6;

public class ContaTelefoneTeste {

    public static void main(String[] args) {

        ContaTelefone c1 = new ContaTelefone("19974133884", 800, 100);
        ContaTelefone c2 = new ContaTelefone("19974133883", 400, 200);

        System.out.println("ContaTelefone1" + c1);
        System.out.println("ContaTelefone2" + c2);

        ContaCelular cc1 = new ContaCelular("19974133884", 800, 100, "CPS");
        ContaCelular cc2 = new ContaCelular("19974133883", 400, 200, "Claro");

        System.out.println("\nContaCelular1" + cc1);
        System.out.println("ContaCelular2" + cc2);
    }
}
