package codecafe.agenticllm.tools;

import dev.langchain4j.agent.tool.Tool;

public class CalculatorTool {

    @Tool("Adds two numbers together")
    public int add(int a, int b) {
        System.out.println("TOOL CALLED: add(" + a + ", " + b + ") =" + (a+b) + "\n");
        return a + b;
    }
}
