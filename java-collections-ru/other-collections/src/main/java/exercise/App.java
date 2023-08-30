package exercise;

import java.util.TreeMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static LinkedHashMap<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {

        Set<String> added = new HashSet<>();
        added.addAll(map2.keySet());
        added.removeAll(map1.keySet());

        Set<String> deleted = new HashSet<>();
        deleted.addAll(map1.keySet());
        deleted.removeAll(map2.keySet());

        Set<String> intersection = new HashSet<>();
        intersection.addAll(map1.keySet());
        intersection.retainAll(map2.keySet());

        Map<String, String> result = new TreeMap<>();

        result.putAll(added.stream()
                .collect(Collectors.toMap(x -> x, x -> "added")));

        result.putAll(deleted.stream()
                        .collect(Collectors.toMap(x -> x, x -> "deleted")));

        for (String a: intersection) {
            if (map1.get(a).equals(map2.get(a))) {
                result.put(a, "unchanged");
            } else {
                result.put(a, "changed");
            }
        }
        return new LinkedHashMap<>(result);
    }
}

//END
