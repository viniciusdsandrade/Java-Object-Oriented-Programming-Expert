package exercicios.lista_3.q3;

import exercicios.lista_3.q2.Caminhao;
import exercicios.lista_3.q2.CaminhaoAlfa;
import exercicios.lista_3.q2.CaminhaoBeta;
import exercicios.lista_3.q2.Pluviometro;

import java.util.ArrayList;
import java.util.List;

public class ControlePluviometros extends Controle {

    public static Caminhao selecionaCaminhao() {
        Caminhao caminhaoEscolhido = null;
        int capacidadeMaxima = 0;

        while (true) {
            String tipoCaminhao = leString("Tipo do caminhão ('Alfa', 'Beta' ou 'Fim' para encerrar): ");
            if (tipoCaminhao.equalsIgnoreCase("Fim")) {
                break;
            }

            Caminhao caminhao = criarCaminhao(tipoCaminhao);
            if (caminhao == null) {
                continue; // Tipo de caminhão inválido
            }

            List<Pluviometro> pluviometros = lerPluviometros();
            int capacidadeTotal = calcularCapacidadeTotal(caminhao, pluviometros);

            if (capacidadeTotal > capacidadeMaxima) {
                capacidadeMaxima = capacidadeTotal;
                caminhaoEscolhido = caminhao;
            }
        }

        return caminhaoEscolhido;
    }

    private static Caminhao criarCaminhao(String tipoCaminhao) {
        int numPluviometros = leInteiro("Número de pluviômetros a transportar: ");
        if (tipoCaminhao.equalsIgnoreCase("Alfa")) {
            return new CaminhaoAlfa(numPluviometros);
        } else if (tipoCaminhao.equalsIgnoreCase("Beta")) {
            return new CaminhaoBeta(numPluviometros);
        } else {
            System.out.println("Tipo de caminhão inválido.");
            return null;
        }
    }

    private static List<Pluviometro> lerPluviometros() {
        int numPluviometros = leInteiro("Número de pluviômetros a transportar: ");
        List<Pluviometro> pluviometros = new ArrayList<>();
        for (int i = 0; i < numPluviometros; i++) {
            String tipoPluviometro = leString("Tipo do pluviômetro " + (i + 1) + ": ");
            pluviometros.add(new Pluviometro(tipoPluviometro));
        }
        return pluviometros;
    }

    private static int calcularCapacidadeTotal(Caminhao caminhao, List<Pluviometro> pluviometros) {
        int capacidadeTotal = 0;
        for (Pluviometro pluviometro : pluviometros) {
            if (caminhao.inserePluviometro(pluviometro)) {
                capacidadeTotal += pluviometro.getCapacidade();
            }
        }
        return capacidadeTotal;
    }
}