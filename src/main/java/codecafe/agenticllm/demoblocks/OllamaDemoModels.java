/**
 * OllamaDemoModels.java
 * <p>
 * Contains a few variations of models for different demos.
 */
package codecafe.agenticllm.demoblocks;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

public class OllamaDemoModels {

    public static ChatModel defaultModel() {
        return OllamaChatModel.builder()
                // change if Ollama is on another host / port
                .baseUrl("http://localhost:11434")
                // must match models installed with `ollama list`
                .modelName("gemma3:4b")
                .temperature(0.2)
                .build();
    }

    public static ChatModel poeticModel() {
        return OllamaChatModel.builder()
                // change if Ollama is on another host / port
                .baseUrl("http://localhost:11434")
                // must match models installed with `ollama list`
                .modelName("gemma3:4b")
                .temperature(1.0)
                .build();
    }

    public static ChatModel seriousModel() {
        return OllamaChatModel.builder()
                // change if Ollama is on another host / port
                .baseUrl("http://localhost:11434")
                // must match models installed with `ollama list`
                .modelName("gemma3:4b")
                .temperature(0.0)
                .build();
    }
}
