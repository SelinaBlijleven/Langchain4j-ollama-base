/**
 * OllamaDemoTools.java
 * <p>
 * Previous: OllamaDemoResponseStreaming
 * Next: OllamaDemoRAG
 * <p>
 * In this demo, we will learn how to use tools with our LLM. Now we are truly progressing
 * towards agentic AI! Our model will use the tools available if necessary, making it more
 * autonomous. The tools in this demo are very simple, and will print a message to the terminal
 * when used. Of course, proper logging would be a much better solution :)
 * <p>
 * https://docs.langchain4j.dev/tutorials/tools
 *
 * @author   Lina Blijleven <selina.blijleven@code-cafe.nl>
 */
package codecafe.agenticllm.demos;

import codecafe.agenticllm.services.OllamaStreamingAssistantBuilder;
import codecafe.agenticllm.services.StreamingAssistant;
import codecafe.agenticllm.streaming.StreamingRunner;
import codecafe.agenticllm.tools.CalculatorTool;
import codecafe.agenticllm.tools.WeatherTool;

public class OllamaDemoTools {

    public void demo() throws InterruptedException {
        // Get the base initialization out of the way
        OllamaStreamingAssistantBuilder assistantBuilder = new OllamaStreamingAssistantBuilder();

        // Let's also bring back the system message, which can also
        // be added to the AI services!
        // LangChain4j uses .systemMessageProvider, but we will use a set system
        // message for now. You can give this any type of function that
        // would help you include relevant details, such as the date/time and location of the user.
        assistantBuilder.systemMessage("You are a helpful assistant with access " +
                "to tools. Respond with a maximum of two sentences and use tools when needed.");

        // We can create tools two ways. I would recommend the second
        // method, but it is nice to see what the specification looks like:
        // we are kind of providing it with documentation!
        weatherDemo(assistantBuilder);
        calculatorDemo(assistantBuilder);
    }

    public void weatherDemo(OllamaStreamingAssistantBuilder assistantFactory) throws InterruptedException {
        // Method 1. With an explicit tool specification and object with a matching function
        WeatherTool weatherTool = new WeatherTool();
        StreamingAssistant assistant = assistantFactory
                .tools(weatherTool.specification(), weatherTool)
                .build();

        // Sadly, our LLM might still ignore the instruction to use the tool.
        String prompt = "You do not know the weather yourself. Use tools if needed. What is the weather in London? Use the getWeather function";
        System.out.println("User: " + prompt + "\n\n");

        // Create and run the stream to get a response
        System.out.println("Assistant:\n");
        StreamingRunner.run(assistant, prompt);
    }

    public void calculatorDemo(OllamaStreamingAssistantBuilder assistantFactory) throws InterruptedException {
        // Method 2. With the @Tool annotation, which will handle the tool specification for us!
        StreamingAssistant assistant = assistantFactory
                .tools(new CalculatorTool())
                .build();

        // Let's test
        String prompt = "Calculate 18 + 29 without doing it yourself";
        System.out.println("User: " + prompt + "\n\n");
        System.out.println("Assistant:\n");
        StreamingRunner.run(assistant, prompt);
    }

    public static void main(String[] args) {
        try {
            new OllamaDemoTools().demo();
        }
        catch (InterruptedException e) {
            System.out.println("Interrupted during demo");
        }
    }
}
