package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map getWordCount(String str) {
        Map<String, Integer> words = new HashMap<>();
        if (str.length() == 0) {
            return words;
        }
        String[] wordsArray = str.split(" ");
        for (String word : wordsArray) {
            if (!words.containsKey(word)) {
                words.put(word, 1);
            } else {
                words.put(word, words.get(word) + 1);
            }
        }
        return words;

    }

    public static String toString(Map<String, Integer> words) {
        if (words.isEmpty()) {
            return "{}";
        }
        String result = "{";
        for (Map.Entry<String, Integer> word: words.entrySet()) {
            result += "\n  " + word.getKey() + ": " + word.getValue();
        }
        result += "\n}";
        return result;
    }
}
//END
