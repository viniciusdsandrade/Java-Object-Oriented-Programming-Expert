package exercicios.lista_3.q2;

 /*
    Questão 2
    Um órgão de levantamento meteorológico possui equipamentos para medir a pluviosidade
    (pluviômetros), onde cada unidade é representada em um software por um objeto da

    classe:
    public class Pluviometro {
        protected String tipo;
        public Pluviometro(String tipo){}
        public String getTipo(){}
        public int getPeso(){}
        public int getCapacidade(){}
    }

    1 - Construtor Recebe como parâmetro o tipo de equipamento.
    2 - getTipo Retorna o tipo do pluviômetro.
    3 - getPeso Retorna o peso do pluviômetro em quilos. Este peso é calculado
    4 - automaticamente pela classe a partir do tipo.
    5 - getCapacidade Retorna a capacidade do pluviômetro em mililitros. Esta capacidade é
    6 - calculada automaticamente pela classe a partir do tipo.

    Os pluviômetros são carregados por caminhões que, no software, são representados
genericamente por objetos da classe Caminhao (esta classe não deve ser implementada nesta questão). A
classe define os seguintes métodos:

    Construtor: Recebe como parâmetro a quantidade de equipamentos que o caminhão irá
    carregar.

    inserePluviometro:  Recebe como parâmetro um objeto da classe Pluviometro e o coloca
    dentro do caminhão se a capacidade do mesmo permitir.

    Cada objeto da classe representa um caminhão. Esta classe não possui nenhum atributo e seus
métodos não possuem implementação, pois serão implementados nas subclasses.

    Escreva duas classes herdeiras da classe Caminhao que representam dois tipos deste veículo com
capacidades diferentes:

    Caminhão Alfa: Consegue carregar no máximo 5 toneladas de pluviômetros, independente da quantidade e tipo.
    Caminhão Beta: Consegue carregar qualquer quantidade e peso de pluviômetros, no entanto, não consegue carregar mais do que um pluviômetro de cada tipo.

    Ambas as classes devem sobrescrever o metodo inserePluviometro.
     */

public class Pluviometro {

    protected String tipo;

    public Pluviometro(String tipo) {
        this.tipo = tipo;
    }
    public String getTipo() {
        return tipo;
    }
    public int getPeso() {
        return 0;
    }
    public int getCapacidade() {
        return 0;
    }

    @Override
    public String toString() {
        return "Pluviômetro " + tipo;
    }
}

