package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN

    public static void index(Context ctx) {
        var user = ctx.sessionAttribute("currentUser");
        MainPage page = new MainPage(user);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        LoginPage page = new LoginPage(null, null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        var user = UsersRepository.findByName(name);

        if (user != null && user.getPassword().equals(encrypt(password))) {
            ctx.sessionAttribute("currentUser", user.getName());
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var errorMessage = "Wrong username or password";
            var page = new LoginPage(name, errorMessage);
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
