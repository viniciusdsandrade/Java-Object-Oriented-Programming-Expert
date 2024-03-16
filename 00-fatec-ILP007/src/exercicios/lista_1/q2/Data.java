package exercicios.lista_1.q2;
/*

Escreva uma classe Data cuja instância (objeto) represente uma data.

Esta classe deverá dispor dos seguintes métodos:
1 - construtor define a data que determinado objeto (por parâmetro), este método verifica se a
    data está correta, caso não esteja a data é configurada como 01/01/0001
    compara recebe como parâmetro outro objeto da Classe data, compare com a data corrente e
    retorne:
        0  se as datas forem iguais;
        1  se a data corrente for maior que a do parâmetro;
        -1 se a data do parâmetro for maior que a corrente.
2 - getDia retorna o dia da data
3 - getMes retorna o mês da data
4 - getMesExtenso retorna o mês da data corrente por extenso
5 - getAno retorna o ano da data
6 - isBissexto retorna verdadeiro se o ano da data corrente for bissexto e falso caso contrário
7 - clone o objeto clona a si próprio, para isto, ele cria um novo objeto da classe Data com os
    mesmos valores de atributos e retorna sua referência pelo método
 */

import java.util.Objects;

import static exercicios.deepCopy.ShallowOrDeepCopy.*;

public class Data implements Comparable<Data>, Cloneable {

    private byte dia, mes;
    private short ano;

    public Data(byte dia, byte mes, short ano) {

        if (!isValidDate(dia, mes, ano)) throw new IllegalArgumentException("A data não é válida.");

        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public static boolean isValidDate(byte dia, byte mes, short ano) {
        if (dia < 1 || dia > 31) return false;
        if (mes < 1 || mes > 12) return false;
        if (ano == 0) return false;
        if (ano == 1582 && mes == 10 && dia >= 5 && dia <= 14) return false;
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) return false;
        if (mes == 2 && dia > 29) return false;
        return mes != 2 || dia != 29 || isBissexto(ano);
    }

    public String diaDaSemana() {
        int dia = this.dia;
        int mes = this.mes;
        int ano = this.ano;

        if (mes == 1 || mes == 2) {
            mes += 12;
            ano--;
        }

        int k = ano % 100;
        int j = ano / 100;

        int diaDaSemana = (dia + (13 * (mes + 1)) / 5 + k + (k / 4) + (j / 4) - (2 * j)) % 7;

        return switch (diaDaSemana) {
            case 0 -> "Sábado";
            case 1 -> "Domingo";
            case 2 -> "Segunda-feira";
            case 3 -> "Terça-feira";
            case 4 -> "Quarta-feira";
            case 5 -> "Quinta-feira";
            case 6 -> "Sexta-feira";
            default -> "Erro";
        };
    }

    public int diferencaEmDias(Data data) {
        int days = 0;
        Data data1 = new Data(this);
        Data data2 = new Data(data);
        if (data1.compareTo(data2) == 0) return 0;
        if (data1.compareTo(data2) > 0) {
            while (data1.compareTo(data2) > 0) {
                data2.avanceUmDia();
                days++;
            }
        } else {
            while (data1.compareTo(data2) < 0) {
                data1.avanceUmDia();
                days++;
            }
        }
        return days;
    }

    private static boolean isBissexto(short ano) {
        if (ano < 1583) return ano % 4 == 0;
        if (ano % 400 == 0) return true;
        return ano % 4 == 0 && ano % 100 != 0;
    }

    public byte getDia() {
        return dia;
    }

    public byte getMes() {
        return mes;
    }

    public short getAno() {
        return ano;
    }

    public void setDia(byte dia) {
        if (!isValidDate(dia, this.mes, this.ano))
            throw new IllegalArgumentException("O dia não é válido.");

        this.dia = dia;
    }

    public void setMes(byte mes) {
        if (!isValidDate(this.dia, mes, this.ano))
            throw new IllegalArgumentException("O mês não é válido.");

        this.mes = mes;
    }

    public void setAno(short ano) {
        if (!isValidDate(this.dia, this.mes, ano))
            throw new IllegalArgumentException("O ano não é válido.");

        this.ano = ano;
    }

    public String getMesPorExtenso() {
        return switch (this.mes) {
            case 1 -> "Janeiro";
            case 2 -> "Fevereiro";
            case 3 -> "Março";
            case 4 -> "Abril";
            case 5 -> "Maio";
            case 6 -> "Junho";
            case 7 -> "Julho";
            case 8 -> "Agosto";
            case 9 -> "Setembro";
            case 10 -> "Outubro";
            case 11 -> "Novembro";
            case 12 -> "Dezembro";
            default -> "Erro";
        };
    }

    public void avanceUmDia() {

        if (this.dia == 4 && this.mes == 10 && this.ano == 1582) {
            this.dia = (byte) 15;
        } else if (isValidDate((byte) (this.dia + 1), this.mes, this.ano)) {
            this.dia++;
        } else if (isValidDate((byte) 1, (byte) (this.mes + 1), this.ano)) {
            this.dia = (byte) 1;
            this.mes++;
        } else {
            this.dia = (byte) 1;
            this.mes = (byte) 1;
            this.ano++;
            if (this.ano == 0) {
                this.ano++;
            }
        }
    }

