package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {

    Map<String, String> storage;

    public InMemoryKV(Map<String, String> data) {
        storage = new HashMap<>();
        storage.putAll(data);
    }

    @Override
    public void set(String key, String value) {
        if (this.storage.containsKey(key)) {
            this.storage.replace(key, value);
        } else {
            this.storage.put(key, value);
        }
    }

    @Override
    public void unset(String key) {
        this.storage.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return this.storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(this.storage);
    }
}
// END
