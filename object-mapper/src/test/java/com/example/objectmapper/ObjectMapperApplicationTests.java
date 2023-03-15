package com.example.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws JsonProcessingException {
        System.out.println("---------");

        // Text JSON <-> Object == ObjectMapper

        // controller req json(text) -> object
        // response object -> json(text)

        var objectMapper = new ObjectMapper();

        // object -> text
        var user = new User("steve", 20, "010-9999-6353");

        var text = objectMapper.writeValueAsString(user);

        System.out.println(text);
        // text -> object

        var objectUser = objectMapper.readValue(text, User.class);
        System.out.println(objectUser);
    }   

}
