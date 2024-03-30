package exercicios.lista_2.q1;

import exercicios.lista_1.q2.Data;
import exercicios.lista_1.q3.Voo;

import java.util.Arrays;
import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

/*
Escreva uma classe herdeira à voo criada na lista de exercícios anterior,
que permita definir quantas cadeiras existem no máximo no voo e se dividir
o avião em ala de fumantes e não fumantes.

Para isto esta classe deve acrescentar os atributos necessários e adicionar os seguintes métodos:

    1 - construtor além dos parâmetros recebidos pelo construtor da superclasse, receberá também
    como parâmetros o número de vagas do voo e quantas cadeiras serão destinadas para
    fumantes
    2 - maxVagas determina o número máximo de cadeiras no voo
    3 - cadeirasFumantes determina quantas cadeiras estão destinadas aos fumantes (as demais serão
    automaticamente destinadas aos não fumantes); as cadeiras dos fumantes serão sempre as últimas do avião
    4 - tipo recebe como parâmetro o número da cadeira e retorna ‘F’ se for uma cadeira para
    fumantes e ‘N’ se for para não fumantes

    Os métodos proximoLivre, verifica e ocupa da superclasse devem ser adaptados para tratar o número
    máximo de vagas informado, ao invés do número fixo de 100.
 */
public class Voo2 extends Voo implements Cloneable {

    private int numeroVoo;
    private Data data;
    private char[] cadeiras;
    private int maxVagas;
    private int cadeirasFumantes;
    private int cadeirasNaoFumantes;

    public Voo2() {
    }

    public Voo2(int numero,
                Data data,
                int maxVagas,
                int cadeirasFumantes,
                int cadeirasNaoFumantes) {

        super(numero, data);

        if (maxVagas < 0) throw new IllegalArgumentException("Lotação do voo não pode ser negativa");
        if (maxVagas > 615) throw new IllegalArgumentException("Lotação do voo não pode ser maior que 615");
        if (cadeirasFumantes < 0)
            throw new IllegalArgumentException("Número de cadeiras fumantes não pode ser negativo");
        if (cadeirasNaoFumantes < 0)
            throw new IllegalArgumentException("Número de cadeiras não fumantes não pode ser negativo");
        if (cadeirasFumantes > maxVagas)
            throw new IllegalArgumentException("Número de cadeiras fumantes não pode ser maior que a lotação do voo");
        if (cadeirasNaoFumantes > maxVagas)
            throw new IllegalArgumentException("Número de cadeiras não fumantes não pode ser maior que a lotação do voo");
        if (cadeirasFumantes + cadeirasNaoFumantes != maxVagas)
            throw new IllegalArgumentException("A soma das cadeiras fumantes e não fumantes não pode ser maior que a lotação do voo");

        this.maxVagas = cadeirasFumantes + cadeirasNaoFumantes;
        this.cadeirasFumantes = cadeirasFumantes;
        this.cadeirasNaoFumantes = cadeirasNaoFumantes;
        this.cadeiras = new char[maxVagas];
        this.numeroVoo = numero;
        this.data = data;

        for (int i = 0; i < maxVagas; i++) {
            if (i < cadeirasFumantes)
                this.cadeiras[i] = 'N';
            else
                this.cadeiras[i] = 'F';
        }
    }

    @Override
    public boolean verifica(int cadeira) {
        if (cadeira < 0 || cadeira >= maxVagas)
            throw new IllegalArgumentException("Cadeira inválida");

        return isCadeiraFumante(cadeira) || isCadeiraNaoFumante(cadeira);
    }

    @Override
    public void ocupa(int cadeira) {

        if (cadeira < 0 || cadeira >= maxVagas)
            throw new IllegalArgumentException("Cadeira inválida");

        if (!verifica(cadeira))
            throw new IllegalArgumentException("Cadeira já ocupada");

        cadeiras[cadeira] = 'O';

        if (isCadeiraFumante(cadeira))
            cadeirasFumantes--;
        else
            cadeirasNaoFumantes--;

        cadeiras[cadeira] = 'O';
    }

    public boolean isCadeiraFumante(int cadeira) {
        return cadeiras[cadeira] == 'F';
    }

    public boolean isCadeiraNaoFumante(int cadeira) {
        return cadeiras[cadeira] == 'N';
    }

    public int buscaPrimeiraCadeiraNaoFumante() {
        for (int i = 0; i < maxVagas; i++) {
            if (isCadeiraNaoFumante(i)) {
                return i;
            }
        }
        return -1;
    }

    public int buscaPrimeiraCadeiraFumante() {
        for (int i = 0; i < maxVagas; i++) {
            if (isCadeiraFumante(i)) {
                return i;
            }
        }
        return -1;
    }

    public void ocupaVagaNormal() {
        int cadeira = buscaPrimeiraCadeiraNaoFumante();

        if (cadeira == -1)
            throw new IllegalArgumentException("Não há mais cadeiras não fumantes disponíveis");

        cadeiras[cadeira] = 'O';
        this.cadeirasNaoFumantes--;
    }

