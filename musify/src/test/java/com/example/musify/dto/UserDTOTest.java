package com.example.musify.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {
    @Test
    public void givenValidUserViewDto_whenSerializingAndDeserializing_thenResultIsSimilar() throws JsonProcessingException {
        UserViewDTO userViewDTO=new UserViewDTO(1,"pele","ioana","pele ioana","peleioana","active");
        ObjectMapper objectMapper=new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(userViewDTO);
        UserViewDTO userViewDTO1 = objectMapper.readValue(valueAsString, UserViewDTO.class);
        assertEquals(userViewDTO1,userViewDTO);
    }

}