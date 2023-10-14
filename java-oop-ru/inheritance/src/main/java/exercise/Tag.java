package exercise;

import java.util.Map;

// BEGIN
abstract class Tag {
    private String name;
    private Map<String, String> attributes;

    Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes = attributes;
    }

    public abstract String toString();

    public String getName() {
        return name;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
// END
