package com.sahil.habit.util;

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

    public static ApiError error(String message, int statusCode) {
        return new ApiError(false, statusCode, message);
    }
}
