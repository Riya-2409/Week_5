package com.handsonpracticeproblem.validateemail;

import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONException;

public class JsonSchemaValidator {

    private static final String SCHEMA_STRING = "{"
            + "\"type\": \"object\","
            + "\"properties\": {"
            + "    \"email\": { \"type\": \"string\", \"format\": \"email\" }"
            + "},"
            + "\"required\": [\"email\"]"
            + "}";

    public static boolean validateJson(String jsonString) {
        try {
            JSONObject jsonSchema = new JSONObject(SCHEMA_STRING);
            JSONObject jsonObject = new JSONObject(jsonString);

            Schema schema = SchemaLoader.load(jsonSchema);
            schema.validate(jsonObject);
            return true;
        } catch (JSONException | org.everit.json.schema.ValidationException e) {
            System.out.println("Invalid JSON: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String validJson = "{ \"email\": \"ranveer@allahbadia.com\" }";
        String invalidJson = "{ \"email\": \"invalid-email\" }";

        System.out.println("Valid JSON Test: " + validateJson(validJson));
        System.out.println("Invalid JSON Test: " + validateJson(invalidJson));
    }
}