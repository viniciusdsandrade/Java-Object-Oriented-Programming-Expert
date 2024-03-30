package exercicios.lista_1.q3;

import exercicios.lista_1.q2.Data;

import java.util.Arrays;
import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;
import static exercicios.lista_1.q2.Data.isValidDate;

/*
Escreva uma classe em que cada objeto representa um vôo que acontece em determinada data e em determinado horário.
Cada vôo possui no máximo 100 passageiros, e a classe permite controlar a ocupação das vagas.

A classe deve ter os seguintes métodos:
    1 - construtor configura os dados do vôo (recebidos como parâmetro):
        número do vôo,
        data (para armazenar a data utilize um objeto da classe Data, criada na questão anterior);
    2 - proximoLivre    - retorna o número da próxima cadeira livre
    3 - verifica        - verifica se o número da cadeira recebido como parâmetro está ocupada (retorna verdadeiro se estiver ocupada e falso caso contrário)
    4 - ocupa           - ocupa determinada cadeira do vôo, cujo número é recebido como parâmetro, e retorna verdadeiro se a cadeira ainda não estiver ocupada
                          (operação foi bem sucedida) e falso caso contrário
    5 - vagas           - retorna o número de cadeiras vagas disponíveis (não ocupadas) no vôo
    6 - getVoo          - retorna o número do vôo
 */
public class Voo implements Cloneable, Comparable<Voo> {

    private int numeroVoo;
    private Data data;
    private boolean[] cadeiras;

    public Voo() {
    }

    public Voo(int numeroVoo, Data data, int lotacao) {

        if (lotacao < 0) throw new IllegalArgumentException("Lotação do voo não pode ser negativa");
        if (lotacao > 100) throw new IllegalArgumentException("Lotação do voo não pode ser maior que 100");
        if (numeroVoo < 0) throw new IllegalArgumentException("Número do voo não pode ser negativo");
        if (!isValidDate(data.getDia(), data.getMes(), data.getAno()))
            throw new IllegalArgumentException("Data inválida");

        this.numeroVoo = numeroVoo;
        this.data = data;
        this.cadeiras = new boolean[lotacao];

        // Inicializa todas as cadeiras como livres (não precisa, pois o array de boolean já é inicializado com false)
        //for (int i = 0; i < lotacao; i++) this.cadeiras[i] = false;
    }

    public Voo(int numeroVoo, Data data) {

        if (numeroVoo < 0) throw new IllegalArgumentException("Número do voo não pode ser negativo");
        if (!isValidDate(data.getDia(), data.getMes(), data.getAno()))
            throw new IllegalArgumentException("Data inválida");

        this.numeroVoo = numeroVoo;
        this.data = data;
        this.cadeiras = new boolean[100];

        // Inicializa todas as cadeiras como livres (não precisa, pois o array de boolean já é inicializado com false)
        //for (int i = 0; i < 100; i++) this.cadeiras[i] = false;
    }

    public boolean[] getCadeirasLivre() {

        boolean[] cadeirasLivres = new boolean[cadeiras.length];

        for (int i = 0; i < cadeiras.length; i++) {
            if (!cadeiras[i]) {
                cadeirasLivres[i] = true;
            }
        }

        return cadeirasLivres;
    }

    public int proximoLivre() {
        for (int i = 0; i < cadeiras.length; i++) {
            if (!cadeiras[i]) {
                return i;
            }
        }
        return -1;
    }

    public boolean verifica(int cadeira) {
        return cadeiras[cadeira];
    }

    public void ocupa(int cadeira) {

        if (cadeira < 0 || cadeira >= cadeiras.length)
            throw new IllegalArgumentException("Cadeira inválida");

        if (cadeiras[cadeira]) return;

        cadeiras[cadeira] = true;
    }

    public int vagas() {
        int vagas = 0;
        for (boolean cadeira : cadeiras) {
            if (!cadeira) {
                vagas++;
            }
        }
        return vagas;
    }

    public int getVoo() {
        return numeroVoo;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public boolean[] getCadeiras() {
        return cadeiras;
    }

    public void setCadeiras(boolean[] cadeiras) {
        this.cadeiras = cadeiras;
    }

    public void setNumeroVoo(int numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public Voo(Voo modelo) {

        if (modelo == null) throw new IllegalArgumentException("Voo não pode ser nulo");

        this.numeroVoo = (int) verifyAndCopy(modelo.numeroVoo);
        this.data = (Data) verifyAndCopy(modelo.data);
        this.cadeiras = new boolean[modelo.cadeiras.length];

        for (int i = 0; i < modelo.cadeiras.length; i++)
            this.cadeiras[i] = (boolean) verifyAndCopy(modelo.cadeiras[i]);
    }

    public Object clone() {

        Voo clone = null;

        try {
            clone = new Voo(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + Integer.hashCode(numeroVoo);
        hash *= prime + Objects.hashCode(data);
        hash *= prime + Integer.hashCode(cadeiras.length);

        for (boolean cadeira : cadeiras)
            hash *= prime + (cadeira ? 1 : 0);

        if (hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Voo that = (Voo) o;

        for (int i = 0; i < this.cadeiras.length; i++)
            if (this.cadeiras[i] != that.cadeiras[i])
                return false;

        return Objects.equals(this.numeroVoo, that.numeroVoo) &&
                Objects.equals(this.data, that.data) &&
                Objects.equals(this.cadeiras.length, that.cadeiras.length) &&
                Arrays.equals(this.cadeiras, that.cadeiras);
    }

    @Override
    public String toString() {
        int totalSeats = cadeiras.length;
        int occupiedSeats = totalSeats - vagas();
        int nextFreeSeat = proximoLivre();
        return "{\n" +
                "\t\"numeroDoVoo\": " + numeroVoo + ",\n" +
                "\t\"data\": \"" + data + "\",\n" +
                "\t\"totalDeAssentos\": " + totalSeats + ",\n" +
                "\t\"assentosOcupados\": " + occupiedSeats + ",\n" +
                "\t\"proximoAssentoLivre\": " + nextFreeSeat + "\n" +
                "}";
    }

    @Override
    public int compareTo(Voo o) {
        return this.data.compareTo(o.data);
    }
}
