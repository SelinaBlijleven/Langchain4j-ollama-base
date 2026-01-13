/**
 * OllamaDemoRAG.java
 * <p>
 * Previous: OllamaDemoTools
 * Next: OllamaDemoStructuredOutput
 * <p>
 * Implementation of easy RAG, so we can quickly see results. This will be very
 * interesting to expand on if you are implementing the researcher.
 * <p>
 * https://docs.langchain4j.dev/tutorials/rag
 *
 * @author   Lina Blijleven <selina.blijleven@code-cafe.nl>
 *
 */
package codecafe.agenticllm.demos;

import codecafe.agenticllm.services.OllamaStreamingAssistantBuilder;
import codecafe.agenticllm.rag.EmbeddingStoreBuilder;
import codecafe.agenticllm.services.StreamingAssistant;
import codecafe.agenticllm.streaming.StreamingRunner;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.rag.content.retriever.EmbeddingStoreContentRetriever;
import dev.langchain4j.store.embedding.EmbeddingStore;

public class OllamaDemoRAG {

    // ‼️Replace this with your own path️‼️
    private final String documentPath = "C:\\Users\\linab\\Downloads\\Fruitkar01-10";

    public void demo() throws InterruptedException {
        // First, we need to store the documents in our folder as embeddings.
        // We are using a simple and fast implementation that functions in-memory,
        // so there is no need for embedding APIs.
        EmbeddingStore<TextSegment> embeddingStore = EmbeddingStoreBuilder.fromPath(documentPath);

        StreamingAssistant assistant = new OllamaStreamingAssistantBuilder()
                .systemMessage("You are an experienced HR professional who handles questions from new employees " +
                        "of De Fruitkar. Help them learn about the company and keep it wholesome and positive.")
                .contentRetriever(EmbeddingStoreContentRetriever.from(embeddingStore))
                .build();

        // Sadly, our LLM might still ignore the instruction to use the tool.
        String prompt = "What is the writing style and tone of De Fruitkar?";
        System.out.println("User: " + prompt + "\n\n");

        // Create and run the stream to get a response
        System.out.println("Assistant:\n");
        StreamingRunner.run(assistant, prompt);
    }

    public static void main(String[] args) {
        try {
            new OllamaDemoRAG().demo();
        }
        catch (InterruptedException e) {
            System.out.println("Demo interrupted");
        }
    }
}
