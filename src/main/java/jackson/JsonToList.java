package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.domain.Car;

import java.util.ArrayList;
import java.util.List;

/***
 * JSON数组字符
 * 串-->List
 */
public class JsonToList {

    public static void main(String[] args) {

        String jsonArray = "[{\"brand\":\"ford\"}, {\"brand\":\"Fiat\"}]";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Car> cars = objectMapper.readValue(jsonArray, new TypeReference<List<Car>>(){});
            System.out.println(cars);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}