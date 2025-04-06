package com.sahil.habit.mapper;

import org.springframework.stereotype.Component;

import com.sahil.habit.dto.request.UserRequestDTO;
import com.sahil.habit.dto.response.UserResponseDTO;
import com.sahil.habit.model.User;

@Component
public class UserMapper {

    public static User toUser(UserRequestDTO dto) {
        return User.builder()
            .email(dto.getEmail())
            .phoneNumber(dto.getPhoneNumber())
            .fullName(dto.getFullName())
            .password(dto.getPassword())
            .build();
    }

    public static UserResponseDTO toUserResponseDTO(User user) {
        return UserResponseDTO.builder()
            .id(user.getId().toString())
            .email(user.getEmail())
            .phoneNumber(user.getPhoneNumber())
            .fullName(user.getFullName())
            .isActive(user.isActive())
            .createdAt(user.getCreatedAt())
            .updatedAt(user.getUpdatedAt())
            .build();
    }
}
