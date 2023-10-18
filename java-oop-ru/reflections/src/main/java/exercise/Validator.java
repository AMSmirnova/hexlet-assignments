package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static List<String> validateLength(Address address) {
        List<String> result = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            MinLength minLength = field.getAnnotation(MinLength.class);
            Object value;
            try {
                field.setAccessible(true);
                value = field.get(address);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (minLength != null && value != null && value.toString().length() < 3) {
                result.add(field.getName());
            }
        }

        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        for (String fieldName : validate(address)) {
            notValidFields.put(fieldName, List.of("can not be null"));
        }
        for (String fieldName : validateLength(address)) {
            notValidFields.put(fieldName, List.of("length less than 3"));
        }

        System.out.println(notValidFields);
        return notValidFields;
    }
}
// END
