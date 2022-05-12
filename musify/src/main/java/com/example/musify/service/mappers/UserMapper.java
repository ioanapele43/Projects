package com.example.musify.service.mappers;

import com.example.musify.dto.UserDTO;
import com.example.musify.dto.UserViewDTO;
import com.example.musify.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "fullName", expression = "java(user.composeFullName())")
    UserViewDTO toViewDto(User user);

    UserDTO toDto(User user);

    User toEntity(UserDTO userDTO);
}