    public void ocupaVagaFumante() {
        int cadeira = buscaPrimeiraCadeiraFumante();

        if (cadeira == -1)
            throw new IllegalArgumentException("Não há mais cadeiras fumantes disponíveis");

        cadeiras[cadeira] = 'O';
        this.cadeirasFumantes--;
    }

    public int getVagasNaoFumantesRestantes() {
        return cadeirasNaoFumantes;
    }

    public int getVagasFumantesRestantes() {
        return cadeirasFumantes;
    }

    public char getTipoCadeira(int cadeira) {
        if (cadeira < 0 || cadeira >= maxVagas)
            throw new IllegalArgumentException("Cadeira inválida");

        return cadeiras[cadeira];
    }

    public int cadeirasFumantes() {
        return cadeirasFumantes;
    }

    public int maxVagas() {
        return maxVagas;
    }

    public char[] getCadeirasLivres() {
        char[] cadeirasLivres = new char[maxVagas];
        for (int i = 0; i < maxVagas; i++) {
            if (cadeiras[i] != 'O') {
                cadeirasLivres[i] = cadeiras[i];
            }
        }
        return cadeirasLivres;
    }

    @Override
    public int proximoLivre() {
        for (int i = 0; i < maxVagas; i++) {
            if (cadeiras[i] != 'O') {
                return i;
            }
        }
        return -1;
    }

    private int cadeirasOcupadas() {
        int ocupadas = 0;
        for (int i = 0; i < maxVagas; i++) {
            if (cadeiras[i] == 'O') {
                ocupadas++;
            }
        }
        return ocupadas;
    }

    @Override
    public int vagas() {
        return maxVagas - cadeirasOcupadas();
    }

    @Override
    public Object clone() {
        Voo2 clone = null;

        try {
            clone = new Voo2(this);
        } catch (Exception ignored) {
        }
        return clone;
    }

    public Voo2(Voo2 original) {

        if (original == null) throw new IllegalArgumentException("Modelo inválido");

        this.numeroVoo = (int) verifyAndCopy(original.numeroVoo);
        this.data = (Data) verifyAndCopy(original.data);
        this.maxVagas = (int) verifyAndCopy(original.maxVagas);
        this.cadeirasFumantes = (int) verifyAndCopy(original.cadeirasFumantes);
        this.cadeirasNaoFumantes = (int) verifyAndCopy(original.cadeirasNaoFumantes);
        this.cadeiras = null;

        if (original.cadeiras != null) {
            this.cadeiras = new char[original.cadeiras.length];
            for (int i = 0; i < original.cadeiras.length; i++) {
                this.cadeiras[i] = (char) verifyAndCopy(original.cadeiras[i]);
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Voo2 voo = (Voo2) obj;

        for (int i = 0; i < maxVagas; i++) {
            if (this.cadeiras[i] != voo.cadeiras[i])
                return false;
        }

        return Objects.equals(this.data, voo.data) &&
                Objects.equals(this.numeroVoo, voo.numeroVoo) &&
                Objects.equals(this.maxVagas, voo.maxVagas) &&
                Objects.equals(this.cadeirasFumantes, voo.cadeirasFumantes) &&
                Objects.equals(this.cadeirasNaoFumantes, voo.cadeirasNaoFumantes);
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = super.hashCode();

        hash *= prime + Integer.hashCode(numeroVoo);
        hash *= prime + Objects.hashCode(data);
        hash *= prime + Integer.hashCode(maxVagas);
        hash *= prime + Integer.hashCode(cadeirasFumantes);
        hash *= prime + Integer.hashCode(cadeirasNaoFumantes);

        for (int i = 0; i < maxVagas; i++)
            hash *= prime + (int) cadeiras[i];

        if (hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        sb.append("    \"numeroVoo\": ").append(numeroVoo).append(",\n");
        sb.append("    \"data\": \"").append(this.data.toString()).append("\",\n");
        sb.append("    \"cadeiras\": [\n");
        for (int i = 0; i < cadeiras.length; i++) {
            sb.append("        ").append(cadeiras[i]);
            if (i < cadeiras.length - 1) {
                sb.append(",");
            }
            sb.append("\n");
        }
        sb.append("    ],\n");
        sb.append("    \"maxVagas\": ").append(maxVagas).append(",\n");
        sb.append("    \"cadeirasFumantes\": ").append(cadeirasFumantes).append(",\n");
        sb.append("    \"cadeirasNaoFumantes\": ").append(cadeirasNaoFumantes).append("\n");
        sb.append("}");
        return sb.toString();
    }

    public String getCadeirasLivresString() {
        for (int i = 0; i < maxVagas; i++) {
            if (cadeiras[i] != 'O') {
                return Arrays.toString(cadeiras);
            }
        }
        return "Todas as cadeiras estão ocupadas";
    }
}
