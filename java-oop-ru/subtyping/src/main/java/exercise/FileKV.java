package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;

    public FileKV(String filePath, Map<String, String> base) {
        Map<String, String> storage = new HashMap<>(base);
        this.filePath = filePath;
        toFile(storage);
    }

    public void toFile(Map<String, String> base) {
        String data = Utils.serialize(base);
        Utils.writeFile(this.filePath, data);
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> base = Utils.unserialize(Utils.readFile(this.filePath));
        if (base.containsKey(key)) {
            base.replace(key, value);
        } else {
            base.put(key, value);
        }
        toFile(base);
    }

    @Override
    public void unset(String key) {
        Map<String, String> base = Utils.unserialize(Utils.readFile(this.filePath));
        base.remove(key);
        toFile(base);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> base = Utils.unserialize(Utils.readFile(this.filePath));
        return base.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(this.filePath));
    }
}
// END
