/**
 * Recipe.java
 * <p>
 * In design patterns, we call this a Data Transfer Object. We can provide
 * classes like this as a requirement to the LLM to generate structured output.
 */
package codecafe.agenticllm.dto;

public class Recipe {

    public String title;
    public int servings;
    public String[] ingredients;
    public String[] steps;

    @Override
    public String toString() {
        return """
               Title: %s
               Servings: %d
               Ingredients:
               - %s

               Steps:
               - %s
               """.formatted(
                title,
                servings,
                String.join("\n- ", ingredients),
                String.join("\n- ", steps)
        );
    }
}
