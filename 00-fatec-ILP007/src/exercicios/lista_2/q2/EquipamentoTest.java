package exercicios.lista_2.q2;

public class EquipamentoTest {
    public static void main(String[] args) {
        EquipamentoCorrigido equipamentos = new EquipamentoCorrigido(5, 1);

        // Definindo valores e meses de compra para os equipamentos
        for (int i = 0; i < equipamentos.getNumeroEquipamentos(); i++) {
            equipamentos.setValor(i, 100.0 * (i + 1));
            equipamentos.setMesCompra(i, (i % 12) + 1);
        }

        // Imprimindo valores iniciais dos equipamentos
        System.out.println("Valores iniciais dos equipamentos:");
        for (int i = 0; i < equipamentos.getNumeroEquipamentos(); i++) {
            System.out.println("Equipamento " + i + ": " + equipamentos.getValor(i));
        }

        // Corrigindo valores dos equipamentos
        for (int i = 0; i < 12; i++) {
            equipamentos.corrige(10.0);  // 10% de correção
        }

        // Imprimindo valores corrigidos dos equipamentos
        System.out.println("\nValores corrigidos dos equipamentos:");
        for (int i = 0; i < equipamentos.getNumeroEquipamentos(); i++) {
            System.out.println("Equipamento " + i + ": " + equipamentos.getValor(i));
        }
    }
}
