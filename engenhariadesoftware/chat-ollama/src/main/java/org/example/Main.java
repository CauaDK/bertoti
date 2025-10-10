package org.example;

import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.models.response.OllamaResult;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = "http://localhost:11434/";
        String model = "qwen3:1.7b";

        OllamaAPI ollama = new OllamaAPI(url);
        ollama.setRequestTimeoutSeconds(60);

        System.out.println("🤖 Chat Ollama iniciado! Digite 'sair' para encerrar.\n");

        while (true) {
            System.out.print("Você: ");
            String pergunta = scanner.nextLine();

            if (pergunta.equalsIgnoreCase("sair")) {
                System.out.println("👋 Encerrando o chat...");
                break;
            }

            try {
                OllamaResult resposta = ollama.generate(model, pergunta, null);
                System.out.println("Ollama: " + resposta.getResponse() + "\n");
            } catch (Exception e) {
                System.out.println("⚠️ Erro ao comunicar com o Ollama: " + e.getMessage());
            }
        }

        scanner.close();
    }
}



