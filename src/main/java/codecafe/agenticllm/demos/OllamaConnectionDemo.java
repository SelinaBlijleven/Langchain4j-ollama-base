/**
 * OllamaConnectionDemo.java
 * <p>
 * The first step to using a language model with LangChain4J
 * and Ollama.
 * <p>
 * https://docs.langchain4j.dev/tutorials/chat-and-language-models
 *
 * @author      Lina Blijleven <selina.blijleven@code-cafe.nl>
 */
package codecafe.agenticllm.demos;

import demoblocks.OllamaDemoModels;
import dev.langchain4j.model.chat.ChatModel;

public class OllamaConnectionDemo {

    public void demo() {
        // Load demo model through Ollama: gemma3:4b
        ChatModel model = OllamaDemoModels.defaultModel();

        // We can call the chat model with a string
        String response = model.chat(
                "How are you doing bestie?"
        );

        System.out.println("Response:");
        System.out.println(response);
    }


    public static void main(String[] args) {
        new OllamaConnectionDemo().demo();
    }
}
