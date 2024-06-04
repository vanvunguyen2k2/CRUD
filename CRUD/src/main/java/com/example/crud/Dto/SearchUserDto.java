package com.example.crud.Dto;

import com.example.crud.entity.Role;
import lombok.Data;

import java.util.Set;

@Data
public class SearchUserDto {
//    private String username;
    private Set<Role> role;


}
