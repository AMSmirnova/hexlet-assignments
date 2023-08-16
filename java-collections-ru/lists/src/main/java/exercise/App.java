package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String setOfLetters, String word) {
        if (setOfLetters.length() < word.length()) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }

        List<String> lettersOfWord = new ArrayList<>(Arrays.asList(word.toLowerCase().split("")));
        List<String> letters = new ArrayList<>(Arrays.asList(setOfLetters.toLowerCase().split("")));

        for (String letter : lettersOfWord) {
            if (letters.contains(letter)) {
                letters.remove(letter);
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
