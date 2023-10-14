package exercise;

import java.util.Map;
import java.util.List;
//import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag{

    private final String body;
    private final List<Tag> children;

    PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("<" + getName());
        for (Map.Entry<String, String> str : getAttributes().entrySet()) {
            result.append(" " + str.getKey() + "=\"" + str.getValue() + "\"");
        }
        result.append(">" + body);

        for (Tag child : children) {
            result.append(child.toString());
        }
        result.append("</" + getName() + ">");

        return result.toString();
    }
}
// END
