package com.sahil.habit.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse<T> {
    private boolean success;
    private int statusCode;
    private String message;
    private int count;
    private T data;

    public static <T> ApiResponse<T> success(T data, String message, int statusCode, int count) {
        return new ApiResponse<>(true, statusCode, message, count, data);
    }
}
