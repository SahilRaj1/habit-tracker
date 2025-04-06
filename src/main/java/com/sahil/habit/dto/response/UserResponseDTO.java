package com.sahil.habit.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    
    private String id;
    private String email;
    private String phoneNumber;
    private String fullName;
    private boolean isActive;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
