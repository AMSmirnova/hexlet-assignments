package exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
class App {
    public static String getForwardedVariables(String str) {

        List<String> values = List.of(str.split("\n"));

        values = values.stream()
                .filter(s -> s.startsWith("environment="))
                .map(s -> s.replaceAll("environment=\"", ""))
                .map(s -> s.replaceAll("\"", ""))
                .map(s -> s.split(","))
                .flatMap(element -> Stream.of(element))
                .filter(s -> s.startsWith("X_FORWARDED_"))
                .map(s -> s.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.toList());

        String result = values.toString()
                .toString()
                .replace(" ", "")
                .replace("[", "")
                .replace("]", "");

        return result;
    }
}
//END
