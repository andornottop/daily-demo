package jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class JacksonTreeModel {

    public static void main(String[] args) {

        String carJson =
                "{ \"brand\" : \"Mercedes\", \"doors\" : 5 }";

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);
            System.out.println(jsonNode);

        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}