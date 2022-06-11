package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.domain.Car;

public class ObjectToStringJson {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Car car = new Car();
        car.setBrand("Mercedes");
        car.setDoors(5);

        String carJson = objectMapper.writeValueAsString(car);
        System.out.println(carJson);
    }
}
