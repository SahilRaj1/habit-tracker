package com.sahil.habit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.habit.model.Habit;
import com.sahil.habit.service.HabitService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1/habit")
public class HabitController {

    @Autowired
    private HabitService service;

    @PostMapping
    public ResponseEntity<Habit> addHabit(@RequestBody Habit newHabit) {
        Habit savedHabit = service.addHabit(newHabit);
        return new ResponseEntity<>(savedHabit, HttpStatus.CREATED);
    }

}
