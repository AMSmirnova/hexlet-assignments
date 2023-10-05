package exercise;

// BEGIN
public class ReversedSequence implements CharSequence{
    private String text;

    public ReversedSequence(String text) {
        this.text = text;
    }

//    public static String reverseString(String text) {
//        return new StringBuilder(text).reverse().toString();
//    }

    public String toString() {
        return new StringBuilder(this.text).reverse().toString();
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
        return null;
    }
}
// END
