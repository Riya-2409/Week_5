package com.handsonpracticeproblem.jsontoxml;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonToXmlConverter {

    public static String convertJsonToXml(String jsonString) throws Exception {
        ObjectMapper jsonMapper = new ObjectMapper();
        JsonNode jsonNode = jsonMapper.readTree(jsonString);

        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(jsonNode);
    }

    public static void main(String[] args) throws Exception {
        String jsonInput = "{ \"name\": \"Samay\", \"age\": 25, \"email\": \"samay@raina.com\" }";

        String xmlOutput = convertJsonToXml(jsonInput);
        System.out.println("XML Output:\n" + xmlOutput);
    }
}