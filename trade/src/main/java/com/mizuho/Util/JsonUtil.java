package com.mizuho.Util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mizuho.model.Price;
import com.mizuho.model.Vendor;

import java.io.IOException;

public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    public static Price jsonToPrice(String payload) {
        try {
            JsonNode rootNode = mapper.readTree(payload);
            JsonNode vendor = rootNode.get("vendor");
            mapper.treeToValue(vendor, Vendor.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
