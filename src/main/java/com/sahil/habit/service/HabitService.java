package com.sahil.habit.service;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.habit.model.Habit;
import com.sahil.habit.repository.HabitRepository;

@Service
public class HabitService {

    @Autowired
    private HabitRepository repo;

    public List<Habit> getAllHabits() {
        return repo.findAll();
    }

    public Habit addHabit(Habit newHabit) {
        Habit savedHabit = repo.save(newHabit);
        return savedHabit;
    }

    public Habit findHabitById(String id) {
        return repo.findById(new ObjectId(id)).orElse(null);
    }

    public Habit updateHabitById(String id, Habit habit) {
        habit.setId(new ObjectId(id));
        Habit savedHabit = repo.save(habit);
        return savedHabit;
    }

    public void deleteHabitById(String id) {
        repo.deleteById(new ObjectId(id));
        return;
    }

}
