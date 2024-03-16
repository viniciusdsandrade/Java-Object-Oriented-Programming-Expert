package exercicios.disciplina;

public class TestDisciplina {
    public static void main(String[] args) {
        LinguagemProgramacao linguagemProgramacao = new LinguagemProgramacao("Laboratório 1");
        linguagemProgramacao.setCodigo(123);
        float notaFinal = linguagemProgramacao.calcularMedia();
        System.out.printf("A média final é: %.2f\n", notaFinal);

        System.out.println(linguagemProgramacao);
    }
}
