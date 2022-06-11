package jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JSONToNode {

    @SneakyThrows
    public static void main(String[] args) {



        ObjectMapper objectMapper = new ObjectMapper();

        String json = "{ \"f1\":\"Hello\", \"f2\":null }";

        JsonNode jsonNode = objectMapper.readTree(json);

        String f2Value = jsonNode.get("f2").asText("Default");

        System.out.println(f2Value);
    }
}