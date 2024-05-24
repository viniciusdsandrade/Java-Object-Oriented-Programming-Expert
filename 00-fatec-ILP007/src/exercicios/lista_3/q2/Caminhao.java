package exercicios.lista_3.q2;

import java.util.ArrayList;
import java.util.List;

public class Caminhao {
    protected int quantidadeEquipamentos;
    protected List<Pluviometro> pluviometros;

    public Caminhao(int quantidadeEquipamentos) {
        this.quantidadeEquipamentos = quantidadeEquipamentos;
        this.pluviometros = new ArrayList<>();
    }

    public boolean inserePluviometro(Pluviometro pluviometro) {
        if (pluviometros.size() < quantidadeEquipamentos) {
            pluviometros.add(pluviometro);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Caminhão com ").append(pluviometros.size()).append(" pluviômetros:\n");
        for (Pluviometro pluviometro : pluviometros) {
            sb.append(pluviometro).append("\n");
        }
        return sb.toString();
    }
}