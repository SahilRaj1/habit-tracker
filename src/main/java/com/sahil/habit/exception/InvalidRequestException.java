package com.sahil.habit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {
    private final List<String> errors;

    public InvalidRequestException(List<String> errors) {
        super("Invalid request body");
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
