package com.java.avancado;

import java.util.Arrays;

public class Lambdas {
    /**
     *  Lambdas obedecem o conceito do paradigma funcional,
     *  com eles podemos facilitar legibilidade do nosso código,
     *  além disso com a nova API Funcional do Java podemos ter
     *  uma alta produtividade para lidar com objetos.
     *  Primeiramente, devemos entender o que são interfaces
     *  funcionais.
     */
    public static void main(String[] args) {
        interfaceFuncional();
    }

    public static void interfaceFuncional() {
        /**
         *  Estrutura de uma lambda
         *  - Quando uma lambda possui apenas uma instrução no corpo de
         *  sua lógica não é necessário o uso de chaves.
         *  InterfaceFuncional nomeVarialvel = parametro -> lógica;
         */
        Funcao gerarUmaSaida = valor -> valor;

        /**
         *  Se a função possui mais de uma instrução DEVEMOS
         *  utilizar chaves e além disso deve explicitar o retorno
         *  se o retorno for diferente de void
         */
        Funcao colocarPrefixoSenhorNaString = valor -> {
          String valorComPrefixo = "Sr. " + valor;
          String valorComPrefixoEPontoFinal = valorComPrefixo + ".";

          return valorComPrefixoEPontoFinal;
        };

        System.out.println(gerarUmaSaida.gerar(Arrays.asList(1, 2, 3, 4)));
        System.out.println(colocarPrefixoSenhorNaString.gerar("Jordan"));
    }

}

/**
 * @FunctionalInterface Proteje a função para que não
 * seja alterada para uma função que não seja funcional
 */
@FunctionalInterface
interface Funcao {
    /**
     * Interfaces funcionais podem ser declaradas
     * como uma labda e podem possuir apenas um método
     * abstrato.
     */
    Object gerar(Object valor);
}

/*
 * Exercício 04: Qual é a sintaxe base de uma lambda?
 *
 * a) (  ) Tipo nomeVariavel = parametro -> logica
 * b) (  ) Tipo nomeVariavel = valor;
 * c) (  ) TipoAbstrato nomeVariavel = valor;
 * d) ( X ) InterfaceFuncional nomeVariavel = parametro -> logico
 * e) (  ) TipoEnum nomeVariavel = parametro -> logica
 */
/*
 * Exercício 04: Quando devemos utilizar chaves em uma lambda ?
 *
 * a) (  ) Quando o mesmo possui apenas uma instrução
 * b) (  ) Quando utilizamos a referencia do método
 * c) (  ) Quando utilizamos a interface Runnable
 * d) ( X ) Quando o mesmo possui mais de uma instrução
 * e) (  ) Quando o mesmo não possui nenhuma instrução
 */
/*
 * Exercício 05: Antes do Java 8, qual era a estratégia utilizada para
 * implementação de interface em uma classe especifica.
 *
 * a) ( x ) Classe Anônima;
 * b) (  ) Declaração de uma outra interface;
 * c) (  ) Enum;
 * d) (  ) Classe Abstrata;
 * e) (  ) Encapsulamento
 */
