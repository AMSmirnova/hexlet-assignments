package exercise;

import java.util.Arrays;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] arr) {
        String[][] largeArr = new String[arr.length * 2][arr.length * 2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                largeArr[i * 2][j * 2] = arr[i][j];
                largeArr[i * 2 + 1][j * 2] = arr[i][j];
                largeArr[i * 2][j * 2 + 1] = arr[i][j];
                largeArr[i * 2 + 1][j * 2 + 1] = arr[i][j];
            }
        }

        return largeArr;
    }
}
// END