    public void retrocedaUmDia() {
        if (this.dia == 15 && this.mes == 10 && this.ano == 1582) {
            this.dia = 4;
        } else if (this.dia == 1 && this.mes == 10 && this.ano == 1582) {
            this.dia = 30;
            this.mes = 9;
        } else if (isValidDate((byte) (this.dia - 1), this.mes, this.ano)) {
            this.dia--;
        } else if (this.mes == 2 && isValidDate((byte) 28, (byte) (this.mes - 1), this.ano)) {
            this.dia = 28;
            this.mes--;
        } else if (isValidDate((byte) 31, (byte) (this.mes - 1), this.ano)) {
            this.mes--;
            if (this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12) {
                this.dia = 31;
            } else {
                this.dia = 30;
            }
        } else if (isValidDate((byte) 31, (byte) 12, (short) (this.ano - 1))) {
            this.dia = 31;
            this.mes = 12;
            this.ano--;
        }
    }

    public void avanceDias(int dias) {
        if (dias < 0) throw new IllegalArgumentException("O número de dias não pode ser negativo.");

        while (dias > 0) {
            avanceUmDia();
            dias--;
        }
    }

    public void retrocedaDias(int dias) {
        if (dias < 0) throw new IllegalArgumentException("O número de dias não pode ser negativo.");

        while (dias > 0) {
            retrocedaUmDia();
            dias--;
        }
    }

    public Data getDiaSeguinte() {
        Data ret = null;

        try {
            ret = new Data((byte) (this.dia + 1), this.mes, this.ano);
        } catch (Exception erro1) {
            try {
                ret = new Data((byte) 1, (byte) (this.mes + 1), this.ano);
            } catch (Exception erro2) {
                try {
                    ret = new Data((byte) 1, (byte) 1, (short) (this.ano + 1));
                } catch (Exception erro3) {
                    try {
                        ret = new Data((byte) 1, (byte) 1, (short) (this.ano + 2));
                    } catch (Exception erro4) {
                        try {
                            ret = new Data((byte) 15, (byte) 10, (short) 1582);
                        } catch (Exception ignored) {
                        }
                    }
                }
            }
        }
        return ret;
    }

    public Data getDiaAnterior() {
        Data ret = null;

        try {
            ret = new Data((byte) (this.dia - 1), this.mes, this.ano); // Retorno de um dia permitido
        } catch (Exception erro1) {
            try {
                ret = new Data((byte) (this.dia - 10), this.mes, this.ano); // Data do Papa
            } catch (Exception erro2) {
                try {
                    ret = new Data((byte) 31, (byte) (this.mes - 1), this.ano); // Retornar um mes caso a data seja
                    // 1/xx/yyyy
                } catch (Exception erro3) {
                    try {
                        ret = new Data((byte) 30, (byte) (this.mes - 1), this.ano); // Se não for um mês com 31 dias,
                        // tentar com 30
                    } catch (Exception erro4) {
                        try {
                            ret = new Data((byte) 29, (byte) (this.mes - 1), this.ano); // Se não for um mês com 30
                            // dias, tentar com 29
                        } catch (Exception erro5) {
                            try {
                                ret = new Data((byte) 28, (byte) (this.mes - 1), this.ano); // Se não for um mês com 29
                                // dias, tentar com 28
                            } catch (Exception erro6) {
                                try {
                                    ret = new Data((byte) 31, (byte) 12, (short) (this.ano - 1)); // se for dia 31/12
                                    // retornar 1 ano
                                } catch (Exception erro7) {
                                    try {
                                        ret = new Data((byte) 31, (byte) 12, (short) (this.ano - 2)); // Se não puder
                                        // retornar 1 ano,
                                        // retornar 2
                                    } catch (Exception erro8) {
                                        try {
                                            ret = new Data((byte) 4, (byte) 10, (short) 1582);// data do papa
                                        } catch (Exception ignored) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return ret;
    }

    public Data(Data copia) {
        if (copia == null) throw new IllegalArgumentException("A data não pode ser nula.");

        this.dia = (byte) verifyAndCopy(copia.getDia());
        this.mes = (byte) verifyAndCopy(copia.getMes());
        this.ano = (short) verifyAndCopy(copia.getAno());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;

        Data that = (Data) o;

        return Objects.equals(this.dia, that.dia) &&
                Objects.equals(this.mes, that.mes) &&
                Objects.equals(this.ano, that.ano);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hash = 1;

        hash *= prime + this.dia;
        hash *= prime + this.mes;
        hash *= prime + this.ano;

        if (hash < 0) hash *= -1;

        return hash;
    }

    @Override
    public String toString() {
        if (this.ano > 0)
            return String.format("%02d/%02d/%04d", this.dia, this.mes, this.ano);
        else
            return String.format("%02d/%02d/%04d a.C.", this.dia, this.mes, this.ano * -1);
    }

    @Override
    public Object clone() {
        Data clone = null;

        try {
            clone = new Data(this);
        } catch (Exception ignored) {
        }

        return clone;
    }

    @Override
    public int compareTo(Data o) {
        int anoCompare = Integer.compare(this.ano, o.ano);
        if (anoCompare != 0) return anoCompare;

        int mesCompare = Integer.compare(this.mes, o.mes);
        if (mesCompare != 0) return mesCompare;

        return Integer.compare(this.dia, o.dia);
    }
}