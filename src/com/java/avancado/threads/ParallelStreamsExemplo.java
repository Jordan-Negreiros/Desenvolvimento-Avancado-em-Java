package com.java.avancado.threads;

import java.util.stream.IntStream;

public class ParallelStreamsExemplo {

    public static void main(String[] args) {
        /**
         *  Serial Stream
         */
        long inicio = System.currentTimeMillis();

        IntStream.range(1, 100000).forEach(num -> fatorial(num));

        long fim = System.currentTimeMillis();
        System.out.println("Tempo de Execução Serial:: " + (fim - inicio));

        /**
         *  Parallel Stream
         */
        inicio = System.currentTimeMillis();

        IntStream.range(1, 100000).parallel().forEach(num -> fatorial(num));

        fim = System.currentTimeMillis();
        System.out.println("Tempo de Execução Parallel :: " + (fim - inicio));
    }

    public static long fatorial(long num) {
        long fat = 1;

        for (long i = 2; i <= num; i++) {
            fat *=i;
        }

        return fat;
    }
}
