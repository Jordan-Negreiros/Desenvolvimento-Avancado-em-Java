package com.java.avancado.intefacesfuncionais;

import java.util.function.Consumer;


public class Consumidores {

    public static void main(String[] args) {

        /**
         * Method Reference
         *  - Apenas
         *  - Utiliza o parâmetro da forma que ele foi recebido
         */
        Consumer<String> imprimirFrase = System.out::println;
        imprimirFrase.accept("Method Reference");

        Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
        imprimirUmaFrase.accept("Hello World");

    }

}
