package exercise.controller;


import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var postsPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);

        var allPosts = PostRepository.getEntities();
//        if (postsPage == 0) { postsPage = 1; }
//        if (postsPage == allPosts.size() % 5 + 1) { postsPage = allPosts.size() % 5; }
        var posts = allPosts.subList(postsPage * 5, postsPage * 5 + 5);
        var page = new PostsPage(posts, postsPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }


    // END
}
