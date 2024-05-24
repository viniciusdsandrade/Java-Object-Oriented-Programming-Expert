package exercicios.lista_3.q2;

import java.util.HashSet;
import java.util.Set;

public class CaminhaoBeta extends Caminhao {
    private Set<String> tiposCarregados;

    public CaminhaoBeta(int quantidadeEquipamentos) {
        super(quantidadeEquipamentos);
        this.tiposCarregados = new HashSet<>();
    }

    @Override
    public boolean inserePluviometro(Pluviometro pluviometro) {
        if (!tiposCarregados.contains(pluviometro.getTipo())) {
            tiposCarregados.add(pluviometro.getTipo());
            return super.inserePluviometro(pluviometro);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Caminhão Beta com " + pluviometros.size() + " pluviômetros";
    }
}