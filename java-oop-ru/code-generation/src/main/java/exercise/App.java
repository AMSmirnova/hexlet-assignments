package exercise;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

// BEGIN
class App {
    public static void save(Path filePath, Car car) {
        String str = car.serialize();
        try {
            Files.writeString(filePath, str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Car extract(Path filePath) {
        String str;
        try {
            str = Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Car.unserialize(str);
    }
}
// END
