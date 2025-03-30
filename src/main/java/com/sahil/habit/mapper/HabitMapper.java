package com.sahil.habit.mapper;

import org.springframework.stereotype.Component;

import com.sahil.habit.dto.request.HabitRequestDTO;
import com.sahil.habit.dto.response.HabitResponseDTO;
import com.sahil.habit.model.Habit;
import com.sahil.habit.model.Streak;

@Component
public class HabitMapper {

    public static Habit toHabit(HabitRequestDTO dto) {
        return Habit.builder()
            .userId(dto.getUserId())
            .name(dto.getName())
            .category(dto.getCategory())
            .frequency(dto.getFrequency())
            .days(dto.getDays())
            .reminderTime(dto.getReminderTime())
            .streak(new Streak(0, 0, null))
            .build();
    }

    public static HabitResponseDTO toHabitResponseDTO(Habit habit) {
        return HabitResponseDTO.builder()
            .id(habit.getId().toString())
            .userId(habit.getUserId())
            .name(habit.getName())
            .category(habit.getCategory())
            .frequency(habit.getFrequency())
            .days(habit.getDays())
            .reminderTime(habit.getReminderTime())
            .streak(habit.getStreak().getCurrent())
            .createdAt(habit.getCreatedAt())
            .updatedAt(habit.getUpdatedAt())
            .build();
    }
}
