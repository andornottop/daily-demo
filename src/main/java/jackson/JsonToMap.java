package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class JsonToMap {

    public static void main(String[] args) {

        String jsonObject = "{\"brand\":\"ford\", \"doors\":5}";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String, Object> jsonMap = objectMapper.readValue(jsonObject,
                    new TypeReference<Map<String,Object>>(){});
            System.out.println(jsonMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}