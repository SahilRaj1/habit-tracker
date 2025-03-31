package com.sahil.habit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.habit.dto.request.HabitRequestDTO;
import com.sahil.habit.dto.response.HabitResponseDTO;
import com.sahil.habit.dto.update.HabitUpdateDTO;
import com.sahil.habit.service.HabitService;
import com.sahil.habit.util.ApiError;
import com.sahil.habit.util.ApiResponse;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/habit")
public class HabitController {

    @Autowired
    private HabitService service;

    @GetMapping
    public ResponseEntity<?> getAllHabits() {
        List<HabitResponseDTO> habits = service.getAllHabits();
        return ResponseEntity.ok(ApiResponse.success(habits, "Habits fetched successfully", 200, habits.size()));
    }

    @PostMapping
    public ResponseEntity<?> addHabit(@Valid @RequestBody HabitRequestDTO newHabit) {
        HabitResponseDTO savedHabit = service.addHabit(newHabit);
        return ResponseEntity.ok(ApiResponse.success(savedHabit, "Habit added successfully", 200, 1));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneHabit(@PathVariable String id) {
        HabitResponseDTO habit = service.findHabitById(id);
        if (habit == null) {
            return new ResponseEntity<>(ApiError.error("Habit not found", 404), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(ApiResponse.success(habit, "Habit added successfully", 200, 1));
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateHabit(@PathVariable String id, @Valid @RequestBody HabitUpdateDTO habit) {
        HabitResponseDTO savedHabit = service.updateHabitById(id, habit);
        if (savedHabit == null) {
            return new ResponseEntity<>(ApiError.error("Habit not found", 404), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(ApiResponse.success(savedHabit, "Habit added successfully", 200, 1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHabit(@PathVariable String id) {
        HabitResponseDTO deletedHabit = service.deleteHabitById(id);
        if (deletedHabit == null) {
            return new ResponseEntity<>(ApiError.error("Habit not found", 404), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(ApiResponse.success(deletedHabit, "Habit added successfully", 200, 1));
    }

}
