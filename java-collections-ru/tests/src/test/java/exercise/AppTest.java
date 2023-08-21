package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        List<Integer> actual1 = App.take(numbers1, 2);
        assertThat(actual1).isEqualTo(new ArrayList<>(Arrays.asList(1, 2)));

        List<Integer> actual2 = App.take(numbers1, 6);
        assertThat(actual2).isEqualTo(new ArrayList<>(Arrays.asList(1, 2, 3, 4)));

        List<Integer> actual3 = App.take(numbers1, 0);
        assertThat(actual3).isEqualTo(new ArrayList<>());

        List<Integer> numbers2 = new ArrayList<>();

        List<Integer> actual4 = App.take(numbers2, 6);
        assertThat(actual4).isEqualTo(new ArrayList<>());

        // END
    }
}
