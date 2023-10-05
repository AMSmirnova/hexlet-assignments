package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List buildApartmentsList(List<Home> realties, int count) {
        return realties.stream()
                .sorted(Home::compareTo)
                .map(realty -> realty.toString())
                .limit(count)
                .collect(Collectors.toList());
    }
}
// END
