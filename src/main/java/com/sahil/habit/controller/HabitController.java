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

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/v1/habit")
public class HabitController {

    @Autowired
    private HabitService service;

    @GetMapping
    public ResponseEntity<?> getAllHabits() {
        List<HabitResponseDTO> habits = service.getAllHabits();
        return ResponseEntity.ok(habits);
    }

    @PostMapping
    public ResponseEntity<?> addHabit(@Valid @RequestBody HabitRequestDTO newHabit) {
        HabitResponseDTO savedHabit = service.addHabit(newHabit);
        return ResponseEntity.ok(savedHabit);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneHabit(@PathVariable String id) {
        HabitResponseDTO habit = service.findHabitById(id);
        if (habit == null) {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(habit);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateHabit(@PathVariable String id, @Valid @RequestBody HabitUpdateDTO habit) {
        HabitResponseDTO savedHabit = service.updateHabitById(id, habit);
        if (savedHabit == null) {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(savedHabit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHabit(@PathVariable String id) {
        HabitResponseDTO deletedHabit = service.deleteHabitById(id);
        if (deletedHabit == null) {
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }
        return ResponseEntity.ok(deletedHabit);
    }

}
