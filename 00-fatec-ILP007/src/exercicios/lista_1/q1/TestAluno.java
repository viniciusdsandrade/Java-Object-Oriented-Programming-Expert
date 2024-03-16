package exercicios.lista_1.q1;

public class TestAluno {
    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("123", "João", 5, 5, 5);
        Aluno copiaAluno1 = new Aluno(aluno1);
        Aluno cloneAluno1 = aluno1.clone();

        Aluno aluno2 = new Aluno("456", "Maria");
        Aluno copiaAluno2 = new Aluno(aluno2);
        Aluno cloneAluno2 = aluno2.clone();

        System.out.println("Aluno1.hashCode()       " + aluno1.hashCode());
        System.out.println("CópiaAluno1.hashCode()  " + copiaAluno1.hashCode());
        System.out.println("CloneAluno1.hashCode()  " + cloneAluno1.hashCode());

        System.out.println("Aluno2.hashCode()       " + aluno2.hashCode());
        System.out.println("CópiaAluno2.hashCode()  " + copiaAluno2.hashCode());
        System.out.println("CloneAluno2.hashCode()  " + cloneAluno2.hashCode());
    }
}
