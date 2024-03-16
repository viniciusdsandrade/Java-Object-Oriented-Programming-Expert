package exercicios.lista_2.q2;
/*
Dada uma classe Equipamento na qual cada objeto representa um conjunto de N equipamentos de
uma empresa com seus respectivos valores, cujo diagrama UML está representado a seguir:

     1 - construtor recebe como parâmetro o número de equipamentos e cria um vetor de
         valores do respectivo tamanho
     2 - getNumeroEquipamentos retorna o número de equipamentos
     3 - getValor recebe como parâmetro o número do equipamento (começando de zero) e retorna seu valor
     4 - setValor recebe como parâmetro o número do equipamento e seu valor e o registra

    Cada equipamento possui um código numérico sequencial, começando de zero, que corresponde a sua
        posição no vetor.
    Escreva uma classe, herdeira da classe Equipamento, denominada EquipamentoCorrigido em que cada
        objeto representa os mesmos equipamentos com valor corrigido, conforme diagrama UML parcial
    representado anteriormente.
        Todos os equipamentos só são corrigidos anualmente no mês em que foi comprado, por este motivo a classe
        deve acrescentar para cada equipamento um registro do seu mês de compra. Além disto, deve possuir os
métodos:
     1 - construtor recebe como parâmetros o número de equipamentos e o mês corrente
     2 - getMesCompra recebe como parâmetro o número do equipamento (começando de zero) e retorna seu mês de compra
     3 - setMesCompra recebe como parâmetro o número do equipamento e seu mês de compra e o registra
     4 - corrige este método recebe como parâmetro apenas o percentual de correção e corrige todos
        os equipamentos cujo mês de compra seja igual ao mês corrente; O objeto deve
        manter registrado em um atributo o mês corrente, que deve começar sempre em
        janeiro (quando o objeto é construído). Cada vez que este método é chamado, após a
        correção, o mês é incrementado de um e, se estiver em dezembro, retorna para
        janeiro
     5 - substitui recebe como parâmetro outro objeto da classe EquipamentoCorrigido e substitui o
        valor e o mês de compra de todos os equipamentos do objeto corrente pelos do objeto
        recebido como parâmetro; a operação só será realizada se ambos os objetos possuírem
        o mesmo número de equipamentos

Note que o atributo “valor” da classe Equipamento é privado, portanto, só poderá ser acessado
    indiretamente, até mesmo pela classe herdeira.
 */
public class Equipamento {
}
