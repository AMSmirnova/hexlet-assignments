package exercise;

import java.util.List;


// BEGIN
class App {
    public static long getCountOfFreeEmails(List<String> emailsList) {
        long count = 0;
        if (!emailsList.isEmpty()) {
            count = emailsList.stream()
                    .filter(mail -> mail.contains("@gmail.com"))
                    .count();
            count += emailsList.stream()
                    .filter(mail -> mail.contains("@yandex.ru"))
                    .count();
            count += emailsList.stream()
                    .filter(mail -> mail.contains("@hotmail.com"))
                    .count();
        }

        return count;
    }
}
// END
