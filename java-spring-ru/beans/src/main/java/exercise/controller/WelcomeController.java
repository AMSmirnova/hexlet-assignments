package exercise.controller;

import exercise.daytime.Day;
import exercise.daytime.Daytime;
import exercise.daytime.Night;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

// BEGIN
@RestController
public class WelcomeController {

    @Autowired
    private Daytime daytime;

    @GetMapping(path = "/welcome")
    public String welcome() {
        return "It is " + daytime.getName() + " now! Welcome to Spring!";
    }

}
// END
