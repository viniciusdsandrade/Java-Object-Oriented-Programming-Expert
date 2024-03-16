package exercicios.lista_1.q2;

import static exercicios.lista_1.q2.Data.isValidDate;

public class TestData {
    public static void main(String[] args) {

        //Data data = new Data((byte) 15, (byte) 10, (short) 1582);
        Data data = new Data((byte) 15, (byte) 3, (short) 2024);

        Data meuNascimento = new Data((byte) 6, (byte) 12, (short) 2001);
        System.out.println("Meu nascimento: " + meuNascimento);

        String diaDaSemana = meuNascimento.diaDaSemana();
        int diff = data.diferencaEmDias(meuNascimento);

        System.out.println("Diferença entre " + data + " e " + meuNascimento + " é de " + diff + " dias");
        System.out.println("Dia da semana de " + meuNascimento + " é " + diaDaSemana);

        // Testes com datas válidas
        System.out.println("01/01/2022 is valid ? " + isValidDate((byte) 1, (byte) 1, (short) 2022)); // Deve retornar true
        System.out.println("31/01/2022 is valid ? " + isValidDate((byte) 31, (byte) 1, (short) 2022)); // Deve retornar true
        System.out.println("28/02/2021 is valid ? " + isValidDate((byte) 28, (byte) 2, (short) 2021)); // Deve retornar true
        System.out.println();

        // Testes com datas inválidas
        System.out.println("32/01/2022 is valid ? " + isValidDate((byte) 32, (byte) 1, (short) 2022)); // Deve retornar false (Janeiro tem 31 dias)
        System.out.println("29/02/2021 is valid ? " + isValidDate((byte) 29, (byte) 2, (short) 2021)); // Deve retornar false (2021 não é bissexto)
        System.out.println("00/12/2022 is valid ? " + isValidDate((byte) 0, (byte) 12, (short) 2022)); // Deve retornar false (Dia não pode ser 0)
        System.out.println("01/01/0000 is valid ? " + isValidDate((byte) 1, (byte) 1, (short) 0)); // Deve retornar false (Ano não pode ser 0)
        System.out.println("10/10/1582 is valid ? " + isValidDate((byte) 10, (byte) 10, (short) 1582)); // Deve retornar false (Data omitida no calendário gregoriano)
        System.out.println();

        Data data1 = new Data((byte) 6, (byte) 12, (short) 2001);
        Data data2 = new Data(data1);
        Data data3 = (Data) data1.clone();

        System.out.println("data1         = " + data1);
        System.out.println("data2 (copy)  = " + data2);
        System.out.println("data3 (clone) = " + data3);

        int hash1 = data1.hashCode();
        int hash2 = data2.hashCode();
        int hash3 = data3.hashCode();

        System.out.println("hash1 =     " + hash1);
        System.out.println("hash2 =     " + hash2);
        System.out.println("hash3 =     " + hash3);

        data1.avanceDias(6);
        System.out.println("\navançando 6 dias na data1");
        System.out.println("data1 =         " + data1);
        System.out.println("data2 (copy)  = " + data2);
        System.out.println("data3 (clone) = " + data3);

        data1.retrocedaDias(12);
        System.out.println("\nretrocedendo 12 dias na data1");
        System.out.println("data1 =         " + data1);
        System.out.println("data2 (copy)  = " + data2);
        System.out.println("data3 (clone) = " + data3);

        data1.avanceDias(6);
        System.out.println("\navançando 6 dias na data1");
        System.out.println("data1 =         " + data1);
        System.out.println("data2 (copy)  = " + data2);
        System.out.println("data3 (clone) = " + data3);

        Data data4 = data1.getDiaSeguinte();
        System.out.println("\npróximo dia de data1 =    " + data4);

        Data data5 = data1.getDiaAnterior();
        System.out.println("\ndia anterior de data1 =   " + data5);
    }
}
