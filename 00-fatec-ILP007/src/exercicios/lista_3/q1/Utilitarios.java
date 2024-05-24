package exercicios.lista_3.q1;

    /*
        Escreva uma classe denominada utilitários que possua os seguintes métodos:
    duplica Recebe como parâmetro dois objetos que implementam a interface Repositorio A e B
    e copia todas as pessoas do repositório A para o repositório B.
    diferenca Recebe como parâmetro três objetos que implementam a interface Repositorio A, B e
    C e coloque no repositório C todas as pessoas de A que não estiverem em B.
  */

public class Utilitarios {

    public static void duplica(Repositorio A, Repositorio B) {
        Pessoa pessoa = A.primeiro();

        while (pessoa != null) {
            B.guarda(pessoa);
            pessoa = A.proximo();
        }
    }

    public static void diferenca(Repositorio A, Repositorio B, Repositorio C) {
        Pessoa pessoaA = A.primeiro();

        while (pessoaA != null) {
            String cpf = pessoaA.getCPF();
            Pessoa pessoaB = B.recupera(cpf);

            if (pessoaB == null) C.guarda(pessoaA);

            pessoaA = A.proximo();
        }
    }
}

