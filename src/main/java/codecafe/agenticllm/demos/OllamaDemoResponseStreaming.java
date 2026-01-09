/**
 * OllamaDemoResponseStreaming.java
 * <p>
 * Previous: OllamaDemoModelParameters
 * Next: OllamaDemoTools
 * <p>
 * As you may have noticed, we have been waiting for the entire response to be ready.
 * This is fine for short responses, but not so great for deeper research. In this demo,
 * we tackle this with response streaming.
 * <p>
 * The following article describes response streaming with LangChain, but
 * this is NOT implemented yet.
 * https://docs.langchain4j.dev/tutorials/response-streaming
 * <p>
 * The following links are more useful in understanding what is currently
 * possible using AI Services instead:
 * https://docs.langchain4j.dev/tutorials/ai-services/
 * https://github.com/quarkiverse/quarkus-langchain4j/issues/1374
 *
 * @author  Lina Blijleven <selina.blijleven@code-cafe.nl>
 */
package codecafe.agenticllm.demos;

import codecafe.agenticllm.services.OllamaStreamingAssistantBuilder;
import codecafe.agenticllm.services.StreamingAssistant;

import codecafe.agenticllm.streaming.StreamingRunner;

public class OllamaDemoResponseStreaming {

    public void demo() throws InterruptedException {
        // We now need to create an AI assistant using AI services
        // To facilitate easy use, the AssistantFactory will be used from now on
        // to handle building different services with different needs, while reducing
        // boilerplate.
        StreamingAssistant assistant = new OllamaStreamingAssistantBuilder().build();

        String prompt = "Write a detailed recipe for chocolate chip pancakes.";
        System.out.println("User: " + prompt + "\n\n");

        // Create and run the stream to get a response
        System.out.println("Assistant: \n");
        StreamingRunner.run(assistant, prompt);
    }

    public static void main(String[] args) {
        try {
            new OllamaDemoResponseStreaming().demo();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for done.");
        }
    }
}
