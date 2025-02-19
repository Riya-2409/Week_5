package com.handsonpracticeproblem.jsonreaderkeyvalues;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class JsonReader {

    public static void printJsonKeysAndValues(String filePath) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new File(filePath));

        Iterator<Map.Entry<String, JsonNode>> fields = rootNode.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();
            System.out.println(field.getKey() + ": " + field.getValue().asText());
        }
    }

    public static void main(String[] args) throws Exception {
        String filePath = "src/main/resources/data2.json";
        printJsonKeysAndValues(filePath);
    }
}
