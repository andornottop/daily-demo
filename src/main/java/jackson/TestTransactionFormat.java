package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.domain.Transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTransactionFormat {

    public static void main(String[] args) {

        Transaction transaction = new Transaction("transfer", new Date());

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        objectMapper.setDateFormat(dateFormat);

        String output2 = null;
        try {
            output2 = objectMapper.writeValueAsString(transaction);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(output2);

    }
}