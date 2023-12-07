package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

import exercise.model.User;
import exercise.dto.users.UsersPage;
import exercise.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/users", ctx -> {
            var term = ctx.queryParam("term");
            List<User> users;
            if (term != null) {
                users = UserRepository.getEntities().stream()
                        .filter(u -> StringUtils.startsWithIgnoreCase(u.getFirstName(), term))
                        .collect(Collectors.toList());
            } else users = UserRepository.getEntities();
            var page = new UsersPage(users, term);
            ctx.render("users/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN

        app.post("/users", ctx -> {
            var firstName = StringUtils.capitalize(ctx.formParam("firstName").toLowerCase());
            var lastName = StringUtils.capitalize(ctx.formParam("lastName").toLowerCase());
            var email = ctx.formParam("email").toLowerCase().trim();
            var password = Security.encrypt(ctx.formParam("password"));
            var passwordConfirmation = ctx.formParam("passwordConfirmation");

            var user = new User(firstName, lastName, email, password);
            UserRepository.save(user);
            ctx.redirect("/users");
        });
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
