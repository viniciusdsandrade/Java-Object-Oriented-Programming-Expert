package exercicios.lista_3.q1;

public interface Repositorio {
    void guarda(Pessoa pessoa);

    Pessoa recupera(String cpf);

    Pessoa primeiro();

    Pessoa proximo();
}