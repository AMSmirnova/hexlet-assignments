package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() { // "<img class="v-10" id="wop">"
        StringBuilder result = new StringBuilder("<" + getName());
        for (Map.Entry<String, String> str : getAttributes().entrySet()) {
            result.append(" " + str.getKey() + "=\"" + str.getValue() + "\"");
        }
        result.append(">");
        return result.toString();
//        getAttributes().entrySet().stream().forEach(entry -> set(entry.getKey(), entry.getValue()));

    }
}
// END
