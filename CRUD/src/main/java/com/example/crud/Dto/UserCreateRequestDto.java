package com.example.crud.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequestDto {


    @NotBlank(message = "The username mustn't be null")
    private String username;
    @NotBlank(message = "The password mustn't be null")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,}$")

    private String password;
    @NotBlank(message = "The firstName mustn't be null")

    private String firstName;
    @NotBlank(message = "The lastName mustn't be null")

    private String lastName;

}
