package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.domain.Car;

public class JsonToObject {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        String carJson = "{ \"brand\" : \"Mercedes\", \"doors\" : 6 }";

        try {
            Car car = objectMapper.readValue(carJson, Car.class);
            System.out.println(car);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        
    }
}