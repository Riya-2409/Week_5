package com.practiceproblem.convertjavaobject;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ListToJsonArrayExample{
    public static void main(String[] args) {
        try {
            // Create a list of Car objects
            List<Car> carList = Arrays.asList(
                    new Car("Toyota", "Camry", 2022),
                    new Car("Honda", "Civic", 2021),
                    new Car("Ford", "Mustang", 2023)
            );

            // Convert list to JSON array
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(carList);

            // Print JSON array
            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
