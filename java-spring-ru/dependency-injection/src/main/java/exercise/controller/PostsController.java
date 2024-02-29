package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private final PostRepository postRepository;

    @Autowired
    private final CommentRepository commentRepository;

    public PostsController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @GetMapping(path = "")
    public List<Post> index() {
        return postRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Post show(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        return post;
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post){
        postRepository.save(post);
        return post;
    }

    @PutMapping(path = "/{id}")
    public Post update(@PathVariable Long id, @RequestBody Post data) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        post.setTitle(data.getTitle());
        post.setBody(data.getBody());
        postRepository.save(post);
        return post;
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        var post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
        commentRepository.deleteByPostId(id);
        postRepository.delete(post);
    }
}
// END
