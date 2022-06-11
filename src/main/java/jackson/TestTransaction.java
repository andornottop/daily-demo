package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.domain.Transaction;

import java.util.Date;

public class TestTransaction {

    public static void main(String[] args) {

        Transaction transaction = new Transaction("transfer", new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        String output = null;
        try {
            output = objectMapper.writeValueAsString(transaction);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(output);

    }
}