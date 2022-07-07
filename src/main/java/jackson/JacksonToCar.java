package jackson;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.domain.Car;

import java.io.IOException;

public class JacksonToCar {

    public static void main(String[] args) {

        ObjectMapper objectMapper = new ObjectMapper();

        String carJson ="{ \"brand\" : \"Mercedes\" }";
        //objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
        try {

            Car car = objectMapper.readValue(carJson, Car.class);
            System.out.println("car brand = " + car.getBrand());
            System.out.println("car doors = " + car.getDoors());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}