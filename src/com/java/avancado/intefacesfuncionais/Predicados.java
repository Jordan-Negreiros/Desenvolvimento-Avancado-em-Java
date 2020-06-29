package com.java.avancado.intefacesfuncionais;

import java.util.function.Predicate;

/**
 * Recebem um parãmetro e retornam um boolean
 */
public class Predicados {

    public static void main(String[] args) {

        Predicate<String> estaVazio = valor -> valor.isEmpty();

        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("João"));

    }

}
