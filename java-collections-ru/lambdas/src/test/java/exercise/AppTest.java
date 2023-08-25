package exercise;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {

    @Test
    void testLargeArray() {
        String[][] array = {
                {"1", "1"},
                {"1", "1"}
        };
        String[][] actual1 = App.enlargeArrayImage(array);
        String[][] expected = {
                {"1", "1","1", "1"},
                {"1", "1","1", "1"},
                {"1", "1","1", "1"},
                {"1", "1","1", "1"}
        };
        assertThat(actual1).isEqualTo(expected);
    }

    @Test
    void testLargeArrayWithEmpty() {
        String[][] array = {};
        String[][] actual = App.enlargeArrayImage(array);

        String[][] expected = {};
        assertThat(actual).isEqualTo(expected);
    }
}
// END
