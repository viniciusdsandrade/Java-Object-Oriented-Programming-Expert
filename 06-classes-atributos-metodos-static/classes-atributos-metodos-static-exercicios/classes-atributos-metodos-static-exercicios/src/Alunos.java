public class Alunos {
    private final String nome;
    private final double nota1;
    private final double nota2;
    private final double nota3;

    public Alunos(String nome, double nota1, double nota2, double nota3) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
    }

    public String getNome() {
        return nome;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public double finalGrade() {
        return nota1 + nota2 + nota3;
    }

    public double missingPoints() {
        if (finalGrade() < 60.0)
            return 60.0 - finalGrade();
        else
            return 0.0;
    }
}