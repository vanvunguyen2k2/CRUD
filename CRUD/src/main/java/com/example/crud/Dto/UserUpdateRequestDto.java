package com.example.crud.Dto;

import com.example.crud.entity.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequestDto {

    private int id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private  String email;

}
