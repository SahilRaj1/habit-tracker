package com.sahil.habit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.habit.model.Habit;
import com.sahil.habit.service.HabitService;
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
    public ResponseEntity<List<Habit>> getAllHabits() {
        List<Habit> habits = service.getAllHabits();
        return new ResponseEntity<>(habits, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Habit> addHabit(@RequestBody Habit newHabit) {
        Habit savedHabit = service.addHabit(newHabit);
        return new ResponseEntity<>(savedHabit, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habit> getOneHabit(@PathVariable String id) {
        Habit habit = service.findHabitById(id);
        return new ResponseEntity<>(habit, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable String id, @RequestBody Habit habit) {
        Habit savedHabit = service.updateHabitById(id, habit);
        return new ResponseEntity<>(savedHabit, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Habit> deleteHabit(@PathVariable String id) {
        service.deleteHabitById(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
