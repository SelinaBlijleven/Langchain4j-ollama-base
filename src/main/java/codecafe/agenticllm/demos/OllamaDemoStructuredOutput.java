/**
 * OllamaDemoStructuredOutput.java
 * <p>
 * Previous: OllamaDemoRAG
 * <p>
 * This is the last demo for the mini course, but the LangChain4J framework still offers
 * more to explore :)
 * <p>
 * https://docs.langchain4j.dev/tutorials/structured-outputs
 *
 * @author   Lina Blijleven <selina.blijleven@code-cafe.nl>
 *
 */
package codecafe.agenticllm.demos;

import codecafe.agenticllm.dto.Recipe;
import codecafe.agenticllm.models.OllamaDemoModels;
import codecafe.agenticllm.services.StructuredAssistant;
import dev.langchain4j.service.AiServices;

public class OllamaDemoStructuredOutput {

    public void demo() {
        // LangChain will provide the output schema later.
        String systemMsg = "You are Gordon Ramsay, a master recipe creator here to help users " +
                "find the recipes for their favourite foods. You give every recipe a title, determine " +
                "how many it serves and you include an ingredient list. You also include detailed " +
                "steps for preparation.";
        String prompt =
                "Create a recipe for chocolate chip pancakes.";
        System.out.println("System: " + systemMsg);
        System.out.println("User: " + prompt);

        // When we create structured output, we need to validate before outputting.
        // This means that it's not compatible with streaming, so we will be
        // building the AI service manually here. It might be a good idea to create
        // your own builders or factories for this :)
        StructuredAssistant assistant =
                AiServices.builder(StructuredAssistant.class)
                        .systemMessageProvider(_ -> systemMsg)
                        .chatModel(OllamaDemoModels.defaultModel())
                        .build();

        // We can create a new recipe that follows the Recipe class perfectly.
        // It seems like magic, but is the result of careful output validation and retries.
        // Sometimes, the possible tokens are also restricted as a way to prevent invalid output
        // when working with LLMs.
        Recipe recipe = assistant.createRecipe(prompt);

        System.out.println("Gordon Ramsay: ");
        System.out.println(recipe);
    }

    public static void main(String[] args) {
        new OllamaDemoStructuredOutput().demo();
    }
}
