/**
 * OllamaDemoModelParameters.java
 * <p>
 * Previous: OllamaConnectionChatMemory
 * <p>
 * In this demo, we look at the influence of the model parameters.
 * Ideally, we would work with a maximum number of output tokens as well.
 * Ollama sadly does not support this, which is why we will work around it
 * with a system message.
 *
 * @author   Lina Blijleven <selina.blijleven@code-cafe.nl>
 */
package codecafe.agenticllm.demos;

import codecafe.agenticllm.demoblocks.OllamaDemoModels;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;

public class OllamaDemoModelParameters {

    /**
     * Retrieve a more poetic response by using a high temperature
     * model and a system message with specific instructions on length/tone.
     *
     * @param   userMsg     User prompt
     * @return  AI response as string
     */
    private String poeticResponse(String userMsg) {
        // Load a model with a high temperature and longer responses
        ChatModel poeticModel = OllamaDemoModels.poeticModel();

        // Ollama does not support maxOutputTokens, we work around it with a
        // system message
        ChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);
        memory.add(SystemMessage.from("You are a poet who writes long poems."));
        memory.add(UserMessage.from(userMsg));

        return poeticModel.chat(memory.messages()).aiMessage().text();
    }

    /**
     * Retrieve a pragmatic response, using a low temperature and a system
     * message with specific instructions on tone and length.
     *
     * @param   userMsg     User prompt
     * @return  AI response as string
     */
    private String seriousResponse(String userMsg) {
        // Load a model with a low temperature
        ChatModel seriousModel = OllamaDemoModels.seriousModel();

        // Ollama does not support maxOutputTokens, we work around it with a
        // system message
        ChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);
        memory.add(SystemMessage.from("You are a very concise researcher who responds in a max. of 20 words."));
        memory.add(UserMessage.from(userMsg));

        return seriousModel.chat(memory.messages()).aiMessage().text();
    }

    public void demo() {
        // User starts the conversation
        String userMsg = "What is love?";
        System.out.print("User:\n" + userMsg + "\n");

        // Serious model responds first
        String ai2 = seriousResponse(userMsg);
        System.out.print("Low temperature and asked to respond like a researcher in max 20 words:\n" + ai2 + "\n");

        // Poetic model responds later and takes longer, due to the length.
        String ai3 = poeticResponse(userMsg);
        System.out.print("High temperature, asked to respond like a wordy poet:\n" + ai3 + "\n");
    }

    public static void main(String[] args) {
        new OllamaDemoModelParameters().demo();
    }
}
