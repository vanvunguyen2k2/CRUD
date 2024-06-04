package com.example.crud.repository.Search;

import com.example.crud.Dto.SearchUserDto;
import com.example.crud.entity.User;
import jakarta.persistence.criteria.Path;
import org.springframework.data.jpa.domain.Specification;

public class UserSearch {
    public static Specification<User> userSpecification (SearchUserDto searchUserDto) {

        return Specification.where(
                (conditionRole(searchUserDto)));

    }

    private static Specification<User> conditionRole(SearchUserDto searchUserDto) {

        if (searchUserDto.getRole() != null) {

            return ((root, query, cri) -> {
                return root.get("role").in(searchUserDto.getRole());
            });

        }else {
            return null;
        }

    }

//    private static Specification<User> conditionName(SearchUserDto searchUserDto) {
//
//
//        if (searchUserDto.getUsername() != null && !"".equals(searchUserDto.getUsername())) {
//            return ((root, query, cri) -> {
//                return cri.like(root.get("username"), "%" + searchUserDto.getUsername() + "%");
//
//            });
//
//        }else {
//            return null;
//        }
//
//    }
}
