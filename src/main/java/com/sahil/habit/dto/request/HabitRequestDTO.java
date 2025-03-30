package com.sahil.habit.dto.request;

import jakarta.validation.constraints.*;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitRequestDTO {

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotBlank(message = "Habit name is required")
    private String name;

    @NotBlank(message = "Category is required")
    private String category;

    @Min(value = 1, message = "Frequency must be at least 1")
    private int frequency;

    @NotEmpty(message = "At least one day must be selected")
    private List<Integer> days;

    private String reminderTime;
}
