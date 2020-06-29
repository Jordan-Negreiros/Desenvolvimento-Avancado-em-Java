package com.java.avancado;

import java.util.HashMap;
import java.util.Map;

public class Recursividade {
    /**
     *  Na recursividade, uma função chama a si mesma repetidamente,
     *  até atingir uma condição de parada. No caso de Java, um método
     *  chama a si mesmo, passando para si objetos primitivos.
     *  Cada chamda gera uma nova entrada na pilha de execução, e alguns dados
     *  podem ser disponibilizados em um escopo global ou local, através de
     *  parâmetros em um escopo global ou local.
     */
    public static void main(String[] args) {

        System.out.println(FatorialRecursivo.fatorial(5));

        System.out.println(FatorialTailCall.fatorialA(5));
    }
}

/**
 * Recursividade tem um papel importante em programação funcional,
 * facilitando que evitemos estados mutáveis e mantenhamos nosso
 * programa mais declarativo, e menos imperativo;
 */
class FatorialRecursivo {
    /**
     *  Neste caso o Java utiliza a tecnologia de empilhamento.
     */
    public static int fatorial (int value) {
        if (value == 1) {
            return value;
        } else {
            return value * fatorial((value - 1));
        }
    }
    /*
     *  ( Método ao usar números altos consome muita memória )
     *  Explicação da Recursividade:
     *
     *  (fatorial(5))
     *  (5 * (fatorial(4)))
     *  (5 * (4 * fatorial(3))))
     *  (5 * (4 * (3 * (fatorial(2)))))
     *  (5 * (4 * (3 * (2 * (fatorial(1))))))
     *  (5 * (4 * (3 * (2 * (1 * (fatorial(0)))))))
     *  (5 * (4 * (3 * (2 * (1 * (1))))))
     *  (5 * (4 * (3 * (2 * (1)))))
     *  (5 * (4 * (3 * (2))))
     *  (5 * (4 * (6)))
     *  (5 * (24))
     *  120
     */
}

/**
 * Tail Call (Recursividade em cauda): Recursão em cauda é uma
 * recursão onde não há nenhuma linha de código após a chamada
 * do próprio método e, sendo assim, não há nenhum tipo de processamento
 * a ser feito após a chamada recursiva.
 *
 * Obs: a JVM não suporta a recursão em cauda, ele lança um
 * estouro de pilha (StackOverFLow)
 * Caso for colocado um número alto vemos que o código não será executado
 */
class FatorialTailCall {
    public static double fatorialA(double valor) {
        return fatorialComTailCall(valor, 1);
    }

    public static double fatorialComTailCall(double valor, double numero) {
        if (valor == 0) {
            return numero;
        }
        return fatorialComTailCall(valor -1, numero * valor);
    }
    /*
     * Explicação da Recursividade com Tail Call:
     * (Neste modelo o cálculo se torna bem menos custoso para a máquina)
     *
     * fatorialA(5,1)
     * fatorialA(4,5)
     * fatorialA(3,20)
     * fatorialA(2,60)
     * fatorialA(1,120)
     * fatorialA(0,120)
     *
     * (5 * 4) = 20
     * (20 * 3) = 60
     * (60 * 2) = 120
     * (120 * 1) - 120
     */
}

/**
 * Memoization: é uma técnica de otimização que consiste no cache do resultado de
 * uma função, baseado nos parâmetros de entrada. Com isso, nas seguintes execuções
 * conseguimos ter uma resposta mais rápidas.
 */
class Memoization {

    static Map<Integer,Integer> MAPA_FATORIAL = new HashMap<>();

    public static void main(String[] args) {

        long I = System.nanoTime();
        System.out.println(fatorialComMemoization(15));
        long F = System.nanoTime();
        System.out.println("FATORIAL 1 "+(F-I));

        /**
         * A cada chamada teremos um tempo menor de execução
         */
        I = System.nanoTime();
        System.out.println(fatorialComMemoization(15));
        
        F = System.nanoTime();
        System.out.println("FATORIAL 2 "+(F-I));
    }

    public static Integer fatorialComMemoization( Integer value ) {
        if ( value == 1 ) {
            return value;
        } else {
            if (MAPA_FATORIAL.containsKey(value)) {
                return   MAPA_FATORIAL.get(value);
            }  else {
                Integer resultado =  value * fatorialComMemoization(value -1);
                MAPA_FATORIAL.put(value,resultado);
                return resultado;
            }
        }
    }
}

/**
 * Exercicio 08: Qual o problema que pode ocorrer ao utilizar recursividade?
 *
 * a) (  ) Deadlook
 * b) (  ) Starvation
 * c) (  ) Concorrência
 * d) ( X ) Estouro de pilha (Stack OverFlow)
 * e) (  ) Erro de compilação
 */
/**
 * Exercicio 09: É uma técnica de otimização que consiste no cache do
 * resultado de uma função, baseada nos parâmetros de
 * entrada, a partir desta afirmação, julgue o item correto.
 *
 * a) ( X ) Memoization
 * b) (  ) Taill Call
 * c) (  ) Lambda
 * d) (  ) Paradigma Imperativo
 * e) (  ) Imutabilidade
 */
/**
 * É uma recursão onde não há nenhuma linha de código após a
 * chamada do próprio método e, sendo assim, não há nenhum tipo
 * de processamento a ser feito após a chamada recursivo, a partir
 * desta afirmação, julgue o item correto.
 *
 * a) (  ) Memoization
 * b) ( X ) Taill Call
 * c) (  ) Lambda
 * d) (  ) Paradigma Imperativo
 * e) (  ) Imutabilidade
 */