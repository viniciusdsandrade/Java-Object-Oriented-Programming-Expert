package exercicios.escola;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Vinícius dos Santos Andrade", "Rua Orlando de Oliveira");
        PessoaFisica pessoaFisica = new PessoaFisica("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "447.840.608-76", "50.562.905-7");
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Vinícius dos Santos Andrade", "Rua Orlando de Oliveira", "447.840.608-76", "50.562.905-7");
        Professor professor = new Professor("Vinícius dos Santos Andrade", "Rua Orlando de Oliveira 375", "447.840.608-76", "50.562.905-7", LocalDate.of(2021, 10, 10), "50.562.905-7", new BigDecimal(1000));
        Aluno aluno = new Aluno("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "50.562.905-7", "447.840.608-76", "22333", "Ciência da Computação");
        Visitante visitante = new Visitante("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "447.840.608-76", "50.562.905-7", LocalDateTime.of(2021, 10, 10, 10, 10), LocalDateTime.of(2021, 10, 10, 10, 10));

        professor.addDisciplinas(List.of("Matemática", "Física", "Química"));

        /*
         Upcasting = Converter uma referência de uma classe filha para uma referência de uma classe pai
         */
        Pessoa pessoaFisicaToPessoa = new PessoaFisica("Vinícius dos Santos Andrade", "Rua Orlando de Oliveira", "447.840.608-76", "50.562.905-7");
        Pessoa pessoaJuridicaToPessoa = new PessoaJuridica("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "447.840.608-76", "50.562.905-7");
        Pessoa professorToPessoa = new Professor("Vinícius dos Santos Andrade", "Rua Orlando de Oliveira 375", "447.840.608-76", "50.562.905-7", LocalDate.of(2021, 10, 10), "50.562.905-7", new BigDecimal(1000));
        Pessoa alunoToPessoa = new Aluno("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "50.562.905-7", "447.840.608-76", "22333", "Ciência da Computação");
        Pessoa visitanteToPessoa = new Visitante("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "447.840.608-76", "50.562.905-7", LocalDateTime.of(2021, 10, 10, 10, 10), LocalDateTime.of(2021, 10, 10, 10, 10));
        PessoaFisica professorToPessoaFisica = new Professor("Vinícius dos Santos Andrade", "Rua Orlando de Oliveira 375", "447.840.608-76", "50.562.905-7", LocalDate.of(2021, 10, 10), "50.562.905-7", new BigDecimal(1000));
        PessoaFisica alunoToPessoaFisica = new Aluno("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "50.562.905-7", "447.840.608-76", "22333", "Ciência da Computação");
        PessoaFisica visitanteToPessoaFisica = new Visitante("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "447.840.608-76", "50.562.905-7", LocalDateTime.of(2021, 10, 10, 10, 10), LocalDateTime.of(2021, 10, 10, 10, 10));

        /*
        Downcasting = Converter uma referência de uma classe pai para uma referência de uma classe filha
        Não é feita implicitamente pelo compilador, é necessário fazer um casting explícito ou uma verificação com o 'instanceof'
        */
        PessoaFisica pessoaToPessoaFisica = (PessoaFisica) pessoaFisicaToPessoa;
        PessoaJuridica pessoaToPessoaJuridica = (PessoaJuridica) pessoaJuridicaToPessoa;
        Aluno pessoaToAluno = (Aluno) alunoToPessoa;
        Visitante pessoaToVisitante = (Visitante) visitanteToPessoa;
        Professor pessoaToProfessor = (Professor) professorToPessoa;
        Professor pessoFisicaToProfessor = (Professor) professorToPessoaFisica;
        Aluno pessoaFisicaToAluno = (Aluno) alunoToPessoaFisica;
        Visitante pessoaFisicaToVisitante = (Visitante) visitanteToPessoaFisica;

        boolean isPessoaFisicaInstanceOfPessoa = pessoaFisicaToPessoa instanceof PessoaFisica;
        boolean isPessoaInstanceOfPessoa = pessoaJuridicaToPessoa instanceof PessoaJuridica;
        boolean isPessoaJuridicaInstanceOfPessoa = pessoaToPessoaJuridica instanceof PessoaJuridica;
        boolean isProfessorInstanceOfPessoa = professorToPessoa instanceof Professor;
        boolean isAlunoInstanceOfPessoa = alunoToPessoa instanceof Aluno;
        boolean isVisitanteInstanceOfPessoa = visitanteToPessoa instanceof Visitante;
        boolean isProfessorInstanceOfPessoaFisica = professorToPessoaFisica instanceof Professor;
        boolean isVisitanteInstanceOfPessoaFisica = visitanteToPessoaFisica instanceof Visitante;

        System.out.println(isPessoaFisicaInstanceOfPessoa);
        System.out.println(isPessoaJuridicaInstanceOfPessoa);
        System.out.println(isPessoaInstanceOfPessoa);
        System.out.println(isProfessorInstanceOfPessoa);
        System.out.println(isAlunoInstanceOfPessoa);
        System.out.println(isVisitanteInstanceOfPessoa);
        System.out.println(isProfessorInstanceOfPessoaFisica);
        System.out.println(isVisitanteInstanceOfPessoaFisica);
        System.out.println();

        ((Professor) professorToPessoa).addDisciplinas(List.of("Matemática", "Física", "Química"));
        ((Professor) professorToPessoaFisica).addDisciplinas(List.of("Matemática", "Física", "Química"));
        pessoaToProfessor.addDisciplinas(List.of("Matemática", "Física", "Química"));
        pessoFisicaToProfessor.addDisciplinas(List.of("Matemática", "Física", "Química"));

        System.out.println(pessoa);
        System.out.println(pessoaFisica);
        System.out.println(pessoaJuridica);
        System.out.println(professor);
        System.out.println(aluno);
        System.out.println(visitante);
        System.out.println();

        System.out.println(pessoaFisicaToPessoa);
        System.out.println(pessoaJuridicaToPessoa);
        System.out.println(professorToPessoa);
        System.out.println(alunoToPessoa);
        System.out.println(visitanteToPessoa);
        System.out.println(professorToPessoaFisica);
        System.out.println();

        System.out.println(pessoaFisicaToPessoa);
        System.out.println(pessoaJuridicaToPessoa);
        System.out.println(alunoToPessoa);
        System.out.println(visitanteToPessoa);
        System.out.println(professorToPessoa);
        System.out.println(professorToPessoaFisica);
        System.out.println(alunoToPessoaFisica);
        System.out.println(visitanteToPessoaFisica);
        
       /*
        Exemplos que dão errado por ClassCastException
        exercicios.escola.PessoaFisica viniciusPF2 = (exercicios.escola.PessoaFisica) new exercicios.escola.Pessoa(vinicius,"Vinícius dos Santos Andrade", "Rua Orlando de Oliveira");
        exercicios.escola.PessoaJuridica arthurPJ = (exercicios.escola.PessoaJuridica) new exercicios.escola.Pessoa("Arthur dos Santos Andrade", "Rua Orlando de Oliveira");
        exercicios.escola.Professor arthurProfessor = (exercicios.escola.Professor) new exercicios.escola.Pessoa("Arthur dos Santos Andrade", "Rua Orlando de Oliveira");
        exercicios.escola.Professor aluno3 = (exercicios.escola.Professor) new exercicios.escola.PessoaFisica("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "50.562.905-7", "447.840.608-76");
        exercicios.escola.Aluno alunoPessoa = (exercicios.escola.Aluno) new exercicios.escola.Pessoa("Arthur dos Santos Andrade", "Rua Orlando de Oliveira");
        exercicios.escola.Aluno alunoPessoaFisica = (exercicios.escola.Aluno) new exercicios.escola.PessoaFisica("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "50.562.905-7", "447.840.608-76");
        exercicios.escola.Visitante visitantePessoa = (exercicios.escola.Visitante) new exercicios.escola.Pessoa("Arthur dos Santos Andrade", "Rua Orlando de Oliveira");
        exercicios.escola.Visitante visitantePessoaFisica = (exercicios.escola.Visitante) new exercicios.escola.PessoaFisica("Arthur dos Santos Andrade", "Rua Orlando de Oliveira", "50.562.905-7", "447.840.608-76");
        */
    }
}