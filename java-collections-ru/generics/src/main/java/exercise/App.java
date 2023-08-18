package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
class App {
    public static List findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();

        for (Map<String, String> book : books) {
            boolean isContain = true;
            for (Map.Entry<String, String> wh : where.entrySet()) {
                if (book.containsKey(wh.getKey()) && book.get(wh.getKey()) != wh.getValue()) {
                    isContain = false;
                }
            }
            if (isContain) {
                result.add(book);
            }
        }
        return result;
    }
}
//END
