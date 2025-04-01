package com.sahil.habit.util;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {
    
    private boolean success;
    private int statusCode;
    private String message;
    private List<String> errors;

    public static ApiError error(String message, int statusCode) {
        return new ApiError(false, statusCode, message, new ArrayList<>());
    }

    public static ApiError validationError(List<String> errors, String message) {
        return new ApiError(false, 400, "Validation failed", errors);
    }

}
