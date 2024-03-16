package exercicios.disciplina;

public abstract class Disciplina {

    private int codigo;

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public abstract float calcularMedia();
}