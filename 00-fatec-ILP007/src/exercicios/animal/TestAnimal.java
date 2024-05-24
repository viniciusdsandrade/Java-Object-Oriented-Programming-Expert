package exercicios.animal;

import java.util.List;

public class TestAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal();

        Arara arara = new Arara();
        Urso urso = new Urso();
        Cobra cobra = new Cobra();

        animal.addAnimal(arara);
        animal.addAnimal(urso);
        animal.addAnimal(cobra);

        List<Animal> animais = animal.getAnimais();

        animais.forEach(Animal::andar);
        animais.forEach(Animal::comer);
        animais.forEach(Animal::dormir);
    }
}
