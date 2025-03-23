package com.sahil.habit.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sahil.habit.model.Habit;

@Repository
public interface HabitRepository extends MongoRepository<Habit, ObjectId> {

}
