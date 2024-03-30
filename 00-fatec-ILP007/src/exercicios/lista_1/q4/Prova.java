package exercicios.lista_1.q4;

import java.util.Arrays;
import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

/*
Considere a seguinte classe, cujo método respostaQuestao recebe como parâmetro o número de uma
questão e retorna a sua resposta correta, proveniente de um gabarito.

    public class Gabarito
    {
        public char respostaQuestao(int numeroQuestao)
        {:}
    }

Escreva uma classe Prova em que cada objeto representa uma prova feita por um aluno.
Esta prova possui 15 questões de múltipla escolha (letras A a E).

As 10 primeiras questões valem 0,5 ponto e as 5 últimas questões valem 1 ponto.
Esta classe deverá controlar as questões respondidas pelo aluno.

Para isto, a classe deve implementar os métodos:

    1 - construtor    - recebe como parâmetro um objeto da classe Gabarito contendo o gabarito da prova
    2 - respostaAluno - recebe como parâmetro a resposta dada pelo aluno a uma questão; este método não
                        recebe entre os parâmetros o número da questão, ele mesmo deve estabelecer um
                        controle interno de modo que as questões sejam inseridas sequencialmente, ou seja, a
                        primeira vez que o método é chamado, insere a primeira questão, a segunda, insere a
                        segunda questão, e assim por diante.
    3 - Acertos       - retorna a quantidade de questões que o aluno acertou
    4 - nota          - retorna a nota que o aluno tirou na prova
    5 - maior         - recebe como parâmetro outro objeto da classe Prova e retorna a nota do aluno que
                        acertou mais questões; se houver empate, retorna a maior nota; se houver empate
                        novamente, retorna a nota do aluno representado no objeto corrente
 */
public class Prova implements Cloneable, Comparable<Prova> {

    private final Gabarito gabarito;
    private final char[] respostasAluno = new char[15];
    private int questaoAtual = 0;

    public Prova(Gabarito gabarito) {
        this.gabarito = gabarito;
    }

    public void respostaAluno(char resposta) {
        if (questaoAtual >= 15)
            throw new IllegalStateException("Todas as questões já foram respondidas.");

        if (resposta < 'A' || resposta > 'E')
            throw new IllegalArgumentException("Resposta inválida.");

        respostasAluno[questaoAtual++] = resposta;
    }

    private boolean respostaCorreta(int questao) {
        return respostasAluno[questao] == gabarito.respostaQuestao(questao + 1);
    }

    public int acertos() {
        int acertos = 0;

        for (int i = 0; i < 15; i++)
            if (respostaCorreta(i))
                acertos++;

        return acertos;
    }

    public double nota() {
        int acertos = acertos();
        double nota = 0;

        for (int i = 0; i < 15; i++) {
            if (i < 10) nota = nota + (respostaCorreta(i) ? 0.5 : 0);
            else nota = nota + (respostaCorreta(i) ? 1 : 0);
        }

        return nota;
    }

    public double maior(Prova outraProva) {
        int acertos = acertos();
        int acertosOutraProva = outraProva.acertos();

        if (acertos > acertosOutraProva) return nota();
        if (acertos < acertosOutraProva) return outraProva.nota();

        return Math.max(nota(), outraProva.nota());
    }

    public Prova(Prova modelo) {

        if (modelo == null) throw new IllegalArgumentException("Modelo não pode ser nulo.");

        this.gabarito = (Gabarito) verifyAndCopy(modelo.gabarito);
        this.questaoAtual = (int) verifyAndCopy(modelo.questaoAtual);

        for (int i = 0; i < 15; i++)
            this.respostasAluno[i] = (char) verifyAndCopy(modelo.respostasAluno[i]);
    }

    @Override
    public Object clone() {
        Prova clone = null;

        try {
            clone = new Prova(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Prova that = (Prova) o;

        for (int i = 0; i < 15; i++)
            if (this.respostasAluno[i] != that.respostasAluno[i])
                return false;

        return Objects.equals(this.gabarito, that.gabarito);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + (this.gabarito == null ? 0 : this.gabarito.hashCode());

        for (char resposta : respostasAluno)
            hash *= prime + Character.hashCode(resposta);

        if (hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Prova:\n");
        sb.append("\tRespostas do aluno: ").append(Arrays.toString(respostasAluno)).append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Prova o) {

        if (this.acertos() > o.acertos()) return 1;
        if (this.acertos() < o.acertos()) return -1;

        return Double.compare(this.nota(), o.nota());
    }
}
