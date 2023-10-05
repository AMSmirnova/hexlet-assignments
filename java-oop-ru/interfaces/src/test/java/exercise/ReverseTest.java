package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseTest {

    @Test
    void testReversedSequence() {
        String expected = "fedcba";

        ReversedSequence text = new ReversedSequence("abcdef");

        assertThat(text.toString()).isEqualTo(expected);
        assertThat(text.length()).isEqualTo(6);
        assertThat(text.charAt(2)).isEqualTo('d');
        assertThat(text.subSequence(1, 4).toString()).isEqualTo("edc");
    }
}
