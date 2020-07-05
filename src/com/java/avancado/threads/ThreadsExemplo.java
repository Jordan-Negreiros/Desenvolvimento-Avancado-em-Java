package com.java.avancado.threads;

/**
 * Thread é um pequeno programa que trabalha como um subsistema,
 * sendo uma forma de um processo se autodividir em duas ou mais
 * tarefas. Essas tarefas múltiplas podem ser executadas simultaneamente
 * para rodar mais rápido do que um programa em um único bloco ou praticamente
 * juntas.
 *
 * Síncrono e Assíncrono
 * O processamento síncrono, são todos os processamentos que ocorrem em sequência (sincronia).
 * Os processos são executados em fila. É preciso que um processo termine para que o outro
 * processo seja executado. Ex: imagine você lavando louça e de repente você se lembra que
 * tem que fazer uma ligação. A ligação só poderá ser realizada quando o processo lavar louça
 * for finalizado.
 */
public class ThreadsExemplo {

    public static void main(String[] args) {

        GerarPDF gerarPDF = new GerarPDF();
        BarraDeCarregamento barraDeCarregamento = new BarraDeCarregamento(gerarPDF);

        gerarPDF.start();
        barraDeCarregamento.start();

    }
}

class GerarPDF extends Thread {

    @Override
    public void run() {

        try {
            System.out.println("Iniciar geração de PDF");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento extends Thread {

    private Thread gerarPDF;

    public BarraDeCarregamento(Thread gerarPDF) {
        this.gerarPDF = gerarPDF;
    }

    @Override
    public void run() {
           while (true) {
               try {
                   Thread.sleep(500);

                   if (!gerarPDF.isAlive()) {
                       break;
                   }

                   System.out.println("Loading ...");

               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

       }
    }
}

class BarraDeCarregametno2 extends Thread {

    @Override
    public void run() {
        System.out.println("Rodei: BarraDeCarregametno2 " + this.getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class BarraDeCarregametno3 extends Thread {

    @Override
    public void run() {
        System.out.println("Rodei: BarraDeCarregametno3 " + this.getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
