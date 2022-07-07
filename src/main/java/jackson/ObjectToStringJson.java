package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.domain.Car;

public class ObjectToStringJson {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = new Car();
        car.setBrand("Mercedes");
        car.setDoors(5);

        String carJson = objectMapper.writeValueAsString(car);

        JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);

        boolean aa = jsonNode.has("aa");

        //System.out.println(jsonNode.get("aa").asText());
        System.out.println(jsonNode.path("aa"));
        System.out.println(jsonNode.path("aa").asText(""));
        System.out.println(jsonNode.path("aa").asInt(1));
        System.out.println(jsonNode.path("brand").asText("ddd"));

        car.setBrand(jsonNode.path("aa").asText());
        System.out.println(objectMapper.writeValueAsString(car));
        System.out.println(aa);
        System.out.println(carJson);
    }
}
