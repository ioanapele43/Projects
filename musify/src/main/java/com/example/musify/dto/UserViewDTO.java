package com.example.musify.dto;

import lombok.*;

import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserViewDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String email;
    private String status;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserViewDTO that = (UserViewDTO) o;
        return id == that.id && firstName.equals(that.firstName) && lastName.equals(that.lastName) && fullName.equals(that.fullName) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, fullName, email);
    }
}
