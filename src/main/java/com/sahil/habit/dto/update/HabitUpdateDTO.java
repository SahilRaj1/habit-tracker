package com.sahil.habit.dto.update;

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
    private Optional<List<Integer>> days = Optional.empty();
    
    @Builder.Default
    private Optional<String> reminderTime = Optional.empty();

}
