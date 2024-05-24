package exercicios.animal;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 Complete o código Java acima adicionando os elementos na lista animais
 (um item para cada tipo de animal) e escreva as classes para os animais: Arara, Urso e cobra
*/

public class Animal {
    private final List<Animal> animais = new LinkedList<>();

    public Animal() {
    }

    public void andar() {
        System.out.println("Eu ando como um animal genérico");
    }

    public void comer() {
        System.out.println("Eu como como um animal genérico");
    }

    public void dormir() {
        System.out.println("Eu durmo como um animal genérico");
    }

    public void deleteAt(int index) {
        if (index >= 0 && index < animais.size()) animais.remove(index);
        else System.out.println("Índice inválido");
    }

    public void addAnimal(Animal animal) {
        animais.add(animal);
    }

    public List<Animal> getAnimais() {
        return Collections.unmodifiableList(animais);
    }
}

class Arara extends Animal {

    @Override
    public void andar() {
        System.out.println("Eu ando como uma arara");
    }

    @Override
    public void comer() {
        System.out.println("Eu me alimento como uma arara");
    }
}

class Urso extends Animal {

    @Override
    public void andar() {
        System.out.println("Eu ando como um urso");
    }

    @Override
    public void dormir() {
        System.out.println("Eu durmo como um urso");
    }

    @Override
    public void comer() {
        System.out.println("Eu me alimento como um urso");
    }
}

class Cobra extends Animal {

    @Override
    public void andar() {
        System.out.println("Eu ando como uma cobra");
    }

    @Override
    public void dormir() {
        System.out.println("Eu durmo como uma cobra");
    }

    @Override
    public void comer() {
        System.out.println("Eu me alimento como uma cobra");
    }
}

