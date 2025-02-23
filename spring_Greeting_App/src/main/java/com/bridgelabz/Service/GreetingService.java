package com.bridgelabz.Service;

import com.bridgelabz.model.Greeting;
import com.bridgelabz.repository.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    // ✅ Default Greeting Message
    public String getGreetingMessage() {
        return "Hello World";
    }

    // ✅ Create Personalized Greeting & Save to DB
    public String displayingGreeting(String firstName, String lastName) {
        String message;

        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello " + lastName + "!";
        } else {
            message = getGreetingMessage();
        }

        saveGreeting(message);  // Save to database
        return message;
    }

    // ✅ Save Greeting Message in DB
    public void saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        greetingRepository.save(greeting);
    }

    // ✅ Fetch All Saved Greetings
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
}
