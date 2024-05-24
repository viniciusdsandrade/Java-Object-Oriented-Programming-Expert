package exercicios.lista_3.q2;

public class CaminhaoAlfa extends Caminhao {
    private int pesoTotal = 0;

    public CaminhaoAlfa(int quantidadeEquipamentos) {
        super(quantidadeEquipamentos);
    }

    @Override
    public boolean inserePluviometro(Pluviometro pluviometro) {
        if (pesoTotal + pluviometro.getPeso() <= 5000) {
            pesoTotal += pluviometro.getPeso();
            return super.inserePluviometro(pluviometro);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Caminhão Alfa com " + pluviometros.size() + " pluviômetros";
    }

}