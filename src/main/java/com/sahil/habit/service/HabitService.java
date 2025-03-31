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
        int frequency = savedHabit.getDays().size();
        savedHabit.setFrequency(frequency);
        return HabitMapper.toHabitResponseDTO(savedHabit);
    }

    public HabitResponseDTO findHabitById(String id) {
        Habit foundHabit = repo.findById(new ObjectId(id)).orElse(null);
        if (foundHabit == null) {
            return null;
        }
        return HabitMapper.toHabitResponseDTO(foundHabit);
    }

    public HabitResponseDTO updateHabitById(String id, HabitUpdateDTO habit) {
        Habit foundHabit = repo.findById(new ObjectId(id)).orElse(null);
        if (foundHabit == null) {
            return null;
        }

        habit.getName().ifPresent(foundHabit::setName);
        habit.getCategory().ifPresent(foundHabit::setCategory);
        habit.getDays().ifPresent(days -> {
            foundHabit.setDays(days);
            foundHabit.setFrequency(days.size());
        });
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
