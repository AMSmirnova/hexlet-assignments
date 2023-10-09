package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage data) {
        Map<String, String> temp = new HashMap<>(data.toMap());
        for (Map.Entry<String, String> entry : temp.entrySet()) {
            data.unset(entry.getKey());
            data.set(entry.getValue(), entry.getKey());
        }
    }
}
// END
