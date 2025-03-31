package com.sahil.habit.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HealthCheckController {

    @GetMapping("api/v1/health-check")
    public String healthCheck() {
        return "Server is running";
    }

}
