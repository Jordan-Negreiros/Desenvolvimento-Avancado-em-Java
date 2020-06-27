package com.java.avancado;

import java.util.Arrays;
import java.util.function.BiPredicate;
import java.util.function.UnaryOperator;

public class ParadigmaFuncional {

    public static void main(String[] args) {

        imperativo();
        funcional();
        composicaoFuncoes();
        funcoesPuras();
        imutabilidade();

    }

    public static void imperativo() {
        /**
         * Paradigma Imperativo: É aquele que expressa o código
         * através de comandos ao computador, nele é possível ter
         * controle de estado dos objetos
         */

        int valor = 10;
        int resultado = valor * 3;

        System.out.println("O resultado é :: " + resultado);
    }

    public static void funcional() {
        /**
         * Paradigma Funcional: Damos uma regra, uma declaração
         * de como queremos que o programa se comporte.
         */

        // Dizemos o comportamento antes de executar
        UnaryOperator<Integer> calcularValorVezes3 = valor -> valor * 3;

        int valor = 10;

        System.out.println("O resultado é :: " + calcularValorVezes3.apply(10));
    }

    public static void composicaoFuncoes() {
        /**
         * Composição de funções: é criar uma nova função através da composição de outras.
         */
        int[] valores = { 1, 2, 3, 4};

        // exemplo de expressões lambda
        Arrays.stream(valores)
                .filter(numero -> numero % 2 == 0)
                .map(numero -> numero * 2)
                .forEach(numero -> System.out.println(numero));
    }

    public static void funcoesPuras() {
    /**
     * Funções Puras: É chamada de pura quando invocada mais de uma vez e
     * produz exatamente o mesmo resultado.
     */
        BiPredicate<Integer, Integer> verificarSeEMaior =
                (parametro, valorComparacao) -> parametro > valorComparacao;

        // sempre que passado o mesmo parâmetro, irá retornar o mesmo resultado
        System.out.println(verificarSeEMaior.test(13, 12));
        System.out.println(verificarSeEMaior.test(13, 12));
    }

    public static void imutabilidade() {
        /**
         * Imutabilidade: Significa que uma vez que uma variável que recebeu
         * um valor, vai possuir esse valor para sempre, ou quando criamos
         * um objeto ele não pode ser modificado
         */

        int valor = 20;

        UnaryOperator<Integer> retornarDobro = v -> v * 2;

        System.out.println(retornarDobro.apply(valor)); // retorna o dobro do valor
        System.out.println(valor);  // valor não será alterado
    }

    /*
     *  Exercício 01: É aquele que expressa o código atrvés de comandos
     *  ao computardor, nele é possível ter controle de estado dos objetos,
     *  de acordo com a afirmação. Qual alternartiva representa esse paradigma ?
     *
     *  a) (  ) Declarativo
     *  b) (  ) Imutabilidade
     *  c) (  ) Funcional
     *  d) (  ) Recursividade
     *  e) ( X ) Imperativo
     */
    /*
     *  Exercício 02: Damos uma regra, uma declaração de como queremos que o
     *  programa se comporte, de acordo com a afirmação. Qual alternativa
     *  representa esse paradigma:
     *
     *  a) (  ) Composição de funções
     *  b) (  ) Imutabilidade
     *  c) ( X ) Funcional
     *  d) (  ) Recursividade
     *  e) (  ) Imperativo
     */
    /*
     *  Exercício 03: Uma vez que uma variável que recebe um valor,
     *  esta vai possuir esse valor para sempre, ou quando criamos um
     *  objeto ele não pode ser modificado, de acordo com a afirmação.
     *  Qual alternativa representa esse paradigma:
     *
     *  a) (  ) Composição de funções
     *  b) ( X ) Imutabilidade
     *  c) (  ) Funcional
     *  d) (  ) Recursividade
     *  e) (  ) Imperativo
     */
}
