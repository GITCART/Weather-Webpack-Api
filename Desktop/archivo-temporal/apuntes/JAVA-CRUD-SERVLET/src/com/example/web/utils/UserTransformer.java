package com.example.web.utils;

import com.example.web.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class UserTransformer {

    public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public static String objectToJson(List<User> users) throws JsonProcessingException {
        return JSON_MAPPER.writerWithDefaultPrettyPrinter()
                .writeValueAsString(users);
    }

    public static User jsonToObject(String user) throws JsonProcessingException {
        return JSON_MAPPER.readValue(user, User.class);
    }

}
