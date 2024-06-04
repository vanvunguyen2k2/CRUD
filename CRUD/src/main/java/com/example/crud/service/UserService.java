package com.example.crud.service;

import com.example.crud.Dto.SearchUserDto;
import com.example.crud.Dto.UserCreateRequestDto;
import com.example.crud.Dto.UserDto;
import com.example.crud.Dto.UserUpdateRequestDto;
import com.example.crud.entity.Role;
import com.example.crud.entity.User;
import com.example.crud.repository.Search.UserSearch;
import com.example.crud.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class UserService implements IUservice {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public User create(UserCreateRequestDto dto) {
        Optional<User> optionalUser = userRepo.findUserByUsername(dto.getUsername());
        if (optionalUser.isPresent()) {
            System.out.println("USER_NAME_EXISTSED");
        }
        User user  = new User();
        BeanUtils.copyProperties(dto, user);
        String passwordEncodeder = passwordEncoder.encode(dto.getPassword());
        user.setRole(Role.EMPLOYER);
        user.setPassword(passwordEncodeder);
        user.setWorking(true);
        return userRepo.save(user);
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepo.findAll(pageable);

    }

    @Override
    public User update(UserUpdateRequestDto dto) {
        User entity = new User();
        BeanUtils.copyProperties(dto, entity);
        return userRepo.save(entity);
    }

    @Override
    public UserDto get_by_id(int id) {
        Optional<User> userOptional = userRepo.findById(id);


        if (userOptional.isPresent()){
            UserDto  userDto = modelMapper.map(userOptional.get(), UserDto.class);
            return userDto;
        }else {
            return null;
        }

    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Optional<User> checkRole = userRepo.findById(id);
        if (checkRole.isEmpty()) {
            User user = checkRole.get();

            if (user.getRole() == Role.ADMIN) {
                user.setWorking(false);
                userRepo.save(user);

            }else {
                System.out.println("FORBIDDEN");
            }

        }
        User user = checkRole.get();
        user.setWorking(false);
        userRepo.save(user);
    }

    @Override
    public Page<User> search(SearchUserDto searchUserDto, Pageable pageable) {
        Specification<User>  condition = UserSearch.userSpecification(searchUserDto);
        return userRepo.findAll(condition, pageable);
    }


}
