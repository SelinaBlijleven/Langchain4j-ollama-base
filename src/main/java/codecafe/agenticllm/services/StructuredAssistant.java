/**
 * StructuredAssistant.java
 * <p>
 * For this assistant, we are creating a service that
 * generates recipes in a structured format. Note that there
 * is no streaming involved in this assistant.
 */
package codecafe.agenticllm.services;

import codecafe.agenticllm.dto.Recipe;
import dev.langchain4j.service.UserMessage;

public interface StructuredAssistant extends Assistant {

    Recipe createRecipe(@UserMessage String request);
}
