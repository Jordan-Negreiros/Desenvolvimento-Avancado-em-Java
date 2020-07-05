package com.java.avancado.novidadesJavaOnze;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *      Um dos recursos que foram incluídos na próxima versão do JDK 11 é a API
 *      do Client HTTP padronizada que visa substituir a classe HttpUrlConnection legada,
 *      que está presente no JDK desde os primeiros anos do Java. O problema com essa API
 *      antiga é descrito na proposta de aprimoramento, principalmente porquer agora
 *      ela é considerada antiga e difícil de usar.
 *
 *      A nova API suporta HTTP / 1.1 e HTTP /2. A versão mais recente do protocolo
 *      HTTP foi projetada para melhorar o desempenho geral do envio de solicitações
 *      por um cliente e do recebimento de respostas do servidor. Isso é conseguido
 *      através da introdução de várias alterações, como multiplexação de fluxo,
 *      compactação de cabeçalho e Push Promise. Além disso, o novo cliente HTTP também
 *      suporta nativamente WebSockets.
 */
public class ClientHttpExemplo {

    public static void main(String[] args) throws IOException, InterruptedException {
        connectAkamaiHttpClient();
    }

    static ExecutorService executor = Executors.newFixedThreadPool(3, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            System.out.println("Nova Thread criada :: " + (thread.isDaemon() ? "deamon" : "") + " Thread Group :: " + thread.getThreadGroup());
            return thread;
        }
    });

    private static void connectAkamaiHttpClient() throws IOException, InterruptedException {

        System.out.println("Running HTTP/2 example ...");

        try {
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();

            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code :: " + response.statusCode());
            System.out.println("Headers response :: " + response.headers());

            String responseBody = response.body();
            System.out.println(responseBody);

            List<Future<?>> future = new ArrayList<>();

            responseBody
                    .lines()
                    .filter(line -> line.trim().startsWith("<img height"))
                    .map(line -> line.substring(line.indexOf("src='") + 5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imgFuture = executor.submit(() -> {
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com" + image))
                                    .build();

                            try {
                                HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());

                                System.out.println("Imagem carregada :: " + image + ", status code :: " + imageResponse.statusCode());

                            } catch (IOException | InterruptedException e) {
                                System.out.println("Erro durante requisição da imagem: " + image);
                            }
                        });

                        future.add(imgFuture);

                        System.out.println("Submetido um futuro para imagem :: " + image);
                    });

            future.forEach(f -> {
                try {
                    f.get();

                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Erro ao esperar carregar imagem do fururo");
                }
            });

            long end = System.currentTimeMillis();

            System.out.println("Tempo de carregamento total :: " + (end - start) + " ms");

        } finally {
            executor.shutdown();
        }
    }

    private static void connectAndPrintURLJavaOracle() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://docs.oracle.com/javase/10/language/"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code :: " + response.statusCode());
        System.out.println("Headers response :: " + response.headers());
        System.out.println(response.body());
    }
}
