/**
 * StreamingAssistant.java
 * <p>
 * If we want to stream, we can currently only do it with AIServices,
 * which is designed to help you build your own. We need to provide an interface
 * to the AI services builder, with the methods we intend to provide through the service.
 * In the streaming demo, we need a chat function that results in a TokenStream. We define
 * that function here, along with the necessary memory management to use AIServices.
 * <p>
 * You are free to use this code for your assignment.
 *
 * @author  Lina Blijleven <selina.blijleven@code-cafe.nl>
 */
package codecafe.agenticllm.services;

import dev.langchain4j.service.*;

public interface StreamingAssistant {

    TokenStream chat(
            @MemoryId int memoryId,
            @UserMessage String message
    );
}
