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

    private Daytime daytime;


    @GetMapping(path = "/welcome")
    public String index() {

        LocalTime min = LocalTime.of(06, 0, 0, 0);
        LocalTime max = LocalTime.of(22, 0, 0, 0);
        if (LocalTime.now().isAfter(min) && LocalTime.now().isBefore(max)) {
            daytime = new Day();
        } else {
            daytime = new Night();
        }

        return "It is " + daytime.getName() + " now! Welcome to Spring!";
    }

}
// END
