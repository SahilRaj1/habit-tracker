package com.sahil.habit.dto.update;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitUpdateDTO {
    
    @Builder.Default
    private Optional<String> name = Optional.empty();

    @Builder.Default
    private Optional<String> category = Optional.empty();
    
    @Builder.Default
    @Min(value = 1, message = "Frequency must be at least 1")
    private Optional<Integer> frequency = Optional.empty();
    
    @Builder.Default
    private Optional<List<Integer>> days = Optional.empty();
    
    @Builder.Default
    private Optional<String> reminderTime = Optional.empty();

}
