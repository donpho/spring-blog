package com.blog.blog;

import com.blog.blog.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostService postService;

    //List<Post> posts = new ArrayList<>();

    public PostController(PostService postService){
//        posts.add(new Post("IA", "English CeVio just came out"));
//        posts.add(new Post("ONE", "English CeVio just came out"));

        this.postService = postService;
    }

    @GetMapping("/posts")
    public String postsIndex(Model viewModel){
        viewModel.addAttribute("posts", postService.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model viewModel){
        Post post = postService.findOne(id);
        viewModel.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String createPost(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/save")
    public String newPost(@ModelAttribute Post post){
        postService.save(post);
        return "redirect:/posts";
    }


}
