package com.example.musify.service.mappers;

import com.example.musify.dto.UserViewDTO;
import com.example.musify.model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperImplTest {
    @BeforeAll
    public static void setup(){
        System.out.println("setup was executed");
    }
    @BeforeEach
    public void init(){
        System.out.println("init was executed");
    }

    @Test
    @DisplayName("To view DTO test")
    public void givenValidUser_whenMappingToUserViewDTO_thenReturnValidUserViewDTO(){
        Integer id=1;
        String firstname="pele";
        String lastname="ioana";
        String email="peleioana";
        String password="1234";
        String role="admin";
        String country="romania";
        String status="active";
        User user=new User();
        user.setId(id);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
        user.setCountry(country);
        user.setRole(role);
        user.setStatus(status);

        UserMapper userMapper=new UserMapperImpl();
        UserViewDTO userViewDTO=userMapper.toViewDto(user);
        assertEquals(userViewDTO.getFirstName(),firstname);
    }
    @Test
    @DisplayName("To view DTO null test")
    public void givenNullUser_whenMappingToUserViewDTO_thenReturnNull(){
        UserMapper userMapper=new UserMapperImpl();
        UserViewDTO userViewDTO=userMapper.toViewDto(null);
        assertNull(userViewDTO);
    }
}