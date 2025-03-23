package com.sahil.habit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.habit.model.Habit;
import com.sahil.habit.repository.HabitRepository;

@Service
public class HabitService {

    @Autowired
    private HabitRepository repo;

    public Habit addHabit(Habit newHabit) {
        Habit savedHabit = repo.save(newHabit);
        return savedHabit;
    }

}
