package org.example;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class Main {

    public static void main(String[] args) {

        ChatModel model = OllamaChatModel.builder()
                // change if Ollama is on another host / port
                .baseUrl("http://localhost:11434")
                // must match models installed with `ollama list`
                .modelName("gemma3:4b")
                .temperature(0.2)
                .build();

        String response = model.chat(
                "How are you doing bestie?"
        );

        System.out.println("Response:");
        System.out.println(response);
    }
}
