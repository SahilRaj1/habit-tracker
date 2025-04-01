package com.sahil.habit.exception;

import com.sahil.habit.util.ApiError;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleResourceNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ApiError.error(ex.getMessage(), HttpStatus.NOT_FOUND.value()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGlobalException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ApiError.error("An unexpected error occurred", HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleInvalidRequestException(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult()
                                .getFieldErrors()
                                .stream()
                                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                                .collect(Collectors.toList());
        
        ApiError apiError = ApiError.validationError(errors, "Invalid request body");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

}
