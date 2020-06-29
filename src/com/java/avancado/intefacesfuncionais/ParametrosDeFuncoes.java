package com.java.avancado.intefacesfuncionais;

import java.util.function.Function;
import java.util.logging.Logger;

public class ParametrosDeFuncoes {

    public static void main(String[] args) {

        Function<String, String> retornaNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String, Integer> converteStringParaInteiroECalculaODobro = string -> Integer.parseInt(string) * 2;

        System.out.println(retornaNomeAoContrario.apply("João"));
        System.out.println(converteStringParaInteiroECalculaODobro.apply("20"));


    }
}
