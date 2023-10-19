package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Getter
@Value
@AllArgsConstructor
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = null;
        try {
            result = objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static Car unserialize(String data) {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = null;
        try {
            car = objectMapper.readValue(data, Car.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
    // END
}
