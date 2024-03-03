package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.LocalTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;

// BEGIN

// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @RequestScope
    public Daytime getDayTime() {
        LocalTime min = LocalTime.of(06, 0, 0, 0);
        LocalTime max = LocalTime.of(22, 0, 0, 0);
        if (LocalTime.now().isAfter(min) && LocalTime.now().isBefore(max)) {
            return new Day();
        }
        return new Night();
    }
    // END
}
