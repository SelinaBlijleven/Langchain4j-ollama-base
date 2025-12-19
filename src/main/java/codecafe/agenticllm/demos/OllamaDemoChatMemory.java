/**
 * OllamaDemoMessageMemory.java
 * <p>
 * Previous: OllamaDemoLocalMessageHistory
 * <p>
 * Now that we know what a message looks like, we can start looking
 * at the ChatMemory primitive. We will also have our first look
 * at the system message.
 * <p>
 * https://docs.langchain4j.dev/tutorials/chat-memory
 *
 * @author   Lina Blijleven <selina.blijleven@code-cafe.nl>
 */
package codecafe.agenticllm.demos;

import demoblocks.OllamaDemoModels;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;

public class OllamaDemoChatMemory {

    public void demo() {
        ChatModel model = OllamaDemoModels.defaultModel();

        // ChatMemory with a sliding window (keeps last N messages)
        ChatMemory memory = MessageWindowChatMemory.withMaxMessages(10);

        // System message: defines behavior / role
        memory.add(SystemMessage.from("You are a helpful Java instructor who loves speaking in Gen Z slang."));

        // User starts the conversation
        String userMsg1 = "How can we manage message history with LangChain4J in max. 100 words?";
        System.out.print("User:\n" + userMsg1 + "\n\n");
        memory.add(UserMessage.from(userMsg1));

        // We use the chat function with the message memory
        AiMessage aiResponse = model.chat(memory.messages()).aiMessage();
        memory.add(aiResponse);

        System.out.print("Assistant:\n" + aiResponse.text() + "\n");
    }

    public static void main(String[] args) {
        new OllamaDemoChatMemory().demo();
    }
}
