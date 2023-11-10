package org.e2e.dataproviders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.e2e.domains.DogDetails;

public class CustomObjectMapper {
    private static ObjectMapper customObjectMapper;

    private CustomObjectMapper() {
    }

    public static ObjectMapper getInstance() {
        if (customObjectMapper == null) {
            customObjectMapper = new ObjectMapper();
        }
        return customObjectMapper;
    }



}
