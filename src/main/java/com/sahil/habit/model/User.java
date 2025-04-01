package com.sahil.habit.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {
    
    @Id
    private ObjectId id;
    
    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    private String phoneNumber;

    private String fullName;
    
    private String password;
    
    private Set<String> roles;

    private boolean isActive;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
