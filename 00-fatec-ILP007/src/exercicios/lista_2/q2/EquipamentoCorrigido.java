package exercicios.lista_2.q2;

public class EquipamentoCorrigido extends Equipamento {
    private final int[] mesCompra;
    private int mesCorrente;

    public EquipamentoCorrigido(int numeroEquipamentos, int mesCorrente) {
        super(numeroEquipamentos);
        this.mesCompra = new int[numeroEquipamentos];
        this.mesCorrente = mesCorrente;
    }

    public int getMesCompra(int numeroEquipamento) {
        return this.mesCompra[numeroEquipamento];
    }

    public void setMesCompra(int numeroEquipamento, int mesCompra) {

        if (mesCompra < 1 || mesCompra > 12)
            throw new IllegalArgumentException("Mês de compra inválido");

        this.mesCompra[numeroEquipamento] = mesCompra;
    }

    public void corrige(double percentualCorrecao) {

        if (percentualCorrecao < 0)
            throw new IllegalArgumentException("Percentual de correção inválido");

        for (int i = 0; i < getNumeroEquipamentos(); i++) {
            if (this.mesCompra[i] == this.mesCorrente) {
                double valorCorrigido = getValor(i) + getValor(i) * percentualCorrecao / 100;
                setValor(i, valorCorrigido);
            }
        }
        this.mesCorrente = this.mesCorrente == 12 ? 1 : this.mesCorrente + 1;
    }

    public void substitui(EquipamentoCorrigido outro) {

        if (getNumeroEquipamentos() == outro.getNumeroEquipamentos()) {
            for (int i = 0; i < getNumeroEquipamentos(); i++) {
                setValor(i, outro.getValor(i));
                this.mesCompra[i] = outro.getMesCompra(i);
            }
        }
    }
}