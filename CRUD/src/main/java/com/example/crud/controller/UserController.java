package com.example.crud.controller;

import com.example.crud.Dto.UserCreateRequestDto;
import com.example.crud.Dto.UserDto;
import com.example.crud.Dto.UserUpdateRequestDto;
import com.example.crud.entity.User;
import com.example.crud.repository.UserRepo;
import com.example.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/create")
    public User create(@RequestBody UserCreateRequestDto dto){
        return userService.create(dto);
    }

    @GetMapping("/getAll")
    public Page<User> getAll(Pageable pageable){
        return userService.getAll(pageable);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") int id){
//        Optional<User> user = userRepo.findById(id);
//        System.out.println(user.get());

         userService.deleteUser(id);

    }

    @PutMapping("/update")
    public User update(@RequestBody UserUpdateRequestDto dto){
        return userService.update(dto);
    }

    @GetMapping("/get_by_id/{id}")
    public UserDto get_by_id(@PathVariable(name = "id")   int id){
            return userService.get_by_id(id);


    }
}
