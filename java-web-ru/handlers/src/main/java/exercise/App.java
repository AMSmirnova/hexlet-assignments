package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        ObjectMapper objectMapper = new ObjectMapper();
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();

        app.get("/phones", ctx -> ctx
                .result(objectMapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(phones)));
        app.get("/domains", ctx -> ctx
                .result(objectMapper
                        .writerWithDefaultPrettyPrinter()
                        .writeValueAsString(domains)));

        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
