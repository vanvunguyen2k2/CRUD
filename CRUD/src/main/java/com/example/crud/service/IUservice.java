package com.example.crud.service;

import com.example.crud.Dto.SearchUserDto;
import com.example.crud.Dto.UserCreateRequestDto;
import com.example.crud.Dto.UserDto;
import com.example.crud.Dto.UserUpdateRequestDto;
import com.example.crud.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUservice {

    User create(UserCreateRequestDto dto);

    Page<User> getAll(Pageable pageable);

    User update(UserUpdateRequestDto dto);

    UserDto get_by_id(int id);

    void deleteUser(int id);

    Page<User> search (SearchUserDto searchUserDto, Pageable pageable);

}
