/**
 * OllamaDemoMessageHistory.java
 * <p>
 * Previous: OllamaDemoConnection
 * Next: OllamaDemoChatMemory
 * <p>
 * LLM's are inherently stateless. This means we need to manage
 * the conversation history somehow. LangChain4J uses the AIMessage
 * and UserMessage primitives for this.
 * <p>
 * In this demo, we take a closer look at how they function, so
 * we can understand the chat history better.
 *
 * @author   Lina Blijleven <selina.blijleven@code-cafe.nl>
 */
package codecafe.agenticllm.demos;

import codecafe.agenticllm.models.OllamaDemoModels;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;

import java.util.ArrayList;
import java.util.List;

public class OllamaDemoLocalMessageHistory {

    public void demo() {
        // Load demo model through Ollama: gemma3:4b
        ChatModel model = OllamaDemoModels.defaultModel();

        // Start keeping a history in our local memory
        List<ChatMessage> history = new ArrayList<>();

        // User starts the conversation
        String userMsg1 = "How can we manage message history with LangChain4J in max. 100 words?";
        System.out.print("User:\n" + userMsg1 + "\n");
        history.add(UserMessage.from(userMsg1));

        // First model response
        AiMessage aiResponse1 = model.chat(history).aiMessage();
        System.out.println("AI:\n" + aiResponse1.text() + "\n");
        history.add(aiResponse1);

        // Follow-up from user
        String userMsg2 = "Can you summarize that in one sentence?";
        System.out.print("User:\n" + userMsg2 + "\n");
        history.add(UserMessage.from(userMsg2));

        // Second model response (with context)
        AiMessage aiResponse2 = model.chat(history).aiMessage();
        System.out.println("AI:\n" + aiResponse2.text() + "\n");
        history.add(aiResponse2);
    }


    public static void main(String[] args) {
        new OllamaDemoLocalMessageHistory().demo();
    }
}
