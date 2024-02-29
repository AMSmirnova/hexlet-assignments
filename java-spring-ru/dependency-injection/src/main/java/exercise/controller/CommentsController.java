package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.repository.CommentRepository;

import java.util.List;

// BEGIN
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private final CommentRepository commentRepository;

    public CommentsController(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @GetMapping(path = "")
    public List<Comment> index() {
        return commentRepository.findAll();
    }

    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment) {
        commentRepository.save(comment);
        return comment;
    }

    @GetMapping(path = "/{id}")
    public Comment show(@PathVariable Long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        return comment;
    }

    @PutMapping(path = "/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment data) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        comment.setBody(data.getBody());
        commentRepository.save(comment);
        return comment;
    }

    @DeleteMapping(path = "/{id}")
    public void destroy(@PathVariable Long id) {
        var comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Comment with id " + id + " not found"));
        commentRepository.delete(comment);
    }

}
// END
