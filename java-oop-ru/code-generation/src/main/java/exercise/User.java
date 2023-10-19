package exercise;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;

// BEGIN
@Value
@Setter
@Getter
// END
class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
