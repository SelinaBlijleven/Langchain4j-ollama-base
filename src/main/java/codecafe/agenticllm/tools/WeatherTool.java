package codecafe.agenticllm.tools;

import dev.langchain4j.agent.tool.ToolSpecification;
import dev.langchain4j.model.chat.request.json.JsonObjectSchema;

import java.util.List;

public class WeatherTool {

    public ToolSpecification specification() {
        // the required properties should be specified explicitly
        return ToolSpecification.builder()
                .name("getWeather")
                .description("Returns the weather forecast for a given city")
                .parameters(JsonObjectSchema.builder()
                        .addStringProperty("city", "The city for which the weather forecast should be returned")
                        .addEnumProperty("temperatureUnit", List.of("CELSIUS", "FAHRENHEIT"))
                        .required("city") // the required properties should be specified explicitly
                        .build())
                .build();
    }

    public String getWeather(String city, String temperatureUnit) {
        System.out.println("TOOL CALLED: getWeather(" + city + ", " + temperatureUnit + ")\n");
        return "It is 18 degrees " + temperatureUnit + " in " + city;
    }
}
