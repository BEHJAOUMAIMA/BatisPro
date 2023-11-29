package com.example.batispro.mapper;

import com.example.batispro.domain.entity.User;
import com.example.batispro.domain.enums.Role;
import com.example.batispro.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {

    public UserDTO mapToDto(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .mobile(user.getMobile())
                .role(user.getRole().name())
                .build();
    }

    public User mapToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.username());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        user.setMobile(userDTO.mobile());
        user.setRole(Role.valueOf(userDTO.role()));

        return user;
    }


}
