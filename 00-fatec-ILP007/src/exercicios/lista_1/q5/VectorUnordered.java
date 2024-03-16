package exercicios.lista_1.q5;

import java.util.Arrays;

import static exercicios.deepCopy.ShallowOrDeepCopy.verifyAndCopy;

/*
A linguagem Java dispõe de um suporte nativo a vetores, que exige a definição de seu tamanho no momento da instanciação.
Após instanciado, o tamanho do vetor não pode ser modificado.

Escreva uma classe chamada Vetor cujos objetos simulem vetores de tamanho variável.
A classe define os seguintes métodos:

    construtor - recebe como parâmetro o tamanho inicial do vetor

    insert - recebe como parâmetro uma string e a coloca na próxima posição disponível do vetor; note
        que o vetor cresce automaticamente, portanto, se a inserção ultrapassar o tamanho inicial
        estabelecido na criação, por exemplo, o vetor deve aumentar seu tamanho
        automaticamente

    get - recebe como parâmetro uma posição do vetor e retorna a string que estiver naquela
        posição; se a posição não estiver ocupada ou ultrapassar o tamanho do vetor, este método
        retorna nulo

    size - retorna a composição inseridos no vetor (independente do tamanho do mesmo)

    O java dispõe de classes – tal como a Vector – que realizam a tarefa solicitada nesta questão.
    Tais classes não devem ser usadas. É possível resolver esta questão apenas usando o sistema de vetores
    preexistente do Java, sem nenhum comando especial extra.
 */
public class VectorUnordered<X> implements Cloneable {

    private X[] vector;
    private int size;

    public VectorUnordered() {
    }

    @SuppressWarnings("unchecked")
    public VectorUnordered(int tamanho) {

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

    public void insert(X elemento) {
        if (size == vector.length)
            resizeUp();

        // Adiciona o elemento na próxima posição disponível
        vector[size++] = elemento;
    }

    public void insertLast(X elemento) {
        insert(elemento);
    }

    @SuppressWarnings("unchecked")
    public void insertFirst(X elemento) {
        if (size == vector.length)
            resizeUp();

        for (int i = size; i > 0; i--)
            vector[i] = (X) verifyAndCopy(vector[i - 1]);

        vector[0] = elemento;
        size++;
    }

    @SuppressWarnings("unchecked")
    public void insertAt(X elemento, int posicao) {
        if (posicao < 0 || posicao > size) return;

        if (posicao == 0) {
            insertFirst(elemento);
            return;
        }

        if (posicao == size) {
            insertLast(elemento);
            return;
        }

        if (size == vector.length)
            resizeUp();

        for (int i = size; i > posicao; i--)
            vector[i] = (X) verifyAndCopy(vector[i - 1]);

        vector[posicao] = elemento;
        size++;
    }

    public void remove(int posicao) {
        if (posicao < 0 || posicao >= size) return;

        // Move os elementos à frente da posição de remoção para trás
        for (int i = posicao; i < size - 1; i++)
            vector[i] = vector[i + 1];

        // Define o último elemento como null para liberar a referência
        vector[size - 1] = null;

        size--; // Atualiza o tamanho do vetor

        resizeDown();
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        remove(size - 1);
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

    public int getSize() {
        return size;
    }

    @Override
    public Object clone() {
        VectorUnordered<X> clone = null;

        try {
            clone = new VectorUnordered<>(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @SuppressWarnings("unchecked")
    public VectorUnordered(VectorUnordered<X> vectorUnordered) {
        if (vectorUnordered == null) throw new IllegalArgumentException("O vetor não pode ser nulo.");

        this.vector = (X[]) new Object[(int) verifyAndCopy(vectorUnordered.vector.length)];
        this.size = (int) verifyAndCopy(vectorUnordered.size);

        for (int i = 0; i < vectorUnordered.size; i++)
            this.vector[i] = (X) verifyAndCopy(vectorUnordered.vector[i]);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        VectorUnordered<?> vectorUnordered1 = (VectorUnordered<?>) obj;

        if (size != vectorUnordered1.size) return false;

        for (int i = 0; i < size; i++)
            if (!vector[i].equals(vectorUnordered1.vector[i])) return false;

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
}
