package com.sahil.habit.dto.response;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitResponseDTO {
    
    private String id;
    private String userId;
    private String name;
    private String category;
    private int frequency;
    private List<Integer> days;
    private String reminderTime;
    private int streak;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
