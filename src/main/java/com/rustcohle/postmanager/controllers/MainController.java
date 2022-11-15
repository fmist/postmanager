package com.rustcohle.postmanager.controllers;

import com.rustcohle.postmanager.models.Post;
import com.rustcohle.postmanager.repo.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin("http://localhost:3000")
public class MainController {
    private final PostRepository postRepository;

    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/posts")
    public List<Post> postsPage() {
        return postRepository.findAll(Sort.by("timeCreated").descending());
    }

    @PostMapping("/posts/add")
    public String addPost(@RequestBody Post post) {
        postRepository.save(post);
        return "Post added";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable Long id) throws Exception {
        if (!postRepository.existsById(id)) {
            throw new Exception("User not found with id=" + id);
        }
        postRepository.deleteById(id);
        return "Post with id=" + id + " deleted";
    }

    @PostMapping("/posts/deleteAll")
    public String deleteAllPosts() {
        postRepository.deleteAll();
        return "All posts deleted";
    }

    @GetMapping("/posts/{id}/edit")
    public String goToEditPage(Model model,
                               @PathVariable("id") Long id) {
        Post post = postRepository.findById(id).orElseThrow();
        post.setTitle(post.getTitle());
        post.setText(post.getText());
        model.addAttribute("post", post);
        return "editPostPage";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@ModelAttribute("post") @Valid Post post,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editPostPage";
        }
        postRepository.save(post);
        return "redirect:/posts";
    }
}
