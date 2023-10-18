package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class Validator {
    public static List<String> validate(Address address) {
        List<String> result = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            NotNull notNull = field.getAnnotation(NotNull.class);
            Object value;
            try {
                field.setAccessible(true);
                value = field.get(address);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (notNull != null && value == null) {
                result.add(field.getName());
            }
        }
        return result;
    }
}
// END
