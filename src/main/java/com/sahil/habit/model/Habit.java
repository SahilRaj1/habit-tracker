package com.sahil.habit.model;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "habits")
public class Habit {

    @Id
    private ObjectId id;

    private String userId;

    private String name;

    private String category;

    private int frequency;

    private List<Integer> days;

    private String reminderTime;
    
    private Streak streak;

    @CreatedDate
    private LocalDate createdAt;

    @LastModifiedDate
    private LocalDate updatedAt;
}
