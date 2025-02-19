package com.handsonpracticeproblem.mergejsonfiles;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JsonMerger {
    public static void main(String[] args) {
        String jsonFile1 = "src/main/resources/file1.json";
        String jsonFile2 = "src/main/resources/file2.json";
        String outputJsonFile = "merge.json";

        try {
            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Read both JSON files
            JsonNode node1 = objectMapper.readTree(new File(jsonFile1));
            JsonNode node2 = objectMapper.readTree(new File(jsonFile2));

            // Merge JSON objects
            ObjectNode mergedNode = objectMapper.createObjectNode();
            mergedNode.setAll((ObjectNode) node1);
            mergedNode.setAll((ObjectNode) node2);

            // Write merged JSON to file
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(outputJsonFile), mergedNode);

            System.out.println("JSON files successfully merged into " + outputJsonFile);
            System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedNode));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

