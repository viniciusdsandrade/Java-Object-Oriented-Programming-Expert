package exercicios.lista_1.q6;

import java.util.Arrays;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

/*
Crie uma classe VetorOrdenado que é uma variante da classe anterior, com as seguintes modificações
e acréscimos:

    insert - recebe uma string como parâmetro e a insere em uma posição tal que o vetor de nomes se
        mantenha sempre em ordem alfabética

    merge - recebe como parâmetro outro objeto da classe VetorOrdenado e retorna um terceiro objeto
        da classe VetorOrdenado (criado dentro do método) que contém o merge do vetor corrente com
        aquele recebido como parâmetro
 */
public class VectorOrdered<X> implements Cloneable, Comparable<VectorOrdered<X>> {

    private X[] vector;
    private int size;

    public VectorOrdered() {
    }

    public int getSize() {
        return size;
    }

    public X get(int posicao) {
        if (posicao < 0 || posicao >= size) return null;

        return vector[posicao];
    }

    public X getFirst() {
        return get(0);
    }

    public X getLast() {
        return get(size - 1);
    }

    @SuppressWarnings("unchecked")
    public VectorOrdered(int tamanho) {

        if (tamanho < 0) throw new IllegalArgumentException("O tamanho do vetor não pode ser negativo.");

        vector = (X[]) new Object[tamanho];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public void resizeUp() {
        X[] novoVetor = (X[]) new Object[(int) verifyAndCopy(vector.length + 1)];

        for (int i = 0; i < vector.length; i++)
            novoVetor[i] = (X) verifyAndCopy(vector[i]);

        vector = novoVetor;
    }

    @SuppressWarnings("unchecked")
    public void resizeDown() {
        X[] novoVetor = (X[]) new Object[(int) verifyAndCopy(vector.length - 1)];

        for (int i = 0; i < novoVetor.length; i++)
            novoVetor[i] = (X) verifyAndCopy(vector[i]);

        vector = novoVetor;
    }

    @SuppressWarnings("unchecked")
    public VectorOrdered<X> merge(VectorOrdered<X> vector1) {
        VectorOrdered<X> vector2 = (VectorOrdered<X>) this.clone();

        for (int i = 0; i < vector1.size; i++)
            vector2.insert((X) verifyAndCopy(vector1.vector[i]));

        return vector2;
    }

    @SuppressWarnings("unchecked")
    public void insert(X elemento) {
        if (size == vector.length)
            resizeUp();

        int i = ordenando((Comparable<X>) elemento);

        vector[i + 1] = elemento;
        size++;
    }

    @SuppressWarnings("unchecked")
    public void remove(int posicao) {
        if (posicao < 0 || posicao >= size) return;

        for (int i = posicao; i < size - 1; i++)
            vector[i] = (X) verifyAndCopy(vector[i + 1]);

        vector[size - 1] = null;
        size--;

        resizeDown();
    }

    @SuppressWarnings("unchecked")
    private int ordenando(Comparable<X> elemento) {
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (elemento.compareTo(vector[i]) < 0)
                vector[i + 1] = (X) verifyAndCopy(vector[i]);
            else
                break;
        }
        return i;
    }

    @Override
    public Object clone() {
        VectorOrdered<X> clone = null;

        try {
            clone = new VectorOrdered<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @SuppressWarnings("unchecked")
    public VectorOrdered(VectorOrdered<X> vector1) {
        if (vector1 == null)
            throw new IllegalArgumentException("O vetor não pode ser nulo.");

        this.vector = (X[]) new Object[(int) verifyAndCopy(vector1.vector.length)];
        this.size = (int) verifyAndCopy(vector1.size);

        for (int i = 0; i < vector1.size; i++)
            this.vector[i] = (X) verifyAndCopy(vector1.vector[i]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        VectorOrdered<?> vector1 = (VectorOrdered<?>) obj;

        if (size != vector1.size) return false;

        for (int i = 0; i < size; i++)
            if (!vector[i].equals(vector1.vector[i]))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 1;

        hash *= prime + size;

        for (int i = 0; i < size; i++)
            hash *= prime + vector[i].hashCode();

        if (hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(VectorOrdered<X> other) {
        if (other == null)
            throw new IllegalArgumentException("O vetor não pode ser nulo.");

        int minLength = Math.min(this.size, other.size);

        // Itera sobre os elementos de ambos os vetores e compara cada par de elementos
        for (int i = 0; i < minLength; i++) {
            int comparison = ((Comparable<X>) this.vector[i]).compareTo(other.vector[i]);
            if (comparison != 0) {
                return comparison; // Se os elementos não forem iguais, retorna o resultado da comparação
            }
        }

        return Integer.compare(this.size, other.size); // Retorna -1 se este vetor for menor que o outro
    }
}
