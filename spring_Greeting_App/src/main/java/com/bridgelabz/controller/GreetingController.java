package com.bridgelabz.controller;

import com.bridgelabz.Service.GreetingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping
    public String getGreeting() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

    @PostMapping
    public String postGreeting() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"" + greetingService.getGreetingMessage() + "\"}";
    }

    @GetMapping("/custom")
    public String getGreetingWithParams(@RequestParam(required = false) String firstName,
                                        @RequestParam(required = false) String lastName) {
        return "{\"message\": \"" + greetingService.displayingGreeting(firstName, lastName) + "\"}";
    }
}
