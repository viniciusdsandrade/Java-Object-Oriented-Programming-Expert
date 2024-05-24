package exercicios.lista_3.a_1;

public class FerramentasConcreto implements Ferramentas{
    @Override
    public Animal[] filtraEspecieAnimal(Animal[] animais, String especie) {
        return new Animal[0];
    }

    @Override
    public String[] classificaEspecies(Animal[] animais) {
        return new String[0];
    }
}
