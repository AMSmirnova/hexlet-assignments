package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private String text;

    public ReversedSequence(String text) {
        this.text = new StringBuilder(text).reverse().toString();
    }

    public String toString() {
        return this.text;
    }

    @Override
    public int length() {
        return text.length();
    }

    @Override
    public char charAt(int index) {
        return this.text.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.text.subSequence(start, end);
    }
}
// END
