package exercicios.disciplina;

import java.util.Objects;
import java.util.Scanner;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

public class LinguagemProgramacao extends Disciplina implements Pratica {

    private String laboratorio;

    public LinguagemProgramacao(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public float calcularMedia() {
        Scanner entrada = new Scanner(System.in);

        float nota1, nota2, mediaFinal;

        System.out.print("Digite a primeira nota: ");
        nota1 = entrada.nextFloat();

        System.out.print("Digite a segunda nota: ");
        nota2 = entrada.nextFloat();

        mediaFinal = (nota1 + 2 * nota2) / 3;

        return mediaFinal;
    }

    @Override
    public String getLaboratorio() {
        return this.laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public Object clone() {
        LinguagemProgramacao clone = null;

        try {
            clone = new LinguagemProgramacao(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    public LinguagemProgramacao(LinguagemProgramacao copy) {
        if (copy == null) throw new IllegalArgumentException("Cópia inválida");

        this.laboratorio = (String) verifyAndCopy(copy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        LinguagemProgramacao that = (LinguagemProgramacao) o;

        return Objects.equals(this.laboratorio, that.laboratorio);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + ((this.laboratorio == null) ? 0 : this.laboratorio.hashCode());

        if (hash < 0) hash = -hash;

        return hash;
    }

    @Override
    public String toString() {
        return "{\n" +
                "  \"laboratorio\": \"" + this.laboratorio + "\"\n" +
                "}";
    }
}
