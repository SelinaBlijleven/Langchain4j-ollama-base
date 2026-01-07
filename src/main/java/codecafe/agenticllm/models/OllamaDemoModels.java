/**
 * OllamaDemoModels.java
 * <p>
 * Contains a few variations of models for different demos.
 */
package codecafe.agenticllm.models;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.StreamingChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import dev.langchain4j.model.ollama.OllamaStreamingChatModel;

public class OllamaDemoModels {

    // change if Ollama is on another host / port
    public static String baseUrl = "http://localhost:11434";
    // must match models installed with `ollama list`
    public static String modelName = "qwen3:4b";

    public static StreamingChatModel streamingChatModel() {
        // build the default model, but with streaming
        return OllamaStreamingChatModel.builder()
                .baseUrl(OllamaDemoModels.baseUrl)
                .modelName(OllamaDemoModels.modelName)
                .temperature(0.2)
                .build();
    }

    public static ChatModel defaultModel() {
        // default model for demo's, without streaming
        return OllamaChatModel.builder()
                .baseUrl(OllamaDemoModels.baseUrl)
                .modelName(OllamaDemoModels.modelName)
                .temperature(0.2)
                .build();
    }

    public static ChatModel poeticModel() {
        // poetic model with a high temperature
        return OllamaChatModel.builder()
                .baseUrl(OllamaDemoModels.baseUrl)
                .modelName(OllamaDemoModels.modelName)
                .temperature(1.0)
                .build();
    }

    public static ChatModel seriousModel() {
        // 'serious' model with low temperature
        return OllamaChatModel.builder()
                .baseUrl(OllamaDemoModels.baseUrl)
                .modelName(OllamaDemoModels.modelName)
                .temperature(0.0)
                .build();
    }
}
