package com.example.musify.dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "First Name cannot be blank!")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank!")
    private String lastName;
    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Email should be valid")
    private String email;
    @NotBlank(message = "Password cannot be blank!")
    @Size(min = 5, max = 15, message = "Password size invalid")
    private String password;
    @NotBlank(message = "Country cannot be blank!")
    private String country;
   /* @NotBlank(message = "Role cannot be blank!")
    private String role;
    @NotBlank(message = "Status cannot be blank!")
    private String status;*/


}
