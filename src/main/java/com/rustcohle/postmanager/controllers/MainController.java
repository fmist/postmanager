package com.rustcohle.postmanager.controllers;

import com.rustcohle.postmanager.models.Post;
import com.rustcohle.postmanager.repo.PostRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {
    private final PostRepository postRepository;

    public MainController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/")
    public String mainPage() {
        return "redirect:/posts";
    }

    @GetMapping("/posts")
    public String postsPage(Model model) {
        List<Post> posts = postRepository.findAll(Sort.by("timeCreated").descending());
        model.addAttribute("posts", posts);
        return "postsPage";
    }

    @GetMapping("/posts/add")
    public String goToCreatePost(Model model) {
        model.addAttribute("post", new Post());
        return "addPostPage";
    }

    @PostMapping("/posts/add")
    public String addPost(@ModelAttribute("post") @Valid Post post, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addPostPage";
        }
        postRepository.save(post);
        return "redirect:/posts";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return "redirect:/posts";
    }

    @PostMapping("/posts/deleteAll")
    public String deleteAllPosts() {
        postRepository.deleteAll();
        return "redirect:/posts";
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
