/**
 * OllamaDemoAssistantFactory.java
 * <p>
 * A wrapper class around the AI Services factory, that makes building an AI
 * service that suits our needs a little bit easier.
 */
package codecafe.agenticllm.models;

import codecafe.agenticllm.services.StreamingAssistant;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.rag.content.retriever.ContentRetriever;
import dev.langchain4j.service.AiServices;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class OllamaDemoAssistantBuilder {

    private final AiServices<StreamingAssistant> builder;

    public OllamaDemoAssistantBuilder() {
        // Memory store, which we need for AI Services (required for @MemoryId in the StreamingAssistant interface)
        Map<Integer, ChatMemory> memories = new ConcurrentHashMap<>();

        // Create a StreamingAssistant builder
        this.builder = AiServices.builder(StreamingAssistant.class)
                .chatModel(OllamaDemoModels.defaultModel())
                .streamingChatModel(OllamaDemoModels.streamingChatModel())
                .chatMemoryProvider(id -> memories.computeIfAbsent((Integer) id, _ -> MessageWindowChatMemory.withMaxMessages(10)));
    }

    public OllamaDemoAssistantBuilder tools(Object assistantTool) {
        builder.tools(assistantTool);
        // allow chaining
        return this;
    }

    public OllamaDemoAssistantBuilder tools(Object... assistantTools) {
        builder.tools(assistantTools);
        // allow chaining
        return this;
    }

    public OllamaDemoAssistantBuilder systemMessage(String systemMsg) {
        builder.systemMessageProvider(_ -> systemMsg);
        // allow chaining
        return this;
    }

    public OllamaDemoAssistantBuilder contentRetriever(ContentRetriever contentRetriever) {
        builder.contentRetriever(contentRetriever);
        // allow chaining
        return this;
    }

    public StreamingAssistant build() {
        return this.builder.build();
    }
}
