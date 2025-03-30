package com.sahil.habit.service;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.habit.dto.request.HabitRequestDTO;
import com.sahil.habit.dto.response.HabitResponseDTO;
import com.sahil.habit.dto.update.HabitUpdateDTO;
import com.sahil.habit.mapper.HabitMapper;
import com.sahil.habit.model.Habit;
import com.sahil.habit.repository.HabitRepository;

@Service
public class HabitService {

    @Autowired
    private HabitRepository repo;

    public List<HabitResponseDTO> getAllHabits() {
        List<HabitResponseDTO> habits = repo.findAll()
            .stream()
            .map(HabitMapper::toHabitResponseDTO)
            .collect(Collectors.toList());
        
        return habits;
    }

    public HabitResponseDTO addHabit(HabitRequestDTO newHabit) {
        Habit savedHabit = repo.save(HabitMapper.toHabit(newHabit));
        return HabitMapper.toHabitResponseDTO(savedHabit);
    }

    public HabitResponseDTO findHabitById(String id) {
        HabitResponseDTO habit = HabitMapper.toHabitResponseDTO(repo.findById(new ObjectId(id)).orElse(null));
        return habit;
    }

    public HabitResponseDTO updateHabitById(String id, HabitUpdateDTO habit) {
        Habit foundHabit = repo.findById(new ObjectId(id)).orElse(null);
        if (foundHabit == null) {
            return null;
        }

        habit.getName().ifPresent(foundHabit::setName);
        habit.getCategory().ifPresent(foundHabit::setCategory);
        habit.getFrequency().ifPresent(foundHabit::setFrequency);
        habit.getDays().ifPresent(foundHabit::setDays);
        habit.getReminderTime().ifPresent(foundHabit::setReminderTime);

        HabitResponseDTO updatedHabit = HabitMapper.toHabitResponseDTO(repo.save(foundHabit));
        return updatedHabit;
    }

    public HabitResponseDTO deleteHabitById(String id) {
        Habit foundHabit = repo.findById(new ObjectId(id)).orElse(null);
        if (foundHabit == null) {
            return null;
        }
        repo.deleteById(foundHabit.getId());
        return HabitMapper.toHabitResponseDTO(foundHabit);
    }

}
