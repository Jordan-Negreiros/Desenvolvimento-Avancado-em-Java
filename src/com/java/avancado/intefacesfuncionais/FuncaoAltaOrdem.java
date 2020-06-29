package com.java.avancado.intefacesfuncionais;

/**
 * É uma função que retorna uma função ou que recebe uma
 * função como parâmetro.
 */
public class FuncaoAltaOrdem {

    public static void main(String[] args) {

        Calculo SOMA = (a, b) -> a + b;
        Calculo SUBTRACAO = (a, b) -> a - b;
        Calculo DIVISAO = (a, b) -> a / b;
        Calculo MULT = (a, b) -> a * b;

        System.out.println(executarOperacao(SOMA, 1, 3));
        System.out.println(executarOperacao(SUBTRACAO, 3, 1));
        System.out.println(executarOperacao(DIVISAO, 9, 3));
        System.out.println(executarOperacao(MULT, 2, 3));

    }

    public static int executarOperacao(Calculo calculo, int a, int b) {
        return calculo.calcular(a, b);
    }

}

@FunctionalInterface
interface Calculo {
    public int calcular(int a, int b);
}
/*
    Por parâmetro recebe outra função
    ou que ela retorna uma função
 */