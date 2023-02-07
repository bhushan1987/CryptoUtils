package com.cv.beautifier.impl;

import com.cv.beautifier.Beautifier;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONBeautifier implements Beautifier {

    @Override
    public String beautify(String uglyData) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(uglyData);
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);
    }
}
