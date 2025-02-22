package com.bridgelabz.controller;
import com.bridgelabz.model.Greeting;
import com.bridgelabz.Service.GreetingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private final GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/default")
    public Map<String, String> getGreeting() {
        return Map.of("message", greetingService.getGreetingMessage());
    }

    @PostMapping("/message")
    public Map<String, String> postGreeting(@RequestParam(required = false) String firstName,
                                            @RequestParam(required = false) String lastName) {
        return Map.of("message", greetingService.displayingGreeting(firstName, lastName));
    }

    @GetMapping("/all")
    public List<Greeting> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
    @PutMapping("/edit/{id}")
    public Greeting editGreeting(@PathVariable Long id, @RequestParam String newMessage) {
        return greetingService.editGreeting(id, newMessage);
    }
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        greetingService.deleteGreeting(id);
        return "Greeting with ID " + id + " has been deleted.";
    }

}